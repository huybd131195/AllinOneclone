package com.codefresher.allinone.fragment.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.codefresher.allinone.R
import com.codefresher.allinone.databinding.FragmentDetailFavoriteBinding
import com.codefresher.allinone.databinding.FragmentHomeBinding


class DetailFavoriteFragment : Fragment() {
    private var _binding: FragmentDetailFavoriteBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailFavoriteBinding.inflate(inflater, container, false)



        return binding.root
    }
//    private fun getAndSetData() {
//        val url = arguments?.getString("url")
//        val title = arguments?.getString("title")
//        val a1 = arguments?.getString("a1")
//        val a2 = arguments?.getString("a2")
//
//        Glide.with(requireContext()).load(url).into(binding.imgTrending)
//        binding.tvTitle.text = title
//        binding.tva1.text = a1
//        binding.tva2.text = a2
//        binding.tvTitle.text = title
//    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}