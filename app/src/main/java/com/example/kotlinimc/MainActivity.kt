package com.example.kotlinimc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var etpeso: EditText
    private lateinit var etaltura: EditText
    private lateinit var tvresul: TextView





    private lateinit var btcalc: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            var systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etpeso = findViewById(R.id.etpeso)
        etaltura = findViewById(R.id.etaltura)
        tvresul = findViewById(R.id.tvresul)






        btcalc = findViewById(R.id.btcalc)

        btcalc.setOnClickListener {
            var sPeso = etpeso.text.toString()
            var sTeste = etaltura.text.toString()


            if (sPeso.isEmpty() || sTeste.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var peso = sPeso.toDouble()
            var teste = sTeste.toDouble()



            var resul = ((peso * peso) / teste)

            tvresul.text = String.format("%.1f", resul)

        }
    }
}
