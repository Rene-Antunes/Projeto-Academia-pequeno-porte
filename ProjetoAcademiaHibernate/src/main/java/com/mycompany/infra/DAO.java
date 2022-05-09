/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tiago
 */
public class DAO<E> {
    private static EntityManagerFactory emf ;
    private EntityManager em;
    private Class<E> classe;
    
    static {
        
        try {
            emf = Persistence
                    .createEntityManagerFactory("academiaup");
        } catch (Exception e) {
            
        }
    
    }

    public DAO() {
        this(null);
    }
    
    public DAO(Class<E> classe) {
        this.classe = classe;
        em = emf.createEntityManager();
    }
     
    public DAO<E> openConetion(){
        em.getTransaction().begin();
        return this;
    
    }
    
    public DAO<E> closeConetion(){
        em.getTransaction().commit();
        return this;
        
    }
    
    public DAO<E> insert(E entidade){
        em.persist(entidade);
        
       return this;

    }
    
    public DAO<E> atomicInsert(E entidade){
        return this.openConetion().insert(entidade).closeConetion();
    
    }
    
    
    
    public void close(){
        em.close();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Class<E> getClasse() {
        return classe;
    }

    public void setClasse(Class<E> classe) {
        this.classe = classe;
    }
   
    
}
