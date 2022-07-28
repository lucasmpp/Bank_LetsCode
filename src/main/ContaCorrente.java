package src.main;

import java.math.BigDecimal;

import src.main.model.Cliente;
import src.main.model.Conta;

public class ContaCorrente extends Conta {
    @Override
    public  Conta abrirConta(Conta tipoConta) {
        ContaCorrente conta = new ContaCorrente( tipoConta.getAgencia(),tipoConta.getCodigoConta(),tipoConta.getCliente());
        Conta.contas.add(conta);
        return conta;
    }

    public ContaCorrente(int agencia, int codigoConta, Cliente cliente){
        super(agencia,codigoConta,cliente);
    }

    @Override
    public Conta sacar(BigDecimal valor) {
        setSaldo(getSaldo().subtract(valor) );
        return this;
    }

    @Override
    public Conta transferencia(Conta contaOrigem, Conta ContaDestino, BigDecimal valor) {
        // TODO Auto-generated method stub
        return null;
    }
}
