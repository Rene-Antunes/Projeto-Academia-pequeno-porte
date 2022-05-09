/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.controller.Helper.AgendamentoHelper;
import com.mycompany.infra.AgendamentoDAO;
import com.mycompany.infra.AlunoDAO;
import com.mycompany.infra.ProfDAO;
import com.mycompany.models.Agendamento;
import com.mycompany.models.Aluno;
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
import java.util.List;
import javax.persistence.NoResultException;
import javax.swing.JOptionPane;

/**
 *
 * @author renea
 */
public class AgendamentoController {
    
    private final Agenda view;
    private final AgendamentoHelper helper;

    public AgendamentoController(Agenda view) {
        this.view = view;
        this.helper = new AgendamentoHelper(view);
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
    
     public void atualizarTabelaAgendamento(){
         AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
         ArrayList<Agendamento> agendamentos = (ArrayList<Agendamento>) agendamentoDAO.selectAll();
         
        helper.preencherTabelaAgendamento(agendamentos);
     }
     
     public void atualizarTabelaPorPesquisa(){
         AlunoDAO alunoDAO = new AlunoDAO(); 
         Aluno aluno = helper.obterModeloAluno();

         try {

           ArrayList<Aluno> alunos = (ArrayList<Aluno>) alunoDAO.getAlunoPorNome(aluno);
           helper.preencherTabelaAluno(alunos);
          
         } catch (NoResultException e) {
             // descobrir pq motivo a mensagem não aparece
             JOptionPane.showMessageDialog(null, "Aluno não encontrado");
         }
        
 
     }
  
       public void atualizarTabelaAluno(){
         AlunoDAO alunoDAO = new AlunoDAO();
         ArrayList<Aluno> alunos = (ArrayList<Aluno>) alunoDAO.selectAll();
         
        helper.preencherTabelaAluno(alunos);
     }
        
     
     public void atualizarBoxProfessor(){
        
        ProfDAO profDAO = new ProfDAO();
        List<Professor> professores = profDAO.selectAll();
        helper.preencherBoxProf(professores);
     
     }
     
     public void getNomeAluno(){
         helper.obterModeloAgenda();
     
     
     }
    
     public void InsertAgendamento(){
         AgendamentoDAO agendaDAO = new AgendamentoDAO();
         Agendamento agendamento = helper.obterModeloAgenda();
         
         agendaDAO.atomicInsert(agendamento).close();
         helper.cleanField();
         
         JOptionPane.showMessageDialog(null,"Agendamento efetuado com sucesso");

     }

    public void excluirAgendamento() {
         int delStm = JOptionPane.
                showConfirmDialog(null, "Deseja cancelar o agendamento?", "Confirmação", JOptionPane.YES_NO_OPTION);
         
         AgendamentoDAO agendaDAO = new AgendamentoDAO();
         Agendamento agendamento = helper.obterModeloAgendamentoExcluir();
         
         if (delStm == 0) {
             agendaDAO.removerAgendamento(agendamento);
              JOptionPane.showMessageDialog(null, "Agendamento removido com êxito");
            
        }
                             
    }

    public void atualizarTabelaAgemdamentoPorPesquisa() {
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        Agendamento agendamento = helper.obterModeloAgendamento();
        ArrayList<Agendamento> agendamentos = (ArrayList<Agendamento>) agendamentoDAO.getAgendamentoPorNome(agendamento);
        helper.preencherTabelaAgendamento(agendamentos);
        
    }

   
     
     
    
    }
     
     
    

