package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ8\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J<\u0010\u0011\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J\"\u0010\u0014\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u0015\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016J,\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00190\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\"\u0010\u001e\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u001f\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"Landroidx/compose/material3/TextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "singleLine", BuildConfig.FLAVOR, "animationProgress", BuildConfig.FLAVOR, "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "intrinsicWidth", BuildConfig.FLAVOR, "measurables", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "width", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldMeasurePolicy implements MeasurePolicy {
    private final float animationProgress;
    private final PaddingValues paddingValues;
    private final boolean singleLine;

    public TextFieldMeasurePolicy(boolean z5, float f5, PaddingValues paddingValues) {
        this.singleLine = z5;
        this.animationProgress = f5;
        this.paddingValues = paddingValues;
    }

    private final int intrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i5, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        IntrinsicMeasurable intrinsicMeasurable;
        int i6;
        int i7;
        IntrinsicMeasurable intrinsicMeasurable2;
        int i8;
        IntrinsicMeasurable intrinsicMeasurable3;
        IntrinsicMeasurable intrinsicMeasurable4;
        int i9;
        IntrinsicMeasurable intrinsicMeasurable5;
        int i10;
        IntrinsicMeasurable intrinsicMeasurable6;
        IntrinsicMeasurable intrinsicMeasurable7;
        int m938calculateHeightmKXJcVc;
        int size = list.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                intrinsicMeasurable = null;
                break;
            }
            intrinsicMeasurable = list.get(i11);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable), "Leading")) {
                break;
            }
            i11++;
        }
        IntrinsicMeasurable intrinsicMeasurable8 = intrinsicMeasurable;
        if (intrinsicMeasurable8 != null) {
            i6 = TextFieldKt.substractConstraintSafely(i5, intrinsicMeasurable8.maxIntrinsicWidth(Integer.MAX_VALUE));
            i7 = function2.invoke(intrinsicMeasurable8, Integer.valueOf(i5)).intValue();
        } else {
            i6 = i5;
            i7 = 0;
        }
        int size2 = list.size();
        int i12 = 0;
        while (true) {
            if (i12 >= size2) {
                intrinsicMeasurable2 = null;
                break;
            }
            intrinsicMeasurable2 = list.get(i12);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable2), "Trailing")) {
                break;
            }
            i12++;
        }
        IntrinsicMeasurable intrinsicMeasurable9 = intrinsicMeasurable2;
        if (intrinsicMeasurable9 != null) {
            i6 = TextFieldKt.substractConstraintSafely(i6, intrinsicMeasurable9.maxIntrinsicWidth(Integer.MAX_VALUE));
            i8 = function2.invoke(intrinsicMeasurable9, Integer.valueOf(i5)).intValue();
        } else {
            i8 = 0;
        }
        int size3 = list.size();
        int i13 = 0;
        while (true) {
            if (i13 >= size3) {
                intrinsicMeasurable3 = null;
                break;
            }
            intrinsicMeasurable3 = list.get(i13);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable3), "Label")) {
                break;
            }
            i13++;
        }
        IntrinsicMeasurable intrinsicMeasurable10 = intrinsicMeasurable3;
        int intValue = intrinsicMeasurable10 != null ? function2.invoke(intrinsicMeasurable10, Integer.valueOf(i6)).intValue() : 0;
        int size4 = list.size();
        int i14 = 0;
        while (true) {
            if (i14 >= size4) {
                intrinsicMeasurable4 = null;
                break;
            }
            intrinsicMeasurable4 = list.get(i14);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable4), "Prefix")) {
                break;
            }
            i14++;
        }
        IntrinsicMeasurable intrinsicMeasurable11 = intrinsicMeasurable4;
        if (intrinsicMeasurable11 != null) {
            int intValue2 = function2.invoke(intrinsicMeasurable11, Integer.valueOf(i6)).intValue();
            i6 = TextFieldKt.substractConstraintSafely(i6, intrinsicMeasurable11.maxIntrinsicWidth(Integer.MAX_VALUE));
            i9 = intValue2;
        } else {
            i9 = 0;
        }
        int size5 = list.size();
        int i15 = 0;
        while (true) {
            if (i15 >= size5) {
                intrinsicMeasurable5 = null;
                break;
            }
            intrinsicMeasurable5 = list.get(i15);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable5), "Suffix")) {
                break;
            }
            i15++;
        }
        IntrinsicMeasurable intrinsicMeasurable12 = intrinsicMeasurable5;
        if (intrinsicMeasurable12 != null) {
            i10 = function2.invoke(intrinsicMeasurable12, Integer.valueOf(i6)).intValue();
            i6 = TextFieldKt.substractConstraintSafely(i6, intrinsicMeasurable12.maxIntrinsicWidth(Integer.MAX_VALUE));
        } else {
            i10 = 0;
        }
        int size6 = list.size();
        for (int i16 = 0; i16 < size6; i16++) {
            IntrinsicMeasurable intrinsicMeasurable13 = list.get(i16);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable13), "TextField")) {
                int intValue3 = function2.invoke(intrinsicMeasurable13, Integer.valueOf(i6)).intValue();
                int size7 = list.size();
                int i17 = 0;
                while (true) {
                    if (i17 >= size7) {
                        intrinsicMeasurable6 = null;
                        break;
                    }
                    intrinsicMeasurable6 = list.get(i17);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable6), "Hint")) {
                        break;
                    }
                    i17++;
                }
                IntrinsicMeasurable intrinsicMeasurable14 = intrinsicMeasurable6;
                int intValue4 = intrinsicMeasurable14 != null ? function2.invoke(intrinsicMeasurable14, Integer.valueOf(i6)).intValue() : 0;
                int size8 = list.size();
                int i18 = 0;
                while (true) {
                    if (i18 >= size8) {
                        intrinsicMeasurable7 = null;
                        break;
                    }
                    intrinsicMeasurable7 = list.get(i18);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable7), "Supporting")) {
                        break;
                    }
                    i18++;
                }
                IntrinsicMeasurable intrinsicMeasurable15 = intrinsicMeasurable7;
                m938calculateHeightmKXJcVc = TextFieldKt.m938calculateHeightmKXJcVc(intValue3, intValue, i7, i8, i9, i10, intValue4, intrinsicMeasurable15 != null ? function2.invoke(intrinsicMeasurable15, Integer.valueOf(i5)).intValue() : 0, this.animationProgress, TextFieldImplKt.getZeroConstraints(), intrinsicMeasureScope.getDensity(), this.paddingValues);
                return m938calculateHeightmKXJcVc;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final int intrinsicWidth(List<? extends IntrinsicMeasurable> measurables, int height, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> intrinsicMeasurer) {
        IntrinsicMeasurable intrinsicMeasurable;
        IntrinsicMeasurable intrinsicMeasurable2;
        IntrinsicMeasurable intrinsicMeasurable3;
        IntrinsicMeasurable intrinsicMeasurable4;
        IntrinsicMeasurable intrinsicMeasurable5;
        IntrinsicMeasurable intrinsicMeasurable6;
        int m939calculateWidthyeHjK3Y;
        int size = measurables.size();
        for (int i5 = 0; i5 < size; i5++) {
            IntrinsicMeasurable intrinsicMeasurable7 = measurables.get(i5);
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable7), "TextField")) {
                int intValue = intrinsicMeasurer.invoke(intrinsicMeasurable7, Integer.valueOf(height)).intValue();
                int size2 = measurables.size();
                int i6 = 0;
                while (true) {
                    intrinsicMeasurable = null;
                    if (i6 >= size2) {
                        intrinsicMeasurable2 = null;
                        break;
                    }
                    intrinsicMeasurable2 = measurables.get(i6);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable2), "Label")) {
                        break;
                    }
                    i6++;
                }
                IntrinsicMeasurable intrinsicMeasurable8 = intrinsicMeasurable2;
                int intValue2 = intrinsicMeasurable8 != null ? intrinsicMeasurer.invoke(intrinsicMeasurable8, Integer.valueOf(height)).intValue() : 0;
                int size3 = measurables.size();
                int i7 = 0;
                while (true) {
                    if (i7 >= size3) {
                        intrinsicMeasurable3 = null;
                        break;
                    }
                    intrinsicMeasurable3 = measurables.get(i7);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable3), "Trailing")) {
                        break;
                    }
                    i7++;
                }
                IntrinsicMeasurable intrinsicMeasurable9 = intrinsicMeasurable3;
                int intValue3 = intrinsicMeasurable9 != null ? intrinsicMeasurer.invoke(intrinsicMeasurable9, Integer.valueOf(height)).intValue() : 0;
                int size4 = measurables.size();
                int i8 = 0;
                while (true) {
                    if (i8 >= size4) {
                        intrinsicMeasurable4 = null;
                        break;
                    }
                    intrinsicMeasurable4 = measurables.get(i8);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable4), "Prefix")) {
                        break;
                    }
                    i8++;
                }
                IntrinsicMeasurable intrinsicMeasurable10 = intrinsicMeasurable4;
                int intValue4 = intrinsicMeasurable10 != null ? intrinsicMeasurer.invoke(intrinsicMeasurable10, Integer.valueOf(height)).intValue() : 0;
                int size5 = measurables.size();
                int i9 = 0;
                while (true) {
                    if (i9 >= size5) {
                        intrinsicMeasurable5 = null;
                        break;
                    }
                    intrinsicMeasurable5 = measurables.get(i9);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable5), "Suffix")) {
                        break;
                    }
                    i9++;
                }
                IntrinsicMeasurable intrinsicMeasurable11 = intrinsicMeasurable5;
                int intValue5 = intrinsicMeasurable11 != null ? intrinsicMeasurer.invoke(intrinsicMeasurable11, Integer.valueOf(height)).intValue() : 0;
                int size6 = measurables.size();
                int i10 = 0;
                while (true) {
                    if (i10 >= size6) {
                        intrinsicMeasurable6 = null;
                        break;
                    }
                    intrinsicMeasurable6 = measurables.get(i10);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable6), "Leading")) {
                        break;
                    }
                    i10++;
                }
                IntrinsicMeasurable intrinsicMeasurable12 = intrinsicMeasurable6;
                int intValue6 = intrinsicMeasurable12 != null ? intrinsicMeasurer.invoke(intrinsicMeasurable12, Integer.valueOf(height)).intValue() : 0;
                int size7 = measurables.size();
                int i11 = 0;
                while (true) {
                    if (i11 >= size7) {
                        break;
                    }
                    IntrinsicMeasurable intrinsicMeasurable13 = measurables.get(i11);
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId(intrinsicMeasurable13), "Hint")) {
                        intrinsicMeasurable = intrinsicMeasurable13;
                        break;
                    }
                    i11++;
                }
                IntrinsicMeasurable intrinsicMeasurable14 = intrinsicMeasurable;
                m939calculateWidthyeHjK3Y = TextFieldKt.m939calculateWidthyeHjK3Y(intValue6, intValue3, intValue4, intValue5, intValue, intValue2, intrinsicMeasurable14 != null ? intrinsicMeasurer.invoke(intrinsicMeasurable14, Integer.valueOf(height)).intValue() : 0, TextFieldImplKt.getZeroConstraints());
                return m939calculateWidthyeHjK3Y;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i5) {
        return intrinsicHeight(intrinsicMeasureScope, list, i5, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.TextFieldMeasurePolicy$maxIntrinsicHeight$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
                return invoke(intrinsicMeasurable, num.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i6) {
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i6));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i5) {
        return intrinsicWidth(list, i5, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.TextFieldMeasurePolicy$maxIntrinsicWidth$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
                return invoke(intrinsicMeasurable, num.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i6) {
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i6));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo19measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, long j5) {
        Measurable measurable;
        Measurable measurable2;
        Measurable measurable3;
        Measurable measurable4;
        Measurable measurable5;
        Measurable measurable6;
        Measurable measurable7;
        final int m939calculateWidthyeHjK3Y;
        final int m938calculateHeightmKXJcVc;
        List<? extends Measurable> list2 = list;
        final int mo206roundToPx0680j_4 = measureScope.mo206roundToPx0680j_4(this.paddingValues.getTop());
        int mo206roundToPx0680j_42 = measureScope.mo206roundToPx0680j_4(this.paddingValues.getBottom());
        long m2570copyZbe2FdA$default = Constraints.m2570copyZbe2FdA$default(j5, 0, 0, 0, 0, 10, null);
        int size = list.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                measurable = null;
                break;
            }
            measurable = list2.get(i5);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "Leading")) {
                break;
            }
            i5++;
        }
        Measurable measurable8 = measurable;
        final Placeable mo1946measureBRTryo0 = measurable8 != null ? measurable8.mo1946measureBRTryo0(m2570copyZbe2FdA$default) : null;
        int widthOrZero = TextFieldImplKt.widthOrZero(mo1946measureBRTryo0);
        int max = Math.max(0, TextFieldImplKt.heightOrZero(mo1946measureBRTryo0));
        int size2 = list.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size2) {
                measurable2 = null;
                break;
            }
            measurable2 = list2.get(i6);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "Trailing")) {
                break;
            }
            i6++;
        }
        Measurable measurable9 = measurable2;
        Placeable mo1946measureBRTryo02 = measurable9 != null ? measurable9.mo1946measureBRTryo0(ConstraintsKt.m2596offsetNN6EwU$default(m2570copyZbe2FdA$default, -widthOrZero, 0, 2, null)) : null;
        int widthOrZero2 = widthOrZero + TextFieldImplKt.widthOrZero(mo1946measureBRTryo02);
        int max2 = Math.max(max, TextFieldImplKt.heightOrZero(mo1946measureBRTryo02));
        int size3 = list.size();
        int i7 = 0;
        while (true) {
            if (i7 >= size3) {
                measurable3 = null;
                break;
            }
            measurable3 = list2.get(i7);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "Prefix")) {
                break;
            }
            i7++;
        }
        Measurable measurable10 = measurable3;
        final Placeable mo1946measureBRTryo03 = measurable10 != null ? measurable10.mo1946measureBRTryo0(ConstraintsKt.m2596offsetNN6EwU$default(m2570copyZbe2FdA$default, -widthOrZero2, 0, 2, null)) : null;
        int widthOrZero3 = widthOrZero2 + TextFieldImplKt.widthOrZero(mo1946measureBRTryo03);
        int max3 = Math.max(max2, TextFieldImplKt.heightOrZero(mo1946measureBRTryo03));
        int size4 = list.size();
        int i8 = 0;
        while (true) {
            if (i8 >= size4) {
                measurable4 = null;
                break;
            }
            measurable4 = list2.get(i8);
            int i9 = size4;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable4), "Suffix")) {
                break;
            }
            i8++;
            size4 = i9;
        }
        Measurable measurable11 = measurable4;
        Placeable mo1946measureBRTryo04 = measurable11 != null ? measurable11.mo1946measureBRTryo0(ConstraintsKt.m2596offsetNN6EwU$default(m2570copyZbe2FdA$default, -widthOrZero3, 0, 2, null)) : null;
        int widthOrZero4 = widthOrZero3 + TextFieldImplKt.widthOrZero(mo1946measureBRTryo04);
        int max4 = Math.max(max3, TextFieldImplKt.heightOrZero(mo1946measureBRTryo04));
        int i10 = -widthOrZero4;
        long m2595offsetNN6EwU = ConstraintsKt.m2595offsetNN6EwU(m2570copyZbe2FdA$default, i10, -mo206roundToPx0680j_42);
        int size5 = list.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size5) {
                measurable5 = null;
                break;
            }
            Measurable measurable12 = list2.get(i11);
            int i12 = size5;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable12), "Label")) {
                measurable5 = measurable12;
                break;
            }
            i11++;
            size5 = i12;
        }
        Measurable measurable13 = measurable5;
        Placeable mo1946measureBRTryo05 = measurable13 != null ? measurable13.mo1946measureBRTryo0(m2595offsetNN6EwU) : null;
        int size6 = list.size();
        int i13 = 0;
        while (true) {
            if (i13 >= size6) {
                measurable6 = null;
                break;
            }
            measurable6 = list2.get(i13);
            int i14 = size6;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable6), "Supporting")) {
                break;
            }
            i13++;
            size6 = i14;
        }
        Measurable measurable14 = measurable6;
        int minIntrinsicHeight = measurable14 != null ? measurable14.minIntrinsicHeight(Constraints.m2580getMinWidthimpl(j5)) : 0;
        int heightOrZero = TextFieldImplKt.heightOrZero(mo1946measureBRTryo05) + mo206roundToPx0680j_4;
        long m2595offsetNN6EwU2 = ConstraintsKt.m2595offsetNN6EwU(Constraints.m2570copyZbe2FdA$default(j5, 0, 0, 0, 0, 11, null), i10, ((-heightOrZero) - mo206roundToPx0680j_42) - minIntrinsicHeight);
        int size7 = list.size();
        int i15 = 0;
        while (i15 < size7) {
            int i16 = size7;
            Measurable measurable15 = list2.get(i15);
            int i17 = i15;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable15), "TextField")) {
                final Placeable mo1946measureBRTryo06 = measurable15.mo1946measureBRTryo0(m2595offsetNN6EwU2);
                long m2570copyZbe2FdA$default2 = Constraints.m2570copyZbe2FdA$default(m2595offsetNN6EwU2, 0, 0, 0, 0, 14, null);
                int size8 = list.size();
                int i18 = 0;
                while (true) {
                    if (i18 >= size8) {
                        measurable7 = null;
                        break;
                    }
                    measurable7 = list2.get(i18);
                    int i19 = size8;
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable7), "Hint")) {
                        break;
                    }
                    i18++;
                    list2 = list;
                    size8 = i19;
                }
                Measurable measurable16 = measurable7;
                Placeable mo1946measureBRTryo07 = measurable16 != null ? measurable16.mo1946measureBRTryo0(m2570copyZbe2FdA$default2) : null;
                int max5 = Math.max(max4, Math.max(TextFieldImplKt.heightOrZero(mo1946measureBRTryo06), TextFieldImplKt.heightOrZero(mo1946measureBRTryo07)) + heightOrZero + mo206roundToPx0680j_42);
                m939calculateWidthyeHjK3Y = TextFieldKt.m939calculateWidthyeHjK3Y(TextFieldImplKt.widthOrZero(mo1946measureBRTryo0), TextFieldImplKt.widthOrZero(mo1946measureBRTryo02), TextFieldImplKt.widthOrZero(mo1946measureBRTryo03), TextFieldImplKt.widthOrZero(mo1946measureBRTryo04), mo1946measureBRTryo06.getWidth(), TextFieldImplKt.widthOrZero(mo1946measureBRTryo05), TextFieldImplKt.widthOrZero(mo1946measureBRTryo07), j5);
                Placeable mo1946measureBRTryo08 = measurable14 != null ? measurable14.mo1946measureBRTryo0(Constraints.m2570copyZbe2FdA$default(ConstraintsKt.m2596offsetNN6EwU$default(m2570copyZbe2FdA$default, 0, -max5, 1, null), 0, m939calculateWidthyeHjK3Y, 0, 0, 9, null)) : null;
                int heightOrZero2 = TextFieldImplKt.heightOrZero(mo1946measureBRTryo08);
                m938calculateHeightmKXJcVc = TextFieldKt.m938calculateHeightmKXJcVc(mo1946measureBRTryo06.getHeight(), TextFieldImplKt.heightOrZero(mo1946measureBRTryo05), TextFieldImplKt.heightOrZero(mo1946measureBRTryo0), TextFieldImplKt.heightOrZero(mo1946measureBRTryo02), TextFieldImplKt.heightOrZero(mo1946measureBRTryo03), TextFieldImplKt.heightOrZero(mo1946measureBRTryo04), TextFieldImplKt.heightOrZero(mo1946measureBRTryo07), TextFieldImplKt.heightOrZero(mo1946measureBRTryo08), this.animationProgress, j5, measureScope.getDensity(), this.paddingValues);
                int i20 = m938calculateHeightmKXJcVc - heightOrZero2;
                int size9 = list.size();
                for (int i21 = 0; i21 < size9; i21++) {
                    Measurable measurable17 = list.get(i21);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable17), "Container")) {
                        final Placeable mo1946measureBRTryo09 = measurable17.mo1946measureBRTryo0(ConstraintsKt.Constraints(m939calculateWidthyeHjK3Y != Integer.MAX_VALUE ? m939calculateWidthyeHjK3Y : 0, m939calculateWidthyeHjK3Y, i20 != Integer.MAX_VALUE ? i20 : 0, i20));
                        final Placeable placeable = mo1946measureBRTryo05;
                        final Placeable placeable2 = mo1946measureBRTryo07;
                        final Placeable placeable3 = mo1946measureBRTryo02;
                        final Placeable placeable4 = mo1946measureBRTryo04;
                        final Placeable placeable5 = mo1946measureBRTryo08;
                        return MeasureScope.layout$default(measureScope, m939calculateWidthyeHjK3Y, m938calculateHeightmKXJcVc, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TextFieldMeasurePolicy$measure$1
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
                                boolean z5;
                                PaddingValues paddingValues;
                                boolean z6;
                                float f5;
                                Placeable placeable6 = Placeable.this;
                                if (placeable6 != null) {
                                    int i22 = m939calculateWidthyeHjK3Y;
                                    int i23 = m938calculateHeightmKXJcVc;
                                    Placeable placeable7 = mo1946measureBRTryo06;
                                    Placeable placeable8 = placeable2;
                                    Placeable placeable9 = mo1946measureBRTryo0;
                                    Placeable placeable10 = placeable3;
                                    Placeable placeable11 = mo1946measureBRTryo03;
                                    Placeable placeable12 = placeable4;
                                    Placeable placeable13 = mo1946measureBRTryo09;
                                    Placeable placeable14 = placeable5;
                                    z6 = this.singleLine;
                                    int i24 = mo206roundToPx0680j_4;
                                    int height = Placeable.this.getHeight() + i24;
                                    f5 = this.animationProgress;
                                    TextFieldKt.placeWithLabel(placementScope, i22, i23, placeable7, placeable6, placeable8, placeable9, placeable10, placeable11, placeable12, placeable13, placeable14, z6, i24, height, f5, measureScope.getDensity());
                                    return;
                                }
                                int i25 = m939calculateWidthyeHjK3Y;
                                int i26 = m938calculateHeightmKXJcVc;
                                Placeable placeable15 = mo1946measureBRTryo06;
                                Placeable placeable16 = placeable2;
                                Placeable placeable17 = mo1946measureBRTryo0;
                                Placeable placeable18 = placeable3;
                                Placeable placeable19 = mo1946measureBRTryo03;
                                Placeable placeable20 = placeable4;
                                Placeable placeable21 = mo1946measureBRTryo09;
                                Placeable placeable22 = placeable5;
                                z5 = this.singleLine;
                                float density = measureScope.getDensity();
                                paddingValues = this.paddingValues;
                                TextFieldKt.placeWithoutLabel(placementScope, i25, i26, placeable15, placeable16, placeable17, placeable18, placeable19, placeable20, placeable21, placeable22, z5, density, paddingValues);
                            }
                        }, 4, null);
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            i15 = i17 + 1;
            size7 = i16;
            list2 = list;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i5) {
        return intrinsicHeight(intrinsicMeasureScope, list, i5, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.TextFieldMeasurePolicy$minIntrinsicHeight$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
                return invoke(intrinsicMeasurable, num.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i6) {
                return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(i6));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i5) {
        return intrinsicWidth(list, i5, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.TextFieldMeasurePolicy$minIntrinsicWidth$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
                return invoke(intrinsicMeasurable, num.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i6) {
                return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(i6));
            }
        });
    }
}
