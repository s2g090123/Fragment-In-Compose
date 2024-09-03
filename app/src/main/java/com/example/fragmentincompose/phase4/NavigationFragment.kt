package com.example.fragmentincompose.phase4

import androidx.fragment.app.Fragment

abstract class NavigationFragment : Fragment() {
  protected var navigator: NavigateTo? = null
    private set

  fun setNavigator(navigator: NavigateTo?) {
    this.navigator = navigator
  }
}