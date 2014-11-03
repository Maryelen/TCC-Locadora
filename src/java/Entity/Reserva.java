/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author maryelen_cassia
 */
public class Reserva {

    private Integer id;
    private Usuario usuario;
    private FilmeLocadora filmeLocadora;
    private String situacao;
    private Date dtReserva;
    private Date dtConfirmacao;
    private Date dtConcluido;
    private Date dtCancelado;
    private String motivo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public FilmeLocadora getFilmeLocadora() {
        return filmeLocadora;
    }

    public void setFilmeLocadora(FilmeLocadora filmeLocadora) {
        this.filmeLocadora = filmeLocadora;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Date getDtReserva() {
        return dtReserva;
    }

    public void setDtReserva(Date dtReserva) {
        this.dtReserva = dtReserva;
    }

    public Date getDtConfirmacao() {
        return dtConfirmacao;
    }

    public void setDtConfirmacao(Date dtConfirmacao) {
        this.dtConfirmacao = dtConfirmacao;
    }

    public Date getDtConcluido() {
        return dtConcluido;
    }

    public void setDtConcluido(Date dtConcluido) {
        this.dtConcluido = dtConcluido;
    }

    public Date getDtCancelado() {
        return dtCancelado;
    }

    public void setDtCancelado(Date dtCancelado) {
        this.dtCancelado = dtCancelado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

}
