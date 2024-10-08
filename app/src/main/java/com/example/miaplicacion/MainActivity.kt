package com.example.miaplicacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.* // Para Column, Row y Spacer
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.* // Para MaterialButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen()
        }
    }
}

@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Campo de correo electrónico
        Text(text = "Correo electrónico")
        Spacer(modifier = Modifier.height(8.dp))
        BasicTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(56.dp)
                .background(Color(0xFFECE4F4)),
            singleLine = true,
            decorationBox = { innerTextField ->
                Box(
                    Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    if (email.isEmpty()) {
                        Text(text = "Correo electrónico", color = Color.Gray)
                    }
                    innerTextField()
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de contraseña
        Text(text = "Contraseña")
        Spacer(modifier = Modifier.height(8.dp))
        BasicTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(56.dp)
                .background(Color(0xFFECE4F4)),
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true,
            decorationBox = { innerTextField ->
                Box(
                    Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    if (password.isEmpty()) {
                        Text(text = "Contraseña", color = Color.Gray)
                    }
                    innerTextField()
                }
            }
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Botón de Iniciar Sesión
        Button(
            onClick = { /* Lógica para iniciar sesión */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text(text = "Iniciar Sesión")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón de Registrarse
        TextButton(onClick = { /* Lógica para registrarse */ }) {
            Text(text = "Registrarse", color = Color(0xFF5E3AEE))
        }
    }
}
