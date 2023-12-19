package com.example.myapplication.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.MainActivity
import com.example.myapplication.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

private var _binding: FragmentNotificationsBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

    _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
    val root: View = binding.root

    val profileNameVal: TextView = binding.profileName
    val profileSchoolVal: TextView = binding.profileSchool
    val profileAchieve1Val: TextView = binding.profileAchieve1
    val profileDesc1Val: TextView = binding.profileDesc1
    val profileAchieve2Val: TextView = binding.profileAchieve2
    val profileDesc2Val: TextView = binding.profileDesc2
    val profileAchieve3Val: TextView = binding.profileAchieve3
    val profileDesc3Val: TextView = binding.profileDesc3
    notificationsViewModel.text.observe(viewLifecycleOwner) {
      if ((activity as MainActivity).getSignedIn()) {
        profileNameVal.text = (activity as MainActivity).getUsernameVal()
      } else {
        profileNameVal.text = "[Input Username]"
      }
      profileSchoolVal.text = "[Input School]"
      profileAchieve1Val.text = "[Input Achievement]"
      profileDesc1Val.text = "[Input Achievement Description]"
      profileAchieve2Val.text = "[Input Achievement]"
      profileDesc2Val.text = "[Input Achievement Description]"
      profileAchieve3Val.text = "[Input Achievement]"
      profileDesc3Val.text = "[Input Achievement Description]"
    }
    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}