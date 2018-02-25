package com.studycase.vanard.vianrasyiddiyatma_1202154186_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailGalon extends AppCompatActivity {
    ImageView logo, galon;
    TextView title, desc, liter;
    int isi = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_galon);
        //set title activity
        setTitle("Detail Air Mineral");
        //bind data
        logo = findViewById(R.id.detail_logo);
        galon = findViewById(R.id.detail_galon);
        title = findViewById(R.id.detail_title);
        desc = findViewById(R.id.detail_desc);
        liter = findViewById(R.id.detail_liter);
        //inisiasi intent
        Intent i = this.getIntent();
        //cek apakah ada data yang dikirim
        if (i.hasExtra("title") && i.hasExtra("subtitle") && i.hasExtra("desc") && i.hasExtra("logo")){
            //terima data
            String img = i.getStringExtra("logo");
            String judul = i.getStringExtra("title");
            String descrip = i.getStringExtra("desc");
            //set data
            logo.setImageDrawable(this.getResources().getDrawable(Integer.valueOf(img)));
            title.setText(judul);
            desc.setText(descrip);
        }
    }

    public void decrease(View view) {
        //jika galon dikurangi akan menghasilkan lebih besar dari atau sama dengan 0
        if (galon.getDrawable().getLevel() - 1 >= 0){
            //maka volume air akan dikurangi 1
            isi-=1;
            //set text
            liter.setText(isi + " Liter");
            //set level gambar
            galon.setImageLevel(galon.getDrawable().getLevel() - 1);
        }else{
            //jika kurang dari 0 maka toast
            Toast.makeText(this, "Galon Almost empty!", Toast.LENGTH_SHORT).show();
        }
    }

    public void increase(View view) {
        //jika galon ditambah akan menghasilkan lebih kecil dari atau sama dengan 6
        if (galon.getDrawable().getLevel() + 1 <= 6){
            //maka volume air akan ditambah 1
            isi+=1;
            //set text
            liter.setText(isi + " Liter");
            //set level gambar
            galon.setImageLevel(galon.getDrawable().getLevel() + 1);
        }else{
            //jika lebih dari 6 maka toast
            Toast.makeText(this, "Galon Full!", Toast.LENGTH_SHORT).show();
        }
    }
}
