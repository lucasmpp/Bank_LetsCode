package src.main;

import java.math.BigDecimal;
import java.util.List;

import src.main.model.Cliente;
import src.main.model.Conta;

public class Aplicacao{
    public static void main(String[] args) {
        Aplicacao aplicacao = new Aplicacao();
        
        ClientePessoaFisica cliente1 = new ClientePessoaFisica("12345678910","bairro desconhecido, casa desconhecida","Jose");
        ContaCorrente conta1 = new ContaCorrente(29548,462780,cliente1);

        ClientePessoaFisica cliente2 = new ClientePessoaFisica("12345678","bairro conhecido, outra casa","Maria");
        ContaCorrente conta2 = new ContaCorrente(29148,462280,cliente2);

        ClientePessoaJuridica cliente3 = new ClientePessoaJuridica();
        ContaInvestimento conta3 = new ContaInvestimento(29148,462280,cliente3);

        ClientePessoaJuridica cliente4 = new ClientePessoaJuridica();
        ContaPoupanca conta4 = new ContaPoupanca(29148,462280,cliente4);

        aplicacao
        .abrirConta(conta1);

        aplicacao
        .abrirConta(conta2)
        .depositar(BigDecimal.valueOf(1000))
        .sacar(BigDecimal.valueOf(200));
        aplicacao.listarContas();
    }
  
    public Conta abrirConta(Conta conta){
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