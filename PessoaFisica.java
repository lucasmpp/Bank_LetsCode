public class PessoaFisica extends Cliente {
    String cpf;

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    PessoaFisica(){}
    PessoaFisica(String cpf, String endereco, String nome){
        this.cpf = cpf;
        this.endereco = endereco;
        this.nome = nome;
    }

    @Override
    public void sacar() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void transferencia() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void investir(double taxaInvestimento) {
        // TODO Auto-generated method stub
        
    }
}
