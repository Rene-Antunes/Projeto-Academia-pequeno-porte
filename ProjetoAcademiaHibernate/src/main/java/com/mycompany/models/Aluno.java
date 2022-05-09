/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;



  


/**
 *
 * @author renea
 */

@Entity
@DiscriminatorValue("Aluno")
public class Aluno extends Pessoa {
     
   
    private String mensalidade;
    private String formaPagamento;
    private String vencimento;

    public Aluno() {
    }
    
    
    public Aluno(String nome) {
        this.nome = nome;
    }

    public Aluno(String mensalidade, String formaPagamento, String vencimento, String login, String nome) {
        super(login, nome);
        this.mensalidade = mensalidade;
        this.formaPagamento = formaPagamento;
        this.vencimento = vencimento;
    }

    public Aluno(String mensalidade, String formaPagamento, String vencimento, 
            String nome, String sexo, String email, String cpf, String idade, 
            String endereco, String numero, String compl, String cep, String bairro,
            String cidade, String estado, String tel, String cel, String watsapp) {
        
        super(nome, sexo, email, cpf, idade, endereco, numero, compl, cep, bairro, cidade, estado, tel, cel, watsapp);
        this.mensalidade = mensalidade;
        this.formaPagamento = formaPagamento;
        this.vencimento = vencimento;
    }

    public Aluno(String mensalidade, String formaPagamento, String vencimento,
            Integer id, String login, String nome, String sexo, String email,
            String cpf, String idade, String endereco, String numero, String compl, 
            String cep, String bairro, String cidade, String estado, String tel,
            String cel, String watsapp) {
        super(id, login, nome, sexo, email, cpf, idade, endereco, numero, compl, cep, bairro, cidade, estado, tel, cel, watsapp);
        this.mensalidade = mensalidade;
        this.formaPagamento = formaPagamento;
        this.vencimento = vencimento;
    }
    
     
    public String getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(String mensalidade) {
        this.mensalidade = mensalidade;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
   @Override
    public String toString(){
    
        return getNome();
    
    }  
    
}
