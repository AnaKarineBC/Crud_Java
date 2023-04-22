/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.view;

import cinema.Cinema;
import cinema.controller.ControllerSessao;
import cinema.model.bean.Sessao;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ana
 */
public class ManterSessao {
    
    public static void menu() throws SQLException, ClassNotFoundException {
        int op = Integer.parseInt(JOptionPane.showInputDialog("1 - Inserir \n 2 - Alterar \n 3 - buscar \n 4 - excluir \n 5 - Listar: "));
        
        switch(op){
            case 1:
                inserir();
                break;
            case 2:
                alterar();
                break;
            case 3:
                buscar();
                break;
            case 4:
                excluir();
                break;
            case 5:
                listar();
                break;
            default:
                System.out.println("Opcao inválida");
        }
    }

    private static void inserir() throws SQLException, ClassNotFoundException {
        int idSala = Integer.parseInt(JOptionPane.showInputDialog("Insira o id da sala da sessao: "));
        String idAnima = JOptionPane.showInputDialog("Insira o id da animacao da sessao: ");
        Sessao sessao = new Sessao(idSala, idAnima);
        ControllerSessao contSessao = new ControllerSessao();
        Sessao sessaoOut = contSessao.inserir(sessao);
        JOptionPane.showMessageDialog(null,sessaoOut.toString());
        Cinema.main(null);
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID da sessao: "));
        int idSala = Integer.parseInt(JOptionPane.showInputDialog("Insira o id da sala da sessao: "));
        String idAnima = JOptionPane.showInputDialog("Insira o id da animacao da sessao: ");
        Sessao sessao = new Sessao(id , idSala, idAnima);
        ControllerSessao contSessao = new ControllerSessao();
        Sessao sessaoOut = contSessao.alterar(sessao);
        JOptionPane.showMessageDialog(null,sessaoOut.toString());
        Cinema.main(null);
    }

    private static void buscar()throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID da sessao: "));
        Sessao sessao = new Sessao(id);
        ControllerSessao contSessao = new ControllerSessao();
        Sessao sessaoOut = contSessao.buscar(sessao);
        JOptionPane.showMessageDialog(null,sessaoOut.toString());
        Cinema.main(null);
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID da sessao: "));
        Sessao sessao = new Sessao(id);
        ControllerSessao contSessao = new ControllerSessao();
        Sessao sessaoOut = contSessao.excluir(sessao);
        JOptionPane.showMessageDialog(null,sessaoOut.toString());
        Cinema.main(null);
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String id = JOptionPane.showInputDialog("Insira o id da animacao da sessao: ");
        Sessao sessao = new Sessao(id);
        ControllerSessao contSessao = new ControllerSessao();
        List<Sessao> listaSessao = contSessao.listar(sessao);
        for (Sessao sessaoOut: listaSessao){
            JOptionPane.showMessageDialog(null,sessaoOut.toString());
        }
        Cinema.main(null);
    }
}