package dk.molslinjen.ui.views.screens.profile.contact;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.res.StringResources_androidKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.screens.profile.contact.ContactFeedbackKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"ContactFeedback", BuildConfig.FLAVOR, "modifier", "Landroidx/compose/ui/Modifier;", "url", BuildConfig.FLAVOR, "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ContactFeedbackKt {
    public static final void ContactFeedback(final Modifier modifier, final String url, Composer composer, final int i5, final int i6) {
        int i7;
        Intrinsics.checkNotNullParameter(url, "url");
        Composer startRestartGroup = composer.startRestartGroup(166607490);
        int i8 = i6 & 1;
        if (i8 != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(modifier) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(url) ? 32 : 16;
        }
        if ((i7 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i8 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(166607490, i7, -1, "dk.molslinjen.ui.views.screens.profile.contact.ContactFeedback (ContactFeedback.kt:9)");
            }
            final UriHandler uriHandler = (UriHandler) startRestartGroup.consume(CompositionLocalsKt.getLocalUriHandler());
            String stringResource = StringResources_androidKt.stringResource(R.string.profile_contact_feedbackCta, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(-14923756);
            boolean changedInstance = startRestartGroup.changedInstance(uriHandler) | ((i7 & 112) == 32);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: H3.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ContactFeedback$lambda$1$lambda$0;
                        ContactFeedback$lambda$1$lambda$0 = ContactFeedbackKt.ContactFeedback$lambda$1$lambda$0(UriHandler.this, url);
                        return ContactFeedback$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            SmallContactItemViewKt.SmallContactItemView(modifier, R.string.profile_contact_feedbackTitle, stringResource, (Function0) rememberedValue, startRestartGroup, (i7 & 14) | 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: H3.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ContactFeedback$lambda$2;
                    ContactFeedback$lambda$2 = ContactFeedbackKt.ContactFeedback$lambda$2(Modifier.this, url, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return ContactFeedback$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContactFeedback$lambda$1$lambda$0(UriHandler uriHandler, String str) {
        uriHandler.openUri(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContactFeedback$lambda$2(Modifier modifier, String str, int i5, int i6, Composer composer, int i7) {
        ContactFeedback(modifier, str, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
