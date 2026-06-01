public class PlanoBasico {
        public String nomePlano;
        public int duracaoMeses;
        public double valorMensal;

        public void calcularValor(int duracaoMeses){
            if (duracaoMeses <= 3) {
                valorMensal = 50.00;
            } else if (duracaoMeses <= 6) {
                valorMensal = 40.00;
            } else if (duracaoMeses <= 12) {
                valorMensal = 30.00;
            } else if (duracaoMeses >= 24) {
                valorMensal = 25.00;
            }
        }

        public void mostrarBeneficios (){
            System.out.println ("Nome do Plano: Plano Básico");
            System.out.println ("Duração (meses): " + duracaoMeses);
            System.out.println ("Valor Mensal: " + valorMensal);
    }
}