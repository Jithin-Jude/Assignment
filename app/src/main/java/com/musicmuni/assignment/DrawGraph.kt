package com.musicmuni.assignment

import android.content.Context
import android.graphics.*
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat


/**
 * Created by <Jithin/Jude> on 21,January,2020.
 * jithin.jude68@gmail.com
 */

class DrawGraph(context: Context): View(context) {

    private val padding = 20

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
    private val dataPointFiveStrokePaint = Paint()

    private val dataPointLinePaint = Paint().apply {
        color = Color.parseColor("#b7b7b2")
        strokeWidth = 7f
        isAntiAlias = true
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

        dataPointFiveStrokePaint.shader = LinearGradient(
            0f,
            0f,
            0f,
            height.toFloat(),
            colorsPointFive,
            positions,
            Shader.TileMode.MIRROR
        )
        dataPointFiveStrokePaint.strokeWidth = 7f
        dataPointFiveStrokePaint.style = Paint.Style.STROKE
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

                Log.d("FINAL_VALUE","FINAL VALUE====================================: "+startY+","+endY)

                if(1000-startY < 1000-endY){
                    if(index == 0){
                        drawCurvedArrow(startX+padding, startY-padding, endX, endY, -30,6f,canvas)
                    }else if(index == 3){
                        drawCurvedArrow(startX, startY, endX-40, endY+padding, -30,6f,canvas)
                    } else{
                        drawCurvedArrow(startX, startY, endX, endY, -30,6f,canvas)
                    }
                }else if(1000-startY > 1000-endY){
                    if(index == 0){
                        drawCurvedArrow(startX+padding, startY-padding, endX, endY, 30,6f,canvas)
                    }else if(index == 4){
                        drawCurvedArrow(startX, startY, endX+padding, endY-padding, 30,6f,canvas)
                    } else{
                        drawCurvedArrow(startX, startY, endX, endY, 30,6f,canvas)
                    }
                }else{
                    if(index == 0){
                        canvas.drawLine(startX+padding, startY-padding, endX, endY, dataPointLinePaint)
                    }else if(index == 4){
                        canvas.drawLine(startX, startY, endX+padding, endY-padding, dataPointLinePaint)
                    } else{
                        canvas.drawLine(startX, startY, endX, endY, dataPointLinePaint)
                    }
                }
            }

            if(index == 0){
                canvas.drawCircle(realX+padding, realY-padding, 20f, dataPointOneFillPaint)
                drawText(canvas,realX,realY-70, "10",
                    ContextCompat.getColor(context,
                        R.color.greenGreyWritings))
            }else if(index == 1){
                canvas.drawCircle(realX, realY, 20f, dataPointTwoFillPaint)
                drawText(canvas,realX-padding,realY-70, "20",
                    ContextCompat.getColor(context,
                        R.color.greenGreyWritings))
            }else if(index == 2){
                canvas.drawCircle(realX, realY, 20f, dataPointThreeFillPaint)
                drawText(canvas,realX-padding,realY-70, "30",
                    ContextCompat.getColor(context,
                        R.color.greenGreyWritings))
            }else if(index == 3){
                canvas.drawCircle(realX, realY, 20f, dataPointFourFillPaint)
                drawText(canvas,realX-padding,realY-70, "40",
                    ContextCompat.getColor(context,
                        R.color.greenGreyWritings))
            }else if(index == 4){
                canvas.drawCircle(realX-40, realY+20, 20f, dataPointFiveFillPaint)
                canvas.drawCircle(realX-40, realY+20, 35f, dataPointFiveStrokePaint)
                drawText(canvas,realX-60,realY-50, "80",
                    ContextCompat.getColor(context,
                        R.color.white))
            }
        }
    }

    fun drawCurvedArrow(x1:Float, y1:Float, x2:Float, y2:Float, curveRadius:Int, lineWidth:Float, canvas: Canvas) {
        val paint = Paint()
        paint.setAntiAlias(true)
        paint.setStyle(Paint.Style.STROKE)
        paint.setStrokeWidth(lineWidth)
        paint.setColor(ContextCompat.getColor(context,
            R.color.pathColor))
        val path = Path()
        val midX = x1 + ((x2 - x1) / 2)
        val midY = y1 + ((y2 - y1) / 2)
        val xDiff = (midX - x1).toFloat()
        val yDiff = (midY - y1).toFloat()
        val angle = (Math.atan2(yDiff.toDouble(), xDiff.toDouble()) * (180 / Math.PI)) - 90
        val angleRadians = Math.toRadians(angle)
        val pointX = (midX + curveRadius * Math.cos(angleRadians)).toFloat()
        val pointY = (midY + curveRadius * Math.sin(angleRadians)).toFloat()
        path.moveTo(x1, y1)
        path.cubicTo(x1, y1, pointX, pointY, x2, y2)
        canvas.drawPath(path, paint)
    }

    fun drawText(canvas: Canvas, x: Float, y: Float, text: String, color: Int){

        val customTypeface = ResourcesCompat.getFont(context, R.font.nunito_black)

        val paint = Paint()
        paint.color = color
        paint.typeface = customTypeface
        paint.setTextSize(48f)
        canvas.drawText(text, x, y, paint)
    }

    fun setData(newDataSet: List<DataPoint>) {

        for (item in newDataSet){
            Log.d("GENERATED_VALUE","GENERATED VALUE====================================: "+item.xVal+","+item.yVal)
        }

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