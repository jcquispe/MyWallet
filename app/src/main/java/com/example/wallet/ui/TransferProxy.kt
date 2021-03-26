package com.example.wallet.ui

class TransferProxy {
    val MAX_TRANSFER_AMOUNT = 1000000
    val MIN_TRANSFER_AMOUNT = 100

    fun checkTransfer(amount: Double) =
        when {
            amount > MAX_TRANSFER_AMOUNT -> "La transacción excede $MAX_TRANSFER_AMOUNT Bs."
            amount < MIN_TRANSFER_AMOUNT -> "La transacción debe ser mayor a $MIN_TRANSFER_AMOUNT Bs."
            else -> {
                doTransfer(amount)
                "La transacción se realizó correctamente"
            }
        }

    private fun doTransfer(amount: Double) {
        //TODO realiza la transferencia
    }
}