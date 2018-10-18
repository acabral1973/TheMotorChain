package es.smartech.themotorchain

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import es.smartech.domain.Model.Car
import kotlinx.android.synthetic.main.activity_main.*
import es.smartech.themotorchain.Fragment.CarsFragment

class MainActivity : AppCompatActivity() {

    val carLists = ArrayList<Car>()
    val carsFragment = CarsFragment.newInstance(carLists)
    val gargesFragment = CarsFragment.newInstance(carLists)
    val showsFragment = CarsFragment.newInstance(carLists)

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_cars -> {
                openFragment(carsFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_garages -> {
                openFragment(gargesFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_shows -> {
                openFragment(showsFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        openFragment(carsFragment)
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
