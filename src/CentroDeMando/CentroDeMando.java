/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CentroDeMando;

import Administrador.Administrador;
import EdificacionRecursos.EdifRecursos;
import EntrenamientoMilitia.Cuartel;
import Factories.AbstractFactory;
import Factories.FactoryProducer;
import Militia.Militia;
import Vehiculos.EdifVehiculos;
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
    
    private int cantOroActual=50000;
    private int cantPlataActual=100000;
    private int cantCobreActual=200000;
    
    public Administrador AdminRecursos;
    public Administrador AdminVehiculos;
    public Administrador AdminMilitia;
    public Militia Especialista;
    
    public Cuartel cuartel;
    
    public ArrayList<EdifRecursos> pendingEdifRecursos = new ArrayList<>();
    public ArrayList<EdifVehiculos> pendingEdifVehiculos = new ArrayList<>();
    public ArrayList<Militia> pendingMilitia = new ArrayList<>();
    public Militia pendingEspecialista= null;
    
    public Cuartel pendingCuartel;
    
    //public ArrayList<Militia> militiaEnAtaqueDeRecursos = new ArrayList<>();

    
    public CentroDeMando(){
        AbstractFactory factory = FactoryProducer.getFactory("Administrador");
        this.AdminRecursos=factory.getAdministrador("Recursos");
        this.AdminVehiculos=factory.getAdministrador("Vehiculos");
        this.AdminMilitia=factory.getAdministrador("Militia");
        this.Especialista = null;
        this.cuartel=null;
        
        
    }
    
       public void addPendingEdif(){
        for (int i =0;i<pendingEdifRecursos.size();i++){
            if (pendingEdifRecursos.get(i).getFaseImplementacion() == Menu.fase){
                try{
                AdminRecursos.add(pendingEdifRecursos.get(i));
                    System.out.println("Se Construyo Una Edificacion de Recursos Y Ahora Esta Activa! ");
                pendingEdifRecursos.remove(pendingEdifRecursos.get(i));
                i-=1;
                }
                catch (Exception e){
                    System.err.println("No se pudo Agregar!");
                }
            }
        }
        
        
        for (int i =0;i<pendingEdifVehiculos.size();i++){
            if (pendingEdifVehiculos.get(i).getFaseImplementacion() == Menu.fase){
                try{
                AdminVehiculos.add(pendingEdifVehiculos.get(i));
                System.out.println("Se Construyo Una: " + pendingEdifVehiculos.get(i).getNombre() + " Y Ahora Esta Activo!");
                pendingEdifVehiculos.remove(pendingEdifVehiculos.get(i));
                i-=1;
                }
                catch (Exception e){
                    System.err.println("No se pudo Agregar!");
                }
            }
        }
        

        for (int i =0;i<pendingMilitia.size();i++){
            if (pendingMilitia.get(i).getFaseImplementacion() == Menu.fase){
                try{
                    System.out.println(i);
                    AdminMilitia.add(pendingMilitia.get(i));
                    System.out.println( pendingMilitia.get(i).getNombre() + " Termino de Entrenar Y Ahora Esta Activo!");
                
                    pendingMilitia.remove(pendingMilitia.get(i));
                    i-=1;
                }
                catch (Exception e){
                    System.err.println("No se pudo Agregar de pending militia a admin militia o no se pudo remover!");
                }
            }
        }
        
        if((this.pendingEspecialista!=null)&&(this.pendingEspecialista.getFaseImplementacion() == Menu.fase)){
            this.Especialista =this.pendingEspecialista;
            this.pendingEspecialista=null;
            System.out.println( Especialista.getNombre() + " Termino de Entrenar Y Ahora Esta Activo!");
        }
        
        if((this.pendingCuartel!=null)&&(this.pendingCuartel.getFaseImplementacion() == Menu.fase)){
            this.cuartel =this.pendingCuartel;
            this.pendingCuartel=null;
        }
        
        
      
    }

       public void Atacar(Jugador enemigo) {
           
           try{
               //AtacarRecursos
               
               //Si la lista de Recursos del enemigo esta vacia, se regresan al cuartel
               if(enemigo.centrodemando.AdminRecursos.getLista().isEmpty()){
                   ArrayList<Militia> arm2 = this.AdminMilitia.getLista();
                   for (Militia m : arm2){
                    if (m.getEstadoAtacando()==1){
                        m.setEstadoAtacando(0);
                        this.AdminMilitia.setLista(arm2);  
                        System.out.println("La Militia Ha Destruido Todas las Edificaciones, Y Ahora Retornaran Al Cuartel!");
                        }
                   }
                   this.Especialista.setEstadoAtacando(0);
                   
                   
               }else{
                   
           ArrayList<Militia> arm = this.AdminMilitia.getLista();
           ArrayList<EdifRecursos> aux1 =  enemigo.centrodemando.AdminRecursos.getLista();
           for (Militia m : arm){
               if (m.getEstadoAtacando()==1){
                   //ArrayList<EdifRecursos> aux1 =  enemigo.centrodemando.AdminRecursos.getLista();
                   aux1.get(0).setVida(aux1.get(0).getVida()-m.Atacar());
                   //enemigo.centrodemando.AdminRecursos.setLista(aux1);

               }
                   
            }
           if((this.Especialista!=null)&&(this.Especialista.getEstadoAtacando()==1))aux1.get(0).setVida(aux1.get(0).getVida()-this.Especialista.Atacar());
           enemigo.centrodemando.AdminRecursos.setLista(aux1);
               }
               
               //AtacarVehiculos
               
           
           
           }catch(Exception e){
               
           }
           
       }
       public void cleanListasEdif(){
           try{
           ArrayList<EdifRecursos> aux1 =  AdminRecursos.getLista();
           if(aux1.get(0).getVida()<=0){
               this.AdminRecursos.delete(this.AdminRecursos.getLista().get(0));
               
            }
           
           }catch(Exception e){
               
           }
       }
     

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

    public ArrayList<EdifRecursos> getPendingEdifRecursos() {
        return pendingEdifRecursos;
    }

    public ArrayList<EdifVehiculos> getPendingEdifVehiculos() {
        return pendingEdifVehiculos;
    }
    
    
 
}
