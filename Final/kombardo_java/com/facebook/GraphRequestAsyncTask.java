package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 $2\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001$B\u0019\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0017¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0015\"\u00020\u0002H\u0017¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0019R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR4\u0010 \u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e2\u000e\u0010\u001f\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e8\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/facebook/GraphRequestAsyncTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", BuildConfig.FLAVOR, "Lcom/facebook/GraphResponse;", "Ljava/net/HttpURLConnection;", "connection", "Lcom/facebook/GraphRequestBatch;", "requests", "<init>", "(Ljava/net/HttpURLConnection;Lcom/facebook/GraphRequestBatch;)V", "(Lcom/facebook/GraphRequestBatch;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "onPreExecute", "()V", "result", "onPostExecute", "(Ljava/util/List;)V", BuildConfig.FLAVOR, "params", "doInBackground", "([Ljava/lang/Void;)Ljava/util/List;", "Ljava/net/HttpURLConnection;", "Lcom/facebook/GraphRequestBatch;", "getRequests", "()Lcom/facebook/GraphRequestBatch;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<set-?>", "exception", "Ljava/lang/Exception;", "getException", "()Ljava/lang/Exception;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public class GraphRequestAsyncTask extends AsyncTask<Void, Void, List<? extends GraphResponse>> {
    private static final String TAG = GraphRequestAsyncTask.class.getCanonicalName();
    private final HttpURLConnection connection;
    private Exception exception;
    private final GraphRequestBatch requests;

    public GraphRequestAsyncTask(HttpURLConnection httpURLConnection, GraphRequestBatch requests) {
        Intrinsics.checkNotNullParameter(requests, "requests");
        this.connection = httpURLConnection;
        this.requests = requests;
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ List<? extends GraphResponse> doInBackground(Void[] voidArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                return doInBackground2(voidArr);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ void onPostExecute(List<? extends GraphResponse> list) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                onPostExecute2((List<GraphResponse>) list);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
        }
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                super.onPreExecute();
                if (FacebookSdk.isDebugEnabled()) {
                    Utility utility = Utility.INSTANCE;
                    String str = TAG;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("execute async task: %s", Arrays.copyOf(new Object[]{this}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                    Utility.logd(str, format);
                }
                if (this.requests.getCallbackHandler() == null) {
                    this.requests.setCallbackHandler(Thread.currentThread() instanceof HandlerThread ? new Handler() : new Handler(Looper.getMainLooper()));
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
        }
    }

    public String toString() {
        String str = "{RequestAsyncTask:  connection: " + this.connection + ", requests: " + this.requests + "}";
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder()\n        .append(\"{RequestAsyncTask: \")\n        .append(\" connection: \")\n        .append(connection)\n        .append(\", requests: \")\n        .append(requests)\n        .append(\"}\")\n        .toString()");
        return str;
    }

    /* renamed from: doInBackground, reason: avoid collision after fix types in other method */
    public List<GraphResponse> doInBackground2(Void... params) {
        List<GraphResponse> executeConnectionAndWait;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                Intrinsics.checkNotNullParameter(params, "params");
                try {
                    HttpURLConnection httpURLConnection = this.connection;
                    if (httpURLConnection == null) {
                        executeConnectionAndWait = this.requests.executeAndWait();
                    } else {
                        executeConnectionAndWait = GraphRequest.INSTANCE.executeConnectionAndWait(httpURLConnection, this.requests);
                    }
                    return executeConnectionAndWait;
                } catch (Exception e5) {
                    this.exception = e5;
                    return null;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    /* renamed from: onPostExecute, reason: avoid collision after fix types in other method */
    protected void onPostExecute2(List<GraphResponse> result) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                Intrinsics.checkNotNullParameter(result, "result");
                super.onPostExecute((GraphRequestAsyncTask) result);
                Exception exc = this.exception;
                if (exc != null) {
                    Utility utility = Utility.INSTANCE;
                    String str = TAG;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("onPostExecute: exception encountered during request: %s", Arrays.copyOf(new Object[]{exc.getMessage()}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                    Utility.logd(str, format);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GraphRequestAsyncTask(GraphRequestBatch requests) {
        this(null, requests);
        Intrinsics.checkNotNullParameter(requests, "requests");
    }
}
