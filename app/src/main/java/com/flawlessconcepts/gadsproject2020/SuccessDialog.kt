package com.flawlessconcepts.gadsproject2020


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class SuccessDialog : DialogFragment() {



   // private val viewModel by viewModels<LoginViewModel>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.item_success_dialog, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
        //setupClickListeners(view)
    }



    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    private fun setupView(view: View) {
        //view.tvTitle.text = arguments?.getString(KEY_TITLE)
        //view.tvSubTitle.text = arguments?.getString(KEY_SUBTITLE)
        if (arguments?.getString(KEY_TITLE)=="SUCCESS"){
            view.findViewById<ImageView>(R.id.imageView3).setImageResource(R.drawable.successv)
            view.findViewById<TextView>(R.id.tv_success).text ="Submission Successful"
        }else { view.findViewById<ImageView>(R.id.imageView3).setImageResource(R.drawable.failure)
            view.findViewById<TextView>(R.id.tv_success).text ="Submission not Successful"
        }
    }



    companion object {

        const val TAG = "ResultDialog"

        private const val KEY_TITLE = "KEY_TITLE"
        private const val KEY_SUBTITLE = "KEY_SUBTITLE"

        fun newInstance(title: String, subTitle: String): SuccessDialog {
            val args = Bundle()
            args.putString(KEY_TITLE, title)
            args.putString(KEY_SUBTITLE, subTitle)
            val fragment = SuccessDialog()
            fragment.arguments = args
            return fragment
        }

    }
}
