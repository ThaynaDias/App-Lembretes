package com.example.applembretes;

import android.content.Context;
import android.content.SharedPreferences;

public class Anotacao {

    private Context context; // indicar activuty associada a essa manipulação
    private SharedPreferences preferences; // responsavel por criar o arquivo e carregar os dados
    private final  String NOME_ARQUIVO = "anotacao";
    private final String CHAVE_ARQUIVO = "nome";
    private SharedPreferences.Editor editor; // responsavel por criar o arquivo(manipular)

    public Anotacao(Context context){
        this.context = context;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void salvarAnotacao(String anotacao){
        editor.putString(CHAVE_ARQUIVO, anotacao); // usou a chave e o texto
        editor.commit(); // salvr os dados no arquivo

    }

    public String getAnotacao(){
        return preferences.getString(CHAVE_ARQUIVO,""); // pegar o texto
    }
}
