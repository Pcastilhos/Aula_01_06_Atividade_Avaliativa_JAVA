import java.util.Scanner;
import java.util.ArrayList;

public class PacoteViagem  {
    public String destino;
    public String dataInicio;
    public String dataFim;
    public int duracaoDias;
    public boolean internacional;
    public double temperatura;
    

    public void adicionarAcompanhante() {
    }

    public double calcularValor() {
        // Retorno padrão provisório para evitar erro de compilação
        return 0.0; 
    }

    // Alterado de 'string' para 'void', já que o método apenas exibe alertas na tela
    public void geraAvisoClima() { 
         
        Scanner scanner = new Scanner(System.in);

        // Criando objeto do serviço
        ClimaService climaService = new ClimaService();

        System.out.println("=== CONSULTA DE CLIMA ===");
        String cidade = destino;

        // Consultando descrição do clima
        String clima =
                climaService.consultarClima(cidade);
   
        // Consultando temperatura
        double temperatura = climaService.consultarTemperatura(cidade);

        System.out.println();

        System.out.println("=== RESULTADO ===");

        System.out.println(clima);

        System.out.println("Temperatura: "+ temperatura);

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

    public void apresentar() {
        System.out.println("Destino: " + destino);
        System.out.println("Data Início: " + dataInicio);
        System.out.println("Data Fim: " + dataFim);
        System.out.println("Quantidade de Dias: " + duracaoDias);
        
        if (internacional) {
            System.out.println("Tipo: Viagem Internacional");
        } else {
            System.out.println("Tipo: Viagem Nacional");
        }
        
        // Aciona a consulta de clima dentro da apresentação
        geraAvisoClima();      
    }
}