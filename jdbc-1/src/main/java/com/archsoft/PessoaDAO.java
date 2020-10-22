package com.archsoft;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

	private Connection connection;
	
	private PreparedStatement pInsert;
	private PreparedStatement pUpdate;
	private PreparedStatement pDelete;
	private PreparedStatement pRead;

	public PessoaDAO(Connection connection) {
		this.connection = connection;
	}

	public void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// Ignore
			}
		}
	}

	public void create(Pessoa pessoa) throws SQLException {
		PreparedStatement p = null;

		try {
			p = getPInsert();

			p.setString(1, pessoa.getCpf());
			p.setString(2, pessoa.getNome());
			p.setInt(3, pessoa.getIdade());

			p.executeUpdate();
		} finally {
			if (p != null) {
				try {
					p.close();
				} catch (SQLException e) {
					// Ignore
				}
			}
		}
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
		PreparedStatement p = null;

		try {
			p = connection.prepareStatement(PessoaSQL.DELETE.sql());

			p.setString(1, cpf);

			p.executeUpdate();
		} finally {
			if (p != null) {
				try {
					p.close();
				} catch (SQLException e) {
					// Ignore
				}
			}
		}
	}

	public void update(Pessoa pessoa) throws SQLException {
		PreparedStatement p = null;

		try {
			p = connection.prepareStatement(
					PessoaSQL.UPDATE.sql());

			p.setString(1, pessoa.getNome());
			p.setInt(2, pessoa.getIdade());
			p.setString(3, pessoa.getCpf());

			p.executeUpdate();
		} finally {
			if (p != null) {
				try {
					p.close();
				} catch (SQLException e) {
					// Ignore
				}
			}
		}
	}
	
	public Pessoa read(String cpf)
			throws SQLException {
		PreparedStatement stm = null;
		ResultSet rs = null;

		try {
			stm = connection.prepareStatement(
				PessoaSQL.READ.sql()
			);
			
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
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// Ignore
				}
			}

			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					// Ignore
				}
			}
		}
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
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// Ignore
				}
			}

			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					// Ignore
				}
			}
		}
	}

	public void create(List<Pessoa> pessoas)
			throws SQLException {
		for (Pessoa p: pessoas) {
			create(p);
		}
	}
}
