package com.uniovi.sdi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletSaludo
 */
@WebServlet("/ServletSaludo")
public class ServletSaludo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int contador = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSaludo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<HTML>");
		out.println("<HEAD><TITLE>Hola Mundo!</TITLE></HEAD>");
		out.println("<BODY>");

		String nombre = (String) request.getParameter("nombre");
		if (nombre != null) {
			out.println("Hola " + nombre + "<br>");
		}

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {}
		
		out.println("ID del hilo:" + Thread.currentThread().getId() + "<br>");
		contador++;
		out.println("Visitas:" + contador + "<br>");

		out.println("</BODY>");
		out.println("</HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
