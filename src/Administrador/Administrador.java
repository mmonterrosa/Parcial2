/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import java.util.ArrayList;

/**
 *
 * @author MMont
 */
public interface Administrador<E> {
     void add(E p) throws Exception;
     void change(E p) throws Exception;
     void delete(E p) throws Exception;
     void show(E p) throws Exception;
     void showAll() throws Exception;
     ArrayList<E> getLista() throws Exception;
}