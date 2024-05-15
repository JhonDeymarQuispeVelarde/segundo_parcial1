package com.emergentes.controlador;

import com.emergentes.dao.EstudianteDAO;
import com.emergentes.dao.EstudianteDAOimpl;
import com.emergentes.modelo.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EstudianteControler", urlPatterns = {"/EstudianteControler"})
public class EstudianteControler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EstudianteDAO dao = new EstudianteDAOimpl();

        Estudiante est = new Estudiante();
        int Id;

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "add":
                request.setAttribute("aviso", est);
                request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                break;
            case "edit":
                Id = Integer.parseInt(request.getParameter("Id"));
                 {
                    try {
                        est = dao.getById(Id);
                    } catch (Exception ex) {
                        System.out.println("error al obtener registro" + ex.getMessage());
                    }
                }
                request.setAttribute("estudiante", est);
                request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                break;

            case "delete":
                Id = Integer.parseInt(request.getParameter("Id"));

                try {
                    dao.delete(Id);
                } catch (Exception ex) {
                    System.out.println("Error al eliminar" + ex.getMessage());
                }

                response.sendRedirect("EstudianteControler");
                break;

            case "view":
                List<Estudiante> lista = new ArrayList<Estudiante>();
                try {
                    lista = dao.getAll();
                } catch (Exception ex) {
                    System.out.println("error al listar" + ex.getMessage());
                }
                request.setAttribute("estudiante", lista);
                request.getRequestDispatcher("estudiante.jsp").forward(request, response);
                break;
            default:
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int Id = Integer.parseInt(request.getParameter("Id"));
        String Nombre = request.getParameter("Nombre");
        String Apellidos = request.getParameter("Apellidos");
        String Seminarios = request.getParameter("Seminarios");
        String Confirmado = request.getParameter("Confirmado");
        String Fecha_de_Inscripcion = request.getParameter("Fecha_de_Inscripcion");

        Estudiante est = new Estudiante();
        
        est.setId(Id);
        est.setNombre(Nombre);
        est.setApellidos(Apellidos);
        est.setSeminario(Seminarios);
        est.setConfirmado(Confirmado);
        est.setFecha_de_Inscripcion(Fecha_de_Inscripcion);
        
        EstudianteDAO dao = new EstudianteDAOimpl();
        
        if (Id == 0){
            try {
                dao.insert(est);
            } catch (Exception ex) {
                System.out.println("Error al insertar"+ex.getMessage());
            }
        }else{
            try {
                dao.update(est);
            } catch (Exception ex) {
                System.out.println("Error al editar"+ex.getMessage());
            }
        }
        response.sendRedirect("EstudianteControler");
    }
}
