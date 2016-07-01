/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.persistencia;

import br.ufsc.ine5605.codigos.Cargo;
import java.util.HashMap;

/**
 *
 * @author Aluno2
 */
public class MapeadorCargo {

    private HashMap<Integer, Cargo> cargos = new HashMap<>();
    private final String filename = "candidatos.dat";

    public Cargo get(Integer idCargo) {
        return cargos.get(idCargo);
    }

    public void put(Cargo cargo) {
        cargos.put(cargo.getCodigo(), cargo);
    }

}
