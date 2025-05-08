package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;", "mainAxisMin", BuildConfig.FLAVOR, "crossAxisMin", "mainAxisMax", "crossAxisMax", "arrangementSpacingInt", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/Measurable;", "placeables", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/Placeable;", "startIndex", "endIndex", "crossAxisOffset", BuildConfig.FLAVOR, "currentLineIndex", "(Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;IIIIILandroidx/compose/ui/layout/MeasureScope;Ljava/util/List;[Landroidx/compose/ui/layout/Placeable;II[II)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class RowColumnMeasurePolicyKt {
    public static final MeasureResult measure(RowColumnMeasurePolicy rowColumnMeasurePolicy, int i5, int i6, int i7, int i8, int i9, MeasureScope measureScope, List<? extends Measurable> list, Placeable[] placeableArr, int i10, int i11, int[] iArr, int i12) {
        int[] iArr2;
        long j5;
        long j6;
        String str;
        String str2;
        int i13;
        Integer num;
        int i14;
        int coerceIn;
        int i15;
        String str3;
        int i16;
        float f5;
        String str4;
        float f6;
        long j7;
        long j8;
        String str5;
        String str6;
        String str7;
        String str8;
        int i17;
        int i18;
        String str9;
        float f7;
        int i19;
        int i20;
        float f8;
        String str10;
        long j9;
        int i21;
        String str11;
        String str12;
        int i22;
        int i23;
        float f9;
        float f10;
        char c5;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        long j10;
        int[] iArr3;
        int i31;
        int i32;
        float f11;
        int[] iArr4;
        int i33;
        List<? extends Measurable> list2 = list;
        int i34 = i11;
        int i35 = i34 - i10;
        int i36 = 0;
        int i37 = i10;
        int i38 = 0;
        int i39 = 0;
        int i40 = 0;
        int i41 = 0;
        int[] iArr5 = new int[i35];
        long j11 = i9;
        float f12 = 0.0f;
        int i42 = 0;
        while (true) {
            if (i37 >= i34) {
                break;
            }
            int i43 = i42;
            Measurable measurable = list2.get(i37);
            RowColumnParentData rowColumnParentData = RowColumnImplKt.getRowColumnParentData(measurable);
            float weight = RowColumnImplKt.getWeight(rowColumnParentData);
            i41 = (i41 != 0 || RowColumnImplKt.isRelative(rowColumnParentData)) ? 1 : i36;
            if (weight > 0.0f) {
                i40++;
                i30 = i37;
                j10 = j11;
                iArr4 = iArr5;
                i32 = i35;
                f11 = f12 + weight;
                i33 = i36;
            } else {
                if (i8 != Integer.MAX_VALUE && rowColumnParentData != null) {
                    rowColumnParentData.getFlowLayoutData();
                }
                int i44 = i7 - i39;
                Placeable placeable = placeableArr[i37];
                if (placeable == null) {
                    i27 = i44;
                    i28 = i39;
                    i29 = i40;
                    i30 = i37;
                    iArr3 = iArr5;
                    j10 = j11;
                    i31 = i43;
                    i32 = i35;
                    f11 = f12;
                    placeable = measurable.mo1946measureBRTryo0(RowColumnMeasurePolicy.m322createConstraintsxF2OJ5Q$default(rowColumnMeasurePolicy, 0, 0, i7 != Integer.MAX_VALUE ? RangesKt.coerceAtLeast(i44, i36) : Integer.MAX_VALUE, i8, false, 16, null));
                } else {
                    i27 = i44;
                    i28 = i39;
                    i29 = i40;
                    i30 = i37;
                    j10 = j11;
                    iArr3 = iArr5;
                    i31 = i43;
                    i32 = i35;
                    f11 = f12;
                }
                Placeable placeable2 = placeable;
                int mainAxisSize = rowColumnMeasurePolicy.mainAxisSize(placeable2);
                int crossAxisSize = rowColumnMeasurePolicy.crossAxisSize(placeable2);
                iArr4 = iArr3;
                iArr4[i30 - i10] = mainAxisSize;
                i33 = 0;
                int min = Math.min(i9, RangesKt.coerceAtLeast(i27 - mainAxisSize, 0));
                i39 = mainAxisSize + min + i28;
                int max = Math.max(i31, crossAxisSize);
                placeableArr[i30] = placeable2;
                i43 = max;
                i38 = min;
                i40 = i29;
            }
            i37 = i30 + 1;
            iArr5 = iArr4;
            i36 = i33;
            f12 = f11;
            i35 = i32;
            i42 = i43;
            j11 = j10;
        }
        int i45 = i42;
        long j12 = j11;
        int[] iArr6 = iArr5;
        int i46 = i35;
        float f13 = f12;
        int i47 = i36;
        int i48 = i39;
        int i49 = i40;
        if (i49 == 0) {
            i15 = i48 - i38;
            iArr2 = iArr6;
            coerceIn = i47;
            i13 = i5;
            i14 = i45;
            num = null;
        } else {
            int i50 = i7 != Integer.MAX_VALUE ? i7 : i5;
            iArr2 = iArr6;
            long j13 = (i49 - 1) * j12;
            long coerceAtLeast = RangesKt.coerceAtLeast((i50 - i48) - j13, 0L);
            float f14 = ((float) coerceAtLeast) / f13;
            int i51 = i10;
            long j14 = coerceAtLeast;
            while (true) {
                j5 = coerceAtLeast;
                j6 = j13;
                str = "arrangementSpacingPx ";
                str2 = "targetSpace ";
                if (i51 >= i34) {
                    break;
                }
                float weight2 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(list2.get(i51)));
                float f15 = f14 * weight2;
                try {
                    j14 -= Math.round(f15);
                    i51++;
                    list2 = list;
                    i34 = i11;
                    coerceAtLeast = j5;
                    j13 = j6;
                } catch (IllegalArgumentException e5) {
                    throw new IllegalArgumentException("This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/297974033 mainAxisMax " + i7 + "mainAxisMin " + i5 + "targetSpace " + i50 + "arrangementSpacingPx " + j12 + "weightChildrenCount " + i49 + "fixedSpace " + i48 + "arrangementSpacingTotal " + j6 + "remainingToTarget " + j5 + "totalWeight " + f13 + "weightUnitSpace " + f14 + "itemWeight " + weight2 + "weightedSize " + f15).initCause(e5);
                }
            }
            i13 = i5;
            float f16 = f13;
            String str13 = "weightedSize ";
            String str14 = "weightUnitSpace ";
            String str15 = "totalWeight ";
            long j15 = j5;
            String str16 = "remainingToTarget ";
            long j16 = j6;
            String str17 = "arrangementSpacingTotal ";
            long j17 = j12;
            int i52 = i45;
            int i53 = 0;
            int i54 = i10;
            int i55 = i11;
            while (i54 < i55) {
                if (placeableArr[i54] == null) {
                    Measurable measurable2 = list.get(i54);
                    RowColumnParentData rowColumnParentData2 = RowColumnImplKt.getRowColumnParentData(measurable2);
                    float weight3 = RowColumnImplKt.getWeight(rowColumnParentData2);
                    String str18 = str;
                    int i56 = i50;
                    if (i8 != Integer.MAX_VALUE && rowColumnParentData2 != null) {
                        rowColumnParentData2.getFlowLayoutData();
                    }
                    if (weight3 <= 0.0f) {
                        throw new IllegalStateException("All weights <= 0 should have placeables");
                    }
                    int sign = MathKt.getSign(j14);
                    String str19 = str2;
                    j14 -= sign;
                    float f17 = f14 * weight3;
                    int max2 = Math.max(0, Math.round(f17) + sign);
                    try {
                    } catch (IllegalArgumentException e6) {
                        e = e6;
                        f7 = f17;
                        i19 = i49;
                        i20 = i48;
                        f8 = weight3;
                        str10 = str13;
                        j9 = j16;
                        i21 = i56;
                        str11 = str18;
                        str12 = str19;
                        i22 = sign;
                        i23 = max2;
                        f9 = f14;
                        f10 = f16;
                        j7 = j17;
                    }
                    try {
                        if (RowColumnImplKt.getFill(rowColumnParentData2)) {
                            c5 = 65535;
                            if (max2 != Integer.MAX_VALUE) {
                                i24 = max2;
                                j9 = j16;
                                str11 = str18;
                                i22 = sign;
                                i23 = max2;
                                str12 = str19;
                                int i57 = i24;
                                f7 = f17;
                                i21 = i56;
                                i19 = i49;
                                i20 = i48;
                                f8 = weight3;
                                f9 = f14;
                                str10 = str13;
                                f10 = f16;
                                j7 = j17;
                                Placeable mo1946measureBRTryo0 = measurable2.mo1946measureBRTryo0(rowColumnMeasurePolicy.mo279createConstraintsxF2OJ5Q(i57, 0, i23, i8, true));
                                int mainAxisSize2 = rowColumnMeasurePolicy.mainAxisSize(mo1946measureBRTryo0);
                                int crossAxisSize2 = rowColumnMeasurePolicy.crossAxisSize(mo1946measureBRTryo0);
                                iArr2[i54 - i10] = mainAxisSize2;
                                i53 += mainAxisSize2;
                                int max3 = Math.max(i52, crossAxisSize2);
                                placeableArr[i54] = mo1946measureBRTryo0;
                                i52 = max3;
                                str4 = str10;
                                f6 = f10;
                                f5 = f9;
                                j8 = j15;
                                str5 = str14;
                                str6 = str15;
                                str7 = str16;
                                str8 = str17;
                                j16 = j9;
                                str3 = str11;
                                str9 = str12;
                                i17 = i21;
                                i18 = i19;
                                i16 = i20;
                            }
                        } else {
                            c5 = 65535;
                        }
                        Placeable mo1946measureBRTryo02 = measurable2.mo1946measureBRTryo0(rowColumnMeasurePolicy.mo279createConstraintsxF2OJ5Q(i57, 0, i23, i8, true));
                        int mainAxisSize22 = rowColumnMeasurePolicy.mainAxisSize(mo1946measureBRTryo02);
                        int crossAxisSize22 = rowColumnMeasurePolicy.crossAxisSize(mo1946measureBRTryo02);
                        iArr2[i54 - i10] = mainAxisSize22;
                        i53 += mainAxisSize22;
                        int max32 = Math.max(i52, crossAxisSize22);
                        placeableArr[i54] = mo1946measureBRTryo02;
                        i52 = max32;
                        str4 = str10;
                        f6 = f10;
                        f5 = f9;
                        j8 = j15;
                        str5 = str14;
                        str6 = str15;
                        str7 = str16;
                        str8 = str17;
                        j16 = j9;
                        str3 = str11;
                        str9 = str12;
                        i17 = i21;
                        i18 = i19;
                        i16 = i20;
                    } catch (IllegalArgumentException e7) {
                        e = e7;
                        throw new IllegalArgumentException("This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/300280216 mainAxisMax " + i7 + "mainAxisMin " + i13 + str12 + i21 + str11 + j7 + "weightChildrenCount " + i19 + "fixedSpace " + i20 + str17 + j9 + str16 + j15 + str15 + f10 + str14 + f9 + "weight " + f8 + str10 + f7 + "crossAxisDesiredSize " + ((Object) null) + "remainderUnit " + i22 + "childMainAxisSize " + i23).initCause(e);
                    }
                    i24 = 0;
                    j9 = j16;
                    str11 = str18;
                    i22 = sign;
                    i23 = max2;
                    str12 = str19;
                    int i572 = i24;
                    f7 = f17;
                    i21 = i56;
                    i19 = i49;
                    i20 = i48;
                    f8 = weight3;
                    f9 = f14;
                    str10 = str13;
                    f10 = f16;
                    j7 = j17;
                } else {
                    str3 = str;
                    i16 = i48;
                    f5 = f14;
                    str4 = str13;
                    f6 = f16;
                    j7 = j17;
                    j8 = j15;
                    str5 = str14;
                    str6 = str15;
                    str7 = str16;
                    str8 = str17;
                    i17 = i50;
                    i18 = i49;
                    str9 = str2;
                }
                i54++;
                str2 = str9;
                i50 = i17;
                str = str3;
                i49 = i18;
                i48 = i16;
                j15 = j8;
                f14 = f5;
                str14 = str5;
                str15 = str6;
                str16 = str7;
                str17 = str8;
                i55 = i11;
                j17 = j7;
                f16 = f6;
                str13 = str4;
            }
            int i58 = i48;
            num = null;
            i14 = i52;
            coerceIn = RangesKt.coerceIn((int) (i53 + j16), 0, i7 - i58);
            i15 = i58;
        }
        if (i41 != 0) {
            int i59 = 0;
            int i60 = 0;
            for (int i61 = i10; i61 < i11; i61++) {
                Placeable placeable3 = placeableArr[i61];
                Intrinsics.checkNotNull(placeable3);
                CrossAxisAlignment crossAxisAlignment = RowColumnImplKt.getCrossAxisAlignment(RowColumnImplKt.getRowColumnParentData(placeable3));
                Integer calculateAlignmentLinePosition$foundation_layout_release = crossAxisAlignment != null ? crossAxisAlignment.calculateAlignmentLinePosition$foundation_layout_release(placeable3) : num;
                if (calculateAlignmentLinePosition$foundation_layout_release != null) {
                    int intValue = calculateAlignmentLinePosition$foundation_layout_release.intValue();
                    int crossAxisSize3 = rowColumnMeasurePolicy.crossAxisSize(placeable3);
                    i59 = Math.max(i59, intValue != Integer.MIN_VALUE ? calculateAlignmentLinePosition$foundation_layout_release.intValue() : 0);
                    if (intValue == Integer.MIN_VALUE) {
                        intValue = crossAxisSize3;
                    }
                    i60 = Math.max(i60, crossAxisSize3 - intValue);
                }
            }
            i25 = i60;
            i26 = i59;
        } else {
            i25 = 0;
            i26 = 0;
        }
        int max4 = Math.max(RangesKt.coerceAtLeast(i15 + coerceIn, 0), i13);
        int max5 = Math.max(i14, Math.max(i6, i25 + i26));
        int[] iArr7 = new int[i46];
        for (int i62 = 0; i62 < i46; i62++) {
            iArr7[i62] = 0;
        }
        rowColumnMeasurePolicy.populateMainAxisPositions(max4, iArr2, iArr7, measureScope);
        return rowColumnMeasurePolicy.placeHelper(placeableArr, measureScope, i26, iArr7, max4, max5, iArr, i12, i10, i11);
    }
}
