package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction


@Composable
fun TransactionCard(
    transaction: Transaction,
){
    val borderColor = if(transaction.czyPrzychod){Color.Green} else{Color.Red} // Zmiana w zaleznosci Panie Piotrze
    Column(Modifier
        .border(2.dp, borderColor)
        .padding(10.dp)
        ){
        Text("${transaction.nazwa} : ${transaction.kwota}")
    }
}

@Preview(
    showBackground = true
)
@Composable
fun TransactionCardPreview(){
    val tran1 = Transaction(1, "Japko", 20.0, true)
    MaterialTheme{
        TransactionCard(tran1)
    }
}