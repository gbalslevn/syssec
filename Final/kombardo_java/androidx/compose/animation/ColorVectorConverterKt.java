package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\",\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006\"-\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0000*\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lkotlin/Function1;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/animation/core/AnimationVector4D;", "ColorToVector", "Lkotlin/jvm/functions/Function1;", "Landroidx/compose/ui/graphics/Color$Companion;", "getVectorConverter", "(Landroidx/compose/ui/graphics/Color$Companion;)Lkotlin/jvm/functions/Function1;", "VectorConverter", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ColorVectorConverterKt {
    private static final Function1<ColorSpace, TwoWayConverter<Color, AnimationVector4D>> ColorToVector = new Function1<ColorSpace, TwoWayConverter<Color, AnimationVector4D>>() { // from class: androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1
        @Override // kotlin.jvm.functions.Function1
        public final TwoWayConverter<Color, AnimationVector4D> invoke(final ColorSpace colorSpace) {
            return VectorConvertersKt.TwoWayConverter(new Function1<Color, AnimationVector4D>() { // from class: androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ AnimationVector4D invoke(Color color) {
                    return m26invoke8_81llA(color.getValue());
                }

                /* renamed from: invoke-8_81llA, reason: not valid java name */
                public final AnimationVector4D m26invoke8_81llA(long j5) {
                    long m1483convertvNxB06k = Color.m1483convertvNxB06k(j5, ColorSpaces.INSTANCE.getOklab());
                    return new AnimationVector4D(Color.m1488getAlphaimpl(m1483convertvNxB06k), Color.m1492getRedimpl(m1483convertvNxB06k), Color.m1491getGreenimpl(m1483convertvNxB06k), Color.m1489getBlueimpl(m1483convertvNxB06k));
                }
            }, new Function1<AnimationVector4D, Color>() { // from class: androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Color invoke(AnimationVector4D animationVector4D) {
                    return Color.m1481boximpl(m27invokevNxB06k(animationVector4D));
                }

                /* renamed from: invoke-vNxB06k, reason: not valid java name */
                public final long m27invokevNxB06k(AnimationVector4D animationVector4D) {
                    float v22 = animationVector4D.getV2();
                    if (v22 < 0.0f) {
                        v22 = 0.0f;
                    }
                    if (v22 > 1.0f) {
                        v22 = 1.0f;
                    }
                    float v32 = animationVector4D.getV3();
                    if (v32 < -0.5f) {
                        v32 = -0.5f;
                    }
                    if (v32 > 0.5f) {
                        v32 = 0.5f;
                    }
                    float v42 = animationVector4D.getV4();
                    float f5 = v42 >= -0.5f ? v42 : -0.5f;
                    float f6 = f5 <= 0.5f ? f5 : 0.5f;
                    float v12 = animationVector4D.getV1();
                    float f7 = v12 >= 0.0f ? v12 : 0.0f;
                    return Color.m1483convertvNxB06k(ColorKt.Color(v22, v32, f6, f7 <= 1.0f ? f7 : 1.0f, ColorSpaces.INSTANCE.getOklab()), ColorSpace.this);
                }
            });
        }
    };

    public static final Function1<ColorSpace, TwoWayConverter<Color, AnimationVector4D>> getVectorConverter(Color.Companion companion) {
        return ColorToVector;
    }
}
