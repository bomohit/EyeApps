package com.example.eyeapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.getField
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonLogin.setOnClickListener(this)
        textRegister.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val i = v.id

        when(i) {
            R.id.buttonLogin -> checkAccount(editLoginUsername.text.toString(), editLoginPassword.text.toString())
            R.id.textRegister -> startActivity(Intent(this, RegisterActivity::class.java))
        }

    }

    private fun checkAccount(username: String, password: String) {
        if (!validate()) {
            return
        }

        db.collection("user").document(username)
            .get()
            .addOnSuccessListener { result ->
                if (result.getField<String>("username") == null) {
                    Toast.makeText(applicationContext, "Invalid Account", Toast.LENGTH_SHORT).show()
                } else {

                    val pwd = result.getField<String>("password").toString()

                    if(pwd == password) {
                        Toast.makeText(applicationContext, "Welcome $username", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, HomeActivity::class.java))

                    } else {
                        Toast.makeText(applicationContext, "Invalid Account", Toast.LENGTH_SHORT).show()
                    }

                }
            }
    }

    private fun validate(): Boolean {
        var valid = true

        val username = editLoginUsername.text.toString()
        if(username.isEmpty()) {
            editLoginUsername.error = "Required"
            valid = false
        } else {
            editLoginUsername.error = null
        }

        val password = editLoginPassword.text.toString()
        if (password.isEmpty()) {
            editLoginPassword.error = "Required"
            valid = false
        } else {
            editLoginPassword.error = null
        }

        return valid
    }

}
