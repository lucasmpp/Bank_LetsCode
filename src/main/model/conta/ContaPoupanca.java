package src.main.model.conta;


import src.main.model.cliente.Cliente;

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
}
