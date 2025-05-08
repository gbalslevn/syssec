package androidx.compose.foundation.layout;

import android.support.v4.media.session.a;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u001a>\u0010\b\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\b\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001e\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\r\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001b\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\b\u0010\u0012\u001a\u001b\u0010\u0015\u001a\u00020\u0001*\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001b\u0010\u0017\u001a\u00020\u0001*\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0017\u0010\u0016\u001a\u001a\u0010\u001a\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a&\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a:\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/Dp;", "start", "top", "end", "bottom", "padding-qDBjuR0", "(Landroidx/compose/ui/Modifier;FFFF)Landroidx/compose/ui/Modifier;", "padding", "horizontal", "vertical", "padding-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "all", "padding-3ABfNKs", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "Landroidx/compose/foundation/layout/PaddingValues;", "paddingValues", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "calculateStartPadding", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateEndPadding", "PaddingValues-0680j_4", "(F)Landroidx/compose/foundation/layout/PaddingValues;", "PaddingValues", "PaddingValues-YgX7TsA", "(FF)Landroidx/compose/foundation/layout/PaddingValues;", "PaddingValues-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PaddingKt {
    /* renamed from: PaddingValues-0680j_4, reason: not valid java name */
    public static final PaddingValues m306PaddingValues0680j_4(float f5) {
        return new PaddingValues(f5, f5, f5, f5, null);
    }

    /* renamed from: PaddingValues-YgX7TsA, reason: not valid java name */
    public static final PaddingValues m307PaddingValuesYgX7TsA(float f5, float f6) {
        return new PaddingValues(f5, f6, f5, f6, null);
    }

    /* renamed from: PaddingValues-YgX7TsA$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m308PaddingValuesYgX7TsA$default(float f5, float f6, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = Dp.m2599constructorimpl(0);
        }
        if ((i5 & 2) != 0) {
            f6 = Dp.m2599constructorimpl(0);
        }
        return m307PaddingValuesYgX7TsA(f5, f6);
    }

    /* renamed from: PaddingValues-a9UjIt4, reason: not valid java name */
    public static final PaddingValues m309PaddingValuesa9UjIt4(float f5, float f6, float f7, float f8) {
        return new PaddingValues(f5, f6, f7, f8, null);
    }

    /* renamed from: PaddingValues-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m310PaddingValuesa9UjIt4$default(float f5, float f6, float f7, float f8, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = Dp.m2599constructorimpl(0);
        }
        if ((i5 & 2) != 0) {
            f6 = Dp.m2599constructorimpl(0);
        }
        if ((i5 & 4) != 0) {
            f7 = Dp.m2599constructorimpl(0);
        }
        if ((i5 & 8) != 0) {
            f8 = Dp.m2599constructorimpl(0);
        }
        return m309PaddingValuesa9UjIt4(f5, f6, f7, f8);
    }

    public static final float calculateEndPadding(PaddingValues paddingValues, LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.Ltr ? paddingValues.mo291calculateRightPaddingu2uoSUM(layoutDirection) : paddingValues.mo290calculateLeftPaddingu2uoSUM(layoutDirection);
    }

    public static final float calculateStartPadding(PaddingValues paddingValues, LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.Ltr ? paddingValues.mo290calculateLeftPaddingu2uoSUM(layoutDirection) : paddingValues.mo291calculateRightPaddingu2uoSUM(layoutDirection);
    }

    public static final Modifier padding(Modifier modifier, final PaddingValues paddingValues) {
        return modifier.then(new PaddingValuesElement(paddingValues, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt$padding$4
            /* JADX INFO: Access modifiers changed from: package-private */
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
        }));
    }

    /* renamed from: padding-3ABfNKs, reason: not valid java name */
    public static final Modifier m311padding3ABfNKs(Modifier modifier, final float f5) {
        return modifier.then(new PaddingElement(f5, f5, f5, f5, true, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt$padding$3
            /* JADX INFO: Access modifiers changed from: package-private */
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
        }, null));
    }

    /* renamed from: padding-VpY3zN4, reason: not valid java name */
    public static final Modifier m312paddingVpY3zN4(Modifier modifier, final float f5, final float f6) {
        return modifier.then(new PaddingElement(f5, f6, f5, f6, true, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt$padding$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
        }, null));
    }

    /* renamed from: padding-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m313paddingVpY3zN4$default(Modifier modifier, float f5, float f6, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = Dp.m2599constructorimpl(0);
        }
        if ((i5 & 2) != 0) {
            f6 = Dp.m2599constructorimpl(0);
        }
        return m312paddingVpY3zN4(modifier, f5, f6);
    }

    /* renamed from: padding-qDBjuR0, reason: not valid java name */
    public static final Modifier m314paddingqDBjuR0(Modifier modifier, final float f5, final float f6, final float f7, final float f8) {
        return modifier.then(new PaddingElement(f5, f6, f7, f8, true, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt$padding$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
        }, null));
    }

    /* renamed from: padding-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m315paddingqDBjuR0$default(Modifier modifier, float f5, float f6, float f7, float f8, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = Dp.m2599constructorimpl(0);
        }
        if ((i5 & 2) != 0) {
            f6 = Dp.m2599constructorimpl(0);
        }
        if ((i5 & 4) != 0) {
            f7 = Dp.m2599constructorimpl(0);
        }
        if ((i5 & 8) != 0) {
            f8 = Dp.m2599constructorimpl(0);
        }
        return m314paddingqDBjuR0(modifier, f5, f6, f7, f8);
    }
}
