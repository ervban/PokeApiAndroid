package com.example.appjson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {

    private ImageSlider _imageSlider;
    private ImageSlider _imageSlide2;
    private TextView _txtNombre, _txtDetalles;
    private ImageView _imgPokemon;
    private Button _btnPokemon,_btnItem;
    private Button _button2;
    //Imagenes del slider

    //LLamado del


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().hide();

        _imageSlider = findViewById(R.id.imageSlider);
        _imageSlide2 = findViewById(R.id.imageSlider2);
        _btnPokemon = findViewById(R.id.btnPokemons);
        _btnItem = findViewById(R.id.btnItem);
        slider();
        _btnPokemon = findViewById(R.id.btnPokemons);
        _btnItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PokemonInter.class);
                startActivity(intent);
            }
        });
    }

    //Class slider
    public void slider(){
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        ArrayList<SlideModel> slideModels1 = new ArrayList<>();
        PokemonInter pokeApi = new PokemonInter();

        slideModels.add(new SlideModel(R.drawable.imagen1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.imagen2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.imagen3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.captura4, ScaleTypes.FIT));



        _imageSlider.setImageList(slideModels, ScaleTypes.FIT);


        slideModels1.add(new SlideModel(R.drawable.imagen12, ScaleTypes.FIT));
        slideModels1.add(new SlideModel(R.drawable.imagen22, ScaleTypes.FIT));
        slideModels1.add(new SlideModel(R.drawable.imagen33, ScaleTypes.FIT));
        slideModels1.add(new SlideModel(R.drawable.imagen44, ScaleTypes.FIT));

        _imageSlide2.setImageList(slideModels1, ScaleTypes.FIT);
    }


}