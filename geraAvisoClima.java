import java.util.Scanner;

public class Clima {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Criando objeto do serviço
        ClimaService climaService = new ClimaService();

        System.out.println("=== CONSULTA DE CLIMA ===");

        System.out.print("Digite a cidade: ");

        String cidade = scanner.nextLine();

        // Consultando descrição do clima
        String clima =
                climaService.consultarClima(cidade);

        // Consultando temperatura
        double temperatura =
                climaService.consultarTemperatura(cidade);

        System.out.println();

        System.out.println("=== RESULTADO ===");

        System.out.println(clima);

        System.out.printf(
                "Temperatura: %.2f graus%n",
                temperatura
        );

        // Regras de negócio da viagem

        if (temperatura < 0) {

            System.out.println(
                    "Alerta: destino muito frio. Leve roupas térmicas."
            );

        } else if (temperatura <= 10) {

            System.out.println(
                    "Aviso: destino frio. Leve casacos."
            );

        } else if (temperatura <= 20) {

            System.out.println(
                    "Aviso: clima ameno."
            );

        } else {

            System.out.println(
                    "Aviso: destino quente. Leve roupas leves."
            );
        }

    }

}