package com.example.placesofinterest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import PlaceAdapter

// It kept complaining about PlaceAdapter on line 15, and literally nothing else helped than
// importing PlaceAdapter manually (it suggested import but nothing happened when I tried to click

class MainActivity : AppCompatActivity() {

    private val places = arrayListOf<Place>()
    private val placeAdapter = PlaceAdapter(places)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews(){

        rvPlaces.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        rvPlaces.adapter = placeAdapter
        // Add place names and their drawable ids in the list
        for (i in Place.PLACE_NAMES.indices) {
            places.add(Place(Place.PLACE_NAMES[i], Place.PLACE_RES_DRAWABLE_IDS[i]))
        }
        placeAdapter.notifyDataSetChanged()
    }

}
