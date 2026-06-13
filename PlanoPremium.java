public class PlanoPremium extends Plano {

    public PlanoPremium() {
        nomePlano = "Plano Premium";
        valorMensal = 129.90;
    }

    @Override
    public void mostrarBeneficios() {
        System.out.println("Benefícios: canais abertos, infantis, filmes e esportes.");
    }
}
