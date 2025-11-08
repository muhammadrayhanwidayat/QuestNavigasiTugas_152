package com.example.questnavigasitugas_152.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

data class PesertaData(
    val nama: String,
    val jenisKelamin: String,
    val status: String,
    val alamat: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Peserta(navController: NavController) {
    val daftarPeserta = listOf(
        PesertaData("Jokowidodo", "Laki-laki", "Belum Menikah", "Bantul"),
        PesertaData("Nanda agung", "Laki-laki", "Menikah", "Yogyakarta"),
        PesertaData("Kanade Yoisaki", "Perempuan", "Belum Menikah", "Sleman"),
        PesertaData("Kazuma", "Laki-laki", "Belum Menikah", "Bantul"),
        PesertaData("Naruto", "Laki-laki", "Menikah", "Kulon Progo"),
        PesertaData("Sitri Smart", "Perempuan", "Belum Menikah", "Gunung Kidul")
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Daftar Peserta", color = Color.White) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF1976D2)
                )
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = {
                    navController.navigate("welcome") {
                        popUpTo("list") { inclusive = true }
                    }
                }) {
                    Text("Beranda")
                }
                Button(onClick = { navController.navigate("form") }) {
                    Text("Tambah Peserta")
                }
            }
        }
    ) { padding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(padding)
                .padding(8.dp)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(daftarPeserta) { peserta ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp),
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD))
                ) {
                    Column(
                        modifier = Modifier
                            .padding(12.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(peserta.nama, style = MaterialTheme.typography.titleMedium, color = Color(0xFF0D47A1))
                        Spacer(Modifier.height(4.dp))
                        Text("Jenis Kelamin: ${peserta.jenisKelamin}")
                        Text("Status: ${peserta.status}")
                        Text("Alamat: ${peserta.alamat}")
                    }
                }
            }
        }
    }
}