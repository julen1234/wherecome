package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Manager {
	
	
	public void registrarRefugiadoAdmin(String nombre, String apellido,Connection con) throws SQLException
	{
		PreparedStatement stmt = con.prepareStatement("INSERT INTO refugiados (nombre,apellido) VALUES(?,?)",Statement.RETURN_GENERATED_KEYS);
		
		stmt.setString(1, nombre);
		stmt.setString(2, apellido);
		
		stmt.executeUpdate();
		
	}
	


}
