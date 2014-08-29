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
public class CadastroFilme {

    private int id;
    private String nomeFilme;
    private Date anoFilme;
    private String diretorFilme;
    private int codigoFilme;
    private Enum midiaFilme;
    private String sinopseFilme;
    private String produtoraFilme;
    private Enum classificacaoIndicativaFilme;
    private double valorPagoLocadora;
    private Enum classificacaoValorFilme;
    private Enum generoFilme;

    public void setId(int id) {
        this.id = id;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public void setAnoFilme(Date anoFilme) {
        this.anoFilme = anoFilme;
    }

    public void setDiretorFilme(String diretorFilme) {
        this.diretorFilme = diretorFilme;
    }

    public void setCodigoFilme(int codigoFilme) {
        this.codigoFilme = codigoFilme;
    }

    public void setMidiaFilme(Enum midiaFilme) {
        this.midiaFilme = midiaFilme;
    }

    public void setSinopseFilme(String sinopseFilme) {
        this.sinopseFilme = sinopseFilme;
    }

    public void setProdutoraFilme(String produtoraFilme) {
        this.produtoraFilme = produtoraFilme;
    }

    public void setClassificacaoIndicativaFilme(Enum classificacaoIndicativaFilme) {
        this.classificacaoIndicativaFilme = classificacaoIndicativaFilme;
    }

    public void setValorPagoLocadora(double valorPagoLocadora) {
        this.valorPagoLocadora = valorPagoLocadora;
    }

    public void setClassificacaoValorFilme(Enum classificacaoValorFilme) {
        this.classificacaoValorFilme = classificacaoValorFilme;
    }

    public void setGeneroFilme(Enum generoFilme) {
        this.generoFilme = generoFilme;
    }

    public int getId() {
        return id;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public Date getAnoFilme() {
        return anoFilme;
    }

    public String getDiretorFilme() {
        return diretorFilme;
    }

    public int getCodigoFilme() {
        return codigoFilme;
    }

    public Enum getMidiaFilme() {
        return midiaFilme;
    }

    public String getSinopseFilme() {
        return sinopseFilme;
    }

    public String getProdutoraFilme() {
        return produtoraFilme;
    }

    public Enum getClassificacaoIndicativaFilme() {
        return classificacaoIndicativaFilme;
    }

    public double getValorPagoLocadora() {
        return valorPagoLocadora;
    }

    public Enum getClassificacaoValorFilme() {
        return classificacaoValorFilme;
    }

    public Enum getGeneroFilme() {
        return generoFilme;
    }

}
