package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction


@Composable
fun BalanceHeader(
    saldo: Double
){
    Column(modifier = Modifier.border(1.dp, Color.Black).padding(2.dp)){
        Text("$saldo Rubli")
    }

}

@Preview(showBackground = true)
@Composable
fun BalanceHeaderPreview(){
    MaterialTheme{
        BalanceHeader(2.00)
    }
}