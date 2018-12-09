package com.example.andinovanprastya.loginfirebase.model;

import com.example.andinovanprastya.loginfirebase.R;

public class Kamar {
    private String nama_kamar;
    private String fasilitas;
    private String harga;
    private int gambar;
    private int gambar2;
    private int gambar3;
    private int gambar4;

    public static final Kamar[] jeniskamar= {
            new Kamar("DeCorner Guest House", "Kamar 2x3m, Kasur Kecil, Lemari, Gantungan baju, Kamar mandi bersama, Listrik", "Rp. 500.000 / Bulan", R.drawable.decorner1, R.drawable.decorner2, R.drawable.decorner3, R.drawable.decorner4),
            new Kamar("Helena Guest House", "Kamar 3x4m,Kasur standar, Lemari, Gantungan baju, Kamar mandi bersama, Listrik, Wifi", "Rp. 650.000 / Bulan", R.drawable.helena4, R.drawable.helena2, R.drawable.helena1, R.drawable.decorner3),
            new Kamar("Merbabu Guest House", "Kamar 3x4m, Kasur standar dobel, Lemari besar, Gantungan baju, Kamar mandi bersama, Listrik, Wifi", "Rp. 750.000 / Bulan", R.drawable.merbabu2, R.drawable.merbabu3, R.drawable.merbabu4, R.drawable.merbabu1),
            new Kamar("Omah Koe Guest House", "Kamar 3x4m, Kasur besar, Lemari besar, Gantungan baju, Kamar mandi pribadi (Shower, Air hangat), Listrik, Wifi, Kipas Angin", "Rp. 1.000.000 / Bulan", R.drawable.omah2, R.drawable.omah3, R.drawable.omah4, R.drawable.omah1),
            new Kamar("Kawi Guest House", "Kamar 4x7m, Kasur springbed, Lemari Besar, Gantungan baju, Kamar mandi pribadi (shower, bathup, air hangat), Kolam renang pribadi, Kulkas 5 Pintu, AC, TV, Telpon, Dapur pribadi, Pembantu", "Rp. 5.000.000 / Bulan", R.drawable.kawi2, R.drawable.kawi4, R.drawable.kawi5, R.drawable.kawi3),

    };

    public Kamar(String name, String facilitation, String price, int image, int image2, int image3, int image4) {
        this.nama_kamar = name;
        this.fasilitas = facilitation;
        this.harga = price;
        this.gambar = image;
        this.gambar2 = image2;
        this.gambar3 = image3;
        this.gambar4 = image4;
    }

    public String getName() {
        return nama_kamar;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public String getHarga() {
        return harga;
    }

    public int getGambar() {
        return gambar;
    }

    public int getGambar2() {
        return gambar2;
    }

    public int getGambar3() {
        return gambar3;
    }

    public int getGambar4() {
        return gambar4;
    }

    public String toString() {
        return this.nama_kamar;
    }
}
