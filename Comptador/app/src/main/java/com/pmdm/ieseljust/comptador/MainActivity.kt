package com.pmdm.ieseljust.comptador

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var comptador=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referencia al TextView
        val textViewContador=findViewById<TextView>(R.id.textViewComptador)
        // Referencia al boto d'Open
        val btOpen=findViewById<Button>(R.id.btOpen)

        // Inicialitzem el TextView amb el comptador a 0
        textViewContador.text=comptador.toString() // Estem fent una assignacio directament o accedinta algun metode?

        // Referencia al botón
        val btAdd=findViewById<Button>(R.id.btAdd)

        // Asociaciamos una expresióin lambda como
        // respuesta (callback) al evento Clic sobre
        // el botón
        btAdd.setOnClickListener {
            comptador++
            textViewContador.text=comptador.toString()
        }

        /*btOpen.setOnClickListener{
            val intent = Intent(baseContext, MostraComptadorActivity::class.java)
            intent.putExtra("comptador", comptador)
            startActivity(intent)
        }*/

        btOpen.setOnClickListener {
            Intent(baseContext, MostraComptadorActivity::class.java).apply {
                putExtra("comptador", comptador)
                startActivity(this)
            }
        }

        val btSubtract=findViewById<Button>(R.id.btSubtract)
        btSubtract.setOnClickListener {
            comptador--
            textViewContador.text=comptador.toString()
        }

        val btReset=findViewById<Button>(R.id.btReset)
        btReset.setOnClickListener {
            comptador=0
            textViewContador.text=comptador.toString()
        }

    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Al mètode onStart") // TAG és una etiqueta prèviament definida
    }

    override fun onRestoreInstanceState(estat: Bundle) {
        super.onRestoreInstanceState(estat)
        // Codi per a guardar l'estat
        comptador=estat.getInt("CLAU")
        val textViewContador=findViewById<TextView>(R.id.textViewComptador)
        textViewContador.text=comptador.toString()
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Al mètode onResume") // TAG és una etiqueta prèviament definida
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Al mètode onPause") // TAG és una etiqueta prèviament definida
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Al mètode onStop") // TAG és una etiqueta prèviament definida
    }

    override fun onSaveInstanceState(estat: Bundle) {
        super.onSaveInstanceState(estat)
        // Codi per a guardar l'estat
        estat.putInt("CLAU", comptador)

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Al mètode onDestroy") // TAG és una etiqueta prèviament definida
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "Al mètode onRestart") // TAG és una etiqueta prèviament definida
    }


}