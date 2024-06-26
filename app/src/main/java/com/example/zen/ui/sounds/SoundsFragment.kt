package com.example.zen.ui.sounds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.zen.databinding.FragmentSoundsBinding

class SoundsFragment : Fragment() {

    private var _binding: FragmentSoundsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val soundsViewModel =
            ViewModelProvider(this).get(SoundsViewModel::class.java)

        _binding = FragmentSoundsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSounds
        soundsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}