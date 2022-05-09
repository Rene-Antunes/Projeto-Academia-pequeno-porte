/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.view.Agenda;
import com.mycompany.view.Avaliacao;
import com.mycompany.view.AvaliacaoCad;
import com.mycompany.view.CadastroAdmLogOn;
import com.mycompany.view.MatriculaAluno;
import com.mycompany.view.MatriculaProfessor;
import com.mycompany.view.HomeMenu;
import com.mycompany.view.Login;
import com.mycompany.view.Treinos;

/**
 *
 * @author renea
 */
public class AvaliacaoCadController {
    private final AvaliacaoCad view;

    public AvaliacaoCadController(AvaliacaoCad view) {
        this.view = view;
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
    
}
