package Model;

public class PessoaFisico extends Cliente {
    private String numeroDocumento;

    public PessoaFisico(int id, String nome, String documento,String numeroDocumento) {
        super(id, nome, documento);
        this.numeroDocumento = numeroDocumento;
    }

    public String getNumeroCpf(){
        return this.numeroDocumento;
    }

    public void setNumeroCpf(String numeroCpf){
        this.numeroDocumento = numeroCpf;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPessoa física: {" + "numero do cpf=" + numeroDocumento + '\'' +
                '}';
    }
}
