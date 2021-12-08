package com.example.infinitysorteios3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TelaGP extends AppCompatActivity {

    private Button btnVoltarTCC;
    private Button btnAgrupar;
    private TextView txtListGP;
    private TextView txtQtdGP;
    private TextView lblResultGP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_gp);

        txtListGP = findViewById(R.id.txtListGP);
        txtQtdGP = findViewById((R.id.txtQtdGP));
        lblResultGP = findViewById((R.id.lblResultGP));

        btnAgrupar = findViewById(R.id.btnAgrupar);
        btnAgrupar.setOnClickListener(v -> {
            if(txtListGP.getText() != "" && txtQtdGP.getText() != ""){
                String result = GerarSorteioGrupo(txtListGP.getText().toString(), Integer.parseInt(txtQtdGP.getText().toString()));
                lblResultGP.setText(result);
            }else{
                lblResultGP.setText("Há campos vazios!");
            }
        });

        btnVoltarTCC = findViewById(R.id.btnVoltarTGP);
        btnVoltarTCC.setOnClickListener(v -> {
            finish();
        });
    }

    private String GerarSorteioGrupo(String listaItens, int qtdGrupos){
        Random random = new Random();
        String[] itens = listaItens.split(",");
        String result = "";

        if(qtdGrupos < 1 ){
            return "Quantidade de grupos deve ser maior que 0";
        }
        if (qtdGrupos > itens.length){
            return "Quantidade de grupos deve ser menor que o número de itens da lista";
        }
        if (itens.length % qtdGrupos != 0){
            return "A quantidade de itens deve ser divida exatamente pela quantidade de grupos";
        }
        int QtdItensGp = itens.length / qtdGrupos;

        List<Integer> listVerificacao = new ArrayList<Integer>();
        for (int i = 0; i < qtdGrupos; i++) {

            List<Integer> listGrupo = new ArrayList<Integer>();
            String partialResult = "";
            do {
                boolean adicionarLista = true;
                int indexSorteada = random.nextInt(itens.length);
                for (int item : listVerificacao) {
                    if (item == indexSorteada) {
                        adicionarLista = false;
                        break;
                    }
                }
                if (adicionarLista) {
                    listGrupo.add(indexSorteada);
                    listVerificacao.add(indexSorteada);
                    partialResult = partialResult + itens[indexSorteada] + ", ";
                }
            } while (listGrupo.size() < QtdItensGp);
            int numerogrupo = i + 1;
            StringBuffer resultPartialFormatado = new StringBuffer(partialResult);
            resultPartialFormatado.deleteCharAt(resultPartialFormatado.length()-2);
            result = result + "-> Grupo " + numerogrupo + ": " + resultPartialFormatado + "\n";
        }
        return result;
    }
}