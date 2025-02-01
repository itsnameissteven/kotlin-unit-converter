package com.example.unitconversion

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.unitconversion.ui.theme.UnitConversionTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.toSize
import com.example.unitconversion.viewmodel.ConverterViewModel
import com.example.unitconversion.viewmodel.MeasurementUnit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConversionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize().border(2.dp, Color.Black)) {
        Header(
            modifier = modifier
        )
        MainContent()
    }
}

@Composable
fun Header(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxWidth()) {
        Text(
            text = "Unit Converter",
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun MainContent() {
    val converterViewModel = ConverterViewModel()
    var fromValue by remember { mutableStateOf("") }
    var toValue by remember { mutableStateOf("") }
    var toUnit by remember { mutableStateOf<MeasurementUnit?>(MeasurementUnit.Meters) }
    var fromUnit by remember { mutableStateOf<MeasurementUnit?>(MeasurementUnit.Kilometers) }

    fun updateFromValue(value: String) {
        fromValue = value
        if(value.toDoubleOrNull() == null) {
            return
        }
        if(value == "") {
            toValue = ""
        } else {
            converterViewModel.convert(value, fromUnit!!, toUnit!!)
            toValue = converterViewModel.convertedValue.value.toString()
        }
    }

    fun updateToValue(value: String) {
        toValue = value
        if(value.toDoubleOrNull() == null) {
            return
        }
        if(value == "") {
            fromValue = ""
        } else {
            converterViewModel.convert(value, toUnit!!, fromUnit!!)
            fromValue = converterViewModel.convertedValue.value.toString()
            Log.i("fromValue", fromValue)
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        UnitRow(
            "From",
            measurementValue = fromValue,
            options = converterViewModel.measurements,
            onChangeValue = {result -> updateFromValue(result)},
            selectedUnit = fromUnit,
            onChangeUnit = {result -> fromUnit = result}
        )
        UnitRow(
            "To",
            measurementValue = toValue,
            options = converterViewModel.measurements,
            onChangeValue = {result -> updateToValue(result)},
            selectedUnit = toUnit,
            onChangeUnit = {result -> toUnit = result}
        )
    }
}

@Composable
fun UnitRow(
    textLabel: String,
    measurementValue: String = "",
    onChangeValue: (String) -> Unit = {},
    onChangeUnit: (MeasurementUnit) -> Unit = {},
    selectedUnit: MeasurementUnit? = null,
    options: List<MeasurementUnit>
) {
    var isExpanded by remember { mutableStateOf(false) }
    var textFieldSize by remember { mutableStateOf(Size.Zero)}
    val icon = if (isExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween) {
        TextField(
            modifier = Modifier.weight(.6f).padding(start = 8.dp, end = 4.dp, top = 8.dp),
            value = measurementValue,
            onValueChange = {result -> onChangeValue(result)},
            label = { Text(text = textLabel) }
        )
        Box(Modifier.fillMaxWidth().weight(.4f).padding(start = 4.dp, end = 8.dp, bottom = 8.dp)) {
            OutlinedTextField(
                value = selectedUnit?.displayName ?: "",
                onValueChange = { },
                modifier = Modifier.onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                },
                label = {Text("Unit")},
                trailingIcon = { IconButton(onClick = { isExpanded = !isExpanded }) {
                    Icon(imageVector = icon, contentDescription = "Icon")
                }},
                readOnly = true
            )
            DropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false },
                modifier = Modifier.width(with(LocalDensity.current){textFieldSize.width.toDp()})
            ) {
                options.forEach { label ->
                    DropdownMenuItem(onClick = {
                        onChangeUnit(label)
                        isExpanded = false
                    },
                        text = { Text(text = label.displayName)}
                    )
                }
            }
        }

    }
}
