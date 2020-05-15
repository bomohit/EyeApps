package com.example.eyeapps

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // get the previous value
        var total = intent.getStringExtra("total").toFloat()

        val marks = (2.09*total).toInt()

        if(total <= 10) {
            textCondition.text = "Normal"
        } else if (total <=18) {
            textCondition.text = "Mild"
        } else if (total <=45) {
            textCondition.text = "Moderate"
        } else {
            textCondition.text = "Severe"
        }

        textScore.text = marks.toString()

        button4Redo.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }

        button4Exit.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }

    }
}