/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.infra;

import com.mycompany.models.Aluno;
import java.awt.HeadlessException;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author renea
 */
public class AlunoDAO extends DAO<Aluno>{

    public AlunoDAO() {
        super(Aluno.class);
    }
     public List<Aluno> selectAll(){
        List<Aluno> alunos = null;
         
         try {
             String jpql = "Select u from Aluno as u";
             Query query = getEm().createQuery(jpql);
             alunos  = query.getResultList();
         } catch (Exception e) {
             System.err.println(e);
         }
        
       
        return alunos;
    
    }
     
        
     public List<Aluno> getAlunoPorNome(Aluno aluno){
         List<Aluno> alunos = null; 
          Query query = null;
         
         try {
             String jpql = " select a from Aluno as a "
                + "where a.nome LIKE :pAluno ";
        
            query = getEm().createQuery(jpql);             
            query = query.setParameter("pAluno",aluno + "%");
            alunos  = query.getResultList();
            
               if (query.getResultList().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Aluno não encontrado");
                }
               
         } catch (HeadlessException e) {
             System.err.println(e);
         }finally{
             getEm().close();
         }
        return alunos;
    
    }
     
     
    
        public Aluno alterarAlunoId(Aluno aluno){
        
        try {
            getEm().getTransaction().begin();
            
            if (aluno.getId() == null) {
                getEm().persist(aluno);
                
            }else{
            getEm().merge(aluno);
            
            }
            getEm().getTransaction().commit();
        } catch (Exception e) {
            getEm().getTransaction().rollback();
        }finally{
            getEm().close();
        
        }
       
        return aluno;
    }

        
      public Aluno removerAluno(Aluno alunoId){
        Aluno aluno = null;
         
        try {
            
            aluno = getEm().find(Aluno.class, alunoId.getId());
            getEm().getTransaction().begin();
            getEm().remove(aluno);
            getEm().getTransaction().commit();
            
        } catch (Exception e) {
           System.err.println(e);
           getEm().getTransaction().rollback();
        }finally{
            getEm().close();
        
        }
       
        return aluno;
    }
    
}
