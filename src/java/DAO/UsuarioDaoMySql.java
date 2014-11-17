/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interface.IUsuarioDao;
import Entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maryelen_cassia
 */
public class UsuarioDaoMySql implements IUsuarioDao {

    public int salvar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int resultado = -1;

        try {
            conn = Conexao.conectar();
            String QUERY_INSERT = "insert into usuario (nome, email, login, senha)values(?, ?, ?, ?)";

            stmt = conn.prepareStatement(QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getLogin());
            stmt.setString(4, usuario.getSenha());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            resultado = rs.getInt(1);

            conn.close();

        } catch (SQLException ex) {

            //ex.printStackTrace();

            resultado = -1;

        } finally {

            return resultado;
        }
    }

    public boolean deletar(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean resultado = false;

        try {
            conn = Conexao.conectar();

            String QUERY_DELETE = "delete from usuario where idUsuario = ?";

            PreparedStatement stmt = conn.prepareStatement(QUERY_DELETE);
            stmt.setInt(1, id);

            stmt.executeUpdate();
            conn.close();

            resultado = true;

            return resultado;
        } catch (SQLException ex) {

            //ex.printStackTrace();
            resultado = false;

        } finally {

            return resultado;
        }

    }

    public List<Usuario> getAll() {
        Connection conn = null;
        ResultSet rs = null;
        List<Usuario> lista = null;
        try {
            conn = Conexao.conectar();

            String QUERY_DETALHE = "select idUsuario, nome, email,login,senha from usuario ";

            PreparedStatement stmt = conn.prepareStatement(QUERY_DETALHE);
            rs = stmt.executeQuery();

            lista = new ArrayList<Usuario>();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("idUsuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));

                lista.add(usuario);
            }

            conn.close();

        } catch (SQLException ex) {
            //ex.printStackTrace();
        } finally {

            return lista;
        }

    }

    public Usuario getById(int id) {

        Connection conn = null;
        Usuario usuario = null;
        try {
            conn = Conexao.conectar();


            String QUERY_DETALHE = "select idUsuario, nome, email, login, senha from usuario where idUsuario = ?";

            PreparedStatement stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);

            ResultSet rs = null;

            rs = stmt.executeQuery();

            while (rs.next()) {

                usuario = new Usuario();
                usuario.setId(rs.getInt("idUsuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));

            }

            conn.close();
        } catch (SQLException ex) {
            //ex.printStackTrace();
        } finally {

            return usuario;
        }
    }

    public boolean update(Usuario usuario) {

        boolean resultado = false;
        
        try {
            PreparedStatement stmt = null;
            Connection conn = Conexao.conectar();
            String QUERY_UPDATE = "update usuario set nome = ?, email = ?, login = ?, senha = ? where idUsuario = ?";

            stmt = conn.prepareStatement(QUERY_UPDATE);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getLogin());
            stmt.setString(4, usuario.getSenha());

            if (usuario.getId() == null) {
                stmt.setString(5, null);
            } else {
                stmt.setInt(5, usuario.getId());
            }

            stmt.executeUpdate();
            conn.close();

            resultado = true;

        } catch (SQLException ex) {

            //ex.printStackTrace();

            resultado = false;

        } finally {

            return resultado;
        }

    }
     public Usuario getByLoginESenha(Usuario usuario) {

        Connection conn = null;
        
        try {
            conn = Conexao.conectar();


            String QUERY_DETALHE = "select idUsuario, nome, email, login, senha from usuario where login = ? and senha = ?";

            PreparedStatement stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            
            ResultSet rs = null;

            rs = stmt.executeQuery();
            usuario = null;
            while (rs.next()) {

                usuario = new Usuario();
                usuario.setId(rs.getInt("idUsuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));

            }
            
            conn.close();
        } catch (SQLException ex) {
            //ex.printStackTrace();
        } finally {

            return usuario;
        }
    }
}
