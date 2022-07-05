package com.geektech.homework63

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.geektech.homework63.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ImageAdapter
    private lateinit var list: ArrayList<Int>
    private var list2 = arrayListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.title = "Выберите фотографии"

        loadImages()
        binding.recycler.layoutManager = GridLayoutManager(applicationContext, 3)
        adapter = ImageAdapter(list)
        binding.recycler.adapter = adapter
        initClick()
    }

    private fun initClick() {
        adapter.setOnClickListener(object : ClickListener {
            override fun onClick(image: Int, view: View) {
                if (list2.contains(image)) {
                    list2.remove(image)
                    view.alpha = 1f
                } else {
                    list2.add(image)
                    view.alpha = 0.5f
                }
            }
        })
        binding.fub.setOnClickListener {
            Intent(this, ResultActivity::class.java).apply {
                putExtra(keyMaRa, list2)
                startActivity(this)
            }
        }
    }

    private fun loadImages() {
        list = arrayListOf()
        list.add(R.drawable.img)
        list.add(R.drawable.img2)
        list.add(R.drawable.img3)
        list.add(R.drawable.img2)
        list.add(R.drawable.img)
        list.add(R.drawable.img)
        list.add(R.drawable.img2)
        list.add(R.drawable.img3)
        list.add(R.drawable.img3)
        list.add(R.drawable.img2)
        list.add(R.drawable.img)
        list.add(R.drawable.img2)
        list.add(R.drawable.img3)
        list.add(R.drawable.img)
        list.add(R.drawable.img3)
    }

    companion object {
        const val keyMaRa: String = "main_key"
    }


}