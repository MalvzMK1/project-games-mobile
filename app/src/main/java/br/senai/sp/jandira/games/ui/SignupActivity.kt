package br.senai.sp.jandira.games.ui

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.databinding.ActivitySignupBinding
import br.senai.sp.jandira.games.model.GamerLevels
import br.senai.sp.jandira.games.model.User
import br.senai.sp.jandira.games.repository.ConsoleRepository
import br.senai.sp.jandira.games.repository.UserRepository
import br.senai.sp.jandira.games.utils.getBitmapUri
import br.senai.sp.jandira.games.utils.getByteArrayFromBitmap

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var profileImg: Bitmap
    private val IMAGE_REQUEST_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sliderListen()

        binding.selectedImage.visibility = View.INVISIBLE

        binding.profileImageButton.setOnClickListener {
            pickImageFromGallery()
        }

    }

    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_signup, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val openMainActivity = Intent(this, MainActivity::class.java)

        if (item.itemId == R.id.menu_exit) {
            startActivity(openMainActivity)
            return true
        } else if (item.itemId == R.id.menu_save) {
            if(validateForm()) {
                UserRepository(this).save(getForm())
                startActivity(openMainActivity)
            }
            return false
        }

        return true
    }

    private fun getSpinnerValue(): String {
        return binding.favoriteConsoleSpinner.selectedItem.toString()
    }

    private fun sliderListen() {
        binding.sliderGamerLevel.addOnChangeListener { slider, value, fromUser ->
            binding.textviewGamerLevel.text = getSliderLevel(binding.sliderGamerLevel.value.toInt()).toString()
        }
    }

    private fun getSliderLevel(pos: Int): GamerLevels {
        if (pos <= 40) return GamerLevels.NOOB
        if (pos in 41..60) return GamerLevels.CASUAL
        if (pos in 61..81) return GamerLevels.ADVANCED
        return GamerLevels.COMPETITIVE
    }

    private fun validateForm(): Boolean {
        var validated = true

        val inputs = listOf(
            binding.editTextUserName,
            binding.editTextUserEmail,
            binding.editTextUserCity,
            binding.editTextUserBirthdate,
            binding.editTextUserPassword
        )

        inputs.forEach { editText ->  
            if (editText.text.isEmpty()) {
                editText.error = "Required field!"
                validated = false
            }
        }

        if (binding.genderRadiogroup.checkedRadioButtonId.toString().isEmpty()) {
            Toast.makeText(this, "Select one gender!", Toast.LENGTH_SHORT).show()
            return false
        }

        if (getSpinnerValue().isEmpty()) {
            Toast.makeText(this, "Select one console!", Toast.LENGTH_SHORT).show()
            return false
        }

        return validated
    }

    private fun getForm(): User {
        val (email, name, city, birthday, password) = listOf(
            binding.editTextUserEmail.text.toString(),
            binding.editTextUserName.text.toString(),
            binding.editTextUserCity.text.toString(),
            binding.editTextUserBirthdate.text.toString(),
            binding.editTextUserPassword.text.toString()
        )
        val level = getSliderLevel(binding.sliderGamerLevel.value.toInt())
        val console = ConsoleRepository(this).getConsoleByName(getSpinnerValue())
        val picture = getByteArrayFromBitmap(profileImg)

        val inputRadio = binding.genderRadiogroup.checkedRadioButtonId
        val gender = findViewById<RadioButton>(inputRadio).text.toString()[0]

        return User(
            profilePhoto = picture,
            name = name,
            email = email,
            password = password,
            birthDate = birthday,
            city = city,
            favoriteConsole = console,
            gamerLevel = level,
            gender = gender
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
            this.profileImg = getBitmapUri(data?.data, this)
            binding.selectedImage.visibility = View.VISIBLE
            binding.selectedImage.setImageBitmap(profileImg)
        }
    }
}
