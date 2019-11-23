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
public class ServletCss extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest peticionHttp, HttpServletResponse respuestaHttp) throws IOException {
        // Definimos el tipo de contenido según los tipos MIME.
        // Formatos conocidos de ficheros para el envío de emails.
        respuestaHttp.setContentType("text/css");
        try (PrintWriter salida = respuestaHttp.getWriter();) {
            salida.print(".color-rojo{"
                    + "color: red;"
                    + "}");
            for (int i = 0; i < 10; i++) {
                salida.print(".tam_" + i + "{"
                        + "font-size: 1." + i * 10 + "em;"
                        + "}");
            }
        }
    }
}
