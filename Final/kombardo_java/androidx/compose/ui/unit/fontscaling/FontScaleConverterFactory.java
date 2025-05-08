package androidx.compose.ui.unit.fontscaling;

import androidx.collection.SparseArrayCompat;
import androidx.compose.ui.unit.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.Unit;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u0019\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00172\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0007H\u0082\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010 \u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b \u0010\u001cR\u0014\u0010!\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R.\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b&\u0010'\u0012\u0004\b,\u0010\u0003\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00100\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u0010\"¨\u00061"}, d2 = {"Landroidx/compose/ui/unit/fontscaling/FontScaleConverterFactory;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/unit/fontscaling/FontScaleConverter;", "start", "end", BuildConfig.FLAVOR, "interpolationPoint", "createInterpolatedTableBetween", "(Landroidx/compose/ui/unit/fontscaling/FontScaleConverter;Landroidx/compose/ui/unit/fontscaling/FontScaleConverter;F)Landroidx/compose/ui/unit/fontscaling/FontScaleConverter;", "fontScale", BuildConfig.FLAVOR, "getKey", "(F)I", "key", "getScaleFromKey", "(I)F", "scaleKey", "fontScaleConverter", BuildConfig.FLAVOR, "put", "(FLandroidx/compose/ui/unit/fontscaling/FontScaleConverter;)V", "Landroidx/collection/SparseArrayCompat;", "table", "putInto", "(Landroidx/collection/SparseArrayCompat;FLandroidx/compose/ui/unit/fontscaling/FontScaleConverter;)V", "get", "(F)Landroidx/compose/ui/unit/fontscaling/FontScaleConverter;", BuildConfig.FLAVOR, "isNonLinearFontScalingActive", "(F)Z", "forScale", "ScaleKeyMultiplier", "F", BuildConfig.FLAVOR, "CommonFontSizes", "[F", "sLookupTables", "Landroidx/collection/SparseArrayCompat;", "getSLookupTables", "()Landroidx/collection/SparseArrayCompat;", "setSLookupTables", "(Landroidx/collection/SparseArrayCompat;)V", "getSLookupTables$annotations", BuildConfig.FLAVOR, "LookupTablesWriteLock", "[Ljava/lang/Object;", "MinScaleForNonLinear", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FontScaleConverterFactory {
    public static final int $stable;
    private static final float[] CommonFontSizes;
    public static final FontScaleConverterFactory INSTANCE;
    private static final Object[] LookupTablesWriteLock;
    private static final float MinScaleForNonLinear = 1.03f;
    private static final float ScaleKeyMultiplier = 100.0f;
    private static volatile SparseArrayCompat<FontScaleConverter> sLookupTables;

    static {
        FontScaleConverterFactory fontScaleConverterFactory = new FontScaleConverterFactory();
        INSTANCE = fontScaleConverterFactory;
        CommonFontSizes = new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, ScaleKeyMultiplier};
        sLookupTables = new SparseArrayCompat<>(0, 1, null);
        Object[] objArr = new Object[0];
        LookupTablesWriteLock = objArr;
        synchronized (objArr) {
            fontScaleConverterFactory.putInto(sLookupTables, 1.15f, new FontScaleConverterTable(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, ScaleKeyMultiplier}, new float[]{9.2f, 11.5f, 13.8f, 16.4f, 19.8f, 21.8f, 25.2f, 30.0f, ScaleKeyMultiplier}));
            fontScaleConverterFactory.putInto(sLookupTables, 1.3f, new FontScaleConverterTable(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, ScaleKeyMultiplier}, new float[]{10.4f, 13.0f, 15.6f, 18.8f, 21.6f, 23.6f, 26.4f, 30.0f, ScaleKeyMultiplier}));
            fontScaleConverterFactory.putInto(sLookupTables, 1.5f, new FontScaleConverterTable(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, ScaleKeyMultiplier}, new float[]{12.0f, 15.0f, 18.0f, 22.0f, 24.0f, 26.0f, 28.0f, 30.0f, ScaleKeyMultiplier}));
            fontScaleConverterFactory.putInto(sLookupTables, 1.8f, new FontScaleConverterTable(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, ScaleKeyMultiplier}, new float[]{14.4f, 18.0f, 21.6f, 24.4f, 27.6f, 30.8f, 32.8f, 34.8f, ScaleKeyMultiplier}));
            fontScaleConverterFactory.putInto(sLookupTables, 2.0f, new FontScaleConverterTable(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, ScaleKeyMultiplier}, new float[]{16.0f, 20.0f, 24.0f, 26.0f, 30.0f, 34.0f, 36.0f, 38.0f, ScaleKeyMultiplier}));
            Unit unit = Unit.INSTANCE;
        }
        if (!(fontScaleConverterFactory.getScaleFromKey(sLookupTables.keyAt(0)) - 0.01f > MinScaleForNonLinear)) {
            InlineClassHelperKt.throwIllegalStateException("You should only apply non-linear scaling to font scales > 1");
        }
        $stable = 8;
    }

    private FontScaleConverterFactory() {
    }

    private final FontScaleConverter createInterpolatedTableBetween(FontScaleConverter start, FontScaleConverter end, float interpolationPoint) {
        float[] fArr = CommonFontSizes;
        float[] fArr2 = new float[fArr.length];
        int length = fArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            float f5 = CommonFontSizes[i5];
            fArr2[i5] = MathUtils.INSTANCE.lerp(start.convertSpToDp(f5), end.convertSpToDp(f5), interpolationPoint);
        }
        return new FontScaleConverterTable(CommonFontSizes, fArr2);
    }

    private final FontScaleConverter get(float scaleKey) {
        return sLookupTables.get(getKey(scaleKey));
    }

    private final int getKey(float fontScale) {
        return (int) (fontScale * ScaleKeyMultiplier);
    }

    private final float getScaleFromKey(int key) {
        return key / ScaleKeyMultiplier;
    }

    private final void put(float scaleKey, FontScaleConverter fontScaleConverter) {
        synchronized (LookupTablesWriteLock) {
            SparseArrayCompat<FontScaleConverter> m16clone = sLookupTables.m16clone();
            INSTANCE.putInto(m16clone, scaleKey, fontScaleConverter);
            sLookupTables = m16clone;
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void putInto(SparseArrayCompat<FontScaleConverter> table, float scaleKey, FontScaleConverter fontScaleConverter) {
        table.put(getKey(scaleKey), fontScaleConverter);
    }

    public final FontScaleConverter forScale(float fontScale) {
        FontScaleConverter valueAt;
        if (!isNonLinearFontScalingActive(fontScale)) {
            return null;
        }
        FontScaleConverter fontScaleConverter = INSTANCE.get(fontScale);
        if (fontScaleConverter != null) {
            return fontScaleConverter;
        }
        int indexOfKey = sLookupTables.indexOfKey(getKey(fontScale));
        if (indexOfKey >= 0) {
            return sLookupTables.valueAt(indexOfKey);
        }
        int i5 = -(indexOfKey + 1);
        int i6 = i5 - 1;
        float f5 = 1.0f;
        if (i5 >= sLookupTables.size()) {
            FontScaleConverterTable fontScaleConverterTable = new FontScaleConverterTable(new float[]{1.0f}, new float[]{fontScale});
            put(fontScale, fontScaleConverterTable);
            return fontScaleConverterTable;
        }
        if (i6 < 0) {
            float[] fArr = CommonFontSizes;
            valueAt = new FontScaleConverterTable(fArr, fArr);
        } else {
            f5 = getScaleFromKey(sLookupTables.keyAt(i6));
            valueAt = sLookupTables.valueAt(i6);
        }
        FontScaleConverter createInterpolatedTableBetween = createInterpolatedTableBetween(valueAt, sLookupTables.valueAt(i5), MathUtils.INSTANCE.constrainedMap(0.0f, 1.0f, f5, getScaleFromKey(sLookupTables.keyAt(i5)), fontScale));
        put(fontScale, createInterpolatedTableBetween);
        return createInterpolatedTableBetween;
    }

    public final boolean isNonLinearFontScalingActive(float fontScale) {
        return fontScale >= MinScaleForNonLinear;
    }
}
