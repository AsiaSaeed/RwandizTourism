package com.example.akretourism.ui.About;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.akretourism.R;
import com.example.akretourism.SendMailActivity;

public class AboutFragment extends Fragment {

    private AboutModel aboutModel;
    private Button mail;
    private Button call;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        aboutModel =
                ViewModelProviders.of(this).get(AboutModel.class);
        View root = inflater.inflate(R.layout.fragment_about, container, false);
        mail=root.findViewById(R.id.mail);
        call=root.findViewById(R.id.call);

        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mailActivityIntent = new Intent(getActivity(), SendMailActivity.class);
                startActivity(mailActivityIntent);
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "123123123", null)));
            }
        });

        return root;
    }
}