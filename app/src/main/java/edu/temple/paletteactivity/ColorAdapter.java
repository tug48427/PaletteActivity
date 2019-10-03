package edu.temple.paletteactivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



public class ColorAdapter extends BaseAdapter {
    private int count;
    private final Context context;
    private final String[] colors;





    public ColorAdapter (Activity context, String[] colors, int length){
        this.colors=colors;
        this.context=context;
        this.count=length;


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

        textView.setText(colorValue);

        textView.setBackgroundColor(Color.parseColor(colorValue));

        textView.setTextSize(22);

        textView.setPadding(5, 5,0,5);

        return textView;
    }
}
