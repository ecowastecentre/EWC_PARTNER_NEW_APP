package com.example.bottomnavigation

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main2.*

/*
class MainActivity2 : AppCompatActivity() {
    lateinit var drawerlayout : DrawerLayout
    lateinit var navigationview : NavigationView
    lateinit var toggle : ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navigationview: NavigationView = findViewById(R.id.navigationView)
        val drawerlayout: DrawerLayout = findViewById(R.id.drawerLayout)


        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications,R.id.navigation_missed,R.id.drawerLayout
            )
        )





        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        navigationView.setNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.textViewProfile -> Toast.makeText(applicationContext,"clicked Profile",Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}*/


class MainActivity2 : AppCompatActivity() {
    lateinit var drawerLayout : DrawerLayout
    lateinit var navigationView : NavigationView
    lateinit var bottomNavigationview : BottomNavigationView
    lateinit var navController : NavController
    lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)




        val navigationView: NavigationView  = findViewById(R.id.navigationView)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val bottomNavigationview: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(bottomNavigationview,navController)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
   /*     val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications,R.id.navigation_missed,R.id.drawerLayout
            )
        )





        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavigationview.setupWithNavController(navController)
*/





        navigationView.setNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.textViewProfile -> Toast.makeText(applicationContext,"clicked Profile",Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
