/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.telas;

import br.ufsc.ine5605.Controladores.ControladorFuncionario;
import br.ufsc.ine5605.Controladores.ControladorGeral;
import br.ufsc.ine5605.codigos.TipoCargo;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author UFSC-420
 */
public class TelaAddCargo extends JFrame {

    private JButton adicionar;
    private JButton buttonVolt;
    private JTextField TFCod;
    private JTextField TFNome;
    private JLabel labelTipo;
    private JLabel labelCod;
    private JLabel labelNome;
    private JComboBox<Object> boxDeCargo;
    private TipoCargo tipo;
    Container janela = getContentPane();
    private ControladorFuncionario owner;

    public TelaAddCargo(ControladorFuncionario owner) {
        super("Adicionar Cargo");
        this.owner = owner;

        adicionar = new JButton("Adicionar");
        buttonVolt = new JButton("Voltar");

        TFCod = new JTextField();
        TFNome = new JTextField();
        labelTipo = new JLabel("Tipo: ");
        labelCod = new JLabel("Codigo: ");
        labelNome = new JLabel("Nome: ");
        boxDeCargo = new JComboBox<Object>();
        configurar();
    }

    public void configurar() {

        boxDeCargo.addItem(tipo.Gerencial);
        boxDeCargo.addItem(tipo.Padrao);
        boxDeCargo.addItem(tipo.SemAcesso);

        setLayout(null);
        TFCod.setBounds(95, 40, 100, 20);
        TFNome.setBounds(95, 80, 100, 20);
        boxDeCargo.setBounds(95, 120, 100, 20);
        labelTipo.setBounds(50, 120, 100, 20);
        labelCod.setBounds(50, 40, 100, 20);
        labelNome.setBounds(50, 80, 100, 20);

        adicionar.setBounds(30, 200, 90, 20);
        buttonVolt.setBounds(130, 200, 90, 20);

        janela.add(adicionar);
        janela.add(buttonVolt);
        janela.add(TFCod);
        janela.add(TFNome);
        janela.add(labelCod);
        janela.add(labelNome);
        janela.add(boxDeCargo);
        janela.add(labelTipo);
        setSize(250, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        adicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int codigo = Integer.parseInt(TFCod.getText());
                String nome = TFNome.getText();
                TipoCargo cargo = (TipoCargo) boxDeCargo.getSelectedItem();

                if (owner.verificaCargo(codigo)) {
                    owner.addCargo(codigo, nome, cargo);

                    owner.getTelaMostraCargos().updateData();
                    

                    JOptionPane.showMessageDialog(null, "Cargo Adicionado com Sucesso");
                    owner.getOwner().getTelaCargo().inicia();
                    fecha();
                } else {
                    JOptionPane.showMessageDialog(null, cargo);
                    owner.getOwner().getTelaGeral().inicia();
                    fecha();
                }

            }
        });

        buttonVolt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                owner.getOwner().getTelaGeral().inicia();
                fecha();
            }
        });

    }

    public void inicia() {
        setVisible(true);
    }

    public void fecha() {
        setVisible(false);
    }



}
