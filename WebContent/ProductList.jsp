<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*, com.mvc.prducts.*" %>


<html>
<head>
<meta charset="UTF-8">
<title>Listado de Productos</title>
<style type="text/css">
	.cabecera{ 
		border-bottom: solid black 1px;
}
</style>
</head>

<%
// Obtiene los productos del controlador
List<Products> losProductos=(List<Products>) request.getAttribute("PRODUCTLIST");
	
%>
<body>

<!--<%= losProductos %> -->

<table>
<tr>
	<td class="cabecera">Product Id</td>
	<td class="cabecera">Name</td>
	<td class="cabecera">Stock</td>
	<td class="cabecera">Price</td>
	
</tr>

	<% for(Products tempProd : losProductos) { %>
		<tr>
		
			<td><%= tempProd.getId() %></td>
			<td><%= tempProd.getName() %></td>
			<td><%= tempProd.getQuantity() %></td>
			<td><%= tempProd.getUnitPrice() %></td>
			
		
		</tr>
		
		<% } %>
</table>



</body>
</html>