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
@DiscriminatorValue("Professor")
public class Professor extends Pessoa{
   
    private String horario;
    private String Cargo;
    

    public Professor() {
    }

    
    
    public Professor(String nome) {
        this.nome = nome;
    }

    public Professor(int id, String login, String nome) {
        super(id, login, nome);
    }
    
    
    
    public Professor(String horario, String Cargo,
            String nome, String sexo, String email, String cpf, String idade,
            String endereco, String numero, String complemento, String cep,
            String bairro, String cidade, String estado, String tel, String cel, String watsapp) {
        super(nome, sexo, email, cpf, idade, endereco, numero, complemento, cep,
                bairro, cidade, estado, tel, cel, watsapp);
        this.horario = horario;
        this.Cargo = Cargo;
        
    }

    public Professor(String horario, String Cargo, Integer id, String login, String nome, String sexo, String email, String cpf, String idade, String endereco, String numero, String compl, String cep, String bairro, String cidade, String estado, String tel, String cel, String watsapp) {
        super(id, login, nome, sexo, email, cpf, idade, endereco, numero, compl, cep, bairro, cidade, estado, tel, cel, watsapp);
        this.horario = horario;
        this.Cargo = Cargo;
    }
    
    
 
 
    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    @Override
    public String toString(){
    
        return getNome();
    
    }
    
}
