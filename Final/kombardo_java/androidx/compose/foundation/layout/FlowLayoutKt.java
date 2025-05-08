package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.CrossAxisAlignment;
import androidx.compose.foundation.layout.FlowLayoutBuildingBlocks;
import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a_\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a7\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001aU\u0010\u001e\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u001e\u0010\u001b\u001a\u001a\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001a2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u008d\u0001\u0010\"\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u001e\u0010\u001b\u001a\u001a\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001a2\u001e\u0010 \u001a\u001a\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001a2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\"\u0010#\u001a]\u0010)\u001a\u00020(2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0012H\u0002¢\u0006\u0004\b)\u0010*\u001a\u008d\u0001\u0010)\u001a\u00020(2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u001e\u0010\u001b\u001a\u001a\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001a2\u001e\u0010 \u001a\u001a\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001a2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0012H\u0002¢\u0006\u0004\b)\u0010+\u001a\\\u0010:\u001a\u000207*\u00020,2\u0006\u0010.\u001a\u00020-2\f\u00101\u001a\b\u0012\u0004\u0012\u0002000/2\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u0002022\u0006\u00106\u001a\u0002052\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0012H\u0000ø\u0001\u0000¢\u0006\u0004\b8\u00109\u001a%\u0010=\u001a\u0004\u0018\u000100*\b\u0012\u0004\u0012\u0002000/2\b\u0010<\u001a\u0004\u0018\u00010;H\u0002¢\u0006\u0004\b=\u0010>\u001a#\u0010A\u001a\u00020\u0006*\u00020\u00182\u0006\u0010@\u001a\u00020?2\u0006\u0010 \u001a\u00020\u0006H\u0000¢\u0006\u0004\bA\u0010B\u001a#\u0010C\u001a\u00020\u0006*\u00020\u00182\u0006\u0010@\u001a\u00020?2\u0006\u0010\u001b\u001a\u00020\u0006H\u0000¢\u0006\u0004\bC\u0010B\u001a<\u0010I\u001a\u00020(*\u0002002\u0006\u0010.\u001a\u00020-2\u0006\u00106\u001a\u00020D2\u0014\u0010F\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010E\u0012\u0004\u0012\u00020\r0\u000bH\u0000ø\u0001\u0000¢\u0006\u0004\bG\u0010H\u001aT\u0010R\u001a\u000207*\u00020,2\u0006\u00106\u001a\u0002052\u0006\u0010J\u001a\u00020\u00062\u0006\u0010K\u001a\u00020\u00062\u0006\u0010&\u001a\u00020$2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002070L2\u0006\u0010N\u001a\u00020-2\u0006\u0010O\u001a\u00020$H\u0000ø\u0001\u0000¢\u0006\u0004\bP\u0010Q\"\u001a\u0010T\u001a\u00020S8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u001a\u0010X\u001a\u00020S8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bX\u0010U\u001a\u0004\bY\u0010W\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006Z"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalArrangement", BuildConfig.FLAVOR, "maxItemsInEachRow", "maxLines", "Landroidx/compose/foundation/layout/FlowRowOverflow;", "overflow", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowRowScope;", BuildConfig.FLAVOR, "content", "FlowRow", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;IILandroidx/compose/foundation/layout/FlowRowOverflow;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "maxItemsInMainAxis", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "overflowState", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "rowMeasurementMultiContentHelper", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "children", "Lkotlin/Function3;", "mainAxisSize", "crossAxisAvailable", "mainAxisSpacing", "maxIntrinsicMainAxisSize", "(Ljava/util/List;Lkotlin/jvm/functions/Function3;III)I", "crossAxisSize", "crossAxisSpacing", "minIntrinsicMainAxisSize", "(Ljava/util/List;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;IIIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)I", BuildConfig.FLAVOR, "mainAxisSizes", "crossAxisSizes", "mainAxisAvailable", "Landroidx/collection/IntIntPair;", "intrinsicCrossAxisSize", "(Ljava/util/List;[I[IIIIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)J", "(Ljava/util/List;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;IIIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)J", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "measurePolicy", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/Measurable;", "measurablesIterator", "Landroidx/compose/ui/unit/Dp;", "mainAxisSpacingDp", "crossAxisSpacingDp", "Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "breakDownItems-di9J0FM", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;Ljava/util/Iterator;FFJIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)Landroidx/compose/ui/layout/MeasureResult;", "breakDownItems", "Landroidx/compose/foundation/layout/FlowLineInfo;", "info", "safeNext", "(Ljava/util/Iterator;Landroidx/compose/foundation/layout/FlowLineInfo;)Landroidx/compose/ui/layout/Measurable;", BuildConfig.FLAVOR, "isHorizontal", "mainAxisMin", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;ZI)I", "crossAxisMin", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/Placeable;", "storePlaceable", "measureAndCache-rqJ1uqs", "(Landroidx/compose/ui/layout/Measurable;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;JLkotlin/jvm/functions/Function1;)J", "measureAndCache", "mainAxisTotalSize", "crossAxisTotalSize", "Landroidx/compose/runtime/collection/MutableVector;", "items", "measureHelper", "outPosition", "placeHelper-BmaY500", "(Landroidx/compose/ui/layout/MeasureScope;JII[ILandroidx/compose/runtime/collection/MutableVector;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;[I)Landroidx/compose/ui/layout/MeasureResult;", "placeHelper", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "CROSS_AXIS_ALIGNMENT_TOP", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCROSS_AXIS_ALIGNMENT_TOP", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "CROSS_AXIS_ALIGNMENT_START", "getCROSS_AXIS_ALIGNMENT_START", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class FlowLayoutKt {
    private static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_START;
    private static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_TOP;

    static {
        CrossAxisAlignment.Companion companion = CrossAxisAlignment.INSTANCE;
        Alignment.Companion companion2 = Alignment.INSTANCE;
        CROSS_AXIS_ALIGNMENT_TOP = companion.vertical$foundation_layout_release(companion2.getTop());
        CROSS_AXIS_ALIGNMENT_START = companion.horizontal$foundation_layout_release(companion2.getStart());
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x018c, code lost:
    
        if (r4 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L125;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FlowRow(Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, int i5, int i6, FlowRowOverflow flowRowOverflow, final Function3<? super FlowRowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i7, final int i8) {
        int i9;
        Arrangement.Horizontal horizontal2;
        int i10;
        Arrangement.Vertical vertical2;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        FlowRowOverflow clip;
        boolean z5;
        Object rememberedValue;
        boolean z6;
        Object obj;
        boolean changed;
        Object rememberedValue2;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        Modifier modifier2;
        FlowRowOverflow flowRowOverflow2;
        final int i16;
        final Arrangement.Vertical vertical3;
        final int i17;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(437853230);
        int i18 = i8 & 1;
        if (i18 != 0) {
            i9 = i7 | 6;
        } else if ((i7 & 6) == 0) {
            i9 = (startRestartGroup.changed(modifier) ? 4 : 2) | i7;
        } else {
            i9 = i7;
        }
        int i19 = i8 & 2;
        if (i19 != 0) {
            i9 |= 48;
        } else if ((i7 & 48) == 0) {
            horizontal2 = horizontal;
            i9 |= startRestartGroup.changed(horizontal2) ? 32 : 16;
            i10 = i8 & 4;
            if (i10 == 0) {
                i9 |= 384;
            } else if ((i7 & 384) == 0) {
                vertical2 = vertical;
                i9 |= startRestartGroup.changed(vertical2) ? 256 : 128;
                i11 = i8 & 8;
                if (i11 != 0) {
                    i9 |= 3072;
                } else if ((i7 & 3072) == 0) {
                    i12 = i5;
                    i9 |= startRestartGroup.changed(i12) ? 2048 : 1024;
                    i13 = i8 & 16;
                    if (i13 == 0) {
                        i9 |= 24576;
                    } else if ((i7 & 24576) == 0) {
                        i14 = i6;
                        i9 |= startRestartGroup.changed(i14) ? 16384 : 8192;
                        i15 = i8 & 32;
                        if (i15 != 0) {
                            i9 |= 196608;
                        } else if ((i7 & 196608) == 0) {
                            i9 |= startRestartGroup.changed(flowRowOverflow) ? 131072 : 65536;
                        }
                        if ((i8 & 64) != 0) {
                            i9 |= 1572864;
                        } else if ((i7 & 1572864) == 0) {
                            i9 |= startRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                        }
                        if ((i9 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                            Modifier modifier3 = i18 != 0 ? Modifier.INSTANCE : modifier;
                            if (i19 != 0) {
                                horizontal2 = Arrangement.INSTANCE.getStart();
                            }
                            Arrangement.Vertical top = i10 != 0 ? Arrangement.INSTANCE.getTop() : vertical2;
                            int i20 = i11 != 0 ? Integer.MAX_VALUE : i12;
                            int i21 = i13 == 0 ? i14 : Integer.MAX_VALUE;
                            clip = i15 != 0 ? FlowRowOverflow.INSTANCE.getClip() : flowRowOverflow;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(437853230, i9, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:92)");
                            }
                            int i22 = i9 & 458752;
                            z5 = i22 == 131072;
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = clip.createOverflowState$foundation_layout_release();
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            FlowLayoutOverflowState flowLayoutOverflowState = (FlowLayoutOverflowState) rememberedValue;
                            Arrangement.Vertical vertical4 = top;
                            int i23 = i21;
                            int i24 = i21;
                            FlowRowOverflow flowRowOverflow3 = clip;
                            MultiContentMeasurePolicy rowMeasurementMultiContentHelper = rowMeasurementMultiContentHelper(horizontal2, top, i20, i23, flowLayoutOverflowState, startRestartGroup, (i9 >> 3) & 8190);
                            z6 = ((3670016 & i9) == 1048576) | (i22 == 131072);
                            Object rememberedValue3 = startRestartGroup.rememberedValue();
                            if (!z6) {
                                obj = rememberedValue3;
                            }
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(ComposableLambdaKt.composableLambdaInstance(-139531073, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$FlowRow$list$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i25) {
                                    if ((i25 & 3) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-139531073, i25, -1, "androidx.compose.foundation.layout.FlowRow.<anonymous>.<anonymous> (FlowLayout.kt:105)");
                                    }
                                    function3.invoke(FlowRowScopeInstance.INSTANCE, composer2, 6);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }));
                            flowRowOverflow3.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState, arrayList);
                            startRestartGroup.updateRememberedValue(arrayList);
                            obj = arrayList;
                            Function2<Composer, Integer, Unit> combineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts((List) obj);
                            changed = startRestartGroup.changed(rowMeasurementMultiContentHelper);
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = MultiContentMeasurePolicyKt.createMeasurePolicy(rowMeasurementMultiContentHelper);
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue2;
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier3);
                            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion.getConstructor();
                            if (startRestartGroup.getApplier() == null) {
                                ComposablesKt.invalidApplier();
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
                                startRestartGroup.createNode(constructor);
                            } else {
                                startRestartGroup.useNode();
                            }
                            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                            Updater.m1227setimpl(m1226constructorimpl, measurePolicy, companion.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                            if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                            combineAsVirtualLayouts.invoke(startRestartGroup, 0);
                            startRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = modifier3;
                            flowRowOverflow2 = flowRowOverflow3;
                            i16 = i20;
                            vertical3 = vertical4;
                            i17 = i24;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            flowRowOverflow2 = flowRowOverflow;
                            vertical3 = vertical2;
                            i16 = i12;
                            i17 = i14;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier4 = modifier2;
                            final Arrangement.Horizontal horizontal3 = horizontal2;
                            final FlowRowOverflow flowRowOverflow4 = flowRowOverflow2;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$FlowRow$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i25) {
                                    FlowLayoutKt.FlowRow(Modifier.this, horizontal3, vertical3, i16, i17, flowRowOverflow4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i7 | 1), i8);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i14 = i6;
                    i15 = i8 & 32;
                    if (i15 != 0) {
                    }
                    if ((i8 & 64) != 0) {
                    }
                    if ((i9 & 599187) == 599186) {
                    }
                    if (i18 != 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i13 == 0) {
                    }
                    if (i15 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i222 = i9 & 458752;
                    if (i222 == 131072) {
                    }
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z5) {
                    }
                    rememberedValue = clip.createOverflowState$foundation_layout_release();
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    FlowLayoutOverflowState flowLayoutOverflowState2 = (FlowLayoutOverflowState) rememberedValue;
                    Arrangement.Vertical vertical42 = top;
                    int i232 = i21;
                    int i242 = i21;
                    FlowRowOverflow flowRowOverflow32 = clip;
                    MultiContentMeasurePolicy rowMeasurementMultiContentHelper2 = rowMeasurementMultiContentHelper(horizontal2, top, i20, i232, flowLayoutOverflowState2, startRestartGroup, (i9 >> 3) & 8190);
                    if (i222 == 131072) {
                    }
                    z6 = ((3670016 & i9) == 1048576) | (i222 == 131072);
                    Object rememberedValue32 = startRestartGroup.rememberedValue();
                    if (!z6) {
                    }
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(ComposableLambdaKt.composableLambdaInstance(-139531073, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$FlowRow$list$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i25) {
                            if ((i25 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-139531073, i25, -1, "androidx.compose.foundation.layout.FlowRow.<anonymous>.<anonymous> (FlowLayout.kt:105)");
                            }
                            function3.invoke(FlowRowScopeInstance.INSTANCE, composer2, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }));
                    flowRowOverflow32.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState2, arrayList2);
                    startRestartGroup.updateRememberedValue(arrayList2);
                    obj = arrayList2;
                    Function2<Composer, Integer, Unit> combineAsVirtualLayouts2 = LayoutKt.combineAsVirtualLayouts((List) obj);
                    changed = startRestartGroup.changed(rowMeasurementMultiContentHelper2);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue2 = MultiContentMeasurePolicyKt.createMeasurePolicy(rowMeasurementMultiContentHelper2);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    MeasurePolicy measurePolicy2 = (MeasurePolicy) rememberedValue2;
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier3);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                    if (startRestartGroup.getApplier() == null) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                    Updater.m1227setimpl(m1226constructorimpl, measurePolicy2, companion2.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                    if (!m1226constructorimpl.getInserting()) {
                    }
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion2.getSetModifier());
                    combineAsVirtualLayouts2.invoke(startRestartGroup, 0);
                    startRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier2 = modifier3;
                    flowRowOverflow2 = flowRowOverflow32;
                    i16 = i20;
                    vertical3 = vertical42;
                    i17 = i242;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i12 = i5;
                i13 = i8 & 16;
                if (i13 == 0) {
                }
                i14 = i6;
                i15 = i8 & 32;
                if (i15 != 0) {
                }
                if ((i8 & 64) != 0) {
                }
                if ((i9 & 599187) == 599186) {
                }
                if (i18 != 0) {
                }
                if (i19 != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if (i13 == 0) {
                }
                if (i15 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                int i2222 = i9 & 458752;
                if (i2222 == 131072) {
                }
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z5) {
                }
                rememberedValue = clip.createOverflowState$foundation_layout_release();
                startRestartGroup.updateRememberedValue(rememberedValue);
                FlowLayoutOverflowState flowLayoutOverflowState22 = (FlowLayoutOverflowState) rememberedValue;
                Arrangement.Vertical vertical422 = top;
                int i2322 = i21;
                int i2422 = i21;
                FlowRowOverflow flowRowOverflow322 = clip;
                MultiContentMeasurePolicy rowMeasurementMultiContentHelper22 = rowMeasurementMultiContentHelper(horizontal2, top, i20, i2322, flowLayoutOverflowState22, startRestartGroup, (i9 >> 3) & 8190);
                if (i2222 == 131072) {
                }
                z6 = ((3670016 & i9) == 1048576) | (i2222 == 131072);
                Object rememberedValue322 = startRestartGroup.rememberedValue();
                if (!z6) {
                }
                ArrayList arrayList22 = new ArrayList();
                arrayList22.add(ComposableLambdaKt.composableLambdaInstance(-139531073, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$FlowRow$list$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i25) {
                        if ((i25 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-139531073, i25, -1, "androidx.compose.foundation.layout.FlowRow.<anonymous>.<anonymous> (FlowLayout.kt:105)");
                        }
                        function3.invoke(FlowRowScopeInstance.INSTANCE, composer2, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
                flowRowOverflow322.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState22, arrayList22);
                startRestartGroup.updateRememberedValue(arrayList22);
                obj = arrayList22;
                Function2<Composer, Integer, Unit> combineAsVirtualLayouts22 = LayoutKt.combineAsVirtualLayouts((List) obj);
                changed = startRestartGroup.changed(rowMeasurementMultiContentHelper22);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue2 = MultiContentMeasurePolicyKt.createMeasurePolicy(rowMeasurementMultiContentHelper22);
                startRestartGroup.updateRememberedValue(rememberedValue2);
                MeasurePolicy measurePolicy22 = (MeasurePolicy) rememberedValue2;
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier3);
                ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor22 = companion22.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, measurePolicy22, companion22.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap22, companion22.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion22.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting()) {
                }
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier22, companion22.getSetModifier());
                combineAsVirtualLayouts22.invoke(startRestartGroup, 0);
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier2 = modifier3;
                flowRowOverflow2 = flowRowOverflow322;
                i16 = i20;
                vertical3 = vertical422;
                i17 = i2422;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            vertical2 = vertical;
            i11 = i8 & 8;
            if (i11 != 0) {
            }
            i12 = i5;
            i13 = i8 & 16;
            if (i13 == 0) {
            }
            i14 = i6;
            i15 = i8 & 32;
            if (i15 != 0) {
            }
            if ((i8 & 64) != 0) {
            }
            if ((i9 & 599187) == 599186) {
            }
            if (i18 != 0) {
            }
            if (i19 != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (i13 == 0) {
            }
            if (i15 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int i22222 = i9 & 458752;
            if (i22222 == 131072) {
            }
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z5) {
            }
            rememberedValue = clip.createOverflowState$foundation_layout_release();
            startRestartGroup.updateRememberedValue(rememberedValue);
            FlowLayoutOverflowState flowLayoutOverflowState222 = (FlowLayoutOverflowState) rememberedValue;
            Arrangement.Vertical vertical4222 = top;
            int i23222 = i21;
            int i24222 = i21;
            FlowRowOverflow flowRowOverflow3222 = clip;
            MultiContentMeasurePolicy rowMeasurementMultiContentHelper222 = rowMeasurementMultiContentHelper(horizontal2, top, i20, i23222, flowLayoutOverflowState222, startRestartGroup, (i9 >> 3) & 8190);
            if (i22222 == 131072) {
            }
            z6 = ((3670016 & i9) == 1048576) | (i22222 == 131072);
            Object rememberedValue3222 = startRestartGroup.rememberedValue();
            if (!z6) {
            }
            ArrayList arrayList222 = new ArrayList();
            arrayList222.add(ComposableLambdaKt.composableLambdaInstance(-139531073, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$FlowRow$list$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i25) {
                    if ((i25 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-139531073, i25, -1, "androidx.compose.foundation.layout.FlowRow.<anonymous>.<anonymous> (FlowLayout.kt:105)");
                    }
                    function3.invoke(FlowRowScopeInstance.INSTANCE, composer2, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            flowRowOverflow3222.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState222, arrayList222);
            startRestartGroup.updateRememberedValue(arrayList222);
            obj = arrayList222;
            Function2<Composer, Integer, Unit> combineAsVirtualLayouts222 = LayoutKt.combineAsVirtualLayouts((List) obj);
            changed = startRestartGroup.changed(rowMeasurementMultiContentHelper222);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue2 = MultiContentMeasurePolicyKt.createMeasurePolicy(rowMeasurementMultiContentHelper222);
            startRestartGroup.updateRememberedValue(rememberedValue2);
            MeasurePolicy measurePolicy222 = (MeasurePolicy) rememberedValue2;
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier3);
            ComposeUiNode.Companion companion222 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor222 = companion222.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, measurePolicy222, companion222.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap222, companion222.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = companion222.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash222);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier222, companion222.getSetModifier());
            combineAsVirtualLayouts222.invoke(startRestartGroup, 0);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier3;
            flowRowOverflow2 = flowRowOverflow3222;
            i16 = i20;
            vertical3 = vertical4222;
            i17 = i24222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        horizontal2 = horizontal;
        i10 = i8 & 4;
        if (i10 == 0) {
        }
        vertical2 = vertical;
        i11 = i8 & 8;
        if (i11 != 0) {
        }
        i12 = i5;
        i13 = i8 & 16;
        if (i13 == 0) {
        }
        i14 = i6;
        i15 = i8 & 32;
        if (i15 != 0) {
        }
        if ((i8 & 64) != 0) {
        }
        if ((i9 & 599187) == 599186) {
        }
        if (i18 != 0) {
        }
        if (i19 != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (i13 == 0) {
        }
        if (i15 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        int i222222 = i9 & 458752;
        if (i222222 == 131072) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z5) {
        }
        rememberedValue = clip.createOverflowState$foundation_layout_release();
        startRestartGroup.updateRememberedValue(rememberedValue);
        FlowLayoutOverflowState flowLayoutOverflowState2222 = (FlowLayoutOverflowState) rememberedValue;
        Arrangement.Vertical vertical42222 = top;
        int i232222 = i21;
        int i242222 = i21;
        FlowRowOverflow flowRowOverflow32222 = clip;
        MultiContentMeasurePolicy rowMeasurementMultiContentHelper2222 = rowMeasurementMultiContentHelper(horizontal2, top, i20, i232222, flowLayoutOverflowState2222, startRestartGroup, (i9 >> 3) & 8190);
        if (i222222 == 131072) {
        }
        z6 = ((3670016 & i9) == 1048576) | (i222222 == 131072);
        Object rememberedValue32222 = startRestartGroup.rememberedValue();
        if (!z6) {
        }
        ArrayList arrayList2222 = new ArrayList();
        arrayList2222.add(ComposableLambdaKt.composableLambdaInstance(-139531073, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$FlowRow$list$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i25) {
                if ((i25 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-139531073, i25, -1, "androidx.compose.foundation.layout.FlowRow.<anonymous>.<anonymous> (FlowLayout.kt:105)");
                }
                function3.invoke(FlowRowScopeInstance.INSTANCE, composer2, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        flowRowOverflow32222.addOverflowComposables$foundation_layout_release(flowLayoutOverflowState2222, arrayList2222);
        startRestartGroup.updateRememberedValue(arrayList2222);
        obj = arrayList2222;
        Function2<Composer, Integer, Unit> combineAsVirtualLayouts2222 = LayoutKt.combineAsVirtualLayouts((List) obj);
        changed = startRestartGroup.changed(rowMeasurementMultiContentHelper2222);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue2 = MultiContentMeasurePolicyKt.createMeasurePolicy(rowMeasurementMultiContentHelper2222);
        startRestartGroup.updateRememberedValue(rememberedValue2);
        MeasurePolicy measurePolicy2222 = (MeasurePolicy) rememberedValue2;
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2222 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier3);
        ComposeUiNode.Companion companion2222 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor2222 = companion2222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, measurePolicy2222, companion2222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2222, companion2222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2222 = companion2222.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2222);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier2222, companion2222.getSetModifier());
        combineAsVirtualLayouts2222.invoke(startRestartGroup, 0);
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = modifier3;
        flowRowOverflow2 = flowRowOverflow32222;
        i16 = i20;
        vertical3 = vertical42222;
        i17 = i242222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: breakDownItems-di9J0FM, reason: not valid java name */
    public static final MeasureResult m282breakDownItemsdi9J0FM(MeasureScope measureScope, FlowLineMeasurePolicy flowLineMeasurePolicy, Iterator<? extends Measurable> it, float f5, float f6, long j5, int i5, int i6, FlowLayoutOverflowState flowLayoutOverflowState) {
        long j6;
        Integer num;
        MutableIntList mutableIntList;
        Measurable measurable;
        final Ref$ObjectRef ref$ObjectRef;
        boolean z5;
        MutableIntList mutableIntList2;
        MutableVector mutableVector;
        ArrayList arrayList;
        long j7;
        int i7;
        int i8;
        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo;
        int i9;
        int i10;
        int height;
        int width;
        T t5;
        Measurable safeNext;
        IntIntPair m6boximpl;
        long j8;
        MutableIntList mutableIntList3;
        MutableIntList mutableIntList4;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo2;
        Iterator<? extends Measurable> it2 = it;
        MutableVector mutableVector2 = new MutableVector(new MeasureResult[16], 0);
        int m2578getMaxWidthimpl = Constraints.m2578getMaxWidthimpl(j5);
        int m2580getMinWidthimpl = Constraints.m2580getMinWidthimpl(j5);
        int m2577getMaxHeightimpl = Constraints.m2577getMaxHeightimpl(j5);
        MutableIntObjectMap mutableIntObjectMapOf = IntObjectMapKt.mutableIntObjectMapOf();
        ArrayList arrayList2 = new ArrayList();
        int ceil = (int) Math.ceil(measureScope.mo212toPx0680j_4(f5));
        int ceil2 = (int) Math.ceil(measureScope.mo212toPx0680j_4(f6));
        long m300constructorimpl = OrientationIndependentConstraints.m300constructorimpl(0, m2578getMaxWidthimpl, 0, m2577getMaxHeightimpl);
        long m305toBoxConstraintsOenEA2s = OrientationIndependentConstraints.m305toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m304copyyUG9Ft0$default(m300constructorimpl, 0, 0, 0, 0, 14, null), flowLineMeasurePolicy.getIsHorizontal() ? LayoutOrientation.Horizontal : LayoutOrientation.Vertical);
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        Measurable safeNext2 = !it.hasNext() ? null : safeNext(it2, null);
        IntIntPair m6boximpl2 = safeNext2 != null ? IntIntPair.m6boximpl(m283measureAndCacherqJ1uqs(safeNext2, flowLineMeasurePolicy, m305toBoxConstraintsOenEA2s, new Function1<Placeable, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$breakDownItems$nextSize$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable placeable) {
                invoke2(placeable);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable placeable) {
                ref$ObjectRef2.element = placeable;
            }
        })) : null;
        Integer valueOf = m6boximpl2 != null ? Integer.valueOf(IntIntPair.m10getFirstimpl(m6boximpl2.getPackedValue())) : null;
        if (m6boximpl2 != null) {
            j6 = m305toBoxConstraintsOenEA2s;
            num = Integer.valueOf(IntIntPair.m11getSecondimpl(m6boximpl2.getPackedValue()));
        } else {
            j6 = m305toBoxConstraintsOenEA2s;
            num = null;
        }
        MutableIntList mutableIntList5 = new MutableIntList(0, 1, null);
        MutableIntList mutableIntList6 = new MutableIntList(0, 1, null);
        FlowLayoutBuildingBlocks flowLayoutBuildingBlocks = new FlowLayoutBuildingBlocks(i5, flowLayoutOverflowState, j5, i6, ceil, ceil2, null);
        FlowLayoutBuildingBlocks.WrapInfo m280getWrapInfoOpUlnko = flowLayoutBuildingBlocks.m280getWrapInfoOpUlnko(it.hasNext(), 0, IntIntPair.m7constructorimpl(m2578getMaxWidthimpl, m2577getMaxHeightimpl), m6boximpl2, 0, 0, 0, false, false);
        if (m280getWrapInfoOpUlnko.getIsLastItemInContainer()) {
            measurable = safeNext2;
            ref$ObjectRef = ref$ObjectRef2;
            z5 = true;
            j7 = j6;
            mutableIntList2 = mutableIntList6;
            i7 = ceil2;
            i8 = ceil;
            mutableIntList = mutableIntList5;
            mutableVector = mutableVector2;
            arrayList = arrayList2;
            wrapEllipsisInfo = flowLayoutBuildingBlocks.getWrapEllipsisInfo(m280getWrapInfoOpUlnko, m6boximpl2 != null, -1, 0, m2578getMaxWidthimpl, 0);
        } else {
            mutableIntList = mutableIntList5;
            measurable = safeNext2;
            ref$ObjectRef = ref$ObjectRef2;
            z5 = true;
            mutableIntList2 = mutableIntList6;
            mutableVector = mutableVector2;
            arrayList = arrayList2;
            j7 = j6;
            i7 = ceil2;
            i8 = ceil;
            wrapEllipsisInfo = null;
        }
        int i16 = m2578getMaxWidthimpl;
        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo3 = wrapEllipsisInfo;
        int i17 = m2577getMaxHeightimpl;
        Measurable measurable2 = measurable;
        int i18 = m2580getMinWidthimpl;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        while (!m280getWrapInfoOpUlnko.getIsLastItemInContainer() && measurable2 != null) {
            Intrinsics.checkNotNull(valueOf);
            int intValue = valueOf.intValue();
            Intrinsics.checkNotNull(num);
            int i25 = m2577getMaxHeightimpl;
            int i26 = i19 + intValue;
            int max = Math.max(i20, num.intValue());
            int i27 = i16 - intValue;
            int i28 = i21 + 1;
            int i29 = m2578getMaxWidthimpl;
            flowLayoutOverflowState.setItemShown$foundation_layout_release(i28);
            arrayList.add(measurable2);
            mutableIntObjectMapOf.set(i21, ref$ObjectRef.element);
            int i30 = i28 - i22;
            if (it.hasNext()) {
                t5 = 0;
                safeNext = safeNext(it2, null);
            } else {
                t5 = 0;
                safeNext = null;
            }
            ref$ObjectRef.element = t5;
            IntIntPair m6boximpl3 = safeNext != null ? IntIntPair.m6boximpl(m283measureAndCacherqJ1uqs(safeNext, flowLineMeasurePolicy, j7, new Function1<Placeable, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$breakDownItems$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable placeable) {
                    invoke2(placeable);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable placeable) {
                    ref$ObjectRef.element = placeable;
                }
            })) : null;
            Integer valueOf2 = m6boximpl3 != null ? Integer.valueOf(IntIntPair.m10getFirstimpl(m6boximpl3.getPackedValue()) + i8) : null;
            Integer valueOf3 = m6boximpl3 != null ? Integer.valueOf(IntIntPair.m11getSecondimpl(m6boximpl3.getPackedValue())) : null;
            boolean hasNext = it.hasNext();
            long m7constructorimpl = IntIntPair.m7constructorimpl(i27, i17);
            if (m6boximpl3 == null) {
                m6boximpl = null;
            } else {
                Intrinsics.checkNotNull(valueOf2);
                int intValue2 = valueOf2.intValue();
                Intrinsics.checkNotNull(valueOf3);
                m6boximpl = IntIntPair.m6boximpl(IntIntPair.m7constructorimpl(intValue2, valueOf3.intValue()));
            }
            FlowLayoutBuildingBlocks.WrapInfo m280getWrapInfoOpUlnko2 = flowLayoutBuildingBlocks.m280getWrapInfoOpUlnko(hasNext, i30, m7constructorimpl, m6boximpl, i24, i23, max, false, false);
            if (m280getWrapInfoOpUlnko2.getIsLastItemInLine()) {
                int min = Math.min(Math.max(i18, i26), i29);
                int i31 = i23 + max;
                FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo4 = flowLayoutBuildingBlocks.getWrapEllipsisInfo(m280getWrapInfoOpUlnko2, m6boximpl3 != null ? z5 : false, i24, i31, i27, i30);
                MutableIntList mutableIntList7 = mutableIntList2;
                mutableIntList7.add(max);
                int i32 = (i25 - i31) - i7;
                MutableIntList mutableIntList8 = mutableIntList;
                mutableIntList8.add(i28);
                i24++;
                i23 = i31 + i7;
                i15 = min;
                m2578getMaxWidthimpl = i29;
                i22 = i28;
                j8 = j7;
                valueOf2 = valueOf2 != null ? Integer.valueOf(valueOf2.intValue() - i8) : null;
                mutableIntList3 = mutableIntList7;
                i11 = i32;
                i13 = 0;
                wrapEllipsisInfo2 = wrapEllipsisInfo4;
                i12 = m2578getMaxWidthimpl;
                mutableIntList4 = mutableIntList8;
                i14 = 0;
            } else {
                j8 = j7;
                m2578getMaxWidthimpl = i29;
                mutableIntList3 = mutableIntList2;
                mutableIntList4 = mutableIntList;
                i11 = i17;
                i12 = i27;
                i13 = max;
                i14 = i26;
                i15 = i18;
                wrapEllipsisInfo2 = wrapEllipsisInfo3;
            }
            m280getWrapInfoOpUlnko = m280getWrapInfoOpUlnko2;
            mutableIntList = mutableIntList4;
            wrapEllipsisInfo3 = wrapEllipsisInfo2;
            i18 = i15;
            i19 = i14;
            i20 = i13;
            measurable2 = safeNext;
            i16 = i12;
            i21 = i28;
            i17 = i11;
            mutableIntList2 = mutableIntList3;
            j7 = j8;
            m2577getMaxHeightimpl = i25;
            valueOf = valueOf2;
            num = valueOf3;
            it2 = it;
        }
        MutableIntList mutableIntList9 = mutableIntList2;
        MutableIntList mutableIntList10 = mutableIntList;
        if (wrapEllipsisInfo3 != null) {
            arrayList.add(wrapEllipsisInfo3.getEllipsis());
            mutableIntObjectMapOf.set(arrayList.size() - 1, wrapEllipsisInfo3.getPlaceable());
            int i33 = mutableIntList10._size - 1;
            if (wrapEllipsisInfo3.getPlaceEllipsisOnLastContentLine()) {
                int i34 = mutableIntList10.get_size() - 1;
                mutableIntList9.set(i33, Math.max(mutableIntList9.get(i33), IntIntPair.m11getSecondimpl(wrapEllipsisInfo3.getEllipsisSize())));
                mutableIntList10.set(i34, mutableIntList10.last() + 1);
            } else {
                mutableIntList9.add(IntIntPair.m11getSecondimpl(wrapEllipsisInfo3.getEllipsisSize()));
                mutableIntList10.add(mutableIntList10.last() + 1);
            }
        }
        int size = arrayList.size();
        Placeable[] placeableArr = new Placeable[size];
        for (int i35 = 0; i35 < size; i35++) {
            placeableArr[i35] = mutableIntObjectMapOf.get(i35);
        }
        int i36 = mutableIntList10.get_size();
        int[] iArr = new int[i36];
        for (int i37 = 0; i37 < i36; i37++) {
            iArr[i37] = 0;
        }
        int i38 = mutableIntList10.get_size();
        int[] iArr2 = new int[i38];
        for (int i39 = 0; i39 < i38; i39++) {
            iArr2[i39] = 0;
        }
        int[] iArr3 = mutableIntList10.content;
        int i40 = mutableIntList10._size;
        int i41 = i18;
        int i42 = 0;
        int i43 = 0;
        int i44 = 0;
        Placeable[] placeableArr2 = placeableArr;
        while (i42 < i40) {
            int i45 = iArr3[i42];
            int i46 = mutableIntList9.get(i42);
            int i47 = i42;
            MutableIntList mutableIntList11 = mutableIntList9;
            int i48 = i41;
            int i49 = i40;
            int[] iArr4 = iArr3;
            int i50 = i43;
            int[] iArr5 = iArr2;
            int[] iArr6 = iArr;
            Placeable[] placeableArr3 = placeableArr2;
            MeasureResult measure = RowColumnMeasurePolicyKt.measure(flowLineMeasurePolicy, i41, Constraints.m2579getMinHeightimpl(m300constructorimpl), Constraints.m2578getMaxWidthimpl(m300constructorimpl), i46, i8, measureScope, arrayList, placeableArr2, i50, i45, iArr, i47);
            if (flowLineMeasurePolicy.getIsHorizontal()) {
                height = measure.getWidth();
                width = measure.getHeight();
            } else {
                height = measure.getHeight();
                width = measure.getWidth();
            }
            iArr5[i47] = width;
            i44 += width;
            i41 = Math.max(i48, height);
            mutableVector.add(measure);
            iArr2 = iArr5;
            i43 = i45;
            i40 = i49;
            iArr3 = iArr4;
            iArr = iArr6;
            placeableArr2 = placeableArr3;
            mutableIntList9 = mutableIntList11;
            i42 = i47 + 1;
        }
        int i51 = i41;
        int[] iArr7 = iArr2;
        int[] iArr8 = iArr;
        MutableVector mutableVector3 = mutableVector;
        if (mutableVector3.isEmpty()) {
            i9 = 0;
            i10 = 0;
        } else {
            i9 = i51;
            i10 = i44;
        }
        return m284placeHelperBmaY500(measureScope, j5, i9, i10, iArr7, mutableVector3, flowLineMeasurePolicy, iArr8);
    }

    public static final int crossAxisMin(IntrinsicMeasurable intrinsicMeasurable, boolean z5, int i5) {
        return z5 ? intrinsicMeasurable.minIntrinsicHeight(i5) : intrinsicMeasurable.minIntrinsicWidth(i5);
    }

    private static final long intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, final int[] iArr, final int[] iArr2, int i5, int i6, int i7, int i8, int i9, FlowLayoutOverflowState flowLayoutOverflowState) {
        return intrinsicCrossAxisSize(list, new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$intrinsicCrossAxisSize$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i10, int i11) {
                return Integer.valueOf(iArr[i10]);
            }
        }, new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$intrinsicCrossAxisSize$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i10, int i11) {
                return Integer.valueOf(iArr2[i10]);
            }
        }, i5, i6, i7, i8, i9, flowLayoutOverflowState);
    }

    public static final int mainAxisMin(IntrinsicMeasurable intrinsicMeasurable, boolean z5, int i5) {
        return z5 ? intrinsicMeasurable.minIntrinsicWidth(i5) : intrinsicMeasurable.minIntrinsicHeight(i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int maxIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, int i5, int i6, int i7) {
        int size = list.size();
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i8 < size) {
            int intValue = function3.invoke(list.get(i8), Integer.valueOf(i8), Integer.valueOf(i5)).intValue() + i6;
            int i12 = i8 + 1;
            if (i12 - i10 == i7 || i12 == list.size()) {
                i9 = Math.max(i9, (i11 + intValue) - i6);
                i11 = 0;
                i10 = i8;
            } else {
                i11 += intValue;
            }
            i8 = i12;
        }
        return i9;
    }

    /* renamed from: measureAndCache-rqJ1uqs, reason: not valid java name */
    public static final long m283measureAndCacherqJ1uqs(Measurable measurable, FlowLineMeasurePolicy flowLineMeasurePolicy, long j5, Function1<? super Placeable, Unit> function1) {
        if (RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(measurable)) != 0.0f) {
            int mainAxisMin = mainAxisMin(measurable, flowLineMeasurePolicy.getIsHorizontal(), Integer.MAX_VALUE);
            return IntIntPair.m7constructorimpl(mainAxisMin, crossAxisMin(measurable, flowLineMeasurePolicy.getIsHorizontal(), mainAxisMin));
        }
        RowColumnParentData rowColumnParentData = RowColumnImplKt.getRowColumnParentData(measurable);
        if (rowColumnParentData != null) {
            rowColumnParentData.getFlowLayoutData();
        }
        Placeable mo1946measureBRTryo0 = measurable.mo1946measureBRTryo0(j5);
        function1.invoke(mo1946measureBRTryo0);
        return IntIntPair.m7constructorimpl(flowLineMeasurePolicy.mainAxisSize(mo1946measureBRTryo0), flowLineMeasurePolicy.crossAxisSize(mo1946measureBRTryo0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r5v13, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    public static final int minIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function32, int i5, int i6, int i7, int i8, int i9, FlowLayoutOverflowState flowLayoutOverflowState) {
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = 0;
        }
        int size2 = list.size();
        int[] iArr2 = new int[size2];
        for (int i11 = 0; i11 < size2; i11++) {
            iArr2[i11] = 0;
        }
        int size3 = list.size();
        for (int i12 = 0; i12 < size3; i12++) {
            IntrinsicMeasurable intrinsicMeasurable = list.get(i12);
            int intValue = function3.invoke(intrinsicMeasurable, Integer.valueOf(i12), Integer.valueOf(i5)).intValue();
            iArr[i12] = intValue;
            iArr2[i12] = function32.invoke(intrinsicMeasurable, Integer.valueOf(i12), Integer.valueOf(intValue)).intValue();
        }
        int i13 = Integer.MAX_VALUE;
        if (i9 != Integer.MAX_VALUE && i8 != Integer.MAX_VALUE) {
            i13 = i8 * i9;
        }
        int min = Math.min(i13 - (((i13 >= list.size() || !(flowLayoutOverflowState.getType() == FlowLayoutOverflow.OverflowType.ExpandIndicator || flowLayoutOverflowState.getType() == FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator)) && (i13 < list.size() || i9 < flowLayoutOverflowState.getMinLinesToShowCollapse() || flowLayoutOverflowState.getType() != FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator)) ? 0 : 1), list.size());
        int sum = ArraysKt.sum(iArr) + ((list.size() - 1) * i6);
        if (size2 == 0) {
            throw new NoSuchElementException();
        }
        int i14 = iArr2[0];
        ?? it = new IntRange(1, ArraysKt.getLastIndex(iArr2)).iterator();
        while (it.hasNext()) {
            int i15 = iArr2[it.nextInt()];
            if (i14 < i15) {
                i14 = i15;
            }
        }
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int i16 = iArr[0];
        ?? it2 = new IntRange(1, ArraysKt.getLastIndex(iArr)).iterator();
        while (it2.hasNext()) {
            int i17 = iArr[it2.nextInt()];
            if (i16 < i17) {
                i16 = i17;
            }
        }
        int i18 = i16;
        int i19 = sum;
        while (i18 <= i19 && i14 != i5) {
            int i20 = (i18 + i19) / 2;
            int i21 = i19;
            int i22 = i18;
            long intrinsicCrossAxisSize = intrinsicCrossAxisSize(list, iArr, iArr2, i20, i6, i7, i8, i9, flowLayoutOverflowState);
            i14 = IntIntPair.m10getFirstimpl(intrinsicCrossAxisSize);
            int m11getSecondimpl = IntIntPair.m11getSecondimpl(intrinsicCrossAxisSize);
            if (i14 > i5 || m11getSecondimpl < min) {
                i18 = i20 + 1;
                if (i18 > i21) {
                    return i18;
                }
                i19 = i21;
                sum = i20;
            } else {
                if (i14 >= i5) {
                    return i20;
                }
                i19 = i20 - 1;
                sum = i20;
                i18 = i22;
            }
        }
        return sum;
    }

    /* renamed from: placeHelper-BmaY500, reason: not valid java name */
    public static final MeasureResult m284placeHelperBmaY500(MeasureScope measureScope, long j5, int i5, int i6, int[] iArr, final MutableVector<MeasureResult> mutableVector, FlowLineMeasurePolicy flowLineMeasurePolicy, int[] iArr2) {
        int i7;
        boolean isHorizontal = flowLineMeasurePolicy.getIsHorizontal();
        Arrangement.Vertical verticalArrangement = flowLineMeasurePolicy.getVerticalArrangement();
        Arrangement.Horizontal horizontalArrangement = flowLineMeasurePolicy.getHorizontalArrangement();
        if (isHorizontal) {
            if (verticalArrangement == null) {
                throw new IllegalArgumentException("null verticalArrangement");
            }
            i7 = RangesKt.coerceIn((measureScope.mo206roundToPx0680j_4(verticalArrangement.getSpacing()) * (mutableVector.getSize() - 1)) + i6, Constraints.m2579getMinHeightimpl(j5), Constraints.m2577getMaxHeightimpl(j5));
            verticalArrangement.arrange(measureScope, i7, iArr, iArr2);
        } else {
            if (horizontalArrangement == null) {
                throw new IllegalArgumentException("null horizontalArrangement");
            }
            int coerceIn = RangesKt.coerceIn((measureScope.mo206roundToPx0680j_4(horizontalArrangement.getSpacing()) * (mutableVector.getSize() - 1)) + i6, Constraints.m2579getMinHeightimpl(j5), Constraints.m2577getMaxHeightimpl(j5));
            horizontalArrangement.arrange(measureScope, coerceIn, iArr, measureScope.getLayoutDirection(), iArr2);
            i7 = coerceIn;
        }
        int coerceIn2 = RangesKt.coerceIn(i5, Constraints.m2580getMinWidthimpl(j5), Constraints.m2578getMaxWidthimpl(j5));
        if (!isHorizontal) {
            int i8 = i7;
            i7 = coerceIn2;
            coerceIn2 = i8;
        }
        return MeasureScope.layout$default(measureScope, coerceIn2, i7, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$placeHelper$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                MutableVector<MeasureResult> mutableVector2 = mutableVector;
                int size = mutableVector2.getSize();
                if (size > 0) {
                    MeasureResult[] content = mutableVector2.getContent();
                    int i9 = 0;
                    do {
                        content[i9].placeChildren();
                        i9++;
                    } while (i9 < size);
                }
            }
        }, 4, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0022, code lost:
    
        if (r22.changed(r17) != false) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final MultiContentMeasurePolicy rowMeasurementMultiContentHelper(Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, int i5, int i6, FlowLayoutOverflowState flowLayoutOverflowState, Composer composer, int i7) {
        boolean z5;
        boolean changed;
        Object rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2134502475, i7, -1, "androidx.compose.foundation.layout.rowMeasurementMultiContentHelper (FlowLayout.kt:413)");
        }
        if (((i7 & 14) ^ 6) <= 4) {
        }
        if ((i7 & 6) != 4) {
            z5 = false;
            changed = z5 | ((((i7 & 112) ^ 48) <= 32 && composer.changed(vertical)) || (i7 & 48) == 32) | ((((i7 & 896) ^ 384) <= 256 && composer.changed(i5)) || (i7 & 384) == 256) | ((((i7 & 7168) ^ 3072) > 2048 && composer.changed(i6)) || (i7 & 3072) == 2048) | composer.changed(flowLayoutOverflowState);
            rememberedValue = composer.rememberedValue();
            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new FlowMeasurePolicy(true, horizontal, vertical, horizontal.getSpacing(), CROSS_AXIS_ALIGNMENT_TOP, vertical.getSpacing(), i5, i6, flowLayoutOverflowState, null);
                composer.updateRememberedValue(rememberedValue);
            }
            FlowMeasurePolicy flowMeasurePolicy = (FlowMeasurePolicy) rememberedValue;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            return flowMeasurePolicy;
        }
        z5 = true;
        if (((i7 & 7168) ^ 3072) > 2048) {
            changed = z5 | ((((i7 & 112) ^ 48) <= 32 && composer.changed(vertical)) || (i7 & 48) == 32) | ((((i7 & 896) ^ 384) <= 256 && composer.changed(i5)) || (i7 & 384) == 256) | ((((i7 & 7168) ^ 3072) > 2048 && composer.changed(i6)) || (i7 & 3072) == 2048) | composer.changed(flowLayoutOverflowState);
            rememberedValue = composer.rememberedValue();
            if (!changed) {
            }
            rememberedValue = new FlowMeasurePolicy(true, horizontal, vertical, horizontal.getSpacing(), CROSS_AXIS_ALIGNMENT_TOP, vertical.getSpacing(), i5, i6, flowLayoutOverflowState, null);
            composer.updateRememberedValue(rememberedValue);
            FlowMeasurePolicy flowMeasurePolicy2 = (FlowMeasurePolicy) rememberedValue;
            if (ComposerKt.isTraceInProgress()) {
            }
            return flowMeasurePolicy2;
        }
        changed = z5 | ((((i7 & 112) ^ 48) <= 32 && composer.changed(vertical)) || (i7 & 48) == 32) | ((((i7 & 896) ^ 384) <= 256 && composer.changed(i5)) || (i7 & 384) == 256) | ((((i7 & 7168) ^ 3072) > 2048 && composer.changed(i6)) || (i7 & 3072) == 2048) | composer.changed(flowLayoutOverflowState);
        rememberedValue = composer.rememberedValue();
        if (!changed) {
        }
        rememberedValue = new FlowMeasurePolicy(true, horizontal, vertical, horizontal.getSpacing(), CROSS_AXIS_ALIGNMENT_TOP, vertical.getSpacing(), i5, i6, flowLayoutOverflowState, null);
        composer.updateRememberedValue(rememberedValue);
        FlowMeasurePolicy flowMeasurePolicy22 = (FlowMeasurePolicy) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
        }
        return flowMeasurePolicy22;
    }

    private static final Measurable safeNext(Iterator<? extends Measurable> it, FlowLineInfo flowLineInfo) {
        try {
            return it.next();
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function32, int i5, int i6, int i7, int i8, int i9, FlowLayoutOverflowState flowLayoutOverflowState) {
        int i10;
        int i11;
        int i12 = 0;
        if (list.isEmpty()) {
            return IntIntPair.m7constructorimpl(0, 0);
        }
        FlowLayoutBuildingBlocks flowLayoutBuildingBlocks = new FlowLayoutBuildingBlocks(i8, flowLayoutOverflowState, OrientationIndependentConstraints.m300constructorimpl(0, i5, 0, Integer.MAX_VALUE), i9, i6, i7, null);
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) CollectionsKt.getOrNull(list, 0);
        int intValue = intrinsicMeasurable != null ? function32.invoke(intrinsicMeasurable, 0, Integer.valueOf(i5)).intValue() : 0;
        int intValue2 = intrinsicMeasurable != null ? function3.invoke(intrinsicMeasurable, 0, Integer.valueOf(intValue)).intValue() : 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        if (flowLayoutBuildingBlocks.m280getWrapInfoOpUlnko(list.size() > 1, 0, IntIntPair.m7constructorimpl(i5, Integer.MAX_VALUE), intrinsicMeasurable == null ? null : IntIntPair.m6boximpl(IntIntPair.m7constructorimpl(intValue2, intValue)), 0, 0, 0, false, false).getIsLastItemInContainer()) {
            IntIntPair m285ellipsisSizeF35zmw$foundation_layout_release = flowLayoutOverflowState.m285ellipsisSizeF35zmw$foundation_layout_release(intrinsicMeasurable != null, 0, 0);
            return IntIntPair.m7constructorimpl(m285ellipsisSizeF35zmw$foundation_layout_release != null ? IntIntPair.m11getSecondimpl(m285ellipsisSizeF35zmw$foundation_layout_release.getPackedValue()) : 0, 0);
        }
        int size = list.size();
        int i16 = i5;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (true) {
            if (i17 >= size) {
                i10 = i18;
                break;
            }
            int i20 = i16 - intValue2;
            i10 = i17 + 1;
            int max = Math.max(i15, intValue);
            IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) CollectionsKt.getOrNull(list, i10);
            int intValue3 = intrinsicMeasurable2 != null ? function32.invoke(intrinsicMeasurable2, Integer.valueOf(i10), Integer.valueOf(i5)).intValue() : i12;
            int intValue4 = intrinsicMeasurable2 != null ? function3.invoke(intrinsicMeasurable2, Integer.valueOf(i10), Integer.valueOf(intValue3)).intValue() + i6 : 0;
            boolean z5 = i17 + 2 < list.size();
            int i21 = i10 - i19;
            FlowLayoutBuildingBlocks.WrapInfo m280getWrapInfoOpUlnko = flowLayoutBuildingBlocks.m280getWrapInfoOpUlnko(z5, i21, IntIntPair.m7constructorimpl(i20, Integer.MAX_VALUE), intrinsicMeasurable2 == null ? null : IntIntPair.m6boximpl(IntIntPair.m7constructorimpl(intValue4, intValue3)), i13, i14, max, false, false);
            if (m280getWrapInfoOpUlnko.getIsLastItemInLine()) {
                i14 += max + i7;
                FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo = flowLayoutBuildingBlocks.getWrapEllipsisInfo(m280getWrapInfoOpUlnko, intrinsicMeasurable2 != null, i13, i14, i20, i21);
                int i22 = intValue4 - i6;
                i13++;
                if (!m280getWrapInfoOpUlnko.getIsLastItemInContainer()) {
                    i11 = i5;
                    intValue2 = i22;
                    i19 = i10;
                    i15 = 0;
                } else if (wrapEllipsisInfo != null) {
                    long ellipsisSize = wrapEllipsisInfo.getEllipsisSize();
                    if (!wrapEllipsisInfo.getPlaceEllipsisOnLastContentLine()) {
                        i14 += IntIntPair.m11getSecondimpl(ellipsisSize) + i7;
                    }
                }
            } else {
                i15 = max;
                i11 = i20;
                intValue2 = intValue4;
            }
            i17 = i10;
            i18 = i17;
            i12 = 0;
            i16 = i11;
            intValue = intValue3;
        }
        return IntIntPair.m7constructorimpl(i14 - i7, i10);
    }
}
