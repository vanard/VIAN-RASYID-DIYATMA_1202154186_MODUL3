package com.studycase.vanard.vianrasyiddiyatma_1202154186_modul3;

import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcView;
    Adapter adapter;
    ArrayList<Galon> brandGalon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set title activity
        setTitle("Daftar Air Mineral");
        //membuat arraylist objek
        brandGalon = new ArrayList<>();
        //bind data
        rcView = findViewById(R.id.rcview);
        //set fix size
        rcView.setHasFixedSize(true);
        //kondisi orientasi landscape
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            //tampilkan 2 grid
            rcView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        }else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){ //jika portrait 1 saja
            rcView.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));
        }
        initData();
    }

    //method ketika configurasi diubah
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            rcView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        }else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){ //jika portrait 1 saja
            rcView.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));
        }
    }

    public void initData(){
        //get resource dari strings.xml
        String[]judul = getResources().getStringArray(R.array.title);
        String[]subjudul = getResources().getStringArray(R.array.subtitle);
        String[]descrip = getResources().getStringArray(R.array.desc);
        TypedArray imgLogo = getResources().obtainTypedArray(R.array.logo);
        //clear data yang sudah ada
        brandGalon.clear();
        //buat arraylist dari objek brandGalon dengan isikan judul dan subjudul
        for (int i=0; i<judul.length; i++){
            brandGalon.add(new Galon(judul[i],subjudul[i],descrip[i],imgLogo.getResourceId(i,0)));
        }
        adapter = new Adapter(this, brandGalon);
        rcView.setAdapter(adapter);
    }
}
