package br.org.spcbrasil.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.spcbrasil.prova.model.Dados;

public interface DadosRepository extends JpaRepository<Dados, Long>{


}
