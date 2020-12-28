package com.example.bottomnavigation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.Toast
import androidx.annotation.AttrRes
import androidx.core.util.Pair
import com.google.android.material.datepicker.MaterialDatePicker

class ReschedulePickUp : AppCompatActivity() {

    var dialogTheme: Int? = null
    var fullscreenTheme: Int? = null
    var picker: MaterialDatePicker<*>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reschedule_pick_up)

   supportActionBar?.setDisplayHomeAsUpEnabled(true)


    }

/*    private fun init() {
        supportActionBar?.let { tb ->
            tb.title = "Reschedule Pickup"
            tb.setHomeButtonEnabled(true)
            tb.setDisplayHomeAsUpEnabled(true)
        }

        fullscreenTheme = resolveOrThrow(this, R.attr.materialCalendarFullscreenTheme)
        dialogTheme = resolveOrThrow(this, R.attr.materialCalendarTheme)
    }
    fun openDialogDateRangePicker(view: View) {
        val builder: MaterialDatePicker.Builder<*> = setDateBuilder(isDatePicker = false)
        builder.setTheme(dialogTheme!!)
        picker = builder.build()
        picker?.show(supportFragmentManager, picker.toString())
       *//* addListener(picker!!)*//*
    }


    private fun setDateBuilder(isDatePicker: Boolean): MaterialDatePicker.Builder<*> {
        val inputMode = MaterialDatePicker.INPUT_MODE_CALENDAR
        //Date Picker
        if (isDatePicker) {
            val builder: MaterialDatePicker.Builder<Long> = MaterialDatePicker.Builder.datePicker()
            builder.setInputMode(inputMode)
            return builder
        } else { //Date Range Picker
            val builder: MaterialDatePicker.Builder<Pair<Long, Long>> = MaterialDatePicker.Builder.dateRangePicker()
            builder.setInputMode(inputMode)
            return builder
        }
    }*/

/*
    private fun addListener(picker: MaterialDatePicker<*>) {
        picker.addOnPositiveButtonClickListener {
            AppUtils.showToast(this, picker.headerText.toString(), Toast.LENGTH_SHORT)
        }
        picker.addOnNegativeButtonClickListener {
            AppUtils.showToast(this, picker.headerText.toString(), Toast.LENGTH_SHORT)
        }
        picker.addOnCancelListener {
            AppUtils.showToast(this, picker.headerText.toString(), Toast.LENGTH_SHORT)
        }
    }
*/

/*    private fun resolveOrThrow(context: Context, @AttrRes attributeResId: Int): Int {
        val typedValue = TypedValue()
        if (context.theme.resolveAttribute(attributeResId, typedValue, true)) {
            return typedValue.data
        }
        throw IllegalArgumentException(context.resources.getResourceName(attributeResId))
    }*/


}