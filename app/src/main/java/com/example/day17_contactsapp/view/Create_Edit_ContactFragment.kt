package com.example.day17_contactsapp.view

import android.os.Bundle
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
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val viewModel by viewModels<ContactViewModel>()

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
    ) = FragmentCreateEditContactBinding.inflate(
        inflater,
        container,
        false
    ).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        //binding.editButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_allContactsFragment_to_create_Edit_ContactFragment))

        binding.editButton.setOnClickListener{

            val args : Create_Edit_ContactFragmentArgs by navArgs()
            var address = args.contact?.ADDRESS
            var contact= args.contact
            //viewModel.insertContacts()
            viewModel.contactsList.observe(viewLifecycleOwner, Observer { contactsList ->

                if(contactsList.contains(contact)){
                    if (contact != null) {
                        viewModel.updateContact(contact)
                    }

                }

                if (contact != null) {
                    viewModel.insertContacts(contact)
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