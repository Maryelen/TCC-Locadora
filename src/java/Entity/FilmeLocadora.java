/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author Jorgeluiz
 */
public class FilmeLocadora {

    private Integer idFilmeLocadora;
    private Integer idFilme;
    private Date dtCadastramento;
    private Integer idLocadora;

    public Integer getIdLocadora() {
        return idLocadora;
    }

    public void setIdLocadora(Integer idLocadora) {
        this.idLocadora = idLocadora;
    }

    public Integer getIdFilmeLocadora() {
        return idFilmeLocadora;
    }

    public void setIdFilmeLocadora(Integer idFilmeLocadora) {
        this.idFilmeLocadora = idFilmeLocadora;
    }

    public Integer getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Integer idFilme) {
        this.idFilme = idFilme;
    }

    public Date getDtCadastramento() {
        return dtCadastramento;
    }

    public void setDtCadastramento(Date dtCadastramento) {
        this.dtCadastramento = dtCadastramento;
    }
}
