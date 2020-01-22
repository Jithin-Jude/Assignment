package com.musicmuni.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_input.*

class InputActivity : AppCompatActivity() {

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
        var scoreOneText = scoreOne.text.toString()
        var scoreTwoText = scoreTwo.text.toString()
        var scoreThreeText = scoreThree.text.toString()
        var scoreFourText = scoreFour.text.toString()
        var scoreFiveText = scoreFive.text.toString()

        val intent = Intent(this,ScoreActivity::class.java)
        intent.putExtra("score_one",scoreOneText)
        intent.putExtra("score_two",scoreTwoText)
        intent.putExtra("score_three",scoreThreeText)
        intent.putExtra("score_four",scoreFourText)
        intent.putExtra("score_five",scoreFiveText)
        startActivity(intent)
    }
}
