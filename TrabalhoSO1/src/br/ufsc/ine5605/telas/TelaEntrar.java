/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.telas;

import br.ufsc.ine5605.Controladores.ControladorGeral;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Aluno2
 */
public class TelaEntrar extends JFrame {

    private ControladorGeral owner;
    private JFormattedTextField jFMatricula;
    private JLabel matriculaFuncionario;
    private Container janela;
    private JButton buttonEntr;
    private JButton buttonVolt;

    public TelaEntrar(ControladorGeral owner) {
        super("Entrar");
        this.owner = owner;
        jFMatricula = new JFormattedTextField();
        matriculaFuncionario = new JLabel("Matricula: ");
        janela = getContentPane();
        buttonEntr = new JButton("Entrar");
        buttonVolt = new JButton("Voltar");
        configura();
    }

    private void configura() {
        setLayout(null);
        matriculaFuncionario.setBounds(50, 40, 100, 20);
        buttonEntr.setBounds(20, 100, 100, 20);
        buttonVolt.setBounds(150, 100, 100, 20);
        jFMatricula.setBounds(150, 40, 100, 20);

        janela.add(jFMatricula);
        janela.add(matriculaFuncionario);
        janela.add(buttonEntr);
        janela.add(buttonVolt);
        setSize(285, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonEntr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int matricula = Integer.parseInt(jFMatricula.getText());

                owner.entrar(matricula);

            }
        });
        
        buttonVolt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                owner.getTelaGeral().inicia();
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
