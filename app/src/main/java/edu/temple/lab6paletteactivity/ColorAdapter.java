package edu.temple.lab6paletteactivity;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



public class ColorAdapter extends BaseAdapter {
    private int count;
    private final Context context;
    private final String[] colors;
    private final String[] enColors;




    public ColorAdapter (Activity context, String[] colors, int length,String[] colors2){
        this.colors=colors;
        this.context=context;
        this.count=length;
        this.enColors=colors2;


    }


    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int postion, View convertView, ViewGroup viewGroup) {
        TextView textView;


        if (convertView != null && convertView instanceof TextView)
            textView = (TextView) convertView;
        else
            textView = new TextView(context);
        String colorValue = colors[postion];
        String colorValueEn = enColors[postion];






        if(postion != 0) {
            textView.setBackgroundColor(Color.parseColor(colorValueEn));
        }
        else{
            textView.setBackgroundColor(Color.WHITE);
        }
        textView.setText(colorValue);




        textView.setTextSize(22);

        textView.setPadding(5, 5,0,5);

        return textView;
    }
}
