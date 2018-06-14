/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntrenamientoMilitia;

import parcial2.Menu;

/**
 *
 * @author MMont
 */
public class Cuartel {

    int vida=500;
    String nombre = "Cuartel";
    int fasesEspera;
    int faseDeImplementacion;
    private static Cuartel instance;
    
    private Cuartel() {
    }

    private Cuartel(int fasesEspera) {
        this.fasesEspera = fasesEspera;
        this.faseDeImplementacion = Menu.fase + fasesEspera;
    }
    
    public synchronized static Cuartel getInstanced(int fasesEspera){
        if(instance ==null){
            instance = new Cuartel(fasesEspera);
        }
        return instance;
    }

    public int getFaseImplementacion() {
        return faseDeImplementacion;
    }
    
    
}
