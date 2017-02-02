package br.com.fiap.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import br.com.fiap.entidades.Escola;

public class EscolaMapper implements RowMapper<Escola> {
	@Override
	public Escola mapRow(ResultSet rs, int arg1) throws SQLException {
		Escola escola = new Escola();
		escola.setId(rs.getInt("ID"));
		escola.setDescricao(rs.getString("DESCRICAO"));
		escola.setEndereco(rs.getString("ENDERECO"));
		escola.setDataFundacao(rs.getDate("DATAFUNDACAO"));
		return escola;
	}
}