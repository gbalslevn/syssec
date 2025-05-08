package kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.CachedNames;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptorKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0018\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0096\u0002J\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020\u00140\n2\u0006\u00101\u001a\u00020\bH\u0016J\u0010\u00102\u001a\u00020\u00012\u0006\u00101\u001a\u00020\bH\u0016J\u0010\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\u0004H\u0016J\u0010\u00105\u001a\u00020\u00042\u0006\u00101\u001a\u00020\bH\u0016J\b\u00106\u001a\u00020\bH\u0016J\u0010\u00107\u001a\u00020-2\u0006\u00101\u001a\u00020\bH\u0016J\b\u00108\u001a\u00020\u0004H\u0016R\u001b\u0010\u000e\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\n0\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040(X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001b¨\u00069"}, d2 = {"Lkotlinx/serialization/descriptors/SerialDescriptorImpl;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/internal/CachedNames;", "serialName", BuildConfig.FLAVOR, "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "elementsCount", BuildConfig.FLAVOR, "typeParameters", BuildConfig.FLAVOR, "builder", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialKind;ILjava/util/List;Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;)V", "_hashCode", "get_hashCode", "()I", "_hashCode$delegate", "Lkotlin/Lazy;", "annotations", BuildConfig.FLAVOR, "getAnnotations", "()Ljava/util/List;", "elementAnnotations", BuildConfig.FLAVOR, "[Ljava/util/List;", "elementDescriptors", "[Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementNames", "[Ljava/lang/String;", "elementOptionality", BuildConfig.FLAVOR, "getElementsCount", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "name2Index", BuildConfig.FLAVOR, "getSerialName", "()Ljava/lang/String;", "serialNames", BuildConfig.FLAVOR, "getSerialNames", "()Ljava/util/Set;", "typeParametersDescriptors", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "hashCode", "isElementOptional", "toString", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SerialDescriptorImpl implements SerialDescriptor, CachedNames {

    /* renamed from: _hashCode$delegate, reason: from kotlin metadata */
    private final Lazy _hashCode;
    private final List<Annotation> annotations;
    private final List<Annotation>[] elementAnnotations;
    private final SerialDescriptor[] elementDescriptors;
    private final String[] elementNames;
    private final boolean[] elementOptionality;
    private final int elementsCount;
    private final SerialKind kind;
    private final Map<String, Integer> name2Index;
    private final String serialName;
    private final Set<String> serialNames;
    private final SerialDescriptor[] typeParametersDescriptors;

    public SerialDescriptorImpl(String serialName, SerialKind kind, int i5, List<? extends SerialDescriptor> typeParameters, ClassSerialDescriptorBuilder builder) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.serialName = serialName;
        this.kind = kind;
        this.elementsCount = i5;
        this.annotations = builder.getAnnotations();
        this.serialNames = CollectionsKt.toHashSet(builder.getElementNames$kotlinx_serialization_core());
        String[] strArr = (String[]) builder.getElementNames$kotlinx_serialization_core().toArray(new String[0]);
        this.elementNames = strArr;
        this.elementDescriptors = Platform_commonKt.compactArray(builder.getElementDescriptors$kotlinx_serialization_core());
        this.elementAnnotations = (List[]) builder.getElementAnnotations$kotlinx_serialization_core().toArray(new List[0]);
        this.elementOptionality = CollectionsKt.toBooleanArray(builder.getElementOptionality$kotlinx_serialization_core());
        Iterable<IndexedValue> withIndex = ArraysKt.withIndex(strArr);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(withIndex, 10));
        for (IndexedValue indexedValue : withIndex) {
            arrayList.add(TuplesKt.to(indexedValue.getValue(), Integer.valueOf(indexedValue.getIndex())));
        }
        this.name2Index = MapsKt.toMap(arrayList);
        this.typeParametersDescriptors = Platform_commonKt.compactArray(typeParameters);
        this._hashCode = LazyKt.lazy(new Function0<Integer>() { // from class: kotlinx.serialization.descriptors.SerialDescriptorImpl$_hashCode$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                SerialDescriptor[] serialDescriptorArr;
                SerialDescriptorImpl serialDescriptorImpl = SerialDescriptorImpl.this;
                serialDescriptorArr = serialDescriptorImpl.typeParametersDescriptors;
                return Integer.valueOf(PluginGeneratedSerialDescriptorKt.hashCodeImpl(serialDescriptorImpl, serialDescriptorArr));
            }
        });
    }

    private final int get_hashCode() {
        return ((Number) this._hashCode.getValue()).intValue();
    }

    public boolean equals(Object other) {
        int i5;
        if (this == other) {
            return true;
        }
        if (other instanceof SerialDescriptorImpl) {
            SerialDescriptor serialDescriptor = (SerialDescriptor) other;
            if (Intrinsics.areEqual(getSerialName(), serialDescriptor.getSerialName()) && Arrays.equals(this.typeParametersDescriptors, ((SerialDescriptorImpl) other).typeParametersDescriptors) && getElementsCount() == serialDescriptor.getElementsCount()) {
                int elementsCount = getElementsCount();
                for (0; i5 < elementsCount; i5 + 1) {
                    i5 = (Intrinsics.areEqual(getElementDescriptor(i5).getSerialName(), serialDescriptor.getElementDescriptor(i5).getSerialName()) && Intrinsics.areEqual(getElementDescriptor(i5).getKind(), serialDescriptor.getElementDescriptor(i5).getKind())) ? i5 + 1 : 0;
                }
                return true;
            }
        }
        return false;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> getAnnotations() {
        return this.annotations;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> getElementAnnotations(int index) {
        return this.elementAnnotations[index];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor getElementDescriptor(int index) {
        return this.elementDescriptors[index];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementIndex(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Integer num = this.name2Index.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String getElementName(int index) {
        return this.elementNames[index];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementsCount() {
        return this.elementsCount;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind getKind() {
        return this.kind;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String getSerialName() {
        return this.serialName;
    }

    @Override // kotlinx.serialization.internal.CachedNames
    public Set<String> getSerialNames() {
        return this.serialNames;
    }

    public int hashCode() {
        return get_hashCode();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isElementOptional(int index) {
        return this.elementOptionality[index];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    /* renamed from: isInline */
    public boolean getIsInline() {
        return SerialDescriptor.DefaultImpls.isInline(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isNullable() {
        return SerialDescriptor.DefaultImpls.isNullable(this);
    }

    public String toString() {
        return CollectionsKt.joinToString$default(RangesKt.until(0, getElementsCount()), ", ", getSerialName() + '(', ")", 0, null, new Function1<Integer, CharSequence>() { // from class: kotlinx.serialization.descriptors.SerialDescriptorImpl$toString$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final CharSequence invoke(int i5) {
                return SerialDescriptorImpl.this.getElementName(i5) + ": " + SerialDescriptorImpl.this.getElementDescriptor(i5).getSerialName();
            }
        }, 24, null);
    }
}
