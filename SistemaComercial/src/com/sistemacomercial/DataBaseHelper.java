package com.sistemacomercial;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DataBaseHelper<T> {

	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost/hablemosdejava";
	private static final String USUARIO="root";
	private static final String CLAVE="123456";
	
	public int editarRegistro(String sql){
		
		Connection conexion = null;
		Statement sentencia = null;
		int filas=0;
		try{
		Class.forName(DRIVER);
		conexion = DriverManager.getConnection(
		URL,
		USUARIO,
		CLAVE);
		sentencia = conexion.createStatement();
		filas=sentencia.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			System.out.println("Error en la carga del driver"
			+ e.getMessage());
			} catch (SQLException e) {
			System.out.println("Error accediendo a la base de datos"
			+ e.getMessage());
			} finally {
			//5
			if (sentencia != null) {
			try {sentencia.close();}
			catch (SQLException e)
			{System.out.println("Error cerrando la sentencia" +
			e.getMessage());}
			}
			if (conexion != null) {
			try {conexion.close();}
			catch (SQLException e)
			{System.out.println("Error cerrando la conexion" +
			e.getMessage());}
			}
			
			}
			
		return filas;
		
	}
	public List<T> seleccionarRegistros(String sql,Class clase){
		Connection conexion = null;
		Statement sentencia = null;
		ResultSet filas=null;
		List<T> listaObj=new ArrayList<T>();
		try{
		Class.forName(DRIVER);
		conexion = DriverManager.getConnection(
		URL,
		USUARIO,
		CLAVE);
		sentencia = conexion.createStatement();
		filas=sentencia.executeQuery(sql);	
		
		while(filas.next()){
			T objecto=(T)Class.forName(clase.getName()).newInstance();
			Method[] metodos=objecto.getClass().getDeclaredMethods();
			for(int i=0;i<metodos.length;i++)
			{
				if(objecto.getClass().getName().equals("java.lang.String")){
					objecto=(T) filas.getString(1);
				}
				if(metodos[i].getName().startsWith("set")){
					metodos[i].invoke(objecto,filas.getString(metodos[i].getName().substring(3)));
				}
			}
			listaObj.add(objecto);
		}
		
		} catch (ClassNotFoundException e) {
			System.out.println("Error en la carga del driver"
					+ e.getMessage());
		}catch(SQLException e){
			System.out.println("Error accediendo a la base de datos"
					+ e.getMessage());
		}catch(Exception e){
			System.out.println("Error al seleccionar registro"+ e.getMessage());
		}
		return listaObj;
		
	}
}
