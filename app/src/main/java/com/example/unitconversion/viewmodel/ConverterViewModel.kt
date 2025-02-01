package com.example.unitconversion.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.pow
import kotlin.math.round

sealed class MeasurementUnit(val displayName: String) {
    object Meters : MeasurementUnit("Meters")
    object Kilometers : MeasurementUnit("Kilometers")
    object Feet : MeasurementUnit("feet")
    object Inches : MeasurementUnit("Inches")
    object Miles : MeasurementUnit("Miles")
    object Yards : MeasurementUnit("Yards")
    object Centimeters : MeasurementUnit("Centimeters")
    object Millimeters : MeasurementUnit("Millimeters")
}

class ConverterViewModel: ViewModel() {
    private val _convertedValue = MutableLiveData<String>()

    val convertedValue: LiveData<String> get() = _convertedValue

    val measurements = listOf(
        MeasurementUnit.Meters,
        MeasurementUnit.Kilometers,
        MeasurementUnit.Feet,
        MeasurementUnit.Inches,
        MeasurementUnit.Miles,
        MeasurementUnit.Yards,
        MeasurementUnit.Centimeters,
        MeasurementUnit.Millimeters
    )

    private fun formatDecimals(value: Double): String {
        val factor = 10.0.pow(5)
        val rounded = round(value * factor) / factor
        val roundedString = rounded.toString()
        val decimals = if(roundedString.contains('.') && !roundedString.endsWith("0"))  {
            roundedString.split(".")[1].length
        } else {
            0
        }
        return String.format("%.${decimals}f", rounded)
    }


    private fun convertLength(value: Double, fromUnit: MeasurementUnit, toUnit: MeasurementUnit): String {
        // Convert to meters first to standardize value
        val meters = when (fromUnit) {
            MeasurementUnit.Meters -> value
            MeasurementUnit.Kilometers -> value * 1000
            MeasurementUnit.Feet -> value * 0.3048
            MeasurementUnit.Inches -> value * 0.0254
            MeasurementUnit.Miles -> value * 1609.344
            MeasurementUnit.Yards -> value * 0.9144
            MeasurementUnit.Centimeters -> value / 100
            MeasurementUnit.Millimeters -> value / 1000
        }
        // Convert the meters value to the desired unit
        val convertedValue = when (toUnit) {
            MeasurementUnit.Meters -> meters
            MeasurementUnit.Kilometers -> meters / 1000
            MeasurementUnit.Feet -> meters * 3.280839895
            MeasurementUnit.Inches -> meters * 39.3700787402
            MeasurementUnit.Miles -> meters * 0.000621371
            MeasurementUnit.Yards -> meters * 1.0936133
            MeasurementUnit.Centimeters -> meters * 100
            MeasurementUnit.Millimeters -> meters * 1000
        }

        return formatDecimals(convertedValue)
    }

    fun convert(value: String, fromUnit: MeasurementUnit, toUnit: MeasurementUnit) {
        val convertedValue = convertLength(value.toDouble(), fromUnit, toUnit)
        _convertedValue.value = convertedValue.toString()
    }

}
