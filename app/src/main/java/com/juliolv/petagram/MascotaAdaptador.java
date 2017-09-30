package com.juliolv.petagram;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by julio on 29/09/2017.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    //Inflar layout y lo pasara al viewholder para que el obtenga los views
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);

        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvRatingCV.setText(mascota.getRating());


        /*contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra("nombre", contacto.getNombre());
                intent.putExtra("telefono", contacto.getTelefono());
                intent.putExtra("email", contacto.getEmail());
                activity.startActivity(intent);
            }
        });*/

        mascotaViewHolder.btnHueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste un hueso a " + mascota.getNombre(),
                        Toast.LENGTH_SHORT).show();

                int rating = Integer.parseInt(mascota.getRating());
                rating = rating + 1;
                mascota.setRating(String.valueOf(rating));
                mascotaViewHolder.tvRatingCV.setText(mascota.getRating());

                //mascotaViewHolder.tvRatingCV.setText(mascota.getRating());
            }
        });
    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista de contactos
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvRatingCV;
        private ImageButton btnHueso;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto         = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV      = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            tvRatingCV      = (TextView) itemView.findViewById(R.id.tvRatingMascota);
            btnHueso        = (ImageButton) itemView.findViewById(R.id.btnHueso);
        }
    }
}
