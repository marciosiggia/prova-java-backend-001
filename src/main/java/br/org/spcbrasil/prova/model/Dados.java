package br.org.spcbrasil.prova.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="Dados")
public class Dados implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1888324575593500065L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idDados ;
	
	@OneToMany(mappedBy = "dado", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Graph> dados;

	public Dados() {
		super();
	}

	@Override
	public String toString() {
		return "Dados [dados=" + dados + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dados == null) ? 0 : dados.hashCode());
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
		Dados other = (Dados) obj;
		if (dados == null) {
			if (other.dados != null)
				return false;
		} else if (!dados.equals(other.dados))
			return false;
		return true;
	}


	public Set<Graph> getDados() {
		return dados;
	}

	public void setDados(Set<Graph> dados) {
		this.dados = dados;
	}

	
}
