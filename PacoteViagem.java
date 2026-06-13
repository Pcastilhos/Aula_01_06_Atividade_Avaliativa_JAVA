import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PacoteViagem {
    public Cliente cliente;
    public ArrayList<Acompanhante> acompanhantes = new ArrayList<>();
    public String destino;
    public String dataInicio;
    public String dataFim;
    public int duracaoDias;
    public boolean internacional;
    public double temperatura;

    public void adicionarAcompanhante(Acompanhante acompanhante) {
        if (acompanhantes.size() < 4) {
            acompanhantes.add(acompanhante);
        }
    }

    public void calcularDataFim() {
        try {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate inicio = LocalDate.parse(dataInicio, formato);
            LocalDate fim = inicio.plusDays(duracaoDias);
            dataFim = fim.format(formato);
        } catch (DateTimeParseException erro) {
            dataFim = "Data inválida";
        }
    }

    public double calcularValor() {
        int quantidadeTotalPessoas = 1 + acompanhantes.size();
        double valorPassagens = 300 * quantidadeTotalPessoas;
        double desconto = 0;

        if (quantidadeTotalPessoas == 3) {
            desconto = valorPassagens * 0.10;
        } else if (quantidadeTotalPessoas == 4) {
            desconto = valorPassagens * 0.20;
        } else if (quantidadeTotalPessoas == 5) {
            desconto = valorPassagens * 0.30;
        }

        double valorComDesconto = valorPassagens - desconto;
        double taxaAdministrativa = 1000;

        if (internacional) {
            taxaAdministrativa = taxaAdministrativa * 1.6;
        } else {
            taxaAdministrativa = taxaAdministrativa * 1.2;
        }

        double taxaAeroporto = 400;
        return valorComDesconto + taxaAdministrativa + taxaAeroporto;
    }

    public void geraAvisoClima() {
        ClimaService climaService = new ClimaService();
        String clima = climaService.consultarClima(destino);
        double temperaturaConsultada = climaService.consultarTemperatura(destino);
        double temperaturaClima = extrairTemperaturaDoClima(clima);

        if (temperaturaConsultada == 0.0 && temperaturaClima != 0.0) {
            temperatura = temperaturaClima;
        } else {
            temperatura = temperaturaConsultada;
        }

        System.out.println("Clima do destino: " + clima);
        System.out.println("Temperatura: " + temperatura);

        if (temperatura < 0) {
            System.out.println("Alerta: destino muito frio. Recomenda-se levar roupas térmicas.");
        } else if (temperatura >= 0 && temperatura <= 10) {
            System.out.println("Aviso: destino frio. Recomenda-se levar casacos.");
        } else if (temperatura > 10 && temperatura <= 20) {
            System.out.println("Aviso: clima ameno. Recomenda-se levar roupas leves e uma blusa.");
        } else {
            System.out.println("Aviso: destino quente. Recomenda-se levar roupas leves.");
        }
    }

    public double extrairTemperaturaDoClima(String clima) {
        Pattern padrao = Pattern.compile("([+-]?\\d+(?:[.,]\\d+)?)\\s*°C");
        Matcher matcher = padrao.matcher(clima);

        if (matcher.find()) {
            String valor = matcher.group(1).replace(',', '.');
            return Double.parseDouble(valor);
        }

        return 0.0;
    }

    public void apresentar() {
        System.out.println("Cliente: " + cliente.nome);
        System.out.println("Destino: " + destino);
        System.out.println("Data Início: " + dataInicio);
        System.out.println("Data Fim: " + dataFim);
        System.out.println("Quantidade de Dias: " + duracaoDias);
        System.out.println("Quantidade total de pessoas: " + (1 + acompanhantes.size()));

        if (internacional) {
            System.out.println("Tipo: Viagem Internacional");
        } else {
            System.out.println("Tipo: Viagem Nacional");
        }

        if (acompanhantes.size() == 0) {
            System.out.println("Acompanhantes: nenhum");
        } else {
            System.out.println("Acompanhantes:");
            for (Acompanhante acompanhante : acompanhantes) {
                acompanhante.apresentar();
            }
        }

        geraAvisoClima();
        System.out.printf("Valor total do pacote: USD %.2f%n", calcularValor());
    }
}
