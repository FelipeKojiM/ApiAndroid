package com.example.sub.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DtoPaises {
    @JsonProperty("Código")
    private int codigo;

    @JsonProperty("Descrição")
    private String descricao;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}