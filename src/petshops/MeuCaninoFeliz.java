package petshops;

public class MeuCaninoFeliz extends Petshop {
    public MeuCaninoFeliz(){
        super("Meu Canino Feliz", 2);
    }
    @Override
    public float calcularPreco(int qtde_caes_pequenos, int qtde_caes_grandes, boolean fim_de_semana) {
        if(!fim_de_semana) {
            return (float) (qtde_caes_pequenos * 20 + qtde_caes_grandes * 40);
        }
        return (float) (1.2 * (qtde_caes_pequenos * 20 + qtde_caes_grandes * 40));
    }
}
