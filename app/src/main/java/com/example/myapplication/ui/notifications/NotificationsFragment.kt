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
        if ((activity as MainActivity).getUsernameVal().equals("Alex")) {
          profileNameVal.text = "Alex Cheng"
          profileSchoolVal.text = "Academy for Information Technology"
          profileAchieve1Val.text = "Tech Intern"
          profileDesc1Val.text = "Tech Jones"
          profileAchieve2Val.text = "Black Belt Taekwondo"
          profileDesc2Val.text = "I could take 5 guys"
          profileAchieve3Val.text = "Piano Diploma"
          profileDesc3Val.text = "Fastest fingers in the West"
        }
        else if ((activity as MainActivity).getUsernameVal().equals("Name")) {
          profileSchoolVal.isCursorVisible = false
          profileSchoolVal.isFocusable = false
          profileAchieve1Val.isCursorVisible = false
          profileAchieve1Val.isFocusable = false
          profileDesc1Val.isCursorVisible = false
          profileDesc1Val.isFocusable = false
          profileAchieve2Val.isCursorVisible = false
          profileAchieve2Val.isFocusable = false
          profileDesc2Val.isCursorVisible = false
          profileDesc2Val.isFocusable = false
          profileAchieve3Val.isCursorVisible = false
          profileAchieve3Val.isFocusable = false
          profileDesc3Val.isCursorVisible = false
          profileDesc3Val.isFocusable = false
          profileNameVal.text = "Alex Cheng"
          profileSchoolVal.text = "Academy for Information Technology"
          profileAchieve1Val.text = "Tech Intern"
          profileDesc1Val.text = "Tech Jones"
          profileAchieve2Val.text = "Black Belt Taekwondo"
          profileDesc2Val.text = "I could take 5 guys"
          profileAchieve3Val.text = "Piano Diploma"
          profileDesc3Val.text = "Fastest fingers in the West"
        } else {
          profileNameVal.text = (activity as MainActivity).getUsernameVal()
        }
      } else {
        profileNameVal.text = "[Input Username]"
        profileSchoolVal.text = "[Input School]"
        profileSchoolVal.isCursorVisible = false
        profileSchoolVal.isFocusable = false
        profileAchieve1Val.text = "[Input Achievement]"
        profileAchieve1Val.isCursorVisible = false
        profileAchieve1Val.isFocusable = false
        profileDesc1Val.text = "[Input Achievement Description]"
        profileDesc1Val.isCursorVisible = false
        profileDesc1Val.isFocusable = false
        profileAchieve2Val.text = "[Input Achievement]"
        profileAchieve2Val.isCursorVisible = false
        profileAchieve2Val.isFocusable = false
        profileDesc2Val.text = "[Input Achievement Description]"
        profileDesc2Val.isCursorVisible = false
        profileDesc2Val.isFocusable = false
        profileAchieve3Val.text = "[Input Achievement]"
        profileAchieve3Val.isCursorVisible = false
        profileAchieve3Val.isFocusable = false
        profileDesc3Val.text = "[Input Achievement Description]"
        profileDesc3Val.isCursorVisible = false
        profileDesc3Val.isFocusable = false
      }
    }
    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}