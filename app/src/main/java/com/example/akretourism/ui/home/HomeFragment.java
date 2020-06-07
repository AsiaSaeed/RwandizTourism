package com.example.akretourism.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.akretourism.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    ViewFlipper vf;
    WebView webView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        int[] img = {R.drawable.rwanduz01, R.drawable.rwanduz03, R.drawable.rwanduz04,
                R.drawable.rwanduz05, R.drawable.rwanduz07, R.drawable.rwanduz08,
                R.drawable.rwanduz09, R.drawable.rwanduz10, R.drawable.rwanduz11,
                R.drawable.rwanduz12, R.drawable.rwanduz13, R.drawable.rwanduz14,
                R.drawable.rwanduz15, R.drawable.rwanduz16, R.drawable.rwanduz17,
                R.drawable.rwanduz18, R.drawable.rwanduz19, R.drawable.rwanduz20,
                R.drawable.rwanduz21, R.drawable.rwanduz22};

        vf = root.findViewById(R.id.image_flipper);
        for (int i = 0; i < img.length; i++) {
            flipperImages(img[i]);
        }

        return root;
    }


    public void flipperImages(int image) {
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(image);
        vf.addView(imageView);
        vf.setFlipInterval(3000);
        vf.setAutoStart(true);
        vf.setInAnimation(getContext(), android.R.anim.slide_in_left);
        vf.setOutAnimation(getContext(), android.R.anim.slide_out_right);
    }
}