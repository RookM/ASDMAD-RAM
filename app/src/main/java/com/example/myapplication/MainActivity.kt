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

        // initializing variables of list view with their ids.
        programmingLanguagesLV = findViewById(R.id.idLVProgrammingLanguages)
        searchView = findViewById(R.id.idSV)

        // initializing list and adding data to list
        programmingLanguagesList = ArrayList()
        programmingLanguagesList.add("C")
        programmingLanguagesList.add("C#")
        programmingLanguagesList.add("Java")
        programmingLanguagesList.add("Javascript")
        programmingLanguagesList.add("Python")
        programmingLanguagesList.add("Dart")
        programmingLanguagesList.add("Kotlin")
        programmingLanguagesList.add("Typescript")

        // initializing list adapter and setting layout
        // for each list view item and adding array list to it.
        listAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            programmingLanguagesList
        )

        // on below line setting list
        // adapter to our list view.
        programmingLanguagesLV.adapter = listAdapter

        // on below line we are adding on query
        // listener for our search view.
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // on below line we are checking
                // if query exist or not.
                if (programmingLanguagesList.contains(query)) {
                    // if query exist within list we
                    // are filtering our list adapter.
                    listAdapter.filter.filter(query)
                } else {
                    // if query is not present we are displaying
                    // a toast message as no  data found..
                    Toast.makeText(this@MainActivity, "No Language found..", Toast.LENGTH_LONG)
                        .show()
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // if query text is change in that case we
                // are filtering our adapter with
                // new text on below line.
                listAdapter.filter.filter(newText)
                return false
            }
        })
    }

    fun getUsernameVal(): String {
        return findViewById<EditText>(R.id.inputUsername).text.toString()
    }

    fun getSignedIn(): Boolean {
        Toast.makeText(this, signedInVal.toString(), Toast.LENGTH_SHORT).show()
        return signedInVal
    }
}