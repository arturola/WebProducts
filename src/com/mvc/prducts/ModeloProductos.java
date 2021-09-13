package com.mvc.prducts;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ModeloProductos {
	
	private DataSource origenDatos;
	
	public ModeloProductos(DataSource origenDatos) {
		this.origenDatos = origenDatos;
	}


	public List<Products> getProducts() throws Exception {
		
		List<Products> products=new ArrayList<>();
		
		Connection miConexion=null;
		Statement miStatement=null;
		ResultSet miResultSet=null;
		
		
		// Establecer Conexion
		miConexion = origenDatos.getConnection();
		
		// Crear sentencia sql
		String instruccionSql = "SELECT * FROM products";
		
		miStatement= miConexion.createStatement();
		
		// Ejecutar la sentencia
		miResultSet=miStatement.executeQuery(instruccionSql);
		
		// Recorrer el ResultSet obtenido
		while(miResultSet.next()) {
			Integer prod_id = miResultSet.getInt("product_id");
			String prod_name = miResultSet.getString("name");
			Integer prod_stock = miResultSet.getInt("quantity_in_stock");
			double prod_price = miResultSet.getDouble("unit_price");
			
			Products temProd = new Products(prod_id, prod_name,prod_stock, prod_price);
			
			products.add(temProd);
			
		}
		
		return products;
	}


}

