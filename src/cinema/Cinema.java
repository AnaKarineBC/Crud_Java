/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cinema;

import cinema.view.ManterAnimacao;
import cinema.view.ManterSala;
import cinema.view.ManterSessao;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ana
 */
public class Cinema {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String msg = " 0 - Sair \n 1 - Sessao \n 2 - Sala \n 3 - Animacao";
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));

        switch (num) {
            case 0:
                int sair = JOptionPane.showConfirmDialog(null,"Deseja Sair");
                if (sair > 0) Cinema.main(null);
                break;
            case 1:
                ManterSessao.menu();
                break;
            case 2:
                ManterSala.menu();
                break;
            case 3:
                ManterAnimacao.menu();
                break;

            default:
                System.out.println("Opção inválido");
      
        }
   }     
}
