package com.example.akretourism;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.RecyclerVH> {
    Context c;
    String[] names;
    String[] desc;
    int[] res;

    public Adapter(Context c, String[] names, String[] desc, int[] res) {
        this.c = c;
        this.names = names;
        this.desc = desc;
        this.res = res;
    }

    @Override
    public RecyclerVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.item_design, parent, false);
        return new RecyclerVH(v);
    }

    @Override
    public void onBindViewHolder(RecyclerVH holder, int position) {
        holder.nameTxt.setText(names[position]);
        holder.descTxt.setText(desc[position]);
        holder.imageIV.setImageResource(res[position]);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    /*
    VIEWHOLDER CLASS
     */
    public class RecyclerVH extends RecyclerView.ViewHolder {
        TextView nameTxt;
        TextView descTxt;
        ImageView imageIV;

        public RecyclerVH(View itemView) {
            super(itemView);
            nameTxt = (TextView) itemView.findViewById(R.id.name_item);
            descTxt = (TextView) itemView.findViewById(R.id.desc_item);
            imageIV = (ImageView) itemView.findViewById(R.id.item_iv);
        }
    }
}