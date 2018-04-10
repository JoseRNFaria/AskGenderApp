package pt.josefaria.kotlingenderizeapp.ui.Menu

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_menu.*
import pt.josefaria.kotlingenderizeapp.R
import pt.josefaria.kotlingenderizeapp.ui.AskGender.AskGenderView

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        ask_gender.setOnClickListener {
            val intent = Intent(this, AskGenderView::class.java)
            startActivity(intent)
        }

        saved_question.setOnClickListener {
            val intent = Intent(this, AskGenderView::class.java)
            startActivity(intent)
        }
    }

}
