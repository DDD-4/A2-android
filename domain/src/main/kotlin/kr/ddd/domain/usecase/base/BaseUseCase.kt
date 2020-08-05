package kr.ddd.domain.usecase.base

import kr.ddd.domain.UseCase


abstract class BaseUseCase<in Params> : UseCase {

    abstract fun execute(params: Params): Any

}
