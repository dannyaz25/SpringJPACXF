<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--import DataBaseHelper-->
<%@ page import="com.sistemacomercial.DataBaseHelper"%>
	
<%
//1
String codigo = request.getParameter("codigo");
String descripcion = request.getParameter("descripcion");
String marca = request.getParameter("marca");
String consultaSQL="insert into productos(codigo,descripcion,marca) values ";
consultaSQL+="('"+ codigo+ "','"+ descripcion+ "','"+ marca+ "')";
DataBaseHelper db=new DataBaseHelper();
int filas=db.editarRegistro(consultaSQL);
  response.sendRedirect("MostrarProductos.jsp");
%>