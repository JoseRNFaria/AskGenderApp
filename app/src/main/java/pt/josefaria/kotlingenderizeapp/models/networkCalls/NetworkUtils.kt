package pt.josefaria.kotlingenderizeapp.models.networkCalls

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import pt.josefaria.kotlingenderizeapp.ui.AskGender.AskGenderInterface
import pt.josefaria.kotlingenderizeapp.models.networkCalls.retrofitServices.GenderizeApiService

/**
 * Created by jose.faria on 01-03-2018.
 */


class NetworkUtils {
    companion object {
        private val genderizeApiService by lazy {
            GenderizeApiService.create()
        }

        var disposable: Disposable? = null


        fun beginSearch(srsearch: String, askGenderInt: AskGenderInterface) {
            disposable =
                    genderizeApiService.genderCheck(srsearch)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(
                                    { result -> showResult(result, askGenderInt) },
                                    { error -> showError(error.message, askGenderInt) }
                            )
        }

        private fun showError(message: String?, askGenderInt: AskGenderInterface) {
            askGenderInt.showError(message)
            disposable?.dispose()
        }

        private fun showResult(gender: Model, askGenderInt: AskGenderInterface) {
            askGenderInt.showSuccessMessage(gender)
            disposable?.dispose()
        }

    }
}