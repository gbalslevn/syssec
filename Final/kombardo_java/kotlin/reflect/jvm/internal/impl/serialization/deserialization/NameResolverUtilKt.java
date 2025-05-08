package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* loaded from: classes3.dex */
public abstract class NameResolverUtilKt {
    public static final ClassId getClassId(NameResolver nameResolver, int i5) {
        Intrinsics.checkNotNullParameter(nameResolver, "<this>");
        return ClassId.Companion.fromString(nameResolver.getQualifiedClassName(i5), nameResolver.isLocalClassName(i5));
    }

    public static final Name getName(NameResolver nameResolver, int i5) {
        Intrinsics.checkNotNullParameter(nameResolver, "<this>");
        Name guessByFirstCharacter = Name.guessByFirstCharacter(nameResolver.getString(i5));
        Intrinsics.checkNotNullExpressionValue(guessByFirstCharacter, "guessByFirstCharacter(...)");
        return guessByFirstCharacter;
    }
}
