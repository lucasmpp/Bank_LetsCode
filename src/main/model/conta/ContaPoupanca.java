package src.main.model.conta;


import src.exceptions.BankExceptions;
import src.main.model.cliente.Cliente;
import src.main.model.cliente.ClientePessoaJuridica;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(int agencia, int codigoConta, Cliente cliente){
        super(agencia,codigoConta,cliente);
    }

    @Override
    public Conta abrirConta(Conta tipoConta) {

        if(tipoConta.getCliente() instanceof ClientePessoaJuridica){
            throw new BankExceptions("1005");
        }

        ContaPoupanca conta = new ContaPoupanca( tipoConta.getAgencia(),tipoConta.getCodigoConta(),tipoConta.getCliente());
        Conta.contas.add(conta);
        return conta;
    }

   
}
