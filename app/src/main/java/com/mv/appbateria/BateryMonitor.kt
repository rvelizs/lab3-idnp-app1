package com.mv.appbateria

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.util.Log

class BateryMonitor : BroadcastReceiver() {
    var va: Int = 0
    override fun onReceive(p0: Context?, intent: Intent?) {
        val level = intent?.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) ?: -1
        Log.d("Batery Receiver", "nivel de batería: $level%")
        va = level

    }

    fun getValue(): Int {
        return va
    }

}