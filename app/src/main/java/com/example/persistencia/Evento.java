package com.example.persistencia;

public class Evento {

    private int id;
    private String descricao;
    private String curso;
    private String url;

    public Evento(int id, String descricao, String curso, String url) {
        this.id = id;
        this.descricao = descricao;
        this.curso = curso;
        this.url = url;
    }

    public Evento(String descricao, String curso, String url) {
        this.descricao = descricao;
        this.curso = curso;
        this.url = url;
    }

    public Evento(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", curso='" + curso + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
