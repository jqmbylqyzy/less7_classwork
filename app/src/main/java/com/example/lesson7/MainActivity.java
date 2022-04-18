package com.example.lesson7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    TextView phone , iosphone;
    RadioButton card,nalom;
    CheckBox surprise,adress;
    Button zhberu;
    String tolem_turu , zhetkizu_turu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phone = findViewById(R.id.phone);
        iosphone = findViewById(R.id.iosphone);
        card = findViewById(R.id.card);
        nalom = findViewById(R.id.nalom);
        surprise = findViewById(R.id.surprise);
        adress = findViewById(R.id.adress);
        zhberu = findViewById(R.id.zhberu);
        registerForContextMenu(iosphone);
        registerForContextMenu(phone);
        zhberu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (card.isChecked()){
                    tolem_turu="Bank card arkyly";
                }
                else if (nalom.isChecked()){
                    tolem_turu="nal arkyly";
                }
                if (surprise.isChecked()){
                    zhetkizu_turu="surprise  arkyly";
                }
                if (adress.isChecked()){
                    zhetkizu_turu="adress arkyly";
                }
                String res = "Android:" +phone.getText()+"/n"+
                        "ios:"+iosphone.getText()+"/n"+
                        "tolem turu:"+tolem_turu+"/n"+
                        "zhetkizu tiru:"+zhetkizu_turu;
                Toast.makeText(MainActivity.this,res,Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v == phone) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.android_menu, menu);
        }
        if ( v ==iosphone){
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.ios_menu, menu);
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.samsung:
                phone.setText("Samsung");
                break;
            case R.id.huawei:
                phone.setText("Huawei");
                break;
            case R.id.xiaomi:
                phone.setText("Xiaomi");
                break;
            case R.id.oppo:
                phone.setText("Oppo");
                break;
            case R.id.Iphone11:
                iosphone.setText("Iphone 11");
                break;
            case R.id.Iphone6:
                iosphone.setText("Iphone 6");
                break;
            case R.id.Iphone10:
                iosphone.setText("Iphone 10");
                break;
            case R.id.Iphonex:
                iosphone.setText("Iphone x");
                break;
        }
        return super.onContextItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_setting:
                Toast.makeText(this, "Setting menu basuldi" ,Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_exit:
                Toast.makeText(this, "exit menu basuldi" ,Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_save:
                Toast.makeText(this, "Save menu basuldi" ,Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_cut:
                Toast.makeText(this, "cut menu basuldi" ,Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}