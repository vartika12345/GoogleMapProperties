package com.example.user.showgooglemaps;

import android.graphics.Color;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.ui.IconGenerator;

/**
 * Created by USER on 17-05-2016.
 */
public class IconGeneratorDemoActivity extends BaseMapActivity {
    @Override
    protected void startDemo() {

        getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-33.8696, 151.2094), 10));

        IconGenerator iconFactory = new IconGenerator(this);
        addIcon(iconFactory, "Default", new LatLng(-33.8696, 151.2094));

        iconFactory.setColor(Color.CYAN);
        addIcon(iconFactory, "Custom color", new LatLng(-33.9360, 151.2070));

        iconFactory.setRotation(90);
        iconFactory.setStyle(IconGenerator.STYLE_RED);
        addIcon(iconFactory, "Rotated 90 degrees", new LatLng(-33.8858, 151.096));

    }

    private void addIcon(IconGenerator iconFactory, String aDefault, LatLng latLng) {
        MarkerOptions markerOptions = new MarkerOptions().
                icon(BitmapDescriptorFactory.fromBitmap(iconFactory.makeIcon(aDefault))).
                position(latLng).
                anchor(iconFactory.getAnchorU(), iconFactory.getAnchorV());

        getMap().addMarker(markerOptions);
    }


    }

