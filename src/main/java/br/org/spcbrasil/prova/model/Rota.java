package br.org.spcbrasil.prova.model;

import java.io.Serializable;

public class Rota implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3214169037888026782L;

	private String  rota;
	
	private Integer paradas;

	public Rota() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rota(String rota, Integer paradas) {
		super();
		this.rota = rota;
		this.paradas = paradas;
	}

	public String getRota() {
		return rota;
	}

	public void setRota(String rota) {
		this.rota = rota;
	}

	public Integer getParadas() {
		return paradas;
	}

	public void setParadas(Integer paradas) {
		this.paradas = paradas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paradas == null) ? 0 : paradas.hashCode());
		result = prime * result + ((rota == null) ? 0 : rota.hashCode());
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
		Rota other = (Rota) obj;
		if (paradas == null) {
			if (other.paradas != null)
				return false;
		} else if (!paradas.equals(other.paradas))
			return false;
		if (rota == null) {
			if (other.rota != null)
				return false;
		} else if (!rota.equals(other.rota))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rota [rota=" + rota + ", paradas=" + paradas + "]";
	}
	
	
}
