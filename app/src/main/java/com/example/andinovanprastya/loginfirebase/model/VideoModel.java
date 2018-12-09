package com.example.andinovanprastya.loginfirebase.model;

public class VideoModel {
    private String nama;
    private String durasi;
    private String videoRawId;


    // Array nama video dan detailnya

    public static final VideoModel[] guesthouse ={
            new VideoModel("DeCorner",
                    "2:23",
                    "decorner"),
            new VideoModel("Kawi",
                    "2:13",
                    "kawi"),
            new VideoModel("Helena",
                    "2:27",
                    "helena"),
            new VideoModel("Merbabu",
                    "3:02",
                    "merbabu"),
            new VideoModel("Omah Koe",
                    "1:56",
                    "omahkoe")
    };

    // setiap data punya nama, deskripsi dan gambar
    private VideoModel(String nama, String durasi, String videoRawId){
        this.nama = nama;
        this.durasi = durasi;
        this.videoRawId = videoRawId;
    }

    public String getNama(){
        return nama;
    }

    public String getDurasi(){
        return durasi;
    }

    public String getVideoRawId(){
        return videoRawId;
    }

    @Override
    public String toString() {
        return this.nama;
    }
}
