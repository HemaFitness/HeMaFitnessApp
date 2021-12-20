package com.example.hema


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.hema.fragments.*
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    private val startseiteFragment = Startseite()
    private val locationFragment = Maps()
    private val bmiFragment = BmiRechner()
    private val stoppuhrFragment = Stoppuhr()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(startseiteFragment)

        bottom_navigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.ic_home -> replaceFragment(startseiteFragment)
                R.id.ic_location -> replaceFragment(locationFragment)
                R.id.ic_bmi -> replaceFragment(bmiFragment)
                R.id.ic_stoppuhr -> replaceFragment(stoppuhrFragment)
            }
            true
        }
    }


    private fun replaceFragment(fragment: Fragment) {
        if(fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }
    }
}