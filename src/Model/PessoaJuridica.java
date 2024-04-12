package Model;

public class PessoaJuridica extends Cliente {
    private String numeroDocumento;
    private String nomeFantasia;

    public PessoaJuridica(int id, String documento, String numeroDocumento, String nomeFantasia) {
        super(id, documento);
        this.numeroDocumento = numeroDocumento;
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj(){
        return this.numeroDocumento = numeroDocumento;
    }

    public String getNomeFantasia(){
        return this.nomeFantasia = nomeFantasia;
    }

    public void setCnpj(String cnpj) {
        this.numeroDocumento = cnpj;
    }

    public void setNomeFantasia(String nomeFantasia){
        this.nomeFantasia = nomeFantasia;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPessoa Jurídica: {" +
                "cnpj='" + numeroDocumento + '\'' +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                '}';
    }
}
