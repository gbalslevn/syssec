package kotlin.reflect.jvm.internal.impl.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public abstract class AttributeArrayOwner<K, T> extends AbstractArrayMapOwner<K, T> {
    private ArrayMap<T> arrayMap;

    protected AttributeArrayOwner(ArrayMap<T> arrayMap) {
        Intrinsics.checkNotNullParameter(arrayMap, "arrayMap");
        this.arrayMap = arrayMap;
    }

    private final String buildDiagnosticMessage(ArrayMap<T> arrayMap, int i5, String str) {
        T t5;
        StringBuilder sb = new StringBuilder();
        sb.append("Race condition happened, the size of ArrayMap is " + i5 + " but it isn't an `" + str + '`');
        sb.append('\n');
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Type: ");
        sb2.append(arrayMap.getClass());
        sb.append(sb2.toString());
        sb.append('\n');
        StringBuilder sb3 = new StringBuilder();
        Map<String, Integer> allValuesThreadUnsafeForRendering = getTypeRegistry().allValuesThreadUnsafeForRendering();
        sb3.append("[");
        sb3.append('\n');
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayMap, 10));
        int i6 = 0;
        for (T t6 : arrayMap) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Iterator<T> it = allValuesThreadUnsafeForRendering.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    t5 = null;
                    break;
                }
                t5 = it.next();
                if (((Number) ((Map.Entry) t5).getValue()).intValue() == i6) {
                    break;
                }
            }
            sb3.append("  " + ((Map.Entry) t5) + '[' + i6 + "]: " + t6);
            sb3.append('\n');
            arrayList.add(sb3);
            i6 = i7;
        }
        sb3.append("]");
        sb3.append('\n');
        sb.append("Content: " + sb3.toString());
        sb.append('\n');
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner
    public final ArrayMap<T> getArrayMap() {
        return this.arrayMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner
    protected final void registerComponent(String keyQualifiedName, T value) {
        Intrinsics.checkNotNullParameter(keyQualifiedName, "keyQualifiedName");
        Intrinsics.checkNotNullParameter(value, "value");
        int id = getTypeRegistry().getId(keyQualifiedName);
        int size = this.arrayMap.getSize();
        if (size == 0) {
            ArrayMap<T> arrayMap = this.arrayMap;
            if (!(arrayMap instanceof EmptyArrayMap)) {
                throw new IllegalStateException(buildDiagnosticMessage(arrayMap, 0, "EmptyArrayMap"));
            }
            this.arrayMap = new OneElementArrayMap(value, id);
            return;
        }
        if (size == 1) {
            ArrayMap<T> arrayMap2 = this.arrayMap;
            try {
                Intrinsics.checkNotNull(arrayMap2, "null cannot be cast to non-null type org.jetbrains.kotlin.util.OneElementArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
                OneElementArrayMap oneElementArrayMap = (OneElementArrayMap) arrayMap2;
                if (oneElementArrayMap.getIndex() == id) {
                    this.arrayMap = new OneElementArrayMap(value, id);
                    return;
                } else {
                    ArrayMapImpl arrayMapImpl = new ArrayMapImpl();
                    this.arrayMap = arrayMapImpl;
                    arrayMapImpl.set(oneElementArrayMap.getIndex(), oneElementArrayMap.getValue());
                }
            } catch (ClassCastException e5) {
                throw new IllegalStateException(buildDiagnosticMessage(arrayMap2, 1, "OneElementArrayMap"), e5);
            }
        }
        this.arrayMap.set(id, value);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AttributeArrayOwner() {
        this(r0);
        EmptyArrayMap emptyArrayMap = EmptyArrayMap.INSTANCE;
        Intrinsics.checkNotNull(emptyArrayMap, "null cannot be cast to non-null type org.jetbrains.kotlin.util.ArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
    }
}
