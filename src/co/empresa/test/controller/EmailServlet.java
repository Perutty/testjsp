package co.empresa.test.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.empresa.test.modelo.Mensaje;
import co.empresa.test.util.EmailConexion;



/**
 * Servlet implementation class SendEmail
 */
@WebServlet({ "/SendEmail", "/EnviarEmail" })
public class EmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("<table><tr><th>Encabezado 1</th><th>Encabezado 2</th></tr></table>")
		.append("<tr><td>"+request.getContextPath()+"</td><td>Algo</td></tr>")
		.append("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String mensaje = request.getParameter("mensaje");
		String asunto = request.getParameter("asunto");
		
		
		Mensaje m = new Mensaje();
		
		m.setNombre(nombre);
		m.setEmail(email);
		m.setAsunto(asunto);
		m.setMensaje(mensaje);
		
		
		EmailConexion.enviarCorreo(m);
		response.sendRedirect("list");

	}

}