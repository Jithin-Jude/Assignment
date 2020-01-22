package com.musicmuni.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_input.*

class InputActivity : AppCompatActivity() {

    var scoreOneText = ""
    var scoreTwoText = ""
    var scoreThreeText = ""
    var scoreFourText = ""
    var scoreFiveText = ""

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
        scoreOneText = scoreOne.text.toString()
        scoreTwoText = scoreTwo.text.toString()
        scoreThreeText = scoreThree.text.toString()
        scoreFourText = scoreFour.text.toString()
        scoreFiveText = scoreFive.text.toString()

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
        if(scoreOneText == "" || scoreTwoText == "" || scoreThreeText == ""
            || scoreFourText == "" || scoreFiveText == ""){
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
