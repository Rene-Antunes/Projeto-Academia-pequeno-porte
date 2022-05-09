/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.controller.Helper.CadastroAdmLogOffHelper;
import com.mycompany.infra.UsuarioDAO;
import com.mycompany.models.Usuario;
import com.mycompany.view.CadastroAdmLogOff;
import com.mycompany.view.HomeMenu;
import com.mycompany.view.Login;
import javax.swing.JOptionPane;

/**
 *
 * @author renea
 */
public class CadastroAdmLogOffContoller {
   
    private final CadastroAdmLogOff view;
    private final CadastroAdmLogOffHelper helper;

    public CadastroAdmLogOffContoller(CadastroAdmLogOff viewCad) {
        this.view = viewCad;
        this.helper = new CadastroAdmLogOffHelper(view);
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
        
       Usuario usuario = helper.obeterModelo();
       userDAO.insert(usuario);
       helper.cleanField();
       
       userDAO.atomicInsert(usuario).close();
       
       JOptionPane.showMessageDialog(null,"Cadastro efetuado com sucesso");
 
    }
    
   
     
     
    
}
