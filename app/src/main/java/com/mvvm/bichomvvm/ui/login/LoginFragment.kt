package com.mvvm.bichomvvm.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.mvvm.bichomvvm.R
import com.mvvm.bichomvvm.databinding.FragmentLoginBinding
import com.mvvm.bichomvvm.ui.home.HomeActivity
import com.mvvm.bichomvvm.utils.Constants.USER_NOT_EXISTS
import com.mvvm.bichomvvm.utils.Constants.WRONG_PASSWORD
import com.mvvm.bichomvvm.utils.DataState
import com.mvvm.bichomvvm.utils.isInputEmpty
import com.mvvm.bichomvvm.utils.toast
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding : FragmentLoginBinding? = null
    private val binding get() =_binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObserves()
        initListeners()
    }

    private fun initObserves(){
        viewModel.loginState.observe(viewLifecycleOwner, Observer { dataState ->
            when(dataState){
                is DataState.Success<Boolean> -> {
                    viewModel.getUserData()
                }
                is DataState.Error -> {
                    hideProgressDialog()
                    manageLoginErrorMessages(dataState.exception)
                }
                is DataState.Loading ->{
                    showProgressBar()
                }
                else -> Unit
            }
        })

        viewModel.userDataState.observe(viewLifecycleOwner, Observer { dataState ->
            when(dataState){
                is DataState.Success<Boolean> -> {
                    hideProgressDialog()
                    startActivity(Intent(requireContext(), HomeActivity::class.java))
                    activity?.finish()
                }
                is DataState.Error -> {
                    hideProgressDialog()
                    manageLoginErrorMessages(dataState.exception)
                }
                is DataState.Loading ->{
                    showProgressBar()
                }
                else -> Unit
            }
        })
    }

    private fun initListeners(){
        binding.btnLogin.setOnClickListener {
            loginUser()
        }
        binding.btnSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }
    }

    private fun loginUser(){
        if (isUserDataOk()){
            showProgressBar()

            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            viewModel.login(email, password)
        }
    }

    private fun isUserDataOk(): Boolean{
        return when{
            requireActivity().isInputEmpty(binding.etEmail, true) -> {
                activity?.toast(getString(R.string.login__error_enter_email))
                false
            }

            requireActivity().isInputEmpty(binding.etPassword, true) -> {
                activity?.toast(getString(R.string.login__error_enter_password))
                false
            }

            else ->{
                true // El usuario mete todos los datos
            }
        }
    }

    private fun manageLoginErrorMessages(exception: Exception) {
        when(exception.message){
            USER_NOT_EXISTS -> { activity?.toast(getString(R.string.login__error_user_no_registered)) }
            WRONG_PASSWORD -> { activity?.toast(getString(R.string.login__error_wrong_password)) }
            else -> { activity?.toast(getString(R.string.login__error_unknown_error)) }
        }
    }

    private fun hideProgressDialog() {
        binding.pbSignIn.visibility = View.GONE
        binding.btnLogin.text = getString(R.string.login__login_button)
        binding.btnLogin.isEnabled = true
    }

    private fun showProgressBar() {
        binding.btnLogin.text = ""
        binding.btnLogin.isEnabled = false
        binding.pbSignIn.visibility = View.VISIBLE
    }

}