package com.example.learnmath1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        auth = FirebaseAuth.getInstance()

        btnSignUp.setOnClickListener {
            signUpHandle()
        }
    }

    override fun onStart() {
        super.onStart()
    }

    private fun signUpHandle() {
        if (edtEmail1.text.toString().isEmpty()) {
            edtEmail1.error = "Please enter email"
            edtEmail1.requestFocus()
            return
        }

        if (edtPass1.text.toString().isEmpty()) {
            edtPass1.error = "Please enter email"
            edtPass1.requestFocus()
            return
        }

        if (edtRePass.text.toString().isEmpty()) {
            edtRePass.error = "Please enter email"
            edtRePass.requestFocus()
            return
        }

        if (edtRePass.text.toString() != edtRePass.text.toString()) {
            edtRePass.error = "Password not the same"
            edtRePass.requestFocus()
            return
        }

        auth.createUserWithEmailAndPassword(edtEmail1.text.toString(), edtPass1.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful){
                    val user = auth.currentUser
                    user?.sendEmailVerification()
                        ?.addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                startActivity(Intent(this, MainActivity::class.java))
                                finish()
                            }else {
                                Toast.makeText(this, "Sign Up failed. Try again after some time.", Toast.LENGTH_LONG).show()
                            }
                        }
                }
            }
    }
}
