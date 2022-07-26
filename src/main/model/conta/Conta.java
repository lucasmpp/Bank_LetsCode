package src.main.model.conta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import src.exceptions.BankExceptions;
import src.main.model.cliente.Cliente;


public abstract class Conta {
    public static List<Conta> contas = new ArrayList<>();

    private int agencia;
    private int codigoConta;
    private Cliente cliente;
    private BigDecimal saldo;
    private boolean estadoConta;

    public Conta() {
    }

    public Conta(int agencia, int codigoConta, Cliente cliente) {
        this.saldo = BigDecimal.valueOf(0);
        this.estadoConta = false;

        this.agencia = agencia;
        this.codigoConta = codigoConta;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getCodigoConta() {
        return codigoConta;
    }

    public void setCodigoConta(int codigoConta) {
        this.codigoConta = codigoConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public boolean isEstadoConta() {
        return estadoConta;
    }

    public void setEstadoConta(boolean estadoConta) {
        this.estadoConta = estadoConta;
    }

    public BigDecimal consultarSaldo(){
        return this.saldo;
    };

    public  abstract  Conta abrirConta(Conta tipoConta);

    public  Conta sacar(double valor) throws BankExceptions{


        if(this.getSaldo().compareTo(BigDecimal.valueOf(valor)) == -1 ){
            throw new BankExceptions("1001");
        }

        this.setSaldo(this.getSaldo().subtract(BigDecimal.valueOf(valor).multiply(this.getCliente().getTaxaConta())));

        this.setSaldo(this.getSaldo().subtract(BigDecimal.valueOf(valor)));
        mergeConta();
        return this;
    };

    

    public Conta depositar(double valor) throws BankExceptions{

        if(valor < 0 ){
            throw new BankExceptions("1003");
        }

        setSaldo(getSaldo().add(BigDecimal.valueOf(valor)));
        mergeConta();
        return this;
    }
    public static Conta transferencia(Conta contaOrigem, Conta contaDestino, double valor) {

        if(valor < 0 ){
            throw new BankExceptions("1003");
        }

        if(contaOrigem.getSaldo().compareTo(BigDecimal.valueOf(valor)) == -1 ){
            throw new BankExceptions("1001");
        }

        BigDecimal valorBig = BigDecimal.valueOf(valor);
        //Aplica taxa apenas se for PJ
        contaOrigem.setSaldo(aplicarTaxa(contaOrigem,valorBig));
        
        contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(valorBig));
        contaDestino.setSaldo(contaDestino.getSaldo().add(valorBig));

        contaOrigem.mergeConta();
        contaDestino.mergeConta();

        return contaOrigem;
    }

    public static BigDecimal  aplicarTaxa(Conta contaOrigem, BigDecimal valor){
        //Se o cliente da conta for PF, retornará 0
        return contaOrigem.getSaldo().subtract(valor.multiply(contaOrigem.getCliente().getTaxaConta()));

    }

    public Conta mergeConta(){
        for(Conta contaGravada:contas){
            if(contaGravada.getAgencia() == this.getAgencia() && contaGravada.getCodigoConta() == this.getCodigoConta()){
                contas.set(contas.indexOf(contaGravada), this);
            }
        }
        return this;
    }

    public static boolean isContaExistente(Conta novaConta){
        for(Conta contaGravada:contas){
            if(contaGravada.getAgencia() == novaConta.getAgencia() && contaGravada.getCodigoConta() == novaConta.getCodigoConta()){
              return true;
            }
        }
        return false;
    }

    public Conta fazerLogin() throws BankExceptions{
        for(Conta contaGravada:contas){
            if(contaGravada.getAgencia() == this.getAgencia() && contaGravada.getCodigoConta() == this.getCodigoConta()){
              return contaGravada;
            }
        }
        throw new BankExceptions("1006");
    }


    @Override
    public String toString() {
        String TipoConta = getClass().getSimpleName();
        String TipoCliente = getCliente().getClass().getSimpleName();
        String Nome = getCliente().nome;
        BigDecimal Saldo = getSaldo();

        return String.format("\n\n{\nTipoConta: %s,\nTipoCliente: %s,\nNome: %s,\nSaldo: %.2f\n}", TipoConta, TipoCliente, Nome, Saldo);
    }



    
}
