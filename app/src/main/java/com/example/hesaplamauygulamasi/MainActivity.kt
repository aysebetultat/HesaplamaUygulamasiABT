package com.example.hesaplamauygulamasi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hesaplamauygulamasi.ui.theme.HesaplamaUygulamasiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HesaplamaUygulamasiTheme {
                Scaffold { innerPadding ->
                    MainContent(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    var vize by remember { mutableStateOf("") }
    var final by remember { mutableStateOf("") }
    var sonuc by remember { mutableStateOf("") }

    Column(modifier = modifier.padding(16.dp)) {
        TextField(
            value = vize,
            onValueChange = { vize = it },
            label = { Text("Vize Notu") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = final,
            onValueChange = { final = it },
            label = { Text("Final Notu") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            val vizeNotu = vize.toDoubleOrNull() ?: 0.0
            val finalNotu = final.toDoubleOrNull() ?: 0.0                                                      
            sonuc = (vizeNotu * 0.4 + finalNotu * 0.6).toString()
        }) {
            Text("Hesapla")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text("Sonuç: $sonuc")
    }
}
