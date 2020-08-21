package br.org.spcbrasil.prova.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Graph")
public class Graph implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7975078108754177136L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String origem;

	private String destino;

	private Integer distancia;

	@ManyToOne
	@JoinColumn(name = "idDados", insertable = false, updatable = false)
	@JsonBackReference
	private Dados dado;
	
	public Graph() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Graph(String origem, String destino, Integer distancia) {
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
	}
	
	public Graph(String origem, String destino) {
		super();
		this.origem = origem;
		this.destino = destino;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	@Override
	public String toString() {
		return "Grafo: [origem=" + origem + ", destino=" + destino + ", distancia=" + distancia + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime * result + ((distancia == null) ? 0 : distancia.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((origem == null) ? 0 : origem.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Graph other = (Graph) obj;
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
			return false;
		if (distancia == null) {
			if (other.distancia != null)
				return false;
		} else if (!distancia.equals(other.distancia))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (origem == null) {
			if (other.origem != null)
				return false;
		} else if (!origem.equals(other.origem))
			return false;
		return true;
	}

	public Dados getDado() {
		return dado;
	}

	public void setDado(Dados dado) {
		this.dado = dado;
	}

}
