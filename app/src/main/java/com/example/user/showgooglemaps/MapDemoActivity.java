package com.example.user.showgooglemaps;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by USER on 17-05-2016.
 */
public class MapDemoActivity extends BaseMapActivity implements LocationListener{

    TextView locationTv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_maps;
    }


    @Override
    public void startDemo() {

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String bestProvider = locationManager.getBestProvider(criteria, true);
        Location location = locationManager.getLastKnownLocation(bestProvider);
        if (location != null) {
            onLocationChanged(location);
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling

            return;
        }
    }

     public void onLocationChanged(Location location) {
         locationTv = (TextView) findViewById(R.id.latlongLocation);
         double latitude = location.getLatitude();
         double longitude = location.getLongitude();
         LatLng latLng = new LatLng(latitude, longitude);
         getMap().addMarker(new MarkerOptions().position(latLng));
         getMap().moveCamera(CameraUpdateFactory.newLatLng(latLng));
         getMap().animateCamera(CameraUpdateFactory.zoomTo(15));
         locationTv.setText("Latitude:" + latitude + ", Longitude:" + longitude);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
