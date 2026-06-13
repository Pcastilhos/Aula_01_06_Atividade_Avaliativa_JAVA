public class PlanoBasico extends Plano {

    public PlanoBasico() {
        nomePlano = "Plano Básico";
        valorMensal = 79.90;
    }

    @Override
    public void mostrarBeneficios() {
        System.out.println("Benefícios: canais abertos e infantis.");
    }
}
