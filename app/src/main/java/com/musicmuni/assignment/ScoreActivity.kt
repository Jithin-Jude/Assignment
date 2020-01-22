package com.musicmuni.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val myView = GridView(this)
        graphBackground.addView(myView)


        val myViewTest = DrawGraph(this)
        myViewTest.setData(generateRandomDataPoints())
        graphView.addView(myViewTest)
    }

    private fun generateRandomDataPoints(): List<DataPoint> {

        val list = listOf(2, 12, 13, 49, 34)

        return (0..4).map {
            DataPoint(it, list[it])
        }
    }
}
