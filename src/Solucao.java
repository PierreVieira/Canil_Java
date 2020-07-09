import petshops.ChowMara;
import petshops.MeuCaninoFeliz;
import petshops.VaiRex;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Solucao {
    private final int cachorros_pequenos, cachorros_grandes;
    private final String data;
    public Solucao(String data, String cachorros_pequenos, String cachorros_grandes){
        this.data = data;
        this.cachorros_pequenos = Integer.parseInt(cachorros_pequenos);
        this.cachorros_grandes = Integer.parseInt(cachorros_grandes);
    }

    public String[] resposta(){
        boolean fim_de_semana;
        fim_de_semana = this.fimDeSemana();
        return identificaMelhorCanil(fim_de_semana);
    }

    private String[] identificaMelhorCanil(boolean fim_de_semana) {
        float preco_meu_canino_feliz, preco_vai_rex, preco_chow_mara;
        MeuCaninoFeliz meu_canino_feliz = new MeuCaninoFeliz();
        String[] array_resposta = new String[2];
        VaiRex vai_rex = new VaiRex();
        ChowMara chow_mara = new ChowMara();
        preco_meu_canino_feliz = meu_canino_feliz.calcularPreco(this.cachorros_pequenos, this.cachorros_grandes, fim_de_semana);
        preco_vai_rex = vai_rex.calcularPreco(this.cachorros_pequenos, this.cachorros_grandes, fim_de_semana);
        preco_chow_mara = chow_mara.calcularPreco(this.cachorros_pequenos, this.cachorros_grandes, fim_de_semana);
        if (preco_meu_canino_feliz < preco_vai_rex && preco_meu_canino_feliz < preco_chow_mara){ //Caso Meu Canino Feliz seja o mais barato
            array_resposta[0] = meu_canino_feliz.nome;
            array_resposta[1] = Float.toString(preco_meu_canino_feliz);
        }
        else if (preco_vai_rex < preco_meu_canino_feliz && preco_vai_rex < preco_chow_mara){ //Caso Vai Rex seja o mais barato
            array_resposta[0] = vai_rex.nome;
            array_resposta[1] = Float.toString(preco_vai_rex);
        }
        else if(preco_chow_mara < preco_meu_canino_feliz && preco_chow_mara < preco_vai_rex){//Caso Chow Mara seja o mais barato
            array_resposta[0] = chow_mara.nome;
            array_resposta[1] = Float.toString(preco_chow_mara);
        }
        else if (preco_chow_mara == preco_meu_canino_feliz && preco_chow_mara == preco_vai_rex){//Caso seja tudo o mesmo preço
            array_resposta[0] = chow_mara.nome;
            array_resposta[1] = Float.toString(preco_chow_mara);
        }
        else if(preco_meu_canino_feliz > preco_chow_mara && preco_chow_mara == preco_vai_rex){// Caso Chow Mara e Vai Rex sejam os mais baratos
            array_resposta[0] = chow_mara.nome;
            array_resposta[1] = Float.toString(preco_chow_mara);
        }
        else if(preco_vai_rex > preco_chow_mara && preco_chow_mara == preco_meu_canino_feliz){// Caso Meu Canino Feliz e Chow Mara sejam os mais baratos
            array_resposta[0] = chow_mara.nome;
            array_resposta[1] = Float.toString(preco_chow_mara);
        }
        else if(preco_chow_mara > preco_meu_canino_feliz && preco_meu_canino_feliz == preco_vai_rex){// Caso Meu Canino Feliz e Vai Rex sejam o mais baratos
            array_resposta[0] = vai_rex.nome;
            array_resposta[1] = Float.toString(preco_vai_rex);
        }
        return array_resposta;
    }

    private boolean fimDeSemana(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date ontem = null;
        try {
            ontem = sdf.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        GregorianCalendar gc = new GregorianCalendar();
        assert ontem != null;
        gc.setTime(ontem);
        int diaDaSemana = gc.get(GregorianCalendar.DAY_OF_WEEK);
        return diaDaSemana == 1 || diaDaSemana == 7;
    }
}
