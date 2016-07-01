/*
 * Universidade Federal de Santa Catarina
 * Trabalho INE5605
 * 
 */
package br.ufsc.ine5605.Controladores;

import br.ufsc.ine5605.telas.TelaCargo;
import br.ufsc.ine5605.telas.TelaEntrar;
import br.ufsc.ine5605.telas.TelaFuncionario;
import br.ufsc.ine5605.telas.TelaGeral;
import java.util.Date;

/**
 *
 * @author renan
 */
public class ControladorGeral {
    private ControladorAcesso controladorAcesso;
    private ControladorFuncionario controladorFuncionario;
    private Date horaAtual;
    private TelaGeral telaGeral;
    private TelaFuncionario telaFuncionario;
    private TelaCargo telaCargo;
    private TelaEntrar telaEntrar;
    
    
    public ControladorGeral() {
    controladorAcesso= new ControladorAcesso();
    controladorFuncionario= new ControladorFuncionario(this);
    telaGeral = new TelaGeral(this);
    telaFuncionario=new TelaFuncionario(this);
    telaCargo=new TelaCargo(this);
    telaEntrar=new TelaEntrar(this);
    }

    public Date getHoraAtual() {
        return horaAtual;
    }

    public void setHoraAtual(Date horaAtual) {
        this.horaAtual = horaAtual;
    }

    public void entrar(int matricula) {
        
    }

    public ControladorAcesso getControladorAcesso() {
        return controladorAcesso;
    }

    public ControladorFuncionario getControladorFuncionario() {
        return controladorFuncionario;
    }

    public TelaGeral getTelaGeral() {
        return telaGeral;
    }

    public TelaFuncionario getTelaFuncionario() {
        return telaFuncionario;
    }

    public TelaCargo getTelaCargo() {
        return telaCargo;
    }

    public TelaEntrar getTelaEntrar() {
        return telaEntrar;
    }

    
    
    
    

    
    
    
    
    
    
    
    
    
    
}
