package com.mvc.prducts;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ControladorProductosRemoto
 */
@WebServlet("/ControladorProductosRemoto")
public class ControladorProductosRemoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private ModeloProductos modeloProductos;
    
    @Resource(name="jdbc/productos")
	private DataSource miPool;
    
   
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			modeloProductos= new ModeloProductos(miPool);
		} catch(Exception e) {
			throw new ServletException(e);
		}
		
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// Obtener la lista de productos
		List<Products> products;
		
		try {
			products = modeloProductos.getProducts();
		
		
			request.setAttribute("PRODUCTLIST", products);
			
		// Enviar a la pag jsp
			
			RequestDispatcher miDispatcher= request.getRequestDispatcher("/ProductList.jsp");
			
			miDispatcher.forward(request, response);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	

}
