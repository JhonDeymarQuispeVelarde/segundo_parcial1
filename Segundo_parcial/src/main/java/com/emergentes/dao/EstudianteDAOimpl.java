package com.emergentes.dao;

import com.emergentes.jhon.conexionBD;
import com.emergentes.modelo.Estudiante;
import com.mysql.cj.protocol.Resultset;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAOimpl extends conexionBD implements EstudianteDAO{

    @Override
    public void insert(Estudiante estudiante) throws Exception {
        String sql = "insert into estudiantes(Nombres, Apellidos, Seminarios, Confirmado, Fecha_de_Inscripcion) values (?,?,?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, estudiante.getNombre());
        ps.setString(2, estudiante.getApellidos());
        ps.setString(3, estudiante.getSeminario());
        ps.setString(4, estudiante.getConfirmado());
        ps.setString(5, estudiante.getFecha_de_Inscripcion());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Estudiante estudiante) throws Exception {
        String sql = "update estudiante set Nombre = ?, Apellidos = ?, Seminario = ?, Confirmado = ?, Fecha_de_Inscripcion = ?,  where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, estudiante.getNombre());
        ps.setString(2, estudiante.getApellidos());
        ps.setString(3, estudiante.getSeminario());
        ps.setString(4, estudiante.getConfirmado());
        ps.setString(5, estudiante.getFecha_de_Inscripcion());
        ps.setInt(6, estudiante.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from estudiante where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public List<Estudiante> getAll() throws Exception {
        List<Estudiante> lista = null;
        String sql = "select * from estudiantes";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        lista = new ArrayList<Estudiante>();
        while(rs.next()){
            Estudiante est = new Estudiante();
            est.setId(rs.getInt("Id"));
            est.setNombre(rs.getString("Nombre"));
            est.setApellidos(rs.getString("Apellidos"));
            est.setSeminario(rs.getString("Seminario"));
            est.setConfirmado(rs.getString("Confirmado"));
            est.setFecha_de_Inscripcion(rs.getString("Fecha_de_Inscripcion"));
            
            lista.add(est);
        }
        this.desconectar();
        return lista;
    }

    @Override
    public Estudiante getById(int id) throws Exception {
        Estudiante est = new Estudiante();
        try {
            String sql = "select * from estudiante = ?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            est.setId(rs.getInt("Id"));
            est.setNombre(rs.getString("Nombre"));
            est.setApellidos(rs.getString("Apellidos"));
            est.setSeminario(rs.getString("Seminario"));
            est.setConfirmado(rs.getString("Confirmado"));
            est.setFecha_de_Inscripcion(rs.getString("Fecha_de_Inscripcion"));
          }
        } catch (SQLException e) {
            throw e;
        }finally{
            this.desconectar();
        }
        
        return est;
    }

   
    
}
