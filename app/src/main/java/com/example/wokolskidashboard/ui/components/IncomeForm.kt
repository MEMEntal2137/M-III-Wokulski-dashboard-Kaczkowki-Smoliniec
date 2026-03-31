package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun IncomeForm(
    
){
    Column(){
        Text(
            text = "Income"
        )
        TextField(
            value="Jakis tekst",
            onValueChange = {},
            label = {Text(text = "Wprowadź nazwę przedmiotu:")},
            singleLine = true
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            modifier = Modifier.align ( Alignment.CenterHorizontally ),
            onClick = {}) {
            Text("Prześlij")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IncomeFormPreview(){
    IncomeForm()
}
