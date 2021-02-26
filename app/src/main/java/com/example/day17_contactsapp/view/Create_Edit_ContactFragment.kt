package com.example.day17_contactsapp.view

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.day17_contactsapp.R
import com.example.day17_contactsapp.databinding.FragmentAllContactsBinding
import com.example.day17_contactsapp.databinding.FragmentCreateEditContactBinding
import com.example.day17_contactsapp.model.Address
import com.example.day17_contactsapp.model.Contact
import com.example.day17_contactsapp.viewmodel.ContactViewModel
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private lateinit var binding: FragmentCreateEditContactBinding

/**
 * A simple [Fragment] subclass.
 * Use the [Create_Edit_ContactFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Create_Edit_ContactFragment : Fragment() {

    private val viewModel by viewModels<ContactViewModel>()
    val args : Create_Edit_ContactFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCreateEditContactBinding.inflate(
        inflater,
        container,
        false
    ).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.contactsList.observe(viewLifecycleOwner, Observer { contactsList ->
            binding.numberOfContactsText.text = contactsList.size.toString()
        })

        if (args.contact != null) {
            //viewModel.insertContacts(contact)
            binding.firstNameText.setText(args.contact!!.firstName)
            binding.lastNameText.setText(args.contact!!.lastName)
            binding.emailText.setText(args.contact!!.email.toString())
            binding.phoneNumberText.setText(args.contact!!.phone.toString())
            binding.cityText.setText(args.contact!!.ADDRESS?.city)
            binding.stateText.setText(args.contact!!.ADDRESS?.state)
            binding.zipcodeText.setText(args.contact!!.ADDRESS?.zipcode.toString())
            binding.streetText.setText(args.contact!!.ADDRESS?.streetAddress)
        }

        //binding.editButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_allContactsFragment_to_create_Edit_ContactFragment))

        binding.editButton.setOnClickListener{


            var fName = binding.firstNameText.text.toString()
            var lName = binding.lastNameText.text.toString()
            var email = listOf(binding.emailText.text.toString())
            var phone = listOf(binding.phoneNumberText.text.toString())
            var city = binding.cityText.text.toString()
            var state = binding.stateText.text.toString()
            var zipcode = binding.zipcodeText.text.toString().toInt()
            var street = binding.streetText.text.toString()
            val id = Random.nextInt(100)

            var address = Address(street,city,state,zipcode)
            var newContact = Contact(fName,lName,address,phone,email,id)

            //viewModel.insertContacts()
            viewModel.contactsList.observe(viewLifecycleOwner, Observer { contactsList ->


                if(!contactsList.contains(newContact)){
                    viewModel.insertContacts(newContact)
                    /*if (newContact != null) {
                        viewModel.updateContact(newContact)
                    }
                    else{

                    }*/

                }
            }

            )




        }


        /*val firstName = binding.firstNameText.text.toString()
        val lastName = binding.lastNameText.text.toString()
        val phone = listOf(binding.phoneNumberText.text.toString())
        val email = listOf(binding.emailText.text.toString())
        val street = binding.streetText.text.toString()
        val state = binding.stateText.text.toString()
        val zipcode = binding.zipcodeText.text.toString().toInt()
        val city = binding.cityText.text.toString()*/








    }


}