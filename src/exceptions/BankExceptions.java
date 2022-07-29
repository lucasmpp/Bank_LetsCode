package src.exceptions;

import java.util.HashMap;
import java.util.Map;

public class BankExceptions extends RuntimeException{

    static final Map<String, String> erros = new HashMap<String, String>();

    static {
        erros.put("1000", "Erro de servidor.");

        // Erros relacionados à Conta
        erros.put("1001", "\n \nNão foi possível executar a operação. O saldo da conta originária é insuficiente.");
        erros.put("1002", "\n \nNão foi possível investir. O saldo da conta originária é insuficiente.");
        erros.put("1003", "\n \nImpossível depositar um valor negativo.");
        erros.put("1004", "\n \nNão é possível criar uma nova conta. Código de Conta e código da agência já existente.");
        erros.put("1005", "\n \nPessoa Jurírica não pode ter conta poupança.");


    }

    public BankExceptions(String codigo){
        super(getMensagemErro(codigo));
    }

    private static String getMensagemErro(String codigo) {
        try {
            String mensagem = erros.get(codigo);
            if (mensagem.isEmpty()) {
                throw new Exception();
            }
            return mensagem;
        } catch (Exception e) {
            return "Erro de Servidor";
        }
    }
    


}