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
    private int vida = 500;
    
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
           int aux = 0;
        for (int i =0;i<pendingEdifRecursos.size();i++){
            if (pendingEdifRecursos.get(i).getFaseImplementacion() == Menu.fase){
                try{
                AdminRecursos.add(pendingEdifRecursos.get(i));
                   // System.out.println("Se Construyo Una Edificacion de Recursos Y Ahora Esta Activa! ");
                    aux++;
                pendingEdifRecursos.remove(pendingEdifRecursos.get(i));
                i-=1;
                }
                catch (Exception e){
                    System.err.println("No se pudo Agregar!");
                }
            }
        }
        if (aux!=0)System.out.println("Se Construyeron: " + aux +" Edificacion de Recursos Y Ahora Estan Activa! ");
        
        aux=0;
        for (int i =0;i<pendingEdifVehiculos.size();i++){
            if (pendingEdifVehiculos.get(i).getFaseImplementacion() == Menu.fase){
                try{
                AdminVehiculos.add(pendingEdifVehiculos.get(i));
                //System.out.println("Se Construyo Una: " + pendingEdifVehiculos.get(i).getNombre() + " Y Ahora Esta Activo!");
                aux++;
                pendingEdifVehiculos.remove(pendingEdifVehiculos.get(i));
                i-=1;
                }
                catch (Exception e){
                    System.err.println("No se pudo Agregar!");
                }
            }
        }
        if (aux!=0)System.out.println("Se Construyo:" +aux+ "Vehiculos Y Ahora Estan Activo!");
                
        
         aux=0;
        for (int i =0;i<pendingMilitia.size();i++){
            if (pendingMilitia.get(i).getFaseImplementacion() == Menu.fase){
                try{
                    System.out.println(i);
                    AdminMilitia.add(pendingMilitia.get(i));
                    //System.out.println( pendingMilitia.get(i).getNombre() + " Termino de Entrenar Y Ahora Esta Activo!");
                    aux++;
                    pendingMilitia.remove(pendingMilitia.get(i));
                    i-=1;
                }
                catch (Exception e){
                    System.err.println("No se pudo Agregar de pending militia a admin militia o no se pudo remover!");
                }
            }
        }
        if(aux!=0)System.out.println(aux +" Escuadrones Terminaron de Entrenar Y Ahora Estan Activos!");
                    
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

       public void AtacarRecursos(Jugador enemigo) {
           
           try{
               //AtacarRecursos
               //Si hay militita y el enemigo no tiene edif recursos
               if(!(this.AdminMilitia.getLista().isEmpty())&&(enemigo.centrodemando.AdminRecursos.getLista().isEmpty())){
                   ArrayList<Militia> arm2 = this.AdminMilitia.getLista();
                   for (Militia m : arm2){
                    if (m.getEstadoAtacando()==1){
                        //Que ataque a Vehiculos
                        m.setEstadoAtacando(2);
                        this.AdminMilitia.setLista(arm2);  
                        
                        }
                   }
                   
                   if(this.Especialista!=null){
                       this.Especialista.setEstadoAtacando(2);
                       System.out.println("El Especialista ahora ataca Vehiculos");
                   }
                   
                  
               }
               
             //Si hay militia y  el enemigo tiene edif recursos
               else if (!(this.AdminMilitia.getLista().isEmpty())&&!(enemigo.centrodemando.AdminRecursos.getLista().isEmpty())){
                   
           ArrayList<Militia> arm = this.AdminMilitia.getLista();
           //ArrayList<EdifRecursos> aux1 =  enemigo.centrodemando.AdminRecursos.getLista();
           for (Militia m : arm){
               if (m.getEstadoAtacando()==1){
                   ArrayList<EdifRecursos> aux1 =  enemigo.centrodemando.AdminRecursos.getLista();
                   aux1.get(0).setVida(aux1.get(0).getVida()-m.Atacar());
                   if(aux1.get(0).getVida()<=0)  aux1.remove(0);
                   enemigo.centrodemando.AdminRecursos.setLista(aux1);
                   if(enemigo.centrodemando.AdminRecursos.getLista().isEmpty())break;

               }
                   
            }
          /* 
           ArrayList<EdifRecursos> aux1 =  enemigo.centrodemando.AdminRecursos.getLista();
           if(!(aux1.isEmpty())&&(this.Especialista!=null)&&(this.Especialista.getEstadoAtacando()==1))aux1.get(0).setVida(aux1.get(0).getVida()-this.Especialista.Atacar());
           enemigo.centrodemando.AdminRecursos.setLista(aux1);
            */
               }
            
            ArrayList<EdifRecursos> aux1 =  enemigo.centrodemando.AdminRecursos.getLista();
           if(!(aux1.isEmpty())&&(this.Especialista!=null)&&(this.Especialista.getEstadoAtacando()==1))aux1.get(0).setVida(aux1.get(0).getVida()-this.Especialista.Atacar());
           enemigo.centrodemando.AdminRecursos.setLista(aux1);
             
           }catch(Exception e){
               
           }
              
           
       }
       
       public void AtacarVehiculos(Jugador enemigo){
           try{
               
               //AtacarVehiculos
               //Si Hay Militia y la lista de Vehiculos del enemigo esta vacia
               if(!(this.AdminMilitia.getLista().isEmpty())&&(enemigo.centrodemando.AdminVehiculos.getLista().isEmpty())){
                   ArrayList<Militia> arm2 = this.AdminMilitia.getLista();
                   for (Militia m : arm2){
                       //Si militia esta atacando vehiculos
                    if (m.getEstadoAtacando()==2){
                        //militia ataca a centro de mando
                        m.setEstadoAtacando(3);
                        this.AdminMilitia.setLista(arm2);
                        this.Especialista.setEstadoAtacando(3);
                        System.out.println("Escuadron Ha Destruido Todas los Vehiculos, Y Ahora Atacaran Al Centro de Mando!");
                        }
   
                   }

                  //Si Hay Militia Si el enemigo tiene vehiculos  
               }else if(!(this.AdminMilitia.getLista().isEmpty())&&!(enemigo.centrodemando.AdminVehiculos.getLista().isEmpty())){
                   
           ArrayList<Militia> arm = this.AdminMilitia.getLista();
           
           for (Militia m : arm){
               ArrayList<EdifVehiculos> aux1 =  enemigo.centrodemando.AdminVehiculos.getLista();
               if (m.getEstadoAtacando()==2){
                   //ArrayList<EdifRecursos> aux1 =  enemigo.centrodemando.AdminRecursos.getLista();
                   aux1.get(0).setVida(aux1.get(0).getVida()-m.Atacar());
                   if(aux1.get(0).getVida()<=0) aux1.remove(0);
                   enemigo.centrodemando.AdminVehiculos.setLista(aux1);
                   if(aux1.isEmpty())break;

               }
                   
            }
           
           
               }
               
              
               ArrayList<EdifVehiculos> aux2 =  enemigo.centrodemando.AdminVehiculos.getLista();
           if(!(aux2.isEmpty())&&(this.Especialista!=null)&&(this.Especialista.getEstadoAtacando()==2))aux2.get(0).setVida(aux2.get(0).getVida()-this.Especialista.Atacar());
           enemigo.centrodemando.AdminVehiculos.setLista(aux2);
               
           }catch(Exception e){
               
           }
       }
       public void AtacarCentroDeMando(Jugador enemigo){
           try{
               //Si la lista de recursos contiene un edif recursos nuevo
               if(!(enemigo.centrodemando.AdminRecursos.getLista().isEmpty())){
                   ArrayList<Militia> aux = AdminMilitia.getLista();
                   for(Militia m : aux){
                       //Hacemos que la militia ataque a este primero
                        if(m.getEstadoAtacando()!=0)m.setEstadoAtacando(1);
                        this.AdminMilitia.setLista(aux);
                    }
                   
               }
               
               //Si la lista de vehiculos contiene un vehiculo nuevo
               else if(!(enemigo.centrodemando.AdminVehiculos.getLista().isEmpty())){
                   ArrayList<Militia> aux = AdminMilitia.getLista();
                   for(Militia m : aux){
                       //Hacemos que la militia ataque a este primero
                        if(m.getEstadoAtacando()!=0)m.setEstadoAtacando(2);
                        this.AdminMilitia.setLista(aux);
                    }
               }
               
               else if((enemigo.centrodemando.AdminRecursos.getLista().isEmpty())&&(enemigo.centrodemando.AdminVehiculos.getLista().isEmpty())){
               ArrayList<Militia> aux = AdminMilitia.getLista();
               for(Militia m : aux){
                   if(m.getEstadoAtacando()==3)enemigo.centrodemando.vida -= m.Atacar(); 
               }
               if(enemigo.centrodemando.vida<=0){
                   System.out.println(enemigo.nombre + "Ha Perdido");
                   System.exit(0);
               }
           }
               
               }catch(Exception e){
                   
               }
       }
       
       public void cleanListasEdif(){
           try{
               
               //Eliminamos Edif Recursos destruidos con 0 vida
           ArrayList<EdifRecursos> aux1 =  AdminRecursos.getLista();
           if(aux1.get(0).getVida()<=0){
               this.AdminRecursos.delete(this.AdminRecursos.getLista().get(0));
            }
           
           //Eliminamos Edif Vehiculos destruidos con 0 vida
            ArrayList<EdifVehiculos> aux2 =  this.AdminVehiculos.getLista();
           if(aux2.get(0).getVida()<=0){
               this.AdminVehiculos.delete(this.AdminVehiculos.getLista().get(0));
            }
           
           }catch(Exception e){
               
           }
       }
     

    public void Recolectar( ){
        ArrayList<EdifRecursos> auxrecolect = new ArrayList();
        try{
                this.AdminRecursos.showAll();
        auxrecolect = AdminRecursos.getLista();
        
        if(!auxrecolect.isEmpty()){
         for (EdifRecursos er : auxrecolect){
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
         
         
        } catch(Exception e){
            System.out.println("no se pudo pasar la lista de recursos linea 320" + e.getMessage());
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
