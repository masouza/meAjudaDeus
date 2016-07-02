/*
 * Universidade Federal de Santa Catarina
 * Trabalho INE5605
 * 
 */
package br.ufsc.ine5605.codigos;

import java.io.Serializable;

/**
 *
 * @author renan
 */
public class Cargo implements Serializable{
    
    
    private static final long serialVersionUID = 1L;
    private Integer codigo;
    private String nome;
    private TipoCargo tipoCargo;

    public Cargo() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoCargo getTipoCargo() {
        return tipoCargo;
    }

    public void setTipoCargo(TipoCargo tipoCargo) {
        this.tipoCargo = tipoCargo;
    }
    
       
}
