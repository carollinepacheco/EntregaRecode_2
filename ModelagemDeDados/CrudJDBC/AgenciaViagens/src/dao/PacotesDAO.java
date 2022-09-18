package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Pacotes;

public class PacotesDAO {
	private static String sql;
	private Connection connection;

	public PacotesDAO(Connection connection) {
		this.connection = connection;
	}

	public void cadastrarPacotes(Pacotes pacotes) {
		sql = "INSERT INTO  pacotesViagens VALUES (null, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, pacotes.getDestino());
			stmt.setString(2, pacotes.getHospedagem());
			stmt.setString(3, pacotes.getDiarias());
			stmt.setDouble(4, pacotes.getPreco());

			int result = stmt.executeUpdate();
			System.out.printf("Pacote salvo com sucesso! Result: %s ", result);

		} catch (SQLException e) {
			System.out.printf("Erro ao inserir pacote!", e.getMessage());
		}
	}

	public List<Pacotes> listarPacotes(Scanner scanner) {

	        sql = "SELECT * FROM pacotesViagens";
	        try {
	            Statement stmt = this.connection.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);
	            List<Pacotes> pacote = new ArrayList<>();
  
	            while (rs.next()) {
	            	Pacotes pacotes = new Pacotes();
	                pacotes.setId(rs.getInt(1));
	                pacotes.setDestino(rs.getString(2));
	                pacotes.setHospedagem(rs.getString(3));
	                pacotes.setDiarias(rs.getString(4));
	                pacotes.setPreco(rs.getDouble(5));
	                pacote.add(pacotes);
	            }
	            System.out.println("Lista dos Pacotes de Viagens!");
	            return pacote;

	        } catch (SQLException e) {
	            System.out.printf("Erro ao consultar lista de Pacotes Message: %s", e.getMessage());
	            return null;
	        }
	 }

	
	public void editarPacotes(Pacotes pacotes) {
		sql = "UPDATE pacotesViagens SET destino = ?, hospedagem = ?, diarias = ?, preco = ? WHERE id = ?";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, pacotes.getDestino());
			stmt.setString(2, pacotes.getHospedagem());
			stmt.setString(3, pacotes.getDiarias());
			stmt.setDouble(4, pacotes.getPreco());
			stmt.setInt(5, pacotes.getId());

			stmt.executeUpdate();
			System.out.println("Pacote atualizado com sucesso! ");

		} catch (SQLException e) {
			System.out.printf("Erro ao atualizar pacote! Message: %s", e.getMessage());
		}
	}

	public void deletarPacotes(long Id) {
		sql = "DELETE FROM pacotesViagens WHERE id = ?";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, Id);
			stmt.executeUpdate();
			System.out.println("Pacote deletado com sucesso!.");
		} catch (SQLException e) {
			System.out.printf("Erro ao deletar pacote! Message: %s", e.getMessage());
		}
	}

}
