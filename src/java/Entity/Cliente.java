/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

/**
 *
 * @author maryelen_cassia
 */
public class Cliente {
    
    private Integer idCliente;
    private String nomeCliente;
    private String cpf;
    private String telefoneResidencial;
    private String telefoneCelular;
    private String telefoneRecado;
    private String email;
    private String Endereco;
    private String cidade;
    private String bairro;
    private String estado;
    private String complemento;
   private int fk_acesso;


    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public int getFk_acesso() {
        return fk_acesso;
    }

    public void setFk_acesso(int fk_acesso) {
        this.fk_acesso = fk_acesso;
    }



    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setCpf(String Cpf) {
        this.cpf = Cpf;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getTelefoneRecado() {
        return telefoneRecado;
    }

    public void setTelefoneRecado(String telefoneRecado) {
        this.telefoneRecado = telefoneRecado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

 
}
