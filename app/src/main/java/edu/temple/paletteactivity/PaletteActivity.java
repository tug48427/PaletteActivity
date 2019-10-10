package edu.temple.paletteactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PaletteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ConstraintLayout mylayout=findViewById(R.id.layout);
        // final ConstraintLayout mylayout2=findViewById(R.id.layout2);


        final Spinner textSpinner = findViewById(R.id.spinner);
        final String[] colors =  {"Please select a color","Blue","Cyan", "Gray","Green","Magenta", "Red","Yellow", "Teal", "DarkGray","LightGray","Lime"};



        final ColorAdapter adapter = new ColorAdapter(this,colors,colors.length);


        textSpinner.setAdapter(adapter);
        textSpinner.setSelection(0,false);

        textSpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){
                view.setBackgroundColor(Color.WHITE);


                Intent myIntent = new Intent(PaletteActivity.this,CanvasActivity.class);
                //mylayout2.setBackgroundColor(Color.parseColor(colors[i]));
                myIntent.putExtra("colors",colors);
                myIntent.putExtra("index",i);
                startActivity(myIntent);



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
