package br.com.fiap.dao.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import br.com.fiap.entidades.Curso;
import br.com.fiap.entidades.Escola;

public class JdbcCursosDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void incluirCurso(Curso curso) throws Exception {
		try {
			String query = "INSERT INTO CURSOS (ID,IDESCOLA,DESCRICAO) VALUES (?,?,?)";
			jdbcTemplate.update(query, curso.getId(), curso.getEscola().getId(), curso.getDescricao());
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Curso> listarCurso(Integer escolaId) throws Exception {
		List<Curso> cursos = new ArrayList<>();
		try {
			cursos = jdbcTemplate.query("SELECT * FROM CURSOS where IDESCOLA="+escolaId, new CursoMapper());
		} catch (Exception e) {
			throw e;
		}
		return cursos;
	}
}