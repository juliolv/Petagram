package com.juliolv.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;

import java.util.ArrayList;

public class CincoMascotasFavoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotasFavoritas;
    private RecyclerView lista5MascotasFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinco_mascotas_favoritas);
        setTitle(getResources().getString(R.string.titulo_5MascotasFavoritas));

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        lista5MascotasFav = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        lista5MascotasFav.setLayoutManager(llm);
        inicializarLista5MascotasFav();
        inicializarAdaptador();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public MascotaAdaptador adapter;
    private void inicializarAdaptador(){
        adapter = new MascotaAdaptador(mascotasFavoritas, this);
        lista5MascotasFav.setAdapter(adapter);
    }

    public  void inicializarLista5MascotasFav() {
        mascotasFavoritas = new ArrayList<Mascota>();

        mascotasFavoritas.add(new Mascota(R.drawable.pet1, "Catty", "5"));
        mascotasFavoritas.add(new Mascota(R.drawable.pet2, "Ronney", "6"));
        mascotasFavoritas.add(new Mascota(R.drawable.pet3, "John", "7"));
        mascotasFavoritas.add(new Mascota(R.drawable.pet4, "Ashley", "2"));
        mascotasFavoritas.add(new Mascota(R.drawable.pet5, "Sam", "9"));

    }

    @Override
    public  boolean onKeyDown(int keyCode, KeyEvent event){

        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(CincoMascotasFavoritas.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}
