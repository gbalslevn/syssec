package com.kizitonwose.calendar.data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002B1\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\n\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\r\u001a\u0004\u0018\u00018\u00002\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\f\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u000f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\t\u001a\u00020\u0003H\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u000bJ&\u0010\u0013\u001a\u00020\u00122\u0014\u0010\u0011\u001a\u0010\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0010H\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u0003H\u0096\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00172\u0006\u0010\f\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0004\b\u001c\u0010\u001dR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001eR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001fR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030 8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000$8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b%\u0010&R&\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000(0 8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b)\u0010\"R\u0014\u0010-\u001a\u00020\u00038\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/kizitonwose/calendar/data/DataStore;", "V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "store", "Lkotlin/Function1;", "create", "<init>", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "key", "get", "(I)Ljava/lang/Object;", "value", "put", "(ILjava/lang/Object;)Ljava/lang/Object;", "remove", BuildConfig.FLAVOR, "from", BuildConfig.FLAVOR, "putAll", "(Ljava/util/Map;)V", "clear", "()V", BuildConfig.FLAVOR, "isEmpty", "()Z", "containsKey", "(I)Z", "containsValue", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "Lkotlin/jvm/functions/Function1;", BuildConfig.FLAVOR, "getKeys", "()Ljava/util/Set;", "keys", BuildConfig.FLAVOR, "getValues", "()Ljava/util/Collection;", "values", BuildConfig.FLAVOR, "getEntries", "entries", "getSize", "()I", "size", "data"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DataStore<V> implements Map<Integer, V>, KMutableMap {
    private final Function1<Integer, V> create;
    private final Map<Integer, V> store;

    /* JADX WARN: Multi-variable type inference failed */
    public DataStore(Map<Integer, V> store, Function1<? super Integer, ? extends V> create) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(create, "create");
        this.store = store;
        this.create = create;
    }

    @Override // java.util.Map
    public void clear() {
        this.store.clear();
    }

    public boolean containsKey(int key) {
        return this.store.containsKey(Integer.valueOf(key));
    }

    @Override // java.util.Map
    public boolean containsValue(Object value) {
        return this.store.containsValue(value);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<Integer, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public final /* bridge */ V get(Object obj) {
        if (obj instanceof Integer) {
            return get(((Number) obj).intValue());
        }
        return null;
    }

    public Set<Map.Entry<Integer, V>> getEntries() {
        return this.store.entrySet();
    }

    public Set<Integer> getKeys() {
        return this.store.keySet();
    }

    public int getSize() {
        return this.store.size();
    }

    public Collection<V> getValues() {
        return this.store.values();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.store.isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Integer> keySet() {
        return getKeys();
    }

    public V put(int key, V value) {
        return this.store.put(Integer.valueOf(key), value);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Integer, ? extends V> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        this.store.putAll(from);
    }

    public V remove(int key) {
        return this.store.remove(Integer.valueOf(key));
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof Integer) {
            return containsKey(((Number) obj).intValue());
        }
        return false;
    }

    public V get(int key) {
        V v5 = this.store.get(Integer.valueOf(key));
        if (v5 != null) {
            return v5;
        }
        V invoke = this.create.invoke(Integer.valueOf(key));
        put(key, (int) invoke);
        return invoke;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(Integer num, Object obj) {
        return put(num.intValue(), (int) obj);
    }

    @Override // java.util.Map
    public final /* bridge */ V remove(Object obj) {
        if (obj instanceof Integer) {
            return remove(((Number) obj).intValue());
        }
        return null;
    }

    public /* synthetic */ DataStore(Map map, Function1 function1, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? new HashMap() : map, function1);
    }
}
