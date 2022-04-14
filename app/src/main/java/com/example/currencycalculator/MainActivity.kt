package com.example.currencycalculator

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.currencycalculator.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Konversi.setOnClickListener{calculateTip()}
    }
    fun calculateTip(){
        val stringinTextField = binding.costOfServiceEditText.text.toString()
        val cost = stringinTextField.toDoubleOrNull()

        if (cost == null || cost == 0.0) {
            displayTip(0.0)
            return
        }

        val tipPercentage = when(binding.radioGroup.checkedRadioButtonId){
            R.id.euroid -> 15653.65
            R.id.usdolarid -> 14358.50
            R.id.javaneseyenid -> 114.57
            else -> 3827.74
        }

        var tip = tipPercentage * cost

        displayTip(tip)


    }


    private fun displayTip(tip: Double){
        val formattedTip = NumberFormat.getIntegerInstance().format(tip)
        binding.result.text = getString(R.string.tip_amount, formattedTip)
    }


}