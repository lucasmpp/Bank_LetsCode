package src.main.model.conta;

import src.main.model.cliente.Cliente;

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
}
