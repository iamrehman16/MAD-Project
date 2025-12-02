package com.example.myapplication.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.model.Member


@Composable
fun MemberShareEditor(
    members: List<Member>,
    shares: Map<String, Double>,
    onShareChange: (String, Double) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text("Member Shares", style = MaterialTheme.typography.bodyMedium)
        members.forEach { member ->
            val share = shares[member.name] ?: 0.0
            Row(
                modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = member.name)
                TextField(
                    value = share.toString(),
                    onValueChange = { newValue ->
                        val doubleVal = newValue.toDoubleOrNull() ?: 0.0
                        onShareChange(member.id, doubleVal)
                    },
                    singleLine = true,
                    modifier = Modifier.width(80.dp)
                )
            }
        }
    }
}
