import java.util.Scanner;

public class Cliente extends Pessoa {
    public String telefone;
    public String cep;
    public String endereco;
    public String cidade;
    public String continuar;

    public Cliente() {}

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Cliente c1 = new Cliente();
        CepService cepService = new CepService(); // ← instância da classe que tem consultarCep()

        do {
            System.out.print("Informe nome do cliente: ");
            c1.nome = scanner.nextLine();

            System.out.print("Informe idade do cliente: ");
            c1.idade = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Informe CPF do cliente: ");
            c1.cpf = scanner.nextLine();

            System.out.print("Informe telefone do cliente: ");
            c1.telefone = scanner.nextLine();

            // 1️⃣ Pede o CEP ao usuário e armazena em c1.cep
            System.out.print("Informe o CEP do cliente: ");
            c1.cep = scanner.nextLine();

            // 2️⃣ Chama consultarCep() passando o cep, e CAPTURA o retorno
            c1.endereco = cepService.consultarCep(c1.cep);

            // 3️⃣ Exibe o endereço retornado pela API
            System.out.println("Endereço encontrado: " + c1.endereco);

            System.out.print("Continuar cadastro? [S/N]: ");
            c1.continuar = scanner.nextLine();

        } while (c1.continuar.equalsIgnoreCase("S")); // ← correção importante aqui!
    }

    private static class CepService {

        public CepService() {
        }

        public String consultarCep(String cep) {
            // implementação simples de exemplo: em um caso real faria chamada a uma API
            if (cep == null || cep.isEmpty()) {
                return "CEP inválido";
            }
            return "Endereço para CEP " + cep;
        }
    }
}