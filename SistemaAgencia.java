import java.util.ArrayList;

public class SistemaAgencia {
    
    public ArrayList<Cliente> clientes = new ArrayList<>();

    public void cadastrarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void listarClientes() {
    System.out.println("Clientes cadastrados:");
    if (clientes.size() == 0) {
        System.out.println("Nenhum cliente cadastrado.");
    } else {
        for (Cliente cliente : clientes) {
            cliente.apresentar();
            System.out.println("-------------------");
        }
    }
    }
     public void cadastrarPacote(Cliente cliente, PacoteViagem pacote) {
        cliente.adicionarPacote(pacote);
    }
    
     
    public void listarPacotesCliente(Cliente cliente) {
        cliente.listarPacotes();
    }
}