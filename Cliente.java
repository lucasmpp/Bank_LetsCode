import java.util.ArrayList;
import java.util.List;

public abstract class  Cliente {
    List<Conta> conta = new ArrayList<>();
    String endereco = "";
    String nome;
    
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

    public abstract void sacar();
    
    public abstract void transferencia();
    public abstract void investir(double taxaInvestimento);

}
