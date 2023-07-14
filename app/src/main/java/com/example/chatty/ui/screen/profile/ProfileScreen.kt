package com.example.chatty.ui.screen.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.chatty.R


@Composable
fun ProfileScreen(navController: NavController, viewModel: ProfileViewModel = ProfileViewModel()) {
    Column {
        Text(text = stringResource(id = R.string.app_name))
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    val navController = rememberNavController()
    ProfileScreen(navController)
}