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

import com.example.akretourism.R;

public class RestaurantFragment extends Fragment {

    private RestaurantViewModel restaurantViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        restaurantViewModel =
                ViewModelProviders.of(this).get(RestaurantViewModel.class);
        View root = inflater.inflate(R.layout.fragment_restaurant, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        restaurantViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}