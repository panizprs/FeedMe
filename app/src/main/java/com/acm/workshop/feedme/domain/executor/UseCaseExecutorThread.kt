package com.acm.workshop.feedme.domain.executor

import io.reactivex.Scheduler

interface UseCaseExecutorThread{
    val scheduler : Scheduler
}