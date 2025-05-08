package retrofit2;

import okhttp3.Request;

/* loaded from: classes3.dex */
public interface Call<T> extends Cloneable {
    void cancel();

    Call<T> clone();

    void enqueue(Callback<T> callback);

    boolean isCanceled();

    Request request();
}
