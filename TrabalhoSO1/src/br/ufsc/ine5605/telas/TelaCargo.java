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
import javax.swing.JFrame;

/**
 *
 * @author UFSC-420
 */
public class TelaCargo extends JFrame{
    
    private JButton buttonAdd;
    private JButton buttonRemov;
    private JButton buttonAlt;
    private JButton buttonList;
    private JButton buttonVolt;
    private Container janela;
    private ControladorGeral owner;
    
    public TelaCargo(ControladorGeral owner) {
        super("Cargo");
        buttonAdd = new JButton("Adicionar");
        buttonRemov = new JButton("Remover");
        buttonAlt = new JButton("Alterar");
        buttonList = new JButton("Listar");
        buttonVolt = new JButton("Voltar");
        janela = getContentPane();
        this.owner=owner;
        configura();
    }


    public void configura() {
        setLayout(null);
        buttonAdd.setBounds(30, 20, 120, 20);
        buttonRemov.setBounds(30, 60, 120, 20);
        buttonList.setBounds(30, 140, 120, 20);
        buttonAlt.setBounds(30, 100, 120, 20);
        buttonVolt.setBounds(30, 180, 120, 20);
        janela.add(buttonAdd);
        janela.add(buttonRemov);
        janela.add(buttonList);
        janela.add(buttonAlt);
        janela.add(buttonVolt);
        setSize(200, 270);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            owner.getControladorFuncionario().getTelaAddCargo().inicia();
            fecha();
            }
        });

        buttonRemov.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        buttonList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                owner.getControladorFuncionario().getTelaMostraCargos().Inicia();
                fecha();
            }
        });

        buttonAlt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

 
        buttonVolt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
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
