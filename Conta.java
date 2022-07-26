import java.math.BigDecimal;

public class Conta {
    private long id;
    private int agencia;
    private int codigoConta;
    private Cliente cliente;
    private BigDecimal saldo;
    private boolean estadoConta;

    private Conta(){}

    private Conta(int agencia, int codigoConta, Cliente cliente) {
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

    public void depositar(){};
    public BigDecimal consultarSaldo(){
        return this.saldo;
    };
    public static Conta abrirConta(Cliente cliente,int agencia, int codigoConta){
         //OPERAÇÃO BANCO DE DADOS
        return new Conta(agencia, codigoConta, cliente);
    };
    public static Conta getConta(long id, Cliente cliente){
        //OPERAÇÃO BANCO DE DADOS
        return new Conta();
    }
    public static boolean ativarConta(Conta conta){
        //OPERAÇÃO BANCO DE DADOS
        conta.setEstadoConta(true);
        return conta.isEstadoConta();

    }
}
