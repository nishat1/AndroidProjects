package com.example.todoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyCustomArrayAdaptor extends ArrayAdapter {

    private Context context;
    private ArrayList<String> todoArray;

    public MyCustomArrayAdaptor(Context context, int textViewResourceId, ArrayList<String> todoArray) {

        // call base class constructor
        super(context, textViewResourceId, todoArray);

        // save the context and the array of strings we were given
        this.context = context;
        this.todoArray = todoArray;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View todoCard = inflater.inflate(R.layout.todo_card, parent, false);

        ImageView icon = (ImageView) todoCard.findViewById(R.id.cardIcon);
        icon.setImageResource (R.drawable.todo_icon);
        icon.setVisibility(View.VISIBLE);

        TextView label = (TextView) todoCard.findViewById(R.id.cardText);
        label.setText(this.todoArray.get(position));

        return todoCard;

    }
}
