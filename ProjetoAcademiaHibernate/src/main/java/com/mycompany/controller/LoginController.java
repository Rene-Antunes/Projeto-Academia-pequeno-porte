/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;


import com.mycompany.controller.Helper.LoginHelper;
import com.mycompany.infra.UsuarioDAO;
import com.mycompany.models.Usuario;
import com.mycompany.view.CadastroAdmLogOff;
import com.mycompany.view.HomeMenu;
import com.mycompany.view.Login;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author renea
 */
public class LoginController {

    private final Login view;
    private final LoginHelper helper;
   

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
        
    }
    
    public void entrarNoSistema(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = helper.ObterModelo();
        boolean testeUser = usuarioDAO.obterUsuarioLogin(usuario);
            
        if (testeUser == true) {
        System.out.println("Iniciado com exito");
        HomeMenu home = new HomeMenu();
        home.setVisible(true);
        view.dispose();
         }else{
           JOptionPane.showMessageDialog(null, "Login ou senha Invalidos");
       
        }
       
    }

    public void abrirCadAdmin(){
        CadastroAdmLogOff cadAdm = new CadastroAdmLogOff();
        cadAdm.setVisible(true);
        view.dispose();  
    }
 
   
    
}
