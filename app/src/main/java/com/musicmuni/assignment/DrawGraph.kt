package com.musicmuni.assignment

import android.content.Context
import android.graphics.*
import android.view.View
import androidx.core.content.ContextCompat

/**
 * Created by <Jithin/Jude> on 21,January,2020.
 * jithin.jude68@gmail.com
 */

class DrawGraph(context: Context): View(context) {

    private val dataSet = mutableListOf<DataPoint>()
    private var xMin = 0
    private var xMax = 0
    private var yMin = 0
    private var yMax = 0

    private val dataPointPaint = Paint().apply {
        color = Color.BLUE
        strokeWidth = 7f
        style = Paint.Style.STROKE
    }

    private val positions = null

    private val dataPointOneFillPaint = Paint()
    private val dataPointTwoFillPaint = Paint()
    private val dataPointThreeFillPaint = Paint()
    private val dataPointFourFillPaint = Paint()
    private val dataPointFiveFillPaint = Paint()

    private val dataPointLinePaint = Paint().apply {
        color = Color.parseColor("#b7b7b2")
        strokeWidth = 7f
        isAntiAlias = true
    }

    private val axisLinePaint = Paint().apply {
        color = Color.RED
        strokeWidth = 10f
    }

    override fun onSizeChanged(w: Int, h: Int, oldW: Int, oldH: Int) {

        val colorsPointOne = intArrayOf(
            ContextCompat.getColor(context,
                R.color.ptOneColorOne),
            ContextCompat.getColor(context,
                R.color.ptOneColorTwo),
            ContextCompat.getColor(context,
                R.color.ptOneColorThree))

        dataPointOneFillPaint.shader = LinearGradient(
            0f,
            0f,
            0f,
            height.toFloat(),
            colorsPointOne,
            positions,
            Shader.TileMode.MIRROR
        )

        val colorsPointTwo = intArrayOf(
            ContextCompat.getColor(context,
                R.color.ptTwoColorOne),
            ContextCompat.getColor(context,
                R.color.ptTwoColorTwo),
            ContextCompat.getColor(context,
                R.color.ptTwoColorThree),
            ContextCompat.getColor(context,
                R.color.ptTwoColorFour))

        dataPointTwoFillPaint.shader = LinearGradient(
            0f,
            0f,
            0f,
            height.toFloat(),
            colorsPointTwo,
            positions,
            Shader.TileMode.MIRROR
        )

        val colorsPointThree = intArrayOf(
            ContextCompat.getColor(context,
                R.color.ptThreeColorOne),
            ContextCompat.getColor(context,
                R.color.ptThreeColorTwo),
            ContextCompat.getColor(context,
                R.color.ptThreeColorThree))

        dataPointThreeFillPaint.shader = LinearGradient(
            0f,
            0f,
            0f,
            height.toFloat(),
            colorsPointThree,
            positions,
            Shader.TileMode.MIRROR
        )

        val colorsPointFour = intArrayOf(
            ContextCompat.getColor(context,
                R.color.ptFourColorOne),
            ContextCompat.getColor(context,
                R.color.ptFourColorTwo),
            ContextCompat.getColor(context,
                R.color.ptFourColorThree))

        dataPointFourFillPaint.shader = LinearGradient(
            0f,
            0f,
            0f,
            height.toFloat(),
            colorsPointFour,
            positions,
            Shader.TileMode.MIRROR
        )

        val colorsPointFive = intArrayOf(
            ContextCompat.getColor(context,
                R.color.ptFiveColorOne),
            ContextCompat.getColor(context,
                R.color.ptFiveColorTwo),
            ContextCompat.getColor(context,
                R.color.ptFiveColorThree))

        dataPointFiveFillPaint.shader = LinearGradient(
            0f,
            0f,
            0f,
            height.toFloat(),
            colorsPointFive,
            positions,
            Shader.TileMode.MIRROR
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        dataSet.forEachIndexed { index, currentDataPoint ->
            val realX = currentDataPoint.xVal.toRealX()
            val realY = currentDataPoint.yVal.toRealY()

            if (index < dataSet.size - 1) {
                val nextDataPoint = dataSet[index + 1]
                val startX = currentDataPoint.xVal.toRealX()
                val startY = currentDataPoint.yVal.toRealY()
                val endX = nextDataPoint.xVal.toRealX()
                val endY = nextDataPoint.yVal.toRealY()
                canvas.drawLine(startX, startY, endX, endY, dataPointLinePaint)
            }

            if(index == 0){
                canvas.drawCircle(realX, realY, 20f, dataPointOneFillPaint)
            }else if(index == 1){
                canvas.drawCircle(realX, realY, 20f, dataPointTwoFillPaint)
            }else if(index == 2){
                canvas.drawCircle(realX, realY, 20f, dataPointThreeFillPaint)
            }else if(index == 3){
                canvas.drawCircle(realX, realY, 20f, dataPointFourFillPaint)
            }else if(index == 4){
                canvas.drawCircle(realX, realY, 20f, dataPointFiveFillPaint)
            }
            //canvas.drawCircle(realX, realY, 7f, dataPointPaint)
        }

        //canvas.drawLine(0f, 0f, 0f, height.toFloat(), axisLinePaint)
        //canvas.drawLine(0f, height.toFloat(), width.toFloat(), height.toFloat(), axisLinePaint)
    }

    fun setData(newDataSet: List<DataPoint>) {
        xMin = newDataSet.minBy { it.xVal }?.xVal ?: 0
        xMax = newDataSet.maxBy { it.xVal }?.xVal ?: 0
        yMin = newDataSet.minBy { it.yVal }?.yVal ?: 0
        yMax = newDataSet.maxBy { it.yVal }?.yVal ?: 0
        dataSet.clear()
        dataSet.addAll(newDataSet)
        invalidate()
    }

    private fun Int.toRealX() = toFloat() / xMax * width
    private fun Int.toRealY() = toFloat() / yMax * height
}

data class DataPoint(
    val xVal: Int,
    val yVal: Int
)