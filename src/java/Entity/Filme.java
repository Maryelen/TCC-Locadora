/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author maryelen_cassia
 */
public class Filme {

    private int idFilme;
    private String nomeFilme;
    private int anoFilme;
    private String diretorFilme;
    private int codigoFilme;
    private String midiaFilme;
    private String sinopseFilme;
    private String produtoraFilme;
    private String classificacaoIndicativaFilme;
    private double valorPagoLocadora;
    private String classificacaoValorFilme;
    private String generoFilme;

    public void setIdFilme(int id) {
        this.idFilme = id;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public void setAnoFilme(int anoFilme) {
        this.anoFilme = anoFilme;
    }

    public void setDiretorFilme(String diretorFilme) {
        this.diretorFilme = diretorFilme;
    }

    public void setCodigoFilme(int codigoFilme) {
        this.codigoFilme = codigoFilme;
    }

    public void setMidiaFilme(String midiaFilme) {
        this.midiaFilme = midiaFilme;
    }

    public void setSinopseFilme(String sinopseFilme) {
        this.sinopseFilme = sinopseFilme;
    }

    public void setProdutoraFilme(String produtoraFilme) {
        this.produtoraFilme = produtoraFilme;
    }

    public void setClassificacaoIndicativaFilme(String classificacaoIndicativaFilme) {
        this.classificacaoIndicativaFilme = classificacaoIndicativaFilme;
    }

    public void setValorPagoLocadora(double valorPagoLocadora) {
        this.valorPagoLocadora = valorPagoLocadora;
    }

    public void setClassificacaoValorFilme(String classificacaoValorFilme) {
        this.classificacaoValorFilme = classificacaoValorFilme;
    }

    public void setGeneroFilme(String generoFilme) {
        this.generoFilme = generoFilme;
    }

    public int getIdFilme() {
        return idFilme;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public int getAnoFilme() {
        return anoFilme;
    }

    public String getDiretorFilme() {
        return diretorFilme;
    }

    public int getCodigoFilme() {
        return codigoFilme;
    }

    public String getMidiaFilme() {
        return midiaFilme;
    }

    public String getSinopseFilme() {
        return sinopseFilme;
    }

    public String getProdutoraFilme() {
        return produtoraFilme;
    }

    public String getClassificacaoIndicativaFilme() {
        return classificacaoIndicativaFilme;
    }

    public double getValorPagoLocadora() {
        return valorPagoLocadora;
    }

    public String getClassificacaoValorFilme() {
        return classificacaoValorFilme;
    }

    public String getGeneroFilme() {
        return generoFilme;
    }

}
