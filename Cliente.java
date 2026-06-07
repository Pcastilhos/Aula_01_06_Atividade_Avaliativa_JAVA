import java.util.Scanner;
import java.util.ArrayList;

public class Cliente extends Pessoa {
        public String telefone;
        public String cep;
        public String endereco;
        public String estado;
        public String cidade;
        public ArrayList<PacoteViagem> pacotes = new ArrayList<>();

    public void adicionarPacote(PacoteViagem pacote) {
        pacotes.add(pacote);
    }

    public void listarPacotes(){
        if (pacotes.size() == 0) {
        System.out.println("Esse cliente não possui pacotes cadastrados.");
        } 
        else {
        System.out.println("Pacotes de " + nome + ":");    
        for (int i = 0; i < pacotes.size(); i++) {
            System.out.println("Pacote " + (i + 1));
            pacotes.get(i).apresentar();
        }
      }  
    }
    public void apresentar() {
    System.out.println("Nome: " + nome);
    System.out.println("CPF: " + cpf);
    System.out.println("Idade: " + idade);
    System.out.println("Telefone: " + telefone);
    System.out.println("CEP: " + cep);
    System.out.println("Endereço: " + endereco);
    System.out.println("Cidade: " + cidade);
    System.out.println("Estado: " + estado);
}
}