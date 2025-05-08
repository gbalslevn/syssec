package androidx.compose.ui.graphics;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0003\"\u0014\u0010\u0001\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0003\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0002\"\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006\"\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006\"\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0006\"\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0006\"\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0006\"\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006\"\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u0006\"\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u0006\"\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0006\"\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0006\"\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0006\"\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0006\"\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0006\"\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0006\"\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0006\"\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/graphics/Float16;", "One", "S", "NegativeOne", BuildConfig.FLAVOR, "Fp16SignShift", "I", "Fp16SignMask", "Fp16ExponentShift", "Fp16ExponentMask", "Fp16SignificandMask", "Fp16ExponentBias", "Fp16Combined", "Fp16ExponentMax", "Fp32SignShift", "Fp32ExponentShift", "Fp32ExponentMask", "Fp32SignificandMask", "Fp32ExponentBias", "Fp32QNaNMask", "Fp32DenormalMagic", BuildConfig.FLAVOR, "Fp32DenormalFloat", "F", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class Float16Kt {
    private static final int Fp16Combined = 32767;
    private static final int Fp16ExponentBias = 15;
    private static final int Fp16ExponentMask = 31;
    private static final int Fp16ExponentMax = 31744;
    private static final int Fp16ExponentShift = 10;
    private static final int Fp16SignMask = 32768;
    private static final int Fp16SignShift = 15;
    private static final int Fp16SignificandMask = 1023;
    private static final int Fp32ExponentBias = 127;
    private static final int Fp32ExponentMask = 255;
    private static final int Fp32ExponentShift = 23;
    private static final int Fp32QNaNMask = 4194304;
    private static final int Fp32SignShift = 31;
    private static final int Fp32SignificandMask = 8388607;
    private static final short One = Float16.m1522constructorimpl(1.0f);
    private static final short NegativeOne = Float16.m1522constructorimpl(-1.0f);
    private static final int Fp32DenormalMagic = 1056964608;
    private static final float Fp32DenormalFloat = Float.intBitsToFloat(Fp32DenormalMagic);
}
