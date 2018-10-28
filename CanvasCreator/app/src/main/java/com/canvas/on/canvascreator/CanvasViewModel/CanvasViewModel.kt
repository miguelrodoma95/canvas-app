package com.canvas.on.canvascreator.CanvasViewModel

import android.arch.lifecycle.ViewModel

/**
 * Created by MIGUEL on 28/10/2018.
 */
class CanvasViewModel : ViewModel() {

    var projectName: String? = null
    var isLeanCanvas: Boolean? = false
    var valueProposition: Set<String>? = null
    var channels: Set<String>? = null
    var customerRelationships: Set<String>? = null
    var revenueStream: Set<String>? = null
    var keyActivities: Set<String>? = null
    var keyResources: Set<String>? = null
    var keyPartners: Set<String>? = null
    var costStructure: Set<String>? = null


}