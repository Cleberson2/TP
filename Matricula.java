package com.dudu;


public class Matricula extends Main{

    private short anoLetivo;
    private byte serie;
    private float notaPrimeiroBimestre = 0.0f;
    private float notaSegundoBimestre = 0.0f;
    private float notaTerceiroBimestre = 0.0f;
    private float notaQuartoBimestre = 0.0f;
    private boolean aprovado = false;
    private String status;
    private float media = 0.0f;
    private float mediaPonderada = 0.0f;

    private Aluno aluno = new Aluno();
    private Disciplina disciplina = new Disciplina();

    public short getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(short anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public byte getSerie() {
        return serie;
    }

    public void setSerie(byte serie) {
        this.serie = serie;
    }

    public float getNotaPrimeiroBimestre() {
        return notaPrimeiroBimestre;
    }

    public void setNotaPrimeiroBimestre(float notaPrimeiroBimestre) {
        this.notaPrimeiroBimestre = notaPrimeiroBimestre;
    }

    public float getNotaSegundoBimestre() {
        return notaSegundoBimestre;
    }

    public void setNotaSegundoBimestre(float notaSegundoBimestre) {
        this.notaSegundoBimestre = notaSegundoBimestre;
    }

    public float getNotaTerceiroBimestre() {
        return notaTerceiroBimestre;
    }

    public void setNotaTerceiroBimestre(float notaTerceiroBimestre) {
        this.notaTerceiroBimestre = notaTerceiroBimestre;
    }

    public float getNotaQuartoBimestre() {
        return notaQuartoBimestre;
    }

    public void setNotaQuartoBimestre(float notaQuartoBimestre) {
        this.notaQuartoBimestre = notaQuartoBimestre;
    }

    public boolean getAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Matricula(short anoLetivo, byte serie, float notaPrimeiroBimestre, float notaSegundoBimestre, float notaTerceiroBimestre, float notaQuartoBimestre, boolean aprovado, float media) {
        this.anoLetivo = anoLetivo;
        this.serie = serie;
        this.notaPrimeiroBimestre = notaPrimeiroBimestre;
        this.notaSegundoBimestre = notaSegundoBimestre;
        this.notaTerceiroBimestre = notaTerceiroBimestre;
        this.notaQuartoBimestre = notaQuartoBimestre;
        this.aprovado = aprovado;
        this.media = media;
    }

    private Matricula(short anoLetivo, byte serie) {

        this.anoLetivo = anoLetivo;
        this.serie = serie;
    }

    public Matricula() {

    }

    public Matricula(short anoLetivo, byte serie, Aluno aluno, Disciplina disciplina) {

        this.anoLetivo = anoLetivo;
        this.serie = serie;
        this.aluno = aluno;
        this.disciplina = disciplina;
    }

    public float maiorNota() {
        float resultado = 0.0f;

        if (notaPrimeiroBimestre > resultado) {
            resultado = notaPrimeiroBimestre;
        }

        if (notaSegundoBimestre > resultado) {
            resultado = notaSegundoBimestre;
        }
        if (notaTerceiroBimestre > resultado) {
            resultado = notaTerceiroBimestre;
        }
        if (notaQuartoBimestre > resultado) {
            resultado = notaQuartoBimestre;
        }

        return resultado;
    }

    public float menorNota() {
        float resultado = 9999999;

        if (notaPrimeiroBimestre < resultado) {
            resultado = notaPrimeiroBimestre;
        }

        if (notaSegundoBimestre < resultado) {
            resultado = notaSegundoBimestre;
        }
        if (notaTerceiroBimestre < resultado) {
            resultado = notaTerceiroBimestre;
        }
        if (notaQuartoBimestre < resultado) {
            resultado = notaQuartoBimestre;
        }

        return resultado;
    }

    public float media() {

        media = (notaPrimeiroBimestre + notaSegundoBimestre + notaTerceiroBimestre + notaQuartoBimestre) / 4;

        verifica();

        return media;
    }

    public float mediaPonderada(float[] notas, int[] pesos) {

        float somaNotas = 0;
        float somaPesos = 0;

        for (int i = 0; i < notas.length; i++) {
            somaNotas += notas[i] * pesos[i];
            somaPesos += pesos[i];
        }
        mediaPonderada = somaNotas / somaPesos;
        return somaNotas / somaPesos;
    }

    private void verifica() {

        if (getMedia() >= 7.0) {
            aprovado = true;
            status = "Aprovado";
        } else {
            aprovado = false;
            status = "Reprovado";
        }
    }

    public void impremeMatricula() {

        System.out.println("\n---------------------------\n");
        System.out.println("Media        :" + media + " " + status);
        System.out.println("Aluno:       :" + aluno.getNome());
        System.out.println("Disciplina   :" + disciplina.getNomeD());
        System.out.println("Serie        :" + serie);
        System.out.println("Ano letivo   :" + anoLetivo);
        System.out.println("\n---------------------------\n");
        menu();

    }
}
