/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.model.dao;

import cinema.model.bean.Sessao;
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
public class DaoSessao {
    private final Connection c;
    
    public DaoSessao() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }
    
  public Sessao excluir(Sessao sessao) throws SQLException{
        String sql = "delete from sessao WHERE id_sessao = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,sessao.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return sessao;
    }
    
    public Sessao buscar(Sessao sessao) throws SQLException{
        String sql = "select * from sessao WHERE id_sessao= ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,sessao.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Sessao sessaoOut = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                sessaoOut = new Sessao(
                    rs.getInt(1),
                    rs.getInt(2),
                       rs.getString(3));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return sessaoOut;
   }

    public Sessao inserir(Sessao sessao) throws SQLException{
        String sql = "insert into sessao" + " (id_sala, id_animacao)" + " values (?,?)";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            // seta os valores
           stmt.setInt(1,sessao.getIdSala());
           stmt.setString(2,sessao.getIdAnima());
            // executa
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                sessao.setId(id);
            }
            stmt.close();
        return sessao;
    }

    public Sessao alterar(Sessao sessao) throws SQLException{
        String sql = "UPDATE sessao SET id_sala = ?, id_animacao = ? WHERE id_sessao = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,sessao.getIdSala());
            stmt.setString(2,sessao.getIdAnima());
            stmt.setInt(3,sessao.getId());
            // executa
            stmt.execute();
            stmt.close();
        return sessao;
    }

   public List<Sessao> listar(Sessao sessao) throws SQLException{
        // usus: array armazena a lista de registros

        List<Sessao> listasessao = new ArrayList<>();
        
        String sql = "select * from sessao where id_animacao like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + sessao.getIdAnima() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Sessao ses= new Sessao(
                rs.getInt(1),
                rs.getInt(2),
                    rs.getString(3)
            );
            // adiciona o usu à lista de usus
            listasessao.add(ses);
        }
        
        rs.close();
        stmt.close();
        return listasessao;
   
   }
}
