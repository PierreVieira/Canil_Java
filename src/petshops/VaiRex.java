package petshops;

public class VaiRex extends Petshop {
    public VaiRex() {
        super("Vai Rex", 1.7f);
    }

    @Override
    public float calcularPreco(int qtde_caes_pequenos, int qtde_caes_grandes, boolean fim_de_semana) {
        if(!fim_de_semana){
            return qtde_caes_pequenos * 15 + qtde_caes_grandes * 50;
        }
        return qtde_caes_pequenos * 20 + qtde_caes_grandes * 55;
    }
}
