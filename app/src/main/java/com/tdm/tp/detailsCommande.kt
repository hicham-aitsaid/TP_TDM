package com.tdm.tp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import java.util.*
import kotlin.collections.ArrayList


                        /** ------------------------- Dev : AIT SAID HICHAM  ----------------------- **/

class detailsCommande : AppCompatActivity(),detailsAdapter.OnItemClickListener {
    private lateinit var detailsList : ArrayList<detailsItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_commande)

        detailsList = ArrayList()
        detailsList.add(detailsItem("0040304342","200"))
        detailsList.add(detailsItem("4423426467","4"))
        detailsList.add(detailsItem("1117474634","52"))
        detailsList.add(detailsItem("1117474634","167"))
        detailsList.add(detailsItem("1117474634","908"))

        val a = findViewById<RecyclerView>(R.id.commande_recycler) as RecyclerView
        a.adapter = detailsAdapter(detailsList, this)
        a.layoutManager = LinearLayoutManager(this)
        a.setHasFixedSize(true)
    }

    override fun onItemClick(position: Int) {
        //ez
    }

    fun goto(view : View){
        val uri: String = java.lang.String.format(
            Locale.ENGLISH,
            "http://maps.google.com/maps?q=loc:%f,%f",
            28.43242324,
            77.8977673
        )
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        startActivity(intent)
    }


    fun scanCode(view : View){
        IntentIntegrator(this@detailsCommande).initiateScan();
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        var result: IntentResult? = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

        if(result != null){

            if(result.contents != null){
                /*txtValue.text = result.contents*/
            } else {
                /*txtValue.text = "scan failed"*/
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }


    fun validerCommande(view:View){

    }
}