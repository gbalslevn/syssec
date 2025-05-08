package androidx.compose.ui.unit;

import androidx.compose.ui.unit.fontscaling.FontScaleConverter;
import androidx.compose.ui.unit.fontscaling.FontScaleConverterFactory;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0016\u0010\b\u001a\u00020\t*\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\r\u001a\u00020\n*\u00020\tH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/unit/FontScaling;", BuildConfig.FLAVOR, "fontScale", BuildConfig.FLAVOR, "getFontScale$annotations", "()V", "getFontScale", "()F", "toDp", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/ui/unit/TextUnit;", "toDp-GaN1DYA", "(J)F", "toSp", "toSp-0xMU5do", "(F)J", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface FontScaling {
    float getFontScale();

    /* renamed from: toDp-GaN1DYA */
    default float mo207toDpGaN1DYA(long j5) {
        if (!TextUnitType.m2688equalsimpl0(TextUnit.m2674getTypeUIouoOA(j5), TextUnitType.INSTANCE.m2693getSpUIouoOA())) {
            InlineClassHelperKt.throwIllegalStateException("Only Sp can convert to Px");
        }
        FontScaleConverterFactory fontScaleConverterFactory = FontScaleConverterFactory.INSTANCE;
        if (!fontScaleConverterFactory.isNonLinearFontScalingActive(getFontScale())) {
            return Dp.m2599constructorimpl(TextUnit.m2675getValueimpl(j5) * getFontScale());
        }
        FontScaleConverter forScale = fontScaleConverterFactory.forScale(getFontScale());
        float m2675getValueimpl = TextUnit.m2675getValueimpl(j5);
        return Dp.m2599constructorimpl(forScale == null ? m2675getValueimpl * getFontScale() : forScale.convertSpToDp(m2675getValueimpl));
    }

    /* renamed from: toSp-0xMU5do */
    default long mo214toSp0xMU5do(float f5) {
        FontScaleConverterFactory fontScaleConverterFactory = FontScaleConverterFactory.INSTANCE;
        if (!fontScaleConverterFactory.isNonLinearFontScalingActive(getFontScale())) {
            return TextUnitKt.getSp(f5 / getFontScale());
        }
        FontScaleConverter forScale = fontScaleConverterFactory.forScale(getFontScale());
        return TextUnitKt.getSp(forScale != null ? forScale.convertDpToSp(f5) : f5 / getFontScale());
    }
}
