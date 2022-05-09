/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller.Helper;

import com.mycompany.models.Agendamento;
import com.mycompany.models.Aluno;
import com.mycompany.models.Professor;
import com.mycompany.view.Agenda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author renea
 */
public class AgendamentoHelper {
    
    private final Agenda view;

    public AgendamentoHelper(Agenda view) {
        this.view = view;
    }
    
    public Aluno obterModeloAluno (){
       String nome = view.getjTextFieldNome().getText();

       Aluno aluno = new Aluno(nome);
    
       return aluno;
    
    }
    
    public Agendamento obterModeloAgendamento(){
    String nome = view.getjTextFieldPesquisarAgendamento().getText();
    Agendamento modelo = new Agendamento(nome);
      
    return modelo;
    
    }
     public Agendamento obterModeloAgendamentoExcluir(){
        Integer id = view.armazenaId();
        String nome = view.getjTextFieldPesquisarAgendamento().getText();
        Agendamento modelo = new Agendamento(id, nome);
      
    return modelo;
    
    }
    public Agendamento obterModeloAgenda(){
    String alunoAg = view.armazenaNome();
    String data = view.getjFormattedTextFieldData().getText();
    String professor = (String) view.getjComboBoxProfessor().getSelectedItem();
    
    Agendamento modelo = new Agendamento(alunoAg, data, professor);
      
    return modelo;
    
    }
    
    public void cleanField(){
        
     view.getjFormattedTextFieldData().setText("");
     view.getjTextFieldNome().setText("");
     view.getjComboBoxProfessor().setSelectedIndex(0);

    }

    public void preencherTabelaAgendamento(ArrayList<Agendamento> agendamentos) {
      
        DefaultTableModel tableModel =  (DefaultTableModel) view.getjTableAgendaMarcados().getModel();
        tableModel.setNumRows(0);
        
        for (Agendamento agendamento : agendamentos) {
            
            tableModel.addRow(new Object[]{
                agendamento.getId(),
                agendamento.getAluno(),
                agendamento.getData(),
                agendamento.getProfessor()

            });  
        } 
    }

    public void preencherTabelaAluno(ArrayList<Aluno> alunos) {
      
        DefaultTableModel tableModel =  (DefaultTableModel) view.getjTableAgendaAluno().getModel();
        tableModel.setNumRows(0);
        
        
        for (Aluno aluno : alunos) {
            
             tableModel.addRow(new Object[]{
               aluno.getId(),
               aluno.getNome(),
               aluno.getTel(),
               aluno.getCel(),
               aluno.getEmail()
  
            });
        }  
    }  

    public void preencherBoxProf(List<Professor> professores) {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBoxProfessor().getModel();
        
        for (Professor professor : professores) {
            
            comboBoxModel.addElement(professor.getNome());
            
        }
    }
}
