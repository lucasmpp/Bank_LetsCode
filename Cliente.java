import java.util.ArrayList;
import java.util.List;

interface Cliente {
    List<Conta> conta = new ArrayList<>();
    String endereco = "";

    public abstract void sacar();
    
    public abstract void transferencia();
    public abstract void investir();


}
