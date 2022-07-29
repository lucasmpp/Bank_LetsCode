package src.main;

import java.util.List;

import src.main.model.cliente.ClientePessoaFisica;
import src.main.model.cliente.ClientePessoaJuridica;
import src.main.model.conta.Conta;
import src.main.model.conta.ContaCorrente;
import src.main.model.conta.ContaInvestimento;
import src.main.model.conta.ContaPoupanca;

public class Aplicacao{

    public static void main(String[] args) {
        Aplicacao aplicacao = new Aplicacao();
        
        ClientePessoaFisica cliente1 = new ClientePessoaFisica("12345678910","Jose","bairro desconhecido, casa desconhecida");
        ContaCorrente conta1 = new ContaCorrente(29548,462780,cliente1);

        ClientePessoaFisica cliente2 = new ClientePessoaFisica("12345678","Maria","bairro conhecido, outra casa");
        ContaCorrente conta2 = new ContaCorrente(29148,462280,cliente2);

        ClientePessoaJuridica cliente3 = new ClientePessoaJuridica("00000000001","Pedro","Rua da esperança");
        ContaInvestimento conta3 = new ContaInvestimento(29148,492280,cliente3);

        ClientePessoaJuridica cliente4 = new ClientePessoaJuridica("0000000333","Ana","Rua da esperança");
        ContaPoupanca conta4 = new ContaPoupanca(29149,461280,cliente4);

        //DEPOSITAR
        aplicacao
        .abrirConta(conta1);

        aplicacao
        .abrirConta(conta2)
        .depositar(100)
        .sacar(30); //ESPERADO 70

        aplicacao
        .abrirConta(conta4)
        .depositar(100);
        aplicacao.realizarTransferencia(conta4.fazerLogin(), conta1.fazerLogin(), 30); //ESPERADO 69.85 

        aplicacao.listarContas();
    }

    // public Conta realizarLogin(Conta conta){
    //     return conta.fazerLogin();
    // }

    public Conta realizarSaque(Conta conta,double valor){
        return conta.sacar(valor);
    }
    
    public Conta realizarDeposito(Conta conta,double valor){
        return conta.depositar(valor);
    }

    public Conta realizarTransferencia(Conta contaOrigem, Conta contaDestino, double valor){
        return Conta.transferencia(contaOrigem, contaDestino, valor);
    }

    public Conta abrirConta(Conta conta){
        if(Conta.isContaExistente(conta)){
            //TODO: Criar exceção
            System.out.println("LANÇAR EXCEÇÃO: Não é possível criar uma nova conta. Código de Conta"+
            "e código da agência já existente"
            );
        }
         return conta.abrirConta(conta);
    }

    public Conta ativarConta(Conta conta){
        conta.setEstadoConta(true);
        return conta;
    }

    public List<Conta> listarContas(){
        for(Conta conta:Conta.contas){
            System.out.println("TipoConta: "+conta.getClass().getSimpleName());
            System.out.println("TipoCliente: "+conta.getCliente().getClass().getSimpleName());
            System.out.println("nome: "+conta.getCliente().nome);
            System.out.println("saldo: "+conta.getSaldo());
            System.out.println();
        }
        return Conta.contas;
    }
    
}