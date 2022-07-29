package src.main.model.cliente;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import src.main.model.conta.Conta;

public abstract class  Cliente {
    public List<Conta> conta = new ArrayList<>();
    public String endereco = "";
    public String nome;
    
    public Cliente(String nome,String endereco){
        this.nome = nome;
        this.endereco = endereco;
    }
    
    public Cliente(){};

    public List<Conta> getConta() {
        return conta;
    }

    public void setConta(List<Conta> conta) {
        this.conta = conta;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract BigDecimal getTaxaConta();

}
