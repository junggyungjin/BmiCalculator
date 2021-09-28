package fastcampus.aop.part2.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fastcampus.aop.part2.bmicalculator.databinding.ActivityResultBinding
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {
    lateinit var binding : ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val weight = intent.getIntExtra("weight", 0)
        val height = intent.getIntExtra("height", 0)

        val bmi = weight / (height/100.0).pow(2.0)
        val resultText = when{
            bmi >= 35.0 -> "고도비만입니다"
            bmi >= 30.0 -> "중정도비만입니다"
            bmi >= 25.0 -> "경도비만입니다"
            bmi >= 23.0 -> "과체중입니다"
            bmi >= 18.5 -> "정상체중입니다"
            else -> "저체중입니다"
        }

        binding.tvBmivalue.text = bmi.toString()
        binding.tvBmiresult.text = resultText


    }
}