package com.musicmuni.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main.*

class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main)

        val myView = GridView(this)
        graphBackground.addView(myView)


        val myViewTest = DrawGraph(this)
        myViewTest.setData(generateRandomDataPoints())
        graphView.addView(myViewTest)
    }

    private fun generateRandomDataPoints(): List<DataPoint> {

        val list = listOf(100-10, 100-20, 100-30, 100-40, 100-80)

        return (0..4).map {
            DataPoint(it, list[it])
        }
    }
}
