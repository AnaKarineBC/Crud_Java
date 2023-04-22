/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.model.bean;

/**
 *
 * @author Ana
 */
public class Animacao {
    private int id;
    private String nome;
    private String ano;

    public Animacao(int id) {
        this.id = id;
    }

    public Animacao(String nome) {
        this.nome = nome;
    }

    public Animacao(int id, String nome, String ano) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
    }

    public Animacao(String nome, String ano) {
        this.nome = nome;
        this.ano = ano;
    }

    public Animacao(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Animacao{" + "id=" + id + ", nome=" + nome + ", ano=" + ano + '}';
    }

    
    
}
