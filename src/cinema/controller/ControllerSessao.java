/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.controller;

import cinema.model.bean.Sessao;
import cinema.model.dao.DaoSessao;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Ana
 */
public class ControllerSessao {
     DaoSessao daoSessao;
    
    public Sessao inserir(Sessao sessao) throws SQLException, ClassNotFoundException {
        daoSessao = new DaoSessao();
        Sessao sessaoOut = daoSessao.inserir(sessao);
        return sessaoOut;
    }
    
    public Sessao alterar(Sessao animacao) throws SQLException, ClassNotFoundException {
        daoSessao = new DaoSessao();
        Sessao sessaoOut = daoSessao.alterar(animacao);
        return sessaoOut;
    }
    public Sessao buscar(Sessao sessao) throws SQLException, ClassNotFoundException {
        daoSessao = new DaoSessao();
        Sessao sessaoOut = daoSessao.buscar(sessao);
        return sessaoOut;
    }
    public Sessao excluir(Sessao sessao) throws SQLException, ClassNotFoundException {
        daoSessao = new DaoSessao();
        Sessao sessaoOut = daoSessao.excluir(sessao);
        return sessaoOut;
    }
    public List<Sessao> listar(Sessao sessao) throws SQLException, ClassNotFoundException {
        daoSessao = new DaoSessao();
         List<Sessao> listaSessao = daoSessao.listar(sessao);
        return listaSessao;
    }
}
