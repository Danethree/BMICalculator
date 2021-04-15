package com.daniela.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import com.daniela.imccalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bt_calculate = binding.btnCalculate
        val message = binding.message

        bt_calculate.setOnClickListener()
        {
            val editWeight = binding.editWeight
            val editHeight = binding.editHeight




            if(editWeight.text.toString().isEmpty())
            {
                message.setText("Write your weight!!")
                editWeight.setError("Weight is a require field")
                editWeight.requestFocus()




            }
            else if(editHeight.text.toString().isEmpty())
            {
                message.setText("Write your height!!")
                editHeight.setError("Height is a require field")
                editHeight.requestFocus()
            }
            else
            {
                CalculateTheBMI(editWeight,editHeight)
            }
        }
    }
    private fun CalculateTheBMI(idWeight:EditText, idHeight:EditText)
    {
        val weight = Integer.parseInt(idWeight.text.toString())
        val height = java.lang.Float.parseFloat(idHeight.text.toString())
        var bmi = weight/(height*height)
        val result = binding.message

        val Message = when{
            bmi<=18.5 -> "Underweight"
            bmi<=24.9 -> "Normal Weight"
            bmi<=29.9 -> "Pre-obesity"
            bmi <=34.9 ->"Obesity class I"
            bmi <= 39.9 ->"Obesity class II"
            else->"Obesity class III"
        }
        bmi.toString()
        result.setText("IMC: ${bmi}\n ${Message}")

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)

        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.reset -> {
               val cleanEditWeight = binding.editWeight
                val cleanEditHeight = binding.editHeight
                val cleanMessage = binding.message
                cleanEditHeight.setText("")
                cleanEditWeight.setText("")
                cleanMessage.setText("")


            }
        }
        return super.onOptionsItemSelected(item)
    }
}