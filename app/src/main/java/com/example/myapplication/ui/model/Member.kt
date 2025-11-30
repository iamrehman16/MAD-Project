package com.example.myapplication.ui.model

data class Member(
    val name: String,
    val id: String
)

data class GroupCreateData(
    val groupName: String = "",
    val description: String = "",
    val date: String = "",
    val members: List<Member> = emptyList(),
    val totalAmount: Double = 0.0,
    val shares: Map<String, Double> = emptyMap() // memberId -> share
)
