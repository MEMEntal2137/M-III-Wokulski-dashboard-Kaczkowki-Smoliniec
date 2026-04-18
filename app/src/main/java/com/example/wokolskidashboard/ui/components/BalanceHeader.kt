package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun BalanceHeader(
    saldo: Double
){
    Column(){
        Text("$saldo")
    }
}

@Preview(showBackground = true)
@Composable
fun BalanceHeaderPreview(){
    MaterialTheme{
        BalanceHeader(2.00)
    }
}