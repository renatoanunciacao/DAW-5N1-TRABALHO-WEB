/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Renato
 */
public class EntityManagerUtil {
    private static EntityManagerFactory emf = null;
    private static javax.persistence.EntityManager em = null;
    
    public static javax.persistence.EntityManager getEntityManager(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("DAW-5N1-TRABALHO-2017-2-PU");
        }
        if(em == null){
            em = emf.createEntityManager();
        }
        return em;
    }
}
