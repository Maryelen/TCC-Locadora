///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package facade;
//
//import Interface.IUsuarioDao;
//import DAO.UsuarioDaoMySql;
//import Entity.Usuario;
//import java.util.List;
//
///**
// *
// * @author maryelen_cassia
// */
//public class FacadeUsuario {
//
//    public void salvar(Usuario cliente) {
//
//        if ((cliente.getLogin() != null)
//                || (cliente.getLogin() != "")) {
//        }
//
//        if ((cliente.getSenha() != null)
//                || (cliente.getSenha() != "")) {
//        }
//
//        if ((cliente.getPerguntaDeSeguranca() != null)
//                || (cliente.getPerguntaDeSeguranca() != "")) {
//
//        }
//
//        UsuarioDaoMySql dao = new UsuarioDaoMySql();
//        dao.salvar(cliente);
//    }
//
//    public List<Usuario> getAll() {
//        IUsuarioDao dao = new UsuarioDaoMySql();
//        return dao.getAll();
//    }
//
//    public void deletar(int id) {
//        IUsuarioDao dao = new UsuarioDaoMySql();
//        dao.deletar(id);
//    }
//
//    public Usuario getById(int id) {
//        IUsuarioDao dao = new UsuarioDaoMySql();
//        return dao.getById(id);
//    }
//}
