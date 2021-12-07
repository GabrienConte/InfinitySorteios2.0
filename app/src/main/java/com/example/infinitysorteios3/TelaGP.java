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
        String[] nomes = listaItens.split(",");
        List<Integer> listSelecionados = new ArrayList<Integer>();
        String result = "";

        if(qtdGrupos < 1 ){
            return "Quantidade de grupos deve ser maior que 0";
        }
        if (qtdGrupos > nomes.length){
            return "Quantidade de grupos deve ser menor que o número de itens da lista";
        }

        do {
            boolean adicionarLista = true;
            int indexSorteada = random.nextInt(nomes.length);
            for (int i : listSelecionados){
                if (i == indexSorteada) {
                    adicionarLista = false;
                    break;
                }
            }
            if (adicionarLista) {
                listSelecionados.add(indexSorteada);
                result = result + nomes[indexSorteada] + ", ";
            }
        } while (listSelecionados.size() < qtdGrupos);

        StringBuffer resultFormatado = new StringBuffer(result);
        resultFormatado.deleteCharAt(resultFormatado.length()-2);

        return resultFormatado.toString();
    }
}