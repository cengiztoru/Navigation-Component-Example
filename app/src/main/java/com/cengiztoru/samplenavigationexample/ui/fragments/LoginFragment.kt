package com.cengiztoru.samplenavigationexample.ui.fragments

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.cengiztoru.samplenavigationexample.R
import com.cengiztoru.samplenavigationexample.data.User
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btnLogin).setOnClickListener(this)
        view.findViewById<Button>(R.id.btnSignup).setOnClickListener(this)
//        btnLogin.setOnClickListener(this)
//        btnSignup.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.btnLogin -> {
                //PASS DATA WITH SAFE ARGS
                //if you add dependencies but Directions library not added rebuild project
                if (!TextUtils.isEmpty(etMail.text.toString()) && !TextUtils.isEmpty(etPassword.text.toString())) {

                    val user = getUserData()
//                    val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment(5) //ide will give error.
                    val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment(user)
                    navController.navigate(action)

                } else {
                    Toast.makeText(
                        requireContext(),
                        "PLEASE ENTER YOUR EMAIL AND PASSWORD",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            R.id.btnSignup -> {
                navController.navigate(R.id.action_loginFragment_to_signupFragment)
            }
        }
    }

    private fun getUserData(): User {
        return User(etMail.text.toString(), "Cengiz", "TORU")
    }

}