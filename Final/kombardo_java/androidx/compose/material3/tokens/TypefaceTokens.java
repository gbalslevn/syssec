package androidx.compose.material3.tokens;

import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0014"}, d2 = {"Landroidx/compose/material3/tokens/TypefaceTokens;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/text/font/GenericFontFamily;", "Brand", "Landroidx/compose/ui/text/font/GenericFontFamily;", "getBrand", "()Landroidx/compose/ui/text/font/GenericFontFamily;", "Plain", "getPlain", "Landroidx/compose/ui/text/font/FontWeight;", "WeightBold", "Landroidx/compose/ui/text/font/FontWeight;", "getWeightBold", "()Landroidx/compose/ui/text/font/FontWeight;", "WeightMedium", "getWeightMedium", "WeightRegular", "getWeightRegular", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TypefaceTokens {
    private static final GenericFontFamily Brand;
    public static final TypefaceTokens INSTANCE = new TypefaceTokens();
    private static final GenericFontFamily Plain;
    private static final FontWeight WeightBold;
    private static final FontWeight WeightMedium;
    private static final FontWeight WeightRegular;

    static {
        FontFamily.Companion companion = FontFamily.INSTANCE;
        Brand = companion.getSansSerif();
        Plain = companion.getSansSerif();
        FontWeight.Companion companion2 = FontWeight.INSTANCE;
        WeightBold = companion2.getBold();
        WeightMedium = companion2.getMedium();
        WeightRegular = companion2.getNormal();
    }

    private TypefaceTokens() {
    }

    public final GenericFontFamily getBrand() {
        return Brand;
    }

    public final GenericFontFamily getPlain() {
        return Plain;
    }

    public final FontWeight getWeightMedium() {
        return WeightMedium;
    }

    public final FontWeight getWeightRegular() {
        return WeightRegular;
    }
}
