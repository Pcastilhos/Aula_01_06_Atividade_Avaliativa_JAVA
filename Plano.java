import java.util.Scanner;

public class Plano {
        public String nomePlano;
        public int duracaoMeses;
        public double valorano;

        public void calcularValor (){
            Scanner scanner = new Scanner (System.in); 
            PlanoBasico pb = new PlanoBasico();
            PlanoPremiun pp = new PlanoPremiun();

            if (nomePlano == "Plano_Basico") {
                pb.calcularValor(duracaoMeses);
                valorano = duracaoMeses * pb.valorMensal;
            } else if (nomePlano == "Plano_Premium") {
                pp.calcularValor(duracaoMeses);
                valorano = duracaoMeses * pp.valorMensal;
            }
        }
        public void apresentar (){
        System.out.println ("Nome do Plano: " + nomePlano);
        System.out.println ("Duracao (meses): " + duracaoMeses);
        System.out.println ("Valor anual do Plano: " + valorano);
    }
}