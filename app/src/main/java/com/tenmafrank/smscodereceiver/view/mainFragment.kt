package com.tenmafrank.smscodereceiver.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.tenmafrank.smscodereceiver.R
import com.tenmafrank.smscodereceiver.databinding.FragmentMainBinding
import com.tenmafrank.smscodereceiver.model.CodeResponse
import com.tenmafrank.smscodereceiver.viewmodel.mainFragmentViewModel

class mainFragment : Fragment() {
    private val viewModel: mainFragmentViewModel by viewModels()
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentMainBinding>(inflater,R.layout.fragment_main, container, false)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the OverviewViewModel
        //binding?.viewModel = viewModel


        with(binding){

            requestCodeButton.setOnClickListener {
               viewModel.getSMSCode(smsStringTextField.text.toString(), telStringTextField.text.toString()).toString()
            }
            verifyCodeButton.setOnClickListener {
                //viewModel.getSingleUser(userIdStringTextField.text.toString())
                viewModel.getAPITest()
            }
            return root
        }
    }

}