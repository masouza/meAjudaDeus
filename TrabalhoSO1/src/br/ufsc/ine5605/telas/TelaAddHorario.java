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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author UFSC-420
 */
public class TelaAddHorario extends JFrame {
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    private ControladorGeral owner;
    private JFormattedTextField jFHora;
    private JLabel horaAtual;
    private Container janela;
    private JButton buttonConf;
    private JButton buttonVolt;

    public TelaAddHorario(ControladorGeral owner) {
        super("Horario Atual");
        this.owner=owner;
        jFHora = new JFormattedTextField();
        horaAtual = new JLabel("Hora Atual: ");
        janela = getContentPane();
        buttonConf = new JButton("Adicionar");
        buttonVolt = new JButton("Voltar");
        configura();
    }

    public void configura() {
        setLayout(null);
        horaAtual.setBounds(50, 40, 100, 20);
        buttonConf.setBounds(20, 100, 100, 20);
        buttonVolt.setBounds(150, 100, 100, 20);

        MaskFormatter mascaraHora = null;

        try {
            mascaraHora = new MaskFormatter("##:##");
            mascaraHora.setPlaceholderCharacter('_');
        } catch (ParseException excp) {
            System.err.println("Erro na formatação: " + excp.getMessage());
            System.exit(-1);
        }
        
        
        
        jFHora = new JFormattedTextField(mascaraHora);
        jFHora.setBounds(150, 40, 40, 20);
        
        janela.add(jFHora);
        janela.add(horaAtual);
        janela.add(buttonConf);
        janela.add(buttonVolt);
        setSize(285, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    
            buttonConf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    owner.setHoraAtual(sdf.parse(jFHora.getText()));
                } catch (ParseException ex) {
                
                
                }
            
            }
        
    });
    
    
    
    
    
    
    
    
    }

    public void inicia() {
        setVisible(true);
    }


}
