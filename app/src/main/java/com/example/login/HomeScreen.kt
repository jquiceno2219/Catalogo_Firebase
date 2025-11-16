package com.example.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun HomeScreen(userEmail: String, onLogout: () -> Unit) {

    val products = remember {
        listOf(
            Product(
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQeIIwUNZqUzdbgQaN6VFbXmEjVI0AD8n98NFAKjK1Q76p0v29F16i6RUradhaH88cv2ZEUvZJ_YQDhUCiLnpxxMqZKWHdPCArM_PTMx8AB&s=10",
                name = "Producto 1",
                price = "$10.00",
                description = "Esta es una descripción corta del producto 1."
            ),
            Product(
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQeIIwUNZqUzdbgQaN6VFbXmEjVI0AD8n98NFAKjK1Q76p0v29F16i6RUradhaH88cv2ZEUvZJ_YQDhUCiLnpxxMqZKWHdPCArM_PTMx8AB&s=10",
                name = "Producto 2",
                price = "$20.00",
                description = "Esta es una descripción corta del producto 2."
            ),
            Product(
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQeIIwUNZqUzdbgQaN6VFbXmEjVI0AD8n98NFAKjK1Q76p0v29F16i6RUradhaH88cv2ZEUvZJ_YQDhUCiLnpxxMqZKWHdPCArM_PTMx8AB&s=10",
                name = "Producto 3",
                price = "$30.00",
                description = "Esta es una descripción corta del producto 3."
            )
        )
    }

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Bienvenido, $userEmail!",
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = onLogout) {
                    Text("Cerrar sesión")
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(products) { product ->
                ProductItem(product)
            }
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    var isExpanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberAsyncImagePainter(product.imageUrl),
                contentDescription = product.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = product.name,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = product.price,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Red,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = if (isExpanded) product.description else product.description.take(50) + "...",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.clickable { isExpanded = !isExpanded }
            )
        }
    }
}