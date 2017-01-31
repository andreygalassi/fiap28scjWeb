package br.com.fiap.entity;

import java.util.Set;

public class AlunoVO {

	private Integer Id;
	private String nome;
	private String disciplina;
	private String curso;
	private Set<Nota> notas;
	private Usuario usuario;
	
	public AlunoVO(Integer id, String nome, String disciplina, String curso, Set<Nota> notas, Usuario usuario) {
		super();
		Id = id;
		this.nome = nome;
		this.disciplina = disciplina;
		this.curso = curso;
		this.notas = notas;
		this.usuario = usuario;
	}
	
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
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Set<Nota> getNotas() {
		return notas;
	}
	public void setNotas(Set<Nota> notas) {
		this.notas = notas;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
