package src.main.model;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class  Cliente {
    public List<Conta> conta = new ArrayList<>();
    public String endereco = "";
    public String nome;
    
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
