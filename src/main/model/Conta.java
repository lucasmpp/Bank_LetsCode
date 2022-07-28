package src.main.model;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
    public Conta(int agencia, int codigoConta) {
        this.agencia = agencia;
        this.codigoConta = codigoConta;
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
    public abstract Conta sacar(BigDecimal valor);
    public Conta depositar(BigDecimal valor){
        setSaldo(getSaldo().add(valor) );
        return this;
    }
    public abstract Conta transferencia(Conta contaOrigem, Conta ContaDestino, BigDecimal valor);

    
}
