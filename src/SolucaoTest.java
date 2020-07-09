import junit.framework.TestCase;
import java.util.HashMap;

public class SolucaoTest extends TestCase{
    private void executarTeste(String nome, String valor, String nome_esperado, String valor_esperado){
        assertEquals(nome, nome_esperado);
        assertEquals(valor, valor_esperado);
    }
    public void testarSaidas(){
        HashMap<String[], String[]> answers = new HashMap<String[], String[]>();
        String[] retorno = new String[2];
        answers.put(new String[]{"03/08/2018", "3", "5"}, new String[]{"Meu Canino Feliz", "260.0"});
        answers.put(new String[]{"06/07/2020", "9", "1"}, new String[]{"Vai Rex", "185.0"});
        answers.put(new String[]{"07/07/2020", "2", "2"}, new String[]{"Meu Canino Feliz", "120.0"});
        answers.put(new String[]{"08/07/2020", "8", "4"}, new String[]{"Vai Rex", "320.0"});
        answers.put(new String[]{"09/07/2020", "6", "7"}, new String[]{"Meu Canino Feliz", "400.0"});
        answers.put(new String[]{"10/07/2020", "8", "8"}, new String[]{"Meu Canino Feliz", "480.0"});
        answers.put(new String[]{"11/07/2020", "3", "9"}, new String[]{"Chow Mara", "495.0"});
        answers.put(new String[]{"12/07/2020", "7", "4"}, new String[]{"Vai Rex", "360.0"});
        for (String[] chave: answers.keySet()) {
            Solucao solucao = new Solucao(chave[0], chave[1], chave[2]);
            retorno = solucao.resposta();
            this.executarTeste(retorno[0], retorno[1], answers.get(chave)[0], answers.get(chave)[1]);
        }
    }
}
