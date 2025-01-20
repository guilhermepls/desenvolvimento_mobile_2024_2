import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.AlertDialog
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import android.widget.Toast
import com.example.apppost2.data.models.Post
import com.example.apppost2.ui.screens.PostItem
import com.example.viewmodel.PostViewModel

@Composable
fun PostScreen(viewModel: PostViewModel = viewModel()) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var editingPost by remember { mutableStateOf<Post?>(null) }
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        isLoading = true
        viewModel.fetchPosts()
        isLoading = false
    }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Titulo") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = content,
            onValueChange = { content = it },
            label = { Text("Conteúdo") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                isLoading = true
                viewModel.createPost(
                    title,
                    content,
                    onSuccess = {
                        Toast.makeText(context, "Post criado com sucesso!", Toast.LENGTH_SHORT).show()
                        isLoading = false
                    },
                    onError = {
                        Toast.makeText(context, "Erro ao criar o post!", Toast.LENGTH_SHORT).show()
                        isLoading = false
                    }
                )
                title = ""
                content = ""
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Criar Post")
        }
        Spacer(modifier = Modifier.height(16.dp))

        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        } else {
            LazyColumn {
                items(viewModel.post) { post ->
                    PostItem(
                        post = post,
                        onDelete = { viewModel.deletePost(it) },
                        onEdit = { editingPost = it }
                    )
                }
            }
        }
    }

    editingPost?.let { post ->
        AlertDialog(
            onDismissRequest = { editingPost = null },
            title = { Text("Editar Post") },
            text = {
                Column {
                    TextField(
                        value = post.title,
                        onValueChange = { newTitle -> editingPost = post.copy(title = newTitle) },
                        label = { Text("Título") }
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    TextField(
                        value = post.content,
                        onValueChange = { newContent -> editingPost = post.copy(content = newContent) },
                        label = { Text("Conteúdo") }
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        viewModel.updatePost(post.id, post.title, post.content)
                        editingPost = null
                    }
                ) {
                    Text("Salvar")
                }
            },
            dismissButton = {
                TextButton(onClick = { editingPost = null }) {
                    Text("Cancelar")
                }
            }
        )
    }
}