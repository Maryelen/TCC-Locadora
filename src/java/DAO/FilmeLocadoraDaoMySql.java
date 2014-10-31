/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interface.IFilmeDao;
import Entity.Filme;
import Entity.FilmeLocadora;
import Interface.IFilmeLocadoraDao;
import java.sql.Connection;
import java.sql.Date;
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
public class FilmeLocadoraDaoMySql implements IFilmeLocadoraDao {

    public int salvar(FilmeLocadora filmeLocadora) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int resultado = -1;

        try {
            conn = Conexao.conectar();
            String QUERY_INSERT = "insert into filmeLocadora (idFilme, dtCadastramento)values(?, ?)";

            stmt = conn.prepareStatement(QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, filmeLocadora.getIdFilme());
            stmt.setDate(2, (Date) filmeLocadora.getDtCadastramento());

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

            String QUERY_DELETE = "delete from filmeLocadora where idFilmeLocadora = ?";

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

    public List<FilmeLocadora> getAll() {
        Connection conn = null;
        ResultSet rs = null;
        List<FilmeLocadora> lista = null;
        try {
            conn = Conexao.conectar();

            String QUERY_DETALHE = "select idFilmeLocadora, idFilme, dtCadastramento from filmeLocadora ";

            PreparedStatement stmt = conn.prepareStatement(QUERY_DETALHE);
            rs = stmt.executeQuery();

            lista = new ArrayList<FilmeLocadora>();

            while (rs.next()) {
                FilmeLocadora filmeLocadora = new FilmeLocadora();
                filmeLocadora.setIdFilmeLocadora(rs.getInt("idFilmeLocadora"));
                filmeLocadora.setIdFilme(rs.getInt("idFilme"));
                filmeLocadora.setDtCadastramento(rs.getDate("dtCadastramento"));


                lista.add(filmeLocadora);
            }

            conn.close();

        } catch (SQLException ex) {
            //ex.printStackTrace();
        } finally {

            return lista;
        }

    }

    public FilmeLocadora getById(int id) {

        Connection conn = null;
       FilmeLocadora filmeLocadora = null;
        try {
            conn = Conexao.conectar();


            String QUERY_DETALHE = "select idFilmeLocadora, idFilme, dtCadastramento from filmeLocadora "
                    + " where idfilmeLocadora = ?";

            PreparedStatement stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);

            ResultSet rs = null;

            rs = stmt.executeQuery();

            while (rs.next()) {

                filmeLocadora = new FilmeLocadora();
                filmeLocadora.setIdFilmeLocadora(rs.getInt("idFilmeLocadora"));
                filmeLocadora.setIdFilme(rs.getInt("idFilme"));
                filmeLocadora.setDtCadastramento(rs.getDate("dtCadastramento"));

            }

            conn.close();
        } catch (SQLException ex) {
            //ex.printStackTrace();
        } finally {

            return filmeLocadora;
        }
    }

    public boolean update(FilmeLocadora filmeLocadora) {

        boolean resultado = false;

        try {
            PreparedStatement stmt = null;
            Connection conn = Conexao.conectar();
            String QUERY_UPDATE = "update filmeLocadora set idFilme = ?, dtCadastramento = ?"
                    + " where idFilmeLocadora = ?";

            stmt = conn.prepareStatement(QUERY_UPDATE);
            stmt.setInt(1, filmeLocadora.getIdFilme());
            stmt.setDate(2, (Date) filmeLocadora.getDtCadastramento());
            stmt.setInt(3, filmeLocadora.getIdFilmeLocadora());

            if (filmeLocadora.getIdFilmeLocadora() == null) {
                stmt.setString(4, null);
            } else {
                stmt.setInt(4, filmeLocadora.getIdFilmeLocadora());
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
}
