package petshops;

public abstract class Petshop {
    public String nome;
    public float distancia_canil;

    public Petshop(String nome, float distancia_canil) {
        this.nome = nome;
        this.distancia_canil = distancia_canil;
    }

    protected abstract float calcularPreco(int qtde_caes_pequenos, int qtde_caes_grandes, boolean fim_de_semana);
}
