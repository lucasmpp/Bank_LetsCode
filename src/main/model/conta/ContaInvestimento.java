package src.main.model.conta;

import src.main.model.cliente.Cliente;

public class ContaInvestimento extends Conta  {

    public ContaInvestimento(int agencia, int codigoConta, Cliente cliente){
        super(agencia,codigoConta,cliente);
    }

    @Override
    public Conta abrirConta(Conta tipoConta) {
        ContaInvestimento conta = new ContaInvestimento( tipoConta.getAgencia(),tipoConta.getCodigoConta(),tipoConta.getCliente());
        Conta.contas.add(conta);
        return conta;
    }

}
