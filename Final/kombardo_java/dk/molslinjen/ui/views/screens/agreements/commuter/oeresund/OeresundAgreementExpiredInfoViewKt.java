package dk.molslinjen.ui.views.screens.agreements.commuter.oeresund;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.InfoBoxViewKt;
import dk.molslinjen.ui.views.screens.agreements.commuter.oeresund.OeresundAgreementExpiredInfoViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {BuildConfig.FLAVOR, "OeresundAgreementExpiredInfoView", "(Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class OeresundAgreementExpiredInfoViewKt {
    public static final void OeresundAgreementExpiredInfoView(Composer composer, final int i5) {
        Composer startRestartGroup = composer.startRestartGroup(-1624992771);
        if (i5 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1624992771, i5, -1, "dk.molslinjen.ui.views.screens.agreements.commuter.oeresund.OeresundAgreementExpiredInfoView (OeresundAgreementExpiredInfoView.kt:13)");
            }
            InfoBoxViewKt.InfoBoxView(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0, StringResources_androidKt.stringResource(R.string.agreement_renewInfo, startRestartGroup, 6), false, startRestartGroup, 6, 10);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: u2.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit OeresundAgreementExpiredInfoView$lambda$0;
                    OeresundAgreementExpiredInfoView$lambda$0 = OeresundAgreementExpiredInfoViewKt.OeresundAgreementExpiredInfoView$lambda$0(i5, (Composer) obj, ((Integer) obj2).intValue());
                    return OeresundAgreementExpiredInfoView$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OeresundAgreementExpiredInfoView$lambda$0(int i5, Composer composer, int i6) {
        OeresundAgreementExpiredInfoView(composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
