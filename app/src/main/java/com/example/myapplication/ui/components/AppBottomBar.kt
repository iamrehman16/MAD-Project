package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.myapplication.ui.navigation.Screen

@Composable
fun AppBottomBar(
    navController: NavHostController
) {
    // Define your bottom bar items in order
    val items = listOf(
        Screen.Groups,
        Screen.Notifications,
        Screen.CreateGroup,
        Screen.Ledger,
        Screen.Profile
    )

    // Observe current route to highlight selected item
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(tonalElevation = 8.dp) {
        items.forEachIndexed { index, screen ->
            val isSelected = currentRoute == screen.route

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    // Navigate to the screen if not already selected
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    when (index) {
                        2 -> { // Center Add button bigger
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.size(48.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.AddCircle,
                                    contentDescription = "Create",
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(64.dp)
                                )
                            }
                        }
                        else -> { // Other icons
                            Icon(
                                imageVector = when (index) {
                                    0 -> Icons.Filled.AccountBox
                                    1 -> Icons.Filled.Notifications
                                    3 -> Icons.Filled.Face
                                    4 -> Icons.Filled.Person
                                    else -> Icons.Filled.Build
                                },
                                contentDescription = screen.route
                            )
                        }
                    }
                }
            )
        }
    }
}
