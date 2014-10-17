/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

/**
 *
 * @author maryelen_cassia
 */
public class AcessoDaoMySql {
   

    private static final String INSERT = "insert into Cliente (nomeCliente, cpf, telefoneResidencial, telefoneCelular, telefoneRecado,"
            + " email, endereco, bairro, cidade, estado, complemento) values (?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String GET_BY_ID = "SELECT * FROM Cliente WHERE idAcesso = ?";
    private static final String DELETAR = "DELETE FROM Cliente WHERE idCliente = ?";
    private static final String UPDATE = "update Cliente set nomeCliente = ?, cpf = ?,telefoneResidencial = ?, telefoneCelular = ?, telefoneRecado = ?,"
            + " email = ?, endereco = ?, bairro = ?, cidade = ?, estado = ?, complemento = ?"
            + " WHERE idCliente = ? ";
    
    
}
