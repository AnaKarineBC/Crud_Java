/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.controller;

import cinema.model.bean.Sala;
import cinema.model.dao.DaoSala;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Ana
 */
public class ControllerSala {

    DaoSala daoSala;
    
    public Sala inserir(Sala sala) throws SQLException, ClassNotFoundException {
        daoSala = new DaoSala();
        Sala salaOut = daoSala.inserir(sala);
        return salaOut;
    }
 public Sala alterar(Sala sala) throws SQLException, ClassNotFoundException {
        daoSala = new DaoSala();
        Sala salaOut = daoSala.alterar(sala);
        return salaOut;
    }

    public Sala buscar(Sala sala) throws SQLException, ClassNotFoundException {
        daoSala = new DaoSala();
        Sala salaOut = daoSala.buscar(sala);
        return salaOut;
    }

    public Sala excluir(Sala sala) throws SQLException, ClassNotFoundException {
        daoSala = new DaoSala();
        Sala salaOut = daoSala.excluir(sala);
        return salaOut;
    }

    public List<Sala> listar(Sala sala) throws SQLException, ClassNotFoundException {
        daoSala = new DaoSala();
        List<Sala> listaSala = daoSala.listar(sala);
        return listaSala;


    }
    
}
