package com.dudu;

import java.util.ArrayList;
import java.util.Scanner;

import sun.security.util.DisabledAlgorithmConstraints;

public class Main{

    static Scanner entrada = new Scanner(System.in);
    private static int contadorDisciplina;
    private static int contadorAluno;
    private static Disciplina disciplina = new Disciplina();
    ;
    static int idAluno = 0;
    private static int codigoD;
    private static String nomeD;
    private static int cargaHoraria;
    static String opcao;
    static ArrayList<Disciplina> disciplinas = new ArrayList<>();
    static ArrayList<Aluno> alunos = new ArrayList<>();
    static ArrayList<Matricula> matriculas = new ArrayList<>();

    public Main() {
        contadorAluno = 0;
        contadorDisciplina = 0;
    }

    static void cadastrarDisciplina() {

        do {

            System.out.println("Digite nome da disciplina");
            nomeD = entrada.next();

            System.out.println("Digite codigo da disciplina");
            codigoD = entrada.nextInt();

            System.out.println("Digite a carga horaria da disciplina");
            cargaHoraria = entrada.nextInt();

            disciplinas.add(new Disciplina(codigoD, nomeD, cargaHoraria));

            System.out.println("Disciplina: " + nomeD + "cadastrada, ID " + codigoD + "\nQuantidade total de disciplinas cadastradas: " + disciplinas.size());

            System.out.println("Cadastrar outra discinplina? (s/n)");
            opcao = entrada.next();

        } while (opcao.toLowerCase().equals("s"));
        menu();

    }

    static void cadastrarAluno() {

        do {

            Aluno aluno = new Aluno();

            System.out.println("Digite nome do aluno: ");
            String nome = entrada.next();
            aluno.setNome(nome);

            System.out.println("Digite sexo: ");
            char sexo = entrada.next().charAt(0);
            aluno.setSexo(sexo);

            System.out.println("Digite idade: ");
            int idade = entrada.nextInt();
            aluno.setIdade(idade);

            System.out.println("Digite o ID do aluno:");
            int idAluno = entrada.nextInt();
            aluno.setIdAluno(idAluno);

            alunos.add(aluno);

            System.out.println("Aluno " + aluno.getNome() + " cadastrado, ID: " + aluno.getIdAluno() + "\nQuantidade total de alunos cadastrados: " + contadorAluno);

            System.out.println("Cadastrar outro aluno? (s/n)");
            opcao = entrada.next();

        } while (opcao.toLowerCase().equals("s"));
        menu();

    } // CadastraAluno();

    static void matriculaAluno() {

        int idAluno = 0;
        int idDisciplina = 0;
        short anoLetivo;
        byte serie;
        Aluno aluno = new Aluno();
        Disciplina disciplina = new Disciplina();
        Matricula matricula;

        System.out.println("Digite o ano letivo");
        anoLetivo = entrada.nextShort();

        System.out.println("Digite a serie");
        serie = entrada.nextByte();

        System.out.println("Digite o identificador do aluno");
        idAluno = entrada.nextInt();

        System.out.println("Escolha a disciplina:\n");
        for (int i = 0; i < disciplinas.size(); i++) {
            System.out.println(disciplinas.get(i).getCodigoDisciplina() + " - " + disciplinas.get(i).getNomeD());
        }
        System.out.println("Digite id da disciplina");
        idDisciplina = entrada.nextInt();

        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getIdAluno() == idAluno) {
                aluno = alunos.get(i);
            }
        }

        for (int i = 0; i < disciplinas.size(); i++) {
            if (disciplinas.get(i).getCodigoDisciplina() == idDisciplina) {
                disciplina = disciplinas.get(i);
            }
        }

        matriculas.add(new Matricula(anoLetivo, serie, aluno, disciplina));
        System.out.println("\t\tRetornando ao menu principal.\n");

        menu();

    } // Fim do método matriculaAluno

    static void lancarNota() {

        int idAluno = 0;
        int idDisciplina = 0;
        int contador = 0;
        float media;

        //do{
        Disciplina disciplina = new Disciplina();

        System.out.println("Digite o identificador do aluno");
        idAluno = entrada.nextInt();

        System.out.println("Escolha a disciplina:\n");
        for (int i = 0; i < disciplinas.size(); i++) {
            System.out.println(disciplinas.get(i).getCodigoDisciplina() + " - " + disciplinas.get(i).getNomeD());
        }
        idDisciplina = entrada.nextInt();

        for (int i = 0; i < matriculas.size(); i++) {
            if (matriculas.get(i).getDisciplina().getCodigoDisciplina() == idDisciplina) {
                if (matriculas.get(i).getAluno().getIdAluno() == idAluno) {

                    System.out.println("Digite a nota do primeiro bimestre");
                    matriculas.get(i).setNotaPrimeiroBimestre(entrada.nextFloat());

                    System.out.println("Digite a nota do segundo bimestre");
                    matriculas.get(i).setNotaSegundoBimestre(entrada.nextFloat());

                    System.out.println("Digite a nota do terceiro bimestre");
                    matriculas.get(i).setNotaTerceiroBimestre(entrada.nextFloat());

                    System.out.println("Digite a nota do quarto bimestre");
                    matriculas.get(i).setNotaQuartoBimestre(entrada.nextFloat());
                    ++contador;
                    media=matriculas.get(i).media();
                    System.out.println(media);
                    if(matriculas.get(i).getAprovado()){
                        System.out.println("Aprovado\n\n");
                    }
                    else{
                        System.out.println("Reprovado\n\n");
                    }

                }
            }
        }
        if (contador == 0) {
            System.out.println("Não foi encontrado esse aluno nessa disciplina!\n\n");
        }
        System.out.println("\t\tRetornando ao menu principal\n");
        menu();


    }

    public static void imprimirRegistros(){

        for(int i = 0; i<matriculas.size(); i++){
            matriculas.get(i).impremeMatricula();
        }
        menu();

    }
    public static void menu() {

        int opcao;

        System.out.println("Menu principal\n\nDigite\n1 - Para cadastrar Disciplina\n2 - Para cadastrar Aluno\n3 - Matricular aluno em uma disciplina\n4 - Lançar nota aluno\n5 - Imprimir registros\n6 - Sair do sistema");
        opcao = entrada.nextInt();

        switch (opcao) {

            case 1:
                cadastrarDisciplina();
                break;
            case 2:
                cadastrarAluno();
                break;
            case 3:
                matriculaAluno();
                break;
            case 4:
                lancarNota();
            case 5:
                imprimirRegistros();
            case 6:
                System.exit(0);
                break;
            default:
                menu();
                break;

        } // Fim do switch

    } // Fim do menu

    public static void main(String[] args) {

        menu();

    } // Fim do método main

} // Fim da classe main