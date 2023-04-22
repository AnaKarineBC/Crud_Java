/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.model.dao;

import cinema.model.bean.Sala;
import cinema.util.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ana
 */
public class DaoSala {
private final Connection c;
    
    public DaoSala() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }
    
  public Sala excluir(Sala sala) throws SQLException{
        String sql = "delete from sala WHERE id_sala = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,sala.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return sala;
    }
    
    public Sala buscar(Sala sala) throws SQLException{
        String sql = "select * from sala WHERE id_sala = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,sala.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Sala salaOut = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                salaOut = new Sala(
                    rs.getInt(1),
                    rs.getString(2));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return salaOut;
   }

    public Sala inserir(Sala sala) throws SQLException{
        String sql = "insert into sala" + " (capacidade)" + " values (?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,sala.getCapacidade());
        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            sala.setId(id);
        }
        stmt.close();
        return sala;
    }

    public Sala alterar(Sala sala) throws SQLException{
        String sql = "UPDATE sala SET capacidade = ? WHERE id_sala = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,sala.getCapacidade());
        stmt.setInt(2,sala.getId());

        // executa
        stmt.execute();
        stmt.close();
        return sala;
    }

   public List<Sala> listar(Sala sala) throws SQLException{
        // usus: array armazena a lista de registros

        List<Sala> listasala = new ArrayList<>();
        
        String sql = "select * from sala where capacidade like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + sala.getCapacidade() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Sala sal = new Sala(
                rs.getInt(1),
                rs.getString(2)
            );
            // adiciona o usu à lista de usus
            listasala.add(sal);
        }
        
        rs.close();
        stmt.close();
        return listasala;
   
   }

    
}
