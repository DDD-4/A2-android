package kr.ddd.domain.usecase.base

import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single

abstract class SingleUseCase<T, in Params>(
    private val executorScheduler: Scheduler,
    private val postExecutionScheduler: Scheduler
) : BaseUseCase<Params>() {

    protected abstract fun buildUseCaseSingle(params: Params): Single<T>

    override fun execute(params: Params): Single<T> =
        buildUseCaseSingle(params = params)
            .subscribeOn(executorScheduler)
            .observeOn(postExecutionScheduler)
}
