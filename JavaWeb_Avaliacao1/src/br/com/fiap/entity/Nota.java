package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nota")
public class Nota implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer Id;
	
	private float projeto1;
	
	private float atividadePratica;
	
	private float projeto2;

	public float getProjeto1() {
		return projeto1;
	}

	public void setProjeto1(float projeto1) {
		this.projeto1 = projeto1;
	}

	public float getAtividadePratica() {
		return atividadePratica;
	}

	public void setAtividadePratica(float atividadePratica) {
		this.atividadePratica = atividadePratica;
	}

	public float getProjeto2() {
		return projeto2;
	}

	public void setProjeto2(float projeto2) {
		this.projeto2 = projeto2;
	}

}
