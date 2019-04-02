package com.example.todoapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TodoAcitivity extends AppCompatActivity {

    private MyCustomArrayAdaptor myTodoArrayAdapter;
    private ArrayList<String> myTodoStringArray = new ArrayList<>();
    EditText editTextTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_acitivity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Todo List");
        setSupportActionBar(toolbar);

        myTodoArrayAdapter = new MyCustomArrayAdaptor(this, android.R.layout.simple_list_item_1, myTodoStringArray);
        editTextTodo = (EditText) findViewById(R.id.editTextTodo);

        ListView PairedListView = (ListView) findViewById(R.id.todoList);
        PairedListView.setAdapter(myTodoArrayAdapter);

        myTodoArrayAdapter.notifyDataSetChanged();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextTodo.getText().length() <= 0) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please enter a Todo...", Toast.LENGTH_LONG);
//                    toast.setMargin(100,100);
                    toast.show();
                } else {
                    myTodoStringArray.add(editTextTodo.getText().toString());
                    myTodoArrayAdapter.notifyDataSetChanged();
                }
            }
        });
    }

}
