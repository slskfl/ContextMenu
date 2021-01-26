package com.example.toastex2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnToast;
    TextView toastText;
    View toastView;
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToast=findViewById(R.id.btnToast);

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast=new Toast(MainActivity.this);
                toastView=View.inflate(MainActivity.this,R.layout.toast,null);
                toastText=toastView.findViewById(R.id.toastText);
                toastText.setText("우리는 인성 쓰레기 모임 ^_^");
                toast.setView(toastView);
                toast.show();
            }
        });
    }
}
