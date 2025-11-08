package com.example.questnavigasitugas_152.view

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormulirScreen(navController: NavController) {
    var nama by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    var expandedJK by remember { mutableStateOf(false) }
    var expandedStatus by remember { mutableStateOf(false) }

    val jenisKelaminList = listOf("Laki-laki", "Perempuan")
    val statusList = listOf("Belum Menikah", "Menikah")

