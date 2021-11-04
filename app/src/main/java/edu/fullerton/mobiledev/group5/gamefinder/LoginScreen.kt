package edu.fullerton.mobiledev.group5.gamefinder

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {
    lateinit var etEmail: EditText
    lateinit var  etPassword: EditText
    val MIN_PASSWORD_LENGTH = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login_screen)
        viewInitializations()
    }

    fun viewInitializations() {
        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)

        // To show back button in actionbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // Checking if the input in form is valid
    fun validateInput(): Boolean {
        if (etEmail.text.toString() == "") {
            etEmail.error = "Please Enter Email"
            return false
        }
        if (etPassword.text.toString() == "") {
            etPassword.error = "Please Enter Password"
            return false
        }

        // checking the proper email format
        if (!isEmailValid(etEmail.text.toString())) {
            etEmail.error = "Please Enter Valid Email"
            return false
        }

        // checking minimum password Length
        if (etPassword.text.length < MIN_PASSWORD_LENGTH) {
            etPassword.error = "Password Length must be more than " + MIN_PASSWORD_LENGTH + "characters"
            return false
        }
        return true
    }

    fun isEmailValid(email: String?): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    // Hook Click Event
    fun performSignUp(v: View) {
        if (validateInput()) {

            // Input is valid, here send data to your server
            val email = etEmail!!.text.toString()
            val password = etPassword!!.text.toString()
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()

        }
    }

    fun goToSignup(v: View) {
        val intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)
    }
}
/*import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import edu.fullerton.mobiledev.group5.gamefinder.databinding.FragmentGameBrowserBinding


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
        var loginButton = findViewById<Button>(R.id.gameBrowser)

        // set on-click listener
        loginButton?.setOnClickListener {
            val usernameEntered = username.text;
            val passwordEntered = password.text;
            Toast.makeText(this@LoginScreen, usernameEntered, Toast.LENGTH_LONG).show()
            Toast.makeText(this@LoginScreen, passwordEntered, Toast.LENGTH_LONG).show()
            Navigation.createNavigateOnClickListener(R.id.gameBrowser, null)

        }
    }
}*/