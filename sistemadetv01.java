import java.util.Scanner;

public class sistemadetv01 {
             
   public static void main(String [] args) {

        Scanner scanner = new Scanner (System.in); 
        Cliente c1 = new Cliente();
        Plano p1 = new Plano();
        
        System.out.print ("Informe nome do cliente: ");
        c1.nome = scanner.nextLine();
        System.out.print ("Informe idade do cliente: ");
        c1.idade = scanner.nextInt();
        scanner.nextLine();
        if (c1.idade >= 18) {
            System.out.println("Maior de idade");
        } else {
            System.out.println("Menor de idade");
            System.exit(0);
        }
        System.out.print ("Informe CPF do cliente: ");
        c1.cpf = scanner.nextInt();
        scanner.nextLine();      
        System.out.println ("Selecione Plano: ");
        System.out.println ("1 - Plano Basico");
        System.out.println ("2 - Plano Premium");
        int opcao = scanner.nextInt();
        if (opcao == 1) {
            p1.nomePlano = "Plano_Basico";
            System.out.print ("Selecione duracao em meses [3, 6, 12 e 24]: ");
            p1.duracaoMeses = scanner.nextInt();
            System.out.println ();
            System.out.println ("##### PLANO BASICO #####");
            p1.calcularValor();
            System.out.println ("Beneficio: Plano economico.");
            p1.apresentar();
            System.out.println ("_____________________________");
        } else if (opcao == 2) {
            p1.nomePlano = "Plano_Premium";
            System.out.print ("Selecione duracao em meses [3, 6, 12 e 24]: ");
            p1.duracaoMeses = scanner.nextInt();
            System.out.println ();
            System.out.println ("##### PLANO PREMIUM #####");
            p1.calcularValor();
            System.out.println ("Beneficio: Melhor qualidade.");
            p1.apresentar();
            System.out.println ("_____________________________");
        }
        scanner.close();
   }
}