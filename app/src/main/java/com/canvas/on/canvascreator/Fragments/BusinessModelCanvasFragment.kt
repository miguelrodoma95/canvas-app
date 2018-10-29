package com.canvas.on.canvascreator.Fragments

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.canvas.on.canvascreator.CanvasViewModel.CanvasViewModel
import com.canvas.on.canvascreator.R
import kotlinx.android.synthetic.main.activity_main.*

class BusinessModelCanvasFragment : Fragment() {

    lateinit var canvasVM: CanvasViewModel
    lateinit var tvProjectName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bmc, fl_container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        canvasVM =  activity.run {
            ViewModelProviders.of(this!!).get(CanvasViewModel::class.java)
        }

        tvProjectName = activity!!.findViewById(R.id.tv_projectName)
        tvProjectName.text = canvasVM.projectName
    }
}
