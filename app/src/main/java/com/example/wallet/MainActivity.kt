package com.example.wallet

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.wallet.R
import com.example.wallet.ui.commands.FileCommandsManager
import com.example.wallet.ui.commands.ReadCommand
import com.example.wallet.ui.commands.SaveCommand

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)

        val commandsManager = FileCommandsManager()
        val saveCommand = SaveCommand()
        commandsManager.putCommand("SaveCommand", saveCommand)
        commandsManager.putCommand("ReadCommand", ReadCommand())

        commandsManager
            .getCommand("SaveCommand")
            .execute(this, "exampleFile", "HolaMundo", "My Wallet")

        commandsManager
            .getCommand("ReadCommand")
            .execute(this, "exampleFile")
    }
}
