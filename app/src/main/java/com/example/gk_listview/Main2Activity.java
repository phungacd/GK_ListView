package com.example.gk_listview;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gk_listview.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    EditText tenfile, noidung;
    Button trolai,open;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);

        tenfile = findViewById(R.id.txttenfile2);
        noidung = findViewById(R.id.txtnoidung2);
        trolai = findViewById(R.id.btnlai);
        open =  findViewById(R.id.btnmofile);
        Intent intent = new Intent();

        final ArrayList<String> filenamelist = getIntent().getExtras().getStringArrayList("filenamelist");
        final ListView listView = (ListView) findViewById(R.id.listview);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, filenamelist);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tenfile.setText(filenamelist.get(i).toString());
                String tenfileb = tenfile.getText().toString();
                SharedPreferences p = getApplicationContext().getSharedPreferences(tenfileb, 0);
                SharedPreferences.Editor editor = p.edit();
                try {
                    String ct = p.getString(tenfileb, null);
                    noidung.setText(ct);


                    Toast.makeText(Main2Activity.this, "Mở file thành công!!", Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                    Toast.makeText(Main2Activity.this, "Mở file thât bại", Toast.LENGTH_LONG).show();
                }
            }



        });


//        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                tenfile.setText(filenamelist.get(i).toString());
//                String tenfileb = tenfile.getText().toString();
//                SharedPreferences p = getApplicationContext().getSharedPreferences(tenfileb, 0);
//                SharedPreferences.Editor editor = p.edit();
//                try {
//                    String ct = p.getString(tenfileb, null);
//                    noidung.setText(ct);
//
//
//                    Toast.makeText(Main2Activity.this, "Mở file thành công!!", Toast.LENGTH_LONG).show();
//
//                } catch (Exception e) {
//                    Toast.makeText(Main2Activity.this, "Mở file thât bại", Toast.LENGTH_LONG).show();
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//                Toast.makeText(Main2Activity.this, "Chọn vào file", Toast.LENGTH_LONG).show();
//            }
//        });

        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filename = tenfile.getText().toString();

//                StringBuffer buffer = new StringBuffer();
//                String line = null;

                SharedPreferences p = getApplicationContext().getSharedPreferences(filename, 0);
                SharedPreferences.Editor editor = p.edit();
                try {
//                    FileInputStream fileInputStream = openFileInput(filename);
//                    BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
//                    while ((line= br.readLine())!=null){
//                        buffer.append(line).append("\n");
//
                    String ct = p.getString(filename,null);

                    noidung.setText(ct);
                    Toast.makeText(Main2Activity.this,"Mở file thành công!!",Toast.LENGTH_LONG).show();


                } catch (Exception e) {
                    Toast.makeText(Main2Activity.this,"Mở file thất bại",Toast.LENGTH_LONG).show();
                }
            }
        });

        trolai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent1);

            }
        });
    }
}
