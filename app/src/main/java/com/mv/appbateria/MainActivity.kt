package com.mv.appbateria

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mv.appbateria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var batteryReceiver: BateryMonitor
    private lateinit var binding: ActivityMainBinding
    lateinit var texto: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        batteryReceiver = BateryMonitor { batteryLevel ->
            // Actualizar el TextView inmediatamente cuando se recibe el nivel de la batería
            texto.text = "$batteryLevel%"
        }

        val view: View
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);

        // Asigna el TextView para actualizar el valor
        texto = binding.txtInfo1
    }

    override fun onResume() {
        super.onResume()
        // Crear filtro de intención para el estado de la batería
        val intentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        // Registrar el receptor con el filtro
        registerReceiver(batteryReceiver, intentFilter)
        Log.d("Aplicación","BroadcastReceiver registrado satisfactoriamente")
        //texto.text = batteryReceiver.getValue().toString()
    }

    override fun onPause() {
        super.onPause()
        // Desregistrar el receptor
        unregisterReceiver(batteryReceiver)
        Log.d("Aplicación","BroadcastReceiver desregistrado satisfactoriamente")
    }
}