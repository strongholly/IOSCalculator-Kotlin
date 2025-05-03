package com.example.calculatorhomework

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.calculatorhomework.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var ekran: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Sayı butonları için ortak fonksiyon
              val numberClickListener = { number: String ->
            ekran += number
            binding.textPrintScreen.text = ekran
        }

          // Operatör butonları için ortak fonksiyon
             val operatorClickListener = { operator: String ->
            ekran += operator
            binding.textPrintScreen.text = ekran
        }

        // Butonlara tıklama işleyicilerini atama
        binding.button0.setOnClickListener { numberClickListener("0") }
          binding.button1.setOnClickListener { numberClickListener("1") }
         binding.button2.setOnClickListener { numberClickListener("2") }
         binding.button3.setOnClickListener { numberClickListener("3") }
         binding.button4.setOnClickListener { numberClickListener("4") }
        binding.button5.setOnClickListener { numberClickListener("5") }
        binding.button6.setOnClickListener { numberClickListener("6") }
        binding.button7.setOnClickListener { numberClickListener("7") }
        binding.button8.setOnClickListener { numberClickListener("8") }
        binding.button9.setOnClickListener { numberClickListener("9") }

        binding.buttonplus.setOnClickListener { operatorClickListener("+") }
        binding.buttonminus.setOnClickListener { operatorClickListener("-") }
        binding.buttondivide.setOnClickListener { operatorClickListener("/") }
        binding.buttontimes.setOnClickListener { operatorClickListener("*") }
        binding.buttonComma.setOnClickListener { operatorClickListener(".") }

        // AC butonuna tıklama işlemi
        binding.buttonAC.setOnClickListener {
            ekran = ""
            binding.textPrintScreen.text = ekran
        }

        // Eşittir (=) butonuna tıklama işlemi
        binding.buttonequal.setOnClickListener {
            try {
                val expression = ExpressionBuilder(ekran).build()
                val result = expression.evaluate()
                binding.textPrintScreen.text = result.toString()
                ekran = result.toString()
            } catch (e: Exception) {
                binding.textPrintScreen.text = "Hata!"
            }
        }
    }
}
