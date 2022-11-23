package com.example.baikiemtraso2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddTree extends AppCompatActivity {

    EditText Science_name,name, Characteristic,leaf_color, url;
    Button btnAdd, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tree);

        Science_name = findViewById(R.id.txtName_Science);
        name = findViewById(R.id.txtCommon_Name);
        Characteristic = findViewById(R.id.txtCharacteristic);
        leaf_color = findViewById(R.id.txtLeaf_color);
        url = findViewById(R.id.txtImageUrl);

        btnAdd = findViewById(R.id.btnAdd);
        btnBack = findViewById(R.id.btnBack);

        // luu
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inserData();
                clearAll();
            }
        });

        //thoat
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddTree.this,ShowRecycle.class);
                startActivity(intent);
            }
        });
    }

    private void inserData(){

        Map<String,Object> map = new HashMap<>();
        map.put("Science_name", Science_name.getText().toString());
        map.put("name",name.getText().toString());
        map.put("Characteristic",Characteristic.getText().toString());
        map.put("leaf_color",leaf_color.getText().toString());
        map.put("url",url.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("trees").push()
                .setValue(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddTree.this,"Thêm thành công!",Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddTree.this,"Thêm thất bại!",Toast.LENGTH_SHORT).show();

                    }
                });
    }

    private  void clearAll(){
        Science_name.setText("");
        name.setText("");
        Characteristic.setText("");
        leaf_color.setText("");
        url.setText("");
    }
}