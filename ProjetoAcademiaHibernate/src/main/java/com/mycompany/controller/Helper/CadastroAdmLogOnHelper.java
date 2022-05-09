/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller.Helper;

import com.mycompany.models.Usuario;
import com.mycompany.view.CadastroAdmLogOn;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author renea
 */
public class CadastroAdmLogOnHelper {
    
    private final CadastroAdmLogOn view;

    public CadastroAdmLogOnHelper(CadastroAdmLogOn view) {
        this.view = view;
    }
    public Usuario ObterModeloUsuario(){
    String nome = view.getjTextFieldPesquisarUser().getText();
    Usuario user = new Usuario(nome);
    return user;
    }
    
     public Usuario obterModelo(){
             
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
        String watsapp = view.getWatsApp();
        String login = view.getjTextFieldLogin().getText();
        String senha = view.getjPasswordField().getText();
        String idade = view.getjFormattedTextFieldIdade().getText();
                       
        Usuario modelo = new Usuario(login, senha, nome, sexo, email, cpf, idade, 
                endereco, numero, compl, cep, bairro, cidade, estado, tel, cel, watsapp);
        
        return modelo;

    }
     
       public Usuario obterModeloAlterar() {
        Integer id = view.armazenaId();
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
        String watsapp = view.getWatsApp();
        String login = view.getjTextFieldLogin().getText();
        String senha = view.getjPasswordField().getText();
        String idade = view.getjFormattedTextFieldIdade().getText();
          
        Usuario modelo = new Usuario(senha, id, login, nome, sexo, email, cpf, 
                idade, endereco, numero, compl, cep, bairro, cidade, estado, tel, cel, watsapp);
        
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
        view.getjRadioButtonWatssApp().setSelected(false);
        view.getjTextFieldLogin().setText("");
        view.getjPasswordField().setText("");
        view.getjFormattedTextFieldIdade().setText("");
    }

    public void preencerTabelaUsuarios(ArrayList<Usuario> user) {
            DefaultTableModel tableModel = (DefaultTableModel) view.getjTableTabelaUsuarios().getModel();
            tableModel.setNumRows(0);
            
            for (Usuario usuario : user) {
                tableModel.addRow(new Object[]{
                
                usuario.getId(),
                usuario.getNome(),
                usuario.getLogin(),
                usuario.getSexo(),
                usuario.getCel(),
                usuario.getWatsapp(),
                usuario.getTel(),
                usuario.getEmail(),
                usuario.getCpf(),
                usuario.getIdade(),
                usuario.getEndereco(),
                usuario.getNumero(),
                usuario.getCompl(),
                usuario.getBairro(),
                usuario.getCidade(),
                usuario.getEstado(),
                usuario.getCep()
                });
            }
            
        
    }

  

   
    
}
