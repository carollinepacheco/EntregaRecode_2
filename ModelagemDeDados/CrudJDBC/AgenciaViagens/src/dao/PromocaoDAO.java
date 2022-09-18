package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Promocao;

public class PromocaoDAO {
	private static String sql;
	private Connection connection;

	public PromocaoDAO(Connection connection) {
		this.connection = connection;
	}

	public void cadastrarPromocao(Promocao promocao) {
		sql = "INSERT INTO promocao VALUES (null, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, promocao.getNomePromocao());
			stmt.setString(2, promocao.getTipoPromocao());
			stmt.setDouble(3, promocao.getDesconto());
			stmt.setInt(4, promocao.getFk_pacotesViagens_id());

			int result = stmt.executeUpdate();
			System.out.printf("Promoção cadastrada com sucesso! Result: %s ", result);

		} catch (SQLException e) {
			System.out.printf("Erro ao cadastrar promoção!", e.getMessage());
		}
	}

	public List<Promocao> listarPromocao(Scanner scanner) {

	        sql = "SELECT * FROM promocao";
	        try {
	            Statement stmt = this.connection.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);
	            List<Promocao> promocao = new ArrayList<>();
  
	            while (rs.next()) {
	            	Promocao promo = new Promocao();
	                promo.setId(rs.getInt(1));
	                promo.setNomePromocao(rs.getString(2));
	                promo.setTipoPromocao(rs.getString(3));
	                promo.setDesconto(rs.getDouble(4));
	                promo.setFk_pacotesViagens_id(rs.getInt(5));
	                promocao.add(promo);
	            }
	            System.out.println("Lista de Promoções!");
	            return promocao;

	        } catch (SQLException e) {
	            System.out.printf("Erro ao consultar lista de Promoções Message: %s", e.getMessage());
	            return null;
	        }
	 }

	
	public void editarPromocao(Promocao promocao) {
		sql = "UPDATE promocao SET nomePromocao = ?, tipoPromocao = ?, desconto = ?, fk_pacoteViagens_id = ? WHERE id = ?";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, promocao.getNomePromocao());
			stmt.setString(2, promocao.getTipoPromocao());
			stmt.setDouble(3, promocao.getDesconto());
			stmt.setInt(4, promocao.getFk_pacotesViagens_id());
			stmt.setInt(5, promocao.getId());

			stmt.executeUpdate();
			System.out.println("Promocao atualizada com sucesso! ");

		} catch (SQLException e) {
			System.out.printf("Erro ao atualizar promocao! Message: %s", e.getMessage());
		}
	}

	public void deletarPromocao(long Id) {
		sql = "DELETE FROM promocao WHERE id = ?";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, Id);
			stmt.executeUpdate();
			System.out.println("Promocao deletada com sucesso!.");
		} catch (SQLException e) {
			System.out.printf("Erro ao deletar promocao! Message: %s", e.getMessage());
		}
	}


}
