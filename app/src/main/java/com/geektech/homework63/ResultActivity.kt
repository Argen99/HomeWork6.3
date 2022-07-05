package com.geektech.homework63

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.geektech.homework63.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityResultBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar!!.title = "Выбранные фотографии"
        binding.recyclerResult.layoutManager = GridLayoutManager(applicationContext, 3)

        val result: ArrayList<Int> =
            intent.getIntegerArrayListExtra(MainActivity.keyMaRa) as ArrayList<Int>
        val adapter = ImageAdapter(result)
        binding.recyclerResult.adapter = adapter

        adapter.setOnClickListener(object : ClickListener {
            override fun onClick(image: Int, view: View) {
            }
        })
    }
}