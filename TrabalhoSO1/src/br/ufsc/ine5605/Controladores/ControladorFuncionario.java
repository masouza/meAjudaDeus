/*
 * Universidade Federal de Santa Catarina
 * Trabalho INE5605
 * 
 */
package br.ufsc.ine5605.Controladores;

import br.ufsc.ine5605.codigos.Cargo;
import br.ufsc.ine5605.codigos.Funcionario;
import br.ufsc.ine5605.codigos.TipoCargo;
import br.ufsc.ine5605.telas.TelaAddCargo;
import br.ufsc.ine5605.telas.TelaAddFuncionario;
import br.ufsc.ine5605.telas.TelaMostraCargos;
import br.ufsc.ine5605.telas.TelaMostraFuncionarios;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author renan
 */
public class ControladorFuncionario {

    private HashMap<Integer, Funcionario> funcionarios = new HashMap<>();
    private HashMap<Integer, Cargo> cargos = new HashMap<>();
    private TelaAddFuncionario telaAddFuncionario;
    private TelaAddCargo telaAddCargo;
    private TelaMostraFuncionarios telaMostraFuncionarios;
    private TelaMostraCargos telaMostraCargos;
    private ControladorGeral owner;

    public ControladorFuncionario(ControladorGeral owner) {
        this.telaAddFuncionario = new TelaAddFuncionario(this);
        this.telaAddCargo=new TelaAddCargo(this);
        this.telaMostraFuncionarios=new TelaMostraFuncionarios(this);
        this.telaMostraCargos=new TelaMostraCargos(this);
        this.owner = owner;
    }

    public HashMap<Integer, Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(HashMap<Integer, Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public HashMap<Integer, Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(HashMap<Integer, Cargo> cargos) {
        this.cargos = cargos;
    }

    public TelaAddFuncionario getTelaAddFuncionario() {
        return telaAddFuncionario;
    }

    public void setTelaAddFuncionario(TelaAddFuncionario telaFuncionario) {
        this.telaAddFuncionario = telaFuncionario;
    }

    public ControladorGeral getOwner() {
        return owner;
    }

    public void setOwner(ControladorGeral owner) {
        this.owner = owner;
    }

    public TelaMostraFuncionarios getTelaMostraFuncionarios() {
        return telaMostraFuncionarios;
    }

    public TelaMostraCargos getTelaMostraCargos() {
        return telaMostraCargos;
    }

    public TelaAddCargo getTelaAddCargo() {
        return telaAddCargo;
    }

    
    
    
    public void addFuncionario(Integer matricula, String nome, long telefone, float salario, Date nascimento,TipoCargo cargo) {
        Funcionario funcionario = new Funcionario();
        funcionario.setMatricula(matricula);
        funcionario.setNome(nome);
        funcionario.setTelefone(telefone);
        funcionario.setSalario(salario);
        funcionario.setNascimento(nascimento);
        //funcionario.setCargo(cargo);
        funcionarios.put(matricula, funcionario);
    }

    public void addCargo(Integer codigo, String nome, TipoCargo tipoCargo){
    Cargo cargo = new Cargo();
        cargo.setCodigo(codigo);
        cargo.setNome(nome);
        cargo.setTipoCargo(tipoCargo);
        cargos.put(codigo, cargo);
        
    }

    public boolean verificaCargo(int codigo) {
        if (!cargos.containsKey(codigo)) {
            return true;
        }

        return false;
    }

    
    public Cargo findCargo(int codigo){
        if(cargos.containsKey(codigo)){
            return cargos.get(codigo);
        }
        
    return null;
    }
}
