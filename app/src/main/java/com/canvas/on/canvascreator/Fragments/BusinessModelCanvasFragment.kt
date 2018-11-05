package com.canvas.on.canvascreator.Fragments

import android.arch.lifecycle.ViewModelProviders
import android.content.Context.MODE_PRIVATE
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
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

        var sqlDataBase: SQLiteDatabase = activity!!.openOrCreateDatabase("Canvas", MODE_PRIVATE, null)
        sqlDataBase.execSQL("CREATE TABLE IF NOT EXISTS usercanvas (valueProp VARCHAR, customerSeg VARCHAR," +
                "customerRelation VARCHAR, channels VARCHAR, keyAct VARCHAR, keyRes VARCHAR, keyPartners VARCHAR," +
                "costStruct VARCHAR, revenueStream VARCHAR)")

        sqlDataBase.execSQL("INSERT INTO usercanvas (valueProp) VALUES ('hola')")

        var c: Cursor = sqlDataBase.rawQuery("SELECT valueProp FROM usercanvas", null)
        c.moveToFirst()
        var vpIndex: Int = c.getColumnIndex("valueProp")

            Log.d("test", c.getString(0))
    }
}
