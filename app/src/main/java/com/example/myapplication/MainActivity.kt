package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.databinding.ActivityMainBinding
import org.json.JSONObject
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding

    fun edit (view: View?) {

    }

    private final var filename = "nameFile"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     binding = ActivityMainBinding.inflate(layoutInflater)
     setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val usernameVal = findViewById<EditText>(R.id.inputUsername).text
        val passwordVal = findViewById<EditText>(R.id.inputPassword).text

        fun writeToFile(json: JSONObject) {
            val fileOutputStream: FileOutputStream = openFileOutput(filename, MODE_PRIVATE)
            val json = json
            fileOutputStream.write(json.toString().toByteArray())
            fileOutputStream.close()

            // print file location
            System.out.println("File location: "  + "/" + filename)
        }

        fun readJSONFromFile(): JSONObject {
            try {
                val fileInputStream = openFileInput(filename)
                val text = fileInputStream.bufferedReader().use { it.readText() }
                fileInputStream.close()
                return JSONObject(text)
            } catch (e: Exception) {
                return JSONObject()
            }
        }
        val clicked = findViewById<Button>(R.id.button)
        clicked.setOnClickListener {
            val jsonObject = JSONObject()

            jsonObject.put("Username", usernameVal)
            jsonObject.put("Password", passwordVal)
            writeToFile(jsonObject);
        }
    }
}