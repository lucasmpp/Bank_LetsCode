// package src.main;

// import src.main.model.Conta;

// public class Login {
//     Conta contaLogada;
//     static final Aplicacao aplicacao = new Aplicacao();
//     public static void main(String[] args) {
//         ClientePessoaFisica cliente1 = new ClientePessoaFisica("12345678910","Jose","bairro desconhecido, casa desconhecida");
//         ContaCorrente conta1 = new ContaCorrente(29548,462780,cliente1);

//         ClientePessoaFisica cliente2 = new ClientePessoaFisica("12345678","Maria","bairro conhecido, outra casa");
//         ContaCorrente conta2 = new ContaCorrente(29148,462280,cliente2);

//         ClientePessoaJuridica cliente3 = new ClientePessoaJuridica("00000000001","Pedro","Rua da esperança");
//         ContaInvestimento conta3 = new ContaInvestimento(29148,462280,cliente3);

//         ClientePessoaJuridica cliente4 = new ClientePessoaJuridica("0000000333","Ana","Rua da esperança");
//         ContaPoupanca conta4 = new ContaPoupanca(29148,462280,cliente4);

        
        
//         Login login = new Login();
//         login.fazerLogin(conta1)
//         .abrirAplicacao()
        
//     }
//     public Login fazerLogin(Conta conta){
//         this.contaLogada = Aplicacao.realizarLogin(conta);
//         return this;
//     }

//     public Aplicacao abrirAplicacao(){
//         return aplicacao;
//     }

// }