package dk.molslinjen.ui.views.screens.saleOnBoard.basket;

import android.content.Context;
import android.os.Build;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager;
import dk.molslinjen.domain.model.saleOnBoard.NotificationType;
import dk.molslinjen.extensions.PermissionExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.buttons.SecondaryButtonKt;
import dk.molslinjen.ui.views.reusable.dialog.SimpleButtonData;
import dk.molslinjen.ui.views.reusable.dialog.TextDialogKt;
import dk.molslinjen.ui.views.screens.profile.permissions.AppPermission;
import dk.molslinjen.ui.views.screens.profile.permissions.rows.GenericPermissionRowKt;
import dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardOrderUpdatesSectionKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u001aI\u0010\n\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\n\u0010\u000b\u001a3\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0005H\u0003¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010²\u0006\u000e\u0010\u000e\u001a\u00020\u00018\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u000f\u001a\u00020\u00018\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListScope;", BuildConfig.FLAVOR, "isPushNotificationEnabled", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", "saleOnBoardCheckoutState", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/saleOnBoard/NotificationType;", BuildConfig.FLAVOR, "onNotificationTypeChange", "togglePushNotifications", "saleOnBoardOrderUpdatesSection", "(Landroidx/compose/foundation/lazy/LazyListScope;ZLdk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "NotificationTypeInfo", "(Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "showPushDialog", "showPushPermissionState", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SaleOnBoardOrderUpdatesSectionKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void NotificationTypeInfo(final SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState, final boolean z5, final Function1<? super Boolean, Unit> function1, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        final MutableState mutableState;
        final MutableState mutableState2;
        Composer startRestartGroup = composer.startRestartGroup(914109457);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(saleOnBoardCheckoutState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(914109457, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.basket.NotificationTypeInfo (SaleOnBoardOrderUpdatesSection.kt:99)");
            }
            if (saleOnBoardCheckoutState.getNotificationType() != NotificationType.Push || z5) {
                composer2 = startRestartGroup;
            } else {
                Object[] objArr = new Object[0];
                startRestartGroup.startReplaceGroup(1957196417);
                Object rememberedValue = startRestartGroup.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: f4.F
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            MutableState NotificationTypeInfo$lambda$1$lambda$0;
                            NotificationTypeInfo$lambda$1$lambda$0 = SaleOnBoardOrderUpdatesSectionKt.NotificationTypeInfo$lambda$1$lambda$0();
                            return NotificationTypeInfo$lambda$1$lambda$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                MutableState mutableState3 = (MutableState) RememberSaveableKt.rememberSaveable(objArr, null, null, (Function0) rememberedValue, startRestartGroup, 3072, 6);
                Object[] objArr2 = new Object[0];
                startRestartGroup.startReplaceGroup(1957199169);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: f4.G
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            MutableState NotificationTypeInfo$lambda$5$lambda$4;
                            NotificationTypeInfo$lambda$5$lambda$4 = SaleOnBoardOrderUpdatesSectionKt.NotificationTypeInfo$lambda$5$lambda$4();
                            return NotificationTypeInfo$lambda$5$lambda$4;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                MutableState mutableState4 = (MutableState) RememberSaveableKt.rememberSaveable(objArr2, null, null, (Function0) rememberedValue2, startRestartGroup, 3072, 6);
                startRestartGroup.startReplaceGroup(1957201532);
                if (NotificationTypeInfo$lambda$2(mutableState3)) {
                    AppPermission appPermission = AppPermission.Notifications;
                    final Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    String stringResource = StringResources_androidKt.stringResource(appPermission.titleRes(NotificationTypeInfo$lambda$6(mutableState4)), startRestartGroup, 0);
                    String stringResource2 = StringResources_androidKt.stringResource(appPermission.descriptionRes(NotificationTypeInfo$lambda$6(mutableState4)), startRestartGroup, 0);
                    String stringResource3 = StringResources_androidKt.stringResource(R.string.button_openSettings, startRestartGroup, 6);
                    startRestartGroup.startReplaceGroup(1957217644);
                    mutableState = mutableState3;
                    boolean changedInstance = startRestartGroup.changedInstance(context) | startRestartGroup.changed(mutableState);
                    Object rememberedValue3 = startRestartGroup.rememberedValue();
                    if (changedInstance || rememberedValue3 == companion.getEmpty()) {
                        rememberedValue3 = new Function0() { // from class: f4.H
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit NotificationTypeInfo$lambda$9$lambda$8;
                                NotificationTypeInfo$lambda$9$lambda$8 = SaleOnBoardOrderUpdatesSectionKt.NotificationTypeInfo$lambda$9$lambda$8(context, mutableState);
                                return NotificationTypeInfo$lambda$9$lambda$8;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                    }
                    startRestartGroup.endReplaceGroup();
                    SimpleButtonData simpleButtonData = new SimpleButtonData(stringResource3, false, false, (Function0) rememberedValue3, 6, null);
                    String stringResource4 = StringResources_androidKt.stringResource(R.string.button_cancel, startRestartGroup, 6);
                    startRestartGroup.startReplaceGroup(1957227894);
                    boolean changed = startRestartGroup.changed(mutableState);
                    Object rememberedValue4 = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue4 == companion.getEmpty()) {
                        rememberedValue4 = new Function0() { // from class: f4.I
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit NotificationTypeInfo$lambda$11$lambda$10;
                                NotificationTypeInfo$lambda$11$lambda$10 = SaleOnBoardOrderUpdatesSectionKt.NotificationTypeInfo$lambda$11$lambda$10(MutableState.this);
                                return NotificationTypeInfo$lambda$11$lambda$10;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                    }
                    startRestartGroup.endReplaceGroup();
                    SimpleButtonData simpleButtonData2 = new SimpleButtonData(stringResource4, false, false, (Function0) rememberedValue4, 6, null);
                    startRestartGroup.startReplaceGroup(1957233678);
                    boolean changed2 = startRestartGroup.changed(mutableState);
                    Object rememberedValue5 = startRestartGroup.rememberedValue();
                    if (changed2 || rememberedValue5 == companion.getEmpty()) {
                        rememberedValue5 = new Function0() { // from class: f4.J
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit NotificationTypeInfo$lambda$13$lambda$12;
                                NotificationTypeInfo$lambda$13$lambda$12 = SaleOnBoardOrderUpdatesSectionKt.NotificationTypeInfo$lambda$13$lambda$12(MutableState.this);
                                return NotificationTypeInfo$lambda$13$lambda$12;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue5);
                    }
                    startRestartGroup.endReplaceGroup();
                    mutableState2 = mutableState4;
                    TextDialogKt.TextDialog(stringResource, stringResource2, simpleButtonData, null, simpleButtonData2, true, (Function0) rememberedValue5, startRestartGroup, 196608, 8);
                } else {
                    mutableState = mutableState3;
                    mutableState2 = mutableState4;
                }
                startRestartGroup.endReplaceGroup();
                Modifier.Companion companion2 = Modifier.INSTANCE;
                float f5 = 16;
                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null);
                AppColor appColor = AppColor.INSTANCE;
                Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BackgroundKt.m103backgroundbw27NRU(m315paddingqDBjuR0$default, appColor.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(f5));
                Arrangement arrangement = Arrangement.INSTANCE;
                Arrangement.Horizontal start = arrangement.getStart();
                Alignment.Companion companion3 = Alignment.INSTANCE;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, companion3.getTop(), startRestartGroup, 0);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs);
                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion4.getConstructor();
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
                Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_notification_bell, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), PaddingKt.m315paddingqDBjuR0$default(SizeKt.m331size3ABfNKs(companion2, Dp.m2599constructorimpl(f5)), 0.0f, Dp.m2599constructorimpl(4), 0.0f, 0.0f, 13, null), Color.INSTANCE.m1501getUnspecified0d7_KjU(), startRestartGroup, 3456, 0);
                Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(companion2, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null);
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getStart(), startRestartGroup, 0);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default2);
                Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
                if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.saleOnBoard_basket_orderUpdates_notificationPermission_details, startRestartGroup, 6), PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 7, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 48, 1572864, 65532);
                if (Build.VERSION.SDK_INT >= 33) {
                    startRestartGroup.startReplaceGroup(-234653473);
                    AppPermission appPermission2 = AppPermission.Notifications;
                    startRestartGroup.startReplaceGroup(2070644815);
                    boolean changed3 = startRestartGroup.changed(mutableState2) | startRestartGroup.changed(mutableState);
                    Object rememberedValue6 = startRestartGroup.rememberedValue();
                    if (changed3 || rememberedValue6 == companion.getEmpty()) {
                        rememberedValue6 = new Function2() { // from class: f4.K
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit NotificationTypeInfo$lambda$19$lambda$18$lambda$15$lambda$14;
                                NotificationTypeInfo$lambda$19$lambda$18$lambda$15$lambda$14 = SaleOnBoardOrderUpdatesSectionKt.NotificationTypeInfo$lambda$19$lambda$18$lambda$15$lambda$14(MutableState.this, mutableState, (AppPermission) obj, ((Boolean) obj2).booleanValue());
                                return NotificationTypeInfo$lambda$19$lambda$18$lambda$15$lambda$14;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue6);
                    }
                    startRestartGroup.endReplaceGroup();
                    GenericPermissionRowKt.GenericPermissionRow((Function2) rememberedValue6, appPermission2, function1, ComposableSingletons$SaleOnBoardOrderUpdatesSectionKt.INSTANCE.m3529getLambda2$app_kombardoProd(), startRestartGroup, (i6 & 896) | 3120, 0);
                    startRestartGroup.endReplaceGroup();
                    composer2 = startRestartGroup;
                } else {
                    startRestartGroup.startReplaceGroup(-233715258);
                    String stringResource5 = StringResources_androidKt.stringResource(R.string.saleOnBoard_basket_orderUpdates_notificationPermission_allow, startRestartGroup, 6);
                    long m3268getGrey50d7_KjU = appColor.m3268getGrey50d7_KjU();
                    startRestartGroup.startReplaceGroup(2070678947);
                    boolean z6 = (i6 & 896) == 256;
                    Object rememberedValue7 = startRestartGroup.rememberedValue();
                    if (z6 || rememberedValue7 == companion.getEmpty()) {
                        rememberedValue7 = new Function0() { // from class: f4.L
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit NotificationTypeInfo$lambda$19$lambda$18$lambda$17$lambda$16;
                                NotificationTypeInfo$lambda$19$lambda$18$lambda$17$lambda$16 = SaleOnBoardOrderUpdatesSectionKt.NotificationTypeInfo$lambda$19$lambda$18$lambda$17$lambda$16(Function1.this);
                                return NotificationTypeInfo$lambda$19$lambda$18$lambda$17$lambda$16;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue7);
                    }
                    Function0 function0 = (Function0) rememberedValue7;
                    startRestartGroup.endReplaceGroup();
                    composer2 = startRestartGroup;
                    SecondaryButtonKt.m3406SecondaryButtonbZJ32A(null, stringResource5, function0, null, false, null, false, null, null, m3268getGrey50d7_KjU, false, composer2, 805306368, 0, 1529);
                    composer2.endReplaceGroup();
                }
                composer2.endNode();
                composer2.endNode();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: f4.M
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit NotificationTypeInfo$lambda$20;
                    NotificationTypeInfo$lambda$20 = SaleOnBoardOrderUpdatesSectionKt.NotificationTypeInfo$lambda$20(SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState.this, z5, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return NotificationTypeInfo$lambda$20;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState NotificationTypeInfo$lambda$1$lambda$0() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        return mutableStateOf$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationTypeInfo$lambda$11$lambda$10(MutableState mutableState) {
        NotificationTypeInfo$lambda$3(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationTypeInfo$lambda$13$lambda$12(MutableState mutableState) {
        NotificationTypeInfo$lambda$3(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationTypeInfo$lambda$19$lambda$18$lambda$15$lambda$14(MutableState mutableState, MutableState mutableState2, AppPermission appPermission, boolean z5) {
        Intrinsics.checkNotNullParameter(appPermission, "<unused var>");
        NotificationTypeInfo$lambda$7(mutableState, z5);
        NotificationTypeInfo$lambda$3(mutableState2, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationTypeInfo$lambda$19$lambda$18$lambda$17$lambda$16(Function1 function1) {
        function1.invoke(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    private static final boolean NotificationTypeInfo$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationTypeInfo$lambda$20(SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState, boolean z5, Function1 function1, int i5, Composer composer, int i6) {
        NotificationTypeInfo(saleOnBoardCheckoutState, z5, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void NotificationTypeInfo$lambda$3(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState NotificationTypeInfo$lambda$5$lambda$4() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        return mutableStateOf$default;
    }

    private static final boolean NotificationTypeInfo$lambda$6(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void NotificationTypeInfo$lambda$7(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationTypeInfo$lambda$9$lambda$8(Context context, MutableState mutableState) {
        PermissionExtensionsKt.openAppSettings(context);
        NotificationTypeInfo$lambda$3(mutableState, false);
        return Unit.INSTANCE;
    }

    public static final void saleOnBoardOrderUpdatesSection(LazyListScope lazyListScope, boolean z5, SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState, Function1<? super NotificationType, Unit> onNotificationTypeChange, Function1<? super Boolean, Unit> togglePushNotifications) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(saleOnBoardCheckoutState, "saleOnBoardCheckoutState");
        Intrinsics.checkNotNullParameter(onNotificationTypeChange, "onNotificationTypeChange");
        Intrinsics.checkNotNullParameter(togglePushNotifications, "togglePushNotifications");
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-881277403, true, new SaleOnBoardOrderUpdatesSectionKt$saleOnBoardOrderUpdatesSection$1(saleOnBoardCheckoutState, z5, togglePushNotifications, onNotificationTypeChange)), 3, null);
        LazyListScope.item$default(lazyListScope, null, null, ComposableSingletons$SaleOnBoardOrderUpdatesSectionKt.INSTANCE.m3528getLambda1$app_kombardoProd(), 3, null);
    }
}
