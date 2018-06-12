/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CentroDeMando;

import Administrador.Administrador;
import EdificacionRecursos.EdifRecursos;
import Factories.AbstractFactory;
import Factories.FactoryProducer;
import java.util.ArrayList;
import parcial2.Jugador;
import parcial2.Menu;

/**
 *
 * @author MMont
 */
public class CentroDeMando {
   
    
    private int nivel = 0;
    private int vida = 2500;
    
    private int oroMax=10000;
    private int plataMax=5000;
    private int cobreMax=3000;
    
    private int cantOroActual=50;
    private int cantPlataActual=100;
    private int cantCobreActual=200;
    
    public Administrador AdminRecursos;
    
    public ArrayList<EdifRecursos> pendingEdifRecursos = new ArrayList<>();
    
    
    public CentroDeMando(){
        AbstractFactory factory = FactoryProducer.getFactory("Administrador");
        this.AdminRecursos=factory.getAdministrador("Recursos");
        
        
    }
    
       public void addPendingEdif(){
        for (int i =0;i<pendingEdifRecursos.size();i++){
            if (pendingEdifRecursos.get(i).getFaseImplementacion() == Menu.fase){
                try{
                AdminRecursos.add(pendingEdifRecursos.get(i));
                pendingEdifRecursos.remove(pendingEdifRecursos.get(i));
                }
                catch (Exception e){
                    System.err.println("No se pudo Agregar!");
                }
            }
        }
      
    }

    /*
     public void addPendingEdif(){
        for (int i =0;i<pendingEdifRecursos.size();i++){
            System.out.println("Fase De Implementacion: " + pendingEdifRecursos.get(i).getFaseImplementacion());
             
    }
     }
*/
    public void Recolectar( ){
        ArrayList<EdifRecursos> aux = new ArrayList();
        try{
        aux = AdminRecursos.getLista();
        } catch(Exception e){
            System.out.println("no se pudo pasar la lista de recursos");
        }
        
        for (EdifRecursos er : aux){
            if (er.getNombre()=="Edificacion de Cobre"){
                this.cantCobreActual += er.recolectar();
            }
            if (er.getNombre()=="Edificacion de Plata"){
                this.cantPlataActual += er.recolectar();
            }
            if (er.getNombre()=="Edificacion de Oro"){
                this.cantOroActual += er.recolectar();
            }

        }
    }
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
