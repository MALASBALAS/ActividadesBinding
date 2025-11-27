package xyz.balbe.actividades

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import xyz.balbe.actividades.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val boton: Button = findViewById(R.id.btnNavegar)

        boton.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                val msg = Toast.makeText(
                    this,
                    getText(R.string.msg_focus_boton),
                    Toast.LENGTH_LONG
                )
                msg.show()
            }
        }
    }

    fun hacerClick(v: View) {
        val nombre = findViewById<EditText>(R.id.nombre).text.toString()
        val edadTexto = findViewById<EditText>(R.id.editTextNumberDecimal2).text.toString()
        val localidad = findViewById<EditText>(R.id.localidad2).text.toString()

        if (nombre.isBlank() || edadTexto.isBlank() || localidad.isBlank()) {
            Toast.makeText(this, getString(R.string.rellenadatos), Toast.LENGTH_SHORT).show()
            return
        }

        val edad = edadTexto.toInt()

        // Navega a la segunda actividad enviando los datos
        val intent = Intent(this, SegundaActivity::class.java)
        intent.putExtra("id", nombre)
        intent.putExtra("edad", edad)
        intent.putExtra("localidad", localidad)

        val msg = "$nombre, $edad años, $localidad"
        val toast = Toast.makeText(this, msg, Toast.LENGTH_LONG)
        toast.show()

        startActivity(intent)
    }
}
