package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.SearchView
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
    // on below line we are
    // creating variables for listview
    lateinit var programmingLanguagesLV: ListView

    // creating array adapter for listview
    lateinit var listAdapter: ArrayAdapter<String>

    // creating array list for listview
    lateinit var programmingLanguagesList: ArrayList<String>;

    // creating variable for searchview
    lateinit var searchView: SearchView
private lateinit var binding: ActivityMainBinding

    fun edit (view: View?) {

    }

    private final var filename = "nameFile"
    var signedInVal = false
    var whoView = "None"

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
            signedInVal = true
        }

//        val clickedAlex = findViewById<Button>(R.id.alexButton)
//        clickedAlex.setOnClickListener {
//            whoView = "Alex"
//        }
//        val clickedMaire = findViewById<Button>(R.id.maireButton)
//        clickedMaire.setOnClickListener {
//            whoView = "Maire"
//        }
//        val clickedArav = findViewById<Button>(R.id.aravButton)
//        clickedArav.setOnClickListener {
//            whoView = "Arav"
//        }
//        val clickedRook = findViewById<Button>(R.id.rookButton)
//        clickedRook.setOnClickListener {
//            whoView = "Rook"
//        }
//        val clickedIsabella = findViewById<Button>(R.id.isabellaButton)
//        clickedIsabella.setOnClickListener {
//            whoView = "Isabella"
//        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
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
            signedInVal = true
        }
        val clickedAlex = findViewById<Button>(R.id.alexButton)
        clickedAlex.setOnClickListener {
            whoView = "Alex"
        }
        val clickedMaire = findViewById<Button>(R.id.maireButton)
        clickedMaire.setOnClickListener {
            whoView = "Maire"
        }
        val clickedArav = findViewById<Button>(R.id.aravButton)
        clickedArav.setOnClickListener {
            whoView = "Arav"
        }
        val clickedRook = findViewById<Button>(R.id.rookButton)
        clickedRook.setOnClickListener {
            whoView = "Rook"
        }
        val clickedIsabella = findViewById<Button>(R.id.isabellaButton)
        clickedIsabella.setOnClickListener {
            whoView = "Isabella"
        }







    }
    fun getUsernameVal(): String {
        return findViewById<EditText>(R.id.inputUsername).text.toString()
    }

    fun getSignedIn(): Boolean {
        Toast.makeText(this, signedInVal.toString(), Toast.LENGTH_SHORT).show()
        return signedInVal
    }

    fun getWho(): String {
        Toast.makeText(this, whoView, Toast.LENGTH_SHORT).show()
        return whoView
    }
}