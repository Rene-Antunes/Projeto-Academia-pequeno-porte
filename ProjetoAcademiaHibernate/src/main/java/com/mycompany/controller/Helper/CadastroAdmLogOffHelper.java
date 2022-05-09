/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller.Helper;

import com.mycompany.models.Usuario;
import com.mycompany.view.CadastroAdmLogOff;

/**
 *
 * @author renea
 */
public class CadastroAdmLogOffHelper {
    
    private final CadastroAdmLogOff view;

    public CadastroAdmLogOffHelper(CadastroAdmLogOff view) {
        this.view = view;
    }
    
    public Usuario obeterModelo(){
       
        String nome = view.getjTextFieldName().getText();
        String email = view.getjTextFieldEmail().getText();
        String cpf = view.getjFormattedTextFieldCPF().getText();
        String endereco = view.getjTextFieldEndereco().getText();
        String numero = view.getjTextFieldNumero1().getText();
        String compl = view.getjTextFieldComplemento1().getText();
        String sexo = view.getSexo();
        String bairro = view.getjTextFieldBairro().getText();
        String cidade = view.getjTextFieldCidade().getText();
        String estado = view.getjTextFieldEstado().getText();
        String cep = view.getjFormattedTextFieldCEP().getText();
        String tel = view.getjFormattedTextFieldTEL().getText();
        String cel = view.getjFormattedTextFieldCEL().getText();
        String watsApp = view.getWatsApp();
        String login = view.getjTextFieldLogin().getText();
        String senha = view.getjPasswordField().getText();
        String idade = view.getjFormattedTextFieldIdade().getText();
        
         
       
        Usuario modelo = new Usuario(login, senha, nome, sexo, email, cpf, idade, 
                endereco, numero, compl, cep, bairro, cidade, estado, tel, cel, watsApp);
        
          
        return modelo;

    }

      public void cleanField(){
       
        view.getjTextFieldName().setText("");
        view.getjTextFieldEmail().setText("");
        view.getjFormattedTextFieldCPF().setText("");
        view.getjTextFieldEndereco().setText("");
        view.getjTextFieldNumero1().setText("");
        view.getjTextFieldComplemento1().setText("");
        view.getButtonGroupSexo().clearSelection();
        view.getjTextFieldBairro().setText("");
        view.getjTextFieldCidade().setText("");
        view.getjTextFieldEstado().setText("");
        view.getjFormattedTextFieldCEP().setText("");
        view.getjFormattedTextFieldTEL().setText("");
        view.getjFormattedTextFieldCEL().setText("");
        view.getjRadioButtonWatssApp().setSelected(true);
        view.getjTextFieldLogin().setText("");
        view.getjPasswordField().setText("");
        view.getjFormattedTextFieldIdade().setText("");
    }
    
}
