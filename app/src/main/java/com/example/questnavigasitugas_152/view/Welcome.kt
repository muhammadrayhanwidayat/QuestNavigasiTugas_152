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

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Formulir Pendaftaran") })
        },
        bottomBar = {
            Button(
                onClick = { navController.navigate("welcome") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) { Text("Kembali ke Beranda") }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = nama,
                onValueChange = { nama = it },
                label = { Text("Nama") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))

            ExposedDropdownMenuBox(
                expanded = expandedJK,
                onExpandedChange = { expandedJK = !expandedJK }
            ) {
                OutlinedTextField(
                    value = jenisKelamin,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Jenis Kelamin") },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth(),
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedJK)
                    }
                )
                ExposedDropdownMenu(
                    expanded = expandedJK,
                    onDismissRequest = { expandedJK = false }
                ) {
                    jenisKelaminList.forEach { option ->
                        DropdownMenuItem(
                            text = { Text(option) },
                            onClick = {
                                jenisKelamin = option
                                expandedJK = false
                            }
                        )
                    }
                }
            }

            Spacer(Modifier.height(8.dp))

            ExposedDropdownMenuBox(
                expanded = expandedStatus,
                onExpandedChange = { expandedStatus = !expandedStatus }
            ) {
                OutlinedTextField(
                    value = status,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Status Pernikahan") },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth(),
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedStatus)
                    }
                )
                ExposedDropdownMenu(
                    expanded = expandedStatus,
                    onDismissRequest = { expandedStatus = false }
                ) {
                    statusList.forEach { option ->
                        DropdownMenuItem(
                            text = { Text(option) },
                            onClick = {
                                status = option
                                expandedStatus = false
                            }
                        )
                    }
                }
            }