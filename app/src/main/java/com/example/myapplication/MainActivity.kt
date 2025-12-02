package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.components.*
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import com.example.myapplication.ui.model.Group
import com.example.myapplication.ui.model.LedgerEntry
import com.example.myapplication.ui.model.Member
import com.example.myapplication.ui.model.NotificationItem
import com.example.myapplication.ui.model.User
import com.example.myapplication.ui.screens.CreateGroupScreen
import com.example.myapplication.ui.screens.GroupScreen
import com.example.myapplication.ui.screens.LedgerScreen
import com.example.myapplication.ui.screens.NotificationScreen
import com.example.myapplication.ui.screens.ProfileScreen
import androidx.compose.runtime.*
import androidx.navigation.compose.*
import com.example.myapplication.ui.navigation.Screen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
               AppScreen()
            }
        }
    }
}




@Composable
fun AppScreen() {

    val navController = rememberNavController()

    val dummyGroups = listOf(
        Group("Family Trip", "Alice", "2025-11-01"),
        Group("Office Party", "Bob", "2025-10-25"),
        Group("Weekend Hike", "Charlie", "2025-11-15")
    )

    val dummyNotifications = listOf(
        NotificationItem("New Group Created", "Alice created 'Family Trip'", "2025-11-01"),
        NotificationItem("Group Updated", "Bob updated 'Office Party'", "2025-11-02"),
        NotificationItem("Reminder", "Charlie invited you to 'Weekend Hike'", "2025-11-05")
    )

    val dummyUser = User(
        name = "John Doe",
        email = "john.doe@example.com",
        memberSince = "2023-01-15"
    )

    val dummyLedger = listOf(
        LedgerEntry("Family Trip", "John", "You", 50.0, true),
        LedgerEntry("Office Party", "You", "Alice", 30.0, false),
        LedgerEntry("Weekend Hike", "Bob", "You", 20.0, true)
    )

    val dummyMembers = listOf(
        Member("Alice", "1"),
        Member("Bob", "2"),
        Member("Charlie", "3")
    )

    Scaffold(
        topBar = { AppTopBar() },
        bottomBar = { AppBottomBar(navController = navController) },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background)
        ) {
            NavHost(
                navController = navController,
                startDestination = Screen.Groups.route
            ) {
                composable(Screen.Groups.route) { GroupScreen(groups = dummyGroups) }
                composable(Screen.Notifications.route) { NotificationScreen(notifications = dummyNotifications) }
                composable(Screen.Ledger.route) { LedgerScreen(ledgerEntries = dummyLedger) }
                composable(Screen.Profile.route) { ProfileScreen(user = dummyUser) }
                composable(Screen.CreateGroup.route) { CreateGroupScreen(availableMembers = dummyMembers) }
            }
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 360,
    heightDp = 720
)
@Composable
fun AppScreenPreview() {
    MyApplicationTheme {
        AppScreen()
    }
}
