package com.android.sharedpref

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var userInputEditText: EditText;
    lateinit var localRepo: RepoLocal
    lateinit var submitBtn: Button
    lateinit var toastBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        init()
    }

    private fun init() {
        localRepo = RepoLocal(context = applicationContext)
        setUi()
    }

    private fun setUi() {
        title = "Shared Pref Demo - Kotlin"
        userInputEditText = findViewById(R.id.user_input)
        submitBtn = findViewById(R.id.submit)
        toastBtn = findViewById(R.id.toast)
        submitBtn.setOnClickListener {
            localRepo.name = userInputEditText.text.toString()
            userInputEditText.text.clear()
            toast(getString(R.string.saved))
        }
        toastBtn.setOnClickListener {
            toast(localRepo.name)
        }
    }

    private fun toast(msg: String?) {
        msg?.let {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

}
