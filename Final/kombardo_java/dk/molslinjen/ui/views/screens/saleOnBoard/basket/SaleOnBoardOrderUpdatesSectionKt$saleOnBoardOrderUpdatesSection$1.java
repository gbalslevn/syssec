package dk.molslinjen.ui.views.screens.saleOnBoard.basket;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager;
import dk.molslinjen.domain.model.saleOnBoard.NotificationType;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.LabeledSelectionControlKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.SelectionControlStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaleOnBoardOrderUpdatesSectionKt$saleOnBoardOrderUpdatesSection$1 implements Function3<LazyItemScope, Composer, Integer, Unit> {
    final /* synthetic */ boolean $isPushNotificationEnabled;
    final /* synthetic */ Function1<NotificationType, Unit> $onNotificationTypeChange;
    final /* synthetic */ SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState $saleOnBoardCheckoutState;
    final /* synthetic */ Function1<Boolean, Unit> $togglePushNotifications;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public SaleOnBoardOrderUpdatesSectionKt$saleOnBoardOrderUpdatesSection$1(SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState, boolean z5, Function1<? super Boolean, Unit> function1, Function1<? super NotificationType, Unit> function12) {
        this.$saleOnBoardCheckoutState = saleOnBoardCheckoutState;
        this.$isPushNotificationEnabled = z5;
        this.$togglePushNotifications = function1;
        this.$onNotificationTypeChange = function12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$1$lambda$0(FocusManager focusManager, Function1 function1, boolean z5) {
        if (z5) {
            FocusManager.clearFocus$default(focusManager, false, 1, null);
            function1.invoke(NotificationType.Sms);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$3$lambda$2(FocusManager focusManager, Function1 function1, boolean z5) {
        if (z5) {
            FocusManager.clearFocus$default(focusManager, false, 1, null);
            function1.invoke(NotificationType.Push);
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
            ComposerKt.traceEventStart(-881277403, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.basket.saleOnBoardOrderUpdatesSection.<anonymous> (SaleOnBoardOrderUpdatesSection.kt:44)");
        }
        final FocusManager focusManager = (FocusManager) composer.consume(CompositionLocalsKt.getLocalFocusManager());
        String stringResource = StringResources_androidKt.stringResource(R.string.saleOnBoard_basket_orderUpdates, composer, 6);
        TextStyle paragraphBold = TypographyKt.getParagraphBold();
        Modifier.Companion companion = Modifier.INSTANCE;
        TextKt.m940Text4IGK_g(stringResource, PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(8), 7, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, paragraphBold, composer, 48, 1572864, 65532);
        float f5 = 24;
        TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.saleOnBoard_basket_orderUpdates_details, composer, 6), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 7, null), AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer, 432, 1572864, 65528);
        SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState = this.$saleOnBoardCheckoutState;
        final Function1<NotificationType, Unit> function1 = this.$onNotificationTypeChange;
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer, 0);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
        String stringResource2 = StringResources_androidKt.stringResource(R.string.saleOnBoard_basket_sms, composer, 6);
        boolean z5 = saleOnBoardCheckoutState.getNotificationType() == NotificationType.Sms;
        composer.startReplaceGroup(1362873596);
        boolean changedInstance = composer.changedInstance(focusManager) | composer.changed(function1);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.basket.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$4$lambda$1$lambda$0;
                    invoke$lambda$4$lambda$1$lambda$0 = SaleOnBoardOrderUpdatesSectionKt$saleOnBoardOrderUpdatesSection$1.invoke$lambda$4$lambda$1$lambda$0(FocusManager.this, function1, ((Boolean) obj).booleanValue());
                    return invoke$lambda$4$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        SelectionControlStyle selectionControlStyle = SelectionControlStyle.RadioButton;
        LabeledSelectionControlKt.LabeledSelectionControl(null, stringResource2, z5, (Function1) rememberedValue, null, false, null, selectionControlStyle, false, composer, 12582912, 369);
        Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 0.0f, 14, null);
        String stringResource3 = StringResources_androidKt.stringResource(R.string.saleOnBoard_basket_notification, composer, 6);
        boolean z6 = saleOnBoardCheckoutState.getNotificationType() == NotificationType.Push;
        composer.startReplaceGroup(1362892125);
        boolean changedInstance2 = composer.changedInstance(focusManager) | composer.changed(function1);
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new Function1() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.basket.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$4$lambda$3$lambda$2;
                    invoke$lambda$4$lambda$3$lambda$2 = SaleOnBoardOrderUpdatesSectionKt$saleOnBoardOrderUpdatesSection$1.invoke$lambda$4$lambda$3$lambda$2(FocusManager.this, function1, ((Boolean) obj).booleanValue());
                    return invoke$lambda$4$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        LabeledSelectionControlKt.LabeledSelectionControl(m315paddingqDBjuR0$default, stringResource3, z6, (Function1) rememberedValue2, null, false, null, selectionControlStyle, false, composer, 12582918, 368);
        composer.endNode();
        SaleOnBoardOrderUpdatesSectionKt.NotificationTypeInfo(this.$saleOnBoardCheckoutState, this.$isPushNotificationEnabled, this.$togglePushNotifications, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
