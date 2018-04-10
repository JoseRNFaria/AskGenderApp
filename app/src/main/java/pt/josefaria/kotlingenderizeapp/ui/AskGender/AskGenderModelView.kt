package pt.josefaria.kotlingenderizeapp.ui.AskGender

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.widget.Toast
import pt.josefaria.kotlingenderizeapp.models.networkCalls.Model
import pt.josefaria.kotlingenderizeapp.models.networkCalls.NetworkUtils

/**
 * Created by jose.faria on 10-04-2018.
 */

class AskGenderModelView : ViewModel() {

    //  val mPreviewCameraSettings = MutableLiveData<PreviewSettings>()

    val answer = MutableLiveData<String>()

    fun askGender(namesString: String) {
        val names = namesString.split('\n')
        names.forEach { i -> NetworkUtils.beginSearch(i, this) }
    }

    fun returnError(message: String?) {
        answer.value=message
    }

    fun returnSuccessMessage(gender: Model) {
        answer.value=gender.name + " is " + gender.gender
    }

}