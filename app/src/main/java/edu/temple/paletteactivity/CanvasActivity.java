package edu.temple.paletteactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

       final ConstraintLayout mylayout2=findViewById(R.id.layout2);


        Intent myIntent2 = getIntent();
        String [] colors2 = myIntent2.getStringArrayExtra("colors");
        int index = myIntent2.getIntExtra("index",-1);
        mylayout2.setBackgroundColor(Color.parseColor(colors2[index]));


    }
}
