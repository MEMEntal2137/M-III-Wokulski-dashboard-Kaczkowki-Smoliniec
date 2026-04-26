package com.example.wokolskidashboard.ui

import android.R
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction
import com.example.wokolskidashboard.ui.components.BalanceHeader
import com.example.wokolskidashboard.ui.components.ExpenseForm
import com.example.wokolskidashboard.ui.components.IncomeForm
import com.example.wokolskidashboard.ui.components.TransactionCard

@Composable
fun MainScreen(modifier: Modifier = Modifier){
    var expenseName by remember { mutableStateOf("") }
    var expenseValue by remember { mutableDoubleStateOf(0.0) }
    var isWasteful by remember { mutableStateOf(false) }
    var nextExpenseId by remember { mutableIntStateOf(1)}
    var expenseList = remember { mutableStateListOf<Transaction>()}

    var incomeName by remember { mutableStateOf("") }
    var incomeValue by remember { mutableDoubleStateOf(0.0) }
    var nextIncomeId by remember { mutableIntStateOf(1) }
    var saldo by remember { mutableDoubleStateOf(0.0) }
    var expenseError by remember { mutableStateOf("") }


    Column(modifier = Modifier.background(Color.Gray).fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        BalanceHeader(saldo = saldo)
        Spacer(Modifier.height(20.dp))
        ExpenseForm(
            expenseName = expenseName,
            expenseValue = expenseValue,
            isWasteful = isWasteful,
            expenseNameChanged = {expenseName = it},
            expenseValueChanged = {expenseValue = it.toDoubleOrNull() ?: 0.0},
            isWastefulValueChanged = {isWasteful = it},
            WokulskiButtonClicked = {
                if (saldo>0 && expenseValue <= saldo) {
                    if (expenseName != "" && expenseValue > 0) {
                        val expense =
                            Transaction(nextExpenseId, expenseName, expenseValue, false, isWasteful)
                        expenseList.add(expense)
                        nextExpenseId++
                        saldo -= expense.kwota
                        expenseName = ""
                        expenseValue = 0.0
                        expenseError = "Zarejestrowano pomyślnie!"
                    }
                }else{
                    expenseError = "Brak wystarczających środków"
                }
            }
        )
        if (expenseError.isNotEmpty()) {
            Text(text = expenseError, color = Color.Red)
        }
        Spacer(Modifier.height(20.dp))
        IncomeForm(
            incomeName=incomeName,
            incomeValue=incomeValue,
            incomeNameChanged= {incomeName=it},
            incomeValueChanged = {incomeValue = it.toDoubleOrNull() ?: 0.0},
            wokulskiButtonClicked =  {
                if(incomeName!="" && incomeValue>0) {
                    val income = Transaction(nextIncomeId, incomeName, incomeValue, true)
                    expenseList.add(income)
                    nextIncomeId++
                    saldo += income.kwota
                    incomeName=""
                    incomeValue=0.0
                }
            })
        Spacer(Modifier.height(10.dp))
        LazyColumn(Modifier.padding(16.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            items(expenseList.size, itemContent = { index ->
                val expense = expenseList[index]
                TransactionCard(expense)
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview(){
    MainScreen()
}