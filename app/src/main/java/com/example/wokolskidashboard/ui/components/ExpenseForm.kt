package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ExpenseForm(
    expenseName: String,
    expenseValue: Double,
    isWasteful: Boolean,
    expenseNameChanged: (String) -> Unit,
    expenseValueChanged: (String) -> Unit,
    isWastefulValueChanged: (Boolean) -> Unit,
    WokulskiButtonClicked: () -> Unit
){
    Column(modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Wydatki")
        WokulskiTextField(expenseName, onTextValueChange = expenseNameChanged)
        Text(text = "Kwota")
        WokulskiTextField(expenseValue.toString(), onTextValueChange = expenseValueChanged)
        Row(modifier = Modifier.padding(top = 16.dp), verticalAlignment = Alignment.CenterVertically) {
            Text("Wydatek zbyteczny")
            Switch(modifier = Modifier.padding(10.dp),
                checked = isWasteful, onCheckedChange = isWastefulValueChanged)
        }
        Spacer(Modifier.height(10.dp))
        WokulskiButton("Dodaj wydatek", Clicked = WokulskiButtonClicked)
    }
}

@Preview(showBackground = true)
@Composable
fun ExpenseFormPreview(){
    MaterialTheme{
        ExpenseForm(
            expenseName = "",
            expenseValue = 0.0,
            isWasteful = false,
            expenseNameChanged = {},
            expenseValueChanged = {},
            isWastefulValueChanged = {},
            WokulskiButtonClicked = {}
        )
    }
}