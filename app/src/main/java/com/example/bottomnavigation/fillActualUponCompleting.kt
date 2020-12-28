package com.example.bottomnavigation

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.android.synthetic.main.activity_fill_actual_upon_completing.*
import java.text.SimpleDateFormat
import java.util.*

class fillActualUponCompleting : AppCompatActivity() {

    private val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.US)
    private val timeFormat = SimpleDateFormat("hh:mm a", Locale.US)



/*
    var dialogTheme: Int? = null
 var fullscreenTheme: Int? = null
 var picker: MaterialDatePicker<*>? = null*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fill_actual_upon_completing)






    val now = Calendar.getInstance()
    btn_date.text = dateFormat.format(now.time)
    btn_time.text = timeFormat.format(now.time)

    btn_date.setOnClickListener {
        val datePicker = DatePickerDialog(
            this, DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(Calendar.YEAR, year)
                selectedDate.set(Calendar.MONTH, month)
                selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                btn_date.text = dateFormat.format(now.time)
            },
            now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH)
        )
        datePicker.show()
    }

    btn_time.setOnClickListener {
        val timePicker = TimePickerDialog(
            this, TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(Calendar.HOUR_OF_DAY, hourOfDay)
                selectedDate.set(Calendar.MINUTE, minute)
                btn_time.text = timeFormat.format(now.time)
            },
            now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), false
        )
        timePicker.show()
    }


}



/*  fun openDatePicker(view: View?) {
       val newFragment: DialogFragment = DatePickerFragment()
        newFragment.show(supportFragmentManager, "datePicker")
         }

    //simple time picker
  fun openTimePicker(view: View?) {
     val newFragment: DialogFragment = TimePickerFragment()
      newFragment.show(supportFragmentManager, "timePicker")
  }*/

}