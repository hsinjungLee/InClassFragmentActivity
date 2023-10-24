package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(::someVar.isInitalized)

        // Fetch images into IntArray called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = IntArray(typedArray.length()) {typedArray.getResourceId(it, 0)}
        typedArray.recycle()

        val fragment1 = ImageDisplayFragment.newInstance(imageArray)

        // Attach an instance of ImageDisplayFragment using factory method

        if (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) !is ImageDisplayFragment)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainerView, ImageDisplayFragment())
                .addToBackStack(null)
                .setReorderingAllowed(true)
                .commit()

    }

    fun setImage(_image: IntArray){
        images[position] = _image

        (view as RecyclerView).adapter.notifyDataSetChanged()
    }



}
