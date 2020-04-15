package com.example.learnmath1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()

        btnLogin.setOnClickListener {
            startActivity(Intent(this, HomeActivuty::class.java))
            finish()
        }

        btnLogin.setOnClickListener {
            handleLogin()
        }

        tvSignUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }

    private fun handleLogin() {
        if (edtEmail.text.toString().isEmpty()) {
            edtEmail.error = "Chưa nhập Email"
            edtEmail.requestFocus()
            return
        }

        if (edtPass.text.toString().isEmpty()) {
            edtEmail.error = "Chưa nhập Password"
            edtEmail.requestFocus()
            return
        }

        auth.signInWithEmailAndPassword(edtEmail.text.toString(), edtPass.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    updateUI(null)
                }
            }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(currentUser: FirebaseUser?) {
        if (currentUser != null) {
            startActivity(Intent(this, HomeActivuty::class.java))
            finish()
        } else {
            Toast.makeText(baseContext, "Login fail", Toast.LENGTH_LONG).show()
        }
    }
}
