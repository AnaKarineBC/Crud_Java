/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.view;

import cinema.Cinema;
import cinema.controller.ControllerAnimacao;
import cinema.model.bean.Animacao;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ana
 */
public class ManterAnimacao {
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
        String nome = JOptionPane.showInputDialog("Insira o nome da animacao: ");
        String ano = JOptionPane.showInputDialog("Insira o ano da animacao: ");
        
        Animacao animacao = new Animacao(nome, ano);
        ControllerAnimacao contAnimacao = new ControllerAnimacao();
        Animacao animacaoOut = contAnimacao.inserir(animacao);
        JOptionPane.showMessageDialog(null,animacaoOut.toString());
        Cinema.main(null);
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID da animacao: "));
        String nome = JOptionPane.showInputDialog("Insira o nome da animacao: ");
        String ano = JOptionPane.showInputDialog("Insira o ano da animacao: ");
        
        Animacao animacao = new Animacao(id, nome, ano);
        ControllerAnimacao contAnimacao = new ControllerAnimacao();
        Animacao animacaoOut = contAnimacao.alterar(animacao);
        JOptionPane.showMessageDialog(null,animacaoOut.toString());
        Cinema.main(null);
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID da animacao: "));
        Animacao animacao = new Animacao(id);
        ControllerAnimacao  contAnimacao = new ControllerAnimacao();
        Animacao animacaoOut = contAnimacao.buscar(animacao);
        JOptionPane.showMessageDialog(null,animacaoOut.toString());
        Cinema.main(null);
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID da animacao: "));
        Animacao animacao = new Animacao(id);
        ControllerAnimacao  contAnimacao = new ControllerAnimacao();
        Animacao animacaoOut = contAnimacao.excluir(animacao);
        JOptionPane.showMessageDialog(null,animacaoOut.toString());
        Cinema.main(null);
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Nome da animacao: ");
        Animacao animacao = new Animacao(nome);
        ControllerAnimacao contAnimacao = new ControllerAnimacao();
        List<Animacao> listaAnimacao = contAnimacao.listar(animacao);
        for(Animacao animacaoOut : listaAnimacao ){
            JOptionPane.showMessageDialog(null,animacaoOut.toString());
            Cinema.main(null);
        }
    }
}
