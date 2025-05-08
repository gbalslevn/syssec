package dk.molslinjen.ui.views.screens.profile.vehicles.selector;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.screens.profile.vehicles.selector.VehicleSelectorViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class VehicleSelectorScreenKt$VehicleSelectorScreen$3$1$1 implements Function3<LazyItemScope, Composer, Integer, Unit> {
    final /* synthetic */ VehicleSelectorViewModel.ViewState $viewState;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VehicleSelectorScreenKt$VehicleSelectorScreen$3$1$1(VehicleSelectorViewModel.ViewState viewState) {
        this.$viewState = viewState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence invoke$lambda$2$lambda$1$lambda$0(Transportation it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getName();
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
            ComposerKt.traceEventStart(-9201639, i5, -1, "dk.molslinjen.ui.views.screens.profile.vehicles.selector.VehicleSelectorScreen.<anonymous>.<anonymous>.<anonymous> (VehicleSelectorScreen.kt:68)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        float f5 = 24;
        Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f5), 0.0f, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5), 2, null);
        AppColor appColor = AppColor.INSTANCE;
        float f6 = 16;
        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m311padding3ABfNKs(BackgroundKt.m103backgroundbw27NRU(m315paddingqDBjuR0$default, appColor.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(f6)), 0.0f, 1, null);
        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
        VehicleSelectorViewModel.ViewState viewState = this.$viewState;
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, fillMaxWidth$default);
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer m1226constructorimpl = Updater.m1226constructorimpl(composer);
        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_alert_warning, composer, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, Dp.m2599constructorimpl(8), 0.0f, 11, null), Dp.m2599constructorimpl(f6)), appColor.m3266getGrey30d7_KjU(), composer, 3456, 0);
        List<Transportation> transportations = viewState.getTransportations();
        composer.startReplaceGroup(1118215756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.vehicles.selector.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    CharSequence invoke$lambda$2$lambda$1$lambda$0;
                    invoke$lambda$2$lambda$1$lambda$0 = VehicleSelectorScreenKt$VehicleSelectorScreen$3$1$1.invoke$lambda$2$lambda$1$lambda$0((Transportation) obj);
                    return invoke$lambda$2$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.vehicleSelector_selectedTransportation, new Object[]{CollectionsKt.joinToString$default(transportations, ", ", null, null, 0, null, (Function1) rememberedValue, 30, null)}, composer, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer, 0, 1572864, 65534);
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
