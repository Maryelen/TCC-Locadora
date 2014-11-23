/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interface.IFilmeDao;
import Entity.Filme;
import Entity.Locadora;
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
            String QUERY_INSERT = "insert into filme (idLocadora, nome, descricao, ano, genero)values(?, ?, ?, ?, ?)";

            stmt = conn.prepareStatement(QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, filme.getLocadora().getId());
            stmt.setString(2, filme.getNome());
            stmt.setString(3, filme.getDescricao());
            stmt.setInt(4, filme.getAno());
            stmt.setString(5, filme.getGenero());

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

            String QUERY_DETALHE = "select  ,idLocadora, nome, descricao, ano, genero from filme ";

            PreparedStatement stmt = conn.prepareStatement(QUERY_DETALHE);
            rs = stmt.executeQuery();

            lista = new ArrayList<Filme>();

            while (rs.next()) {
                Filme filme = new Filme();
                filme.setLocadora(new Locadora());
                LocadoraDaoMySql locDao = new LocadoraDaoMySql();
                
                filme.setId(rs.getInt("idFilme"));
                filme.setLocadora(locDao.getById(rs.getInt("idLocadora")));
                filme.setNome(rs.getString("nome"));
                filme.setDescricao(rs.getString("descricao"));
                filme.setAno(rs.getInt("Ano"));
                filme.setGenero(rs.getString("genero"));

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

            String QUERY_DETALHE = "select idFilme, idLocadora, nome, descricao, ano, genero from filme where idfilme = ?";

            PreparedStatement stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);

            ResultSet rs = null;

            rs = stmt.executeQuery();

            while (rs.next()) {

                filme = new Filme();
                filme.setLocadora(new Locadora());
                LocadoraDaoMySql locDao = new LocadoraDaoMySql();

                filme.setId(rs.getInt("idFilme"));
                filme.setLocadora(locDao.getById(rs.getInt("idLocadora")));
                filme.setNome(rs.getString("nome"));
                filme.setDescricao(rs.getString("descricao"));
                filme.setAno(rs.getInt("ano"));
                filme.setGenero(rs.getString("genero"));

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
            String QUERY_UPDATE = "update filme set idLocadora = ?, nome = ?, descricao = ?,"
                    + " ano = ?, genero = ? where idFilme = ?";

            stmt = conn.prepareStatement(QUERY_UPDATE);
            stmt.setInt(1, filme.getLocadora().getId());
            stmt.setString(2, filme.getNome());
            stmt.setString(3, filme.getDescricao());
            stmt.setInt(4, filme.getAno());
            stmt.setString(5, filme.getGenero());

            if (filme.getId() == null) {
                stmt.setString(6, null);
            } else {
                stmt.setInt(6, filme.getId());
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
