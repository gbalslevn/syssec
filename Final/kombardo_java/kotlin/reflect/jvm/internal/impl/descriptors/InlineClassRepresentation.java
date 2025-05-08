package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;

/* loaded from: classes3.dex */
public final class InlineClassRepresentation<Type extends RigidTypeMarker> extends ValueClassRepresentation<Type> {
    private final Name underlyingPropertyName;
    private final Type underlyingType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InlineClassRepresentation(Name underlyingPropertyName, Type underlyingType) {
        super(null);
        Intrinsics.checkNotNullParameter(underlyingPropertyName, "underlyingPropertyName");
        Intrinsics.checkNotNullParameter(underlyingType, "underlyingType");
        this.underlyingPropertyName = underlyingPropertyName;
        this.underlyingType = underlyingType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation
    public boolean containsPropertyWithName(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return Intrinsics.areEqual(this.underlyingPropertyName, name);
    }

    public final Name getUnderlyingPropertyName() {
        return this.underlyingPropertyName;
    }

    public final Type getUnderlyingType() {
        return this.underlyingType;
    }

    public String toString() {
        return "InlineClassRepresentation(underlyingPropertyName=" + this.underlyingPropertyName + ", underlyingType=" + this.underlyingType + ')';
    }
}
