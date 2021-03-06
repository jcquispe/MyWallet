package com.example.wallet.ui.commands

import android.content.Context

interface FileCommand {
    fun execute(context: Context, fileName: String, vararg arguments: String)
}