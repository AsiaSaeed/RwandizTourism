package com.example.akretourism.ui.places;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.akretourism.Adapter;
import com.example.akretourism.R;

public class PlacesFragment extends Fragment {

    private PlacesViewModel placesViewModel;
    private RecyclerView rv;
    String[] placeNames ={"Korek","Korek","Korek","Korek","Korek"};
    String[] placeDesc ={"hich xosh nya tkaya sardan makan :D","hich xosh nya tkaya sardan makan :D","hich xosh nya tkaya sardan makan :D","hich xosh nya tkaya sardan makan :D","hich xosh nya tkaya sardan makan :D"};
    int[] placeRes ={R.drawable.rwanduz01,R.drawable.rwanduz02,R.drawable.rwanduz03,R.drawable.rwanduz04,R.drawable.rwanduz05};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        placesViewModel =
                ViewModelProviders.of(this).get(PlacesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_places, container, false);
        rv=root.findViewById(R.id.place_rv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new Adapter(getContext(), placeNames, placeDesc, placeRes));
        return root;
    }
}