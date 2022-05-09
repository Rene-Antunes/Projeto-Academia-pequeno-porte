/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.infra;


import com.mycompany.models.Usuario;


/**
 *
 * @author tiago
 */
public class TesteHibernate {
    public static void main(String[] args) {
        
//        EntityManager em = new DAO().getEntityManager();
//        em.getTransaction().begin();
//        
//        Usuario user = new Usuario("Cristina", "1234");
//        em.persist(user);
//            
//        em.getTransaction().commit();
//        em.close();
      
        Usuario user = new Usuario("Nenel", "1234", "Emanoel");
        
        DAO<Usuario> userDAO = new DAO<>(Usuario.class);
        
        userDAO.atomicInsert(user).close();
        
      
        
        
       

    }
}
