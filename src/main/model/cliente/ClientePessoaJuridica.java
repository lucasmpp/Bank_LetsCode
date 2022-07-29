package src.main.model.cliente;

import java.math.BigDecimal;

public class ClientePessoaJuridica extends Cliente {
    String cnpj;
    private static final BigDecimal TAXA_SAQUE_TRANSFERENCIA = BigDecimal.valueOf(0.005);
    private static final BigDecimal TAXA_INVESTIMENTO = ClientePessoaFisica.TAXA_INVESTIMENTO.add(BigDecimal.valueOf(0.02));


    public ClientePessoaJuridica(String cnpj,  String nome,String endereco){
        super(nome,endereco);
        this.cnpj = cnpj;
    }

    @Override
    public BigDecimal getTaxaConta() {
        
        return TAXA_SAQUE_TRANSFERENCIA;
    }

    @Override
    public BigDecimal getTaxaInvestimento() {
        return TAXA_INVESTIMENTO;
    }
   

}
