package com.facebook;

import android.os.Handler;
import com.sdk.growthbook.utils.Constants;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0013\u0018\u0000 D2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002EDB\u0017\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u001d\b\u0016\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0007\"\u00020\u0002¢\u0006\u0004\b\u0005\u0010\bJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0096\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b \u0010\u001fJ \u0010!\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b!\u0010\"J\u0013\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b#\u0010\fJ\r\u0010$\u001a\u00020\r¢\u0006\u0004\b$\u0010\u000fR$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0017\u0010/\u001a\u00020.8\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R0\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u0002032\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u0002038\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0004\u00105\u001a\u0004\b6\u0010\fR0\u00107\u001a\b\u0012\u0004\u0012\u00020\u0010032\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u0010038\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b7\u00105\u001a\u0004\b8\u0010\fR$\u00109\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u00100\u001a\u0004\b:\u00102\"\u0004\b;\u0010<R$\u0010A\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00198F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0014\u0010C\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010>¨\u0006F"}, d2 = {"Lcom/facebook/GraphRequestBatch;", "Ljava/util/AbstractList;", "Lcom/facebook/GraphRequest;", BuildConfig.FLAVOR, "requests", "<init>", "(Ljava/util/Collection;)V", BuildConfig.FLAVOR, "([Lcom/facebook/GraphRequest;)V", BuildConfig.FLAVOR, "Lcom/facebook/GraphResponse;", "executeAndWaitImpl", "()Ljava/util/List;", "Lcom/facebook/GraphRequestAsyncTask;", "executeAsyncImpl", "()Lcom/facebook/GraphRequestAsyncTask;", "Lcom/facebook/GraphRequestBatch$Callback;", com.sun.jna.Callback.METHOD_NAME, BuildConfig.FLAVOR, "addCallback", "(Lcom/facebook/GraphRequestBatch$Callback;)V", "element", BuildConfig.FLAVOR, "add", "(Lcom/facebook/GraphRequest;)Z", BuildConfig.FLAVOR, "index", "(ILcom/facebook/GraphRequest;)V", "clear", "()V", "get", "(I)Lcom/facebook/GraphRequest;", "removeAt", "set", "(ILcom/facebook/GraphRequest;)Lcom/facebook/GraphRequest;", "executeAndWait", "executeAsync", "Landroid/os/Handler;", "callbackHandler", "Landroid/os/Handler;", "getCallbackHandler", "()Landroid/os/Handler;", "setCallbackHandler", "(Landroid/os/Handler;)V", "timeoutInMilliseconds", "I", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "Ljava/lang/String;", "getId", "()Ljava/lang/String;", BuildConfig.FLAVOR, "<set-?>", "Ljava/util/List;", "getRequests", "callbacks", "getCallbacks", "batchApplicationId", "getBatchApplicationId", "setBatchApplicationId", "(Ljava/lang/String;)V", "getTimeout", "()I", "setTimeout", "(I)V", "timeout", "getSize", "size", "Companion", "Callback", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class GraphRequestBatch extends AbstractList<GraphRequest> {
    private static final AtomicInteger idGenerator = new AtomicInteger();
    private String batchApplicationId;
    private Handler callbackHandler;
    private List<Callback> callbacks;
    private final String id;
    private List<GraphRequest> requests;
    private int timeoutInMilliseconds;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/facebook/GraphRequestBatch$Callback;", BuildConfig.FLAVOR, "onBatchCompleted", BuildConfig.FLAVOR, "batch", "Lcom/facebook/GraphRequestBatch;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public interface Callback {
        void onBatchCompleted(GraphRequestBatch batch);
    }

    public GraphRequestBatch(Collection<GraphRequest> requests) {
        Intrinsics.checkNotNullParameter(requests, "requests");
        this.id = String.valueOf(Integer.valueOf(idGenerator.incrementAndGet()));
        this.callbacks = new ArrayList();
        this.requests = new ArrayList(requests);
    }

    private final List<GraphResponse> executeAndWaitImpl() {
        return GraphRequest.INSTANCE.executeBatchAndWait(this);
    }

    private final GraphRequestAsyncTask executeAsyncImpl() {
        return GraphRequest.INSTANCE.executeBatchAsync(this);
    }

    public final void addCallback(Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.callbacks.contains(callback)) {
            return;
        }
        this.callbacks.add(callback);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.requests.clear();
    }

    public /* bridge */ boolean contains(GraphRequest graphRequest) {
        return super.contains((Object) graphRequest);
    }

    public final List<GraphResponse> executeAndWait() {
        return executeAndWaitImpl();
    }

    public final GraphRequestAsyncTask executeAsync() {
        return executeAsyncImpl();
    }

    public final String getBatchApplicationId() {
        return this.batchApplicationId;
    }

    public final Handler getCallbackHandler() {
        return this.callbackHandler;
    }

    public final List<Callback> getCallbacks() {
        return this.callbacks;
    }

    public final String getId() {
        return this.id;
    }

    public final List<GraphRequest> getRequests() {
        return this.requests;
    }

    public int getSize() {
        return this.requests.size();
    }

    /* renamed from: getTimeout, reason: from getter */
    public final int getTimeoutInMilliseconds() {
        return this.timeoutInMilliseconds;
    }

    public /* bridge */ int indexOf(GraphRequest graphRequest) {
        return super.indexOf((Object) graphRequest);
    }

    public /* bridge */ int lastIndexOf(GraphRequest graphRequest) {
        return super.lastIndexOf((Object) graphRequest);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ GraphRequest remove(int i5) {
        return removeAt(i5);
    }

    public GraphRequest removeAt(int index) {
        return this.requests.remove(index);
    }

    public final void setCallbackHandler(Handler handler) {
        this.callbackHandler = handler;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null ? true : obj instanceof GraphRequest) {
            return contains((GraphRequest) obj);
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public GraphRequest get(int index) {
        return this.requests.get(index);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj == null ? true : obj instanceof GraphRequest) {
            return indexOf((GraphRequest) obj);
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj == null ? true : obj instanceof GraphRequest) {
            return lastIndexOf((GraphRequest) obj);
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public GraphRequest set(int index, GraphRequest element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.requests.set(index, element);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(GraphRequest element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.requests.add(element);
    }

    public /* bridge */ boolean remove(GraphRequest graphRequest) {
        return super.remove((Object) graphRequest);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int index, GraphRequest element) {
        Intrinsics.checkNotNullParameter(element, "element");
        this.requests.add(index, element);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        if (obj == null ? true : obj instanceof GraphRequest) {
            return remove((GraphRequest) obj);
        }
        return false;
    }

    public GraphRequestBatch(GraphRequest... requests) {
        Intrinsics.checkNotNullParameter(requests, "requests");
        this.id = String.valueOf(Integer.valueOf(idGenerator.incrementAndGet()));
        this.callbacks = new ArrayList();
        this.requests = new ArrayList(ArraysKt.asList(requests));
    }
}
