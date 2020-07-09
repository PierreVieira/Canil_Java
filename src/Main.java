public class Main {
    public static void main(String[] args) {
        SolucaoTest teste = new SolucaoTest();
        teste.testarSaidas();
        Solucao solucao = new Solucao(args[0], args[1], args[2]);
        String[] melhor_canil = solucao.resposta();
        System.out.println("Melhor canil: "+melhor_canil[0]+"\nPreço total: R$ "+melhor_canil[1]);
    }
}
