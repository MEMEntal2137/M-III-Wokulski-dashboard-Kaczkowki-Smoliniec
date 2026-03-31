package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ExpenseForm(
    WokulskiTextFieldChanged: (String) -> Unit,
    WokulskiButtonClicked: () -> Unit
){
    Column(modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Wydatki")
        WokulskiTextField("Nowy wydatek", WokulskiTextFieldChanged)
        Text(text = "Kwota")
        WokulskiTextField() { }
    }
}

@Preview(showBackground = true)
@Composable
fun ExpenseFormPreview(){
    MaterialTheme{
        ExpenseForm(
            TODO(),
            TODO()
        )
    }
}