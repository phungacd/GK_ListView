package com.example.gk_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gk_listview.MainActivity;
import com.example.gk_listview.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText tenfile, noidung;
    Button clear, luu,xem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tenfile = findViewById(R.id.txttenfile2);
        noidung = findViewById(R.id.txtnoidung2);
        clear = findViewById(R.id.btnnhapmoi);
        luu = findViewById(R.id.btnluu);
        xem = findViewById(R.id.btnxem);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleartext();
            }
        });


        final ArrayList<String> filenamelist = new ArrayList<String>();
        luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenfileb = tenfile.getText().toString();
                String noidungb = noidung.getText().toString();
                filenamelist.add(tenfileb);

                try {
                    SharedPreferences p = getApplicationContext().getSharedPreferences(tenfileb,0);
                    SharedPreferences.Editor editor = p.edit();
                    editor.putString(tenfileb,noidungb);
                    editor.commit();

                    cleartext();
                    Toast.makeText(MainActivity.this,"Lưu file thành công!!",Toast.LENGTH_LONG).show();



                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"Lỗi khi lưu file!!",Toast.LENGTH_LONG).show();
                }
            }
        });

        xem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("filenamelist",filenamelist);
                startActivity(intent);
            }
        });
    }

    public void cleartext() {
        tenfile.setText("");
        noidung.setText("");
        tenfile.requestFocus();
    }
}
