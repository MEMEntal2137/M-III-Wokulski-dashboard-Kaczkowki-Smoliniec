package com.example.wokolskidashboard.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction
import com.example.wokolskidashboard.ui.components.BalanceHeader
import com.example.wokolskidashboard.ui.components.ExpenseForm
import com.example.wokolskidashboard.ui.components.TransactionCard

@Composable
fun MainScreen(modifier: Modifier = Modifier){
    var expenseName by remember { mutableStateOf("") }
    var expenseValue by remember { mutableDoubleStateOf(0.0) }
    var isWasteful by remember { mutableStateOf(false) }
    var nextExpenseId by remember { mutableIntStateOf(1)}
    var expenseList = remember { mutableStateListOf<Transaction>()}


    Column(modifier = Modifier, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        ExpenseForm(
            expenseName = expenseName,
            expenseValue = expenseValue,
            isWasteful = isWasteful,
            expenseNameChanged = {expenseName = it},
            expenseValueChanged = {expenseValue = it.toDouble()},
            isWastefulValueChanged = {isWasteful = it},
            {
                val expense = Transaction(nextExpenseId, expenseName, expenseValue, false, isWasteful)
                expenseList.add(expense)
                nextExpenseId++
            }
        )
        Spacer(Modifier.height(10.dp))
        LazyColumn() {
            items(expenseList.size, itemContent = { index ->
                val expense = expenseList[index]
                TransactionCard(expense)
            })
        }
    }
}