package com.promptnow.econprice.fragment.weather;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.promptnow.econprice.R;

/**
 * Created by Acer on 30/8/2559.
 */

public class GuideWeather extends Fragment {
    private View rootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_guide_weather, container, false);


        setView();

        return rootView;
    }

    private void setView() {
        ImageView image = (ImageView) rootView.findViewById(R.id.imageView4);
        image.setImageResource(R.drawable.weather);
    }

}
