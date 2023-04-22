/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.model.bean;

/**
 *
 * @author Ana
 */
public class Sala {
    private int id;
    private String capacidade;

     public Sala(int id) {
        this.id = id;
    }

    
    public Sala(String capacidade) {
        this.capacidade = capacidade;
    }
    
    public Sala(int id, String capacidade) {
        this.id = id;
        this.capacidade = capacidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public String toString() {
        return "Sala{" + "id=" + id + ", capacidade=" + capacidade + '}';
    }
    
}
