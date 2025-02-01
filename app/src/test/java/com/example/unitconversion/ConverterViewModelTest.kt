package com.example.unitconversion

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.unitconversion.viewmodel.ConverterViewModel
import com.example.unitconversion.viewmodel.MeasurementUnit
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ConverterViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule() // Ensures LiveData updates instantly

    private lateinit var viewModel: ConverterViewModel

    @Before
    fun setUp() {
        viewModel = ConverterViewModel()
    }
    // Mile Conversion
    @Test
    fun metersToMeters() {
        viewModel.convert("1", MeasurementUnit.Meters, MeasurementUnit.Meters)
        assertEquals("1", viewModel.convertedValue.value)
    }

    @Test
    fun metersToKilometers() {
        viewModel.convert("1000", MeasurementUnit.Meters, MeasurementUnit.Kilometers)
        assertEquals("1", viewModel.convertedValue.value)
    }

    @Test
    fun metersToFeet() {
        viewModel.convert("1", MeasurementUnit.Meters, MeasurementUnit.Feet)
        assertEquals("3.28084", viewModel.convertedValue.value)
    }

    @Test
    fun metersToInches() {
        viewModel.convert("1", MeasurementUnit.Meters, MeasurementUnit.Inches)
        assertEquals("39.37008", viewModel.convertedValue.value)
    }

    @Test
    fun metersToMiles() {
        viewModel.convert("1", MeasurementUnit.Meters, MeasurementUnit.Miles)
        assertEquals("0.0006", viewModel.convertedValue.value)
    }

    @Test
    fun metersToYards() {
        viewModel.convert("1", MeasurementUnit.Meters, MeasurementUnit.Yards)
        assertEquals("1.09361", viewModel.convertedValue.value)
    }

    @Test
    fun metersToCentimeters() {
        viewModel.convert("1", MeasurementUnit.Meters, MeasurementUnit.Centimeters)
        assertEquals("100", viewModel.convertedValue.value)
    }
    @Test
    fun metersToMillimeters() {
        viewModel.convert("1", MeasurementUnit.Meters, MeasurementUnit.Millimeters)
        assertEquals("1000", viewModel.convertedValue.value)
    }
    // Kilometer Conversion
    @Test
    fun kilometersToMeters() {
        viewModel.convert("1", MeasurementUnit.Kilometers, MeasurementUnit.Meters)
        assertEquals("1000", viewModel.convertedValue.value)
    }
    @Test
    fun kilometersToKilometers() {
        viewModel.convert("1", MeasurementUnit.Kilometers, MeasurementUnit.Kilometers)
        assertEquals("1", viewModel.convertedValue.value)
    }
    @Test
    fun kilometersToFeet() {
        viewModel.convert("1", MeasurementUnit.Kilometers, MeasurementUnit.Feet)
        assertEquals("3280.8399", viewModel.convertedValue.value)
    }
    @Test
    fun kilometersToInches() {
        viewModel.convert("1", MeasurementUnit.Kilometers, MeasurementUnit.Inches)
        assertEquals("39370.07874", viewModel.convertedValue.value)
    }
    @Test
    fun kilometersToMiles() {
        viewModel.convert("1", MeasurementUnit.Kilometers, MeasurementUnit.Miles)
        assertEquals("0.62137", viewModel.convertedValue.value)
    }
    @Test
    fun kilometersToYards() {
        viewModel.convert("1", MeasurementUnit.Kilometers, MeasurementUnit.Yards)
        assertEquals("1093.6133", viewModel.convertedValue.value)
    }
    @Test
    fun kilometersToCentimeters() {
        viewModel.convert("1", MeasurementUnit.Kilometers, MeasurementUnit.Centimeters)
        assertEquals("100000", viewModel.convertedValue.value)
    }
    @Test
    fun kilometersToMillimeters() {
        viewModel.convert("1", MeasurementUnit.Kilometers, MeasurementUnit.Millimeters)
        assertEquals("1000000", viewModel.convertedValue.value)
    }
//    Feet Conversion
    @Test
    fun feetToMeters() {
        viewModel.convert("1", MeasurementUnit.Feet, MeasurementUnit.Meters)
        assertEquals("0.3048", viewModel.convertedValue.value)
    }
    @Test
    fun feetToKilometers() {
        viewModel.convert("1", MeasurementUnit.Feet, MeasurementUnit.Kilometers)
        assertEquals("0.0003", viewModel.convertedValue.value)
    }
    @Test
    fun feetToFeet() {
        viewModel.convert("1", MeasurementUnit.Feet, MeasurementUnit.Feet)
        assertEquals("1", viewModel.convertedValue.value)
    }
    @Test
    fun feetToInches() {
        viewModel.convert("1", MeasurementUnit.Feet, MeasurementUnit.Inches)
        assertEquals("12", viewModel.convertedValue.value)
    }

    @Test
    fun feetToMiles() {
        viewModel.convert("1000", MeasurementUnit.Feet, MeasurementUnit.Miles)
        assertEquals("0.18939", viewModel.convertedValue.value)
    }
    @Test
    fun feetToYards() {
        viewModel.convert("1", MeasurementUnit.Feet, MeasurementUnit.Yards)
        assertEquals("0.33333", viewModel.convertedValue.value)
    }
    @Test
    fun feetToCentimeters() {
        viewModel.convert("1", MeasurementUnit.Feet, MeasurementUnit.Centimeters)
        assertEquals("30.48", viewModel.convertedValue.value)
    }

    @Test
    fun feetToMillimeters() {
        viewModel.convert("1", MeasurementUnit.Feet, MeasurementUnit.Millimeters)
        assertEquals("304.8", viewModel.convertedValue.value)
    }
    // Inches conversion
    @Test
    fun inchesToMeters() {
        viewModel.convert("1", MeasurementUnit.Inches, MeasurementUnit.Meters)
        assertEquals("0.0254", viewModel.convertedValue.value)
    }
    @Test
    fun inchesToKilometers() {
        viewModel.convert("1000", MeasurementUnit.Inches, MeasurementUnit.Kilometers)
        assertEquals("0.0254", viewModel.convertedValue.value)
    }
    @Test
    fun inchesToFeet() {
        viewModel.convert("1", MeasurementUnit.Inches, MeasurementUnit.Feet)
        assertEquals("0.08333", viewModel.convertedValue.value)
    }
    @Test
    fun inchesToInches() {
        viewModel.convert("1", MeasurementUnit.Inches, MeasurementUnit.Inches)
        assertEquals("1", viewModel.convertedValue.value)
    }
    @Test
    fun inchesToMiles() {
        viewModel.convert("10000", MeasurementUnit.Inches, MeasurementUnit.Miles)
        assertEquals("0.15783", viewModel.convertedValue.value)
    }
    @Test
    fun inchesToYards() {
        viewModel.convert("1", MeasurementUnit.Inches, MeasurementUnit.Yards)
        assertEquals("0.02778", viewModel.convertedValue.value)
    }
    @Test
    fun inchesToCentimeters() {
        viewModel.convert("1", MeasurementUnit.Inches, MeasurementUnit.Centimeters)
        assertEquals("2.54", viewModel.convertedValue.value)
    }
    @Test
    fun inchesToMillimeters() {
        viewModel.convert("1", MeasurementUnit.Inches, MeasurementUnit.Millimeters)
        assertEquals("25.4", viewModel.convertedValue.value)
    }
    // Miles Test
    @Test
    fun milesToMeters() {
        viewModel.convert("1", MeasurementUnit.Miles, MeasurementUnit.Meters)
        assertEquals("1609.344", viewModel.convertedValue.value)
    }
    @Test
    fun milesToKilometers() {
        viewModel.convert("1", MeasurementUnit.Miles, MeasurementUnit.Kilometers)
        assertEquals("1.60934", viewModel.convertedValue.value)
    }
    @Test
    fun milesToFeet() {
        viewModel.convert("1", MeasurementUnit.Miles, MeasurementUnit.Feet)
        assertEquals("5280", viewModel.convertedValue.value)
    }
    @Test
    fun milesToInches() {
        viewModel.convert("1", MeasurementUnit.Miles, MeasurementUnit.Inches)
        assertEquals("63360", viewModel.convertedValue.value)
    }
    @Test
    fun milesToMiles() {
        viewModel.convert("1", MeasurementUnit.Miles, MeasurementUnit.Miles)
        assertEquals("1", viewModel.convertedValue.value)
    }
    @Test
    fun milesToYards() {
        viewModel.convert("1", MeasurementUnit.Miles, MeasurementUnit.Yards)
        assertEquals("1760", viewModel.convertedValue.value)
    }
    @Test
    fun milesToCentimeters() {
        viewModel.convert("1", MeasurementUnit.Miles, MeasurementUnit.Centimeters)
        assertEquals("160934.4", viewModel.convertedValue.value)
    }
    @Test
    fun milesToMillimeters() {
        viewModel.convert("1", MeasurementUnit.Miles, MeasurementUnit.Millimeters)
        assertEquals("1609344", viewModel.convertedValue.value)
    }
    // Yards tests
    @Test
    fun yardsToMeters() {
        viewModel.convert("1", MeasurementUnit.Yards, MeasurementUnit.Meters)
        assertEquals("0.9144", viewModel.convertedValue.value)
    }
    @Test
    fun yardsToKilometers() {
        viewModel.convert("1", MeasurementUnit.Yards, MeasurementUnit.Kilometers)
        assertEquals("0.0009", viewModel.convertedValue.value)
    }
    @Test
    fun yardsToFeet() {
        viewModel.convert("1", MeasurementUnit.Yards, MeasurementUnit.Feet)
        assertEquals("3", viewModel.convertedValue.value)
    }

    @Test
    fun yardsToInches() {
        viewModel.convert("1", MeasurementUnit.Yards, MeasurementUnit.Inches)
        assertEquals("36", viewModel.convertedValue.value)
    }
    @Test
    fun yardsToMiles() {
        viewModel.convert("1000", MeasurementUnit.Yards, MeasurementUnit.Miles)
        assertEquals("0.56818", viewModel.convertedValue.value)
    }
    @Test
    fun yardsToYards() {
        viewModel.convert("1", MeasurementUnit.Yards, MeasurementUnit.Yards)
        assertEquals("1", viewModel.convertedValue.value)
    }
    @Test
    fun yardsToCentimeters() {
        viewModel.convert("1", MeasurementUnit.Yards, MeasurementUnit.Centimeters)
        assertEquals("91.44", viewModel.convertedValue.value)
    }
    @Test
    fun yardsToMillimeters() {
        viewModel.convert("1", MeasurementUnit.Yards, MeasurementUnit.Millimeters)
        assertEquals("914.4", viewModel.convertedValue.value)
    }
    // Centimeters tests
    @Test
    fun centimetersToMeters() {
        viewModel.convert("1", MeasurementUnit.Centimeters, MeasurementUnit.Meters)
        assertEquals("0.01", viewModel.convertedValue.value)
    }

    @Test
    fun centimetersToKilometers() {
        viewModel.convert("100000", MeasurementUnit.Centimeters, MeasurementUnit.Kilometers)
        assertEquals("1", viewModel.convertedValue.value)
    }
    @Test
    fun centimetersToFeet() {
        viewModel.convert("1", MeasurementUnit.Centimeters, MeasurementUnit.Feet)
        assertEquals("0.03281", viewModel.convertedValue.value)
    }
    @Test
    fun centimetersToInches() {
        viewModel.convert("1", MeasurementUnit.Centimeters, MeasurementUnit.Inches)
        assertEquals("0.3937", viewModel.convertedValue.value)
    }
    @Test
    fun centimetersToMiles() {
        viewModel.convert("1000000", MeasurementUnit.Centimeters, MeasurementUnit.Miles)
        assertEquals("6.21371", viewModel.convertedValue.value)
    }
    @Test
    fun centimetersToYards() {
        viewModel.convert("1", MeasurementUnit.Centimeters, MeasurementUnit.Yards)
        assertEquals("0.01094", viewModel.convertedValue.value)
    }
    @Test
    fun centimetersToCentimeters() {
        viewModel.convert("1", MeasurementUnit.Centimeters, MeasurementUnit.Centimeters)
        assertEquals("1", viewModel.convertedValue.value)
    }
    @Test
    fun centimetersToMillimeters() {
        viewModel.convert("1", MeasurementUnit.Centimeters, MeasurementUnit.Millimeters)
        assertEquals("10", viewModel.convertedValue.value)
    }
    // Millimeters tests
    @Test
    fun millimetersToMeters() {
        viewModel.convert("1", MeasurementUnit.Millimeters, MeasurementUnit.Meters)
        assertEquals("0.001", viewModel.convertedValue.value)
    }
    @Test
    fun millimetersToKilometers() {
        viewModel.convert("1000000", MeasurementUnit.Millimeters, MeasurementUnit.Kilometers)
        assertEquals("1", viewModel.convertedValue.value)
    }
    @Test
    fun millimetersToFeet() {
        viewModel.convert("1", MeasurementUnit.Millimeters, MeasurementUnit.Feet)
        assertEquals("0.00328", viewModel.convertedValue.value)
    }
    @Test
    fun millimetersToInches() {
        viewModel.convert("1", MeasurementUnit.Millimeters, MeasurementUnit.Inches)
        assertEquals("0.03937", viewModel.convertedValue.value)
    }
    @Test
    fun millimetersToMiles() {
        viewModel.convert("1000000000", MeasurementUnit.Millimeters, MeasurementUnit.Miles)
        assertEquals("621.371", viewModel.convertedValue.value)
    }
    @Test
    fun millimetersToYards() {
        viewModel.convert("1", MeasurementUnit.Millimeters, MeasurementUnit.Yards)
        assertEquals("0.00109", viewModel.convertedValue.value)
    }

    @Test
    fun millimetersToCentimeters() {
        viewModel.convert("1", MeasurementUnit.Millimeters, MeasurementUnit.Centimeters)
        assertEquals("0.1", viewModel.convertedValue.value)
    }
    @Test
    fun millimetersToMillimeters() {
        viewModel.convert("1", MeasurementUnit.Millimeters, MeasurementUnit.Millimeters)
        assertEquals("1", viewModel.convertedValue.value)
    }

}
