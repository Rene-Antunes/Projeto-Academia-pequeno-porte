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
@DiscriminatorValue("Usuario")
public class Usuario extends Pessoa{
    

    private String senha;
    
    // login não entra com contrutor padrão descobrir como corrigir isso
    public Usuario() {
    }
    
    public Usuario(String nome){
        this.nome = nome;
    }

    public Usuario(String login, String senha) {
        super(login);
        this.senha = senha;
    }

    public Usuario(String login, String senha, String nome) {
        super(login, nome);
        this.senha = senha;
    }
    
    public Usuario(String login,String senha, String nome, String sexo, String email,
            String cpf, String idade, String endereco, String numero, String complemento,
            String cep, String bairro, String cidade, String estado, String tel, String cel, String watsapp) {
        super(nome, sexo, email, cpf, idade, endereco, numero, complemento, cep, bairro, cidade, estado, tel, cel, watsapp);
       
        this.senha = senha;
    }

    public Usuario(String senha, Integer id, String login, String nome,
            String sexo, String email, String cpf, String idade,
            String endereco, String numero, String compl, String cep,
            String bairro, String cidade, String estado, String tel,
            String cel, String watsapp) {
        super(id, login, nome, sexo, email, cpf, idade, endereco, numero, 
                compl, cep, bairro, cidade, estado, tel, cel, watsapp);
        this.senha = senha;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

  @Override
    public String toString(){
    
        return getNome();
    
    }  
   
    
    
}
