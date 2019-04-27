package com.example.naosei;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editRa, editNome, ediTcurso;
    Button btnAdd, btnViewALL, btnDropDatabase;

    ArrayList<String> ListaALuno = new ArrayList<>();

    // faz instancia do banco de dados
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editRa = findViewById(R.id.txt1);
        editNome = findViewById(R.id.txt2);
        ediTcurso = findViewById(R.id.txt3);

        btnAdd = findViewById(R.id.btnGrava);
        btnViewALL = findViewById(R.id.btnLista);
        btnDropDatabase = findViewById(R.id.btnDrop);


        // Cria um Banco de dados

        db = openOrCreateDatabase("AlunoDB",
                Context.MODE_PRIVATE
                ,null);
        String x;


        //Cria tabela
        db.execSQL("CREATE TABLE IF NOT EXISTS aluno "+ "(ra VARCHAR, nome VARCHAR, curso VARCHAR)");


          // BOTÃO INCLUIR
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ra = editRa.getText().toString();
                String nome = editNome.getText().toString();
                String curso = ediTcurso.getText().toString();

                //INSERT

            db.execSQL("INSERT INTO aluno VALUES(" + "'" + ra+ "','" + nome + "', '" + curso + "');");




            }
        });
        // BOTÃO LISTAR
        btnViewALL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListaALuno.clear();// LIMPA O ARRAY DE LIST

                // armazera os dados retornados da consulta
                Cursor c = db.rawQuery("SELECT * FROM aluno ", null);

                //INSERE A LINHA DO CURSOR NO ARRAYLIST
                while(c.moveToNext()){
                    ListaALuno.add(c.getString(1));
                    Log.d("nome:", c.getString(1));

                    ArrayAdapter<String> MeuAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1);
                }

            }
        });


        //acaba aqui
    }
}
