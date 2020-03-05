package com.example.android.quakereport;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;
import java.util.ArrayList;

public class DataAdapter extends ArrayAdapter {

    public DataAdapter(Context context, ArrayList<Data> data) {
        super(context, 0, data);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem=convertView;

        if(listItem==null){
            listItem= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        final Data data=(Data)getItem(position);

        Double magnitude=data.getMag();
        int magcolor;
        switch ((int)Math.floor(magnitude)){
            case 1:
                magcolor=R.color.mag1;
                break;
            case 2:
                magcolor=R.color.mag2;
                break;
            case 3:
                magcolor=R.color.mag3;
                break;
            case 4:
                magcolor=R.color.mag4;
                break;
            case 5:
                magcolor=R.color.mag5;
                break;
            case 6:
                magcolor=R.color.mag6;
                break;
            case 7:
                magcolor=R.color.mag7;
                break;
            case 8:
                magcolor=R.color.mag8;
                break;
            case 9:
                magcolor=R.color.mag9;
                break;
            default:
                magcolor=R.color.mag10;
                break;
        }
        TextView mag=(TextView)listItem.findViewById(R.id.magnitude);
        GradientDrawable magnitudecircle=(GradientDrawable) mag.getBackground();
        magnitudecircle.setColor(ContextCompat.getColor(getContext(),magcolor));
        mag.setText(magnitude.toString());

        String place[]=data.getLocation().split("of",2);
        String offset,region;
        if(place.length==1)
        {
            offset="Nearby";
            region=place[0];
        }
        else
        {
            offset=place[0]+"of";
            region=place[1].substring(1);
        }

        TextView offsetView=(TextView)listItem.findViewById(R.id.offset);
        offsetView.setText(offset);

        TextView location=(TextView)listItem.findViewById(R.id.location);
        location.setText(region);

        TextView time=(TextView)listItem.findViewById(R.id.time);
        time.setText(data.getTime());

        TextView date=(TextView) listItem.findViewById(R.id.date);
        date.setText(data.getDate());

//        listItem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getContext(),"Item Clicked",Toast.LENGTH_SHORT).show();
//                new EarthquakeActivity().openurl(data.getUrl());
//            }
//        });
        return listItem;
    }
}
