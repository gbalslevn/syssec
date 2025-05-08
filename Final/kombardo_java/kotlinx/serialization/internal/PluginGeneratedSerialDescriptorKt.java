package kotlinx.serialization.internal;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorKt;
import kotlinx.serialization.descriptors.SerialKind;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a!\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/serialization/descriptors/SerialDescriptor;", BuildConfig.FLAVOR, "typeParams", BuildConfig.FLAVOR, "hashCodeImpl", "(Lkotlinx/serialization/descriptors/SerialDescriptor;[Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "kotlinx-serialization-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class PluginGeneratedSerialDescriptorKt {
    public static final int hashCodeImpl(SerialDescriptor serialDescriptor, SerialDescriptor[] typeParams) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(typeParams, "typeParams");
        int hashCode = (serialDescriptor.getSerialName().hashCode() * 31) + Arrays.hashCode(typeParams);
        Iterable<SerialDescriptor> elementDescriptors = SerialDescriptorKt.getElementDescriptors(serialDescriptor);
        Iterator<SerialDescriptor> it = elementDescriptors.iterator();
        int i5 = 1;
        int i6 = 1;
        while (true) {
            int i7 = 0;
            if (!it.hasNext()) {
                break;
            }
            int i8 = i6 * 31;
            String serialName = it.next().getSerialName();
            if (serialName != null) {
                i7 = serialName.hashCode();
            }
            i6 = i8 + i7;
        }
        Iterator<SerialDescriptor> it2 = elementDescriptors.iterator();
        while (it2.hasNext()) {
            int i9 = i5 * 31;
            SerialKind kind = it2.next().getKind();
            i5 = i9 + (kind != null ? kind.hashCode() : 0);
        }
        return (((hashCode * 31) + i6) * 31) + i5;
    }
}
