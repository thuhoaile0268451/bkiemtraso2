package com.example.baikiemtraso2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class ShowRecycle extends AppCompatActivity {

    RecyclerView recyclerView;
    com.example.baikiemtraso2.TreeAdapter mainAdapter;

    FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_recycle);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<com.example.baikiemtraso2.Tree> options =
                new FirebaseRecyclerOptions.Builder<com.example.baikiemtraso2.Tree>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("trees"), com.example.baikiemtraso2.Tree.class)
                        .build();

        mainAdapter = new com.example.baikiemtraso2.TreeAdapter(options);
        recyclerView.setAdapter(mainAdapter);

        //button add firebase
        floatingActionButton= (FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddTree.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainAdapter.stopListening();
    }
}