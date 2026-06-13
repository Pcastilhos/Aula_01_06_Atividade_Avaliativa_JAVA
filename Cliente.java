import java.util.ArrayList;

public class Cliente extends Pessoa {
    public String cep;
    public String endereco;
    public String cidade;
    public String estado;
    public ArrayList<PacoteViagem> pacotes = new ArrayList<>();

    public void apresentar() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Idade: " + idade);
        System.out.println("CEP: " + cep);
        System.out.println("Endereço: " + endereco);
        System.out.println("Cidade: " + cidade);
        System.out.println("Estado: " + estado);
    }

    public void verificarMaioridade() {
        if (idade >= 18) {
            System.out.println("Cliente maior de idade.");
        } else {
            System.out.println("Cliente menor de idade.");
        }
    }

    public void preencherEndereco() {
        CepService cepService = new CepService();
        String dadosCep = cepService.consultarCep(cep);
        endereco = dadosCep;
        cidade = extrairCampo(dadosCep, "localidade");
        estado = extrairCampo(dadosCep, "uf");

        if (cidade.equals("")) {
            cidade = "Não informada";
        }

        if (estado.equals("")) {
            estado = "Não informado";
        }
    }

    public void adicionarPacote(PacoteViagem pacote) {
        pacotes.add(pacote);
    }

    public void listarPacotes() {
        if (pacotes.size() == 0) {
            System.out.println("Nenhum pacote cadastrado para este cliente.");
        } else {
            for (PacoteViagem pacote : pacotes) {
                pacote.apresentar();
                System.out.println("-------------------");
            }
        }
    }

    public String extrairCampo(String json, String campo) {
        String procura = "\"" + campo + "\": \"";
        int inicio = json.indexOf(procura);

        if (inicio == -1) {
            return "";
        }

        inicio = inicio + procura.length();
        int fim = json.indexOf("\"", inicio);

        if (fim == -1) {
            return "";
        }

        return json.substring(inicio, fim);
    }
}
