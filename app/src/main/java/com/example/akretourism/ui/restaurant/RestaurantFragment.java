package com.example.akretourism.ui.restaurant;

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

public class RestaurantFragment extends Fragment {

    private RestaurantViewModel restaurantViewModel;
    private RecyclerView rv;
    String[] restaurantNames={"Korek","Korek","Korek","Korek","Korek"};
    String[] restaurantDesc={"hich xosh nya tkaya sardan makan :D","hich xosh nya tkaya sardan makan :D","hich xosh nya tkaya sardan makan :D","hich xosh nya tkaya sardan makan :D","hich xosh nya tkaya sardan makan :D"};
    int[] restaurantRes={R.drawable.rwanduz01,R.drawable.rwanduz02,R.drawable.rwanduz03,R.drawable.rwanduz04,R.drawable.rwanduz05};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        restaurantViewModel =
                ViewModelProviders.of(this).get(RestaurantViewModel.class);
        View root = inflater.inflate(R.layout.fragment_restaurant, container, false);
        rv=root.findViewById(R.id.restaurant_rv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new Adapter(getContext(),restaurantNames,restaurantDesc,restaurantRes));
        return root;
    }
}