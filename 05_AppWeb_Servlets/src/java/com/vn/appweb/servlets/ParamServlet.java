package com.vn.appweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Creando y formulario y recibiendo sus campos como parámetros
 *
 * @author pc
 */
public class ParamServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest peticionHttp, HttpServletResponse respuestaHttp)
            throws ServletException, IOException {
        respuestaHttp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = respuestaHttp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Form y param</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ParamServlet at " + peticionHttp.getContextPath() + "</h1>");
            out.println("<h2>Formulario de registro</h2>");
            // Campos a enviar: nombre e email, obligatorios y con su validacion HTML5
            out.println("<form name='formDatos' action='./formulario' method='POST' >");
            out.println("<div style='margin:.5em'><label for='nombre'>*Nombre: </label>");
            out.println("<input type='text' name='nombre' id='nombre' required='required'/></div>");
            out.println("<div style='margin:.5em'><label for='email'>*Email: </label>");
            out.println("<input type='email' name='email' id='email' required='required'/></div>");
            out.println("<input type='submit' value='Enviar datos' />");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest peticionHttp, HttpServletResponse respuestaHttp)
            throws ServletException, IOException {
        respuestaHttp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = respuestaHttp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Form y param</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ParamServlet at " + peticionHttp.getContextPath() + "</h1>");
            out.println("<h2>Formulario de registro</h2>");
            // Capturar valor del parámetro
            String nombre = peticionHttp.getParameter("nombre");
            String email = peticionHttp.getParameter("email");
            if (nombre == null || email == null || "".equals(nombre) || "".equals(email)) {
                out.print("<p style='color:red;font-weight:bold;'>No se han recibido alguno de los parámetros</p>");
            } else {
                out.print("<p style='color:green;'>Nombre: <span style='font-weight:bold;'>" + nombre + "</span></p>");
                out.print("<p style='color:green'>Email: <span style='font-weight:bold;'>" + email + "</span></p>");
            }
            // Vamos a insertar los datos recibidos
            // jdbc:derby://localhost:1527/db_prueba
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
            } catch (Exception ex) {
                Logger.getLogger(ParamServlet.class.getName()).log(Level.SEVERE, null, ex);
                out.print("<p style='color:red;font-weight:bold;'>No se ha podido cargar DerbyDB</p>");
            }
            try (Connection con = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/db_prueba",
                    "root",
                    "1234")) {
                String sqlQuery = "INSERT INTO PERSONA (nombre, email) VALUES ('" + nombre + "', '" + email + "')";
                Statement sentenciaSQL = con.createStatement();
                sentenciaSQL.executeUpdate(sqlQuery);
            } catch (SQLException ex) {
                Logger.getLogger(ParamServlet.class.getName()).log(Level.SEVERE, null, ex);
                out.print("<p style='color:red;font-weight:bold;'>Error SQL: " + ex.getMessage() + "</p>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet que envía formulario y recibe dos parámetros";
    }// </editor-fold>

}
