package com.canvas.on.canvascreator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.canvas.on.canvascreator.Fragments.ProjectNameFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var projectNameFragment: ProjectNameFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        projectNameFragment = ProjectNameFragment()

        if(savedInstanceState == null){
            val fragmentTransaction = supportFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fl_container, projectNameFragment).commit()
        }


    }
}
