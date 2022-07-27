public class Aplicacao{
    public static void main(String[] args) {
        Aplicacao aplicacao = new Aplicacao();
        Cliente cliente = new PessoaFisica("12345678910","bairro desconhecido, casa desconhecida","Jose");
        aplicacao
        .abrirConta(cliente, 2954, 46278);
        
        
        
    }
    public Conta abrirConta(Cliente cliente, int agencia,int codigoConta){
        return null;
    }
}