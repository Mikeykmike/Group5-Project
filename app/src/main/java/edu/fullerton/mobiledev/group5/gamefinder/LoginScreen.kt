package edu.fullerton.mobiledev.group5.gamefinder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.widget.Toolbar


/**
 * A Login Form Example in Kotlin Android
 */
class LoginScreen : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login_screen)

        toolbar = findViewById(R.id.toolbar_login)
        setSupportActionBar(toolbar)

        // get reference to all views
        var username = findViewById<EditText>(R.id.et_user_name)
        var password = findViewById<EditText>(R.id.et_password)
        var loginButton = findViewById<Button>(R.id.login_button)

        // set on-click listener
        loginButton.setOnClickListener {
            val usernameEntered = username.text;
            val passwordEntered = password.text;
            Toast.makeText(this@LoginScreen, usernameEntered, Toast.LENGTH_LONG).show()

        }
    }
}