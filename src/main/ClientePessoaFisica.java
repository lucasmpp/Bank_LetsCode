package src.main;

import java.math.BigDecimal;

import src.main.model.Cliente;

public class ClientePessoaFisica extends Cliente {
    private String cpf;
    private static final BigDecimal TAXA_SAQUE_TRANSFERENCIA = BigDecimal.valueOf(0); 

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    ClientePessoaFisica(){}
    ClientePessoaFisica(String cpf, String endereco, String nome){
        this.cpf = cpf;
        this.endereco = endereco;
        this.nome = nome;
    }

    @Override
    public BigDecimal getTaxaConta() {
        return TAXA_SAQUE_TRANSFERENCIA;
    }
}
