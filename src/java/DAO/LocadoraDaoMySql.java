/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Locadora;
import Interface.ILocadoraDao;
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
public class LocadoraDaoMySql implements ILocadoraDao {

    public int salvar(Locadora locadora) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int resultado = -1;

        try {
            conn = Conexao.conectar();
            String QUERY_INSERT = "insert into locadora "
                    + "(idUsuario, idFilmeLocadora"
                    + ",nome, cnpj, rua, numero,complemento,bairro"
                    + ", cidade, estado, cep, telefonecomercial, telefonecontato"
                    + ", email, site)"
                    + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            stmt = conn.prepareStatement(QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, locadora.getIdUsuario());
            stmt.setInt(2, locadora.getIdFilmeLocadora());
            stmt.setString(3, locadora.getNome());
            stmt.setString(4, locadora.getCnpj());
            stmt.setString(5, locadora.getRua());
            stmt.setInt(6, locadora.getNumero());
            stmt.setString(7, locadora.getComplemento());
            stmt.setString(8, locadora.getBairro());
            stmt.setString(9, locadora.getCidade());
            stmt.setString(10, locadora.getEstado());
            stmt.setString(11, locadora.getCep());
            stmt.setString(12, locadora.getTelefoneComercial());
            stmt.setString(13, locadora.getTelefoneContato());
            stmt.setString(14, locadora.getEmail());
            stmt.setString(15, locadora.getSite());

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

            String QUERY_DELETE = "delete from locadora where idLocadora = ?";

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

    public List<Locadora> getAll() {
        Connection conn = null;
        ResultSet rs = null;
        List<Locadora> lista = null;
        try {
            conn = Conexao.conectar();

            String QUERY_DETALHE = "select idLocadora, dUsuario, idFilmeLocadora"
                    + ",nome, cnpj, rua, numero,complemento,bairro"
                    + ", cidade, estado, cep, telefonecomercial, telefonecontato"
                    + ", email, site from locadora ";

            PreparedStatement stmt = conn.prepareStatement(QUERY_DETALHE);
            rs = stmt.executeQuery();

            lista = new ArrayList<Locadora>();

            while (rs.next()) {
                Locadora locadora = new Locadora();
                locadora.setId(rs.getInt("idLocadora"));
                locadora.setIdUsuario(rs.getInt("idUsuario"));
                locadora.setIdFilmeLocadora(rs.getInt("idFilmeLocadora"));
                locadora.setNome(rs.getString("nome"));
                locadora.setCnpj(rs.getString("cnpj"));
                locadora.setRua(rs.getString("rua"));
                locadora.setNumero(rs.getInt("numero"));
                locadora.setComplemento(rs.getString("complemento"));
                locadora.setBairro(rs.getString("bairro"));
                locadora.setCidade(rs.getString("cidade"));
                locadora.setEstado(rs.getString("estado"));
                locadora.setCep(rs.getString("cep"));
                locadora.setTelefoneComercial(rs.getString("telefonecomercial"));
                locadora.setTelefoneContato(rs.getString("telefonecontato"));
                locadora.setEmail(rs.getString("email"));
                locadora.setSite(rs.getString("site"));

                lista.add(locadora);
            }

            conn.close();

        } catch (SQLException ex) {
            //ex.printStackTrace();
        } finally {

            return lista;
        }

    }

    public Locadora getById(int id) {

        Connection conn = null;
        Locadora locadora = null;
        try {
            conn = Conexao.conectar();


            String QUERY_DETALHE = "select idLocadora, dUsuario, idFilmeLocadora"
                    + ",nome, cnpj, rua, numero,complemento,bairro"
                    + ", cidade, estado, cep, telefonecomercial, telefonecontato"
                    + ", email, site from locadora where idUsuario = ?";

            PreparedStatement stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);

            ResultSet rs = null;

            rs = stmt.executeQuery();

            while (rs.next()) {

                locadora = new Locadora();
                locadora.setId(rs.getInt("idLocadora"));
                locadora.setIdUsuario(rs.getInt("idUsuario"));
                locadora.setIdFilmeLocadora(rs.getInt("idFilmeLocadora"));
                locadora.setNome(rs.getString("nome"));
                locadora.setCnpj(rs.getString("cnpj"));
                locadora.setRua(rs.getString("rua"));
                locadora.setNumero(rs.getInt("numero"));
                locadora.setComplemento(rs.getString("complemento"));
                locadora.setBairro(rs.getString("bairro"));
                locadora.setCidade(rs.getString("cidade"));
                locadora.setEstado(rs.getString("estado"));
                locadora.setCep(rs.getString("cep"));
                locadora.setTelefoneComercial(rs.getString("telefonecomercial"));
                locadora.setTelefoneContato(rs.getString("telefonecontato"));
                locadora.setEmail(rs.getString("email"));
                locadora.setSite(rs.getString("site"));

            }

            conn.close();
        } catch (SQLException ex) {
            //ex.printStackTrace();
        } finally {

            return locadora;
        }
    }

    public boolean update(Locadora locadora) {

        boolean resultado = false;

        try {
            PreparedStatement stmt = null;
            Connection conn = Conexao.conectar();
            String QUERY_UPDATE = "update locadora set dUsuario = ?, idFilmeLocadora = ?"
                    + ",nome = ?, cnpj = ?, rua = ?, numero = ?,complemento = ?,bairro = ?"
                    + ", cidade = ?, estad = ?, cep = ?, telefonecomercial = ?, telefonecontato = ?"
                    + ", email = ?, site = ? where idLocadora = ?";

            stmt.setInt(1, locadora.getIdUsuario());
            stmt.setInt(2, locadora.getIdFilmeLocadora());
            stmt.setString(3, locadora.getNome());
            stmt.setString(4, locadora.getCnpj());
            stmt.setString(5, locadora.getRua());
            stmt.setInt(6, locadora.getNumero());
            stmt.setString(7, locadora.getComplemento());
            stmt.setString(8, locadora.getBairro());
            stmt.setString(9, locadora.getCidade());
            stmt.setString(10, locadora.getEstado());
            stmt.setString(11, locadora.getCep());
            stmt.setString(12, locadora.getTelefoneComercial());
            stmt.setString(13, locadora.getTelefoneContato());
            stmt.setString(14, locadora.getEmail());
            stmt.setString(15, locadora.getSite());
            stmt.setInt(16, locadora.getId());

            if (locadora.getId()== null) {
                stmt.setString(6, null);
            } else {
                stmt.setInt(5, locadora.getId());
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
