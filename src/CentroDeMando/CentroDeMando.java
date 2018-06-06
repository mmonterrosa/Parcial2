/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CentroDeMando;

/**
 *
 * @author MMont
 */
public class CentroDeMando {
    private int nivel = 0;
    private int vida = 500;
    
    private int oroMax=10000;
    private int plataMax=5000;
    private int cobreMax=3000;
    private int cantOroActual=100;
    private int cantPlataActual=100;
    private int cantCobreActual=0;

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getOroMax() {
        return oroMax;
    }

    public void setOroMax(int oroMax) {
        this.oroMax = oroMax;
    }

    public int getPlataMax() {
        return plataMax;
    }

    public void setPlataMax(int plataMax) {
        this.plataMax = plataMax;
    }

    public int getCobreMax() {
        return cobreMax;
    }

    public void setCobreMax(int cobreMax) {
        this.cobreMax = cobreMax;
    }

    public int getCantOroActual() {
        return cantOroActual;
    }

    public void setCantOroActual(int cantOroActual) {
        this.cantOroActual = cantOroActual;
    }

    public int getCantPlataActual() {
        return cantPlataActual;
    }

    public void setCantPlataActual(int cantPlataActual) {
        this.cantPlataActual = cantPlataActual;
    }

    public int getCantCobreActual() {
        return cantCobreActual;
    }

    public void setCantCobreActual(int cantCobreActual) {
        this.cantCobreActual = cantCobreActual;
    }
      
    
    
    
    
    
    
    
}
