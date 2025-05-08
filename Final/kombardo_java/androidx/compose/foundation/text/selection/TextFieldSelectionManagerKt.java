package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextDelegate;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a\"\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, d2 = {"TextFieldSelectionHandle", BuildConfig.FLAVOR, "isStartHandle", BuildConfig.FLAVOR, "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "(ZLandroidx/compose/ui/text/style/ResolvedTextDirection;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "calculateSelectionMagnifierCenterAndroid", "Landroidx/compose/ui/geometry/Offset;", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;", "calculateSelectionMagnifierCenterAndroid-O0kMr_c", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;J)J", "isSelectionHandleInVisibleBound", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class TextFieldSelectionManagerKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Handle.values().length];
            try {
                iArr[Handle.Cursor.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Handle.SelectionStart.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Handle.SelectionEnd.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void TextFieldSelectionHandle(final boolean z5, final ResolvedTextDirection resolvedTextDirection, final TextFieldSelectionManager textFieldSelectionManager, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-1344558920);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(z5) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(resolvedTextDirection) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(textFieldSelectionManager) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1344558920, i6, -1, "androidx.compose.foundation.text.selection.TextFieldSelectionHandle (TextFieldSelectionManager.kt:1000)");
            }
            int i7 = i6 & 14;
            boolean changed = (i7 == 4) | startRestartGroup.changed(textFieldSelectionManager);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = textFieldSelectionManager.handleDragObserver$foundation_release(z5);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            TextDragObserver textDragObserver = (TextDragObserver) rememberedValue;
            boolean changedInstance = startRestartGroup.changedInstance(textFieldSelectionManager) | (i7 == 4);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new OffsetProvider() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$TextFieldSelectionHandle$1$1
                    @Override // androidx.compose.foundation.text.selection.OffsetProvider
                    /* renamed from: provide-F1C5BW0 */
                    public final long mo474provideF1C5BW0() {
                        return TextFieldSelectionManager.this.m646getHandlePositiontuRUvjQ$foundation_release(z5);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            OffsetProvider offsetProvider = (OffsetProvider) rememberedValue2;
            boolean m2284getReversedimpl = TextRange.m2284getReversedimpl(textFieldSelectionManager.getValue$foundation_release().getSelection());
            Modifier.Companion companion = Modifier.INSTANCE;
            boolean changedInstance2 = startRestartGroup.changedInstance(textDragObserver);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new TextFieldSelectionManagerKt$TextFieldSelectionHandle$2$1(textDragObserver, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            AndroidSelectionHandles_androidKt.m621SelectionHandlepzduO1o(offsetProvider, z5, resolvedTextDirection, m2284getReversedimpl, 0L, SuspendingPointerInputFilterKt.pointerInput(companion, textDragObserver, (Function2) rememberedValue3), startRestartGroup, (i6 << 3) & 1008, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$TextFieldSelectionHandle$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i8) {
                    TextFieldSelectionManagerKt.TextFieldSelectionHandle(z5, resolvedTextDirection, textFieldSelectionManager, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    /* renamed from: calculateSelectionMagnifierCenterAndroid-O0kMr_c, reason: not valid java name */
    public static final long m649calculateSelectionMagnifierCenterAndroidO0kMr_c(TextFieldSelectionManager textFieldSelectionManager, long j5) {
        int m2285getStartimpl;
        TextLayoutResultProxy layoutResult;
        TextDelegate textDelegate;
        AnnotatedString text;
        Offset m644getCurrentDragPosition_m7T9E = textFieldSelectionManager.m644getCurrentDragPosition_m7T9E();
        if (m644getCurrentDragPosition_m7T9E == null) {
            return Offset.INSTANCE.m1348getUnspecifiedF1C5BW0();
        }
        long packedValue = m644getCurrentDragPosition_m7T9E.getPackedValue();
        AnnotatedString transformedText$foundation_release = textFieldSelectionManager.getTransformedText$foundation_release();
        if (transformedText$foundation_release == null || transformedText$foundation_release.length() == 0) {
            return Offset.INSTANCE.m1348getUnspecifiedF1C5BW0();
        }
        Handle draggingHandle = textFieldSelectionManager.getDraggingHandle();
        int i5 = draggingHandle == null ? -1 : WhenMappings.$EnumSwitchMapping$0[draggingHandle.ordinal()];
        if (i5 == -1) {
            return Offset.INSTANCE.m1348getUnspecifiedF1C5BW0();
        }
        if (i5 == 1 || i5 == 2) {
            m2285getStartimpl = TextRange.m2285getStartimpl(textFieldSelectionManager.getValue$foundation_release().getSelection());
        } else {
            if (i5 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            m2285getStartimpl = TextRange.m2280getEndimpl(textFieldSelectionManager.getValue$foundation_release().getSelection());
        }
        LegacyTextFieldState state = textFieldSelectionManager.getState();
        if (state == null || (layoutResult = state.getLayoutResult()) == null) {
            return Offset.INSTANCE.m1348getUnspecifiedF1C5BW0();
        }
        LegacyTextFieldState state2 = textFieldSelectionManager.getState();
        if (state2 == null || (textDelegate = state2.getTextDelegate()) == null || (text = textDelegate.getText()) == null) {
            return Offset.INSTANCE.m1348getUnspecifiedF1C5BW0();
        }
        int coerceIn = RangesKt.coerceIn(textFieldSelectionManager.getOffsetMapping().originalToTransformed(m2285getStartimpl), 0, text.length());
        float m1337getXimpl = Offset.m1337getXimpl(layoutResult.m554translateDecorationToInnerCoordinatesMKHz9U$foundation_release(packedValue));
        TextLayoutResult value = layoutResult.getValue();
        int lineForOffset = value.getLineForOffset(coerceIn);
        float lineLeft = value.getLineLeft(lineForOffset);
        float lineRight = value.getLineRight(lineForOffset);
        float coerceIn2 = RangesKt.coerceIn(m1337getXimpl, Math.min(lineLeft, lineRight), Math.max(lineLeft, lineRight));
        if (!IntSize.m2659equalsimpl0(j5, IntSize.INSTANCE.m2665getZeroYbymL2g()) && Math.abs(m1337getXimpl - coerceIn2) > IntSize.m2661getWidthimpl(j5) / 2) {
            return Offset.INSTANCE.m1348getUnspecifiedF1C5BW0();
        }
        float lineTop = value.getLineTop(lineForOffset);
        return OffsetKt.Offset(coerceIn2, ((value.getLineBottom(lineForOffset) - lineTop) / 2) + lineTop);
    }

    public static final boolean isSelectionHandleInVisibleBound(TextFieldSelectionManager textFieldSelectionManager, boolean z5) {
        LayoutCoordinates layoutCoordinates;
        Rect visibleBounds;
        LegacyTextFieldState state = textFieldSelectionManager.getState();
        if (state == null || (layoutCoordinates = state.getLayoutCoordinates()) == null || (visibleBounds = SelectionManagerKt.visibleBounds(layoutCoordinates)) == null) {
            return false;
        }
        return SelectionManagerKt.m635containsInclusiveUv8p0NA(visibleBounds, textFieldSelectionManager.m646getHandlePositiontuRUvjQ$foundation_release(z5));
    }
}
