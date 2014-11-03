/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author Jorgeluiz
 */
public class FilmeLocadora {

    private Integer id;
    private Filme filme;
    private Locadora locadora;
    private Date dtCadastramento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Locadora getLocadora() {
        return locadora;
    }

    public void setLocadora(Locadora locadora) {
        this.locadora = locadora;
    }

    public Date getDtCadastramento() {
        return dtCadastramento;
    }

    public void setDtCadastramento(Date dtCadastramento) {
        this.dtCadastramento = dtCadastramento;
    }
}
