package br.org.spcbrasil.prova.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.spcbrasil.prova.model.Dados;
import br.org.spcbrasil.prova.model.Graph;
import br.org.spcbrasil.prova.repository.DadosRepository;
import br.org.spcbrasil.prova.repository.GraphRepository;

@RestController
@RequestMapping("/grafo")
public class GraphResource {

	@Autowired
	private GraphRepository repository;

	@Autowired
	private DadosRepository dadosRepository;

	@PostMapping
	public ResponseEntity<Object> salvar(@RequestBody Graph grafo) {
		repository.save(grafo);
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}

	@PostMapping("/salvarDados")
	public ResponseEntity<Object> salvarDados(@RequestBody Dados dados) {
		dadosRepository.save(dados);
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Dados> buscarPorId(@PathVariable Long id) {
		Dados retorno = dadosRepository.findOne(id);

		if (retorno == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(retorno);
	}

}
