package com.ground0.mediacontrollertest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Vector;

/**
 * Created by Arjun on 21-08-2015.
 */
public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.ViewHolder> {

    Vector<String> data;
    Context context;
    LayoutInflater layoutInflator;

    public class ViewHolder extends RecyclerView.ViewHolder {

         TextView listItemText;

        public ViewHolder(View itemView) {
            super(itemView);
            listItemText = (TextView)itemView.findViewById(R.id.list_item_text);

        }
    }

    public void add(int position, String item) {
        data.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(String item) {
        int position = data.indexOf(item);
        data.remove(position);
        notifyItemRemoved(position);
    }

    public ListViewAdapter(Context context, Vector<String> data)
    {
        this.context = context;
        this.data = data;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if(layoutInflator == null)
        {
            layoutInflator = LayoutInflater.from(context);
        }
        View view = layoutInflator.inflate(R.layout.list_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        String string = data.get(i);
        viewHolder.listItemText.setText(string);

    }



    @Override
    public int getItemCount() {
        return data.size();
    }
}
