package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Fetch images into IntArray called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = IntArray(typedArray.length()) {typedArray.getResourceId(it, 0)}
        typedArray.recycle()

        val fragment1 = ImageDisplayFragment.newInstance(imageArray)

        // Attach an instance of ImageDisplayFragment using factory method

        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        fragmentManager.apply {
            transaction
                .add(R.id.fragmentContainerView, ImageDisplayFragment())
                .commit()
        }





    }


}
