package dk.molslinjen.ui.views.screens.booking.passengers;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.extensions.domain.AgeGroupExtensionsKt;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.InitialsViewKt;
import dk.molslinjen.ui.views.reusable.InitialsViewSize;
import dk.molslinjen.ui.views.screens.booking.passengers.CheckoutPassengerPortraitSimpleKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/domain/model/booking/BookingPassenger;", "passenger", BuildConfig.FLAVOR, "showAgeGroup", BuildConfig.FLAVOR, "PassengerPortraitSimple", "(Ldk/molslinjen/domain/model/booking/BookingPassenger;ZLandroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CheckoutPassengerPortraitSimpleKt {
    public static final void PassengerPortraitSimple(final BookingPassenger passenger, final boolean z5, Composer composer, final int i5) {
        int i6;
        Modifier.Companion companion;
        Composer composer2;
        Intrinsics.checkNotNullParameter(passenger, "passenger");
        Composer startRestartGroup = composer.startRestartGroup(-1461449732);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(passenger) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1461449732, i6, -1, "dk.molslinjen.ui.views.screens.booking.passengers.PassengerPortraitSimple (CheckoutPassengerPortraitSimple.kt:29)");
            }
            Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Modifier.Companion companion2 = Modifier.INSTANCE;
            float m2599constructorimpl = Dp.m2599constructorimpl(1);
            AppColor appColor = AppColor.INSTANCE;
            float f5 = 4;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(SizeKt.m333sizeVpY3zN4(BackgroundKt.m103backgroundbw27NRU(BorderKt.m108borderxT4_qwU(companion2, m2599constructorimpl, appColor.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getSmall()), appColor.m3281getWhite0d7_KjU(), ThemeShapesKt.getThemeShapes().getSmall()), Dp.m2599constructorimpl(74), Dp.m2599constructorimpl(104)), Dp.m2599constructorimpl(f5), 0.0f, 2, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getCenterHorizontally(), startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default);
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            if (z5) {
                startRestartGroup.startReplaceGroup(-473539135);
                Modifier m313paddingVpY3zN4$default2 = PaddingKt.m313paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), 0.0f, Dp.m2599constructorimpl(f5), 1, null);
                String name = AgeGroupExtensionsKt.name(passenger.getAgeGroup(), context);
                TextStyle subSmallBold = TypographyKt.getSubSmallBold();
                int m2528getCentere0LSkKk = TextAlign.INSTANCE.m2528getCentere0LSkKk();
                long m3264getGrey10d7_KjU = appColor.m3264getGrey10d7_KjU();
                TextAlign m2521boximpl = TextAlign.m2521boximpl(m2528getCentere0LSkKk);
                companion = companion2;
                TextKt.m940Text4IGK_g(name, m313paddingVpY3zN4$default2, m3264getGrey10d7_KjU, 0L, null, null, null, 0L, null, m2521boximpl, 0L, 0, false, 0, 0, null, subSmallBold, startRestartGroup, 432, 1572864, 65016);
                startRestartGroup.endReplaceGroup();
                startRestartGroup = startRestartGroup;
            } else {
                companion = companion2;
                startRestartGroup.startReplaceGroup(-473202506);
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(12)), startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            }
            InitialsViewKt.m3389InitialsViewgPmlwdY(null, InitialsViewSize.Small, null, null, passenger.getInitials(), true, false, false, startRestartGroup, 196656, 205);
            Composer composer3 = startRestartGroup;
            TextKt.m940Text4IGK_g(passenger.fullName(), null, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSubSmall(), composer3, 0, 1572864, 65022);
            composer2 = composer3;
            SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, companion, 1.0f, false, 2, null), composer2, 0);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: U2.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PassengerPortraitSimple$lambda$1;
                    PassengerPortraitSimple$lambda$1 = CheckoutPassengerPortraitSimpleKt.PassengerPortraitSimple$lambda$1(BookingPassenger.this, z5, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return PassengerPortraitSimple$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerPortraitSimple$lambda$1(BookingPassenger bookingPassenger, boolean z5, int i5, Composer composer, int i6) {
        PassengerPortraitSimple(bookingPassenger, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
