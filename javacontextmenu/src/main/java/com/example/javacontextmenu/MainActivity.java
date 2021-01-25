package com.example.javacontextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button btnBack;
    ImageView imgPet;
    LinearLayout layout;
    static final int BACKRED=1, BACKGREEN=2, BACKBLUE=3, BACKBASE=4;
    static final int IMGROTATE=5, IMGSIZE=6, IMGBASE=7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBack = findViewById(R.id.btnBack);
        imgPet = findViewById(R.id.imPet);
        layout = findViewById(R.id.layout);
        registerForContextMenu(btnBack);
        registerForContextMenu(imgPet);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v==btnBack){
            menu.setHeaderTitle("배경색 변경");
            menu.add(0,BACKRED,0,"배경색_빨강" );
            menu.add(0,BACKGREEN,0,"배경색_초록" );
            menu.add(0,BACKBLUE,0,"배경색_파랑" );
            menu.add(0,BACKBASE,0,"배경색_기본" );
        }
       if(v==imgPet){
           menu.add(0,IMGROTATE,0,"이미지_회전" );
           menu.add(0,IMGSIZE,0,"이미지_확대" );
           menu.add(0,IMGBASE,0,"이미지_기본" );
       }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case BACKRED:
                layout.setBackgroundColor(Color.RED);
                break;
            case BACKGREEN:
                layout.setBackgroundColor(Color.GREEN);
                break;
            case BACKBLUE:
                layout.setBackgroundColor(Color.BLUE);
                break;
            case BACKBASE:
                layout.setBackgroundColor(Color.WHITE);
                break;
            case IMGROTATE:
                imgPet.setRotation(45);
                break;
            case IMGSIZE:
                imgPet.setScaleX(2);
                imgPet.setScaleY(2);
                break;
            case IMGBASE:
                imgPet.setScaleX(1);
                imgPet.setScaleY(1);
                imgPet.setRotation(0);
                break;
        }
        return super.onContextItemSelected(item);
    }
}
