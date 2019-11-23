package com.vn.appweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet que genera una respuesta en formato html.
 *
 * @author pc
 */
public class HolaHtmlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest peticionHttp, HttpServletResponse respuestaHttp) throws IOException {
        // Definimos el tipo de contenido según los tipos MIME.
        // Formatos conocidos de ficheros para el envío de emails.
        respuestaHttp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter salida = respuestaHttp.getWriter();) {
            salida.print("<html>");
            salida.print("<head>");
            salida.print("<title>Web HTML desde Servlet</title>");
            salida.print("<link rel='stylesheet' href='./estilo'>");
            salida.print("</head>");
            salida.print("<body>");
            salida.print(
                    "<h1>Web HTML desde Servlet</h1>"
                    + "<h2 class='color-rojo'>Hola que pasa</h2>"
                            + "<ul>"
            );
            for (int i = 0; i < 10; i++) {
                salida.print("<li class='tam_"+ i +"'>Iteracción " + i + "</li>");
            }
            salida.print("</ul>");
            salida.print("<br/>Ruta: " + peticionHttp.getContextPath());
            salida.print("<br/>Método: " + peticionHttp.getMethod());
            salida.print("</body>");
            salida.print("</html>");
            //salida.close(); //Ya no hace falta, el try se encarga de cerrarlo.
        }
    }
}
