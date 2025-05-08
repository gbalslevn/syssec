package dk.molslinjen.core.image;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Ldk/molslinjen/core/image/ImageHelper;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "url", "Landroidx/compose/ui/unit/Dp;", "width", "height", "buildImageUrl-C8IHX40", "(Ljava/lang/String;Landroidx/compose/ui/unit/Dp;Landroidx/compose/ui/unit/Dp;Landroidx/compose/runtime/Composer;II)Ljava/lang/String;", "buildImageUrl", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ImageHelper {
    public static final ImageHelper INSTANCE = new ImageHelper();

    private ImageHelper() {
    }

    /* renamed from: buildImageUrl-C8IHX40, reason: not valid java name */
    public final String m3193buildImageUrlC8IHX40(String str, Dp dp, Dp dp2, Composer composer, int i5, int i6) {
        composer.startReplaceGroup(-565736466);
        String str2 = null;
        if ((i6 & 2) != 0) {
            dp = null;
        }
        if ((i6 & 4) != 0) {
            dp2 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-565736466, i5, -1, "dk.molslinjen.core.image.ImageHelper.buildImageUrl (ImageHelper.kt:8)");
        }
        if (str != null) {
            composer.startReplaceGroup(1355933239);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("?format=png");
            sb.append("&mode=crop");
            composer.startReplaceGroup(1355937204);
            if (dp != null) {
                sb.append("&width=" + ComposeExtensionsKt.m3250dpToPx8Feqmps(dp.getValue(), composer, (i5 >> 3) & 14));
            }
            composer.endReplaceGroup();
            composer.startReplaceGroup(1355940727);
            if (dp2 != null) {
                sb.append("&height=" + ComposeExtensionsKt.m3250dpToPx8Feqmps(dp2.getValue(), composer, (i5 >> 6) & 14));
            }
            composer.endReplaceGroup();
            str2 = sb.toString();
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return str2;
    }
}
