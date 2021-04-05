package com.tdm.tp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter

                        /** ------------------------- Dev : AIT SAID HICHAM  ----------------------- **/

class Adapter (private val context : Context, private val myModelArrayList: ArrayList<Model>) : PagerAdapter(){



    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return myModelArrayList.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val view = LayoutInflater.from(context).inflate(R.layout.card_item,container,false)

        val model = myModelArrayList[position]

        val text = model.text
        val num = model.num
        val image = model.image


        view.findViewById<TextView>(R.id.title).text = text
        view.findViewById<TextView>(R.id.num).text = num // this one comes from DB
        view.findViewById<ImageView>(R.id.liv).setImageResource(image)


        view.setOnClickListener {}
        container.addView(view, position)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }


}