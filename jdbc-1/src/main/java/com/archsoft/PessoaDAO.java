package com.archsoft;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PessoaDAO implements AutoCloseable {

	private Connection connection;
	
	private PreparedStatement pInsert;
	private PreparedStatement pUpdate;
	private PreparedStatement pDelete;
	private PreparedStatement pRead;

	public PessoaDAO(Connection connection) {
		this.connection = connection;
	}

	public void close() throws Exception {
		close(pInsert);
		close(pUpdate);
		close(pRead);
		close(pDelete);
		close(connection);
	}

	private void close(Connection connection) {
		Optional.ofNullable(connection).ifPresent(c -> {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
	}

	private void close(Statement statement) {
		Optional.ofNullable(statement).ifPresent(s -> {
			try {
				s.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
	}

	private void close(ResultSet resultSet) {
		Optional.ofNullable(resultSet).ifPresent(r -> {
			try {
				r.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
	}



	public void create(Pessoa pessoa) throws SQLException {
		PreparedStatement p = getPInsert();

		p.setString(1, pessoa.getCpf());
		p.setString(2, pessoa.getNome());
		p.setInt(3, pessoa.getIdade());

		p.executeUpdate();
	}
	
	private PreparedStatement getPInsert() throws SQLException {
		if (pInsert == null) {
			pInsert = connection.prepareStatement(
					PessoaSQL.INSERT.sql()
			);
		}
		
		return pInsert;
	}

	public void delete(String cpf) throws SQLException {
		PreparedStatement p = getPDelete();

		p.setString(1, cpf);

		p.executeUpdate();
	}

	private PreparedStatement getPDelete() throws SQLException {
		if (pDelete == null) {
			pDelete = connection.prepareStatement(
					PessoaSQL.DELETE.sql()
			);
		}

		return pDelete;
	}

	public void update(Pessoa pessoa) throws SQLException {
		PreparedStatement p = getPUpdate();

		p.setString(1, pessoa.getNome());
		p.setInt(2, pessoa.getIdade());
		p.setString(3, pessoa.getCpf());

		p.executeUpdate();
	}

	private PreparedStatement getPUpdate() throws SQLException {
		if (pUpdate == null) {
			pUpdate = connection.prepareStatement(
					PessoaSQL.UPDATE.sql()
			);
		}

		return pUpdate;
	}
	
	public Pessoa read(String cpf)
			throws SQLException {
		PreparedStatement stm = null;
		ResultSet rs = null;

		try {
			stm = getPRead();
			
			stm.setString(1, cpf);
			
			rs = stm.executeQuery();

			Pessoa p = null;
			
			if (rs.next()) {
				p = new Pessoa();

				p.setCpf(rs.getString("cpf"));
				p.setNome(rs.getString("nome"));
				p.setIdade(rs.getInt("idade"));
			}

			return p;
		} finally {
			close(rs);
		}
	}

	private PreparedStatement getPRead() throws SQLException {
		if (pRead == null) {
			pRead = connection.prepareStatement(
					PessoaSQL.READ.sql()
			);
		}

		return pRead;
	}

	public List<Pessoa> listar() throws SQLException {
		Statement stm = null;
		ResultSet rs = null;

		try {
			stm = connection.createStatement();
			rs = stm.executeQuery(PessoaSQL.LIST.sql());

			List<Pessoa> list = new ArrayList<Pessoa>();

			while (rs.next()) {
				Pessoa p = new Pessoa();

				p.setCpf(rs.getString("CPF"));
				p.setNome(rs.getString("NOME"));
				p.setIdade(rs.getInt("IDADE"));

				list.add(p);
			}

			return list;
		} finally {
			close(rs);
			close(stm);
		}
	}

	public void create(List<Pessoa> pessoas)
			throws SQLException {
		for (Pessoa p: pessoas) {
			create(p);
		}
	}
}
