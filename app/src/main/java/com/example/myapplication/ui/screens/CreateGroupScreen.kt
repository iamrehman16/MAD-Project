package com.example.myapplication.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.components.*
import com.example.myapplication.ui.model.GroupCreateData
import com.example.myapplication.ui.model.Member

@Composable
fun CreateGroupScreen(availableMembers: List<Member>) {
    var groupName by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var selectedMembers by remember { mutableStateOf(listOf<Member>()) }
    var totalAmount by remember { mutableStateOf(0.0) }
    var memberShares by remember { mutableStateOf(mapOf<String, Double>()) }

    // Automatically divide equally
    LaunchedEffect(selectedMembers, totalAmount) {
        if (selectedMembers.isNotEmpty()) {
            val share = totalAmount / selectedMembers.size
            memberShares = selectedMembers.associate { it.id to share }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        LabeledTextField("Group Name", groupName, onValueChange = { groupName = it })
        LabeledTextField("Description", description, onValueChange = { description = it })
        DatePickerField("Date", date = date, onDateChange = { date = it })
        LabeledTextField("Total Amount", totalAmount.toString(), onValueChange = {
            totalAmount = it.toDoubleOrNull() ?: 0.0
        })
        Spacer(modifier = Modifier.height(8.dp))

        MemberSelector(
            availableMembers = availableMembers,
            selectedMembers = selectedMembers,
            onMemberSelected = { member -> selectedMembers = selectedMembers + member }
        )

        Spacer(modifier = Modifier.height(8.dp))
        MemberShareEditor(
            members = selectedMembers,
            shares = memberShares,
            onShareChange = { memberId, newShare ->
                memberShares = memberShares.toMutableMap().also { it[memberId] = newShare }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* TODO: handle create group */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Create Group")
        }
    }
}
