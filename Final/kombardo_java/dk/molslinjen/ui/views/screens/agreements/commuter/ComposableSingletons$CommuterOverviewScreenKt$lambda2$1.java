package dk.molslinjen.ui.views.screens.agreements.commuter;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.InfoBoxViewKt;
import dk.molslinjen.ui.views.reusable.clickableText.ClickableTextData;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* renamed from: dk.molslinjen.ui.views.screens.agreements.commuter.ComposableSingletons$CommuterOverviewScreenKt$lambda-2$1, reason: invalid class name */
/* loaded from: classes2.dex */
final class ComposableSingletons$CommuterOverviewScreenKt$lambda2$1 implements Function3<LazyItemScope, Composer, Integer, Unit> {
    public static final ComposableSingletons$CommuterOverviewScreenKt$lambda2$1 INSTANCE = new ComposableSingletons$CommuterOverviewScreenKt$lambda2$1();

    ComposableSingletons$CommuterOverviewScreenKt$lambda2$1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(UriHandler uriHandler, String str) {
        try {
            uriHandler.openUri("https://" + str);
        } catch (Exception e5) {
            Logger logger = Logger.INSTANCE;
            String localizedMessage = e5.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = ExceptionsKt.stackTraceToString(e5);
            }
            logger.logCritical(new CriticalLog(localizedMessage));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(UriHandler uriHandler, String str) {
        try {
            uriHandler.openUri("https://" + str);
        } catch (Exception e5) {
            Logger logger = Logger.INSTANCE;
            String localizedMessage = e5.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = ExceptionsKt.stackTraceToString(e5);
            }
            logger.logCritical(new CriticalLog(localizedMessage));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
        invoke(lazyItemScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope item, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if ((i5 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(140091804, i5, -1, "dk.molslinjen.ui.views.screens.agreements.commuter.ComposableSingletons$CommuterOverviewScreenKt.lambda-2.<anonymous> (CommuterOverviewScreen.kt:107)");
        }
        final UriHandler uriHandler = (UriHandler) composer.consume(CompositionLocalsKt.getLocalUriHandler());
        final String stringResource = StringResources_androidKt.stringResource(R.string.commuter_administrationInfo_oeresundSite, composer, 6);
        final String stringResource2 = StringResources_androidKt.stringResource(R.string.commuter_administrationInfo_bornholmSite, composer, 6);
        String stringResource3 = StringResources_androidKt.stringResource(R.string.commuter_administrationInfo, new Object[]{stringResource2, stringResource}, composer, 6);
        composer.startReplaceGroup(-990732060);
        boolean changedInstance = composer.changedInstance(uriHandler) | composer.changed(stringResource2);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.agreements.commuter.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = ComposableSingletons$CommuterOverviewScreenKt$lambda2$1.invoke$lambda$1$lambda$0(UriHandler.this, stringResource2);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        Function0 function0 = (Function0) rememberedValue;
        composer.endReplaceGroup();
        TextDecoration.Companion companion = TextDecoration.INSTANCE;
        TextDecoration none = companion.getNone();
        AppColor appColor = AppColor.INSTANCE;
        ClickableTextData clickableTextData = new ClickableTextData(stringResource2, function0, none, Color.m1481boximpl(appColor.m3255getBrandBlue10d7_KjU()), null, 16, null);
        composer.startReplaceGroup(-990713244);
        boolean changedInstance2 = composer.changedInstance(uriHandler) | composer.changed(stringResource);
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.screens.agreements.commuter.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$3$lambda$2;
                    invoke$lambda$3$lambda$2 = ComposableSingletons$CommuterOverviewScreenKt$lambda2$1.invoke$lambda$3$lambda$2(UriHandler.this, stringResource);
                    return invoke$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        InfoBoxViewKt.InfoBoxView(null, 0, false, stringResource3, CollectionsKt.listOf((Object[]) new ClickableTextData[]{clickableTextData, new ClickableTextData(stringResource, (Function0) rememberedValue2, companion.getNone(), Color.m1481boximpl(appColor.m3255getBrandBlue10d7_KjU()), null, 16, null)}), composer, 0, 7);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
