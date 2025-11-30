package com.example.myapplication.ui.model

data class LedgerEntry(
    val groupName: String,
    val payer: String,
    val payee: String,
    val amount: Double,
    val isOwedByYou: Boolean // true = you owe them → show Pay, false = they owe you → show Remind
)
