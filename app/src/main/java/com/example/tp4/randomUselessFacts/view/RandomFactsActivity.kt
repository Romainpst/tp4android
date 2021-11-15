package com.example.tp4.randomUselessFacts.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp4.randomUselessFacts.model.RandomFactsUi
import com.example.tp4.randomUselessFacts.view.RandomFactsAdapter
import com.example.tp4.randomUselessFacts.viewModel.RandomFactsViewModel
import com.example.tp4.databinding.ActivityRandomFactsBinding

class RandomFactsActivity : AppCompatActivity() {

    private lateinit var viewModel: RandomFactsViewModel
    private lateinit var binding : ActivityRandomFactsBinding
    private val adapter : RandomFactsAdapter = RandomFactsAdapter()

    private val observer = Observer<List<RandomFactsUi>> {
        adapter.submitList(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRandomFactsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[RandomFactsViewModel::class.java]

        binding.randomFactsActivityRv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.randomFactsActivityRv.adapter = adapter

        binding.randomFactsActivityAdd.setOnClickListener {
            viewModel.fetchNewQuote()
        }

        binding.randomFactsActivityDelete.setOnClickListener {
            viewModel.deleteAll()
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.randomFactsQuoteLiveData.observe(this, observer)
    }

    override fun onStop() {
        viewModel.randomFactsQuoteLiveData.removeObserver(observer)
        super.onStop()
    }
}