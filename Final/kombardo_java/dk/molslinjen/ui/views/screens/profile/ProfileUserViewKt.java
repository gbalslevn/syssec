package dk.molslinjen.ui.views.screens.profile;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.account.user.AccountUser;
import dk.molslinjen.domain.model.account.user.LocalUser;
import dk.molslinjen.domain.model.account.user.Uninitialized;
import dk.molslinjen.domain.model.account.user.User;
import dk.molslinjen.domain.model.account.user.UserContactDetails;
import dk.molslinjen.domain.model.account.user.UserInfo;
import dk.molslinjen.domain.model.account.user.UserPersonalDetails;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.InitialsViewKt;
import dk.molslinjen.ui.views.reusable.InitialsViewSize;
import dk.molslinjen.ui.views.reusable.modifiers.SkeletonKt;
import dk.molslinjen.ui.views.screens.profile.ProfileUserViewKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a/\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Ldk/molslinjen/domain/model/account/user/User;", "user", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onNavigateToEdit", "ProfileUserView", "(Landroidx/compose/ui/Modifier;Ldk/molslinjen/domain/model/account/user/User;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ProfileUserViewKt {
    public static final void ProfileUserView(Modifier modifier, final User user, final Function0<Unit> onNavigateToEdit, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        Modifier modifier3;
        Composer composer2;
        String email;
        UserContactDetails contactDetails;
        boolean z5;
        int i8;
        float f5;
        Color color;
        int i9;
        Composer composer3;
        UserPersonalDetails personalDetails;
        UserPersonalDetails personalDetails2;
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(onNavigateToEdit, "onNavigateToEdit");
        Composer startRestartGroup = composer.startRestartGroup(-1076795306);
        int i10 = i6 & 1;
        if (i10 != 0) {
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
            i7 |= startRestartGroup.changedInstance(user) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(onNavigateToEdit) ? 256 : 128;
        }
        int i11 = i7;
        if ((i11 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            composer3 = startRestartGroup;
        } else {
            Modifier modifier4 = i10 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1076795306, i11, -1, "dk.molslinjen.ui.views.screens.profile.ProfileUserView (ProfileUserView.kt:36)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            AppColor appColor = AppColor.INSTANCE;
            float f6 = 24;
            Modifier then = PaddingKt.m315paddingqDBjuR0$default(PaddingKt.m313paddingVpY3zN4$default(BackgroundKt.m104backgroundbw27NRU$default(companion, appColor.m3281getWhite0d7_KjU(), null, 2, null), Dp.m2599constructorimpl(f6), 0.0f, 2, null), 0.0f, Dp.m2599constructorimpl(f6), 0.0f, Dp.m2599constructorimpl(32), 5, null).then(modifier4);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            Alignment.Vertical centerVertically = companion2.getCenterVertically();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, then);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            UserInfo details = user.getDetails();
            String initials = (details == null || (personalDetails2 = details.getPersonalDetails()) == null) ? null : personalDetails2.getInitials();
            startRestartGroup.startReplaceGroup(1154112282);
            if (initials == null) {
                modifier3 = modifier4;
                composer2 = startRestartGroup;
            } else {
                modifier3 = modifier4;
                InitialsViewKt.m3389InitialsViewgPmlwdY(null, InitialsViewSize.Medium, null, null, initials, false, false, false, startRestartGroup, 48, 237);
                composer2 = startRestartGroup;
                SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(16)), composer2, 6);
                Unit unit = Unit.INSTANCE;
            }
            composer2.endReplaceGroup();
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composer2, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, weight$default);
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            if (composer2.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer2.useNode();
            }
            Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer2);
            Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            boolean z6 = (user instanceof Uninitialized) || ((user instanceof AccountUser) && ((AccountUser) user).getUserInfo() == null);
            UserInfo details2 = user.getDetails();
            if (details2 == null || (personalDetails = details2.getPersonalDetails()) == null || (email = personalDetails.getFullName()) == null) {
                UserInfo details3 = user.getDetails();
                email = (details3 == null || (contactDetails = details3.getContactDetails()) == null) ? null : contactDetails.getEmail();
            }
            UserInfo details4 = user.getDetails();
            if (details4 == null || details4.getIsEmpty()) {
                z5 = false;
                i8 = 1;
                f5 = 0.0f;
                color = null;
            } else {
                i8 = 1;
                f5 = 0.0f;
                color = null;
                z5 = true;
            }
            Modifier m3425skeletont9lfQc4$default = SkeletonKt.m3425skeletont9lfQc4$default(SizeKt.fillMaxWidth$default(companion, f5, i8, color), z6, color, 2, color);
            composer2.startReplaceGroup(-517133557);
            String stringResource = email == null ? StringResources_androidKt.stringResource(R.string.profile_noStoredInfo, composer2, 6) : email;
            composer2.endReplaceGroup();
            Composer composer4 = composer2;
            TextKt.m940Text4IGK_g(stringResource, m3425skeletont9lfQc4$default, z5 ? appColor.m3253getBrandBlack10d7_KjU() : appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 1, 0, null, z5 ? TypographyKt.getH3Bold() : TypographyKt.getParagraph(), composer4, 0, 3072, 57336);
            Modifier m3425skeletont9lfQc4$default2 = SkeletonKt.m3425skeletont9lfQc4$default(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 13, null), z6, null, 2, null);
            boolean z7 = !z6;
            composer4.startReplaceGroup(-517120163);
            boolean z8 = (i11 & 896) == 256;
            Object rememberedValue = composer4.rememberedValue();
            if (z8 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: v3.D
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Modifier ProfileUserView$lambda$5$lambda$4$lambda$3$lambda$2;
                        ProfileUserView$lambda$5$lambda$4$lambda$3$lambda$2 = ProfileUserViewKt.ProfileUserView$lambda$5$lambda$4$lambda$3$lambda$2(Function0.this, (Modifier) obj);
                        return ProfileUserView$lambda$5$lambda$4$lambda$3$lambda$2;
                    }
                };
                composer4.updateRememberedValue(rememberedValue);
            }
            composer4.endReplaceGroup();
            Modifier applyIf = ModifierExtensionsKt.applyIf(m3425skeletont9lfQc4$default2, z7, (Function1) rememberedValue);
            if (user instanceof AccountUser) {
                i9 = R.string.profile_editProfile;
            } else if (user instanceof LocalUser) {
                i9 = R.string.profile_editInfo;
            } else {
                if (!Intrinsics.areEqual(user, Uninitialized.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                }
                i9 = R.string.profile_addInfo;
            }
            composer3 = composer4;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(i9, composer4, 0), applyIf, 0L, 0L, null, null, null, 0L, TextDecoration.INSTANCE.getUnderline(), null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer3, 100663296, 1572864, 65276);
            composer3.endNode();
            composer3.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: v3.E
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProfileUserView$lambda$6;
                    ProfileUserView$lambda$6 = ProfileUserViewKt.ProfileUserView$lambda$6(Modifier.this, user, onNavigateToEdit, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return ProfileUserView$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier ProfileUserView$lambda$5$lambda$4$lambda$3$lambda$2(final Function0 function0, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return ClickableKt.m122clickableXHw0xAI$default(applyIf, false, null, null, new Function0() { // from class: v3.F
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit ProfileUserView$lambda$5$lambda$4$lambda$3$lambda$2$lambda$1;
                ProfileUserView$lambda$5$lambda$4$lambda$3$lambda$2$lambda$1 = ProfileUserViewKt.ProfileUserView$lambda$5$lambda$4$lambda$3$lambda$2$lambda$1(Function0.this);
                return ProfileUserView$lambda$5$lambda$4$lambda$3$lambda$2$lambda$1;
            }
        }, 7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileUserView$lambda$5$lambda$4$lambda$3$lambda$2$lambda$1(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileUserView$lambda$6(Modifier modifier, User user, Function0 function0, int i5, int i6, Composer composer, int i7) {
        ProfileUserView(modifier, user, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
