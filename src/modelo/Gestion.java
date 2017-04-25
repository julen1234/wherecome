package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import datos.BeanUserBD;
import negocio.Conexion;




public class Gestion {

	public static void main(String[] args) {
		
// ESTABLECIMIENTO CONEXIÓN CON BD
		Scanner scanner = new Scanner(System.in);
		BeanUserBD datos= new BeanUserBD();
		System.out.println("USUARIO\n");
		datos.setUser(scanner.nextLine());
		System.out.println("PASS\n");
		datos.setPassword(scanner.nextLine());
		System.out.println("HOSTNAME\n");
		datos.setHost(scanner.nextLine());
		System.out.println("BD NAME\n");
		datos.setNombreBase(scanner.nextLine());
		scanner.close();
		
		Conexion conexion=new Conexion();
		Connection con=conexion.getconexionMYSQL(datos.getUser(), datos.getNombreBase(),datos.getHost(),datos.getPassword());
		
		if(con==null)
		{
			System.err.println("******IMPOSIBLE CONECTAR CON LA BASE DE DATOS******");
		}
		else
		{
			try {
				System.out.println("CONEXIÓN ESTABLECIDA CON BD");
				
				PreparedStatement stmt = con.prepareStatement("INSERT INTO refugiados (nombre,apellido) VALUES(?,?)",Statement.RETURN_GENERATED_KEYS);
								
				stmt.setString(1, "perico");
				stmt.setString(2, "maloso");
				
				stmt.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
