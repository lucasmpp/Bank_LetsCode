package src.main;

import java.math.BigDecimal;

import src.main.model.Cliente;

public class ClientePessoaJuridica extends Cliente {
    String cnpf;
    private static final BigDecimal TAXA_SAQUE_TRANSFERENCIA = BigDecimal.valueOf(0.005);

    @Override
    public BigDecimal getTaxaConta() {
        
        return TAXA_SAQUE_TRANSFERENCIA;
    }
}
