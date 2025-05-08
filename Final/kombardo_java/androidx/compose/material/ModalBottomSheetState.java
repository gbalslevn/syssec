package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 /2\u00020\u0001:\u0001/BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u000fH\u0080@¢\u0006\u0004\b\u0012\u0010\u0011J\u0010\u0010\u0014\u001a\u00020\u000fH\u0086@¢\u0006\u0004\b\u0014\u0010\u0011J\u0010\u0010\u0016\u001a\u00020\u000fH\u0080@¢\u0006\u0004\b\u0015\u0010\u0011J\"\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\nH\u0080@¢\u0006\u0004\b\u0019\u0010\u001aR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\f\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b \u0010!R \u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\"8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0011\u0010)\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0011\u0010+\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b*\u0010(R\u0011\u0010,\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b,\u0010!R\u0014\u0010.\u001a\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b-\u0010!¨\u00060"}, d2 = {"Landroidx/compose/material/ModalBottomSheetState;", BuildConfig.FLAVOR, "Landroidx/compose/material/ModalBottomSheetValue;", "initialValue", "Landroidx/compose/ui/unit/Density;", "density", "Lkotlin/Function1;", BuildConfig.FLAVOR, "confirmValueChange", "Landroidx/compose/animation/core/AnimationSpec;", BuildConfig.FLAVOR, "animationSpec", "isSkipHalfExpanded", "<init>", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/AnimationSpec;Z)V", BuildConfig.FLAVOR, "show", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "halfExpand$material_release", "halfExpand", "hide", "expand$material_release", "expand", "target", "velocity", "animateTo$material_release", "(Landroidx/compose/material/ModalBottomSheetValue;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "Landroidx/compose/animation/core/AnimationSpec;", "getAnimationSpec$material_release", "()Landroidx/compose/animation/core/AnimationSpec;", "Z", "isSkipHalfExpanded$material_release", "()Z", "Landroidx/compose/material/AnchoredDraggableState;", "anchoredDraggableState", "Landroidx/compose/material/AnchoredDraggableState;", "getAnchoredDraggableState$material_release", "()Landroidx/compose/material/AnchoredDraggableState;", "getCurrentValue", "()Landroidx/compose/material/ModalBottomSheetValue;", "currentValue", "getTargetValue", "targetValue", "isVisible", "getHasHalfExpandedState$material_release", "hasHalfExpandedState", "Companion", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ModalBottomSheetState {
    private final AnchoredDraggableState<ModalBottomSheetValue> anchoredDraggableState;
    private final AnimationSpec<Float> animationSpec;
    private final boolean isSkipHalfExpanded;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JB\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/material/ModalBottomSheetState$Companion;", BuildConfig.FLAVOR, "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/ModalBottomSheetState;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", BuildConfig.FLAVOR, "confirmValueChange", "Lkotlin/Function1;", "Landroidx/compose/material/ModalBottomSheetValue;", BuildConfig.FLAVOR, "skipHalfExpanded", "density", "Landroidx/compose/ui/unit/Density;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Saver<ModalBottomSheetState, ?> Saver(final AnimationSpec<Float> animationSpec, final Function1<? super ModalBottomSheetValue, Boolean> confirmValueChange, final boolean skipHalfExpanded, final Density density) {
            return SaverKt.Saver(new Function2<SaverScope, ModalBottomSheetState, ModalBottomSheetValue>() { // from class: androidx.compose.material.ModalBottomSheetState$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                public final ModalBottomSheetValue invoke(SaverScope saverScope, ModalBottomSheetState modalBottomSheetState) {
                    return modalBottomSheetState.getCurrentValue();
                }
            }, new Function1<ModalBottomSheetValue, ModalBottomSheetState>() { // from class: androidx.compose.material.ModalBottomSheetState$Companion$Saver$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final ModalBottomSheetState invoke(ModalBottomSheetValue modalBottomSheetValue) {
                    return new ModalBottomSheetState(modalBottomSheetValue, Density.this, confirmValueChange, animationSpec, skipHalfExpanded);
                }
            });
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ModalBottomSheetValue.values().length];
            try {
                iArr[ModalBottomSheetValue.Hidden.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ModalBottomSheetState(ModalBottomSheetValue modalBottomSheetValue, final Density density, Function1<? super ModalBottomSheetValue, Boolean> function1, AnimationSpec<Float> animationSpec, boolean z5) {
        this.animationSpec = animationSpec;
        this.isSkipHalfExpanded = z5;
        this.anchoredDraggableState = new AnchoredDraggableState<>(modalBottomSheetValue, new Function1<Float, Float>() { // from class: androidx.compose.material.ModalBottomSheetState$anchoredDraggableState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Float invoke(Float f5) {
                return invoke(f5.floatValue());
            }

            public final Float invoke(float f5) {
                return Float.valueOf(Density.this.mo212toPx0680j_4(ModalBottomSheetKt.access$getModalBottomSheetPositionalThreshold$p()));
            }
        }, new Function0<Float>() { // from class: androidx.compose.material.ModalBottomSheetState$anchoredDraggableState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(Density.this.mo212toPx0680j_4(ModalBottomSheetKt.access$getModalBottomSheetVelocityThreshold$p()));
            }
        }, animationSpec, function1);
        if (z5 && modalBottomSheetValue == ModalBottomSheetValue.HalfExpanded) {
            throw new IllegalArgumentException("The initial value must not be set to HalfExpanded if skipHalfExpanded is set to true.");
        }
    }

    public static /* synthetic */ Object animateTo$material_release$default(ModalBottomSheetState modalBottomSheetState, ModalBottomSheetValue modalBottomSheetValue, float f5, Continuation continuation, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            f5 = modalBottomSheetState.anchoredDraggableState.getLastVelocity();
        }
        return modalBottomSheetState.animateTo$material_release(modalBottomSheetValue, f5, continuation);
    }

    public final Object animateTo$material_release(ModalBottomSheetValue modalBottomSheetValue, float f5, Continuation<? super Unit> continuation) {
        Object animateTo = AnchoredDraggableKt.animateTo(this.anchoredDraggableState, modalBottomSheetValue, f5, continuation);
        return animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo : Unit.INSTANCE;
    }

    public final Object expand$material_release(Continuation<? super Unit> continuation) {
        Object animateTo$material_release$default;
        DraggableAnchors<ModalBottomSheetValue> anchors = this.anchoredDraggableState.getAnchors();
        ModalBottomSheetValue modalBottomSheetValue = ModalBottomSheetValue.Expanded;
        return (anchors.hasAnchorFor(modalBottomSheetValue) && (animateTo$material_release$default = animateTo$material_release$default(this, modalBottomSheetValue, 0.0f, continuation, 2, null)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? animateTo$material_release$default : Unit.INSTANCE;
    }

    public final AnchoredDraggableState<ModalBottomSheetValue> getAnchoredDraggableState$material_release() {
        return this.anchoredDraggableState;
    }

    public final ModalBottomSheetValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public final boolean getHasHalfExpandedState$material_release() {
        return this.anchoredDraggableState.getAnchors().hasAnchorFor(ModalBottomSheetValue.HalfExpanded);
    }

    public final ModalBottomSheetValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final Object halfExpand$material_release(Continuation<? super Unit> continuation) {
        Object animateTo$material_release$default;
        return (getHasHalfExpandedState$material_release() && (animateTo$material_release$default = animateTo$material_release$default(this, ModalBottomSheetValue.HalfExpanded, 0.0f, continuation, 2, null)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? animateTo$material_release$default : Unit.INSTANCE;
    }

    public final Object hide(Continuation<? super Unit> continuation) {
        Object animateTo$material_release$default = animateTo$material_release$default(this, ModalBottomSheetValue.Hidden, 0.0f, continuation, 2, null);
        return animateTo$material_release$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$material_release$default : Unit.INSTANCE;
    }

    /* renamed from: isSkipHalfExpanded$material_release, reason: from getter */
    public final boolean getIsSkipHalfExpanded() {
        return this.isSkipHalfExpanded;
    }

    public final boolean isVisible() {
        return this.anchoredDraggableState.getCurrentValue() != ModalBottomSheetValue.Hidden;
    }

    public final Object show(Continuation<? super Unit> continuation) {
        DraggableAnchors<ModalBottomSheetValue> anchors = this.anchoredDraggableState.getAnchors();
        ModalBottomSheetValue modalBottomSheetValue = ModalBottomSheetValue.Expanded;
        boolean hasAnchorFor = anchors.hasAnchorFor(modalBottomSheetValue);
        if (WhenMappings.$EnumSwitchMapping$0[getCurrentValue().ordinal()] == 1) {
            if (getHasHalfExpandedState$material_release()) {
                modalBottomSheetValue = ModalBottomSheetValue.HalfExpanded;
            }
        } else if (!hasAnchorFor) {
            modalBottomSheetValue = ModalBottomSheetValue.Hidden;
        }
        Object animateTo$material_release$default = animateTo$material_release$default(this, modalBottomSheetValue, 0.0f, continuation, 2, null);
        return animateTo$material_release$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$material_release$default : Unit.INSTANCE;
    }
}
