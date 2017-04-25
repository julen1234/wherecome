package negocio;
import java.sql.Connection;
import java.sql.DriverManager;



public class Conexion {
	
	private Connection con=null;
	

	public Connection getconexionMYSQL(String user, String nombre_base,String host,String password)
	{
		
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance( );
            String servidor = "jdbc:mysql://"+host+"/"+nombre_base;
            con = DriverManager.getConnection(servidor,user,password);
            return con;
            
        }catch(Exception e){
            e.printStackTrace();
            return con;
        }

		
	}
}
	


