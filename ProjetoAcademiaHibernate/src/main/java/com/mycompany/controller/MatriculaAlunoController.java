/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.controller.Helper.MatriculaAlunoHelper;
import com.mycompany.infra.AlunoDAO;
import com.mycompany.models.Aluno;
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
public class MatriculaAlunoController {
    
    private final MatriculaAluno view;
    private final MatriculaAlunoHelper helper;

    public MatriculaAlunoController(MatriculaAluno view) {
        this.view = view;
        this.helper = new MatriculaAlunoHelper(view);
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
    
     public void abrirCadAluno(){
        MatriculaAluno cadAluno = new MatriculaAluno();
        cadAluno.setVisible(true);
        view.dispose();
       
    }
     
 
    public void alunoInsert(){
        AlunoDAO alunoDAO = new AlunoDAO();
        Aluno aluno = helper.obterModelo();     
        alunoDAO.atomicInsert(aluno).close();   
        helper.cleanField(); 
        JOptionPane.showMessageDialog(null,"Cadastro efetuado com êxito");
    
    }
    
    public void alterarAluno(){
        int altStm = JOptionPane.
                showConfirmDialog(null, "Deseja alterar este Aluno?", "Confirmação", JOptionPane.YES_NO_OPTION);
         AlunoDAO userDAO = new AlunoDAO();
         Aluno aluno = helper.obterModeloAlterar(); 
         
        if (altStm == 0) {
            userDAO.alterarAlunoId(aluno);
            helper.cleanField();
            JOptionPane.showMessageDialog(null, "Aluno Atualizado com êxito");
        }
        
    
    }
    
    public void excluirAluno(){
        int delStm = JOptionPane
                .showConfirmDialog(null, "Deseja remover este Aluno?", "Confirmação", JOptionPane.YES_NO_OPTION);
        
         AlunoDAO alunoDAO = new AlunoDAO();
         Aluno aluno = helper.obterModeloAlterar();
         
        if (delStm == 0) {
           alunoDAO.removerAluno(aluno);
            JOptionPane.showMessageDialog(null, "Aluno removido com êxito");
        }
       

    }
    
    public void atualizarTabelaAlunos(){
         AlunoDAO alunoDAO = new AlunoDAO();
         ArrayList<Aluno> alunos = (ArrayList<Aluno>) alunoDAO.selectAll();
         
         helper.preencherTabelaAlunos(alunos);
         
     
     }

    public void atualizarTabelaPorPesquisa() {
        AlunoDAO alunoDAO = new AlunoDAO();
        Aluno aluno = helper.obterModeloAluno();
        ArrayList<Aluno> alunos = (ArrayList<Aluno>) alunoDAO.getAlunoPorNome(aluno);
        helper.preencherTabelaAlunos(alunos);
    }
    
    
    
}
