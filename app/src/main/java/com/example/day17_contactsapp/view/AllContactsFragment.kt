package com.example.day17_contactsapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.day17_contactsapp.adaptor.ContactAdapter
import com.example.day17_contactsapp.databinding.FragmentAllContactsBinding
import com.example.day17_contactsapp.model.Contact
import com.example.day17_contactsapp.viewmodel.ContactViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AllContactsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AllContactsFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    val viewModel by viewModels<ContactViewModel>()

    private lateinit var binding: FragmentAllContactsBinding

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
        //insertContactsIntoDB()
    }

    private fun insertContactsIntoDB(): Contact {
        val phone = listOf<String>("77793111")
        val email = listOf<String>("xnara@yahoo.com")
        var contact = Contact("xavier", "nara", null, phone, email, 1)

        return contact
    }


    private fun initObservers() {
        viewModel.insertContacts(insertContactsIntoDB())
        viewModel.getAllContacts()
        viewModel._allContactsList.observe(requireActivity()) {
            generateDataList(it)
        }


    }

    private fun generateDataList(contactList: List<Contact>) {
        binding.contactRecycler.adapter = ContactAdapter(contactList)
        binding.contactRecycler.layoutManager = LinearLayoutManager(binding.contactRecycler.context)
    }


}