package petshops;

public class ChowMara extends Petshop {
    public ChowMara() {
        super("Chow Mara", 0.8f);
    }

    @Override
    public float calcularPreco(int qtde_caes_pequenos, int qtde_caes_grandes, boolean fim_de_semana) {
        return (float) (qtde_caes_pequenos * 30 + qtde_caes_grandes * 45);
    }
}
