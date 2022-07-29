package src.main.model.cliente;

import java.math.BigDecimal;

public class ClientePessoaFisica extends Cliente {
    private String cpf;
    private static final BigDecimal TAXA_SAQUE_TRANSFERENCIA_PJ = BigDecimal.valueOf(0); 
    public static final BigDecimal TAXA_INVESTIMENTO = BigDecimal.valueOf(0.000332); 

    public ClientePessoaFisica(String cpf,  String nome,String endereco){
        super(nome,endereco);
        this.cpf = cpf;
    }

     public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public BigDecimal getTaxaConta() {
        return TAXA_SAQUE_TRANSFERENCIA_PJ;
    }

    @Override
    public BigDecimal getTaxaInvestimento() {
        return TAXA_INVESTIMENTO;
    }
}
