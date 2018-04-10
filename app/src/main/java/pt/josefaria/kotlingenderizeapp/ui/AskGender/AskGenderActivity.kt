package pt.josefaria.kotlingenderizeapp.ui.AskGender

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import pt.josefaria.kotlingenderizeapp.R
import pt.josefaria.kotlingenderizeapp.models.networkCalls.Model
import pt.josefaria.kotlingenderizeapp.models.networkCalls.NetworkUtils


//https://genderize.io/
class AskGenderActivity : AppCompatActivity(), AskGenderInterface {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val names=name_value.text.toString().split('\n')

            names.forEach {i ->  NetworkUtils.beginSearch(i,this)}

            }

    }

    override fun showSuccessMessage(model: Model) {
        Toast.makeText(this@AskGenderActivity, model.name + " is " + model.gender, Toast.LENGTH_SHORT).show()
        Log.d("answer",model.name + " is " + model.gender);
    }

    override fun showError(message: String?) {
        Toast.makeText(this@AskGenderActivity, message, Toast.LENGTH_SHORT).show()
    }


}