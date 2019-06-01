package com.acm.workshop.feedme.domain.executor

import io.reactivex.Scheduler

interface PostExecutorThread {
    val scheduler : Scheduler
}