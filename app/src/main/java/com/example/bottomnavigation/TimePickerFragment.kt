package com.example.bottomnavigation

import android.app.Dialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.util.*

class TimePickerFragment : DialogFragment(), OnTimeSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val hour = c[Calendar.HOUR_OF_DAY]
        val minute = c[Calendar.MINUTE]
        return TimePickerDialog(activity, this, hour, minute, DateFormat.is24HourFormat(activity))
    }

    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        val AM_PM = if (hourOfDay < 12) "AM" else "PM"
        Toast.makeText(activity, "Time-HH:MM $hourOfDay:$minute $AM_PM", Toast.LENGTH_SHORT).show()
    }
}