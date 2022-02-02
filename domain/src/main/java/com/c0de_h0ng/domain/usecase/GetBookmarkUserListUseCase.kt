package com.c0de_h0ng.domain.usecase

import android.util.Log
import com.c0de_h0ng.domain.model.BookmarkUser
import com.c0de_h0ng.domain.repository.SampleRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable

/**
 * Created by c0de_h0ng on 2022/02/02.
 */
class GetBookmarkUserListUseCase constructor(
    private val repository: SampleRepository
) : BaseUseCase<List<BookmarkUser>>() {

    operator fun invoke(): Disposable {
        return repository.getBookmarkUserList()
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                // 구독할 때 수행할 작업을 구현
                result.value = CallResult.Loading(isLoading = true)
            }
            .doOnTerminate {
                // 스트림이 종료될 때 수행할 작업을 구현
                result.value = CallResult.Loading(isLoading = false)
            }
            .subscribe(
                {
                    Log.d("Result >>> ", "Success")
                    result.value = CallResult.Success(it)
                }, {
                    Log.d("Result >>> ", it.localizedMessage ?: "An unexpected error occured")
                    result.value = CallResult.Error(it.localizedMessage ?: "An unexpected error occured", 400)
                }
            )
    }
}