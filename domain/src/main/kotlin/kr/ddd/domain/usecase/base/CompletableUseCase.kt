package kr.ddd.domain.usecase.base

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Scheduler

abstract class CompletableUseCase<in Params>(
    private val executorScheduler: Scheduler,
    private val postExecutionScheduler: Scheduler
) : BaseUseCase<Params>() {

    protected abstract fun buildUseCaseCompletable(): Completable

    override fun execute(params: Params): Completable =
        buildUseCaseCompletable()
            .subscribeOn(executorScheduler)
            .observeOn(postExecutionScheduler)
}
