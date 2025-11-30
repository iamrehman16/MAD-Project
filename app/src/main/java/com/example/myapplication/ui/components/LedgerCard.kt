package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.model.LedgerEntry

@Composable
fun LedgerCard(
    entry: LedgerEntry,
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = entry.groupName,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Payer: ${entry.payer}",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "Payee: ${entry.payee}",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "Amount: \$${entry.amount}",
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = onButtonClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = if (entry.isOwedByYou) "Pay" else "Remind")
            }
        }
    }
}
