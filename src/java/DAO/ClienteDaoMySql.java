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

/**
 *
 * @author maryelen_cassia
 */
public class ClienteDaoMySql {
    
    private static final String INSERT = "insert into Cliente (nomeCliente, cpf, telefoneResidencial, telefoneCelular, telefoneRecado,"
            + " email, endereco, bairro, cidade, estado, login, senha) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String GET_BY_ID = "SELECT * FROM Cliente WHERE idCliente = ?";
    private static final String GET_ALL = "select * from Cliente";
    private static final String DELETAR = "DELETE FROM Cliente WHERE idCliente = ?";
    private static final String UPDATE = "update into Cliente nomeCliente = ?, cpf = ?,telefoneResidencial = ?, telefoneCelular = ?, telefoneRecado = ?,"
            + " email = ?, endereco = ?, bairro = ?, cidade = ?, estado = ?, login = ?, senha = ?"
            + " WHERE idCliente = ? ";

 public void salvar(Cliente cliente) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

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
                ps.setString(11, cliente.getSenha());

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

       /*       ps.setInt(2, filme.getAnoFilme());
                ps.setString(3, filme.getGeneroFilme());
                ps.setString(4, filme.getDiretorFilme());
                ps.setInt(5, filme.getCodigoFilme());
                ps.setString(6, filme.getMidiaFilme());
                ps.setString(7, filme.getSinopseFilme());
                ps.setString(8, filme.getProdutoraFilme());
                ps.setString(9, filme.getClassificacaoIndicativaFilme());
                ps.setDouble(10, filme.getValorPagoLocadora());
                ps.setString(11, filme.getClassificacaoValorFilme());
              */

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar(con);
            }
        }

    }

    
}
