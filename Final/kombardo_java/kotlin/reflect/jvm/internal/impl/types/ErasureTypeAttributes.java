package kotlin.reflect.jvm.internal.impl.types;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* loaded from: classes3.dex */
public abstract class ErasureTypeAttributes {
    private final SimpleType defaultType;
    private final TypeUsage howThisTypeIsUsed;
    private final Set<TypeParameterDescriptor> visitedTypeParameters;

    /* JADX WARN: Multi-variable type inference failed */
    public ErasureTypeAttributes(TypeUsage howThisTypeIsUsed, Set<? extends TypeParameterDescriptor> set, SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(howThisTypeIsUsed, "howThisTypeIsUsed");
        this.howThisTypeIsUsed = howThisTypeIsUsed;
        this.visitedTypeParameters = set;
        this.defaultType = simpleType;
    }

    public abstract SimpleType getDefaultType();

    public abstract TypeUsage getHowThisTypeIsUsed();

    public abstract Set<TypeParameterDescriptor> getVisitedTypeParameters();

    public abstract int hashCode();

    public abstract ErasureTypeAttributes withNewVisitedTypeParameter(TypeParameterDescriptor typeParameterDescriptor);
}
