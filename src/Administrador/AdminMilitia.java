/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import Militia.Militia;
import java.util.ArrayList;

/**
 *
 * @author MMont
 */
public class AdminMilitia implements Administrador<Militia>{
     public ArrayList<Militia> ListaDeMilitia= new ArrayList();

    public AdminMilitia() {
        ListaDeMilitia= new ArrayList();
    }
     

    @Override
    public void add(Militia p) throws Exception {
        ListaDeMilitia.add(p);
    
    }

    @Override
    public void change(Militia p) throws Exception {
    
    }

    @Override
    public void delete(Militia p) throws Exception {
    ListaDeMilitia.remove(p);
    }

    @Override
    public void show(Militia p) throws Exception {
        System.out.println(p.toString());
    
    }

    @Override
    public void showAll() throws Exception {
    for(Militia m : ListaDeMilitia){
        System.out.println(m.toString());
        }
    }

    @Override
    public ArrayList<Militia> getLista() throws Exception {
    return this.ListaDeMilitia;
    }

    @Override
    public void setLista(ArrayList<Militia> x) throws Exception {
     this.ListaDeMilitia= x;
    }

    
}
