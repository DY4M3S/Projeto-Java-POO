import Model.Banco;
import Model.Cliente;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static void printMenu() {
        System.out.println("\nBem vindo ao Banco Java:\n\n");
        System.out.println("1 - Cadastrar Cliente Fisico");
        System.out.println("2 - Cadastrar Cliente Juridico");
        System.out.println("3 - Consultar Cliente");
        System.out.println("4 - Remover Cliente");
        System.out.println("5 - Depositar");
        System.out.println("6 - Sacar");
        System.out.println("7 - Transferir");
        System.out.println("8 - Somar todos os saldos dos Clientes");
        System.out.println("0 - Sair\n\n");
    }
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner input = new Scanner(System.in);

        printMenu();

        int opcao = input.nextInt();

        while (opcao != 0) {
            if (opcao == 1) {
                Cliente c = banco.criarClientesFisico();

            }else if (opcao == 2) {
                Cliente c = banco.criarClientesJuridico();

            }else if (opcao == 3) {
                System.out.println("\nDigite o identificador do cliente:\n");
                int id = input.nextInt();

                banco.verificarSeExisteCliente(id);

            }else if (opcao == 4) {
                System.out.println("\nDigite o identificador: ");
                int identificador = input.nextInt();

                banco.removerCliente(identificador);

            }else if (opcao == 5) {
                System.out.println("\nDigite o identificador: ");
                int id = input.nextInt();

                if(banco.verificarSeExisteCliente(id)) {
                    banco.getClientes().get(id).depositar();
                } else {
                    System.out.println("\nNao foi possivel concluir a operacao\n");
                }


            }else if (opcao == 6) {
                System.out.println("\nDigite o identificador: ");
                int id = input.nextInt();

                if(banco.verificarSeExisteCliente(id)) {
                    banco.getClientes().get(id).sacar();
                } else {
                    System.out.println("\nNao foi possivel concluir a operacao\n");
                }


            }else if (opcao == 7) {
                System.out.println("\nDigite o id da conta origem: ");
                int id = input.nextInt();

                boolean validarId = banco.verificarSeExisteCliente(id);

                System.out.println("\nDigite o id da conta destino: ");
                int idDestino = input.nextInt();

                boolean validarIdDestino = banco.verificarSeExisteCliente(idDestino);

                if( validarId && validarIdDestino) {

                    banco.getClientes().get(id).TransferirSaldo(
                            banco.getClientes().get(id),
                            banco.getClientes().get(idDestino));
                } else {
                    System.out.println("\nNao foi possivel concluir a operacao\n");
                }

            } else if (opcao == 8) {

                List<Cliente> clientes = banco.getClientes();

                banco.somarTodosSaldos(clientes);
            }

            printMenu();
            opcao = input.nextInt();
        }


    }

}