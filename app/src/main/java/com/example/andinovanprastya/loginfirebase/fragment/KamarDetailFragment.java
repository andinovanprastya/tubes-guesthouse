package com.example.andinovanprastya.loginfirebase.fragment;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andinovanprastya.loginfirebase.R;
import com.example.andinovanprastya.loginfirebase.model.Kamar;
import com.example.imagewatermark2.ImageWaterMarkView;
import com.example.imagewatermark2.WaterMarkParamBean;
import com.example.imagewatermark2.WaterMarkType;
import com.ladwa.aditya.greytouchimageview.GreyTouchImageView;

import java.util.ArrayList;

import br.com.felix.imagezoom.ImageZoom;


public class KamarDetailFragment extends Fragment {
    private long kosId;

    // activity digunakan untuk menampilkan layout (hanya 1) yg dpt membuat xml dan java
    // fragment merupakan sub activity yang dapat digunakan berkali kali

    // lifecycle activity ada 7, onstart, oncreate, on pause, on resume, on destroy, on stop, on restart
    // lifecycle fragment ada banyak, on createview, on attach, on detach, on activity created, on view state restore, on destroy view

    //notifikasi lewat console dsb notif
    // notif lewat postman dsb data

    // notifikasi berjalan di on background(pas aplikasi di tutup)
    // notif berjalan di forgrground ppas aplikasi dibuka

    // firebase adalah platform oleh gugel untuk mempermudah pengguna dalam mengembangkan aplikasi yg tlh dia buat
    // fcm adalah google api digunakan untuk mengirim pesan , mengirim pesan sampai 4kb

    // attach memanggil 1x di activity menempelkan fragment ke activity
    // detach digunakan ketika fragment gada di activity
    // on create view tumpukan

    // backstagk tumpukan activity atau fragment

    public KamarDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        // return ke halaman trsebut
        return inflater.inflate(R.layout.fragment_kamar_detail, container, false);
    }

    public void setKos(long id){
        this.kosId = id;
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();

        if(view != null){
            TextView title = view.findViewById(R.id.textTitle);
            Kamar tipekamar = Kamar.jeniskamar[(int) kosId];
            title.setText(tipekamar.getName());

            TextView fasilitas = view.findViewById(R.id.textFasilitas);
            fasilitas.setText(tipekamar.getFasilitas());

            TextView harga = view.findViewById(R.id.textPrice);
            harga.setText(tipekamar.getHarga());

//            ImageView img = view.findViewById(R.id.fotoKamar);
//            img.setImageResource(tipekamar.getGambar());

            ImageZoom img = view.findViewById(R.id.fotoKamar);
            img.setImageResource(tipekamar.getGambar4());

            ImageZoom img2 = view.findViewById(R.id.fotoKamar2);
            img2.setImageResource(tipekamar.getGambar());

            ImageZoom img3 = view.findViewById(R.id.fotoKamar3);
            img3.setImageResource(tipekamar.getGambar2());

            ImageZoom img4 = view.findViewById(R.id.fotoKamar4);
            img4.setImageResource(tipekamar.getGambar3());


//            GreyTouchImageView img = view.findViewById(R.id.fotoKamar);
//            img.setImageResource(tipekamar.getGambar());


//            waterMarkView= (ImageWaterMarkView) view.findViewById(R.id.fotoKamar);
//            waterMarkView.setImageBitmap(BitmapFactory.decodeResource(getResources(),tipekamar.getGambar()));
        }
    }
}
