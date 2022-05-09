/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.infra;


import com.mycompany.models.Agendamento;
import java.awt.HeadlessException;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author renea
 */
public class AgendamentoDAO extends DAO<Agendamento>{

    public AgendamentoDAO() {
        super(Agendamento.class);
    }
    
     public List<Agendamento> selectAll(){
        
        String jpql = "Select a from Agendamento as a";
        Query query = getEm().createQuery(jpql);
        List<Agendamento> agendamentos = query.getResultList();
        return agendamentos;
    
    }

    public Agendamento removerAgendamento(Agendamento agendamentoId) {
        Agendamento agendamento = null;
        
        try {
            agendamento = getEm().find(Agendamento.class, agendamentoId.getId());
            getEm().getTransaction().begin();
            getEm().remove(agendamento);
            getEm().getTransaction().commit();
            
        } catch (Exception e) {
            System.err.println(e);
            getEm().getTransaction().rollback();
        } finally {
            getEm().close();
        }
        
        return agendamento;
    }

    public List<Agendamento> getAgendamentoPorNome(Agendamento agendamento) {
        List<Agendamento> agendamentos = null;
        Query query = null;
        
        try {
            String jpql = "select a from Agendamento as a "
                    + "where a.aluno LIKE :pAgendamento";
            
            query = getEm().createQuery(jpql);
            query = query.setParameter("pAgendamento", agendamento + "%");
            agendamentos = query.getResultList();
            
            if (query.getResultList().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Agendamento não encontrado.");
                
            }
            
        } catch (HeadlessException e) {
             System.err.println(e);
        } finally {
            getEm().close();
        }
        
        return agendamentos;
    }
    
    
  
}
