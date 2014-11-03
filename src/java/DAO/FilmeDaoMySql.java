/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interface.IFilmeDao;
import Entity.Filme;
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
public class FilmeDaoMySql implements IFilmeDao {

    public int salvar(Filme filme) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int resultado = -1;

        try {
            conn = Conexao.conectar();
            String QUERY_INSERT = "insert into filme (nome, descricao, foto)values(?, ?, ?)";

            stmt = conn.prepareStatement(QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, filme.getNome());
            stmt.setString(2, filme.getDescricao());
            stmt.setString(3, filme.getFoto());

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

            String QUERY_DELETE = "delete from filme where idFilme = ?";

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

    public List<Filme> getAll() {
        Connection conn = null;
        ResultSet rs = null;
        List<Filme> lista = null;
        try {
            conn = Conexao.conectar();

            String QUERY_DETALHE = "select idFilme, nome, descricao, foto from filme ";

            PreparedStatement stmt = conn.prepareStatement(QUERY_DETALHE);
            rs = stmt.executeQuery();

            lista = new ArrayList<Filme>();

            while (rs.next()) {
                Filme filme = new Filme();
                filme.setIdFilme(rs.getInt("idFilme"));
                filme.setNome(rs.getString("nome"));
                filme.setDescricao(rs.getString("descricao"));
                filme.setFoto(rs.getString("foto"));

                lista.add(filme);
            }

            conn.close();

        } catch (SQLException ex) {
            //ex.printStackTrace();
        } finally {

            return lista;
        }

    }

    public Filme getById(int id) {

        Connection conn = null;
        Filme filme = null;
        try {
            conn = Conexao.conectar();


            String QUERY_DETALHE = "select idFilme, nome, descricao, foto from filme where idfilme = ?";

            PreparedStatement stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);

            ResultSet rs = null;

            rs = stmt.executeQuery();

            while (rs.next()) {

                filme = new Filme();
                filme.setIdFilme(rs.getInt("idFilme"));
                filme.setNome(rs.getString("nome"));
                filme.setDescricao(rs.getString("descricao"));
                filme.setFoto(rs.getString("foto"));
            }

            conn.close();
        } catch (SQLException ex) {
            //ex.printStackTrace();
        } finally {

            return filme;
        }
    }

    public boolean update(Filme filme) {

        boolean resultado = false;

        try {
            PreparedStatement stmt = null;
            Connection conn = Conexao.conectar();
            String QUERY_UPDATE = "update filme set nome = ?, descricao = ?,"
                    + " foto = ? where idFilme = ?";

            stmt = conn.prepareStatement(QUERY_UPDATE);
            stmt.setString(1, filme.getNome());
            stmt.setString(2, filme.getDescricao());
            stmt.setString(3, filme.getFoto());

            if (filme.getIdFilme() == null) {
                stmt.setString(4, null);
            } else {
                stmt.setInt(4, filme.getIdFilme());
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
