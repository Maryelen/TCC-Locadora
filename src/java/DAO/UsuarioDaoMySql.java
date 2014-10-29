/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maryelen_cassia
 */
public class UsuarioDaoMySql implements UsuarioDao {

    private static final String INSERT = "insert into usuario (login, senha, perguntaDeSeguranca) values (?,?,?)";
    private static final String GET_BY_ID = "SELECT * FROM usuario WHERE id = ?";
    private static final String GET_ALL = "select * from usuario";
    private static final String DELETAR = "DELETE FROM usuario WHERE id = ?";
    private static final String UPDATE = "update usuario set login = ?, senha = ?,perguntaDeSeguranca = ?"
            + " WHERE id = ? ";

    public void salvar(Usuario usuario) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Conexao.conectar();
            if (usuario.getId() == 0) {
                ps = (PreparedStatement) con.prepareStatement(INSERT);
                ps.setString(1, usuario.getLogin());
                ps.setString(2, usuario.getSenha());
                ps.setString(3, usuario.getPerguntaDeSeguranca());
            } else {
                ps = (PreparedStatement) con.prepareStatement(UPDATE);
                ps.setString(1, usuario.getLogin());
                ps.setString(2, usuario.getSenha());
                ps.setString(3, usuario.getPerguntaDeSeguranca());
                ps.setInt(4,usuario.getId());
            }
            ps.execute();
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            Conexao.desconectar(con);
        }
    }

    public void deletar(int id) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Conexao.conectar();
            ps = (PreparedStatement) con.prepareStatement(DELETAR);
            ps.setInt(1, id);
            ps.execute();
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public List<Usuario> getAll() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Usuario> lista = new ArrayList<Usuario>();
        try {
            con = Conexao.conectar();

            ps = (PreparedStatement) con.prepareStatement(GET_ALL);
            rs = ps.executeQuery();

            while (rs.next()) {
                Usuario c = new Usuario();
                c.setId(rs.getInt("id"));
                c.setLogin(rs.getString("login"));
                c.setSenha(rs.getString("senha"));
                c.setPerguntaDeSeguranca(rs.getString("perguntaDeSeguranca"));
                lista.add(c);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    public Usuario getById(int id) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario usuario = null;
        try {
            con = Conexao.conectar();
            ps = (PreparedStatement) con.prepareStatement(GET_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setLogin(rs.getString("login"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setPerguntaDeSeguranca(rs.getString("perguntaDeSeguranca"));

            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return usuario;

    }
}
