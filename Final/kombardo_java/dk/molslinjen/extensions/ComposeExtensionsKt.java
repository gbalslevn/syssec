package dk.molslinjen.extensions;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.sdk.growthbook.utils.Constants;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a%\u0010\u0004\u001a\u00020\u00022\n\b\u0001\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0006H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0000H\u0007¢\u0006\u0004\b\b\u0010\n\u001a\u0013\u0010\u000b\u001a\u00020\u0000*\u00020\u0000H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\u000b\u001a\u00020\u0006*\u00020\u0007H\u0007¢\u0006\u0004\b\r\u0010\t¨\u0006\u000e"}, d2 = {BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "default", "stringResourceWithDefault", "(Ljava/lang/Integer;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Ljava/lang/String;", BuildConfig.FLAVOR, "Landroidx/compose/ui/unit/Dp;", "pxToDp", "(FLandroidx/compose/runtime/Composer;I)F", "(ILandroidx/compose/runtime/Composer;I)F", "dpToPx", "(ILandroidx/compose/runtime/Composer;I)I", "dpToPx-8Feqmps", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ComposeExtensionsKt {
    public static final int dpToPx(int i5, Composer composer, int i6) {
        composer.startReplaceGroup(-339436223);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-339436223, i6, -1, "dk.molslinjen.extensions.dpToPx (ComposeExtensions.kt:37)");
        }
        int mo212toPx0680j_4 = (int) ((Density) composer.consume(CompositionLocalsKt.getLocalDensity())).mo212toPx0680j_4(Dp.m2599constructorimpl(i5));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return mo212toPx0680j_4;
    }

    /* renamed from: dpToPx-8Feqmps, reason: not valid java name */
    public static final float m3250dpToPx8Feqmps(float f5, Composer composer, int i5) {
        composer.startReplaceGroup(833363803);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(833363803, i5, -1, "dk.molslinjen.extensions.dpToPx (ComposeExtensions.kt:40)");
        }
        float mo212toPx0680j_4 = ((Density) composer.consume(CompositionLocalsKt.getLocalDensity())).mo212toPx0680j_4(f5);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return mo212toPx0680j_4;
    }

    public static final float pxToDp(float f5, Composer composer, int i5) {
        composer.startReplaceGroup(-2110133225);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2110133225, i5, -1, "dk.molslinjen.extensions.pxToDp (ComposeExtensions.kt:31)");
        }
        float mo208toDpu2uoSUM = ((Density) composer.consume(CompositionLocalsKt.getLocalDensity())).mo208toDpu2uoSUM(f5);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return mo208toDpu2uoSUM;
    }

    public static final String stringResourceWithDefault(Integer num, String str, Composer composer, int i5, int i6) {
        if ((i6 & 2) != 0) {
            str = BuildConfig.FLAVOR;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-446155839, i5, -1, "dk.molslinjen.extensions.stringResourceWithDefault (ComposeExtensions.kt:20)");
        }
        String stringResource = num == null ? null : StringResources_androidKt.stringResource(num.intValue(), composer, i5 & 14);
        if (stringResource != null) {
            str = stringResource;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return str;
    }

    public static final float pxToDp(int i5, Composer composer, int i6) {
        composer.startReplaceGroup(-521310870);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-521310870, i6, -1, "dk.molslinjen.extensions.pxToDp (ComposeExtensions.kt:34)");
        }
        float mo209toDpu2uoSUM = ((Density) composer.consume(CompositionLocalsKt.getLocalDensity())).mo209toDpu2uoSUM(i5);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return mo209toDpu2uoSUM;
    }
}
