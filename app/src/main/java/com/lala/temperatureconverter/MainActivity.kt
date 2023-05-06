package com.lala.temperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lala.temperatureconverter.databinding.ActivityMainBinding

class MainActivity:AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var res = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpListeners()
    }

    fun setUpListeners(){
        binding.btCalculate.setOnClickListener{
            if (binding.editTextNumber.text.isNotEmpty()) {
                val inputTemp = binding.editTextNumber.text.toString().toInt()
                val selectedRadioId = binding.radioGroup.checkedRadioButtonId

                // check which radio button is selected
                if (selectedRadioId == binding.cTofRadio.id) {
                    res = inputTemp * 9 / 5 + 32
                } else if (selectedRadioId == binding.fTocRadio.id) {
                    res = (inputTemp - 32) * 5 / 9
                }
                binding.tvResult.text = res.toString()
            } else {
                Toast.makeText(this, "EditText is Empty", Toast.LENGTH_LONG).show()
            }
        }
    }

}
