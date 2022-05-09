/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.models;

/**
 *
 * @author renea
 */
public class Treinos {
    private int id;
    private Aluno aluno;
    private Professor professor;
    private String nomeExerci;
    private String serie;
    private String rep;
    private String carga;
    private String membro;

    public Treinos() {
    }

    public Treinos(int id, Aluno aluno, Professor professor, String nomeExerci, String serie, String rep, String carga, String membro) {
        this.id = id;
        this.aluno = aluno;
        this.professor = professor;
        this.nomeExerci = nomeExerci;
        this.serie = serie;
        this.rep = rep;
        this.carga = carga;
        this.membro = membro;
    }

    public Treinos(Aluno aluno, Professor professor, String nomeExerci, String serie, String rep, String carga, String membro) {
        this.aluno = aluno;
        this.professor = professor;
        this.nomeExerci = nomeExerci;
        this.serie = serie;
        this.rep = rep;
        this.carga = carga;
        this.membro = membro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getNomeExerci() {
        return nomeExerci;
    }

    public void setNomeExerci(String nomeExerci) {
        this.nomeExerci = nomeExerci;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    public String getCarga() {
        return carga;
    }

    public void setCarga(String carga) {
        this.carga = carga;
    }

    public String getMembro() {
        return membro;
    }

    public void setMembro(String membro) {
        this.membro = membro;
    }
    
     
}
