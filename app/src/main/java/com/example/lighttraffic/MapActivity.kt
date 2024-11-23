package com.example.lighttraffic

import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Rect
import android.graphics.drawable.BitmapDrawable
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.lighttraffic.databinding.ActivityMapBinding
import org.osmdroid.api.IMapController
import org.osmdroid.config.Configuration
import org.osmdroid.events.MapListener
import org.osmdroid.events.ScrollEvent
import org.osmdroid.events.ZoomEvent
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay

class MapActivity : AppCompatActivity(), MapListener {
    private lateinit var binding: ActivityMapBinding

    private lateinit var mMap: MapView
    private lateinit var controller: IMapController
    private lateinit var mMyLocationOverlay: MyLocationNewOverlay

    private lateinit var locationManager: LocationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityMapBinding.inflate(layoutInflater)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setContentView(binding.root)

        binding.apply {
            btnBack.setOnClickListener {
                finish()
            }
        }

        Configuration.getInstance().load(
            applicationContext,
            getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE)
        )
        mMap = binding.osmmap
        mMap.setTileSource(TileSourceFactory.MAPNIK)
        mMap.mapCenter
        mMap.setMultiTouchControls(true)
        mMap.getLocalVisibleRect(Rect())

        controller = mMap.controller

        mMyLocationOverlay = MyLocationNewOverlay(GpsMyLocationProvider(this), mMap)
        mMyLocationOverlay.enableMyLocation()
        mMyLocationOverlay.enableFollowLocation()

        mMyLocationOverlay.isDrawAccuracyEnabled = true

        val latitude =  21.037425910029118
        val longitude = 105.78889286755597
        val mapPoint = GeoPoint(latitude, longitude)

        val icon1 = BitmapFactory.decodeResource(resources, R.drawable.point_location)
        val scaledIcon1 = Bitmap.createScaledBitmap(icon1, 50, 80, false)

        val positions = listOf(
            GeoPoint(latitude, longitude),
            GeoPoint( 21.028428210129306, 105.79080110944439),
            GeoPoint( 21.040628650709927,  105.79742656711718)
        )

        positions.forEach { position ->
            val marker = Marker(mMap)
            marker.position = position
            marker.icon = BitmapDrawable(resources, scaledIcon1)

            // Thêm Marker vào bản đồ
            mMap.overlays.add(marker)
        }

        controller.setZoom(15.0)
        controller.animateTo(mapPoint)

        val marker = Marker(mMap)
        marker.position = mapPoint
        val drawableIcon = BitmapDrawable(resources, scaledIcon1)
        marker.icon = drawableIcon

        mMap.overlays.add(marker)
        mMap.addMapListener(this)

        mMyLocationOverlay.runOnFirstFix {
            runOnUiThread {
                mMap.overlays.clear()
                mMap.overlays.add(mMyLocationOverlay)
                controller.setCenter(mMyLocationOverlay.myLocation)
                controller.animateTo(mMyLocationOverlay.myLocation)
            }
        }
    }

    override fun onScroll(event: ScrollEvent?): Boolean {
        return true
    }

    override fun onZoom(event: ZoomEvent?): Boolean {
        return false;
    }
}