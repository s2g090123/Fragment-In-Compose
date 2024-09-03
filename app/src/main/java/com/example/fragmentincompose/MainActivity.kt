package com.example.fragmentincompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import androidx.fragment.compose.AndroidFragment
import androidx.fragment.compose.rememberFragmentState
import com.example.fragmentincompose.phase3.Phase3Fragment
import com.example.fragmentincompose.ui.theme.FragmentInComposeTheme

class MainActivity : FragmentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      FragmentInComposeTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          /**
           * Display a Fragment in Compose using AndroidFragment
           */
          AndroidFragment(
            modifier = Modifier.padding(innerPadding),
            clazz = Phase3Fragment::class.java,
            fragmentState = rememberFragmentState(),
            arguments = Bundle.EMPTY,
            onUpdate = { fragment ->
              // Executed after onResume, and you can initialize the content of the fragment here
            }
          )
        }
      }
    }
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!",
    modifier = modifier
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  FragmentInComposeTheme {
    Greeting("Android")
  }
}