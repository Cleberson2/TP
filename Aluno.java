package com.dudu;

import java.util.Calendar;

public class Aluno {

    // Atributos
    Disciplina disciplina = new Disciplina();
    DisciplinaPratica disciplinaPratica = new DisciplinaPratica();

    private int idAluno;
    private String nome;
    private char sexo;
    private Calendar nascimento;
    private int idade;

    private final int MAX_ALUNO = 10;
    private final int MAX_DISCIPLINA = 5;
    private final int MAX_MATRICULAS = 30;

    // Propriedades
    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public DisciplinaPratica getDisciplinaPratica() {
        return disciplinaPratica;
    }

    public void setDisciplinaPratica(DisciplinaPratica disciplinaPratica) {
        this.disciplinaPratica = disciplinaPratica;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    //Construtores
    public Aluno() {

    }

    public Aluno(String nome, int idade, int idAluno, Calendar nascimento, char sexo) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.idAluno = idAluno;
        this.nascimento = nascimento;
    }

    public String nomeCompleto() {
        return this.nome;
    }

} // fim da classe Aluno




