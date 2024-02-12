package com.fatihakbulut.timepicker_datepicker

import android.app.TimePickerDialog
import android.content.DialogInterface
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihakbulut.timepicker_datepicker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.editTextSaat.setOnClickListener{

            val calendar  = Calendar.getInstance() // Bu değişken ile zaman bilgileri alınır.

            val saat = calendar.get(Calendar.HOUR_OF_DAY) // Saat(24 saatlik)
            val dakika = calendar.get(Calendar.MINUTE)  // Dakika

            val timePicker = TimePickerDialog(this@MainActivity,TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                binding.editTextSaat.setText("$hourOfDay : $minute")
            },saat,dakika,true)

            timePicker.setTitle("Saat seçiniz")
            timePicker.setButton(DialogInterface.BUTTON_POSITIVE,"Ayarla",timePicker)
            timePicker.setButton(DialogInterface.BUTTON_NEGATIVE, "İptal",timePicker)

            timePicker.show()
        }

        binding.editTextTarih.setOnClickListener{





        }
    }
}