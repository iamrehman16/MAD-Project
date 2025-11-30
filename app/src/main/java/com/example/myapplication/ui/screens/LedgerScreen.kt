package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.components.LedgerCard
import com.example.myapplication.ui.model.LedgerEntry

@Composable
fun LedgerScreen(ledgerEntries: List<LedgerEntry>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        // Header
        item {
            Text(
                text = "Ledger",
                style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
            )
        }

        // Ledger cards
        items(ledgerEntries) { entry ->
            LedgerCard(entry = entry) {
                // TODO: handle pay/remind click
            }
        }
    }
}
