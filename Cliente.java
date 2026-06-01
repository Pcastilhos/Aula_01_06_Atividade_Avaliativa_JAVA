public class Cliente {
        public String nome;
        public int cpf;
        public int idade;

        public static void verificarmaioridade(int idade){
            if (idade >= 18) {
                System.out.println("Maior de idade");
            } else {
                System.out.println("Menor de idade");
            }
        }

        public void apresentar (){
            System.out.println ("Nome " +nome);
            System.out.println ("CPF " +cpf);
            System.out.println ("Idade " +idade);
    }
}