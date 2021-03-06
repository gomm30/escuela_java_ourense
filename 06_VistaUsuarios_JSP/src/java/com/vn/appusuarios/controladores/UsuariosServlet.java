package com.vn.appusuarios.controladores;

import com.vn.appusuarios.modelo.logica.ChivatoServicios;
import com.vn.appusuarios.modelo.logica.ServiciosUsuarios;
import com.vn.appusuarios.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author pc
 */
public class UsuariosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String nombre = request.getParameter("nombre");
        String edad = request.getParameter("edad");

        ServiciosUsuarios srvUsu = new ServiciosUsuarios();
        srvUsu.setChivato((String mensaje) -> {
            request.getSession().setAttribute("mensajeError", "Error al crear: " + mensaje);
        });
        // Comprobamos que la petición es POST.
        if (request.getMethod() == "POST") {
            // Creamos el usuario.
            Usuario usuario = srvUsu.crear(email, password, nombre, edad);
            // Si usuario tiene id y no es null.
            if (usuario != null && usuario.getId() >= 0) {
                // Redirigir a la vista que muestra el usuario registrado.
                request.getSession().setAttribute("emailUsuario",email);
                request.getRequestDispatcher("registrado.jsp")
                        .forward(request, response);
            } else {
                // Redirigir la petición a la propia vista.
               request.getRequestDispatcher("registrarse.jsp")
                        .forward(request, response); 
            }
        }
    }

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
