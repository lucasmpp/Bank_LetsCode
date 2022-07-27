import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    private static List<Conta> contas = new ArrayList<>();
    private long id;
    private int agencia;
    private int codigoConta;
    private Cliente cliente;
    private BigDecimal saldo;
    private boolean estadoConta;

    public Conta(){}

    public Conta(int agencia, int codigoConta, Cliente cliente) {
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

    public Conta depositar(){
        return this;
    };
    public BigDecimal consultarSaldo(){
        return this.saldo;
    };

    public static boolean ativarConta(Conta conta){
        //OPERAÇÃO BANCO DE DADOS
        conta.setEstadoConta(true);
        return conta.isEstadoConta();
    }
    public static List<Conta> getContas() {
        return contas;
    }
    public abstract Conta abrirConta(int agencia, int codigoConta, Cliente cliente, long id);
}
