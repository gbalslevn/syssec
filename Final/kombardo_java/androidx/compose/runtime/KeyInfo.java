package androidx.compose.runtime;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u0001B3\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\n\u001a\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Landroidx/compose/runtime/KeyInfo;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "key", "objectKey", "location", "nodes", "index", "<init>", "(ILjava/lang/Object;III)V", "I", "getKey", "()I", "Ljava/lang/Object;", "getObjectKey", "()Ljava/lang/Object;", "getLocation", "getNodes", "getIndex", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class KeyInfo {
    private final int index;
    private final int key;
    private final int location;
    private final int nodes;
    private final Object objectKey;

    public KeyInfo(int i5, Object obj, int i6, int i7, int i8) {
        this.key = i5;
        this.objectKey = obj;
        this.location = i6;
        this.nodes = i7;
        this.index = i8;
    }

    public final int getKey() {
        return this.key;
    }

    public final int getLocation() {
        return this.location;
    }

    public final int getNodes() {
        return this.nodes;
    }

    public final Object getObjectKey() {
        return this.objectKey;
    }
}
