package br.com.fiap.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.fiap.dao.GenericDao;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer Id;
	
	private String nome;

	@ManyToMany(mappedBy="alunos")
	private Set<Disciplina> disciplinas;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	private Curso curso;

	@OneToMany(mappedBy="aluno", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Nota> notas;

	@OneToOne(cascade={CascadeType.MERGE,CascadeType.PERSIST}, fetch=FetchType.LAZY)
	private Usuario usuario;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Aluno> getListaAlunos(){
		GenericDao<Aluno> dao = new GenericDao<>(Aluno.class);
		return dao.listar();
	}

//	public Nota getNota() {
//		return nota;
//	}
//
//	public void setNota(Nota nota) {
//		this.nota = nota;
//	}

	public Set<Nota> getNotas() {
		return notas;
	}

	public void setNotas(Set<Nota> notas) {
		this.notas = notas;
	}

	public void addNotas(Nota nota) {
		if (notas==null){
			notas = new HashSet<>();
		}
		this.notas.add(nota);
	}
	
	

}
