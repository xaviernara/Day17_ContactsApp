package com.example.day17_contactsapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.day17_contactsapp.adaptor.ContactAdapter
import com.example.day17_contactsapp.adaptor.ContactClickListener
import com.example.day17_contactsapp.databinding.FragmentAllContactsBinding
import com.example.day17_contactsapp.model.Address
import com.example.day17_contactsapp.model.Contact
import com.example.day17_contactsapp.viewmodel.ContactViewModel
import androidx.navigation.fragment.findNavController
import com.example.day17_contactsapp.R
import kotlinx.android.synthetic.main.fragment_all_contacts.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AllContactsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AllContactsFragment : Fragment(), ContactClickListener {
    /* private var param1: String? = null
     private var param2: String? = null*/
    private val viewModel by viewModels<ContactViewModel>()

    private lateinit var binding: FragmentAllContactsBinding
    private lateinit var contactGlobal: Contact

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }*/
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentAllContactsBinding.inflate(
        inflater,
        container,
        false
    ).also { binding = it }.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // val adapter = ContactAdapter()


        //viewModel = ViewModelProvider(this).get(ContactViewModel::class.java)
        initObservers()


        //onclick for add button using navigation
        //binding.addContactButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_allContactsFragment_to_create_Edit_ContactFragment))


        //insertContactsIntoDB()


        /*viewModel._allContactsList.observe(requireActivity()) {



        }
*/

    }


    private fun insertContactsIntoDB(): Contact {
        val phone = listOf("77793111")
        val email = listOf("xnara@yahoo.com")
        val address = Address("place st", "gary", "In", 45640)

        return Contact("xavier", "nara", address, phone, email, 1)
    }

    private fun insertContactsIntoDB2(): Contact {
        val phone = listOf("123456789")
        val email = listOf("thing@yahoo.com")
        val address = Address("place st", "gary", "In", 45640)

        return Contact("person", "place", address, phone, email, 2)
    }


    private fun initObservers() {
        viewModel.insertContacts(insertContactsIntoDB())
        viewModel.insertContacts(insertContactsIntoDB2())
        viewModel.getAllContacts()
        viewModel.contactsList.observe(viewLifecycleOwner, Observer { contactsList ->
            generateContactRecycler(contactsList)
        })


    }

    private fun generateContactRecycler(contactList: List<Contact>) {
        binding.contactRecycler.layoutManager = LinearLayoutManager(binding.contactRecycler.context)
        binding.contactRecycler.adapter = ContactAdapter(contactList, this)
    }

    //onClick inherited form onClick Interface for recyclerview
    override fun onClickListener(contact: Contact) {
        /*val firstName = contact.firstName
        val lastName = contact.lastName
        val address = contact.ADDRESS.toString()
        val email = contact.email.toString()
        val phone = contact.phone.toString()*/
        var action =
            AllContactsFragmentDirections.actionAllContactsFragmentToContactDetailsFragment(null)
        findNavController().navigate(action)
    }

}


