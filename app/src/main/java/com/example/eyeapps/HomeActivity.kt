package com.example.eyeapps

import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        button1Next.setOnClickListener {
            var total = 0;
            // check if all question answered before proceed to next
            if(!validate()) {
                Toast.makeText(applicationContext, "Fail", Toast.LENGTH_SHORT).show()
            }

            // type 1
            if(radioButton1.isChecked) {
                total += 4;
            } else if(radioButton2.isChecked) {
                total += 3;
            } else if(radioButton3.isChecked) {
                total += 2;
            } else if(radioButton4.isChecked) {
                total += 1;
            } else if(radioButton5.isChecked) {
                total += 0;
            }

            // type 2
            if(radioButton6.isChecked) {
                total += 4;
            } else if(radioButton7.isChecked) {
                total += 3;
            } else if(radioButton8.isChecked) {
                total += 2;
            } else if(radioButton9.isChecked) {
                total += 1;
            } else if(radioButton10.isChecked) {
                total += 0;
            }

            // type 3
            if(radioButton11.isChecked) {
                total += 4;
            } else if(radioButton12.isChecked) {
                total += 3;
            } else if(radioButton13.isChecked) {
                total += 2;
            } else if(radioButton14.isChecked) {
                total += 1;
            } else if(radioButton15.isChecked) {
                total += 0;
            }

            // type 4
            if(radioButton16.isChecked) {
                total += 4;
            } else if(radioButton17.isChecked) {
                total += 3;
            } else if(radioButton18.isChecked) {
                total += 2;
            } else if(radioButton19.isChecked) {
                total += 1;
            } else if(radioButton20.isChecked) {
                total += 0;
            }

            // type 5
            if(radioButton21.isChecked) {
                total += 4;
            } else if(radioButton22.isChecked) {
                total += 3;
            } else if(radioButton23.isChecked) {
                total += 2;
            } else if(radioButton24.isChecked) {
                total += 1;
            } else if(radioButton25.isChecked) {
                total += 0;
            }

            d("bomoh", "total: $total")
            // pass data and open next page
            val intent = Intent(this,Home2Activity::class.java)
            intent.putExtra("total", total.toString())
            startActivity(intent)


        }

    }

    fun validate(): Boolean {
        var valid = true

        if(RadioType1.checkedRadioButtonId == -1) {
            valid = false
        }
        else if(RadioType2.checkedRadioButtonId == -1) {
            valid = false
        }
        else if(RadioType3.checkedRadioButtonId == -1) {
            valid = false
        }
        else if(RadioType4.checkedRadioButtonId == -1) {
            valid = false
        }
        else if(RadioType5.checkedRadioButtonId == -1) {
            valid = false
        }

        return valid
    }
}