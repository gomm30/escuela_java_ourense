<%-- 
    Document   : lista_bbdd
    Created on : 22-nov-2019, 11:24:13
    Author     : pc
--%>

<%@page import="com.vn.appweb.modelo.ConsultaSQL"%>
<%@page import="java.util.List"%>
<%@page import="com.vn.appweb.modelo.DatosPersona"%>
<!--Este comentario se ve en el html-->
<%--Este comentario NO se ve en el html--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado JSP con DerbyDB</title>
        <style>
            body{
                font-family: sans-serif;
            }
            .global{
                padding: 1em 0;
                width: 90%;
                margin: 0 auto;
            }
            .busqueda{
                padding-bottom: 2em;
            }
            .busqueda form input{
                display: inline-block;
                font-size: 1.2em;
            }
            .busqueda input[type="submit"]{
                width: 19%;
                border: 2px black solid; 
                border-radius: 5px;
                padding: .1em 0;
                background-color: white;
            }
            .busqueda input[type="submit"]:hover{
                background-color: black;
                color: white;
            }
            .busqueda input[type="text"]{
                width: 80%;
                border:none;
                border-bottom: 2px lightgray solid;
                padding-right: .1em;
            }
            .busqueda input[type="text"]:focus{
                border-bottom-color: black;
            }
            table{
                border-collapse: collapse;
                width: 100%;
            }
            td, th{
                border-bottom: 2px black solid;
                padding: .5em;
                text-align: center;
            }
            th{
                background-color: black;
                color:white;
            }
            tbody tr:hover{
                background-color: lemonchiffon;
            }
        </style>
    </head>
    <body>
        <h1>Listado JSP con DerbyDB</h1>
        <%
            out.println("<p>Hola desde Java " + request.getContextPath() + "</p>");
        %>
        <!--        <ul>
        <%
            for (int i = 0; i < 3; i++) {
        %>  
        <li>Número <%=i%> </li>
        <%    }
        %>
</ul>-->
        <div class="global">
            <div class="busqueda">
                <form name="formBusq" method="GET" action="./lista_bbdd.jsp">
                    <input type="text" name="nombre_busq" placeholder="Introduzca el nombre de usuario a buscar..." />
                    <input type="submit" value="Buscar"/>
                </form>
            </div>
            <table>
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ConsultaSQL conSQL = new ConsultaSQL();
                        String nombreBusq = request.getParameter("nombre_busq");
                        List<DatosPersona> listaPer = conSQL.leerTabla(nombreBusq);
                        if (listaPer.size() > 0) {
                            for (DatosPersona persona : listaPer) {%>
                    <tr>
                        <td><%=persona.getNombre()%></td>
                        <td><%=persona.getEmail()%></td>
                    </tr>
                    <%    }
                    } else {
                    %>
                <td style="text-align: center" colspan="2">Parece que no existe ningún usuario con ese nombre</td>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </body>
</html>
