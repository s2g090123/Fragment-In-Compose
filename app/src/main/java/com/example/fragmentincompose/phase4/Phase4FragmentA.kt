package com.example.fragmentincompose.phase4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.compose.content
import com.example.fragmentincompose.R

class Phase4FragmentA : NavigationFragment() {
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_phase4_a, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    view.findViewById<Button>(R.id.btn_a).setOnClickListener {
      // Expected to retrieve the Navigator from here
      navigator?.navigate(Route.B)
    }
    content {
      // Expected to retrieve the Navigator from here
    }
  }
}