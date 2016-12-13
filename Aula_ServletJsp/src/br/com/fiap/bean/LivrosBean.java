package br.com.fiap.bean;

import java.util.List;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Livro;

public class LivrosBean {

	public List<Livro> getListaLivros(){
		GenericDao<Livro> dao = new GenericDao<>(Livro.class);
		return dao.listar();
	}
}
