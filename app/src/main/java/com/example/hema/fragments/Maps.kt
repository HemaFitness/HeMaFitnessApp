package com.example.hema.fragments

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hema.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class Maps : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        val fitX = LatLng(49.626879449501786, 8.358735892936965)
        googleMap.addMarker(MarkerOptions().position(fitX).title("FitX"))

        val veniceBeach = LatLng(49.62633213399826, 8.362372146616371)
        googleMap.addMarker(MarkerOptions().position(veniceBeach).title("VeniceBeach"))

        val blackwhite = LatLng(49.63250660665036, 8.33715266992974)
        googleMap.addMarker(MarkerOptions().position(blackwhite).title("Black & White Fitness"))

        val high5gym = LatLng(49.6269098539525, 8.359614316355174)
        googleMap.addMarker(MarkerOptions().position(high5gym).title("High5 Gym"))

        val athletenschmiede = LatLng(49.61883746734236, 8.352176817780721)
        googleMap.addMarker(MarkerOptions().position(athletenschmiede).title("Athletenschmiede"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(athletenschmiede,14F))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}