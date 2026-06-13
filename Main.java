import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaAgencia sistema = new SistemaAgencia();
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n=== MUNDO FACIL VIAGENS ===");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Cadastrar pacote para cliente");
            System.out.println("3 - Listar clientes");
            System.out.println("4 - Listar pacotes de um cliente");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                Cliente cliente = new Cliente();

                System.out.print("Nome: ");
                cliente.nome = scanner.nextLine();

                System.out.print("CPF: ");
                cliente.cpf = scanner.nextLine();

                System.out.print("Idade: ");
                cliente.idade = scanner.nextInt();
                scanner.nextLine();

                System.out.print("CEP: ");
                cliente.cep = scanner.nextLine();
                cliente.preencherEndereco();

                sistema.cadastrarCliente(cliente);
                System.out.println("Cliente cadastrado com sucesso!");

            } else if (opcao == 2) {
                if (sistema.clientes.size() == 0) {
                    System.out.println("Nenhum cliente cadastrado.");
                } else {
                    System.out.println("Escolha o cliente:");
                    for (int i = 0; i < sistema.clientes.size(); i++) {
                        System.out.println((i + 1) + " - " + sistema.clientes.get(i).nome);
                    }

                    int indiceCliente = scanner.nextInt();
                    scanner.nextLine();

                    Cliente clienteSelecionado = sistema.clientes.get(indiceCliente - 1);
                    PacoteViagem pacote = new PacoteViagem();
                    pacote.cliente = clienteSelecionado;

                    System.out.print("Destino: ");
                    pacote.destino = scanner.nextLine();

                        System.out.print("Data de inicio (dd/MM/yyyy): ");
                    pacote.dataInicio = scanner.nextLine();

                    System.out.print("Duração em dias (7, 15 ou 30): ");
                    pacote.duracaoDias = scanner.nextInt();
                    scanner.nextLine();

                    if (pacote.duracaoDias != 7 && pacote.duracaoDias != 15 && pacote.duracaoDias != 30) {
                        System.out.println("Duração inválida.");
                    } else {
                        pacote.calcularDataFim();

                        System.out.print("É internacional?\n1 - Sim\n2 - Não: ");
                        int ehInternacional = scanner.nextInt();
                        scanner.nextLine();

                        if (ehInternacional == 1) {
                            pacote.internacional = true;
                        } else {
                            pacote.internacional = false;
                        }

                        System.out.print("Quantidade de acompanhantes (0 a 4): ");
                        int quantidadeAcompanhantes = scanner.nextInt();
                        scanner.nextLine();

                        if (quantidadeAcompanhantes < 0) {
                            quantidadeAcompanhantes = 0;
                        }

                        if (quantidadeAcompanhantes > 4) {
                            quantidadeAcompanhantes = 4;
                        }

                        for (int i = 0; i < quantidadeAcompanhantes; i++) {
                            Acompanhante acompanhante = new Acompanhante();

                            System.out.print("Nome do acompanhante " + (i + 1) + ": ");
                            acompanhante.nome = scanner.nextLine();

                            System.out.print("Idade do acompanhante " + (i + 1) + ": ");
                            acompanhante.idade = scanner.nextInt();
                            scanner.nextLine();

                            pacote.adicionarAcompanhante(acompanhante);
                        }

                        sistema.cadastrarPacote(clienteSelecionado, pacote);
                        System.out.println("Pacote cadastrado com sucesso!");
                    }
                }

            } else if (opcao == 3) {
                sistema.listarClientes();

            } else if (opcao == 4) {
                if (sistema.clientes.size() == 0) {
                    System.out.println("Nenhum cliente cadastrado.");
                } else {
                    System.out.println("Escolha o cliente:");
                    for (int i = 0; i < sistema.clientes.size(); i++) {
                        System.out.println((i + 1) + " - " + sistema.clientes.get(i).nome);
                    }

                    int indiceCliente = scanner.nextInt();
                    scanner.nextLine();

                    Cliente clienteSelecionado = sistema.clientes.get(indiceCliente - 1);
                    sistema.listarPacotesCliente(clienteSelecionado);
                }

            } else if (opcao == 5) {
                System.out.println("Saindo do sistema...");

            } else {
                System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
