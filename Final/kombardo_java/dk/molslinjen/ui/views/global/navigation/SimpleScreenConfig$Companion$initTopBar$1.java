package dk.molslinjen.ui.views.global.navigation;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.ramcosta.composedestinations.generated.destinations.ProfileScreenDestination;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.account.user.AccountUser;
import dk.molslinjen.domain.model.account.user.User;
import dk.molslinjen.domain.model.account.user.UserInfo;
import dk.molslinjen.domain.model.account.user.UserPersonalDetails;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.global.topbar.TopBarButtonBasicKt;
import dk.molslinjen.ui.views.reusable.InitialsViewKt;
import dk.molslinjen.ui.views.reusable.InitialsViewSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SimpleScreenConfig$Companion$initTopBar$1 implements Function3<NavController, Composer, Integer, Unit> {
    final /* synthetic */ IUserManager $userManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SimpleScreenConfig$Companion$initTopBar$1(IUserManager iUserManager) {
        this.$userManager = iUserManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(NavController navController) {
        NavController.navigate$default(navController, ProfileScreenDestination.INSTANCE.getRoute(), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(NavController navController, Composer composer, Integer num) {
        invoke(navController, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(final NavController navController, Composer composer, int i5) {
        UserInfo details;
        UserPersonalDetails personalDetails;
        Intrinsics.checkNotNullParameter(navController, "navController");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-321117337, i5, -1, "dk.molslinjen.ui.views.global.navigation.SimpleScreenConfig.Companion.initTopBar.<anonymous> (SimpleScreenConfig.kt:96)");
        }
        String str = null;
        User user = ((IUserManager.UserState) SnapshotStateKt.collectAsState(this.$userManager.getCurrentUserState(), null, composer, 0, 1).getValue()).getUser();
        AccountUser accountUser = user instanceof AccountUser ? (AccountUser) user : null;
        composer.startReplaceGroup(-1714067830);
        boolean changedInstance = composer.changedInstance(navController);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.global.navigation.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = SimpleScreenConfig$Companion$initTopBar$1.invoke$lambda$1$lambda$0(NavController.this);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        Function0 function0 = (Function0) rememberedValue;
        composer.endReplaceGroup();
        if (accountUser != null && (details = accountUser.getDetails()) != null && (personalDetails = details.getPersonalDetails()) != null) {
            str = personalDetails.getInitials();
        }
        if (str != null) {
            composer.startReplaceGroup(-1596301457);
            Modifier m122clickableXHw0xAI$default = ClickableKt.m122clickableXHw0xAI$default(Modifier.INSTANCE, false, null, null, function0, 7, null);
            InitialsViewSize initialsViewSize = InitialsViewSize.Small;
            AppColor appColor = AppColor.INSTANCE;
            InitialsViewKt.m3389InitialsViewgPmlwdY(m122clickableXHw0xAI$default, initialsViewSize, Color.m1481boximpl(appColor.m3281getWhite0d7_KjU()), Color.m1481boximpl(appColor.m3259getBrandDarkBlue10d7_KjU()), str, false, false, false, composer, 3504, 224);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-1595915073);
            TopBarButtonBasicKt.TopBarButtonBasic(R.drawable.icon_profile, Integer.valueOf(R.string.profile_title), function0, composer, 54, 0);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
