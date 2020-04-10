package com.hyejeanmoon.mergeadapterdemo

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.MergeAdapter
import com.hyejeanmoon.mergeadapterdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mergeAdapter: MergeAdapter
    lateinit var firstAdapter: FirstAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        val data = getData()
        firstAdapter = FirstAdapter(data)
        val secondAdapter = SecondAdapter(data)
        val thirdAdapter = ThirdAdapter(data)

        mergeAdapter = MergeAdapter(listOf(firstAdapter, secondAdapter, thirdAdapter))
        binding.recyclerView.adapter = mergeAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(this).inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.remove -> {
                mergeAdapter.removeAdapter(firstAdapter)
            }
            R.id.add -> {
                mergeAdapter.addAdapter(firstAdapter)
            }
            R.id.numbers -> {
                Toast.makeText(this, mergeAdapter.adapters.size.toString(), Toast.LENGTH_LONG)
                    .show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getData(): List<String> {
        val data: ArrayList<String> = ArrayList()
        val prefix = "MOON"
        for (i in 0..10) {
            data.add(prefix + i)
        }
        return data
    }
}
