import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaAgencia sistema = new SistemaAgencia();
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Cadastrar pacote para cliente");
            System.out.println("3 - Listar clientes");
            System.out.println("4 - Listar pacotes de um cliente");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
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

                System.out.print("Telefone: ");
                cliente.telefone = scanner.nextLine();

                System.out.print("CEP: ");
                cliente.cep = scanner.nextLine();

                CepService cepService = new CepService();
                String retorno = cepService.consultarCep(cliente.cep);
                cliente.cidade = extrairCampo(retorno, "localidade");
                cliente.estado = extrairCampo(retorno, "estado");

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

                    System.out.print("Destino: ");
                    pacote.destino = scanner.nextLine();

                    System.out.print("Data de início: ");
                    pacote.dataInicio = scanner.nextLine();

                    System.out.print("Data de fim: ");
                    pacote.dataFim = scanner.nextLine();

                    System.out.print("Duração em dias (7, 15 ou 30): ");
                    pacote.duracaoDias = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("É internacional? \n 1 - Sim \n 2 - Não): ");
                    int ehInternacional;
                    ehInternacional = scanner.nextInt();
                    if (ehInternacional == 1 ){
                        pacote.internacional = true;
                    }
                    else {
                        pacote.internacional = false;
                    }
                    //pacote.internacional = scanner.nextBoolean();
                    scanner.nextLine();

                    sistema.cadastrarPacote(clienteSelecionado, pacote);
                    System.out.println("Pacote cadastrado com sucesso!");

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

    public static String extrairCampo(String json, String campo) {
        String procura = "\"" + campo + "\": \"";
        int inicio = json.indexOf(procura);

        if (inicio == -1) {
            return "";
        }

        inicio = inicio + procura.length();
        int fim = json.indexOf("\"", inicio);

        return json.substring(inicio, fim);
    }
}