package com.example.andinovanprastya.loginfirebase.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.andinovanprastya.loginfirebase.R;
import com.example.andinovanprastya.loginfirebase.model.Kamar;

public class KamarFragment extends ListFragment {
    private Listener listener;

    public KamarFragment() {
        // Required empty public constructor
    }

    // menampilkan dataset dari array
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] names = new String[Kamar.jeniskamar.length];
        for (int i = 0; i < names.length; i++){
            names[i] = Kamar.jeniskamar[i].getName();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater.getContext(),
                android.R.layout.simple_list_item_1, names);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }



    public interface Listener {
        void itemClicked(long id);
    }

    // create listener
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this . listener = (Listener) context ;
    }

    @Override
    public void onListItemClick(ListView listView, View itemView, int position, long id){
        if(listener != null)
        {
            listener.itemClicked(id);
        }
    }
}
