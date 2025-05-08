package dk.molslinjen.ui.views.screens.developer;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.SettingsKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$DeveloperPanelViewKt {
    public static final ComposableSingletons$DeveloperPanelViewKt INSTANCE = new ComposableSingletons$DeveloperPanelViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f194lambda1 = ComposableLambdaKt.composableLambdaInstance(248361091, false, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.developer.ComposableSingletons$DeveloperPanelViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i5) {
            if ((i5 & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(248361091, i5, -1, "dk.molslinjen.ui.views.screens.developer.ComposableSingletons$DeveloperPanelViewKt.lambda-1.<anonymous> (DeveloperPanelView.kt:90)");
            }
            IconKt.m858Iconww6aTOc(SettingsKt.getSettings(Icons.INSTANCE.getDefault()), "Developer Settings", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m792getInverseOnSurface0d7_KjU(), composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    private static Function3<ColumnScope, Composer, Integer, Unit> f195lambda2 = ComposableLambdaKt.composableLambdaInstance(-586429325, false, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.developer.ComposableSingletons$DeveloperPanelViewKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
            invoke(columnScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(ColumnScope CustomDialog, Composer composer, int i5) {
            Intrinsics.checkNotNullParameter(CustomDialog, "$this$CustomDialog");
            if ((i5 & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-586429325, i5, -1, "dk.molslinjen.ui.views.screens.developer.ComposableSingletons$DeveloperPanelViewKt.lambda-2.<anonymous> (DeveloperPanelView.kt:137)");
            }
            TextKt.m940Text4IGK_g("This is a dialog from DevPanel", null, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), composer, 6, 1572864, 65022);
            Modifier.Companion companion = Modifier.INSTANCE;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(16)), composer, 6);
            float f5 = 24;
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_profile_vehicles, composer, 6), Accessibility.INSTANCE.getSkip(), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 7, null), null, null, 0.0f, null, composer, 384, 120);
            TextKt.m940Text4IGK_g("This is a subText in the custom content", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 131070);
            TextKt.m940Text4IGK_g("This is the custom content area for the styled dialog", PaddingKt.m311padding3ABfNKs(BackgroundKt.m104backgroundbw27NRU$default(companion, AppColor.INSTANCE.m3274getTagBlue0d7_KjU(), null, 2, null), Dp.m2599constructorimpl(f5)), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 54, 0, 131068);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m3487getLambda1$app_kombardoProd() {
        return f194lambda1;
    }

    /* renamed from: getLambda-2$app_kombardoProd, reason: not valid java name */
    public final Function3<ColumnScope, Composer, Integer, Unit> m3488getLambda2$app_kombardoProd() {
        return f195lambda2;
    }
}
