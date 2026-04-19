package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun IncomeForm(
    incomeName: String,
    incomeValue: Double,
    incomeNameChanged: (String) -> Unit,
    incomeValueChanged: (String) -> Unit,
    wokulskiButtonClicked: () -> Unit,
){
    Column(modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Dochody")
        WokulskiTextField(incomeName, onTextValueChange = incomeNameChanged)
        Text("Zysk")
        WokulskiTextField(incomeValue.toString(), onTextValueChange = incomeValueChanged)
        Spacer(Modifier.height(10.dp))
        WokulskiButton("Dodaj dochód", Clicked = wokulskiButtonClicked)
    }
    }

@Preview(showBackground = true)
@Composable
fun IncomeFormPreview(){
    MaterialTheme{
        IncomeForm(
            "Rękwaiczki Paryskie",
            12.0,
            {},
            {},
            {},
        )
    }
}
