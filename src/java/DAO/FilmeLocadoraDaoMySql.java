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
            String QUERY_INSERT = "insert into filmeLocadora (idFilme, dtCadastramento, idLocadora)values(?, ?, ?)";

            stmt = conn.prepareStatement(QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, filmeLocadora.getFilme().getId());
            stmt.setDate(2, filmeLocadora.getDtCadastramento());
            stmt.setInt(3, filmeLocadora.getLocadora().getId());

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

            String QUERY_DETALHE = "select idFilmeLocadora, idFilme, dtCadastramento, idLocadora from filmeLocadora ";

            PreparedStatement stmt = conn.prepareStatement(QUERY_DETALHE);
            rs = stmt.executeQuery();

            lista = new ArrayList<FilmeLocadora>();

            while (rs.next()) {
                FilmeLocadora filmeLocadora = new FilmeLocadora();
                filmeLocadora.setId(rs.getInt("idFilmeLocadora"));
                FilmeDaoMySql daoFilme = new FilmeDaoMySql();
                filmeLocadora.setFilme(daoFilme.getById(rs.getInt("idFilme")));
                filmeLocadora.setDtCadastramento(rs.getDate("dtCadastramento"));
                LocadoraDaoMySql daoLocadora = new LocadoraDaoMySql();
                
                filmeLocadora.setLocadora(daoLocadora.getById(rs.getInt("idLocadora")));

                lista.add(filmeLocadora);
            }

            conn.close();

        } catch (SQLException ex) {
            //ex.printStackTrace();
        } finally {

            return lista;
        }

    }

    public List<FilmeLocadora> getAllByIdLocadora(int id) {
        Connection conn = null;
        ResultSet rs = null;
        List<FilmeLocadora> lista = null;
        try {
            conn = Conexao.conectar();

            String QUERY_DETALHE = "select filmeLocadora.idFilmeLocadora, filmeLocadora.idFilme, "
                    + "filmeLocadora.dtCadastramento, filmeLocadora.idLocadora "
                    + "from filmeLocadora left join filme on filme.idFilme = filmeLocadora.idFilmeLocadora "
                    + " where filmelocadora.idLocadora = ?";

            PreparedStatement stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            lista = new ArrayList<FilmeLocadora>();

            while (rs.next()) {
                FilmeLocadora filmeLocadora = new FilmeLocadora();
                filmeLocadora.setId(rs.getInt("idFilmeLocadora"));
                FilmeDaoMySql daoFilme = new FilmeDaoMySql();
                filmeLocadora.setFilme(daoFilme.getById(rs.getInt("idFilme")));
                filmeLocadora.setDtCadastramento(rs.getDate("dtCadastramento"));
                LocadoraDaoMySql daoLocadora = new LocadoraDaoMySql();
                filmeLocadora.setLocadora(daoLocadora.getById(rs.getInt("idLocadora")));

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

            String QUERY_DETALHE = "select idFilmeLocadora, idFilme, dtCadastramento, idLocadora from  "
                    + "filmeLocadora where idLocadora = ?";

            PreparedStatement stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);

            ResultSet rs = null;

            rs = stmt.executeQuery();

            while (rs.next()) {

                filmeLocadora = new FilmeLocadora();
                filmeLocadora.setId(rs.getInt("idFilmeLocadora"));
                FilmeDaoMySql daoFilme = new FilmeDaoMySql();
                filmeLocadora.setFilme(daoFilme.getById(rs.getInt("idFilme")));
                filmeLocadora.setDtCadastramento(rs.getDate("dtCadastramento"));
                LocadoraDaoMySql daoLocadora = new LocadoraDaoMySql();
                filmeLocadora.setLocadora(daoLocadora.getById(rs.getInt("idLocadora")));

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
                    + " idLocadora = ? where idFilmeLocadora = ?";

            stmt = conn.prepareStatement(QUERY_UPDATE);
            stmt.setInt(1, filmeLocadora.getFilme().getId());
            stmt.setDate(2, (Date) filmeLocadora.getDtCadastramento());
            stmt.setInt(3, filmeLocadora.getLocadora().getId());

            if (filmeLocadora.getId() == null) {
                stmt.setString(4, null);
            } else {
                stmt.setInt(4, filmeLocadora.getId());
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
