package src.main;

import java.math.BigDecimal;

import src.main.model.Cliente;
import src.main.model.Conta;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(int agencia, int codigoConta, Cliente cliente){
        super(agencia,codigoConta,cliente);
    }

    @Override
    public Conta abrirConta(Conta tipoConta) {
        ContaPoupanca conta = new ContaPoupanca( tipoConta.getAgencia(),tipoConta.getCodigoConta(),tipoConta.getCliente());
        Conta.contas.add(conta);
        return conta;
    }

    @Override
    public Conta sacar(BigDecimal valor) {

        return null;
    }

    @Override
    public Conta transferencia(Conta contaOrigem, Conta ContaDestino, BigDecimal valor) {
        // TODO Auto-generated method stub
        return null;
    }
}
