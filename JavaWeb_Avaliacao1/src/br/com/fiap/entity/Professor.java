package br.com.fiap.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.fiap.dao.GenericDao;

@Entity
@Table(name = "professor")
public class Professor implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer Id;

	private String nome;

	@OneToMany(mappedBy = "professor", fetch = FetchType.EAGER)
	private Set<Disciplina> disciplinas;

	@OneToOne(cascade={CascadeType.MERGE,CascadeType.PERSIST}, fetch=FetchType.LAZY)
	private Usuario usuario;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private Set<Escola> escolas;

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

	public Set<Escola> getEscolas() {
		return escolas;
	}

	public void setEscolas(Set<Escola> escolas) {
		this.escolas = escolas;
	}

	public List<Professor> getListaProfessores() {
		GenericDao<Professor> dao = new GenericDao<>(Professor.class);
		return dao.listar();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}