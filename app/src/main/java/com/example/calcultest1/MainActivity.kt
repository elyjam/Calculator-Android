package com.example.calcultest1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Déplacez le CountDownTimer ici
        object : CountDownTimer(3000L, 100L) {
            override fun onTick(millisUntilFinished: Long) {
                // Code exécuté à chaque tick (100 ms dans ce cas)
            }

            override fun onFinish() {
                // Code exécuté quand le compteur est terminé
                val intent = Intent(this@MainActivity, MainActivity2::class.java)
                startActivity(intent)
            }
        }.start()
    }
}
