package Model;

import java.util.Scanner;

public class Cliente {
    private int id;
    private String tipo;
    private String nome;
    private String documento;
    private float saldo = 0.00f;

    public Cliente(int id, String tipo, String nome, String documento) {
        this.id = this.id;
        this.tipo = this.tipo;
        this.nome = this.nome;
        this.documento = this.documento;
        this.saldo = saldo;
    }

    public Cliente(int id, String nome, String documento){
        this.id = id;
        this.nome = nome;
        this.documento = documento;

    }

    public Cliente(int id,String documento){
        this.id = id;
        this.documento = documento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void sacar (){ // digitar o valor, verificar se saldo é > 0 e  se input  > 0 e se input <= saldo, subtrarir, mensagem
        System.out.println("\nDigite o valor a ser sacado:\n");

        Scanner sacarDaConta = new Scanner(System.in);
        float input = sacarDaConta.nextFloat();

        if(this.saldo > 0 && input > 0 && input <= this.saldo){
            this.saldo-= input;
            System.out.println("\nSaldo restante da conta e de: " + getSaldo() + ".\n");
        }else {
            System.out.printf("\nSaldo indisponível\n\nVerifique se o valor digitado e valido\n\n" +
                    "Valor digitado para sacar tem que ser maior que 0\n\n");
        }

    }

    public void depositar (){ //digitar o valor,verificar >0,adicionar na conta, mensagem
        System.out.println("Digite o valor a ser depositado:\n");

        Scanner depositarDaConta = new Scanner (System.in);
        float input = depositarDaConta.nextFloat();

        if(input >0){
            this.saldo += input;

            System.out.println("\nDeposito realizado com sucesso!\n");

        }else {
            System.out.printf("\nValor digitado e invalido.\n\n" +
                    "Valor digitado para depositar tem que ser maior que 0\n\n");
        }

    }

    public void TransferirSaldo (Cliente origem, Cliente destino){
        System.out.println("Digite o valor a ser transferido da conta  origem  para destino:\n");

        Scanner transferirSaldo = new Scanner(System.in);
        float input = transferirSaldo.nextFloat();

        if(origem.getSaldo() > 0 && input > 0 && input <= origem.getSaldo()){

            float saldoAtual = destino.getSaldo() + input;
            destino.setSaldo(saldoAtual);

            float saldoRestante = origem.getSaldo() - input;
            origem.setSaldo(saldoRestante);

        }else {
            System.out.printf("\nVerifique se o valor digitado e valido.\n\n" +
                    "Verifique se o valor digitado e igual ou menor ao saldo atual da conta.\n\n");
        }
    }

    @Override
    public String toString() {
        return  "\n" + "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
