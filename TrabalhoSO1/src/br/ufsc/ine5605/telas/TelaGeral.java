/*
 * Universidade Federal de Santa Catarina
 * Trabalho INE5605
 * 
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
 * @author renan
 */
public class TelaGeral extends JFrame {

    private JButton buttonEntr;
    private JButton buttonFunc;
    private JButton buttonCarg;
    private JButton buttonSair;
    private Container janela;
    private ControladorGeral owner;

    public TelaGeral(ControladorGeral owner) {
        super("Controle de Portas");
        buttonEntr = new JButton("Entrar");
        buttonFunc = new JButton("Funcionarios");
        buttonCarg = new JButton("Cargos");
        buttonSair = new JButton("Sair");
        janela = getContentPane();
        this.owner = owner;
        configura();
    }

    public void configura() {
        setLayout(null);
        buttonEntr.setBounds(30, 20, 120, 20);
        buttonFunc.setBounds(30, 60, 120, 20);
        buttonCarg.setBounds(30, 100, 120, 20);
        buttonSair.setBounds(30, 140, 120, 20);
        janela.add(buttonEntr);
        janela.add(buttonFunc);
        janela.add(buttonCarg);
        janela.add(buttonSair);
        setSize(200, 220);


        buttonEntr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                owner.getTelaEntrar().inicia();
                fecha();
            }
        });
        
        
        buttonCarg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                owner.getTelaCargo().inicia();
                fecha();
            }
        });

        buttonFunc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                owner.getTelaFuncionario().inicia();
                fecha();
            }
        });

        buttonSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
    
    
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void inicia() {
        setVisible(true);
    }

    public void fecha() {
        setVisible(false);
    }

    public static void main(String[] args) {
        ControladorGeral teste = new ControladorGeral();
        TelaGeral tela = new TelaGeral(teste);
        tela.inicia();
    }
}
