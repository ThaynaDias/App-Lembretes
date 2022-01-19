package com.example.applembretes;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Anotacao prerencias;
    private EditText edt_anotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prerencias = new Anotacao(MainActivity.this); // passando o contexto, ou seja a activity
        edt_anotacao = findViewById(R.id.edt_anotacao);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // acao do flote button
                String text = edt_anotacao.getText().toString();
                if(text.isEmpty()){ // verificar se ele ta fazio
                    Snackbar.make(view, "Preencha anotação", Snackbar.LENGTH_LONG).show();
                }else{
                    prerencias.salvarAnotacao(text);
                    Snackbar.make(view, "Anotação salva com sucesso", Snackbar.LENGTH_LONG).show();
                }
            }
        });
        // recuperar anotação
        String anotacao = prerencias.getAnotacao();
        if(!anotacao.isEmpty()){
            edt_anotacao.setText(anotacao);
        }
    }
}