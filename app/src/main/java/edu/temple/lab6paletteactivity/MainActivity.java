package edu.temple.lab6paletteactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Spinner;

import java.util.Locale;

import static android.graphics.Color.*;

public class MainActivity extends AppCompatActivity implements  PaletteFragment.OnPaletteSelectedListener{
     CanvasFragment canvasFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // final ConstraintLayout mylayout2=findViewById(R.id.layout2);


        //final Spinner textSpinner = findViewById(R.id.spinner);
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



        canvasFragment= CanvasFragment.newInstance(colorsEn);


        PaletteFragment paletteFragment = PaletteFragment.newInstance(colors,colorsEn);

        getSupportFragmentManager().beginTransaction().add(R.id.PaletteFrag,paletteFragment).add(R.id.CanvasFrag,canvasFragment).commit();

        //FragmentManager fragmentManager = getSupportFragmentManager();
        //FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();


        //fragmentTransaction.commit();


    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        if(fragment instanceof PaletteFragment){
            PaletteFragment paletteFragment = (PaletteFragment) fragment;
            paletteFragment.OnPaletteSelectedListener(this);


            /*
            canvasFragment= new CanvasFragment();
            getSupportFragmentManager().findFragmentById(R.id.CanvasFrag);

           CanvasFragment canvasFragment = new CanvasFragment();
           Bundle args = new Bundle();
           args.putStringArray();

             */
        }
    }

    @Override
    public void onColorSelected(int postion) {
        CanvasFragment canFrag = (CanvasFragment)
                getSupportFragmentManager().findFragmentById(R.id.CanvasFrag);
        if(canFrag != null){

            canFrag.updateCanFrag(postion);

           // canFrag.getView().setBackground(Color.);


        }else{

        }

    }
}
