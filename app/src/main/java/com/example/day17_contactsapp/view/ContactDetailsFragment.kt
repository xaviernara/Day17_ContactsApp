package com.example.day17_contactsapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.day17_contactsapp.ContactDetailsFragmentArgs
import com.example.day17_contactsapp.ContactDetailsFragmentDirections
import com.example.day17_contactsapp.R

import com.example.day17_contactsapp.databinding.FragmentContactDetailsBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [ContactDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ContactDetailsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val args : ContactDetailsFragmentArgs by navArgs()

    
    private lateinit var  binding: FragmentContactDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentContactDetailsBinding.inflate(
        inflater,
        container,
        false
    ).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.emailText.text = args.contact?.email.toString()
        binding.addressText.text = args.contact?.ADDRESS.toString()
        binding.firstNameText.text = args.contact?.firstName
        binding.lastNameText.text = args.contact?.lastName
        binding.phoneNumberText.text = args.contact?.phone.toString()


        binding.addContactButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_contactDetailsFragment_to_create_Edit_ContactFragment))


        binding.editContactButton.setOnClickListener{

            //Navigation.createNavigateOnClickListener()

            val action = ContactDetailsFragmentDirections.actionContactDetailsFragmentToCreateEditContactFragment(args.contact)
            findNavController().navigate(action)
        }



    }

    /*companion object {
        *//**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ContactDetailsFragment.
         *//*
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ContactDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }*/
}