package src.main;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import src.exceptions.BankExceptions;
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

        ClientePessoaFisica cliente5 = new ClientePessoaFisica("12345678","Maria","bairro conhecido, outra casa");
        ContaInvestimento conta5 = new ContaInvestimento(29150,492280,cliente3);
        
        
        // ABRIR CONTA QUE PRECISA DE LOGIN
        aplicacao.abrirConta(conta1);


        // TESTE DE DEPOSITAR E SACAR DEPOIS DE ABERTA A CONTA

        // aplicacao
        // .abrirConta(conta2)
        // .depositar(100)
        // .sacar(30); //ESPERADO 70


        // TESTE ABRIR CONTA, DEPOSITAR E TRANSFERENCIA

        aplicacao
        .abrirConta(conta3)
        .depositar(100);

        aplicacao.realizarTransferencia(conta3.fazerLogin(), conta1.fazerLogin(), 30); //ESPERADO 69.85 

        // TESTE INVESTIR, CONSULTAR SALDO
        
        // aplicacao.investir((ContaInvestimento)conta3.fazerLogin(), 50, LocalDate.of(2020, 4, 10), LocalDate.of(2020, 4, 14));
        aplicacao.abrirConta(conta5).depositar(200);
        aplicacao.investir((ContaInvestimento)conta5.fazerLogin(), 50, LocalDate.of(2020, 4, 10), LocalDate.of(2020, 4, 14));
        System.out.println(aplicacao.ConsultarSaldo(conta5.fazerLogin()));

        // TESTANDO EXCEÇOES

        // TESTANDO SE É POSSIVEL ABRIR CONTA POUPANÇA COM PESSOA JURIDICA
        //aplicacao.abrirConta(conta4);

        //TESTANDO SACAR CO SALDO SUFICIENTE
        aplicacao.abrirConta(conta2).depositar(100);
        aplicacao.realizarSaque(conta2.fazerLogin(), 200);

        aplicacao.listarContas();
    }

    // public Conta realizarLogin(Conta conta){
    //     return conta.fazerLogin();
    // }
    
    public BigDecimal ConsultarSaldoInvestimento(ContaInvestimento conta){
        return conta.getSaldoInvestimento();
    }
    
    public BigDecimal ConsultarSaldo(Conta conta){
        return conta.getSaldo();
    }

    public Conta investir(ContaInvestimento conta,double valor, LocalDate dataInicio, LocalDate dataFim){
        return conta.investir(valor, dataInicio, dataFim);
    }

    public Conta realizarSaque(Conta conta,double valor){
        return conta.sacar(valor);
    }
    
    public Conta realizarDeposito(Conta conta,double valor){
        return conta.depositar(valor);
    }

    public Conta realizarTransferencia(Conta contaOrigem, Conta contaDestino, double valor){
        return Conta.transferencia(contaOrigem, contaDestino, valor);
    }

    public Conta abrirConta(Conta conta) throws BankExceptions{
        if(Conta.isContaExistente(conta)){
            throw new BankExceptions("1004");
        }
         return conta.abrirConta(conta);
    }

    public Conta ativarConta(Conta conta){
        conta.setEstadoConta(true);
        return conta;
    }

    public List<Conta> listarContas(){
        for(Conta conta:Conta.contas){
            System.out.println(conta);
        }
        return Conta.contas;
    }
    
}