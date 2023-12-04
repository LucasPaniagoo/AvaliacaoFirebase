package com.lucaspaniago.avaliacaofirebase;

public class Pedido {
    private int id;
    private String codRoupa;
    private String nome;
    private String cor;
    private String tamanho;
    private String quantidade;
    private String nomcli;
    private String telefone;
    private String sitpag;

    //getters and setters

    public String getCodRoupa() {
        return codRoupa;
    }

    public void setCodRoupa(String codRoupa) {
        this.codRoupa = codRoupa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getNomcli() {
        return nomcli;
    }

    public void setNomcli(String nomcli) {
        this.nomcli = nomcli;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSitpag() {
        return sitpag;
    }

    public void setSitpag(String sitpag) {
        this.sitpag = sitpag;
    }
}
