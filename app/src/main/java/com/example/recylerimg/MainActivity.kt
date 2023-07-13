package com.example.recylerimg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recylerimg.databinding.ActivityMainBinding
import com.example.recylerimg.databinding.ItemRowBinding

class MainActivity : AppCompatActivity(), ItemAdapter.ItemClickListener {
    private lateinit var binding: ActivityMainBinding
    private val itemList = returnItemList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar el RecyclerView y el adaptador
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        val itemAdapter = ItemAdapter(itemList, this)
        binding.recyclerView.adapter = itemAdapter
    }

    // Método para cargar los datos de los ítems
    private fun returnItemList(): List<Item> {
        return listOf(
            Item("Zhuo Cheng you", "https://unsplash.com/photos/UBvtBr_FmrY/download?force=true&w=640"),
            Item("billow926", "https://unsplash.com/photos/pNoP-qVwBFQ/download?force=true&w=640"),
            Item("Philipp Deiß", "https://unsplash.com/photos/LfJx0gqqiEc/download?force=true&w=640"),
            Item("Huper by Joshua Earle", "https://unsplash.com/photos/_p8gVNNsWw4/download?force=true&w=640"),
            Item("Melnychuk Nataliya", "https://unsplash.com/photos/rnPGCe7LsQo/download?force=true&w=640"),
            Item("Teagan Maddux", "https://unsplash.com/photos/k2DbTXQ0yrQ/download?force=true&w=640"),
            Item("Chen Liu", "https://unsplash.com/photos/kZH8X0q4Nvo/download?force=true&w=640"),
            Item("John Fornander", "https://unsplash.com/photos/iNqJx-VOceI/download?force=true&w=640"),
            Item("Parker Coffman", "https://unsplash.com/photos/mNWrQ9O6KZw/download?force=true&w=640"),
            Item("XPS", "https://unsplash.com/photos/8pb7Hq539Zw/download?force=true&w=640"),
            Item("Daniel J. Schwarz", "https://unsplash.com/photos/l8BvDmt8Ac4/download?force=true&w=640"),
            Item("Wesley Armstrong", "https://unsplash.com/photos/q0wqYpyWDpc/download?force=true&w=640")
        )
    }

    // Método que se ejecuta cuando se hace clic en un ítem
    override fun onItemClick(item: Item) {
        val detailsFragment = DetailsFragment.newInstance(item.name, item.imageUrl)
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, detailsFragment) // Reemplazar el contenedor principal
            .addToBackStack(null)
            .commit()
    }
}
