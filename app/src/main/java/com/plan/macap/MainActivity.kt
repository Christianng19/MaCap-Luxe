package com.plan.macap

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.plan.macap.ui.theme.MacapTheme
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseReference

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        // Obtener una referencia a la base de datos
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")

        // Escribir un mensaje en la base de datos
        myRef.setValue("Hello, Firebase!")

        // Leer el mensaje desde la base de datos
        myRef.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val value = task.result?.value
                Log.d("FirebaseTest", "Value is: $value")
            } else {
                Log.e("FirebaseTest", "Error getting data", task.exception)
            }
        }
    }
}
