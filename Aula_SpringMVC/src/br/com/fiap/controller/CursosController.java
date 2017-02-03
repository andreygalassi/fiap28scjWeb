package br.com.fiap.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fiap.dao.jdbc.JdbcCursosDao;
import br.com.fiap.dao.jdbc.JdbcEscolasDao;
import br.com.fiap.entidades.Curso;

@Controller
public class CursosController {
	@RequestMapping("/curso/cadastro")
	public String incluir(ModelMap model) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beanJdbc.xml");
		JdbcEscolasDao dao_e = (JdbcEscolasDao) ctx.getBean("jdbcEscolasDAO");
		try {
			model.addAttribute("escolas", dao_e.listarEscolas());
			return "cadastros/incluirCurso";
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
	}

	@RequestMapping(value = "/cadcurso", method = RequestMethod.POST)
	public String incluir(@RequestParam("idc") int idc, Curso curso, ModelMap model) {
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("beanJdbc.xml");
			JdbcEscolasDao dao_e = (JdbcEscolasDao) ctx.getBean("jdbcEscolasDAO");
			curso.setEscola(dao_e.buscarEscola(idc));
			JdbcCursosDao dao = (JdbcCursosDao) ctx.getBean("jdbcCursosDAO");
			dao.incluirCurso(curso);
			model.addAttribute("msg", "Escola " + curso.getDescricao() + "incluída");
			return "menu";
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
	}
	
	@RequestMapping(value = "/curso/listar", method = RequestMethod.GET)
	public String listar(ModelMap model) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beanJdbc.xml");
		JdbcEscolasDao dao_e = (JdbcEscolasDao) ctx.getBean("jdbcEscolasDAO");
		try {
			model.addAttribute("escolas", dao_e.listarEscolas());
			return "listas/listaCurso";
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
	}

	@RequestMapping(value = "/curso/listar", method = RequestMethod.POST)
	public String listar(@RequestParam("idc") int idc, Curso curso, ModelMap model) {
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("beanJdbc.xml");
			
			JdbcEscolasDao dao_e = (JdbcEscolasDao) ctx.getBean("jdbcEscolasDAO");
			model.addAttribute("escolas", dao_e.listarEscolas());
			
			JdbcCursosDao dao = (JdbcCursosDao) ctx.getBean("jdbcCursosDAO");
			List<Curso> listarCurso = dao.listarCurso(idc);
			model.addAttribute("cursos", listarCurso);
			return "listas/listaCurso";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
	}
}