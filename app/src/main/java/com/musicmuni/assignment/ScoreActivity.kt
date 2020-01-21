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



        val dataPointList: List<DataPoint>
        dataPointList = ArrayList()
        dataPointList.toMutableList().add(DataPoint(1,1))
        dataPointList.toMutableList().add(DataPoint(10,10))
        dataPointList.toMutableList().add(DataPoint(100,100))
        dataPointList.toMutableList().add(DataPoint(20,20))
        dataPointList.toMutableList().add(DataPoint(25,25))

        val myViewTest = DrawGraph(this)
        myViewTest.setData(generateRandomDataPoints())
        graphView.addView(myViewTest)
    }

    private fun generateRandomDataPoints(): List<DataPoint> {
        val random = Random()
        return (0..4).map {
            DataPoint(it, random.nextInt(50) + 1)
        }
    }
}
