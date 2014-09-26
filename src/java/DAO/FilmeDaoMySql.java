/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Filme;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maryelen_cassia
 */
public class FilmeDaoMySql implements FilmeDao {

    private static final String INSERT = "insert into Filme (nomeFilme, anoFilme,generoFilme, diretorFilme, codigoFilme,"
            + " midiaFilme, sinopseFilme, produtoraFilme, classificacaoIndicativaFilme,"
            + " valorPagoLocadora, classificacaoValorFilme) values (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String GET_BY_ID = "SELECT * FROM Filme WHERE idFilme = ?";
    private static final String GET_ALL = "select * from filme";
    private static final String DELETAR = "DELETE FROM Filme "
            + "WHERE idFilme = ?";
    private static final String UPDATE = "update into Filme nomeFilme = ?, anoFilme = ?,generoFilme = ?, diretorFilme = ?, codigoFilme = ?,"
            + " midiaFilme = ?,sinopseFilme = ?, produtoraFilme = ?,classificacaoIndicativaFilme = ?,"
            + "valorPagoLocadora = ?, classificacaoValorFilme = ? "
            + " WHERE idFilme = ? ";

    ;

    @Override
    public void salvar(Filme filme) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        if (filme.getIdFilme() == 0) {
            try {
                con = Conexao.conectar();
                ps = (PreparedStatement) con.prepareStatement(INSERT,
                        PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, filme.getNomeFilme());
                ps.setInt(2, filme.getAnoFilme());
                ps.setString(3, filme.getGeneroFilme());
                ps.setString(4, filme.getDiretorFilme());
                ps.setInt(5, filme.getCodigoFilme());
                ps.setString(6, filme.getMidiaFilme());
                ps.setString(7, filme.getSinopseFilme());
                ps.setString(8, filme.getProdutoraFilme());
                ps.setString(9, filme.getClassificacaoIndicativaFilme());
                ps.setDouble(10, filme.getValorPagoLocadora());
                ps.setString(11, filme.getClassificacaoValorFilme());

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
                ps.setString(1, filme.getNomeFilme());

                ps.setInt(2, filme.getAnoFilme());
                ps.setString(3, filme.getGeneroFilme());
                ps.setString(4, filme.getDiretorFilme());
                ps.setInt(5, filme.getCodigoFilme());
                ps.setString(6, filme.getMidiaFilme());
                ps.setString(7, filme.getSinopseFilme());
                ps.setString(8, filme.getProdutoraFilme());
                ps.setString(9, filme.getClassificacaoIndicativaFilme());
                ps.setDouble(10, filme.getValorPagoLocadora());
                ps.setString(11, filme.getClassificacaoValorFilme());

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar(con);
            }
        }

    }

    public void excluir(int idFilme) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = Conexao.conectar();
            String sql
                    = "DELETE FROM Filme "
                    + "WHERE idFilme = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idFilme);

            stmt.execute();
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public List<Filme> getAll() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Filme> lista = new ArrayList<Filme>();
        try {
            con = Conexao.conectar();

            ps = (PreparedStatement) con.prepareStatement(GET_ALL);
            rs = ps.executeQuery();

            while (rs.next()) {
                Filme f = new Filme();
                f.setIdFilme(rs.getInt("idFilme"));
                f.setNomeFilme(rs.getString("nomeFilme"));
                f.setAnoFilme(rs.getInt("anoFilme"));
                f.setClassificacaoIndicativaFilme(rs.getString("classificacaoIndicativaFilme"));
                f.setClassificacaoValorFilme(rs.getString("classificacaoValorFilme"));
                f.setCodigoFilme(rs.getInt("codigoFilme"));
                f.setGeneroFilme(rs.getString("generoFilme"));
                f.setProdutoraFilme(rs.getString("produtoraFilme"));
                f.setMidiaFilme(rs.getString("midiaFilme"));
                f.setDiretorFilme(rs.getString("diretorFilme"));
                f.setSinopseFilme(rs.getString("sinopseFilme"));
                f.setValorPagoLocadora(rs.getDouble("valorPagoLocadora"));
                lista.add(f);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    @Override
    public Filme getById(int id) throws ClassNotFoundException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Filme f = new Filme();
        try {
            con = Conexao.conectar();
            ps = (PreparedStatement) con.prepareStatement(GET_BY_ID);
            ps.setInt(1, id);

            if (rs.next()) {
                f.setIdFilme(rs.getInt("idFilme"));
                f.setNomeFilme(rs.getString("nomeFilme"));
                f.setAnoFilme(rs.getInt("anoFilme"));
                f.setDiretorFilme(rs.getString("diretorFilme"));
                f.setCodigoFilme(rs.getInt("codigoFilme"));
                f.setMidiaFilme(rs.getString("midiaFilme"));
                f.setSinopseFilme(rs.getString("sinopseFilme"));
                f.setProdutoraFilme(rs.getString("produtoraFilme"));
                f.setClassificacaoIndicativaFilme(rs.getString("classificacaoIndicativaFilme"));
                f.setValorPagoLocadora(rs.getDouble("valorPagoLocadora"));
                f.setClassificacaoIndicativaFilme(rs.getString("classificacaoValorFilme"));
                f.setGeneroFilme(rs.getString("generoFilme"));
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return f;

    }
}