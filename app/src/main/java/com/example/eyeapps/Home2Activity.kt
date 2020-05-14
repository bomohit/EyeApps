package com.example.eyeapps

import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_home2.*

class Home2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home2)
        // get the previous value
        var total = intent.getStringExtra("total").toInt()
        d("bomoh", "2nd : $total")

        button2Next.setOnClickListener {

            if(!validate()) {
                Toast.makeText(applicationContext, "Fail", Toast.LENGTH_SHORT).show()
            }

            // type 6
            if(radioButton26.isChecked) {
                total += 4;
            } else if(radioButton27.isChecked) {
                total += 3;
            } else if(radioButton28.isChecked) {
                total += 2;
            } else if(radioButton29.isChecked) {
                total += 1;
            } else if(radioButton30.isChecked) {
                total += 0;
            }

            // type 7
            if(radioButton31.isChecked) {
                total += 4;
            } else if(radioButton32.isChecked) {
                total += 3;
            } else if(radioButton33.isChecked) {
                total += 2;
            } else if(radioButton34.isChecked) {
                total += 1;
            } else if(radioButton35.isChecked) {
                total += 0;
            }

            // type 8
            if(radioButton36.isChecked) {
                total += 4;
            } else if(radioButton37.isChecked) {
                total += 3;
            } else if(radioButton38.isChecked) {
                total += 2;
            } else if(radioButton39.isChecked) {
                total += 1;
            } else if(radioButton40.isChecked) {
                total += 0;
            }

            // type 9
            if(radioButton41.isChecked) {
                total += 4;
            } else if(radioButton42.isChecked) {
                total += 3;
            } else if(radioButton43.isChecked) {
                total += 2;
            } else if(radioButton44.isChecked) {
                total += 1;
            } else if(radioButton45.isChecked) {
                total += 0;
            }



            d("bomoh", "total: $total")
            // pass data and open next page
            val intent = Intent(this,Home3Activity::class.java)
            intent.putExtra("total", total.toString())
            startActivity(intent)

        }



    }

    fun validate(): Boolean {
        var valid = true

        if(RadioType6.checkedRadioButtonId == -1) {
            valid = false
        }
        else if(RadioType7.checkedRadioButtonId == -1) {
            valid = false
        }
        else if(RadioType8.checkedRadioButtonId == -1) {
            valid = false
        }
        else if(RadioType8.checkedRadioButtonId == -1) {
            valid = false
        }
        else if(RadioType9.checkedRadioButtonId == -1) {
            valid = false
        }

        return valid
    }
}