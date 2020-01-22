package com.musicmuni.assignment

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import androidx.annotation.NonNull
import androidx.annotation.Nullable

/**
 * Created by <Jithin/Jude> on 21,January,2020.
 * jithin.jude68@gmail.com
 */

class GridView @JvmOverloads constructor(@NonNull context: Context):
    View(context) {
    //number of row and column
    internal var horizontalGridCount = 60
    private val horiz:Drawable
    private val vert: Drawable
    private var width:Float = 0.toFloat()
    init{
        horiz = ColorDrawable(Color.parseColor("#075e55"))
        horiz.setAlpha(160)
        vert = ColorDrawable(Color.parseColor("#075e55"))
        vert.setAlpha(160)
        width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0.9f, context
            .resources.displayMetrics)
    }
    override fun onLayout(changed:Boolean, left:Int, top:Int, right:Int, bottom:Int) {
        super.onLayout(changed, left, top, right, bottom)
        horiz.setBounds(left, 0, right, width.toInt())
        vert.setBounds(0, top, width.toInt(), bottom)
    }
    private fun getLinePosition(lineNumber:Int):Float {
        val lineCount = horizontalGridCount
        return (1f / (lineCount + 1)) * (lineNumber + 1f)
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val count = horizontalGridCount
        for (n in 0 until count)
        {
            val pos = getLinePosition(n)
            // Draw horizontal line
            canvas.translate(0f, pos * height)
            horiz.draw(canvas)
            canvas.translate(0f, -pos * height)
            // Draw vertical line
            canvas.translate(pos * getWidth(), 0f)
            vert.draw(canvas)
            canvas.translate(-pos * getWidth(), 0f)
        }

    }
}