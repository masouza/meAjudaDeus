/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.telas;

import br.ufsc.ine5605.Controladores.ControladorFuncionario;
import java.awt.GridLayout;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author UFSC-420
 */
public class TelaMostraCargos extends JFrame {

    private JPanel painelFundo;
    private JTable tabela;
    private JScrollPane barraRolagem;
    private ControladorFuncionario owner;

    public TelaMostraCargos(ControladorFuncionario owner) {
        super("Cargos");
        this.owner = owner;
        criaJanela();
    }

    public void criaJanela() {

        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(1, 1));
        tabela = new JTable();
        barraRolagem = new JScrollPane(tabela);
        painelFundo.add(barraRolagem);

        getContentPane().add(painelFundo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

    }

    public void updateData() {
        DefaultTableModel modelTbCargos = new DefaultTableModel();
        modelTbCargos.addColumn("Codigo");
        modelTbCargos.addColumn("Nome");
        modelTbCargos.addColumn("Tipo-Cargo");

        Set<Integer> chaves = owner.getCargos().keySet();

        for (Integer chave : chaves) {
            if (chave != null) {
                modelTbCargos.addRow(new Object[]{owner.getCargos().get(chave).getCodigo(), owner.getCargos().get(chave).getNome(),
                    owner.getCargos().get(chave).getTipoCargo()
                });
            }

            tabela.setModel(modelTbCargos);
            this.repaint();
        }
    }

    public void Inicia() {
        setVisible(true);
    }

    public void fecha() {
        setVisible(false);
    }
}
