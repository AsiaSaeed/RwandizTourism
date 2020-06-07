package com.example.akretourism.ui.restaurant;

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

public class RestaurantFragment extends Fragment {

    private RestaurantViewModel restaurantViewModel;
    private RecyclerView rv;
    String[] restaurantNames;
    String[] restaurantNumbers;
    int[] restaurantRes={R.drawable.restaurant,R.drawable.restaurant,
            R.drawable.restaurant,R.drawable.restaurant,
            R.drawable.restaurant,R.drawable.restaurant,
            R.drawable.restaurant,R.drawable.restaurant,
            R.drawable.restaurant};
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        restaurantViewModel =
                ViewModelProviders.of(this).get(RestaurantViewModel.class);
        View root = inflater.inflate(R.layout.fragment_restaurant, container, false);


        restaurantNames = getResources().getStringArray(R.array.hotel_names);
        restaurantNumbers = getResources().getStringArray(R.array.hotel_numbers);



        rv=root.findViewById(R.id.restaurant_rv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new Adapter(getContext(),restaurantNames, restaurantNumbers,restaurantRes));
        rv.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), rv ,new RecyclerItemClickListener.OnItemClickListener() {


                    @Override
                    public void onItemClick(View view, int position) {
                        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", restaurantNumbers[position], null)));

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                })
        );
        return root;
    }
}