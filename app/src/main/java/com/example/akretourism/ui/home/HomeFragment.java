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
        int []img={R.drawable.rwanduz01,R.drawable.rwanduz02,R.drawable.rwanduz03,R.drawable.rwanduz04,
                R.drawable.rwanduz05,R.drawable.rwanduz06,R.drawable.rwanduz07,R.drawable.rwanduz08,
                R.drawable.rwanduz09,R.drawable.rwanduz10};

        vf = root.findViewById(R.id.image_flipper);
//        webView = root.findViewById(R.id.map_url_v);
//        webView.loadUrl("google.com/maps/d/viewer?ie=UTF8&hl=en&t=h&msa=0&ll=36.66671754584973%2C43.38636199999996&mid=1_n5vYBvtfKuWcG8_ZdLpyGlGAPQ&z=9");
        for (int i=0;i<img.length;i++){
            flipperImages(img[i]);
        }

        return root;
    }



    public void flipperImages(int image){
        ImageView imageView=new ImageView(getContext());
        imageView.setBackgroundResource(image);
        vf.addView(imageView);
        vf.setFlipInterval(3000);
        vf.setAutoStart(true);
        vf.setInAnimation(getContext(),android.R.anim.slide_in_left);
        vf.setOutAnimation(getContext(),android.R.anim.slide_out_right);
    }
}