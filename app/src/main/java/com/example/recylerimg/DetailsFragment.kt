package com.example.recylerimg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.recylerimg.databinding.FragmentDetailsBinding



class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private var name: String? = null
    private var imageUrl: String? = null

    companion object {
        private const val ARG_NAME = "arg_name"
        private const val ARG_IMAGE_URL = "arg_image_url"

        fun newInstance(name: String, imageUrl: String): DetailsFragment {
            val fragment = DetailsFragment()
            val args = Bundle()
            args.putString(ARG_NAME, name)
            args.putString(ARG_IMAGE_URL, imageUrl)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            name = it.getString(ARG_NAME)
            imageUrl = it.getString(ARG_IMAGE_URL)
        }

        name?.let { binding.textViewDetails.text = it }
        imageUrl?.let {
            Glide.with(this)
                .load(it)
                .into(binding.imageViewDetails)
        }

        binding.buttonBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
