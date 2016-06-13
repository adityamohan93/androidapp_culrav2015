package com.mnnit.culrav.fragments;

import android.app.Activity;
import android.content.Context;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mnnit.culrav.home.R;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

//import com.google.android.gms.common.ConnectionResult;
//import com.google.android.gms.common.GooglePlayServicesUtil;
//import com.google.android.gms.maps.CameraUpdate;
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {

    GoogleMap map;
    Location myLocation;
    private LocationManager manager;
    private LatLng library;
    private FragmentActivity myContext;


    private LatLng sms, mpHall, basketCourt, skateCourt, tennisCourt,
            gangaGate, yamunaGate, NLH, seminarHall, lectureHallComplex,
            GSLectureRooms, footballGround, gymkhanaGround, fnLectureRooms,
            bikanerOutlet, saraswatiGate, newAdminBuilding, amulOutlet,
            vivekanadHostel, computerCentre, deanAcadBuilding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.fragment_maps, container,
                false);
        //map = ((SupportMapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        FragmentManager fragmentManager = getChildFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment)
                fragmentManager.findFragmentById(R.id.naksha);
        if (mapFragment == null)
            Log.e("here", "here");
        map = mapFragment.getMap();

        setupMap();
        //    feedBack = new FeedbackDialog(this, "AF_EA6EF4AC032A-23", Config.getFeedBackSettings());

        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        myContext = (FragmentActivity) activity;
        super.onAttach(activity);
    }

    private void setupMap() {

        if (map == null) {
            Crouton.makeText(getActivity(), "Google Maps not available", Style.ALERT).show();
            return;
        }
        /*
         * CameraPosition camPos = new CameraPosition.Builder().target(MNNIT)
		 * .zoom(16) .tilt(30) .build();
		 * map.animateCamera(CameraUpdateFactory.newCameraPosition(camPos));
		 */
        mpHall = new LatLng(25.491917, 81.865844);
        NLH = new LatLng(25.493031, 81.863092);
        GSLectureRooms = new LatLng(25.492781, 81.863234);
        seminarHall = new LatLng(25.492254, 81.862350);
        lectureHallComplex = new LatLng(25.491748, 81.862325);
        footballGround = new LatLng(25.4947416, 81.864632);
        gymkhanaGround = new LatLng(25.493398, 81.865975);
        fnLectureRooms = new LatLng(25.493924, 81.864346);
        basketCourt = new LatLng(25.492301, 81.866066);

        gangaGate = new LatLng(25.492648, 81.861216);
        yamunaGate = new LatLng(25.494221, 81.861488);
        saraswatiGate = new LatLng(25.491343, 81.866341);
        newAdminBuilding = new LatLng(25.493417, 81.862270);
        deanAcadBuilding = new LatLng(25.492369, 81.863044);
        skateCourt = new LatLng(25.492311, 81.865462);
        tennisCourt = new LatLng(25.493946, 81.865875);
        computerCentre = new LatLng(25.491689, 81.863150);
        vivekanadHostel = new LatLng(25.490506, 81.863147);
        library = new LatLng(25.493924, 81.864346);
        sms = new LatLng(25.490487, 81.864245);
        bikanerOutlet = new LatLng(25.491540, 81.866122);
        amulOutlet = new LatLng(25.4939459, 81.8623689);

        map.addMarker(new MarkerOptions().position(mpHall).title("MP Hall"));
        map.addMarker(new MarkerOptions().position(NLH).title(
                "New Lecuture Halls (NLH)"));
        map.addMarker(new MarkerOptions().position(GSLectureRooms).title(
                "GS Lecture Rooms"));
        map.addMarker(new MarkerOptions().position(seminarHall).title(
                "Seminar Hall"));
        map.addMarker(new MarkerOptions().position(lectureHallComplex).title(
                "Lecture Hall Complex"));
        map.addMarker(new MarkerOptions().position(footballGround).title(
                "Football Ground"));
        map.addMarker(new MarkerOptions().position(gymkhanaGround).title(
                "Gymkhana Ground"));
        map.addMarker(new MarkerOptions().position(fnLectureRooms).title(
                "FN Lecture Rooms"));
        map.addMarker(new MarkerOptions().position(basketCourt).title(
                "Basketball Court"));

        map.addMarker(new MarkerOptions().position(gangaGate).title(
                "Ganga Gate"));
        map.addMarker(new MarkerOptions().position(yamunaGate).title(
                "Yamuna Gate"));
        map.addMarker(new MarkerOptions().position(saraswatiGate).title(
                "Saraswati Gate"));
        map.addMarker(new MarkerOptions().position(newAdminBuilding).title(
                "MNNIT Administrative Building"));
        map.addMarker(new MarkerOptions().position(deanAcadBuilding).title(
                "Dean Academics Office"));
        map.addMarker(new MarkerOptions().position(skateCourt).title(
                "Skating Court"));
        map.addMarker(new MarkerOptions().position(tennisCourt).title(
                "Tennis Court"));
        map.addMarker(new MarkerOptions().position(computerCentre).title(
                "Computer Centre"));
        map.addMarker(new MarkerOptions().position(vivekanadHostel).title(
                "Swami Vivekanand Hostel"));
        map.addMarker(new MarkerOptions().position(library).title(
                "MNNIT Central Library"));
        map.addMarker(new MarkerOptions().position(sms).title(
                "School of Management Studies"));
        map.addMarker(new MarkerOptions().position(bikanerOutlet).title(
                "Bikaner Outlet"));
        map.addMarker(new MarkerOptions().position(amulOutlet).title(
                "Amul Outlet"));

        manager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        setupGPS();

    }

    private void setupGPS() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            setupGPSCompat();
            return;
        }
        manager.addGpsStatusListener(new GpsStatus.Listener() {

            @Override
            public void onGpsStatusChanged(int event) {
                map.setMyLocationEnabled(true);
            }
        });

        if (manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            map.setMyLocationEnabled(true);
            myLocation = map.getMyLocation();
            Crouton.makeText(getActivity(), "GPS is enabled", Style.INFO).show();
        } else {
            Crouton.makeText(getActivity(), "GPS is not enabled. Can not locate you",
                    Style.ALERT).show();
        }
    }

    void setupGPSCompat() {
        map.setMyLocationEnabled(true);
        myLocation = map.getMyLocation();
    }
}
