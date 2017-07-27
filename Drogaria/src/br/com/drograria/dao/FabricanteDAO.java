package br.com.drograria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import br.com.drograria.domain.Fabricante;
import br.com.drograria.factory.ConexaoFactory;

public class FabricanteDAO {

	public void salvar(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fabricante ");
		sql.append("(descricao) ");
		sql.append("VALUES(?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDecricao());

		comando.executeUpdate();
	}

	public void excluir(Fabricante f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fabricante ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());

		comando.executeUpdate();

	}

	public void editar(Fabricante f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fabricante ");
		sql.append("SET descricao = ? ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDecricao());
		comando.setLong(2, f.getCodigo());

		comando.executeUpdate();

	}

	public Fabricante buscarPorCodigo(Fabricante f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fabricante ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());

		ResultSet resultado = comando.executeQuery();

		Fabricante retorno = null;

		if (resultado.next()) {
			retorno = new Fabricante();
			retorno.setCodigo(resultado.getLong("codigo"));
			retorno.setDescricao(resultado.getString("descricao"));
		}

		return retorno;

	}

	public ArrayList<Fabricante> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fabricante ");
		sql.append("ORDER BY descricao DESC");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Fabricante> lista = new ArrayList<Fabricante>();

		while (resultado.next()) {
			Fabricante f = new Fabricante();
			f.setCodigo(resultado.getLong("codigo"));
			f.setDescricao(resultado.getString("descricao"));
			lista.add(f);
		}

		return lista;

	}

	public ArrayList<Fabricante> buscarPorDescricao(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fabricante ");
		sql.append("WHERE descricao LIKE ? ");
		sql.append("ORDER BY descricao ASC");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, "%" + f.getDecricao() + "%");

		ResultSet resultado = comando.executeQuery();

		ArrayList<Fabricante> lista = new ArrayList<>();

		while (resultado.next()) {
			Fabricante item = new Fabricante();
			item.setCodigo(resultado.getLong("codigo"));
			item.setDescricao(resultado.getString("descricao"));
			lista.add(item);
		}

		return lista;

	}

	public static void main(String[] args) {

		/*
		 * Fabricante f1 = new Fabricante(); f1.setDecricao("Descrição 06");
		 * 
		 * Fabricante f2 = new Fabricante(); f2.setDecricao("Descrição 07");
		 * 
		 * FabricanteDAO fDAO = new FabricanteDAO();
		 * 
		 * try { fDAO.salvar(f1); fDAO.salvar(f2);
		 * System.out.println("Dados salvos com sucesso!"); } catch (SQLException e) {
		 * System.out.println("Não foi possível salvar."); e.printStackTrace(); }
		 */

		/*
		 * Fabricante f1 = new Fabricante(); f1.setCodigo(2L); Fabricante f2 = new
		 * Fabricante(); f2.setCodigo(1L);
		 * 
		 * FabricanteDAO fDAO = new FabricanteDAO();
		 * 
		 * try { fDAO.excluir(f1); fDAO.excluir(f2);
		 * System.out.println("Dados excluídos com sucesso!"); } catch (SQLException e)
		 * { System.out.println("Não foi possível excluir."); e.printStackTrace(); }
		 */

		/*
		 * Fabricante f1 = new Fabricante(); f1.setDecricao("Fercar"); f1.setCodigo(3L);
		 * Fabricante f2 = new Fabricante(); f2.setDecricao("Ferlig"); f2.setCodigo(4L);
		 * 
		 * FabricanteDAO fDAO = new FabricanteDAO(); try { fDAO.editar(f1);
		 * fDAO.editar(f2); System.out.println("Dados editados com sucesos!"); } catch
		 * (SQLException e) { System.out.println("Não foi possível editar.");
		 * e.printStackTrace(); }
		 */

		/*
		 * Fabricante f1 = new Fabricante(); f1.setCodigo(4L);
		 * 
		 * Fabricante f2 = new Fabricante(); f2.setCodigo(5L);
		 * 
		 * FabricanteDAO fDAO = new FabricanteDAO(); try { Fabricante f3 =
		 * fDAO.buscarPorCodigo(f1); Fabricante f4 = fDAO.buscarPorCodigo(f2);
		 * System.out.println("Resultado 1: " + f3); System.out.println("Resultado 2: "
		 * + f4); } catch (SQLException e) {
		 * System.out.println("Erro ao realizar a pesquisa."); e.printStackTrace(); }
		 */

		/*
		 * FabricanteDAO fDAO = new FabricanteDAO();
		 * 
		 * try { ArrayList<Fabricante> lista = fDAO.listar();
		 * 
		 * for(Fabricante f : lista) { System.out.println("Resultado: " + f); }
		 * 
		 * } catch (SQLException e) { System.out.println("Erro ao listar fabricantes.");
		 * e.printStackTrace(); }
		 */
		
		Fabricante f1 = new Fabricante();
		f1.setDescricao("D");
		
		FabricanteDAO fDAO = new FabricanteDAO();
		
		try {
			ArrayList<Fabricante> fabricantes = fDAO.buscarPorDescricao(f1);
			for(Fabricante f : fabricantes) {
				System.out.println("Resultado: " + f);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar por fabricantes.");
			e.printStackTrace();
		}
		
		

	} // Fim do main

} // Fim da classe
