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
public class Usuario {

    private Integer id;
    private String login;
    private String senha;
    private String perguntaDeSeguranca;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerguntaDeSeguranca() {
        return perguntaDeSeguranca;
    }

    public void setPerguntaDeSeguranca(String perguntaDeSeguranca) {
        this.perguntaDeSeguranca = perguntaDeSeguranca;
    }

}
