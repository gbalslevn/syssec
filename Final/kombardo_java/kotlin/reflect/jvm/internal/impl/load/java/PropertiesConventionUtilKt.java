package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.text.StringsKt;

/* loaded from: classes3.dex */
public abstract class PropertiesConventionUtilKt {
    public static final List<Name> getPropertyNamesCandidatesByAccessorName(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        String asString = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        return JvmAbi.isGetterName(asString) ? CollectionsKt.listOfNotNull(propertyNameByGetMethodName(name)) : JvmAbi.isSetterName(asString) ? propertyNamesBySetMethodName(name) : BuiltinSpecialProperties.INSTANCE.getPropertyNameCandidatesBySpecialGetterName(name);
    }

    public static final Name propertyNameByGetMethodName(Name methodName) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Name propertyNameFromAccessorMethodName$default = propertyNameFromAccessorMethodName$default(methodName, "get", false, null, 12, null);
        return propertyNameFromAccessorMethodName$default == null ? propertyNameFromAccessorMethodName$default(methodName, "is", false, null, 8, null) : propertyNameFromAccessorMethodName$default;
    }

    public static final Name propertyNameBySetMethodName(Name methodName, boolean z5) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        return propertyNameFromAccessorMethodName$default(methodName, "set", false, z5 ? "is" : null, 4, null);
    }

    private static final Name propertyNameFromAccessorMethodName(Name name, String str, boolean z5, String str2) {
        if (name.isSpecial()) {
            return null;
        }
        String identifier = name.getIdentifier();
        Intrinsics.checkNotNullExpressionValue(identifier, "getIdentifier(...)");
        if (!StringsKt.startsWith$default(identifier, str, false, 2, (Object) null) || identifier.length() == str.length()) {
            return null;
        }
        char charAt = identifier.charAt(str.length());
        if ('a' <= charAt && charAt < '{') {
            return null;
        }
        if (str2 != null) {
            return Name.identifier(str2 + StringsKt.removePrefix(identifier, str));
        }
        if (!z5) {
            return name;
        }
        String decapitalizeSmartForCompiler = CapitalizeDecapitalizeKt.decapitalizeSmartForCompiler(StringsKt.removePrefix(identifier, str), true);
        if (Name.isValidIdentifier(decapitalizeSmartForCompiler)) {
            return Name.identifier(decapitalizeSmartForCompiler);
        }
        return null;
    }

    static /* synthetic */ Name propertyNameFromAccessorMethodName$default(Name name, String str, boolean z5, String str2, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            z5 = true;
        }
        if ((i5 & 8) != 0) {
            str2 = null;
        }
        return propertyNameFromAccessorMethodName(name, str, z5, str2);
    }

    public static final List<Name> propertyNamesBySetMethodName(Name methodName) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        return CollectionsKt.listOfNotNull((Object[]) new Name[]{propertyNameBySetMethodName(methodName, false), propertyNameBySetMethodName(methodName, true)});
    }
}
