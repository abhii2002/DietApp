package com.blissvine.dietapp.activities


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.blissvine.dietapp.fragments.DietPlanFragment
import com.blissvine.dietapp.fragments.InfoFragment
import com.blissvine.dietapp.fragments.MainFragment
import com.blissvine.dietapp.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.bottom_navigation
import kotlinx.android.synthetic.main.fragment_main.*



@AndroidEntryPoint
class MainActivity : AppCompatActivity(){

    private var doubleBackToExitPressedOnce = false


    private val mainFragment = MainFragment()
    private val dietPlanFragment = DietPlanFragment()
    private val infoFragment = InfoFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            replaceFragment(mainFragment)


            bottom_navigation.setOnNavigationItemSelectedListener {
                when(it.itemId){
                     R.id.ic_dashboard -> {
                         replaceFragment(mainFragment)


                     }
                     R.id.ic_dietPlan ->{
                         replaceFragment(dietPlanFragment)
                     }
                     R.id.ic_info -> replaceFragment(infoFragment)
                }
                true
            }


    }


    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            doubleBackToExit()
        }
    }

    private fun doubleBackToExit(){
        if(doubleBackToExitPressedOnce){
            super.onBackPressed()
            return
        }
        this.doubleBackToExitPressedOnce = true
        Toast.makeText(
            this,
            "Please click back again to exit",
            Toast.LENGTH_SHORT
        ).show()

        Handler(Looper.getMainLooper()).postDelayed({
            doubleBackToExitPressedOnce = false
        },2000)

    }

  private fun replaceFragment(fragment: Fragment){
       if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
             transaction.replace(R.id.fragment_container, fragment)
             transaction.commit()
       }
    }

 }