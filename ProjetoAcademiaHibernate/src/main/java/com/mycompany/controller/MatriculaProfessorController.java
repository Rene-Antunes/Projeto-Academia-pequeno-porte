/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.controller.Helper.MatriculaProfessorHelper;
import com.mycompany.infra.ProfDAO;
import com.mycompany.models.Professor;
import com.mycompany.view.Agenda;
import com.mycompany.view.Avaliacao;
import com.mycompany.view.CadastroAdmLogOn;
import com.mycompany.view.MatriculaAluno;
import com.mycompany.view.MatriculaProfessor;
import com.mycompany.view.HomeMenu;
import com.mycompany.view.Login;
import com.mycompany.view.Treinos;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author renea
 */
public class MatriculaProfessorController {
    
    private final MatriculaProfessor view;
    private final MatriculaProfessorHelper helper;

    public MatriculaProfessorController(MatriculaProfessor view) {
        this.view = view;
        this.helper = new MatriculaProfessorHelper(view);
    }
    
     public void abrirCadAluno(){
        MatriculaAluno cadAluno = new MatriculaAluno();
        cadAluno.setVisible(true);
        view.dispose();
       
    }
    
       public void abrirCadProf(){
           MatriculaProfessor cadProf = new MatriculaProfessor();
           cadProf.setVisible(true);
           view.dispose();
    }
       
      public void abrirCadAdm(){
           CadastroAdmLogOn cadAdm = new CadastroAdmLogOn();
           cadAdm.setVisible(true);
           view.dispose();
    }
    
       public void abrirAgendaAvali(){
           Agenda agenda = new Agenda();
           agenda.setVisible(true);
           view.dispose();
       }
      
       
       public void abrirTreinos(){
           Treinos treinos = new Treinos();
           treinos.setVisible(true);
           view.dispose(); 
       }
       
       public void abrirAvaliacao(){
           Avaliacao avaliacao = new Avaliacao();
           avaliacao.setVisible(true);
           view.dispose();
       }
       
        public void trocarUsuario(){
            Login login = new Login();
            login.setVisible(true);
            view.dispose();
    }
        
     public void voltarMenu() {
        HomeMenu menu = new HomeMenu();
        menu.setVisible(true);
        view.dispose();
    }
     
     public void incluirProfessor(){
       ProfDAO profDAO = new ProfDAO();
        
         Professor prof = helper.obterModelo();
       profDAO.insert(prof);
       helper.cleanField();
       
       profDAO.atomicInsert(prof).close();
       
       JOptionPane.showMessageDialog(null,"Cadastro efetuado com êxito");
 
    }
     
      public void atualizarTabelaProf() {
        ProfDAO profDAO = new ProfDAO();
        ArrayList<Professor> professores = (ArrayList<Professor>) profDAO.selectAll();
        helper.preencherTabelaProf(professores);
        
        
    }

    public void atualizarTabelaPorPesquisa() {
       ProfDAO profDAO = new ProfDAO();
       Professor professor = helper.ObterModeloProfessor();

        try {
              ArrayList<Professor> professores = (ArrayList<Professor>) profDAO.getProfPorNome(professor);
              helper.preencherTabelaProf(professores);
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Professor não encontrado");
        }
    }

    public void alterarProf(){
        int altStm = JOptionPane.showConfirmDialog(null, "Deseja Alterar este Professor?", "Confirmação", JOptionPane.YES_NO_OPTION);
        
        if (altStm == 0) {
        ProfDAO profDAO = new ProfDAO();
        Professor professor = helper.obterModeloAlterar();
        profDAO.alterarProfId(professor);
        helper.cleanField();
        JOptionPane.showMessageDialog(null, "Professor Atualizado com êxito");
        }
        
    
    }
    
    public void exluirProf(){
        int delStm = JOptionPane.showConfirmDialog(null, "Deseja remover este Professor?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (delStm == 0) {
            ProfDAO profDAO = new ProfDAO();
            Professor prof = helper.obterModeloAlterar();
            JOptionPane.showMessageDialog(null, "Professor removido com êxito");
            profDAO.removerProf(prof);
           
        } 
       
    
    }
    
}
