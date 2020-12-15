package eu.kanade.tachiyomi.ui.setting.track

import android.net.Uri
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class BangumiLoginActivity : BaseOAuthLoginActivity() {

    override fun handleResult(data: Uri?) {
        val code = data?.getQueryParameter("code")
        if (code != null) {
            trackManager.bangumi.login(code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        returnToSettings()
                    },
                    {
                        returnToSettings()
                    }
                )
        } else {
            trackManager.bangumi.logout()
            returnToSettings()
        }
    }
}
