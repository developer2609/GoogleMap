package com.developer.mapsactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.developer.mapsactivity.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.CameraPosition

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.setOnMarkerClickListener {
            Toast.makeText(this, "click", Toast.LENGTH_SHORT).show()
        true
        }

        // Add a marker in Sydney and move the camera
        val codial = LatLng(42.08142764601572, 63.55507473908758)
        val cameraPosition=CameraPosition.builder()
        cameraPosition.target(codial)
        cameraPosition.bearing(180f)
        cameraPosition.tilt(0f)
        cameraPosition.zoom(4f)
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition.build()))
        mMap.setOnMapClickListener {
            mMap.addMarker(MarkerOptions().title("marker").position(it))
        }
       }
}