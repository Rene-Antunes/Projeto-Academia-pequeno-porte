/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller.Helper;

import com.mycompany.models.Professor;
import com.mycompany.view.MatriculaProfessor;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author renea
 */
public class MatriculaProfessorHelper {
    
    private final MatriculaProfessor view;

    public MatriculaProfessorHelper(MatriculaProfessor view) {
        this.view = view;
    }
    
    
     
    public Professor ObterModeloProfessor() {
        String nome = view.getjTextFieldPesquisarProf().getText();
        Professor professor = new Professor(nome);
        return professor;        
    }

  public Professor obterModeloAlterar(){
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
        String idade = view.getjFormattedTextFieldIdade().getText();
        String horario = (String) view.getjComboBoxHorario().getSelectedItem();
        String cargo = (String) view.getjComboBoxCargo().getSelectedItem();
        
       
        Professor modelo = new Professor(horario, cargo, id, compl, nome, sexo,
                email, cpf, idade, endereco, numero, compl, cep, bairro, cidade,
                estado, tel, cel, watsapp);
    
        return modelo;
   
    }
    
    public Professor obterModelo(){
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
        String idade = view.getjFormattedTextFieldIdade().getText();
        String horario = (String) view.getjComboBoxHorario().getSelectedItem();
        String cargo = (String) view.getjComboBoxCargo().getSelectedItem();
        

        Professor modelo = new Professor(horario, cargo,nome, sexo, 
                email, cpf, idade, endereco, numero, compl, cep, bairro, cidade,
                estado, tel, cel, watsapp);
    
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
        view.getjTextFieldCel().setText("");
        view.getjRadioButtonSexoF().setSelected(false);
        view.getjRadioButtonSexoM().setSelected(false);
        view.getjComboBoxCargo().setSelectedIndex(0);
        view.getjComboBoxHorario().setSelectedIndex(0);
        view.getjRadioButtonWatssApp().setSelected(false);        
        view.getjFormattedTextFieldIdade().setText("");
    }
    
       public void preencherTabelaProf(ArrayList<Professor> professores) {
        
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTableTabelaProfessor().getModel();
        tableModel.setNumRows(0);
        
        for (Professor professor : professores) {
            
            tableModel.addRow(new Object[]{
                
                professor.getId(),
                professor.getNome(),
                professor.getSexo(),
                professor.getCel(),
                professor.getWatsapp(),
                professor.getTel(),
                professor.getEmail(),
                professor.getCpf(),
                professor.getIdade(),
                professor.getEndereco(),
                professor.getNumero(),
                professor.getBairro(),
                professor.getCidade(),
                professor.getCompl(),
                professor.getEstado(),
                professor.getCep(),
                professor.getHorario(),
                professor.getCargo(),
                professor.getHorario(),
                professor.getCargo()
            });
            
        }
        
      
        
    }
    
}
