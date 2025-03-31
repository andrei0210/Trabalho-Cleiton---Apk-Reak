package com.example.calculadoraimc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // A função onCreate é chamada quando a activity (tela) é criada
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // Define o layout da activity

        // Referência aos elementos de UI
        val etPeso = findViewById<EditText>(R.id.etPeso)
        val etAltura = findViewById<EditText>(R.id.etAltura)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        // Ação que ocorre quando o botão é clicado
        btnCalcular.setOnClickListener {
            // Recupera os valores inseridos pelo usuário nos campos de peso e altura
            val peso = etPeso.text.toString().toDoubleOrNull()
            val altura = etAltura.text.toString().toDoubleOrNull()

            // Verifica se os valores são válidos (não nulos e maiores que 0)
            if (peso != null && altura != null && peso > 0 && altura > 0) {
                // Calcula o IMC
                val imc = peso / (altura * altura)
                var categoria = ""

                // Determina a categoria de acordo com o IMC calculado
                when {
                    imc < 18.5 -> categoria = "Abaixo do peso"
                    imc in 18.5..24.9 -> categoria = "Peso normal"
                    imc in 25.0..29.9 -> categoria = "Sobrepeso"
                    else -> categoria = "Obesidade"
                }

                // Exibe o resultado (IMC e categoria) na tela
                tvResultado.text = "IMC: %.2f\nCategoria: $categoria".format(imc)
            } else {
                // Exibe uma mensagem de erro caso algum valor seja inválido
                tvResultado.text = "Por favor, insira valores válidos."
            }
        }
    }
}
