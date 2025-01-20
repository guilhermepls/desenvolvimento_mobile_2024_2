package com.example.apppost2.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.apppost2.data.models.Post

@Composable
fun PostItem(post: Post, onDelete: (Int) -> Unit, onEdit: (Post) -> Unit) {
    var showDialog by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 8.dp),
        elevation = 2.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Text(
                text = post.title,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            Text(
                text = post.content,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Row(modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = { showDialog = true },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colors.error
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 4.dp)
                ) {
                    Text(text = "Deletar")
                }
                
                Button(
                    onClick = { onEdit(post) },
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 4.dp)
                ) {
                    Text(text = "Editar")
                }
            }
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { 
                Text(
                    text = "Confirmar Exclusão",
                    style = MaterialTheme.typography.h6
                )
            },
            text = { 
                Text(
                    text = "Tem certeza que deseja deletar este post?",
                    style = MaterialTheme.typography.body1
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        onDelete(post.id)
                        showDialog = false
                    }
                ) {
                    Text(text = "Sim")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showDialog = false }
                ) {
                    Text(text = "Cancelar")
                }
            }
        )
    }
}