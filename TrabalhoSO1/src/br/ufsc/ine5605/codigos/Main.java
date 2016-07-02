/*
 * Universidade Federal de Santa Catarina
 * Trabalho INE5605
 * 
 */
package br.ufsc.ine5605.codigos;

import br.ufsc.ine5605.Controladores.ControladorFuncionario;
import br.ufsc.ine5605.Controladores.ControladorGeral;
import br.ufsc.ine5605.telas.TelaAddFuncionario;
import br.ufsc.ine5605.telas.TelaGeral;

/**
 *
 * @author renan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControladorGeral teste = new ControladorGeral();
        TelaGeral telaG = new TelaGeral(teste);
        telaG.inicia();
    }

}
