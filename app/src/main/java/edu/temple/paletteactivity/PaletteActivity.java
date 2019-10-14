package edu.temple.paletteactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.Locale;

public class PaletteActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ConstraintLayout mylayout=findViewById(R.id.layout);
        // final ConstraintLayout mylayout2=findViewById(R.id.layout2);


        final Spinner textSpinner = findViewById(R.id.spinner);
        //final String[] colorsHard =  {"Please select a color","Blue","Cyan", "Gray","Green","Magenta", "Red","Yellow", "Teal", "DarkGray","LightGray","Lime"};
        Resources res = getApplicationContext().getResources();
        final String [] colors = res.getStringArray(R.array.colorsStr);

        //change language to english
        //Configuration confi = getResources().getConfiguration();
        Locale locale=new Locale("en");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);
        //getBaseContext().createConfigurationContext(config).getResources();

        Resources res2 = getBaseContext().createConfigurationContext(config).getResources();


        final String[] colorsEn = res2.getStringArray(R.array.colorsStr);





        final ColorAdapter adapter = new ColorAdapter(this,colors,colors.length,colorsEn);


        textSpinner.setAdapter(adapter);
        textSpinner.setSelection(0,false);

        textSpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){
                view.setBackgroundColor(Color.WHITE);


                Intent myIntent = new Intent(PaletteActivity.this,CanvasActivity.class);

                if(i!=0) {

                    myIntent.putExtra("colors", colors);
                    myIntent.putExtra("colors2", colorsEn);
                    myIntent.putExtra("index", i);
                    startActivity(myIntent);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
