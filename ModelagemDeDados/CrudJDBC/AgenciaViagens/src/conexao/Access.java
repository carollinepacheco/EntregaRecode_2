package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Access {

	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenciaViagens";
	private static final String USERNAME = "root";
	private static final String PASSOWRD = "goo-357s2prd$";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	public static Connection connectionFactory() {
		try {
			Class.forName(DRIVER);
			System.out.println("Conex�o com o Driver obtida! \n");
	   }catch (ClassNotFoundException e) {
		    System.out.println("Erro na conex�o com o Driver!");
	   }

		try {
			Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSOWRD); 
			System.out.println("Conex�o com Banco de dados obtida! \n");
		    return connection;      
	   }catch(SQLException e) {
		   System.out.println("Erro na conex�o com Banco de dados!");
		   return null;
	   }	
   }
}