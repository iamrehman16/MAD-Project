package com.example.myapplication.ui.navigation


sealed class Screen(val route: String) {
    object Groups : Screen("groups")
    object Notifications : Screen("notifications")
    object Ledger : Screen("ledger")
    object Profile : Screen("profile")
    object CreateGroup : Screen("create_group")
}
