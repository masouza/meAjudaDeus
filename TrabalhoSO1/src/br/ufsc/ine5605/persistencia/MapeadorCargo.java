/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.persistencia;

import br.ufsc.ine5605.Controladores.ControladorFuncionario;
import br.ufsc.ine5605.codigos.Cargo;
import br.ufsc.ine5605.codigos.Funcionario;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 *
 * @author NEGO BAM
 */
public class MapeadorCargo {

    private ControladorFuncionario owner;
    private HashMap<Integer, Cargo> cargos;
    private final String filename = "candidatos.dat";

    public MapeadorCargo(ControladorFuncionario owner) {
        this.owner = owner;
        this.cargos = owner.getCargos();
    }

    public void setCargo() {
        this.cargos = owner.getCargos();
    }
    
    public HashMap getCargos(){
        return cargos;
    }

    public void persist() {
        setCargo();
        try {
            FileOutputStream fout = new FileOutputStream(filename);
            
            ObjectOutputStream oo = new ObjectOutputStream(fout);
            oo.writeObject(cargos);
            
            oo.flush();
            fout.flush();
            
            oo.close();
            fout.close();
            oo = null;
            fout = null;

        } catch (FileNotFoundException ex) {
            System.out.println("Ops, ocorreu o erro: "+ ex);
        } catch (IOException ex) {
            System.out.println("Ops, ocorreu o erro" + ex);
        }

    }

    public void load(){
        
        try{
            FileInputStream fin = new FileInputStream(filename);
            ObjectInputStream oi = new ObjectInputStream(fin);
            
            this.cargos = (HashMap<Integer, Cargo>) oi.readObject();
            
            oi.close();
            fin.close();
            oi  = null;
            fin = null;
            
        }
        catch(ClassNotFoundException ex){
            System.out.println("Ops, ocorreu o erro: "+ex);
        }
        catch(FileNotFoundException ex){
            System.out.println("Ops, ocorreu o erro: "+ex);
        }
        catch(IOException ex){
            System.out.println("Ops, ocorreu o erro: "+ex);
        }
        owner.setCargos(cargos);
    }
    
    
}
