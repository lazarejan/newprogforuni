package com.example.davaleba2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFF4F6F9)
                ) {
                    StudentFormScreen()
                }
            }
        }
    }
}

@Composable
fun StudentFormScreen() {
    val context = LocalContext.current

    // State ცვლადების შენახვა მთავარ ეკრანზე
    var nameState by remember { mutableStateOf("") }
    var surnameState by remember { mutableStateOf("") }
    var emailState by remember { mutableStateOf("") }
    var dateState by remember { mutableStateOf("") }
    var selectedOption by remember { mutableStateOf("") }
    var isAgreed by remember { mutableStateOf(false) }

    val directionOptions = listOf("Android", "iOS", "Web")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 1. Header კომპონენტი
        FormHeader()
        Spacer(modifier = Modifier.height(24.dp))

        // 2. Input კომპონენტები
        CustomTextField(
            value = nameState,
            onValueChange = { nameState = it },
            label = "სახელი"
        )
        CustomTextField(
            value = surnameState,
            onValueChange = { surnameState = it },
            label = "გვარი"
        )

        // 3. Date Picker კომპონენტი
        DatePickerField(
            dateState = dateState,
            onDateSelected = { dateState = it }
        )

        CustomTextField(
            value = emailState,
            onValueChange = { emailState = it },
            label = "ელ. ფოსტა (Email)"
        )
        Spacer(modifier = Modifier.height(16.dp))

        // 4. Radio Group კომპონენტი
        DirectionRadioGroup(
            options = directionOptions,
            selectedOption = selectedOption,
            onOptionSelected = { selectedOption = it }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // 5. Switch კომპონენტი
        AgreementSwitch(
            isAgreed = isAgreed,
            onCheckedChange = { isAgreed = it }
        )
        Spacer(modifier = Modifier.height(32.dp))

        // Submit Button (უშუალოდ მთავარ ეკრანზე, რადგან ყველა ველის ვალიდაცია სჭირდება)
        Button(
            onClick = {
                val isFieldsFilled = nameState.isNotBlank() &&
                        surnameState.isNotBlank() &&
                        emailState.isNotBlank() &&
                        dateState.isNotBlank()
                val isOptionSelected = selectedOption.isNotBlank()

                if (!isFieldsFilled || !isOptionSelected || !isAgreed) {
                    Toast.makeText(context, "შეავსეთ ყველა ველი!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "მონაცემები გაიგზავნა!", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2980B9))
        ) {
            Text(text = "Submit", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun StudentFormScreenPreview() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFF4F6F9)
        ) {
            StudentFormScreen()
        }
    }
}