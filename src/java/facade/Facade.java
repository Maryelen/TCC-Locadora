/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import DAO.FilmeDao;
import DAO.FilmeDaoMySql;
import Entity.Filme;
import java.util.List;

/**
 *
 * @author jorge_filho
 */
public class Facade {

    public void Salvar(Filme filme) {

        if ((filme.getNomeFilme() != null)
                || (filme.getNomeFilme() != "")) {

        }

        if (filme.getAnoFilme() != 0) {

        }
        if ((filme.getGeneroFilme() != null)
                || (filme.getGeneroFilme() != "")) {

        }

        if ((filme.getDiretorFilme() != null)
                || (filme.getDiretorFilme() != "")) {

        }
        if (filme.getCodigoFilme() != 0) {

        }
        if ((filme.getMidiaFilme() != null)
                || (filme.getMidiaFilme() != "")) {

        }

        if ((filme.getSinopseFilme() != null)
                || (filme.getSinopseFilme() != "")) {

        }

        if ((filme.getProdutoraFilme() != null)
                || (filme.getProdutoraFilme() != "")) {

        }
        if ((filme.getClassificacaoIndicativaFilme()
                != null) || (filme.getClassificacaoIndicativaFilme() != "")) {

        }
        if (filme.getValorPagoLocadora()
                != 0) {

        }
        if ((filme.getClassificacaoIndicativaFilme() != null)
                || (filme.getClassificacaoIndicativaFilme() != "")) {

        }
        if ((filme.getClassificacaoValorFilme() != null)
                || (filme.getClassificacaoValorFilme() != "")) {

        }
        FilmeDaoMySql dao = new FilmeDaoMySql();
        dao.salvar(filme);
    }

    }
    
    
//    public List<Filme> getAll() {
//        FilmeDao dao = new FilmeDaoMySql();
//        return dao.getAll();
//    }
    

