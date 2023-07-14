package com.example.chatty.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.chatty.R
import com.example.chatty.common.data.model.Conversation

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = HomeViewModel()) {
    Column {
        Text(text = stringResource(id = R.string.app_name))
        Divider()
        LazyColumn {
            items(viewModel.conversations) { conversation ->
                ConversationItem(conversation, navController)
            }
        }
    }
}

@Composable
fun ConversationItem(conversation: Conversation, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                navController.navigate("chat")
            }
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = conversation.name, fontWeight = FontWeight.Bold)
            Text(text = conversation.lastMessage)
        }
        Text(text = conversation.timestamp, textAlign = TextAlign.End)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController)
}