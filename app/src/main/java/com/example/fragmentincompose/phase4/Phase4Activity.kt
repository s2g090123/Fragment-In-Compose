package com.example.fragmentincompose.phase4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.createGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.fragment
import com.example.fragmentincompose.R
import kotlinx.serialization.Serializable

@Serializable
object A

@Serializable
object B

class Phase4Activity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(R.layout.activity_phase4)

    /**
     * Navigation in Fragment
     */
    val hostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
    hostFragment.navController.apply {
      graph = createGraph(startDestination = "$A") {
        fragment<Phase4FragmentA>("$A")
        fragment<Phase4FragmentB>("$B")
      }
    }
  }
}