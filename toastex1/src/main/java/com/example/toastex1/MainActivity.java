package com.example.toastex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnHello;
    Toast tmsg;
    EditText edtX, edtY, edtContent;
    int x=0, y=0;
    String msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHello=findViewById(R.id.btnHello);
        edtX=findViewById(R.id.edtX);
        edtY=findViewById(R.id.edtY);
        edtContent=findViewById(R.id.edtContent);


       /* btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg= edtContent.getText().toString();
                tmsg=Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG);
                x = Integer.parseInt(edtX.getText().toString());
                Log.e("slskfl", String.valueOf(x));
                y = Integer.parseInt(edtY.getText().toString());
                Log.e("slskfl", String.valueOf(y));
                tmsg.setGravity(Gravity.TOP|Gravity.LEFT, x, y);
                tmsg.show();
            }
        });*/
        btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tmsg=Toast.makeText(getApplicationContext(), "안녕하세요." , Toast.LENGTH_LONG);
                Display display=((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                int x=(int)Math.random()*display.getWidth();
                int y=(int)Math.random()*display.getHeight();
                tmsg.setGravity(Gravity.TOP | Gravity.LEFT,x,y);
                tmsg.show();
            }
        });
    }
}
