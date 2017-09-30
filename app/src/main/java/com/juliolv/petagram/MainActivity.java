package com.juliolv.petagram;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.avMascotasFavoritas){
            Intent intent = new Intent(this, CincoMascotasFavoritas.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public MascotaAdaptador adapter;
    private void inicializarAdaptador(){
        adapter = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adapter);
    }

    public  void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.pet1, "Catty", "5"));
        mascotas.add(new Mascota(R.drawable.pet2, "Ronney","6"));
        mascotas.add(new Mascota(R.drawable.pet3, "John", "2"));
        mascotas.add(new Mascota(R.drawable.pet4, "Ashley", "2"));
        mascotas.add(new Mascota(R.drawable.pet5, "Sam", "9"));
        mascotas.add(new Mascota(R.drawable.pet6, "Fiddo", "1"));
        mascotas.add(new Mascota(R.drawable.pet7, "Toby", "7"));
        mascotas.add(new Mascota(R.drawable.pet8, "Roxy", "1"));
        mascotas.add(new Mascota(R.drawable.pet9, "Sue", "3"));
        mascotas.add(new Mascota(R.drawable.pet10, "Jimmy", "4"));

    }


}
