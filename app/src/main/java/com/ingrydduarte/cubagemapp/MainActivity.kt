package com.ingrydduarte.cubagemapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.ingrydduarte.cubagemapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var buttonCalcular: Button
    private lateinit var labelTotal: TextView
    private lateinit var labelCubagem: TextView
    private lateinit var inputComp: EditText
    private lateinit var inputLarg: EditText
    private lateinit var inputAlt: EditText
    private var fatorCubagem: Int = 240
    private var resultadoPeso: Float = 0.2f
    private var resultadoCubagem: Float = 0.2f


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //referenciar o botão
        buttonCalcular = binding.btCalcular
        labelTotal = binding.textoTotal // referenciando o textView que contém o valor do peso cubado
        labelCubagem = binding.textoCubagem // referenciando o textView que contém o valor da cubagem
        //referenciar os inputs
        inputComp = binding.floatComp
        inputLarg = binding.floatLarg
        inputAlt = binding.floatAlt


        //evento do botão
        buttonCalcular.setOnClickListener {
            try {
                //caso deixe nulo
                if (inputComp.text.isNullOrEmpty() || inputLarg.text.isNullOrEmpty() || inputAlt.text.isNullOrEmpty()) {
                    throw NumberFormatException("Valores vazios")
                }

                // Obter valores dos EditText
                val comp = inputComp.text.toString().toFloat()
                val larg = inputLarg.text.toString().toFloat()
                val alt = inputAlt.text.toString().toFloat()

                resultadoPeso = comp * larg * alt * fatorCubagem
                resultadoCubagem = comp * larg * alt
                labelCubagem.text = getString(R.string.textCubagem, resultadoCubagem)
                labelTotal.text = getString(R.string.textTotal, resultadoPeso)
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor, insira valores válidos", Toast.LENGTH_SHORT).show()
            }

        }
    }
}