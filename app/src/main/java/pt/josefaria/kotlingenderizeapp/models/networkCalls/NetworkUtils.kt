package pt.josefaria.kotlingenderizeapp.models.networkCalls

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import pt.josefaria.kotlingenderizeapp.ui.AskGender.AskGenderInterface
import pt.josefaria.kotlingenderizeapp.models.networkCalls.retrofitServices.GenderizeApiService
import pt.josefaria.kotlingenderizeapp.ui.AskGender.AskGenderModelView

/**
 * Created by jose.faria on 01-03-2018.
 */


class NetworkUtils {
    companion object {
        private val genderizeApiService by lazy {
            GenderizeApiService.create()
        }

        var disposable: Disposable? = null


        fun beginSearch(srsearch: String, askGender: AskGenderModelView) {
            disposable =
                    genderizeApiService.genderCheck(srsearch)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(
                                    { result -> showResult(result, askGender) },
                                    { error -> showError(error.message, askGender) }
                            )
        }

        private fun showError(message: String?, askGender: AskGenderModelView) {
            askGender.returnError(message)
            disposable?.dispose()
        }

        private fun showResult(gender: Model, askGender: AskGenderModelView) {
            askGender.returnSuccessMessage(gender)
            disposable?.dispose()
        }

    }
}