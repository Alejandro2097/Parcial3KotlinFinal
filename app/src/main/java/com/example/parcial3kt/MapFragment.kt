package com.example.parcial3kt

import android.annotation.SuppressLint
import android.location.Location
import android.os.Bundle
import android.view.View
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.tasks.OnSuccessListener


class MapFragment : SupportMapFragment(), OnMapReadyCallback, OnSuccessListener<Location>,
    GoogleMap.OnMapLongClickListener {

    private lateinit var map: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())
        getMapAsync(this)
    }

    @SuppressLint("MissingPermission")
    override fun onMapReady(p0: GoogleMap) {
        this.map = p0
        this.map.setOnMapLongClickListener(this)
        fusedLocationClient.lastLocation.addOnSuccessListener(this)
    }

    override fun onSuccess(p0: Location) {
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(p0.latitude, p0.longitude), 17f))
        map.addMarker(MarkerOptions().position(LatLng(p0.latitude, p0.longitude)).title("Posición Actual"))
    }

    override fun onMapLongClick(p0: LatLng) {
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(p0.latitude, p0.longitude), 17f))
        map.addMarker(MarkerOptions().position(LatLng(p0.latitude, p0.longitude)).title("Destino"))
    }

}

