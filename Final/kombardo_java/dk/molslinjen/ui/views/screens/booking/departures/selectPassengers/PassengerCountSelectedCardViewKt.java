package dk.molslinjen.ui.views.screens.booking.departures.selectPassengers;

import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.material3.MaterialTheme;
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
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.extensions.domain.PassengerInfoExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.LabelCardKt;
import dk.molslinjen.ui.views.reusable.VerticalDividerKt;
import dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountSelectedCardViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001aE\u0010\n\u001a\u00020\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/model/booking/PassengerInfo;", "outboundPassengerInfo", "returnPassengerInfo", BuildConfig.FLAVOR, "onlyShowReturn", "Lkotlin/Function0;", BuildConfig.FLAVOR, "showPassengerCountSelector", BuildConfig.FLAVOR, "icon", "PassengerCountSelectedCardView", "(Ldk/molslinjen/domain/model/booking/PassengerInfo;Ldk/molslinjen/domain/model/booking/PassengerInfo;ZLkotlin/jvm/functions/Function0;Ljava/lang/Integer;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PassengerCountSelectedCardViewKt {
    /* JADX WARN: Removed duplicated region for block: B:24:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void PassengerCountSelectedCardView(final PassengerInfo passengerInfo, final PassengerInfo passengerInfo2, final boolean z5, final Function0<Unit> showPassengerCountSelector, Integer num, Composer composer, final int i5, final int i6) {
        int i7;
        Integer num2;
        Integer num3;
        Composer composer2;
        final Integer num4;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(showPassengerCountSelector, "showPassengerCountSelector");
        Composer startRestartGroup = composer.startRestartGroup(-83374807);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(passengerInfo) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(passengerInfo2) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changedInstance(showPassengerCountSelector) ? 2048 : 1024;
        }
        int i8 = i6 & 16;
        if (i8 != 0) {
            i7 |= 24576;
        } else if ((i5 & 24576) == 0) {
            num2 = num;
            i7 |= startRestartGroup.changed(num2) ? 16384 : 8192;
            if ((i7 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                num3 = i8 == 0 ? null : num2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-83374807, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountSelectedCardView (PassengerCountSelectedCardView.kt:27)");
                }
                if (passengerInfo2 != null || Intrinsics.areEqual(passengerInfo, passengerInfo2) || z5) {
                    startRestartGroup.startReplaceGroup(-2087129993);
                    PassengerInfo passengerInfo3 = !z5 ? passengerInfo2 : passengerInfo;
                    startRestartGroup.startReplaceGroup(1041056008);
                    String formatted = passengerInfo3 != null ? PassengerInfoExtensionsKt.formatted(passengerInfo3, (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())) : null;
                    startRestartGroup.endReplaceGroup();
                    composer2 = startRestartGroup;
                    LabelCardKt.m3391LabelCardTek12BE(StringResources_androidKt.stringResource(R.string.passengers_headline, startRestartGroup, 6), formatted, null, null, null, num3, false, 0L, 0.0f, showPassengerCountSelector, startRestartGroup, ((i7 << 3) & 458752) | ((i7 << 18) & 1879048192), 476);
                    composer2.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(-2088143507);
                    startRestartGroup.startReplaceGroup(1041020136);
                    String formatted2 = passengerInfo == null ? null : PassengerInfoExtensionsKt.formatted(passengerInfo, (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()));
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(1041022920);
                    String formatted3 = passengerInfo2 == null ? null : PassengerInfoExtensionsKt.formatted(passengerInfo2, (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()));
                    startRestartGroup.endReplaceGroup();
                    Modifier.Companion companion = Modifier.INSTANCE;
                    Modifier height = IntrinsicKt.height(companion, IntrinsicSize.Max);
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), startRestartGroup, 0);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, height);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
                    Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                    if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    Modifier weight$default = RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null);
                    String stringResource = StringResources_androidKt.stringResource(R.string.passengers_outbound, startRestartGroup, 6);
                    MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                    int i9 = MaterialTheme.$stable;
                    float f5 = 0;
                    int i10 = (i7 << 18) & 1879048192;
                    LabelCardKt.m3391LabelCardTek12BE(stringResource, formatted2, weight$default, CornerBasedShape.copy$default(materialTheme.getShapes(startRestartGroup, i9).getMedium(), null, CornerSizeKt.m459CornerSize0680j_4(Dp.m2599constructorimpl(f5)), CornerSizeKt.m459CornerSize0680j_4(Dp.m2599constructorimpl(f5)), null, 9, null), null, null, false, 0L, 0.0f, showPassengerCountSelector, startRestartGroup, i10, 496);
                    VerticalDividerKt.m3394VerticalDividertZIQpXc(null, 0L, 0.0f, null, startRestartGroup, 0, 15);
                    LabelCardKt.m3391LabelCardTek12BE(StringResources_androidKt.stringResource(R.string.passengers_return, startRestartGroup, 6), formatted3, RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), CornerBasedShape.copy$default(materialTheme.getShapes(startRestartGroup, i9).getMedium(), CornerSizeKt.m459CornerSize0680j_4(Dp.m2599constructorimpl(f5)), null, null, CornerSizeKt.m459CornerSize0680j_4(Dp.m2599constructorimpl(f5)), 6, null), null, null, false, 0L, 0.0f, showPassengerCountSelector, startRestartGroup, i10, 496);
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceGroup();
                    composer2 = startRestartGroup;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                num4 = num3;
            } else {
                startRestartGroup.skipToGroupEnd();
                num4 = num2;
                composer2 = startRestartGroup;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: O2.a
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit PassengerCountSelectedCardView$lambda$1;
                        PassengerCountSelectedCardView$lambda$1 = PassengerCountSelectedCardViewKt.PassengerCountSelectedCardView$lambda$1(PassengerInfo.this, passengerInfo2, z5, showPassengerCountSelector, num4, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                        return PassengerCountSelectedCardView$lambda$1;
                    }
                });
                return;
            }
            return;
        }
        num2 = num;
        if ((i7 & 9363) == 9362) {
        }
        if (i8 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        if (passengerInfo2 != null) {
        }
        startRestartGroup.startReplaceGroup(-2087129993);
        if (!z5) {
        }
        startRestartGroup.startReplaceGroup(1041056008);
        if (passengerInfo3 != null) {
        }
        startRestartGroup.endReplaceGroup();
        composer2 = startRestartGroup;
        LabelCardKt.m3391LabelCardTek12BE(StringResources_androidKt.stringResource(R.string.passengers_headline, startRestartGroup, 6), formatted, null, null, null, num3, false, 0L, 0.0f, showPassengerCountSelector, startRestartGroup, ((i7 << 3) & 458752) | ((i7 << 18) & 1879048192), 476);
        composer2.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        num4 = num3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerCountSelectedCardView$lambda$1(PassengerInfo passengerInfo, PassengerInfo passengerInfo2, boolean z5, Function0 function0, Integer num, int i5, int i6, Composer composer, int i7) {
        PassengerCountSelectedCardView(passengerInfo, passengerInfo2, z5, function0, num, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
