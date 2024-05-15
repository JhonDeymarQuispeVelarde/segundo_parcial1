<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Estudiante"%>
<%
    Estudiante estudiante = (Estudiante)request.getAttribute("estudiante");

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nuevo Registro</h1>
        <form action="EstudianteControler" method="post">
            <input type="hidden" name="Id" value="${estudiante.Id}"
            <table>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="Nombre" value="${estudiante.Nombre}"/></td>
                </tr>
                <tr>
                    <td>Apellidos</td>
                    <td><input type="text" name="Apellidos" value="${estudiante.Apellidos}"/></td>
                </tr>
                <tr>
                    <td>Seminario</td>
                    <td><input type="text" name="Seminario" value="${estudiante.Seminario}"/></td>
                </tr>
                <tr>
                    <td>Confirmado</td>
                    <td><input type="text" name="Confirmado" value="${estudiante.Confirmado}"/></td>
                </tr>
                <tr>
                    <td>Fecha_de_Inscripcion</td>
                    <td><input type="text" name="Fecha_de_Inscripcion" value="${estudiante.Fecha_de_Inscripcion}"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit"></td>
                </tr>
            </table>
       </form>
    </body>
</html>
