package com.adjust.sdk.scheduler;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public abstract class AsyncTaskExecutor<Params, Result> {

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object[] f4211a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Handler f4212b;

        /* renamed from: com.adjust.sdk.scheduler.AsyncTaskExecutor$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0026a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f4214a;

            public RunnableC0026a(Object obj) {
                this.f4214a = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() {
                AsyncTaskExecutor.this.onPostExecute(this.f4214a);
            }
        }

        public a(Object[] objArr, Handler handler) {
            this.f4211a = objArr;
            this.f4212b = handler;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            this.f4212b.post(new RunnableC0026a(AsyncTaskExecutor.this.doInBackground(this.f4211a)));
        }
    }

    public abstract Result doInBackground(Params[] paramsArr);

    @SafeVarargs
    public final AsyncTaskExecutor<Params, Result> execute(Params... paramsArr) {
        onPreExecute();
        Executors.newSingleThreadExecutor().execute(new a(paramsArr, new Handler(Looper.getMainLooper())));
        return this;
    }

    public void onPostExecute(Result result) {
    }

    public void onPreExecute() {
    }
}
