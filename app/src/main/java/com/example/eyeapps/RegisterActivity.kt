package com.example.eyeapps

import android.os.Bundle
import android.util.Log.d
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.getField
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener {
    private val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        buttonSignUp.setOnClickListener(this)
        textLogin.setOnClickListener(this)


    }

    override fun onClick(v: View) {
        val i = v.id

        when (i) {
            R.id.buttonSignUp -> createAccount(editSignUpUsername.text.toString(), editSignUpPassword.text.toString())
            R.id.textLogin -> onBackPressed()
        }
    }

    private fun createAccount(username: String, password: String) {
        if(!validate()) {
            return
        }

        val User = hashMapOf(
            "username" to username,
            "password" to password
        )

        db.collection("user").document("${username}")
            .get()
            .addOnSuccessListener { result ->
                if (result.getField<String>("username") != null) {
                    editSignUpUsername.error = "username already used"
                } else {
                    editSignUpUsername.error = null

                    db.collection("user").document("${username}")
                        .set(User)
                        .addOnSuccessListener {
                            d("bomoh", "register success")
                            Toast.makeText(applicationContext, "Registered", Toast.LENGTH_SHORT).show()
                            onBackPressed()
                        }
                        .addOnFailureListener { e ->
                            d("bomoh", "error occur", e)
                        }
                }
            }
    }

    private fun validate(): Boolean {
        var valid = true

        val username = editSignUpUsername.text.toString()
        if (username.isEmpty()) {
            editSignUpUsername.error = "Required"
            valid = false
        } else {
            editSignUpUsername.error = null
        }

        val password = editSignUpPassword.text.toString()
        if (password.isEmpty()) {
            editSignUpPassword.error = "Required"
            valid = false
        } else {
            editSignUpPassword.error = null
        }

        return valid

    }
}