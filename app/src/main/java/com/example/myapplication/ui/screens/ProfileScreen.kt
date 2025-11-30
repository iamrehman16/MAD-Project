package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.components.ProfileCard
import com.example.myapplication.ui.components.ProfileOption
import com.example.myapplication.ui.model.User

@Composable
fun ProfileScreen(user: User) {
    val profileOptions = listOf(
        "Edit Profile",
        "Account Settings",
        "Notifications",
        "Privacy",
        "Logout"
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        // Header
        item {
            Text(
                text = "Profile",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
            )
        }

        // Profile Card
        item {
            ProfileCard(user = user)
        }

        // Profile Options stacked vertically
        items(profileOptions) { option ->
            ProfileOption(title = option)
        }
    }
}
