package com.google.android.datatransport.runtime.retries;

/* loaded from: classes.dex */
public abstract class Retries {
    public static <TInput, TResult, TException extends Throwable> TResult retry(int i5, TInput tinput, Function<TInput, TResult, TException> function, RetryStrategy<TInput, TResult> retryStrategy) {
        TResult apply;
        if (i5 < 1) {
            return function.apply(tinput);
        }
        do {
            apply = function.apply(tinput);
            tinput = retryStrategy.shouldRetry(tinput, apply);
            if (tinput == null) {
                break;
            }
            i5--;
        } while (i5 >= 1);
        return apply;
    }
}
