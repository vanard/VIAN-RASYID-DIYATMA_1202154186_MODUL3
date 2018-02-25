package com.studycase.vanard.vianrasyiddiyatma_1202154186_modul3;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by viani on 25/02/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.GalonHolder> {
    private Context c;
    private ArrayList<Galon> brandGalon;

    //konstruktor
    public Adapter(Context c, ArrayList<Galon> brandGalon) {
        this.c = c;
        this.brandGalon = brandGalon;
    }

    //inflate layout
    @Override
    public Adapter.GalonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GalonHolder(LayoutInflater.from(c).inflate(R.layout.list_brand_galon, parent, false));
    }

    //setting untuk tiap-tiap item pada recyclerview
    @Override
    public void onBindViewHolder(GalonHolder holder, int position) {
        //get posisi galon
        Galon galon = brandGalon.get(position);
        //set data
        holder.bindTo(galon);
        //kondisi gambar dari drawable dijadikan background
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
            holder.layout.setBackground(holder.layout.getResources().getDrawable(galon.getImgGalon()));
        }
        holder.layout.setTag(galon.getImgGalon());
    }

    //menghitung total item
    @Override
    public int getItemCount() {
        return brandGalon.size();
    }

    class GalonHolder extends RecyclerView.ViewHolder{
        //variable
        TextView titleGalon, subtitleGalon, descGalon;
        RelativeLayout layout;

        public GalonHolder(View itemView) {
            super(itemView);
            //bind data
            titleGalon = itemView.findViewById(R.id.title_galon);
            subtitleGalon = itemView.findViewById(R.id.subtitle_galon);
            descGalon = itemView.findViewById(R.id.descrip);
            layout = itemView.findViewById(R.id.layout);

            //implement onClick
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //membuat objek intent
                    Intent i = new Intent(c, DetailGalon.class);
                    //mengirimkan data ke activity yang dituju
                    i.putExtra("title", titleGalon.getText());
                    i.putExtra("subtitle", subtitleGalon.getText());
                    i.putExtra("desc", descGalon.getText());
                    i.putExtra("logo", layout.getTag().toString());
                    //startactivity
                    c.startActivity(i);
                }
            });
        }

        //method set data
        void bindTo(Galon galon){
            titleGalon.setText(galon.getTitle());
            subtitleGalon.setText(galon.getSubtitle());
            descGalon.setText(galon.getDesc());
        }
    }
}
