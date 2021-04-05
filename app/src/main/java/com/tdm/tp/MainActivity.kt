package com.tdm.tp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.tdm.tp.listeCommandes.commandeItem
import com.tdm.tp.listeCommandes.commandesAdapter

class MainActivity : AppCompatActivity(),commandesAdapter.OnItemClickListener {

    private lateinit var modelList : ArrayList<Model>
    private lateinit var commandesList : ArrayList<commandeItem>
    private lateinit var adapter : Adapter
    private lateinit var adapterCommandes : commandesAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val vp = findViewById<ViewPager>(R.id.viewPager)

        loadCards()


        vp.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {

            }
        })

        loadCommandes()
    }

    private fun loadCards() {
        modelList = ArrayList()
        modelList.add(Model("ez","ez",R.drawable.ic_camion_de_livraison))
        modelList.add(Model("ez","ez",R.drawable.ic_camion_de_livraison))
        modelList.add(Model("ez","ez",R.drawable.ic_camion_de_livraison))

        adapter = Adapter(this,modelList)
        val vp = findViewById<ViewPager>(R.id.viewPager)
        vp.adapter = adapter
        vp.setPadding(300,0,300,0)
    }

    private fun loadCommandes(){
        commandesList = ArrayList()
        commandesList.add(commandeItem("0040304342","","","","",""))
        commandesList.add(commandeItem("4423426467","","","","",""))
        commandesList.add(commandeItem("1117474634","","","","",""))
        commandesList.add(commandeItem("1117474634","","","","",""))
        commandesList.add(commandeItem("1117474634","","","","",""))

        val a = findViewById<RecyclerView>(R.id.recycler) as RecyclerView
        a.adapter = commandesAdapter(commandesList, this)
        a.layoutManager = LinearLayoutManager(this)
        a.setHasFixedSize(true)
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this,detailsCommande::class.java)
        startActivity(intent)
    }

}