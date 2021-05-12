package com.example.ejerciciociclodevida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.ejerciciociclodevida.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    // Esto hay que crearlo siempre
    lateinit var binding: ActivityMainBinding
    var contador = 1

    var listaPersonas = mutableListOf(
        Persona("Carlos", 33, 0.0, 1.70),
        Persona("Pedrito", 23, 1.0, 1.60),
        Persona("Jaimito", 99, 2.0, 1.90),
        Persona("Juanito", 22, 3.0, 1.50),
        Persona("Rodolfo", 43, 4.0, 1.20),
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Forma 1 de obtener el text view
        val textView1 = findViewById<TextView>(R.id.tv_text)
        textView1.text = "Texto modificado usando findViewById"

        // Forma 2. Usar el Binding. Está es la mejor.
        // Requiere cambios es el Gradle. Crear el binding y modificar el setContentView
        /* Esto hay que ponerlo en Gradle, dentro de la sección android
        buildFeatures {
            viewBinding = true
        }
        */
        binding.tvText.text = "Texto Modificado usando el binding"
        Log.w("Carlos", "onCreate ${contador++}")

        mostrarListaPersonas()

    }

    override fun onStart() {
        super.onStart()
        Log.w("Carlos", "onStart ${contador++}")

    }

    override fun onResume() {
        super.onResume()
        Log.w("Carlos", "onResume ${contador++}")

    }

    override fun onRestart() {
        super.onRestart()
        Log.w("Carlos", "onRestart ${contador++}")

    }

    override fun onPause() {
        Log.w("Carlos", "onPause ${contador++}")
        super.onPause()
    }

    override fun onStop() {
        Log.w("Carlos", "onStop ${contador++}")
        super.onStop()
    }

    override fun onDestroy() {
        Log.w("Carlos", "onDestroy ${contador++}")
        super.onDestroy()
    }

    fun mostrarListaPersonas(){

        val opcion = Random.nextInt(0,4)
        when(opcion) {
            0 -> listaPersonas.sortBy { it.nombre }
            1 -> listaPersonas . sortBy { it.edad }
            2 -> listaPersonas . sortByDescending { it.nombre }
            3 -> listaPersonas . sortByDescending { it.altura }
            else -> Log.e("Carlos", "Se ha recibido una opción inesperada, opcion = $opcion")
        }
        binding.tvText.text = listaPersonas.toString()
    }

    data class Persona(var nombre : String, var edad : Int, var notaMedia : Double, var altura : Double) {
        override fun toString(): String {
            return "\nMi nombre es $nombre, mi edad es $edad, mi nota media es $notaMedia y mido $altura\n"
        }
    }

}