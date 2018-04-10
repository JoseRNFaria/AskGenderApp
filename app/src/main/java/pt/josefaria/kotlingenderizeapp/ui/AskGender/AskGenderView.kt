package pt.josefaria.kotlingenderizeapp.ui.AskGender

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import pt.josefaria.kotlingenderizeapp.R


//https://genderize.io/
class AskGenderView : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val model = ViewModelProviders.of(this).get(AskGenderModelView::class.java)

        button.setOnClickListener {
            model.askGender(name_value.text.toString())
        }

        model.answer.observeForever({ answer ->
            Toast.makeText(this, answer,Toast.LENGTH_SHORT).show()
        })

    }


}