package com.vn.appusuarios.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Descriptores de servlets
@WebServlet({ "/saludo", "/otraurl" })
public class SaludoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		resp.getWriter().println(nombre);
		Cookie[] todasCookies = req.getCookies();
		Cookie nombreCookie = null;
		boolean hayCookie = false;
		for(Cookie co:todasCookies) {
			if(co.getName().equals(nombreCookie)) {
				hayCookie = true;
				nombreCookie = co;
			}
		}
		if (!hayCookie) {
			nombreCookie = new Cookie("nombre_cookie", "Valor de la cookie " + nombre);
			//nombreCookie.setMaxAge(3600);
		} else {
			nombreCookie = todasCookies[0];
		}
		resp.addCookie(nombreCookie);
		System.out.println("Cookie desde navegador: " + todasCookies[0].getValue());
		if (todasCookies.length > 0) {
			System.out.println("Cookie desde navegador: " + todasCookies[1].getValue());
		}
		
		resp.getWriter().println("<div id='div'></div>");
		resp.getWriter().println("<script>document.getElementById('div').innerHTML = document.cookie;");
		resp.getWriter().println("document.cookie ='nombre_cookie=\"Modificada en JS:\"';");
		resp.getWriter().println("</script>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
	}

}
