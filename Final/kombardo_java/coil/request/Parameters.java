package coil.request;

import android.support.v4.media.session.a;
import coil.content.Collections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001:\u0002#\"B\u001d\b\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0005¢\u0006\u0004\b\u0007\u0010\bB\t\b\u0016¢\u0006\u0004\b\u0007\u0010\tJ!\u0010\f\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\n*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0013H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010!¨\u0006$"}, d2 = {"Lcoil/request/Parameters;", BuildConfig.FLAVOR, "Lkotlin/Pair;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "entries", "<init>", "(Ljava/util/Map;)V", "()V", "T", "key", "value", "(Ljava/lang/String;)Ljava/lang/Object;", BuildConfig.FLAVOR, "isEmpty", "()Z", "memoryCacheKeys", "()Ljava/util/Map;", BuildConfig.FLAVOR, "iterator", "()Ljava/util/Iterator;", "other", "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", "toString", "()Ljava/lang/String;", "Lcoil/request/Parameters$Builder;", "newBuilder", "()Lcoil/request/Parameters$Builder;", "Ljava/util/Map;", "Companion", "Builder", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Parameters implements Iterable<Pair<? extends String, Object>>, KMappedMarker {
    public static final Parameters EMPTY = new Parameters();
    private final Map<String, Object> entries;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcoil/request/Parameters$Builder;", BuildConfig.FLAVOR, "Lcoil/request/Parameters;", "parameters", "<init>", "(Lcoil/request/Parameters;)V", "build", "()Lcoil/request/Parameters;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "entries", "Ljava/util/Map;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Builder {
        private final Map<String, Object> entries;

        public Builder(Parameters parameters) {
            this.entries = MapsKt.toMutableMap(parameters.entries);
        }

        public final Parameters build() {
            return new Parameters(Collections.toImmutableMap(this.entries), null);
        }
    }

    public /* synthetic */ Parameters(Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(map);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Parameters) && Intrinsics.areEqual(this.entries, ((Parameters) other).entries);
    }

    public int hashCode() {
        return this.entries.hashCode();
    }

    public final boolean isEmpty() {
        return this.entries.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<Pair<? extends String, Object>> iterator() {
        Map<String, Object> map = this.entries;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            a.a(entry.getValue());
            arrayList.add(TuplesKt.to(key, null));
        }
        return arrayList.iterator();
    }

    public final Map<String, String> memoryCacheKeys() {
        if (isEmpty()) {
            return MapsKt.emptyMap();
        }
        Map<String, Object> map = this.entries;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return linkedHashMap;
        }
        a.a(it.next().getValue());
        throw null;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "Parameters(entries=" + this.entries + ')';
    }

    public final <T> T value(String key) {
        a.a(this.entries.get(key));
        return null;
    }

    private Parameters(Map<String, Object> map) {
        this.entries = map;
    }

    public Parameters() {
        this(MapsKt.emptyMap());
    }
}
