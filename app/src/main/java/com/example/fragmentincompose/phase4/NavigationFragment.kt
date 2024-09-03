package com.example.fragmentincompose.phase4

import androidx.fragment.app.Fragment

/**
 * Currently, there is no way to obtain the current Compose Navigator in a Fragment or Compose
 *
 *「WORKAROUND」
 * It’s necessary to store the current Navigator in the Fragment
 */
abstract class NavigationFragment : Fragment() {
  protected var navigator: NavigateTo? = null
    private set

  fun setNavigator(navigator: NavigateTo?) {
    this.navigator = navigator
  }
}