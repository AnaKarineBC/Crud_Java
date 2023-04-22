/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.view;

import cinema.Cinema;
import cinema.controller.ControllerSala;
import cinema.model.bean.Sala;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ana
 */
public class ManterSala {
    
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
        String CapSala = JOptionPane.showInputDialog("Insira a capacidade da sala: ");
        Sala sala = new Sala(CapSala);
        ControllerSala contSala = new ControllerSala();
        Sala salaOut = contSala.inserir(sala);
        JOptionPane.showMessageDialog(null,salaOut.toString());
        Cinema.main(null);
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID da sala: "));
        String CapSala = JOptionPane.showInputDialog("Insira a capacidadeda sala: ");
        Sala sala = new Sala(id , CapSala);
        ControllerSala contSala = new ControllerSala();
        Sala salaOut = contSala.alterar(sala);
        JOptionPane.showMessageDialog(null,salaOut.toString());
        Cinema.main(null);
    }

    private static void buscar()throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID da sala: "));
        Sala sala = new Sala(id);
        ControllerSala contSala = new ControllerSala();
        Sala salaOut = contSala.buscar(sala);
        JOptionPane.showMessageDialog(null,salaOut.toString());
        Cinema.main(null);
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID da sala: "));
        Sala sala = new Sala(id);
        ControllerSala contSala = new ControllerSala();
        Sala salaOut = contSala.excluir(sala);
        JOptionPane.showMessageDialog(null,salaOut.toString());
        Cinema.main(null);
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String salaCap = JOptionPane.showInputDialog("Insira a capacidade da sala: ");
        Sala sala = new Sala(salaCap);
        ControllerSala contSala = new ControllerSala();
        List<Sala> listaSala = contSala.listar(sala);
        for (Sala salaOut: listaSala) {
            JOptionPane.showMessageDialog(null,salaOut.toString());
        }
        Cinema.main(null);
    }
}
