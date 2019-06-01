package com.acm.workshop.feedme.app.executor

import com.acm.workshop.feedme.domain.executor.UseCaseExecutorThread
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class BackgroundThread : UseCaseExecutorThread{
    override val scheduler: Scheduler
        get() = Schedulers.io()

}