/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.infra;

import com.mycompany.models.Professor;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author renea
 */
public class ProfDAO extends DAO<Professor>{

    public ProfDAO() {
        super(Professor.class);
    }
    
     public List<Professor> selectAll(){
         
        String jpql = "Select u from Professor as u";
        Query query = getEm().createQuery(jpql);
        List<Professor> professores = query.getResultList();
        return professores;
    
    }
     
    public List<Professor> getProfPorNome(Professor professor){
        	
        String jpql = "Select p from Professor as p "
                + "where  p.nome LIKE :pProfessor";
        
        Query query = getEm().createQuery(jpql);
        query.setParameter("pProfessor", professor + "%");
       
        
        
        List<Professor> professores = query.getResultList();
        
        return professores;
    
    }
    
    public Professor alterarProfId(Professor professor){
    
        try {
            getEm().getTransaction().begin();
            
            if (professor.getId() == null) {
                getEm().persist(professor);
            }else{
                getEm().merge(professor);
            
            }
            getEm().getTransaction().commit();
        } catch (Exception e) {
            getEm().getTransaction().rollback();
        }finally{
            
            getEm().close();
        
        }
        
        return professor;
   
    }
    
    
    public Professor removerProf(Professor profId){
        Professor prof = null;
       
        try {
            prof = getEm().find(Professor.class, profId.getId());
            getEm().getTransaction().begin();
            getEm().remove(prof);
            getEm().getTransaction().commit();
            
        } catch (Exception e) {
            System.err.println(e);
            getEm().getTransaction().rollback();
        } finally {
            getEm().close();
        }
        
        return prof;
    }
    
    
}
