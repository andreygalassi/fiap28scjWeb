package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

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

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Disciplina disciplina;

	@ManyToOne(fetch = FetchType.LAZY)
	private Aluno aluno;

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

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	@Transient
	public String getStatus(){
		double p1 = getProjeto1() * 0.3;
		double ap = getAtividadePratica() * 0.3;
		double p2 = getProjeto2() * 0.4;

		double notaFinal = p1 + ap + p2;

		String status = notaFinal >= 7.0 ? "aprovado" : "reprovado";
		return status;
	}

}
