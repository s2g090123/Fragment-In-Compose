package com.example.fragmentincompose.phase4

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.fragment.compose.AndroidFragment
import androidx.fragment.compose.FragmentState
import androidx.fragment.compose.rememberFragmentState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

sealed interface Route {
  @Serializable
  data object A : Route

  @Serializable
  data object B : Route
}

fun interface NavigateTo {
  fun navigate(destination: Route)
}

class Phase4ComposeActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      val navController = rememberNavController()
      NavHost(navController = navController, startDestination = "${Route.A}") {
        composable("${Route.A}") {
          NavigationFragment<Phase4FragmentA>(
            modifier = Modifier.fillMaxSize(),
            navHostController = navController,
          )
        }
        composable("${Route.B}") {
          NavigationFragment<Phase4FragmentB>(
            modifier = Modifier.fillMaxSize(),
            navHostController = navController,
          )
        }
      }
    }
  }
}

@Composable
inline fun <reified T : NavigationFragment> NavigationFragment(
  navHostController: NavHostController,
  modifier: Modifier = Modifier,
  fragmentState: FragmentState = rememberFragmentState(),
  arguments: Bundle = Bundle.EMPTY,
  noinline onUpdate: (T) -> Unit = { },
) {
  val navController by rememberUpdatedState(navHostController)
  val update by rememberUpdatedState(onUpdate)

  AndroidFragment<T>(
    modifier = modifier,
    fragmentState = fragmentState,
    arguments = arguments,
    onUpdate = { fragment ->
      fragment.setNavigator { route ->
        navController.navigate("$route")
      }
      update(fragment)
    }
  )
}