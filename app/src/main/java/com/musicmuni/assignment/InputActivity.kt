package com.musicmuni.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_input.*

class InputActivity : AppCompatActivity() {

    var scoreOneText = "0"
    var scoreTwoText = "0"
    var scoreThreeText = "0"
    var scoreFourText = "0"
    var scoreFiveText = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager
            .LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_input)

        btnShowGraph.setOnClickListener {
            showGraph()
        }
    }

    fun showGraph(){
        scoreOneText = if ( scoreOne.text.toString() == "" ) "0" else scoreOne.text.toString()
        scoreTwoText = if ( scoreTwo.text.toString() == "" ) "0" else scoreTwo.text.toString()
        scoreThreeText = if ( scoreThree.text.toString() == "" ) "0" else scoreThree.text.toString()
        scoreFourText = if ( scoreFour.text.toString() == "" ) "0" else scoreFour.text.toString()
        scoreFiveText = if ( scoreFive.text.toString() == "" ) "0" else scoreFive.text.toString()

        if(validate()){
            val intent = Intent(this,ScoreActivity::class.java)
            intent.putExtra("score_one",scoreOneText)
            intent.putExtra("score_two",scoreTwoText)
            intent.putExtra("score_three",scoreThreeText)
            intent.putExtra("score_four",scoreFourText)
            intent.putExtra("score_five",scoreFiveText)
            startActivity(intent)
        }
    }

    fun validate():Boolean{
        if(scoreOneText == "0" && scoreTwoText == "0" && scoreThreeText == "0"
            && scoreFourText == "0" && scoreFiveText == "0"){
            Toast.makeText(this, "Empty Input.", Toast.LENGTH_SHORT).show()
            return false
        }else if(scoreOneText.toInt() > 100 || scoreTwoText.toInt() > 100
            || scoreThreeText.toInt() > 100 || scoreFourText.toInt() > 100
            || scoreFiveText.toInt() > 100 || scoreOneText.toInt() < 0 || scoreTwoText.toInt() < 0
            || scoreThreeText.toInt() < 0 || scoreFourText.toInt() < 0
            || scoreFiveText.toInt() < 0){
            Toast.makeText(this, "Score should be between 0 and 100.",
                Toast.LENGTH_SHORT).show()
            return false
        }else{
            return true
        }
    }
}
