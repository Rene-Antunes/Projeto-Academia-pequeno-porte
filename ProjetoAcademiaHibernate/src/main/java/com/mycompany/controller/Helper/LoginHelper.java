/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller.Helper;

import com.mycompany.models.Usuario;
import com.mycompany.view.Login;

/**
 *
 * @author renea
 */
public class LoginHelper {
    
    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }
    
    public Usuario ObterModelo(){
   
        String login = view.getjTextFieldUser().getText();
        String senha = view.getjPasswordField().getText();
    
        Usuario modelo  = new Usuario(login, senha);
        return modelo;
     
    }
    
    public  void setModelo(Usuario modelo){
        String nome = modelo.getNome();
        String senha = modelo.getSenha();
        view.getjTextFieldUser().setText(nome);
        view.getjPasswordField().setText(senha);
    }
    
    public void limparTela(){
        view.getjTextFieldUser().setText("");
        view.getjPasswordField().setText("");
    
    }
    
}
