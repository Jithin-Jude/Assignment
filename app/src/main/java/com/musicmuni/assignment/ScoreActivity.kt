package com.musicmuni.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_score.*

class ScoreActivity : AppCompatActivity() {

    var scoreOne = 0
    var scoreTwo = 0
    var scoreThree = 0
    var scoreFour = 0
    var scoreFive = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager
            .LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_score)

        scoreOne = intent.getStringExtra("score_one")!!.toInt()
        scoreTwo = intent.getStringExtra("score_two")!!.toInt()
        scoreThree = intent.getStringExtra("score_three")!!.toInt()
        scoreFour = intent.getStringExtra("score_four")!!.toInt()
        scoreFive = intent.getStringExtra("score_five")!!.toInt()

        val gridLines = GridView(this)
        graphBackground.addView(gridLines)


        val graph = DrawGraph(this)
        graph.setData(getDataPoints())
        graphView.addView(graph)
    }

    private fun getDataPoints(): List<DataPoint> {

        val list = listOf(100-scoreOne, 100-scoreTwo, 100-scoreThree, 100-scoreFour, 100-scoreFive)

        return (0..4).map {
            DataPoint(it, list[it])
        }
    }
}
