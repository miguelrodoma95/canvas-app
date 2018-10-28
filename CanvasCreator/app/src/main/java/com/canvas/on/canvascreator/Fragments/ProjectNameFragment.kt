package com.canvas.on.canvascreator.Fragments

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.canvas.on.canvascreator.CanvasViewModel.CanvasViewModel
import com.canvas.on.canvascreator.R
import kotlinx.android.synthetic.main.activity_main.*

class ProjectNameFragment : Fragment() {

    lateinit var etProjectName: EditText
    lateinit var btnSubmit: Button
    lateinit var canvasVM: CanvasViewModel
    lateinit var tvError: TextView
    lateinit var bmcFragment: BusinessModelCanvasFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fraagment_project_name,fl_container , false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        canvasVM =  activity.run {
            ViewModelProviders.of(this!!).get(CanvasViewModel::class.java)
        }

        bmcFragment = BusinessModelCanvasFragment()
        viewElements()
        clickListeners()
    }

    private fun clickListeners() {
        btnSubmit.setOnClickListener {
            if(validated()){
                tvError.visibility = View.GONE
                canvasVM.projectName = etProjectName.text.toString()
                var fragmentTransaction = fragmentManager?.beginTransaction()
                fragmentTransaction?.replace(R.id.fl_container,bmcFragment)?.addToBackStack("project_name")?.commit()
            } else {
                tvError.visibility = View.VISIBLE
            }
        }
    }

    fun validated(): Boolean {
        if(TextUtils.isEmpty(etProjectName.text)) return false

        return true
    }
    private fun viewElements() {
        etProjectName = activity!!.findViewById(R.id.et_project_name)
        btnSubmit = activity!!.findViewById(R.id.btn_submit)
        tvError = activity!!.findViewById(R.id.tv_error)
    }
}
