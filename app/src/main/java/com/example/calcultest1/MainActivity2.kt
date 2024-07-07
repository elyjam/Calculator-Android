package com.example.calcultest1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.mariuszgromada.math.mxparser.Expression

class MainActivity2 : AppCompatActivity() {
    private lateinit var reponse: TextView
    private lateinit var qst :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        reponse=findViewById(R.id.reponse)
        qst=findViewById(R.id.qst)
        val storage = getSharedPreferences("file", Context.MODE_PRIVATE)
        reponse.text=storage.getString("resultat","")
        qst.text=storage.getString("operation","")
    }

    fun C(view: View) {
         reponse.text=""
         qst.text=""
    }

    fun CE(view: View) {
        val s=qst.text.toString()
        qst.text=s.dropLast(1)
    }

    fun equal(view: View) {
        val T=qst.text.toString()
        reponse.text=Expression(T).calculate().toString()
        if (Expression(T).calculate().isNaN()){

            val vibreur = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
//vérifier l'existence du vibreur
            if (vibreur.hasVibrator()) {
// Effectuer une vibration d'une seconde
                vibreur.vibrate(500)
            }
        }
        val sharedPref = getSharedPreferences("file", Context.MODE_PRIVATE)
        val editeur=sharedPref.edit()
        editeur.putString("resultat",reponse.text.toString())
        editeur.putString("operation", qst.text.toString())
        editeur.apply()
    }

    fun ecrire(view: View) {
        val b=findViewById<Button>(view.id)
        qst.append(b.text.toString())
    }
}