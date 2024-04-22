package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {
    private List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> getClientes() {
        return clientes;
    }

    public Cliente criarClientesFisico() {
        System.out.println("\nInsira o id:\n");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        input.nextLine();
        System.out.println("\nInsira o nome completo:\n");
        String nome = input.nextLine();
        System.out.println("\nInsira o tipo de documento:\n");
        String documento = input.nextLine();
        System.out.println("\nInsira o numero do documento:\n");
        String numeroDocumento = input.nextLine();
        Cliente cliente = new PessoaFisico(id, nome, documento, numeroDocumento);

        adicionarCliente(cliente);

        return cliente;
    }

    public Cliente criarClientesJuridico() {
        System.out.println("\nInsira o id:\n");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        input.nextLine();                      //Usa input.nextLine(); para remover os espacos vazios que pode ocorrer de uma forma inespera ao misturar uma entra do tipo nextInt e logo em seguinda nextLine
        System.out.println("\nInsira o tipo de documento:\n");
        String documento = input.nextLine();
        System.out.println("\nInsira o numero do documento:\n");
        String numeroDocumento = input.nextLine();
        System.out.println("\nInsira o nome fantasia:\n");
        String nomeFantasia = input.nextLine();
        Cliente cliente = new PessoaJuridica(id, documento, numeroDocumento, nomeFantasia);

        adicionarCliente(cliente);

        return cliente;
    }

    public int verificarSeExisteCliente(int id) {

        for (int posicao = 0; id <= this.clientes.toArray().length; posicao++) {
            Cliente cliente = this.clientes.get(posicao);

            if (id == cliente.getId()) {
                System.out.println(cliente);

                return posicao;
            }
        }
        System.out.println("\nCliente nao encontrado");
        return -1;
    }

    public  void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void removerCliente(int id){
        int index = -1;

        // Percorre a lista de clientes para encontrar o índice do cliente com o ID fornecido
        for (int posicao = 0; posicao < this.clientes.size(); posicao++) {
            Cliente cliente = this.clientes.get(posicao);

            if (id == cliente.getId()) {
                index = posicao; // Atualiza o índice se o cliente for encontrado
                break;
            }
        }

        if (index != -1) {
            this.clientes.remove(index);
            System.out.println("\nCliente removido com sucesso!");
        } else {
            System.out.println("\nCliente não encontrado. Não foi possível concluir a operação.");
        }
    }

    public float somarTodosSaldos(List<Cliente> clientes){ // retornar valor em float,
        System.out.println("\nSomando o valor total do saldo dos clientes:\n");

        float totalSaldos = 0f;

        for(int i = 0; i < this.clientes.toArray().length ; i ++){
            if(this.clientes.get(i) != null){
                totalSaldos += clientes.get(i).getSaldo();
            }
        }
        System.out.println("\nO saldo total dos clientes e: " + totalSaldos + ".\n");
        return  totalSaldos;
    }
}