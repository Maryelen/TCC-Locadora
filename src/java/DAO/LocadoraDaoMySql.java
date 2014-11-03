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
                    + "( nome, cnpj, rua, numero,complemento,bairro"
                    + ", cidade, estado, cep, telefonecomercial, telefonecontato"
                    + ", email, site)"
                    + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            stmt = conn.prepareStatement(QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, locadora.getNome());
            stmt.setString(2, locadora.getCnpj());
            stmt.setString(3, locadora.getRua());
            stmt.setInt(4, locadora.getNumero());
            stmt.setString(5, locadora.getComplemento());
            stmt.setString(6, locadora.getBairro());
            stmt.setString(7, locadora.getCidade());
            stmt.setString(8, locadora.getEstado());
            stmt.setString(9, locadora.getCep());
            stmt.setString(10, locadora.getTelefoneComercial());
            stmt.setString(11, locadora.getTelefoneContato());
            stmt.setString(12, locadora.getEmail());
            stmt.setString(13, locadora.getSite());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            resultado = rs.getInt(1);

            conn.close();

        } catch (SQLException ex) {

            ex.printStackTrace();

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

            String QUERY_DETALHE = "select idLocadora "
                    + ",nome, cnpj, rua, numero,complemento,bairro "
                    + ", cidade, estado, cep, telefonecomercial, telefonecontato "
                    + ", email, site from locadora ";

            PreparedStatement stmt = conn.prepareStatement(QUERY_DETALHE);
            rs = stmt.executeQuery();

            lista = new ArrayList<Locadora>();

            while (rs.next()) {
                Locadora locadora = new Locadora();
                locadora.setId(rs.getInt("idLocadora"));
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


            String QUERY_DETALHE = "select idLocadora "
                    + ",nome, cnpj, rua, numero,complemento,bairro"
                    + ", cidade, estado, cep, telefonecomercial, telefonecontato"
                    + ", email, site from locadora where idLocadora = ?";

            PreparedStatement stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);

            ResultSet rs = null;

            rs = stmt.executeQuery();

            while (rs.next()) {

                locadora = new Locadora();
                locadora.setId(rs.getInt("idLocadora"));
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
            String QUERY_UPDATE = "update locadora set nome = ?, cnpj = ?, rua = ?, numero = ?"
                    + ",complemento = ?,bairro = ?, cidade = ?, estado = ?, cep = ?"
                    + ", telefonecomercial = ?, telefonecontato = ?, email = ?, site = ? "
                    + " where idLocadora = ?";

            stmt = conn.prepareStatement(QUERY_UPDATE);
            stmt.setString(1, locadora.getNome());
            stmt.setString(2, locadora.getCnpj());
            stmt.setString(3, locadora.getRua());
            stmt.setInt(4, locadora.getNumero());
            stmt.setString(5, locadora.getComplemento());
            stmt.setString(6, locadora.getBairro());
            stmt.setString(7, locadora.getCidade());
            stmt.setString(8, locadora.getEstado());
            stmt.setString(9, locadora.getCep());
            stmt.setString(10, locadora.getTelefoneComercial());
            stmt.setString(11, locadora.getTelefoneContato());
            stmt.setString(12, locadora.getEmail());
            stmt.setString(13, locadora.getSite());
            stmt.setInt(14, locadora.getId());

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
