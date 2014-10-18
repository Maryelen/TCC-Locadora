/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Cliente;
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
public class ClienteDaoMySql {

    private static final String INSERT = "insert into Cliente (nomeCliente, cpf, telefoneResidencial, telefoneCelular, telefoneRecado,"
            + " email, endereco, bairro, cidade, estado, complemento) values (?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String GET_BY_ID = "SELECT * FROM Cliente WHERE idCliente = ?";
    private static final String GET_ALL = "select * from Cliente";
    private static final String DELETAR = "DELETE FROM Cliente WHERE idCliente = ?";
    private static final String UPDATE = "update Cliente set nomeCliente = ?, cpf = ?,telefoneResidencial = ?, telefoneCelular = ?, telefoneRecado = ?,"
            + " email = ?, endereco = ?, bairro = ?, cidade = ?, estado = ?, complemento = ?"
            + " WHERE idCliente = ? ";

    public void salvar(Cliente cliente) {
        Connection con = null;
        PreparedStatement ps = null;

        if (cliente.getIdCliente() == 0) {
            try {
                con = Conexao.conectar();
                ps = (PreparedStatement) con.prepareStatement(INSERT,
                        PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, cliente.getNomeCliente());
                ps.setString(2, cliente.getCpf());
                ps.setString(3, cliente.getEmail());
                ps.setString(4, cliente.getTelefoneCelular());
                ps.setString(5, cliente.getTelefoneRecado());
                ps.setString(6, cliente.getTelefoneResidencial());
                ps.setString(7, cliente.getBairro());
                ps.setString(8, cliente.getEndereco());
                ps.setString(9, cliente.getEstado());
                ps.setString(10, cliente.getCidade());
                ps.setString(11, cliente.getComplemento());

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
                ps.setString(1, cliente.getNomeCliente());

                ps.setString(2, cliente.getCpf());
                ps.setString(3, cliente.getEmail());
                ps.setString(4, cliente.getTelefoneCelular());
                ps.setString(5, cliente.getTelefoneRecado());
                ps.setString(6, cliente.getTelefoneResidencial());
                ps.setString(7, cliente.getEndereco());
                ps.setString(8, cliente.getEstado());
                ps.setString(9, cliente.getBairro());
                ps.setString(10, cliente.getComplemento());
                ps.setString(11, cliente.getCidade());

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar(con);
            }
        }

    }

    public void deletar(int idCliente) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Conexao.conectar();
            ps = (PreparedStatement) con.prepareStatement(DELETAR);
            ps.setInt(1, idCliente);
            ps.execute();
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public List<Cliente> getAll() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Cliente> lista = new ArrayList<Cliente>();
        try {
            con = Conexao.conectar();

            ps = (PreparedStatement) con.prepareStatement(GET_ALL);
            rs = ps.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("idCliente"));
                c.setNomeCliente(rs.getString("nomeCliente"));
                c.setCpf(rs.getString("cpf"));
                c.setEmail(rs.getString("email"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefoneCelular(rs.getString("telefoneCelular"));
                c.setTelefoneResidencial(rs.getString("telefoneCelular"));
                c.setTelefoneRecado(rs.getString("telefoneRecado"));
                c.setBairro(rs.getString("bairro"));
                c.setComplemento(rs.getString("complemento"));
                c.setEstado(rs.getString("estado"));
                c.setCidade(rs.getString("cidade"));
                lista.add(c);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    public Cliente getById(int id) throws ClassNotFoundException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Cliente c = new Cliente();
        try {
            con = Conexao.conectar();
            ps = (PreparedStatement) con.prepareStatement(GET_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                c.setIdCliente(rs.getInt("idCliente"));
                c.setNomeCliente(rs.getString("nomeCliente"));
                c.setCpf(rs.getString("cpf"));
                c.setEmail(rs.getString("email"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefoneCelular(rs.getString("telefoneCelular"));
                c.setTelefoneResidencial(rs.getString("telefoneCelular"));
                c.setTelefoneRecado(rs.getString("telefoneRecado"));
                c.setBairro(rs.getString("bairro"));
                c.setComplemento(rs.getString("complemento"));
                c.setEstado(rs.getString("estado"));
                c.setCidade(rs.getString("cidade"));

            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return c;

    }
}
