package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* loaded from: classes3.dex */
public abstract class DescriptorRenderer {
    public static final DescriptorRenderer COMPACT;
    public static final DescriptorRenderer COMPACT_WITHOUT_SUPERTYPES;
    public static final DescriptorRenderer COMPACT_WITH_MODIFIERS;
    public static final DescriptorRenderer COMPACT_WITH_SHORT_TYPES;
    public static final Companion Companion;
    public static final DescriptorRenderer DEBUG_TEXT;
    public static final DescriptorRenderer FQ_NAMES_IN_TYPES;
    public static final DescriptorRenderer FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS;
    public static final DescriptorRenderer HTML;
    public static final DescriptorRenderer ONLY_NAMES_WITH_SHORT_TYPES;
    public static final DescriptorRenderer SHORT_NAMES_IN_TYPES;
    public static final DescriptorRenderer WITHOUT_MODIFIERS;

    /* loaded from: classes3.dex */
    public static final class Companion {

        /* loaded from: classes3.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ClassKind.values().length];
                try {
                    iArr[ClassKind.CLASS.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ClassKind.INTERFACE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ClassKind.ENUM_CLASS.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ClassKind.OBJECT.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[ClassKind.ANNOTATION_CLASS.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[ClassKind.ENUM_ENTRY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getClassifierKindPrefix(ClassifierDescriptorWithTypeParameters classifier) {
            Intrinsics.checkNotNullParameter(classifier, "classifier");
            if (classifier instanceof TypeAliasDescriptor) {
                return "typealias";
            }
            if (!(classifier instanceof ClassDescriptor)) {
                throw new AssertionError("Unexpected classifier: " + classifier);
            }
            ClassDescriptor classDescriptor = (ClassDescriptor) classifier;
            if (classDescriptor.isCompanionObject()) {
                return "companion object";
            }
            switch (WhenMappings.$EnumSwitchMapping$0[classDescriptor.getKind().ordinal()]) {
                case 1:
                    return "class";
                case 2:
                    return "interface";
                case 3:
                    return "enum class";
                case 4:
                    return "object";
                case 5:
                    return "annotation class";
                case 6:
                    return "enum entry";
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        public final DescriptorRenderer withOptions(Function1<? super DescriptorRendererOptions, Unit> changeOptions) {
            Intrinsics.checkNotNullParameter(changeOptions, "changeOptions");
            DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = new DescriptorRendererOptionsImpl();
            changeOptions.invoke(descriptorRendererOptionsImpl);
            descriptorRendererOptionsImpl.lock();
            return new DescriptorRendererImpl(descriptorRendererOptionsImpl);
        }

        private Companion() {
        }
    }

    /* loaded from: classes3.dex */
    public interface ValueParametersHandler {

        /* loaded from: classes3.dex */
        public static final class DEFAULT implements ValueParametersHandler {
            public static final DEFAULT INSTANCE = new DEFAULT();

            private DEFAULT() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendAfterValueParameter(ValueParameterDescriptor parameter, int i5, int i6, StringBuilder builder) {
                Intrinsics.checkNotNullParameter(parameter, "parameter");
                Intrinsics.checkNotNullParameter(builder, "builder");
                if (i5 != i6 - 1) {
                    builder.append(", ");
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendAfterValueParameters(int i5, StringBuilder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                builder.append(")");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendBeforeValueParameter(ValueParameterDescriptor parameter, int i5, int i6, StringBuilder builder) {
                Intrinsics.checkNotNullParameter(parameter, "parameter");
                Intrinsics.checkNotNullParameter(builder, "builder");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendBeforeValueParameters(int i5, StringBuilder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                builder.append("(");
            }
        }

        void appendAfterValueParameter(ValueParameterDescriptor valueParameterDescriptor, int i5, int i6, StringBuilder sb);

        void appendAfterValueParameters(int i5, StringBuilder sb);

        void appendBeforeValueParameter(ValueParameterDescriptor valueParameterDescriptor, int i5, int i6, StringBuilder sb);

        void appendBeforeValueParameters(int i5, StringBuilder sb);
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        WITHOUT_MODIFIERS = companion.withOptions(new Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit WITHOUT_MODIFIERS$lambda$0;
                WITHOUT_MODIFIERS$lambda$0 = DescriptorRenderer.WITHOUT_MODIFIERS$lambda$0((DescriptorRendererOptions) obj);
                return WITHOUT_MODIFIERS$lambda$0;
            }
        });
        COMPACT_WITH_MODIFIERS = companion.withOptions(new Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$1
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit COMPACT_WITH_MODIFIERS$lambda$1;
                COMPACT_WITH_MODIFIERS$lambda$1 = DescriptorRenderer.COMPACT_WITH_MODIFIERS$lambda$1((DescriptorRendererOptions) obj);
                return COMPACT_WITH_MODIFIERS$lambda$1;
            }
        });
        COMPACT = companion.withOptions(new Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$2
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit COMPACT$lambda$2;
                COMPACT$lambda$2 = DescriptorRenderer.COMPACT$lambda$2((DescriptorRendererOptions) obj);
                return COMPACT$lambda$2;
            }
        });
        COMPACT_WITHOUT_SUPERTYPES = companion.withOptions(new Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$3
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit COMPACT_WITHOUT_SUPERTYPES$lambda$3;
                COMPACT_WITHOUT_SUPERTYPES$lambda$3 = DescriptorRenderer.COMPACT_WITHOUT_SUPERTYPES$lambda$3((DescriptorRendererOptions) obj);
                return COMPACT_WITHOUT_SUPERTYPES$lambda$3;
            }
        });
        COMPACT_WITH_SHORT_TYPES = companion.withOptions(new Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$4
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit COMPACT_WITH_SHORT_TYPES$lambda$4;
                COMPACT_WITH_SHORT_TYPES$lambda$4 = DescriptorRenderer.COMPACT_WITH_SHORT_TYPES$lambda$4((DescriptorRendererOptions) obj);
                return COMPACT_WITH_SHORT_TYPES$lambda$4;
            }
        });
        ONLY_NAMES_WITH_SHORT_TYPES = companion.withOptions(new Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$5
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit ONLY_NAMES_WITH_SHORT_TYPES$lambda$5;
                ONLY_NAMES_WITH_SHORT_TYPES$lambda$5 = DescriptorRenderer.ONLY_NAMES_WITH_SHORT_TYPES$lambda$5((DescriptorRendererOptions) obj);
                return ONLY_NAMES_WITH_SHORT_TYPES$lambda$5;
            }
        });
        FQ_NAMES_IN_TYPES = companion.withOptions(new Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$6
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit FQ_NAMES_IN_TYPES$lambda$6;
                FQ_NAMES_IN_TYPES$lambda$6 = DescriptorRenderer.FQ_NAMES_IN_TYPES$lambda$6((DescriptorRendererOptions) obj);
                return FQ_NAMES_IN_TYPES$lambda$6;
            }
        });
        FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS = companion.withOptions(new Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$7
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS$lambda$7;
                FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS$lambda$7 = DescriptorRenderer.FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS$lambda$7((DescriptorRendererOptions) obj);
                return FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS$lambda$7;
            }
        });
        SHORT_NAMES_IN_TYPES = companion.withOptions(new Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$8
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit SHORT_NAMES_IN_TYPES$lambda$8;
                SHORT_NAMES_IN_TYPES$lambda$8 = DescriptorRenderer.SHORT_NAMES_IN_TYPES$lambda$8((DescriptorRendererOptions) obj);
                return SHORT_NAMES_IN_TYPES$lambda$8;
            }
        });
        DEBUG_TEXT = companion.withOptions(new Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$9
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit DEBUG_TEXT$lambda$9;
                DEBUG_TEXT$lambda$9 = DescriptorRenderer.DEBUG_TEXT$lambda$9((DescriptorRendererOptions) obj);
                return DEBUG_TEXT$lambda$9;
            }
        });
        HTML = companion.withOptions(new Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$10
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit HTML$lambda$10;
                HTML$lambda$10 = DescriptorRenderer.HTML$lambda$10((DescriptorRendererOptions) obj);
                return HTML$lambda$10;
            }
        });
    }

    public static final Unit COMPACT$lambda$2(DescriptorRendererOptions withOptions) {
        Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setWithDefinedIn(false);
        withOptions.setModifiers(SetsKt.emptySet());
        return Unit.INSTANCE;
    }

    public static final Unit COMPACT_WITHOUT_SUPERTYPES$lambda$3(DescriptorRendererOptions withOptions) {
        Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setWithDefinedIn(false);
        withOptions.setModifiers(SetsKt.emptySet());
        withOptions.setWithoutSuperTypes(true);
        return Unit.INSTANCE;
    }

    public static final Unit COMPACT_WITH_MODIFIERS$lambda$1(DescriptorRendererOptions withOptions) {
        Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setWithDefinedIn(false);
        return Unit.INSTANCE;
    }

    public static final Unit COMPACT_WITH_SHORT_TYPES$lambda$4(DescriptorRendererOptions withOptions) {
        Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setModifiers(SetsKt.emptySet());
        withOptions.setClassifierNamePolicy(ClassifierNamePolicy.SHORT.INSTANCE);
        withOptions.setParameterNameRenderingPolicy(ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED);
        return Unit.INSTANCE;
    }

    public static final Unit DEBUG_TEXT$lambda$9(DescriptorRendererOptions withOptions) {
        Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setDebugMode(true);
        withOptions.setClassifierNamePolicy(ClassifierNamePolicy.FULLY_QUALIFIED.INSTANCE);
        withOptions.setModifiers(DescriptorRendererModifier.ALL);
        return Unit.INSTANCE;
    }

    public static final Unit FQ_NAMES_IN_TYPES$lambda$6(DescriptorRendererOptions withOptions) {
        Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setModifiers(DescriptorRendererModifier.ALL_EXCEPT_ANNOTATIONS);
        return Unit.INSTANCE;
    }

    public static final Unit FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS$lambda$7(DescriptorRendererOptions withOptions) {
        Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setModifiers(DescriptorRendererModifier.ALL);
        return Unit.INSTANCE;
    }

    public static final Unit HTML$lambda$10(DescriptorRendererOptions withOptions) {
        Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setTextFormat(RenderingFormat.HTML);
        withOptions.setModifiers(DescriptorRendererModifier.ALL);
        return Unit.INSTANCE;
    }

    public static final Unit ONLY_NAMES_WITH_SHORT_TYPES$lambda$5(DescriptorRendererOptions withOptions) {
        Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setWithDefinedIn(false);
        withOptions.setModifiers(SetsKt.emptySet());
        withOptions.setClassifierNamePolicy(ClassifierNamePolicy.SHORT.INSTANCE);
        withOptions.setWithoutTypeParameters(true);
        withOptions.setParameterNameRenderingPolicy(ParameterNameRenderingPolicy.NONE);
        withOptions.setReceiverAfterName(true);
        withOptions.setRenderCompanionObjectName(true);
        withOptions.setWithoutSuperTypes(true);
        withOptions.setStartFromName(true);
        return Unit.INSTANCE;
    }

    public static final Unit SHORT_NAMES_IN_TYPES$lambda$8(DescriptorRendererOptions withOptions) {
        Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setClassifierNamePolicy(ClassifierNamePolicy.SHORT.INSTANCE);
        withOptions.setParameterNameRenderingPolicy(ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED);
        return Unit.INSTANCE;
    }

    public static final Unit WITHOUT_MODIFIERS$lambda$0(DescriptorRendererOptions withOptions) {
        Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setModifiers(SetsKt.emptySet());
        return Unit.INSTANCE;
    }

    public static /* synthetic */ String renderAnnotation$default(DescriptorRenderer descriptorRenderer, AnnotationDescriptor annotationDescriptor, AnnotationUseSiteTarget annotationUseSiteTarget, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderAnnotation");
        }
        if ((i5 & 2) != 0) {
            annotationUseSiteTarget = null;
        }
        return descriptorRenderer.renderAnnotation(annotationDescriptor, annotationUseSiteTarget);
    }

    public abstract String render(DeclarationDescriptor declarationDescriptor);

    public abstract String renderAnnotation(AnnotationDescriptor annotationDescriptor, AnnotationUseSiteTarget annotationUseSiteTarget);

    public abstract String renderFlexibleType(String str, String str2, KotlinBuiltIns kotlinBuiltIns);

    public abstract String renderFqName(FqNameUnsafe fqNameUnsafe);

    public abstract String renderName(Name name, boolean z5);

    public abstract String renderType(KotlinType kotlinType);

    public abstract String renderTypeProjection(TypeProjection typeProjection);

    public final DescriptorRenderer withOptions(Function1<? super DescriptorRendererOptions, Unit> changeOptions) {
        Intrinsics.checkNotNullParameter(changeOptions, "changeOptions");
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
        DescriptorRendererOptionsImpl copy = ((DescriptorRendererImpl) this).getOptions().copy();
        changeOptions.invoke(copy);
        copy.lock();
        return new DescriptorRendererImpl(copy);
    }
}
