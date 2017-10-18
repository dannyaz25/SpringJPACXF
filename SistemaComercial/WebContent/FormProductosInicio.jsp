<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.sistemacomercial.Producto" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario Productos</title>
<script type="text/javascript">
function validacion(){
	var codigo=document.getElementById("codigo");
	var form=document.getElementById("formularioProducto");
	
	if(codigo.value=="")
		{
		alert("Ingrese un código");
		return false;
		}
	else
		form.submit();
}
</script>
</head>
<body>
<h1>Gestion de Productos</h1>
<form id="formularioProducto">
Codigo:
<input id="codigo" type="text" name="codigo"><br>
Descripcion
<input id="descripcion" type="text" name="descripcion"><br>
Marca
<select name="comboMarca">
<option value="0">seleccionar</option>
<%

	
		List<String> listaCategorias=null;
		listaCategorias=Producto.buscarTodosMarcas();
		for(String categoria:listaCategorias) { %>
		

	<option value="<%=categoria%>"><%=categoria%></option>	

		<% 
		}
%>
</select>
<input type="button" value="Insertar" onclick="validacion()">
</form>
</body>
</html>