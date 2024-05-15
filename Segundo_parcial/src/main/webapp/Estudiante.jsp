<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Estudiante"%>
<%
  List<Estudiante> estudiantes = (List<Estudiante>)request.getAttribute("estudiantes");

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1" CENTER > 
            <p>PRIMER PARCIAL TEM-742 </br> 
                Nombre: Jhon deymar quispe velarde </br>
                Carnet: 13550043
            </p>
        </table>
        <h1 CENTER>REGISTRO DIA DEL INTERNET </h1>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Seminario</th>
                <th>Confirmado</th>
                <th>Fecha_de_Inscripcion</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${esstudiante}">
                <tr>
                <td>${item.Id}</td>
                <td>${item.Nombre}</td>
                <td>${item.Apellidos}</td>
                <td>${item.Seminario}</td>
                <td>${item.Confirmado}</td>
                <td>${item.Fecha_de_Inscripcion}</td>
                <td><a href="EstudianteControler?action=edit&Id=${item.Id}">Editar</a> </td>
                <td><a href="EstudianteControler?action=delete&Id=${item.Id}">Eliminar</a></td>
            </tr>
            </c:forEach>
            
        </table>

    </body>
</html>
