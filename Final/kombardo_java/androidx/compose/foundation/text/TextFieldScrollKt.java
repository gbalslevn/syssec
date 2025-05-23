package androidx.compose.foundation.text;

import android.support.v4.media.session.a;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002\u001a4\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015H\u0000\u001a*\u0010\u0017\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\nH\u0000¨\u0006\u001b"}, d2 = {"getCursorRectInScroller", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/Density;", "cursorOffset", BuildConfig.FLAVOR, "transformedText", "Landroidx/compose/ui/text/input/TransformedText;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "rtl", BuildConfig.FLAVOR, "textFieldWidth", "textFieldScroll", "Landroidx/compose/ui/Modifier;", "scrollerPosition", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "textLayoutResultProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "textFieldScrollable", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "enabled", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class TextFieldScrollKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Orientation.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final /* synthetic */ Rect access$getCursorRectInScroller(Density density, int i5, TransformedText transformedText, TextLayoutResult textLayoutResult, boolean z5, int i6) {
        return getCursorRectInScroller(density, i5, transformedText, textLayoutResult, z5, i6);
    }

    public static final Rect getCursorRectInScroller(Density density, int i5, TransformedText transformedText, TextLayoutResult textLayoutResult, boolean z5, int i6) {
        Rect zero;
        if (textLayoutResult == null || (zero = textLayoutResult.getCursorRect(transformedText.getOffsetMapping().originalToTransformed(i5))) == null) {
            zero = Rect.INSTANCE.getZero();
        }
        Rect rect = zero;
        int mo206roundToPx0680j_4 = density.mo206roundToPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness());
        return Rect.copy$default(rect, z5 ? (i6 - rect.getLeft()) - mo206roundToPx0680j_4 : rect.getLeft(), 0.0f, z5 ? i6 - rect.getLeft() : rect.getLeft() + mo206roundToPx0680j_4, 0.0f, 10, null);
    }

    public static final Modifier textFieldScroll(Modifier modifier, TextFieldScrollerPosition textFieldScrollerPosition, TextFieldValue textFieldValue, VisualTransformation visualTransformation, Function0<TextLayoutResultProxy> function0) {
        Modifier verticalScrollLayoutModifier;
        Orientation orientation = textFieldScrollerPosition.getOrientation();
        int m544getOffsetToFollow5zctL8 = textFieldScrollerPosition.m544getOffsetToFollow5zctL8(textFieldValue.getSelection());
        textFieldScrollerPosition.m545setPreviousSelection5zctL8(textFieldValue.getSelection());
        TransformedText filterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation, textFieldValue.getText());
        int i5 = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        if (i5 == 1) {
            verticalScrollLayoutModifier = new VerticalScrollLayoutModifier(textFieldScrollerPosition, m544getOffsetToFollow5zctL8, filterWithValidation, function0);
        } else {
            if (i5 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            verticalScrollLayoutModifier = new HorizontalScrollLayoutModifier(textFieldScrollerPosition, m544getOffsetToFollow5zctL8, filterWithValidation, function0);
        }
        return ClipKt.clipToBounds(modifier).then(verticalScrollLayoutModifier);
    }

    public static final Modifier textFieldScrollable(Modifier modifier, final TextFieldScrollerPosition textFieldScrollerPosition, final MutableInteractionSource mutableInteractionSource, final boolean z5) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                a.a(inspectorInfo);
                invoke2((InspectorInfo) null);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                throw null;
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i5) {
                composer.startReplaceGroup(805428266);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(805428266, i5, -1, "androidx.compose.foundation.text.textFieldScrollable.<anonymous> (TextFieldScroll.kt:68)");
                }
                boolean z6 = TextFieldScrollerPosition.this.getOrientation() == Orientation.Vertical || !(composer.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl);
                boolean changed = composer.changed(TextFieldScrollerPosition.this);
                final TextFieldScrollerPosition textFieldScrollerPosition2 = TextFieldScrollerPosition.this;
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function1<Float, Float>() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$scrollableState$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Float invoke(Float f5) {
                            return invoke(f5.floatValue());
                        }

                        public final Float invoke(float f5) {
                            float offset = TextFieldScrollerPosition.this.getOffset() + f5;
                            if (offset > TextFieldScrollerPosition.this.getMaximum()) {
                                f5 = TextFieldScrollerPosition.this.getMaximum() - TextFieldScrollerPosition.this.getOffset();
                            } else if (offset < 0.0f) {
                                f5 = -TextFieldScrollerPosition.this.getOffset();
                            }
                            TextFieldScrollerPosition textFieldScrollerPosition3 = TextFieldScrollerPosition.this;
                            textFieldScrollerPosition3.setOffset(textFieldScrollerPosition3.getOffset() + f5);
                            return Float.valueOf(f5);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                final ScrollableState rememberScrollableState = ScrollableStateKt.rememberScrollableState((Function1) rememberedValue, composer, 0);
                boolean changed2 = composer.changed(rememberScrollableState) | composer.changed(TextFieldScrollerPosition.this);
                final TextFieldScrollerPosition textFieldScrollerPosition3 = TextFieldScrollerPosition.this;
                Object rememberedValue2 = composer.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new ScrollableState(textFieldScrollerPosition3) { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1

                        /* renamed from: canScrollBackward$delegate, reason: from kotlin metadata */
                        private final State canScrollBackward;

                        /* renamed from: canScrollForward$delegate, reason: from kotlin metadata */
                        private final State canScrollForward;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.canScrollForward = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1$canScrollForward$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    return Boolean.valueOf(TextFieldScrollerPosition.this.getOffset() < TextFieldScrollerPosition.this.getMaximum());
                                }
                            });
                            this.canScrollBackward = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1$canScrollBackward$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    return Boolean.valueOf(TextFieldScrollerPosition.this.getOffset() > 0.0f);
                                }
                            });
                        }

                        @Override // androidx.compose.foundation.gestures.ScrollableState
                        public float dispatchRawDelta(float delta) {
                            return ScrollableState.this.dispatchRawDelta(delta);
                        }

                        @Override // androidx.compose.foundation.gestures.ScrollableState
                        public boolean getCanScrollBackward() {
                            return ((Boolean) this.canScrollBackward.getValue()).booleanValue();
                        }

                        @Override // androidx.compose.foundation.gestures.ScrollableState
                        public boolean getCanScrollForward() {
                            return ((Boolean) this.canScrollForward.getValue()).booleanValue();
                        }

                        @Override // androidx.compose.foundation.gestures.ScrollableState
                        public boolean isScrollInProgress() {
                            return ScrollableState.this.isScrollInProgress();
                        }

                        @Override // androidx.compose.foundation.gestures.ScrollableState
                        public Object scroll(MutatePriority mutatePriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
                            return ScrollableState.this.scroll(mutatePriority, function2, continuation);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                Modifier scrollable$default = ScrollableKt.scrollable$default(Modifier.INSTANCE, (TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1) rememberedValue2, TextFieldScrollerPosition.this.getOrientation(), z5 && TextFieldScrollerPosition.this.getMaximum() != 0.0f, z6, null, mutableInteractionSource, 16, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return scrollable$default;
            }
        });
    }
}
