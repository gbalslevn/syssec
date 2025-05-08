package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public final class TypeMappingMode {
    public static final TypeMappingMode CLASS_DECLARATION;
    public static final Companion Companion = new Companion(null);
    public static final TypeMappingMode DEFAULT;
    public static final TypeMappingMode DEFAULT_UAST;
    public static final TypeMappingMode GENERIC_ARGUMENT;
    public static final TypeMappingMode GENERIC_ARGUMENT_UAST;
    public static final TypeMappingMode RETURN_TYPE_BOXED;
    public static final TypeMappingMode SUPER_TYPE;
    public static final TypeMappingMode SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS;
    public static final TypeMappingMode VALUE_FOR_ANNOTATION;
    private final TypeMappingMode genericArgumentMode;
    private final TypeMappingMode genericContravariantArgumentMode;
    private final TypeMappingMode genericInvariantArgumentMode;
    private final boolean isForAnnotationParameter;
    private final boolean kotlinCollectionsToJavaCollections;
    private final boolean mapTypeAliases;
    private final boolean needInlineClassWrapping;
    private final boolean needPrimitiveBoxing;
    private final boolean skipDeclarationSiteWildcards;
    private final boolean skipDeclarationSiteWildcardsIfPossible;

    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.values().length];
            try {
                iArr[Variance.IN_VARIANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Variance.INVARIANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        TypeMappingMode typeMappingMode = null;
        boolean z9 = false;
        TypeMappingMode typeMappingMode2 = null;
        TypeMappingMode typeMappingMode3 = null;
        boolean z10 = false;
        TypeMappingMode typeMappingMode4 = new TypeMappingMode(z5, false, z6, z7, z8, typeMappingMode, z9, typeMappingMode2, typeMappingMode3, z10, 1023, defaultConstructorMarker);
        GENERIC_ARGUMENT = typeMappingMode4;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        boolean z16 = false;
        TypeMappingMode typeMappingMode5 = null;
        TypeMappingMode typeMappingMode6 = null;
        boolean z17 = true;
        TypeMappingMode typeMappingMode7 = new TypeMappingMode(z11, z12, z13, z14, z15, null, z16, typeMappingMode5, typeMappingMode6, z17, 511, defaultConstructorMarker2);
        GENERIC_ARGUMENT_UAST = typeMappingMode7;
        RETURN_TYPE_BOXED = new TypeMappingMode(z5, true, z6, z7, z8, typeMappingMode, z9, typeMappingMode2, typeMappingMode3, z10, 1021, defaultConstructorMarker);
        int i5 = 988;
        DEFAULT = new TypeMappingMode(z5, false, z6, z7, z8, typeMappingMode4, z9, typeMappingMode2, typeMappingMode3, z10, i5, defaultConstructorMarker);
        DEFAULT_UAST = new TypeMappingMode(z11, z12, z13, z14, z15, typeMappingMode7, z16, typeMappingMode5, typeMappingMode6, z17, 476, defaultConstructorMarker2);
        CLASS_DECLARATION = new TypeMappingMode(z5, true, z6, z7, z8, typeMappingMode4, z9, typeMappingMode2, typeMappingMode3, z10, i5, defaultConstructorMarker);
        boolean z18 = false;
        boolean z19 = true;
        SUPER_TYPE = new TypeMappingMode(z5, z18, z6, z19, z8, typeMappingMode4, z9, typeMappingMode2, typeMappingMode3, z10, 983, defaultConstructorMarker);
        SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS = new TypeMappingMode(z5, z18, z6, z19, z8, typeMappingMode4, z9, typeMappingMode2, typeMappingMode3, z10, 919, defaultConstructorMarker);
        VALUE_FOR_ANNOTATION = new TypeMappingMode(z5, z18, true, false, z8, typeMappingMode4, z9, typeMappingMode2, typeMappingMode3, z10, 984, defaultConstructorMarker);
    }

    public TypeMappingMode(boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, TypeMappingMode typeMappingMode, boolean z10, TypeMappingMode typeMappingMode2, TypeMappingMode typeMappingMode3, boolean z11) {
        this.needPrimitiveBoxing = z5;
        this.needInlineClassWrapping = z6;
        this.isForAnnotationParameter = z7;
        this.skipDeclarationSiteWildcards = z8;
        this.skipDeclarationSiteWildcardsIfPossible = z9;
        this.genericArgumentMode = typeMappingMode;
        this.kotlinCollectionsToJavaCollections = z10;
        this.genericContravariantArgumentMode = typeMappingMode2;
        this.genericInvariantArgumentMode = typeMappingMode3;
        this.mapTypeAliases = z11;
    }

    public final boolean getKotlinCollectionsToJavaCollections() {
        return this.kotlinCollectionsToJavaCollections;
    }

    public final boolean getMapTypeAliases() {
        return this.mapTypeAliases;
    }

    public final boolean getNeedInlineClassWrapping() {
        return this.needInlineClassWrapping;
    }

    public final boolean getNeedPrimitiveBoxing() {
        return this.needPrimitiveBoxing;
    }

    public final boolean isForAnnotationParameter() {
        return this.isForAnnotationParameter;
    }

    public final TypeMappingMode toGenericArgumentMode(Variance effectiveVariance, boolean z5) {
        Intrinsics.checkNotNullParameter(effectiveVariance, "effectiveVariance");
        if (!z5 || !this.isForAnnotationParameter) {
            int i5 = WhenMappings.$EnumSwitchMapping$0[effectiveVariance.ordinal()];
            if (i5 == 1) {
                TypeMappingMode typeMappingMode = this.genericContravariantArgumentMode;
                if (typeMappingMode != null) {
                    return typeMappingMode;
                }
            } else if (i5 != 2) {
                TypeMappingMode typeMappingMode2 = this.genericArgumentMode;
                if (typeMappingMode2 != null) {
                    return typeMappingMode2;
                }
            } else {
                TypeMappingMode typeMappingMode3 = this.genericInvariantArgumentMode;
                if (typeMappingMode3 != null) {
                    return typeMappingMode3;
                }
            }
        }
        return this;
    }

    public final TypeMappingMode wrapInlineClassesMode() {
        return new TypeMappingMode(this.needPrimitiveBoxing, true, this.isForAnnotationParameter, this.skipDeclarationSiteWildcards, this.skipDeclarationSiteWildcardsIfPossible, this.genericArgumentMode, this.kotlinCollectionsToJavaCollections, this.genericContravariantArgumentMode, this.genericInvariantArgumentMode, false, 512, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ TypeMappingMode(boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, TypeMappingMode typeMappingMode, boolean z10, TypeMappingMode typeMappingMode2, TypeMappingMode typeMappingMode3, boolean z11, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r3, r4, r6, r7, r8, (i5 & 64) == 0 ? z10 : true, (i5 & 128) != 0 ? r8 : typeMappingMode2, (i5 & 256) != 0 ? r8 : typeMappingMode3, (i5 & 512) == 0 ? z11 : false);
        boolean z12 = (i5 & 1) != 0 ? true : z5;
        boolean z13 = (i5 & 2) != 0 ? true : z6;
        boolean z14 = (i5 & 4) != 0 ? false : z7;
        boolean z15 = (i5 & 8) != 0 ? false : z8;
        boolean z16 = (i5 & 16) != 0 ? false : z9;
        TypeMappingMode typeMappingMode4 = (i5 & 32) != 0 ? null : typeMappingMode;
    }
}
