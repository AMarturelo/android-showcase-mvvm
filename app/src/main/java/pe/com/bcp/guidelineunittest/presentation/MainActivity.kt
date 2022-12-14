package pe.com.bcp.guidelineunittest.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pe.com.bcp.guidelineunittest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}