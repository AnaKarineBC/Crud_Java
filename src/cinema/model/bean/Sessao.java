/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.model.bean;

/**
 *
 * @author Ana
 */
public class Sessao {
    private int id;
    private int idSala;
    private String idAnima;
    private Animacao animacao;
    private Sala sala;

    public Sessao(int id) {
        this.id = id;
    }

    public Sessao(String idAnima) {
        this.idAnima = idAnima;
    }
    
    public Sessao(int id, int idSala, String idAnima) {
        this.id = id;
        this.idSala = idSala;
        this.idAnima = idAnima;
    }

    public Sessao(int idSala, String idAnima) {
        this.idSala = idSala;
        this.idAnima = idAnima;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public String getIdAnima() {
        return idAnima;
    }

    public void setIdAnima(String idAnima) {
        this.idAnima = idAnima;
    }

    public Animacao getAnimacao() {
        return animacao;
    }

    public void setAnimacao(Animacao animacao) {
        this.animacao = animacao;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Sessao \n" + "id: " + id + ", idSala:" + idSala + ", idAnima:" + idAnima ;
    }

    
    
    
}
