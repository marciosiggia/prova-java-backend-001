package br.org.spcbrasil.prova.resources;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.org.spcbrasil.prova.model.Graph;
import br.org.spcbrasil.prova.model.Rota;
import br.org.spcbrasil.prova.repository.GraphRepository;

@RestController
@RequestMapping("/rotas")
public class RotaResource {
	
	@Autowired
	private GraphRepository repository;

	@PostMapping("/de/{origem}/para/{destino}")
	public ResponseEntity<Set<Rota>> buscarRotasDisponiveis(
			@PathVariable String origem, 
			@PathVariable String destino, 
			@RequestParam(value = "qtdMaxParadas", required = false) Integer qtdMaxParadasOrNull) {
		
		Set<Rota> lstRota = new HashSet<Rota>();
		StringBuilder sbRota = new StringBuilder();
		
		List<Graph> lstGrfOrig = repository.findByOrigem(origem);	
		List<Graph> lstGrfDest = repository.findByDestino(destino);	
		List<Graph> lstGrfParInicial = new ArrayList<Graph>();
		List<Graph> grafosPossiveis = new ArrayList<Graph>();
		AtomicInteger paradas = new AtomicInteger();
		
		if((lstGrfOrig != null && lstGrfDest != null)) {
			
			//Guarda só os destinos para fazerem pares com os grafos da lista lstGrfDest
			List<String> dest1 = new ArrayList<String>();
			lstGrfOrig.forEach(lgo -> {
				grafosPossiveis.add(new Graph(lgo.getOrigem(),lgo.getDestino()));
				dest1.add(lgo.getDestino());
			});
			
			//Gera lista de pares para busca dos grafos possíveis
			dest1.forEach(d -> {
				lstGrfDest.forEach(gd -> {
					lstGrfParInicial.add(new Graph(d,gd.getOrigem()));
					lstGrfParInicial.add(new Graph(d,gd.getDestino()));
				});
			});
			
			//Busca os grafos possíveis
			lstGrfParInicial.forEach(lgpi ->{
				grafosPossiveis.addAll(repository.findByOrigemAndDestino(lgpi.getOrigem(), lgpi.getDestino()));
			});
			
			Set<String> cidades = new LinkedHashSet<String>();
			
			lstGrfOrig.forEach(lgo ->{

				cidades.clear();
				
				Graph gtemp = new Graph();
				gtemp.setOrigem(lgo.getOrigem());
				gtemp.setDestino(lgo.getDestino());
				
				grafosPossiveis.forEach(gp ->{
					if(cidades.isEmpty()) {
						cidades.add(lgo.getOrigem());
						cidades.add(lgo.getDestino());
						paradas.incrementAndGet();
					} else {
						if(gp != null) {
							if(gtemp.getDestino().equals(gp.getOrigem())) { 
								cidades.add(gp.getDestino());
								paradas.incrementAndGet();
								gtemp.setDestino(gp.getDestino());
							}
							
						}
					}
				});
				
				if(!cidades.isEmpty()) {
					if(qtdMaxParadasOrNull != null && (paradas.intValue() <= qtdMaxParadasOrNull)) {
						cidades.forEach(sbRota::append);
						lstRota.add(new Rota(sbRota.toString(),paradas.intValue()));
					}
				}
				paradas.set(0);
			});
			
		}
		
		return new ResponseEntity<Set<Rota>>(lstRota, HttpStatus.OK);
	}
	
}
