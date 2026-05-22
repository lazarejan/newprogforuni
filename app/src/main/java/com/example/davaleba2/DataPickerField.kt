package com.example.davaleba2

import android.app.DatePickerDialog
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.util.Calendar

@Composable
fun DatePickerField(
    dateState: String,
    onDateSelected: (String) -> Unit
) {
    val context = LocalContext.current

    OutlinedTextField(
        value = dateState,
        onValueChange = { },
        label = { Text("აირჩიეთ თარიღი") },
        enabled = false,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            disabledTextColor = Color.Black,
            disabledBorderColor = Color.Gray,
            disabledLabelColor = Color.Black
        ),
        trailingIcon = {
            Button(
                onClick = {
                    val calendar = Calendar.getInstance()
                    DatePickerDialog(
                        context,
                        { _, year, month, dayOfMonth ->
                            val formattedDay = dayOfMonth.toString().padStart(2, '0')
                            val formattedMonth = (month + 1).toString().padStart(2, '0')
                            onDateSelected("$formattedDay/$formattedMonth/$year")
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                    ).show()
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF34495E)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Text("არჩევა")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DatePickerFieldPreview() {
    MaterialTheme {
        DatePickerField(dateState = "12/05/2026", onDateSelected = {})
    }
}