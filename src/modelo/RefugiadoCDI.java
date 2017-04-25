package modelo;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import datos.Refugiado;
import negocio.Conexion;
import negocio.Manager;

@Named
@RequestScoped
public class RefugiadoCDI implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Refugiado entity=new Refugiado();
	

	public Refugiado getEntity() {
		return entity;
	}

	public void setEntity(Refugiado entity) {
		this.entity = entity;
		System.err.println("*---REFUGIADOCDI SET ENTITY-------------------------");
	}
	public void guardar() throws SQLException
	{
		Manager manager=new Manager();
		Conexion conexion= new Conexion();
		Connection con= conexion.getconexionMYSQL("endika", "prueba", "localhost", "");
		
		manager.registrarRefugiadoAdmin(this.getEntity().getNombre(), this.getEntity().getApellido(), con);
	}
	


}
