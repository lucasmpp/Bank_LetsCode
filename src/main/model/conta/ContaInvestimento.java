package src.main.model.conta;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import src.exceptions.BankExceptions;
import src.main.model.cliente.Cliente;

public class ContaInvestimento extends Conta  {

    private BigDecimal saldoInvestimento;



    public ContaInvestimento(int agencia, int codigoConta, Cliente cliente){
        super(agencia,codigoConta,cliente);
    }

    public Conta investir(double valor, LocalDate dataInicio, LocalDate dataFim) throws BankExceptions{

        if(valor < 0 ){
            throw new BankExceptions("1003");
        }

        if(this.getSaldo().compareTo(BigDecimal.valueOf(valor)) == -1 ){
            throw new BankExceptions("1002");
        }
        
        this.saldoInvestimento = BigDecimal.valueOf(ChronoUnit.DAYS.between( dataInicio , dataFim )).multiply(getCliente().getTaxaInvestimento()).multiply(BigDecimal.valueOf(valor)).add(BigDecimal.valueOf(valor));
        

        this.setSaldo(this.getSaldo().subtract(BigDecimal.valueOf(valor)));
        mergeConta();
        return this;
    };




    @Override
    public Conta abrirConta(Conta tipoConta) {
        ContaInvestimento conta = new ContaInvestimento( tipoConta.getAgencia(),tipoConta.getCodigoConta(),tipoConta.getCliente());
        Conta.contas.add(conta);
        return conta;
    }

    public BigDecimal getSaldoInvestimento() {
        return saldoInvestimento;
    }

    public void setSaldoInvestimento(BigDecimal saldoInvestimento) {
        this.saldoInvestimento = saldoInvestimento;
    }

    @Override
    public String toString() {
        String TipoConta = getClass().getSimpleName();
        String TipoCliente = getCliente().getClass().getSimpleName();
        String Nome = getCliente().nome;
        BigDecimal Saldo = getSaldo();
        BigDecimal SaldoInvestimento = getSaldoInvestimento();

        return String
        .format("\n\n{\nTipoConta: %s,\nTipoCliente: %s,\nNome: %s,\nSaldo: %.2f,\nSaldoInvestimento: %.4f\n}", TipoConta, TipoCliente, Nome, Saldo, SaldoInvestimento);
    }

    

    
    
}

