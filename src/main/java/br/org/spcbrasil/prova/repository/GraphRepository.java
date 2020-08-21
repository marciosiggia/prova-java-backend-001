package br.org.spcbrasil.prova.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.spcbrasil.prova.model.Graph;

public interface GraphRepository extends JpaRepository<Graph, Long>{

	List<Graph> findByOrigemAndDestino(String origem, String destino);
	
	List<Graph> findByOrigem(String origem);

	List<Graph> findByDestino(String destino);

}
