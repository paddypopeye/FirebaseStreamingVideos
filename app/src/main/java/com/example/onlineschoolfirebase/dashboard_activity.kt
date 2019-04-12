package com.example.onlineschoolfirebase

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.GridLayout

class dashboard_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_activity)

        var lesson1 = "https://firebasestorage.googleapis.com/v0/b/fir-project-f7d09.appspot.com/o/1280.mp4?alt=media&token=fb1550e0-17e7-4c78-bbd3-3031ce3eca25"
        var lesson2 = "https://firebasestorage.googleapis.com/v0/b/fir-project-f7d09.appspot.com/o/big_buck_bunny.mp4?alt=media&token=8752c59f-5993-4eac-bbf9-4242c5b0d55f"
        var lesson3 = "https://firebasestorage.googleapis.com/v0/b/fir-project-f7d09.appspot.com/o/Sample%20Videos%203.mp4?alt=media&token=194f2d7f-9338-469b-aa90-1853d12de2c8"
        var lesson4 = "https://firebasestorage.googleapis.com/v0/b/fir-project-f7d09.appspot.com/o/Sample%20Videos%203.mp4?alt=media&token=194f2d7f-9338-469b-aa90-1853d12de2c8"
        var lesson5 = "https://firebasestorage.googleapis.com/v0/b/fir-project-f7d09.appspot.com/o/toystory.mp4?alt=media&token=9b7fe602-ec67-4435-be61-8cfb6cff9e04"



        var items = ArrayList<Lesson>()

        items.add(Lesson("Test Video one", "This is the first test video", lesson1))
        items.add(Lesson("Test Video two", "This is the second test video", lesson2))
        items.add(Lesson("Test Video three", "This is the third video", lesson3))
        items.add(Lesson("Test Video four", "This is the fourth test video", lesson4))
        items.add(Lesson("Test Video five", "This is the fifth test video", lesson5))

        val list = findViewById<RecyclerView>(R.id.video_list)
        val adapter = Adapter(items, applicationContext)
        list.layoutManager = GridLayoutManager(applicationContext, 1)
        list.adapter = adapter

    }
}
