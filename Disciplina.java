package com.dudu;

public class Disciplina {

    private int codigoDisciplina;
    private String nomeD;
    private int cargaHorariaGeral;

    public int getCodigoDisciplina () {return this.codigoDisciplina; }


    public String getNomeD () {return this.nomeD; }
    public void setNomeD (String nome) {
        if (nomeD != null)
            this.nomeD = nome;
    }

    public int getCargaHorariaGeral () {return this.cargaHorariaGeral; }
    public void setCargaHorariaGeral (int cargaHorariaGeral) {
        this.cargaHorariaGeral = cargaHorariaGeral;
    }

  /*public int getIdDisciplina (){return this.idDisciplina;}
  public void setIdDisciplina (int idDisciplina){
      this.idDisciplina = idDisciplina;
  }*/

    public Disciplina () {
        this.codigoDisciplina = 0;
        this.nomeD = " ";
        this.cargaHorariaGeral = 0;
    }

    public Disciplina (int codigoDisciplina, String nome, int cargaHorariaGeral) {
        this.codigoDisciplina = codigoDisciplina;
        this.nomeD = nome;
        this.cargaHorariaGeral = cargaHorariaGeral;
    }
}

