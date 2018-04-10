package pt.josefaria.kotlingenderizeapp.ui.AskGender

import pt.josefaria.kotlingenderizeapp.models.networkCalls.Model

/**
 * Created by jose.faria on 01-03-2018.
 */
interface AskGenderInterface {

    fun showSuccessMessage(model: Model)

    fun showError(message: String?)
}