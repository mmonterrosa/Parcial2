/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import Vehiculos.EdifVehiculos;
import java.util.ArrayList;

/**
 *
 * @author MMont
 */
public class AdminEdificioVehiculos implements Administrador<EdifVehiculos>{
    public ArrayList<EdifVehiculos> ListaEdificiosVehiculos;

    public AdminEdificioVehiculos() {
        ListaEdificiosVehiculos = new ArrayList();
        
    }

    @Override
    public void add(EdifVehiculos p) throws Exception {
     ListaEdificiosVehiculos.add(p);
    }

    @Override
    public void change(EdifVehiculos p) throws Exception {
    
    }

    @Override
    public void delete(EdifVehiculos p) throws Exception {
        ListaEdificiosVehiculos.remove(p);
    }

    @Override
    public void show(EdifVehiculos p) throws Exception {
     System.out.println(p.toString());
    }

    @Override
    public void showAll() throws Exception {
    for(EdifVehiculos p : ListaEdificiosVehiculos){
                System.out.println(p.toString());
            } 
    }

    @Override
    public ArrayList<EdifVehiculos> getLista() throws Exception {
    return this.ListaEdificiosVehiculos;
    }
    
 
    
}
