package dk.molslinjen.ui.views.screens.profile.contact;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.AnnotatedString;
import dk.molslinjen.core.helpers.ExternalActionHelper;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.screens.profile.contact.ContactEmailKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"ContactEmail", BuildConfig.FLAVOR, "modifier", "Landroidx/compose/ui/Modifier;", "showEmailCopied", "Lkotlin/Function0;", "email", BuildConfig.FLAVOR, "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ContactEmailKt {
    public static final void ContactEmail(Modifier modifier, final Function0<Unit> showEmailCopied, final String email, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(showEmailCopied, "showEmailCopied");
        Intrinsics.checkNotNullParameter(email, "email");
        Composer startRestartGroup = composer.startRestartGroup(663267428);
        int i8 = i6 & 1;
        if (i8 != 0) {
            i7 = i5 | 6;
            modifier2 = modifier;
        } else if ((i5 & 6) == 0) {
            modifier2 = modifier;
            i7 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i5;
        } else {
            modifier2 = modifier;
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(showEmailCopied) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changed(email) ? 256 : 128;
        }
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            modifier3 = i8 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(663267428, i7, -1, "dk.molslinjen.ui.views.screens.profile.contact.ContactEmail (ContactEmail.kt:11)");
            }
            final Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            final ClipboardManager clipboardManager = (ClipboardManager) startRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager());
            startRestartGroup.startReplaceGroup(1543963384);
            boolean changedInstance = startRestartGroup.changedInstance(context) | ((i7 & 896) == 256) | startRestartGroup.changedInstance(clipboardManager) | ((i7 & 112) == 32);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: H3.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ContactEmail$lambda$1$lambda$0;
                        ContactEmail$lambda$1$lambda$0 = ContactEmailKt.ContactEmail$lambda$1$lambda$0(context, email, clipboardManager, showEmailCopied);
                        return ContactEmail$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            LargeContactItemViewKt.LargeContactItemView(modifier3, R.drawable.icon_contact_email, R.string.profile_contact_email_title, R.string.profile_contact_email_description, R.drawable.icon_mail, email, (Function0) rememberedValue, null, startRestartGroup, (i7 & 14) | 28080 | ((i7 << 9) & 458752), 128);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: H3.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ContactEmail$lambda$2;
                    ContactEmail$lambda$2 = ContactEmailKt.ContactEmail$lambda$2(Modifier.this, showEmailCopied, email, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return ContactEmail$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContactEmail$lambda$1$lambda$0(Context context, String str, ClipboardManager clipboardManager, Function0 function0) {
        if (!ExternalActionHelper.INSTANCE.composeEmail(context, str)) {
            clipboardManager.setText(new AnnotatedString(str, null, null, 6, null));
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContactEmail$lambda$2(Modifier modifier, Function0 function0, String str, int i5, int i6, Composer composer, int i7) {
        ContactEmail(modifier, function0, str, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
