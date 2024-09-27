package com.mv.appbateria

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.util.Log

class BateryMonitor(private val onBatteryLevelChanged: (Int) -> Unit) : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val level = intent?.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) ?: -1
        Log.d("Batery Receiver", "Nivel de batería: $level%")
        onBatteryLevelChanged(level) // Actualiza la interfaz de usuario directamente
                                    // Llama al lambda para actualizar la interfaz
    }
}