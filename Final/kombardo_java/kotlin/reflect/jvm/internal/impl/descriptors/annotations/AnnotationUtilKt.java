package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.conscrypt.BuildConfig;

/* loaded from: classes3.dex */
public abstract class AnnotationUtilKt {
    private static final Name DEPRECATED_LEVEL_NAME;
    private static final Name DEPRECATED_MESSAGE_NAME;
    private static final Name DEPRECATED_REPLACE_WITH_NAME;
    private static final Name REPLACE_WITH_EXPRESSION_NAME;
    private static final Name REPLACE_WITH_IMPORTS_NAME;

    static {
        Name identifier = Name.identifier("message");
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        DEPRECATED_MESSAGE_NAME = identifier;
        Name identifier2 = Name.identifier("replaceWith");
        Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(...)");
        DEPRECATED_REPLACE_WITH_NAME = identifier2;
        Name identifier3 = Name.identifier("level");
        Intrinsics.checkNotNullExpressionValue(identifier3, "identifier(...)");
        DEPRECATED_LEVEL_NAME = identifier3;
        Name identifier4 = Name.identifier("expression");
        Intrinsics.checkNotNullExpressionValue(identifier4, "identifier(...)");
        REPLACE_WITH_EXPRESSION_NAME = identifier4;
        Name identifier5 = Name.identifier("imports");
        Intrinsics.checkNotNullExpressionValue(identifier5, "identifier(...)");
        REPLACE_WITH_IMPORTS_NAME = identifier5;
    }

    public static final AnnotationDescriptor createDeprecatedAnnotation(final KotlinBuiltIns kotlinBuiltIns, String message, String replaceWith, String level, boolean z5) {
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(replaceWith, "replaceWith");
        Intrinsics.checkNotNullParameter(level, "level");
        BuiltInAnnotationDescriptor builtInAnnotationDescriptor = new BuiltInAnnotationDescriptor(kotlinBuiltIns, StandardNames.FqNames.replaceWith, MapsKt.mapOf(TuplesKt.to(REPLACE_WITH_EXPRESSION_NAME, new StringValue(replaceWith)), TuplesKt.to(REPLACE_WITH_IMPORTS_NAME, new ArrayValue(CollectionsKt.emptyList(), new Function1(kotlinBuiltIns) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt$$Lambda$0
            private final KotlinBuiltIns arg$0;

            {
                this.arg$0 = kotlinBuiltIns;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                KotlinType createDeprecatedAnnotation$lambda$0;
                createDeprecatedAnnotation$lambda$0 = AnnotationUtilKt.createDeprecatedAnnotation$lambda$0(this.arg$0, (ModuleDescriptor) obj);
                return createDeprecatedAnnotation$lambda$0;
            }
        }))), false, 8, null);
        FqName fqName = StandardNames.FqNames.deprecated;
        Pair pair = TuplesKt.to(DEPRECATED_MESSAGE_NAME, new StringValue(message));
        Pair pair2 = TuplesKt.to(DEPRECATED_REPLACE_WITH_NAME, new AnnotationValue(builtInAnnotationDescriptor));
        Name name = DEPRECATED_LEVEL_NAME;
        ClassId classId = ClassId.Companion.topLevel(StandardNames.FqNames.deprecationLevel);
        Name identifier = Name.identifier(level);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        return new BuiltInAnnotationDescriptor(kotlinBuiltIns, fqName, MapsKt.mapOf(pair, pair2, TuplesKt.to(name, new EnumValue(classId, identifier))), z5);
    }

    public static /* synthetic */ AnnotationDescriptor createDeprecatedAnnotation$default(KotlinBuiltIns kotlinBuiltIns, String str, String str2, String str3, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str2 = BuildConfig.FLAVOR;
        }
        if ((i5 & 4) != 0) {
            str3 = "WARNING";
        }
        if ((i5 & 8) != 0) {
            z5 = false;
        }
        return createDeprecatedAnnotation(kotlinBuiltIns, str, str2, str3, z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KotlinType createDeprecatedAnnotation$lambda$0(KotlinBuiltIns kotlinBuiltIns, ModuleDescriptor module) {
        Intrinsics.checkNotNullParameter(module, "module");
        SimpleType arrayType = module.getBuiltIns().getArrayType(Variance.INVARIANT, kotlinBuiltIns.getStringType());
        Intrinsics.checkNotNullExpressionValue(arrayType, "getArrayType(...)");
        return arrayType;
    }
}
