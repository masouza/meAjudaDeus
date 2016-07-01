/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.persistencia;

import br.ufsc.ine5605.codigos.Funcionario;
import java.util.HashMap;

/**
 *
 * @author Aluno2
 */
public class MapeadorFuncionario {

    private HashMap<Integer, Funcionario> funcionarios = new HashMap<>();
    private final String filename = "candidatos.dat";

    public Funcionario get(Integer idFuncionario) {
        return funcionarios.get(idFuncionario);
    }

    public void put(Funcionario funcionario) {
        funcionarios.put(funcionario.getMatricula(), funcionario);
    }

}
