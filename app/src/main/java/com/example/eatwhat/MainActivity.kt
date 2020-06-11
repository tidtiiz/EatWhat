package com.example.eatwhat

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import pl.droidsonroids.gif.GifDrawable


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imvChickenFood.setBackgroundResource(R.drawable.animation_chicken_food)
        val frameAnimation = imvChickenFood.background as AnimationDrawable
        frameAnimation.start()

        val mGifDrawable = burgerGif.drawable as GifDrawable
        mGifDrawable.stop()
        randomBtn.setOnClickListener {
            mGifDrawable.reset()
            mGifDrawable.loopCount = 3
            mGifDrawable.start()

            eatWhat.text = callRandom()
        }


        nextBtn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }

    private fun callRandom(): String {
        val list =
            listOf(
                "เรื่องเยอะจิงๆ",
                "มาม่าขี้เมาทะเล",
                "กะเพราหมูสับ",
                "คะน้าหมูกรอบ",
                "หมูทอดกระเทียม",
                "กินตีนไม๊เรา?",
                "หมูกระทะ",
                "ชาบู",
                "แขนงหมูกรอบ",
                "เนื้อแดดเดียว",
                "ชาบู",
                "ข้าวกล่อง7-11",
                "ไข่เจียวหมูสับ"
            )

        return list.random()
    }
}
