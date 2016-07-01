/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.telas;

import br.ufsc.ine5605.Controladores.ControladorFuncionario;
import br.ufsc.ine5605.Controladores.ControladorGeral;
import br.ufsc.ine5605.codigos.Funcionario;
import java.awt.GridLayout;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aluno2
 */
public class teste extends JFrame {

    private JPanel painelFundo;
    private JTable tabela;
    private JScrollPane barraRolagem;
    private ControladorFuncionario owner;


    public teste(ControladorFuncionario owner) {
        super("Funcionarios");
           this.owner=owner;
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

    public void updateData(){
        DefaultTableModel modelTbFuncionarios = new DefaultTableModel();
        modelTbFuncionarios.addColumn("Matricula");
        modelTbFuncionarios.addColumn("Nome");
        modelTbFuncionarios.addColumn("Telefone");
        modelTbFuncionarios.addColumn("Salario");
        modelTbFuncionarios.addColumn("Cargo");
        modelTbFuncionarios.addColumn("Nascimento");
        
        
        Set<Integer> chaves =owner.getFuncionarios().keySet();
        
        
        
        for (Integer chave : chaves) {
            if(chave!=null){
            modelTbFuncionarios.addRow(new Object[] {owner.getFuncionarios().get(chave).getMatricula(),owner.getFuncionarios().get(chave).getNome(),
                owner.getFuncionarios().get(chave).getTelefone(),owner.getFuncionarios().get(chave).getSalario(), owner.getFuncionarios().get(chave).getCargo(),
            });
        }
        
        tabela.setModel(modelTbFuncionarios);
        this.repaint();
        }
    }
    
    
    
    public void Inicia() {
        setVisible(true);
    }

    public static void main(String[] args) {
        ControladorGeral ownerr=new ControladorGeral();
        ControladorFuncionario owner = new ControladorFuncionario(ownerr);
        teste teste = new teste(owner);
    }
}
