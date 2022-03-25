package com.example.yumyum.view.main

import android.R.attr.password
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.yumyum.databinding.ActivityLoginBinding
import com.example.yumyum.databinding.ActivityRegisterBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        val view = binding.root;
        setContentView(view)
        initData();
    }


    private fun initData(){
        auth = FirebaseAuth.getInstance()
        clickListener();
    }

    private fun clickListener(){
        binding.registerButton.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java));
            finish();
        }

        binding.connectionButton.setOnClickListener {
            getUserData()
        }
    }

    private fun getUserData(){
        var email = binding.userEditText.text.toString()
        var password = binding.passwordEditView.text.toString()

        if(email.isNotEmpty() && password.isNotEmpty()){
            authUser(email, password)
        }else{
            Toast.makeText(this, "Echec de l'autentification ...",Toast.LENGTH_LONG).show()
        }
    }

    private fun authUser(email: String, password: String){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                checkResult(it.isSuccessful)
            }
    }

    private fun checkResult(isSuccess: Boolean){

        if(isSuccess){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }else{
            Toast.makeText(this, "Echec de l'autentification ...",Toast.LENGTH_LONG).show()
        }

    }

}