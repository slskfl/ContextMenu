package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button btnBack;
    ImageView imgPet;
    LinearLayout layout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBack = findViewById(R.id.btnBack);
        imgPet = findViewById(R.id.imPet);
        layout1 = findViewById(R.id.layout);

        registerForContextMenu(btnBack);
        registerForContextMenu(imgPet);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater=getMenuInflater();
        if(v==btnBack){
            menu.setHeaderTitle("배경색 변경");
            menuInflater.inflate(R.menu.backmenu, menu);
        }
        if(v==imgPet){
            menuInflater.inflate(R.menu.imgmenu, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.backRed:
                layout1.setBackgroundColor(Color.RED);
                break;
            case R.id.backGreen:
                layout1.setBackgroundColor(Color.GREEN);
                break;
            case R.id.backBlue:
                layout1.setBackgroundColor(Color.BLUE);
                break;
            case R.id.backBase:
                layout1.setBackgroundColor(Color.WHITE);
                break;
            case R.id.imgRotate:
                imgPet.setRotation(45);
                break;
            case R.id.imgSize:
                imgPet.setScaleX(2);
                imgPet.setScaleY(2);
                break;
            case R.id.imgReturn:
                imgPet.setScaleX(1);
                imgPet.setScaleY(1);
                imgPet.setRotation(0);
                break;
        }
        return super.onContextItemSelected(item);
    }
}