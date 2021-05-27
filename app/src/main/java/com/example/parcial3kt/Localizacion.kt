package com.example.parcial3kt

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.parcial3kt.databinding.FragmentLocalizacionBinding
import com.google.android.gms.location.*



class Localizacion : Fragment() {
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var binding: FragmentLocalizacionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentLocalizacionBinding>(inflater, R.layout.fragment_localizacion, container, false)
        return binding.root
    }

    @SuppressLint("MissingPermission")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())

        //Para poder suscribirme a los cambión en la ubicación, requiero dos objetos:

        //1. LocationRequest
        val locationRequest = LocationRequest.create()
        locationRequest.interval = 1000
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        //2. Callback
        val locationCallback: LocationCallback = object : LocationCallback() {
            override fun onLocationResult(location: LocationResult) {
                super.onLocationResult(location)
                val latitude = location.lastLocation.latitude
                val longitude = location.lastLocation.longitude
                binding.latitudeTextView.text = latitude.toString()
                binding.longitudeTextView.text = longitude.toString()
            }
        }
        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null)
    }

}