package kotlinx.serialization.json.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0003J\r\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0003J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0015R\u001e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lkotlinx/serialization/json/internal/JsonPath;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "resize", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "sd", "pushDescriptor", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", BuildConfig.FLAVOR, "index", "updateDescriptorIndex", "(I)V", "key", "updateCurrentMapKey", "(Ljava/lang/Object;)V", "resetCurrentMapKey", "popDescriptor", BuildConfig.FLAVOR, "getPath", "()Ljava/lang/String;", "toString", BuildConfig.FLAVOR, "currentObjectPath", "[Ljava/lang/Object;", BuildConfig.FLAVOR, "indicies", "[I", "currentDepth", "I", "Tombstone", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class JsonPath {
    private int currentDepth;
    private Object[] currentObjectPath = new Object[8];
    private int[] indicies;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/serialization/json/internal/JsonPath$Tombstone;", BuildConfig.FLAVOR, "()V", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Tombstone {
        public static final Tombstone INSTANCE = new Tombstone();

        private Tombstone() {
        }
    }

    public JsonPath() {
        int[] iArr = new int[8];
        for (int i5 = 0; i5 < 8; i5++) {
            iArr[i5] = -1;
        }
        this.indicies = iArr;
        this.currentDepth = -1;
    }

    private final void resize() {
        int i5 = this.currentDepth * 2;
        Object[] copyOf = Arrays.copyOf(this.currentObjectPath, i5);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        this.currentObjectPath = copyOf;
        int[] copyOf2 = Arrays.copyOf(this.indicies, i5);
        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(...)");
        this.indicies = copyOf2;
    }

    public final String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append("$");
        int i5 = this.currentDepth + 1;
        for (int i6 = 0; i6 < i5; i6++) {
            Object obj = this.currentObjectPath[i6];
            if (obj instanceof SerialDescriptor) {
                SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
                if (!Intrinsics.areEqual(serialDescriptor.getKind(), StructureKind.LIST.INSTANCE)) {
                    int i7 = this.indicies[i6];
                    if (i7 >= 0) {
                        sb.append(".");
                        sb.append(serialDescriptor.getElementName(i7));
                    }
                } else if (this.indicies[i6] != -1) {
                    sb.append("[");
                    sb.append(this.indicies[i6]);
                    sb.append("]");
                }
            } else if (obj != Tombstone.INSTANCE) {
                sb.append("[");
                sb.append("'");
                sb.append(obj);
                sb.append("'");
                sb.append("]");
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final void popDescriptor() {
        int i5 = this.currentDepth;
        int[] iArr = this.indicies;
        if (iArr[i5] == -2) {
            iArr[i5] = -1;
            this.currentDepth = i5 - 1;
        }
        int i6 = this.currentDepth;
        if (i6 != -1) {
            this.currentDepth = i6 - 1;
        }
    }

    public final void pushDescriptor(SerialDescriptor sd) {
        Intrinsics.checkNotNullParameter(sd, "sd");
        int i5 = this.currentDepth + 1;
        this.currentDepth = i5;
        if (i5 == this.currentObjectPath.length) {
            resize();
        }
        this.currentObjectPath[i5] = sd;
    }

    public final void resetCurrentMapKey() {
        int[] iArr = this.indicies;
        int i5 = this.currentDepth;
        if (iArr[i5] == -2) {
            this.currentObjectPath[i5] = Tombstone.INSTANCE;
        }
    }

    public String toString() {
        return getPath();
    }

    public final void updateCurrentMapKey(Object key) {
        int[] iArr = this.indicies;
        int i5 = this.currentDepth;
        if (iArr[i5] != -2) {
            int i6 = i5 + 1;
            this.currentDepth = i6;
            if (i6 == this.currentObjectPath.length) {
                resize();
            }
        }
        Object[] objArr = this.currentObjectPath;
        int i7 = this.currentDepth;
        objArr[i7] = key;
        this.indicies[i7] = -2;
    }

    public final void updateDescriptorIndex(int index) {
        this.indicies[this.currentDepth] = index;
    }
}
