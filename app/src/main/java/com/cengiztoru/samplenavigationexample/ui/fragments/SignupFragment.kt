package com.cengiztoru.samplenavigationexample.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.cengiztoru.samplenavigationexample.R

class SignupFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btnSignup).setOnClickListener(this)
        view.findViewById<Button>(R.id.btnReturnLogin).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnSignup -> {
                //send user data to remote etc.
                // ...
                returnLoginScreen()
            }
            R.id.btnReturnLogin -> {
                returnLoginScreen()
            }
        }
    }

    private fun returnLoginScreen() {
        //You can return login screen by 3 way
        navController.navigate(R.id.action_signupFragment_to_loginFragment)
//                navController.popBackStack()

//                activity!!.onBackPressed()
    }

}