package com.example.wokolskidashboard.ui.components

import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.unit.dp

@Composable
fun WokulskiTextField(
    text:String,
    onTextValueChange: (String) -> Unit
    ){
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextField(value = "adsad", onValueChange = onTextValueChange, modifier = Modifier.padding(4.dp))
    }
}

@Composable
fun WokulskiButton(
    text:String,
    Clicked: () -> Unit
){
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        androidx.compose.material3.Button(onClick = Clicked, modifier = Modifier) {
            Text(text)
        }
    }
}