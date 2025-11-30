package com.example.myapplication.ui.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.model.Member


@Composable
fun MemberSelector(
    availableMembers: List<Member>,
    selectedMembers: List<Member>,
    onMemberSelected: (Member) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(text = "Add Members", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(4.dp))

        // Show currently selected members
        selectedMembers.forEach { member ->
            Text(text = member.name, modifier = Modifier.padding(vertical = 2.dp))
        }

        // Show available members to add
        availableMembers.filter { it !in selectedMembers }.forEach { member ->
            Text(
                text = member.name,
                modifier = Modifier
                    .padding(vertical = 2.dp)
                    .clickable { onMemberSelected(member) },
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
