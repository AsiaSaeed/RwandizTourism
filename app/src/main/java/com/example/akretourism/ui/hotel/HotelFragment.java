package com.example.akretourism.ui.hotel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.akretourism.Adapter;
import com.example.akretourism.R;

public class HotelFragment extends Fragment {

    private HotelViewModel hotelViewModel;
    private RecyclerView rv;
    String[] hotelNames={"Korek","Korek","Korek","Korek","Korek"};
    String[] hotelDesc={"hich xosh nya tkaya sardan makan :D","hich xosh nya tkaya sardan makan :D","hich xosh nya tkaya sardan makan :D","hich xosh nya tkaya sardan makan :D","hich xosh nya tkaya sardan makan :D"};
    int[] hotelRes={R.drawable.rwanduz01,R.drawable.rwanduz02,R.drawable.rwanduz03,R.drawable.rwanduz04,R.drawable.rwanduz05};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        hotelViewModel =
                ViewModelProviders.of(this).get(HotelViewModel.class);
        View root = inflater.inflate(R.layout.fragment_hotel, container, false);
        rv=root.findViewById(R.id.hotel_rv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new Adapter(getContext(),hotelNames,hotelDesc,hotelRes));
        return root;
    }

}