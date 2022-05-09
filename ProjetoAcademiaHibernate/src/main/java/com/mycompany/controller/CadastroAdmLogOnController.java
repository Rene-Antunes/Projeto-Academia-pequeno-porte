/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.controller.Helper.CadastroAdmLogOnHelper;
import com.mycompany.infra.UsuarioDAO;
import com.mycompany.models.Usuario;
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
public class CadastroAdmLogOnController {
    
    private final CadastroAdmLogOn view;
    private final CadastroAdmLogOnHelper helper;

    public CadastroAdmLogOnController(CadastroAdmLogOn view) {
        this.view = view;
        
        this.helper = new CadastroAdmLogOnHelper(view);
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
        
        
        
       public void incluirUsuario(){
            UsuarioDAO userDAO = new UsuarioDAO();

            Usuario usuario = helper.obterModelo();
            userDAO.insert(usuario);
            helper.cleanField();

            userDAO.atomicInsert(usuario).close();

            JOptionPane.showMessageDialog(null,"Cadastro efetuado com sucesso");

    }

    public void atualizarTabelaUsuarios() {
        UsuarioDAO userDAO = new UsuarioDAO();
        ArrayList<Usuario> user = (ArrayList<Usuario>) userDAO.selectAll();
        
        helper.preencerTabelaUsuarios(user);
        
    }

    public void UsuarioInsert() {
        UsuarioDAO userDAO = new UsuarioDAO();
        Usuario user = helper.obterModelo();
        userDAO.atomicInsert(user).close();
        helper.cleanField();
        JOptionPane.showMessageDialog(null,"Cadastro efetuado com êxito");
        
        
    }

    public void alterarUsuario() {
        int altStm = JOptionPane.
                showConfirmDialog(null, "Deseja alterar este Usuário?", "Confirmação", JOptionPane.YES_NO_OPTION);
        
        UsuarioDAO userDao = new UsuarioDAO();
        Usuario user = helper.obterModeloAlterar();
        if (altStm == 0) {
            userDao.alterarUsuarioId(user);
            helper.cleanField();
            JOptionPane.showMessageDialog(null, "Usuario Atualizado com êxito");
         }
        
    }

    public void excluirUsuario() {
        int delStm = JOptionPane.
                showConfirmDialog(null, "Deseja remover este Usuário?", "Confirmação", JOptionPane.YES_NO_OPTION);
        
        UsuarioDAO userDAO = new UsuarioDAO();
        Usuario user = helper.obterModeloAlterar();
        
        if (delStm == 0) {
            userDAO.removerUsario(user);
            JOptionPane.showMessageDialog(null, "Usuário removido com êxito");
            
        }
        
        
    }

    public void atualizarTabelaPorPesquisa() {
        UsuarioDAO userDAO = new UsuarioDAO();
        Usuario user = helper.ObterModeloUsuario();
        ArrayList<Usuario> users = (ArrayList<Usuario>) userDAO.getUsuarioPorNome(user);
        helper.preencerTabelaUsuarios(users);
             
    }

   
    
    
     
     
     
}
