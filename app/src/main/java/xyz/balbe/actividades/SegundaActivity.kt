package xyz.balbe.actividades

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_segunda)

        val extras = intent.extras
        val nombre = extras?.getString("id")
        val edad = extras?.getInt("edad")
        val localidad = extras?.getString("localidad")

        findViewById<TextView>(R.id.nombre).text = nombre
        findViewById<TextView>(R.id.editTextNumberDecimal).text = edad.toString()
        findViewById<TextView>(R.id.localidad2).text = localidad


        val msg = "$nombre, $edad años, $localidad"
        val toast = Toast.makeText(this, msg, Toast.LENGTH_LONG)
        toast.show()

        val boton: Button = findViewById(R.id.btnNavegar)
        boton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
