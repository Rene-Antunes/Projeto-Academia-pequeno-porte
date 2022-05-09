/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.models;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author renea
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("PS")
abstract public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String login;
    protected String nome;
    protected String sexo;
    protected String email;
    protected String cpf;
    protected Date idade;
    protected String endereco;
    protected String numero;
    protected String compl;
    protected String cep;
    protected String bairro;
    protected String cidade;
    protected String estado;
    protected String tel;
    protected String cel;
    protected String watsapp; 

    public Pessoa() {
    }

    
    
    public Pessoa(String login) {
        this.login = login;
    }

    public Pessoa(String login, String nome) {
        this.login = login;
        this.nome = nome;
    }

    public Pessoa(Integer id, String login, String nome) {
        this.id = id;
        this.login = login;
        this.nome = nome;
    }
    
    
    
    public Pessoa(String nome, String sexo, String email, String cpf, 
            String idade, String endereco, String numero, String compl,
            String cep, String bairro, String cidade, String estado, String tel,
            String cel, String watsapp) {
        
        
        this.nome = nome;
        this.sexo = sexo;
        this.email = email;
        this.cpf = cpf;
        try {
            this.idade = new SimpleDateFormat("dd/MM/yyyy").parse(idade);
        } catch (ParseException ex) {
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.endereco = endereco;
        this.numero = numero;
        this.compl = compl;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.tel = tel;
        this.cel = cel;
        this.watsapp = watsapp;
    }

    public Pessoa(Integer id, String login, String nome, String sexo,
            String email, String cpf, String idade, String endereco, String numero,
            String compl, String cep, String bairro, String cidade, String estado,
            String tel, String cel, String watsapp) {
        this.id = id;
        this.login = login;
        this.nome = nome;
        this.sexo = sexo;
        this.email = email;
        this.cpf = cpf;
         try {
            this.idade = new SimpleDateFormat("dd/MM/yyyy").parse(idade);
        } catch (ParseException ex) {
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.endereco = endereco;
        this.numero = numero;
        this.compl = compl;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.tel = tel;
        this.cel = cel;
        this.watsapp = watsapp;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getIdade() {
        return idade;
    }

    public void setIdade(Date idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCompl() {
        return compl;
    }

    public void setCompl(String compl) {
        this.compl = compl;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTel() {
        return tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }
    
      public String getWatsapp() {
        return watsapp;
    }
 
    public void setWatsapp( String  watsapp) {
        this.watsapp = watsapp;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

  
    
    
}
