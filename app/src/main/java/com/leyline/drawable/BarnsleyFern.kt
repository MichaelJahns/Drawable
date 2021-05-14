package com.leyline.drawable

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class BarnsleyFern @JvmOverloads constructor(
    context: Context, attributeSet: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {
    var x: Double = 250.0
    var y: Double = 800.0
    val paint: Paint = Paint()


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        for(i in 1..10000){
            drawPoint(canvas)
            nextPoint()
        }
    }

    fun drawPoint(canvas: Canvas?){
        val px = x.toFloat()
        val py = y.toFloat()
        canvas?.drawPoint(px, py, paint)
    }
    fun nextPoint(){
        val tempX: Double
        val tempY: Double
        val r = Math.random()

        // Stem Points
        when {
            r <= 0.01 -> {
                tempX = 0.50
                tempY = 0.16 * y
            }// Left leaflets
            r <= 0.08 -> {
                tempX = 0.20 * x - 0.26 * y + 0.400
                tempY = 0.23 * x + 0.22 * y - 0.045
            }// Right leaflets
            r <= 0.15 -> {
                tempX = -0.15 * x + 0.28 * y + 0.575
                tempY =  0.26 * x + 0.24 * y - 0.086
            }
            //  Successively smaller leaflets
            else -> {
                tempX =  0.85 * x + 0.04 * y + 0.075
                tempY = -0.04 * x + 0.85 * y + 0.180
            }
        }
        x = tempX;
        y = tempY;
    }
}