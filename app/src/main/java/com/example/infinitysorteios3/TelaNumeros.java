package com.example.infinitysorteios3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;

public class TelaNumeros extends AppCompatActivity {

    private Button btnVoltarTNUM;
    private Button btnSortearNum;
    private TextView txtSorteadorNUM;
    private TextView lblResultNUM;


   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_numeros);
        txtSorteadorNUM =findViewById(R.id.txtSorteadorNUM);
        lblResultNUM = findViewById(R.id.lblResultNUM);

        btnSortearNum = findViewById(R.id.btnSortearNUM);
        btnSortearNum.setOnClickListener(v ->{
            String result = GerarSorteioNumero(Integer.parseInt(txtSorteadorNUM.getText().toString()));
            lblResultNUM.setText(result);
        });

        btnVoltarTNUM = findViewById(R.id.btnVoltarTNUM);
        btnVoltarTNUM.setOnClickListener(v -> {
            finish();
        });
    }
    private String GerarSorteioNumero(int txtSorteadorNUM){
        Random random = new Random();
        List<Integer> listNumeros  = new ArrayList<Integer>();
        String result="";


        if(txtSorteadorNUM<1){
            return "Quantidade de números deve ser maior que 0";
        }
        if (txtSorteadorNUM > 1001){
            return "Quantidade de numeros deve estar entre 0 e 1000";
        }

        do{
            boolean adcionarLista=true;
            int indexSorteado= random.nextInt(1001);
            for (int i: listNumeros){
                if (i == indexSorteado){
                    adcionarLista = false;
                    break;
                }
            }
            if (adcionarLista){
                listNumeros.add(indexSorteado);
                result = result + indexSorteado + ",";
            }

        }while (listNumeros.size()< txtSorteadorNUM);

        StringBuffer resultFormatado = new StringBuffer(result);
        resultFormatado.deleteCharAt(resultFormatado.length()-1);

        return resultFormatado.toString();
    }
}