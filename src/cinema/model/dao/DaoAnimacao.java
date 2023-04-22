/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.model.dao;

import cinema.model.bean.Animacao;
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
public class DaoAnimacao {

    private final Connection c;
    
    public DaoAnimacao() throws SQLException, ClassNotFoundException {
        this.c = ConexaoDb.getConexaoMySQL();
    }
    
    public Animacao excluir(Animacao animacao) throws SQLException{
        String sql = "delete from animacao WHERE id_animacao = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,animacao.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return animacao;
    }
    
    public Animacao buscar(Animacao animacao) throws SQLException{
        String sql = "select * from animacao WHERE id_animacao = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,animacao.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Animacao animacaoOut = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                animacaoOut = new Animacao(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return animacaoOut;
   }

    public Animacao inserir(Animacao animacao) throws SQLException{
        String sql = "insert into animacao" + " (nome, ano)" + " values (?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,animacao.getNome());
        stmt.setString(2,animacao.getAno());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            animacao.setId(id);
        }
        stmt.close();
        return animacao;
    }

    public Animacao alterar(Animacao animacao) throws SQLException{
        String sql = "UPDATE animacao SET nome = ?, ano = ? WHERE id_animacao = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,animacao.getNome());
        stmt.setString(2,animacao.getAno());
        stmt.setInt(3,animacao.getId());

        // executa
        stmt.execute();
        stmt.close();
        return animacao;
    }

   public List<Animacao> listar(Animacao animacao) throws SQLException{
        // usus: array armazena a lista de registros

        List<Animacao> animas = new ArrayList<>();
        
        String sql = "select * from animacao where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + animacao.getNome() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Animacao anima = new Animacao(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3));
            // adiciona o usu à lista de usus
            animas.add(anima);
        }
        
        rs.close();
        stmt.close();
        return animas;
   
   }

    
}
