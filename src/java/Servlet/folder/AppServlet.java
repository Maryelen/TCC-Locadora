/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.folder;

import Entity.Filme;
import facade.Facade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author maryelen_cassia
 */
public class AppServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Filme filme = new Filme();

        filme.setNomeFilme(req.getParameter("nomeFilme"));
        filme.setAnoFilme(Integer.parseInt(req.getParameter("anoFilme")));
        filme.setGeneroFilme(req.getParameter("generoFilme"));
        filme.setDiretorFilme(req.getParameter("diretorFilme"));
        filme.setCodigoFilme(Integer.parseInt(req.getParameter("codigoFilme")));
        filme.setMidiaFilme(req.getParameter("midiaFilme"));
        filme.setSinopseFilme(req.getParameter("sinopseFilme"));
        filme.setProdutoraFilme(req.getParameter("produtoraFilme"));
        filme.setClassificacaoIndicativaFilme(req.getParameter("classificacaoFilme"));
        filme.setValorPagoLocadora(Double.parseDouble(req.getParameter("valorFilmePagoLocadora")));
        filme.setClassificacaoValorFilme(req.getParameter("classificacaoValorFilme"));
        
        Facade facade = new Facade();
        
        facade.Salvar(filme);
                                                                                                                           

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
