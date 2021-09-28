package fastcampus.aop.part2.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import fastcampus.aop.part2.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            if (binding.etHeight.text.isEmpty() || binding.etWeight.text.isEmpty()) {
                Toast.makeText(this@MainActivity, "빈 값이 있습니다", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val height: Int = binding.etHeight.text.toString().toInt()
            val weight: Int = binding.etWeight.text.toString().toInt()

            val intent = Intent(this@MainActivity, ResultActivity::class.java)
            intent.putExtra("weight", weight)
            intent.putExtra("height", height)
            startActivity(intent)
        }
    }
}