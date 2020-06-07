package com.example.akretourism.ui.hotel;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import com.example.akretourism.ui.RecyclerItemClickListener;

public class HotelFragment extends Fragment {

    private HotelViewModel hotelViewModel;
    private RecyclerView rv;
    String[] hotelNames;
    String[] hotelNumbers;
    int[] hotelRes={R.drawable.hotel,R.drawable.hotel,
            R.drawable.hotel,R.drawable.hotel,
            R.drawable.hotel,R.drawable.hotel,
            R.drawable.hotel,R.drawable.hotel,
            R.drawable.hotel,R.drawable.hotel,
            R.drawable.hotel};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        hotelViewModel =
                ViewModelProviders.of(this).get(HotelViewModel.class);
        View root = inflater.inflate(R.layout.fragment_hotel, container, false);

        hotelNames = getResources().getStringArray(R.array.hotel_names);
        hotelNumbers = getResources().getStringArray(R.array.hotel_numbers);


        rv=root.findViewById(R.id.hotel_rv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new Adapter(getContext(),hotelNames, hotelNumbers,hotelRes));
        rv.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), rv ,new RecyclerItemClickListener.OnItemClickListener() {


                    @Override
                    public void onItemClick(View view, int position) {
                        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", hotelNumbers[position], null)));

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                })
        );
        return root;
    }

}