/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entity.Acesso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author maryelen_cassia
 */
public class AcessoDaoMySql {
   

    private static final String INSERT = "insert into Acesso(login, senha) values (?,?)";
    private static final String GET_BY_ID = "SELECT * FROM Acesso WHERE idAcesso = ?";
    private static final String DELETAR = "DELETE FROM Acesso WHERE idAcesso = ?";
    private static final String UPDATE = "update Acesso set login = ?, senha = ?"
            + " WHERE idAcesso = ? ";
    
     public void salvar(Acesso acesso) {
        Connection con = null;
        PreparedStatement ps = null;

        if (acesso.getIdAcesso() == 0){
            try {
                con = Conexao.conectar();
                ps = (PreparedStatement) con.prepareStatement(INSERT,
                        PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, acesso.getLogin());
                ps.setString(2, acesso.getSenha());                     

                ps.execute();
                con.close();

            } catch (Exception ex) {
                ex.printStackTrace();

            } finally {
                Conexao.desconectar(con);
            }
        } else {
            try {
                con = Conexao.conectar();
                ps = (PreparedStatement) con.prepareStatement(UPDATE);
                ps.setString(1, acesso.getLogin());
                ps.setString(2, acesso.getSenha());
                

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar(con);
            }
        }
     }
        
        public void deletar(int idAcesso) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Conexao.conectar();
            ps = (PreparedStatement) con.prepareStatement(DELETAR);
            ps.setInt(1, idAcesso);
            ps.execute();
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
    }
        public Acesso getById(int id) throws ClassNotFoundException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Acesso a = new Acesso();
        try {
            con = Conexao.conectar();
            ps = (PreparedStatement) con.prepareStatement(GET_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                a.setIdAcesso(rs.getInt("idAcesso"));
                a.setLogin(rs.getString("login"));
                a.setSenha(rs.getString("senha"));
               

            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return a;

    }
    
}
