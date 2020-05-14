package com.example.eyeapps

import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home3.*

class Home3Activity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home3)

        // get the previous value
        var total = intent.getStringExtra("total").toInt()
        d("bomoh", "2nd : $total")

        button3Result.setOnClickListener {
            if(!validate()) {
                Toast.makeText(applicationContext, "Fail", Toast.LENGTH_SHORT).show()
            }

            // type 10
            if(radioButton46.isChecked) {
                total += 4;
            } else if(radioButton47.isChecked) {
                total += 3;
            } else if(radioButton48.isChecked) {
                total += 2;
            } else if(radioButton49.isChecked) {
                total += 1;
            } else if(radioButton50.isChecked) {
                total += 0;
            }

            // type 11
            if(radioButton51.isChecked) {
                total += 4;
            } else if(radioButton52.isChecked) {
                total += 3;
            } else if(radioButton53.isChecked) {
                total += 2;
            } else if(radioButton54.isChecked) {
                total += 1;
            } else if(radioButton55.isChecked) {
                total += 0;
            }

            // type 12
            if(radioButton56.isChecked) {
                total += 4;
            } else if(radioButton57.isChecked) {
                total += 3;
            } else if(radioButton58.isChecked) {
                total += 2;
            } else if(radioButton59.isChecked) {
                total += 1;
            } else if(radioButton60.isChecked) {
                total += 0;
            }


            d("bomoh", "total: $total")
            // pass data and open next page
            val intent = Intent(this,ResultActivity::class.java)
            intent.putExtra("total", total.toString())
            startActivity(intent)
        }

    }

    fun validate(): Boolean {
        var valid = true

        if(RadioType10.checkedRadioButtonId == -1) {
            valid = false
        }
        else if(RadioType11.checkedRadioButtonId == -1) {
            valid = false
        }
        else if(RadioType12.checkedRadioButtonId == -1) {
            valid = false
        }

        return valid
    }
}