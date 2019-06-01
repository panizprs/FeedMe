package com.acm.workshop.feedme.app.executor

import com.acm.workshop.feedme.domain.executor.PostExecutorThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

class MainThread : PostExecutorThread{
    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()

}