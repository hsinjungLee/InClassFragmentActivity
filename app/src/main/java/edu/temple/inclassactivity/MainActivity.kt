package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val imagesViewModel = ViewModelProvider(this)[ImagesViewModel :: class.java]


        // Fetch images into IntArray called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = IntArray(typedArray.length()) { typedArray.getResourceId(it, 0) }
        typedArray.recycle()

        imagesViewModel.setImages(imageArray)

        if(supportFragmentManager.findFragmentById(R.id.fragmentContainerView)!is ImageDisplayFragment)
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragmentContainerView, ImageDisplayFragment())
                    .addToBackStack(null)
                    .setReorderingAllowed(true)
                    .commit()



    findViewById<Button>(R.id.button).setOnClickListener{


    }



        // Attach an instance of ImageDisplayFragment using factory method

        (supportFragmentManager.findFragmentById(R.id.imageView) as ImageDisplayFragment)



    }
}
