package androidx.compose.foundation.layout;

import android.support.v4.media.session.a;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.WrapContentElement;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001e\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001e\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0004\u001a\u001e\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0004\u001a&\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001e\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a*\u0010\u0011\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\n\u001a*\u0010\u0013\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\n\u001a>\u0010\u001a\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a&\u0010\u001c\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\n\u001a>\u0010\u001e\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0019\u001a\u001d\u0010!\u001a\u00020\u0000*\u00020\u00002\b\b\u0003\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b!\u0010\u0004\u001a\u001d\u0010\"\u001a\u00020\u0000*\u00020\u00002\b\b\u0003\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b\"\u0010\u0004\u001a\u001d\u0010#\u001a\u00020\u0000*\u00020\u00002\b\b\u0003\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b#\u0010\u0004\u001a'\u0010(\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010'\u001a\u00020&H\u0007¢\u0006\u0004\b(\u0010)\u001a'\u0010+\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010%\u001a\u00020*2\b\b\u0002\u0010'\u001a\u00020&H\u0007¢\u0006\u0004\b+\u0010,\u001a*\u0010.\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010\n\"\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101\"\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00101\"\u0014\u00103\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00101\"\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106\"\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00106\"\u0014\u00108\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00106\"\u0014\u00109\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00106\"\u0014\u0010:\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00106\"\u0014\u0010;\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u00106\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006<"}, d2 = {"Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/Dp;", "width", "width-3ABfNKs", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "height", "height-3ABfNKs", "size", "size-3ABfNKs", "size-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/DpSize;", "size-6HolHcs", "(Landroidx/compose/ui/Modifier;J)Landroidx/compose/ui/Modifier;", "min", "max", "widthIn-VpY3zN4", "widthIn", "heightIn-VpY3zN4", "heightIn", "minWidth", "minHeight", "maxWidth", "maxHeight", "sizeIn-qDBjuR0", "(Landroidx/compose/ui/Modifier;FFFF)Landroidx/compose/ui/Modifier;", "sizeIn", "requiredSize-VpY3zN4", "requiredSize", "requiredSizeIn-qDBjuR0", "requiredSizeIn", BuildConfig.FLAVOR, "fraction", "fillMaxWidth", "fillMaxHeight", "fillMaxSize", "Landroidx/compose/ui/Alignment$Vertical;", "align", BuildConfig.FLAVOR, "unbounded", "wrapContentHeight", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment$Vertical;Z)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/Alignment;", "wrapContentSize", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Z)Landroidx/compose/ui/Modifier;", "defaultMinSize-VpY3zN4", "defaultMinSize", "Landroidx/compose/foundation/layout/FillElement;", "FillWholeMaxWidth", "Landroidx/compose/foundation/layout/FillElement;", "FillWholeMaxHeight", "FillWholeMaxSize", "Landroidx/compose/foundation/layout/WrapContentElement;", "WrapContentWidthCenter", "Landroidx/compose/foundation/layout/WrapContentElement;", "WrapContentWidthStart", "WrapContentHeightCenter", "WrapContentHeightTop", "WrapContentSizeCenter", "WrapContentSizeTopStart", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SizeKt {
    private static final FillElement FillWholeMaxHeight;
    private static final FillElement FillWholeMaxSize;
    private static final FillElement FillWholeMaxWidth;
    private static final WrapContentElement WrapContentHeightCenter;
    private static final WrapContentElement WrapContentHeightTop;
    private static final WrapContentElement WrapContentSizeCenter;
    private static final WrapContentElement WrapContentSizeTopStart;
    private static final WrapContentElement WrapContentWidthCenter;
    private static final WrapContentElement WrapContentWidthStart;

    static {
        FillElement.Companion companion = FillElement.INSTANCE;
        FillWholeMaxWidth = companion.width(1.0f);
        FillWholeMaxHeight = companion.height(1.0f);
        FillWholeMaxSize = companion.size(1.0f);
        WrapContentElement.Companion companion2 = WrapContentElement.INSTANCE;
        Alignment.Companion companion3 = Alignment.INSTANCE;
        WrapContentWidthCenter = companion2.width(companion3.getCenterHorizontally(), false);
        WrapContentWidthStart = companion2.width(companion3.getStart(), false);
        WrapContentHeightCenter = companion2.height(companion3.getCenterVertically(), false);
        WrapContentHeightTop = companion2.height(companion3.getTop(), false);
        WrapContentSizeCenter = companion2.size(companion3.getCenter(), false);
        WrapContentSizeTopStart = companion2.size(companion3.getTopStart(), false);
    }

    /* renamed from: defaultMinSize-VpY3zN4 */
    public static final Modifier m323defaultMinSizeVpY3zN4(Modifier modifier, float f5, float f6) {
        return modifier.then(new UnspecifiedConstraintsElement(f5, f6, null));
    }

    /* renamed from: defaultMinSize-VpY3zN4$default */
    public static /* synthetic */ Modifier m324defaultMinSizeVpY3zN4$default(Modifier modifier, float f5, float f6, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM();
        }
        if ((i5 & 2) != 0) {
            f6 = Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM();
        }
        return m323defaultMinSizeVpY3zN4(modifier, f5, f6);
    }

    public static final Modifier fillMaxHeight(Modifier modifier, float f5) {
        return modifier.then(f5 == 1.0f ? FillWholeMaxHeight : FillElement.INSTANCE.height(f5));
    }

    public static /* synthetic */ Modifier fillMaxHeight$default(Modifier modifier, float f5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = 1.0f;
        }
        return fillMaxHeight(modifier, f5);
    }

    public static final Modifier fillMaxSize(Modifier modifier, float f5) {
        return modifier.then(f5 == 1.0f ? FillWholeMaxSize : FillElement.INSTANCE.size(f5));
    }

    public static /* synthetic */ Modifier fillMaxSize$default(Modifier modifier, float f5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = 1.0f;
        }
        return fillMaxSize(modifier, f5);
    }

    public static final Modifier fillMaxWidth(Modifier modifier, float f5) {
        return modifier.then(f5 == 1.0f ? FillWholeMaxWidth : FillElement.INSTANCE.width(f5));
    }

    public static /* synthetic */ Modifier fillMaxWidth$default(Modifier modifier, float f5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = 1.0f;
        }
        return fillMaxWidth(modifier, f5);
    }

    /* renamed from: height-3ABfNKs */
    public static final Modifier m325height3ABfNKs(Modifier modifier, final float f5) {
        return modifier.then(new SizeElement(0.0f, f5, 0.0f, f5, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$height-3ABfNKs$$inlined$debugInspectorInfo$1
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
        } : InspectableValueKt.getNoInspectorInfo(), 5, null));
    }

    /* renamed from: heightIn-VpY3zN4 */
    public static final Modifier m326heightInVpY3zN4(Modifier modifier, final float f5, final float f6) {
        return modifier.then(new SizeElement(0.0f, f5, 0.0f, f6, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$heightIn-VpY3zN4$$inlined$debugInspectorInfo$1
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
        } : InspectableValueKt.getNoInspectorInfo(), 5, null));
    }

    /* renamed from: heightIn-VpY3zN4$default */
    public static /* synthetic */ Modifier m327heightInVpY3zN4$default(Modifier modifier, float f5, float f6, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM();
        }
        if ((i5 & 2) != 0) {
            f6 = Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM();
        }
        return m326heightInVpY3zN4(modifier, f5, f6);
    }

    /* renamed from: requiredSize-VpY3zN4 */
    public static final Modifier m328requiredSizeVpY3zN4(Modifier modifier, final float f5, final float f6) {
        return modifier.then(new SizeElement(f5, f6, f5, f6, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$requiredSize-VpY3zN4$$inlined$debugInspectorInfo$1
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
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* renamed from: requiredSizeIn-qDBjuR0 */
    public static final Modifier m329requiredSizeInqDBjuR0(Modifier modifier, final float f5, final float f6, final float f7, final float f8) {
        return modifier.then(new SizeElement(f5, f6, f7, f8, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$requiredSizeIn-qDBjuR0$$inlined$debugInspectorInfo$1
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
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* renamed from: requiredSizeIn-qDBjuR0$default */
    public static /* synthetic */ Modifier m330requiredSizeInqDBjuR0$default(Modifier modifier, float f5, float f6, float f7, float f8, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM();
        }
        if ((i5 & 2) != 0) {
            f6 = Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM();
        }
        if ((i5 & 4) != 0) {
            f7 = Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM();
        }
        if ((i5 & 8) != 0) {
            f8 = Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM();
        }
        return m329requiredSizeInqDBjuR0(modifier, f5, f6, f7, f8);
    }

    /* renamed from: size-3ABfNKs */
    public static final Modifier m331size3ABfNKs(Modifier modifier, final float f5) {
        return modifier.then(new SizeElement(f5, f5, f5, f5, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$size-3ABfNKs$$inlined$debugInspectorInfo$1
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
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* renamed from: size-6HolHcs */
    public static final Modifier m332size6HolHcs(Modifier modifier, long j5) {
        return m333sizeVpY3zN4(modifier, DpSize.m2626getWidthD9Ej5fM(j5), DpSize.m2625getHeightD9Ej5fM(j5));
    }

    /* renamed from: size-VpY3zN4 */
    public static final Modifier m333sizeVpY3zN4(Modifier modifier, final float f5, final float f6) {
        return modifier.then(new SizeElement(f5, f6, f5, f6, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$size-VpY3zN4$$inlined$debugInspectorInfo$1
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
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* renamed from: sizeIn-qDBjuR0 */
    public static final Modifier m334sizeInqDBjuR0(Modifier modifier, final float f5, final float f6, final float f7, final float f8) {
        return modifier.then(new SizeElement(f5, f6, f7, f8, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$sizeIn-qDBjuR0$$inlined$debugInspectorInfo$1
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
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* renamed from: sizeIn-qDBjuR0$default */
    public static /* synthetic */ Modifier m335sizeInqDBjuR0$default(Modifier modifier, float f5, float f6, float f7, float f8, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM();
        }
        if ((i5 & 2) != 0) {
            f6 = Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM();
        }
        if ((i5 & 4) != 0) {
            f7 = Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM();
        }
        if ((i5 & 8) != 0) {
            f8 = Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM();
        }
        return m334sizeInqDBjuR0(modifier, f5, f6, f7, f8);
    }

    /* renamed from: width-3ABfNKs */
    public static final Modifier m336width3ABfNKs(Modifier modifier, final float f5) {
        return modifier.then(new SizeElement(f5, 0.0f, f5, 0.0f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$width-3ABfNKs$$inlined$debugInspectorInfo$1
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
        } : InspectableValueKt.getNoInspectorInfo(), 10, null));
    }

    /* renamed from: widthIn-VpY3zN4 */
    public static final Modifier m337widthInVpY3zN4(Modifier modifier, final float f5, final float f6) {
        return modifier.then(new SizeElement(f5, 0.0f, f6, 0.0f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$widthIn-VpY3zN4$$inlined$debugInspectorInfo$1
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
        } : InspectableValueKt.getNoInspectorInfo(), 10, null));
    }

    /* renamed from: widthIn-VpY3zN4$default */
    public static /* synthetic */ Modifier m338widthInVpY3zN4$default(Modifier modifier, float f5, float f6, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM();
        }
        if ((i5 & 2) != 0) {
            f6 = Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM();
        }
        return m337widthInVpY3zN4(modifier, f5, f6);
    }

    public static final Modifier wrapContentHeight(Modifier modifier, Alignment.Vertical vertical, boolean z5) {
        Alignment.Companion companion = Alignment.INSTANCE;
        return modifier.then((!Intrinsics.areEqual(vertical, companion.getCenterVertically()) || z5) ? (!Intrinsics.areEqual(vertical, companion.getTop()) || z5) ? WrapContentElement.INSTANCE.height(vertical, z5) : WrapContentHeightTop : WrapContentHeightCenter);
    }

    public static /* synthetic */ Modifier wrapContentHeight$default(Modifier modifier, Alignment.Vertical vertical, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            vertical = Alignment.INSTANCE.getCenterVertically();
        }
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        return wrapContentHeight(modifier, vertical, z5);
    }

    public static final Modifier wrapContentSize(Modifier modifier, Alignment alignment, boolean z5) {
        Alignment.Companion companion = Alignment.INSTANCE;
        return modifier.then((!Intrinsics.areEqual(alignment, companion.getCenter()) || z5) ? (!Intrinsics.areEqual(alignment, companion.getTopStart()) || z5) ? WrapContentElement.INSTANCE.size(alignment, z5) : WrapContentSizeTopStart : WrapContentSizeCenter);
    }

    public static /* synthetic */ Modifier wrapContentSize$default(Modifier modifier, Alignment alignment, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            alignment = Alignment.INSTANCE.getCenter();
        }
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        return wrapContentSize(modifier, alignment, z5);
    }
}
