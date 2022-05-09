/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller.Helper;

import com.mycompany.models.Aluno;
import com.mycompany.view.MatriculaAluno;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author renea
 */
public class MatriculaAlunoHelper {
    
    private final MatriculaAluno view;

    public MatriculaAlunoHelper(MatriculaAluno view) {
        this.view = view;
    }
    
     public Aluno obterModeloAluno() {
          
          String nome = view.getjTextFieldPesquisarAluno().getText();
          
          Aluno aluno = new Aluno(nome);
          
          return aluno;
    }
     public Aluno obterModeloAlterar(){
         
        Integer id = view.armazenaId();
        String nome = view.getjTextFieldName().getText();
        String email = view.getjTextFieldEmail().getText();
        String cpf = view.getjFormattedTextFieldCPF().getText();
        String endereco = view.getjTextFieldEndereco().getText();
        String numero = view.getjTextFieldNumero1().getText();
        String compl = view.getjTextFieldCompl().getText();
        String sexo = view.getSexo();
        String bairro = view.getjTextFieldBairro().getText();
        String cidade = view.getjTextFieldCidade().getText();
        String estado = view.getjTextFieldEstado().getText();
        String cep = view.getjFormattedTextFieldCEP().getText();
        String tel = view.getjFormattedTextFieldTEL().getText();
        String cel = view.getjFormattedTextFieldCEL().getText();
        String watsapp = view.getWatsApp();
        String idade = view.getjFormattedTextFieldIdade().getText();
        String mensalidade = (String) view.getjComboBoxMensalidade().getSelectedItem() ;
        String formaPagamento = (String) view.getjComboBoxFormaPagamento().getSelectedItem() ;
        String vencimento = (String) view.getjComboBoxVencimento().getSelectedItem();
     
        Aluno modelo = new Aluno(mensalidade, formaPagamento, vencimento,
                id, compl, nome, sexo, email, cpf, idade, endereco,
                numero, compl, cep, bairro, cidade, estado, tel, cel, watsapp);
         return modelo;
     }

    public Aluno obterModelo(){
        
        String nome = view.getjTextFieldName().getText();
        String email = view.getjTextFieldEmail().getText();
        String cpf = view.getjFormattedTextFieldCPF().getText();
        String endereco = view.getjTextFieldEndereco().getText();
        String numero = view.getjTextFieldNumero1().getText();
        String compl = view.getjTextFieldCompl().getText();
        String sexo = view.getSexo();
        String bairro = view.getjTextFieldBairro().getText();
        String cidade = view.getjTextFieldCidade().getText();
        String estado = view.getjTextFieldEstado().getText();
        String cep = view.getjFormattedTextFieldCEP().getText();
        String tel = view.getjFormattedTextFieldTEL().getText();
        String cel = view.getjFormattedTextFieldCEL().getText();
        String watsapp = view.getWatsApp();
        String idade = view.getjFormattedTextFieldIdade().getText();
        String mensalidade = (String) view.getjComboBoxMensalidade().getSelectedItem() ;
        String formaPagamento = (String) view.getjComboBoxFormaPagamento().getSelectedItem() ;
        String vencimento = (String) view.getjComboBoxVencimento().getSelectedItem();
    
        Aluno modelo = new Aluno(mensalidade, formaPagamento, vencimento, nome,
                sexo, email, cpf, idade, endereco, numero, compl, cep,
                bairro, cidade, estado, tel, cel, watsapp);
    
        return modelo;
   
    }

     public void cleanField(){
       
        view.getjTextFieldName().setText("");
        view.getjTextFieldEmail().setText("");
        view.getjFormattedTextFieldCPF().setText("");
        view.getjTextFieldEndereco().setText("");
        view.getjTextFieldNumero1().setText("");
        view.getjTextFieldCompl().setText("");
        view.getButtonGroupSexo().clearSelection();
        view.getjTextFieldBairro().setText("");
        view.getjTextFieldCidade().setText("");
        view.getjTextFieldEstado().setText("");
        view.getjFormattedTextFieldCEP().setText("");
        view.getjFormattedTextFieldTEL().setText("");
        view.getjFormattedTextFieldCEL().setText("");
        view.getjTextFieldCel().setText("");
        view.getjRadioButtonWatssApp().setSelected(false);
        view.getjComboBoxFormaPagamento().setSelectedIndex(0);
        view.getjComboBoxMensalidade().setSelectedIndex(0);
        view.getjComboBoxVencimento().setSelectedIndex(0);
        view.getjFormattedTextFieldIdade().setText("");
    }
     
     
     public void preencherTabelaAlunos(ArrayList<Aluno> alunos) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTableTabelaAlunos().getModel();
        tableModel.setNumRows(0);
        
        for (Aluno aluno : alunos) {
            
            tableModel.addRow(new Object[]{
                
                aluno.getId(),
                aluno.getNome(),
                aluno.getSexo(),
                aluno.getCel(),
                aluno.getWatsapp(),
                aluno.getTel(),
                aluno.getEmail(),
                aluno.getCpf(),
                aluno.getIdade(),
                aluno.getEndereco(),
                aluno.getNumero(),
                aluno.getCompl(),
                aluno.getBairro(),
                aluno.getCidade(),
                aluno.getEstado(),
                aluno.getCep(),
                aluno.getFormaPagamento(),
                aluno.getMensalidade(),
                aluno.getVencimento()
            });
            
        }
        
    }
}
