package com.example.appjson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PokemonInter extends AppCompatActivity {
    private ImageView _PokemonImageView;
    private TextView _PokemonNameTextView, _txtInfo;
    private Button _bntBuscar, _btnRandom;
    private EditText _txtid ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_inter);
        _PokemonImageView= findViewById(R.id.PokemonImageView);
        _PokemonNameTextView=findViewById(R.id.PokemonNameTextView);
        _bntBuscar=findViewById(R.id.bntBuscar);
        _txtid=findViewById(R.id.txtid);
        _txtInfo=findViewById(R.id.txtInfo);
        //Parte de cabecera
        ImageView leftIcon = findViewById(R.id.left_icon);
        TextView title = findViewById(R.id.txtToolBar);


       //_btnRandom=findViewById(R.id.btnRandom);

        //Boton de regreso
        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PokemonInter.this, MainActivity.class);
                startActivity(intent);
            }
        });


        //boton de buscar
        _bntBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPokemon(Integer.parseInt(_txtid.getText().toString()));
            }
        });


    }
    public void getPokemon(int id) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://pokeapi.co/api/v2/pokemon/" + id)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("" + response);
                } else {
                    Gson gson = new Gson();
                    final Pokemon pokemon = gson.fromJson(response.body().string(), Pokemon.class);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            _PokemonNameTextView.setText(pokemon.getName().toUpperCase());
                            String statsInfo = "";

                            // Obtener la lista de estadísticas
                            List<Stats> statsList = pokemon.getStats();

                            // Recorrer la lista de estadísticas y construir la cadena de información
                            for (Stats stats : statsList) {
                                String statName = stats.getStat().getName().toUpperCase();
                                int baseStat = stats.getBase_stat();
                                statsInfo += "  " + statName + " - " + baseStat + "\n";
                            }

                            _txtInfo.setText(statsInfo);
                            Picasso.get().load(pokemon.getSprites().getFront_default()).into(_PokemonImageView);
                        }
                    });
                }
            }
        });
    }







}