package com.example.wtf;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calculate (View view){
        //načíst vstup
        EditText editText = findViewById(R.id.vstupnipoletyvole);

        //Kontrola dělitenosti
        try {
            int numero = Integer.parseInt(editText.getText().toString());
            int duration = Toast.LENGTH_LONG;
            if(numero%2 == 0) {
                CharSequence text = "sudé";
                Toast toast = Toast.makeText(this, text, duration);
                toast.show();
                TextView textview = findViewById(R.id.textView);
                textview.setText(text);
            }else if(numero%2 == 1){
                CharSequence text = "liché";
                Toast toast = Toast.makeText(this, text, duration);
                toast.show();
                TextView textview = findViewById(R.id.textView);
                textview.setText(text);
            }
        }catch (Exception e){
            CharSequence text = "zadej číslo";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
            TextView textview = findViewById(R.id.textView);
            textview.setText(text);
        }
    }
}

