package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0000\"\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {BuildConfig.FLAVOR, "Landroidx/compose/ui/text/font/Font;", "fonts", "Landroidx/compose/ui/text/font/FontFamily;", "FontFamily", "([Landroidx/compose/ui/text/font/Font;)Landroidx/compose/ui/text/font/FontFamily;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class FontFamilyKt {
    public static final FontFamily FontFamily(Font... fontArr) {
        return new FontListFontFamily(ArraysKt.asList(fontArr));
    }
}
