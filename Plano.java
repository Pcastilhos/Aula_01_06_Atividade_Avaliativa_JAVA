public class Plano {
    public String nomePlano;
    public double valorMensal;

    public void apresentar() {
        System.out.println("Plano escolhido: " + nomePlano);
    }

    public double calcularValor() {
        return valorMensal;
    }

    public void mostrarBeneficios() {
        System.out.println("Benefícios do plano não informados.");
    }
}
