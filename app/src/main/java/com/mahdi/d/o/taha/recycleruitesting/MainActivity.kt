package com.mahdi.d.o.taha.recycleruitesting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_login.setOnClickListener {
            if (ed_email.text.toString().isNotEmpty() && ed_email.text.toString().isNotEmpty()) {
                startActivity(Intent(this, DataActivity::class.java))
            }else{
                Snackbar.make(LoginRoot,"Fill Fields",Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}