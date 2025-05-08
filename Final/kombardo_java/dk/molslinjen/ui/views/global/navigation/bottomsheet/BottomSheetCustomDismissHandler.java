package dk.molslinjen.ui.views.global.navigation.bottomsheet;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcher;
import androidx.view.OnBackPressedDispatcherKt;
import androidx.view.OnBackPressedDispatcherOwner;
import androidx.view.compose.LocalOnBackPressedDispatcherOwner;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.spec.Direction;
import dk.molslinjen.ui.views.global.navigation.BackstackEntryLifecycleListenerKt;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetCustomDismissHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012 \u0010\u0007\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0004\u0018\u0001`\u0005\u0012\u0004\u0012\u00020\u00060\u0002\u0012\u001c\u0010\b\u001a\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005\u0012\u0004\u0012\u00020\u00060\u0002¢\u0006\u0004\b\t\u0010\nJi\u0010\u0013\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2 \u0010\u0007\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0004\u0018\u0001`\u0005\u0012\u0004\u0012\u00020\u00060\u00022&\u0010\u0012\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010\u0012\u0004\u0012\u00020\u00060\u000fH\u0003¢\u0006\u0004\b\u0013\u0010\u0014JO\u0010\u0017\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\r2&\u0010\u0012\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010\u0012\u0004\u0012\u00020\u00060\u000fH\u0007¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010&\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b&\u0010'R4\u0010\u0007\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0004\u0018\u0001`\u0005\u0012\u0004\u0012\u00020\u00060\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010(\u001a\u0004\b)\u0010*R0\u0010\b\u001a\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005\u0012\u0004\u0012\u00020\u00060\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010(\u001a\u0004\b+\u0010*R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R$\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0004\u0018\u0001`\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102¨\u00064²\u0006\u000e\u00103\u001a\u00020\u00048\n@\nX\u008a\u008e\u0002"}, d2 = {"Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetCustomDismissHandler;", BuildConfig.FLAVOR, "Lkotlin/Function1;", "Lkotlin/Function0;", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetCloseCallback;", BuildConfig.FLAVOR, "setSheetCloseConfirmCallback", "resetSheetCloseConfirmCallbackIfThisCallback", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Landroidx/navigation/NavBackStackEntry;", "navBackStackEntry", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Lkotlin/Function2;", "Landroidx/compose/runtime/MutableState;", "Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetCloseData;", "content", "CustomDismissSheet", "(Landroidx/navigation/NavBackStackEntry;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "Landroidx/navigation/NavController;", "navController", "SetupHandling", "(Landroidx/navigation/NavBackStackEntry;Landroidx/navigation/NavController;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "Lcom/ramcosta/composedestinations/spec/Direction;", "destination", "Landroidx/navigation/NavOptions;", "navOptions", "navigateWithoutClosingExistingCustomHandledSheet", "(Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Lcom/ramcosta/composedestinations/spec/Direction;Landroidx/navigation/NavOptions;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/jvm/functions/Function1;", "getSetSheetCloseConfirmCallback", "()Lkotlin/jvm/functions/Function1;", "getResetSheetCloseConfirmCallbackIfThisCallback", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "sheetCloseConfirmCallback", "Lkotlin/jvm/functions/Function0;", "forceNavigationWithoutClosingCustomHandledBottomSheets", "Z", "showCloseWarningDialog", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class BottomSheetCustomDismissHandler {
    private final CoroutineScope coroutineScope;
    private boolean forceNavigationWithoutClosingCustomHandledBottomSheets;
    private final Function1<Function0<Boolean>, Unit> resetSheetCloseConfirmCallbackIfThisCallback;
    private final Function1<Function0<Boolean>, Unit> setSheetCloseConfirmCallback;
    private Function0<Boolean> sheetCloseConfirmCallback;

    /* JADX WARN: Multi-variable type inference failed */
    public BottomSheetCustomDismissHandler(Function1<? super Function0<Boolean>, Unit> setSheetCloseConfirmCallback, Function1<? super Function0<Boolean>, Unit> resetSheetCloseConfirmCallbackIfThisCallback) {
        Intrinsics.checkNotNullParameter(setSheetCloseConfirmCallback, "setSheetCloseConfirmCallback");
        Intrinsics.checkNotNullParameter(resetSheetCloseConfirmCallbackIfThisCallback, "resetSheetCloseConfirmCallbackIfThisCallback");
        this.setSheetCloseConfirmCallback = setSheetCloseConfirmCallback;
        this.resetSheetCloseConfirmCallbackIfThisCallback = resetSheetCloseConfirmCallbackIfThisCallback;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
    }

    private final void CustomDismissSheet(final NavBackStackEntry navBackStackEntry, final DestinationsNavigator destinationsNavigator, final Function1<? super Function0<Boolean>, Unit> function1, final Function4<? super Function0<Unit>, ? super MutableState<BottomSheetCloseData>, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i5) {
        int i6;
        final Function0 function0;
        final BottomSheetCloseData bottomSheetCloseData;
        Composer startRestartGroup = composer.startRestartGroup(1134124881);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(navBackStackEntry) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(destinationsNavigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function4) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(this) ? 16384 : 8192;
        }
        int i7 = i6;
        if ((i7 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1134124881, i7, -1, "dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetCustomDismissHandler.CustomDismissSheet (BottomSheetCustomDismissHandler.kt:92)");
            }
            startRestartGroup.startReplaceGroup(-1692679753);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1692677448);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            startRestartGroup.startReplaceGroup(-1692675448);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = Boolean.FALSE;
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            boolean booleanValue = ((Boolean) rememberedValue3).booleanValue();
            startRestartGroup.endReplaceGroup();
            ref$BooleanRef.element = booleanValue;
            final Function0 function02 = new Function0() { // from class: S1.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit CustomDismissSheet$lambda$8;
                    CustomDismissSheet$lambda$8 = BottomSheetCustomDismissHandler.CustomDismissSheet$lambda$8(MutableState.this, ref$BooleanRef, destinationsNavigator, mutableState2);
                    return CustomDismissSheet$lambda$8;
                }
            };
            Function0<Boolean> function03 = new Function0() { // from class: S1.f
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    boolean CustomDismissSheet$lambda$9;
                    CustomDismissSheet$lambda$9 = BottomSheetCustomDismissHandler.CustomDismissSheet$lambda$9(BottomSheetCustomDismissHandler.this, ref$BooleanRef, function02);
                    return Boolean.valueOf(CustomDismissSheet$lambda$9);
                }
            };
            this.sheetCloseConfirmCallback = function03;
            function1.invoke(function03);
            OnBackPressedDispatcherOwner current = LocalOnBackPressedDispatcherOwner.INSTANCE.getCurrent(startRestartGroup, LocalOnBackPressedDispatcherOwner.$stable);
            OnBackPressedDispatcher onBackPressedDispatcher = current != null ? current.getOnBackPressedDispatcher() : null;
            startRestartGroup.startReplaceGroup(-1692641986);
            if (onBackPressedDispatcher == null) {
                function0 = function02;
            } else {
                startRestartGroup.startReplaceGroup(-1692640777);
                boolean changed = startRestartGroup.changed(function02);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new Function1() { // from class: S1.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit CustomDismissSheet$lambda$11$lambda$10;
                            CustomDismissSheet$lambda$11$lambda$10 = BottomSheetCustomDismissHandler.CustomDismissSheet$lambda$11$lambda$10(Function0.this, (OnBackPressedCallback) obj);
                            return CustomDismissSheet$lambda$11$lambda$10;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceGroup();
                function0 = function02;
                OnBackPressedDispatcherKt.addCallback$default(onBackPressedDispatcher, navBackStackEntry, false, (Function1) rememberedValue4, 2, null);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1692638873);
            if (CustomDismissSheet$lambda$5(mutableState2) && (bottomSheetCloseData = (BottomSheetCloseData) mutableState.getValue()) != null) {
                String dialogText = bottomSheetCloseData.getDialogText();
                String dialogButtonText = bottomSheetCloseData.getDialogButtonText();
                startRestartGroup.startReplaceGroup(456982746);
                boolean changed2 = startRestartGroup.changed(bottomSheetCloseData) | startRestartGroup.changed(function0);
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue5 == companion.getEmpty()) {
                    rememberedValue5 = new Function0() { // from class: S1.h
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CustomDismissSheet$lambda$16$lambda$13$lambda$12;
                            CustomDismissSheet$lambda$16$lambda$13$lambda$12 = BottomSheetCustomDismissHandler.CustomDismissSheet$lambda$16$lambda$13$lambda$12(MutableState.this, bottomSheetCloseData, function0, mutableState2);
                            return CustomDismissSheet$lambda$16$lambda$13$lambda$12;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                Function0 function04 = (Function0) rememberedValue5;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(456989943);
                Object rememberedValue6 = startRestartGroup.rememberedValue();
                if (rememberedValue6 == companion.getEmpty()) {
                    rememberedValue6 = new Function0() { // from class: S1.i
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CustomDismissSheet$lambda$16$lambda$15$lambda$14;
                            CustomDismissSheet$lambda$16$lambda$15$lambda$14 = BottomSheetCustomDismissHandler.CustomDismissSheet$lambda$16$lambda$15$lambda$14(MutableState.this);
                            return CustomDismissSheet$lambda$16$lambda$15$lambda$14;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                }
                startRestartGroup.endReplaceGroup();
                BottomSheetCloseWarningDialogKt.BottomSheetCloseWarningDialog(dialogText, dialogButtonText, function04, (Function0) rememberedValue6, startRestartGroup, 3072);
            }
            startRestartGroup.endReplaceGroup();
            function4.invoke(function0, mutableState, startRestartGroup, Integer.valueOf(((i7 >> 3) & 896) | 48));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: S1.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CustomDismissSheet$lambda$17;
                    CustomDismissSheet$lambda$17 = BottomSheetCustomDismissHandler.CustomDismissSheet$lambda$17(BottomSheetCustomDismissHandler.this, navBackStackEntry, destinationsNavigator, function1, function4, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return CustomDismissSheet$lambda$17;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomDismissSheet$lambda$11$lambda$10(Function0 function0, OnBackPressedCallback addCallback) {
        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomDismissSheet$lambda$16$lambda$13$lambda$12(MutableState mutableState, BottomSheetCloseData bottomSheetCloseData, Function0 function0, MutableState mutableState2) {
        mutableState.setValue(BottomSheetCloseData.copy$default(bottomSheetCloseData, false, null, null, null, 14, null));
        function0.invoke();
        CustomDismissSheet$lambda$6(mutableState2, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomDismissSheet$lambda$16$lambda$15$lambda$14(MutableState mutableState) {
        CustomDismissSheet$lambda$6(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomDismissSheet$lambda$17(BottomSheetCustomDismissHandler bottomSheetCustomDismissHandler, NavBackStackEntry navBackStackEntry, DestinationsNavigator destinationsNavigator, Function1 function1, Function4 function4, int i5, Composer composer, int i6) {
        bottomSheetCustomDismissHandler.CustomDismissSheet(navBackStackEntry, destinationsNavigator, function1, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final boolean CustomDismissSheet$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void CustomDismissSheet$lambda$6(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomDismissSheet$lambda$8(MutableState mutableState, Ref$BooleanRef ref$BooleanRef, DestinationsNavigator destinationsNavigator, MutableState mutableState2) {
        Function0<Unit> customDismiss;
        BottomSheetCloseData bottomSheetCloseData = (BottomSheetCloseData) mutableState.getValue();
        if (bottomSheetCloseData == null || !bottomSheetCloseData.getPromptForClose()) {
            ref$BooleanRef.element = true;
            if (bottomSheetCloseData == null || (customDismiss = bottomSheetCloseData.getCustomDismiss()) == null) {
                destinationsNavigator.popBackStack();
            } else {
                customDismiss.invoke();
            }
        } else {
            CustomDismissSheet$lambda$6(mutableState2, true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CustomDismissSheet$lambda$9(BottomSheetCustomDismissHandler bottomSheetCustomDismissHandler, Ref$BooleanRef ref$BooleanRef, Function0 function0) {
        if (bottomSheetCustomDismissHandler.forceNavigationWithoutClosingCustomHandledBottomSheets || ref$BooleanRef.element) {
            return true;
        }
        function0.invoke();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetupHandling$lambda$1$lambda$0(BottomSheetCustomDismissHandler bottomSheetCustomDismissHandler) {
        BuildersKt__Builders_commonKt.launch$default(bottomSheetCustomDismissHandler.coroutineScope, null, null, new BottomSheetCustomDismissHandler$SetupHandling$1$1$1(bottomSheetCustomDismissHandler, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetupHandling$lambda$2(BottomSheetCustomDismissHandler bottomSheetCustomDismissHandler, NavBackStackEntry navBackStackEntry, NavController navController, DestinationsNavigator destinationsNavigator, Function4 function4, int i5, Composer composer, int i6) {
        bottomSheetCustomDismissHandler.SetupHandling(navBackStackEntry, navController, destinationsNavigator, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void navigateWithoutClosingExistingCustomHandledSheet$default(BottomSheetCustomDismissHandler bottomSheetCustomDismissHandler, DestinationsNavigator destinationsNavigator, Direction direction, NavOptions navOptions, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            navOptions = null;
        }
        bottomSheetCustomDismissHandler.navigateWithoutClosingExistingCustomHandledSheet(destinationsNavigator, direction, navOptions);
    }

    public final void SetupHandling(final NavBackStackEntry navBackStackEntry, final NavController navController, final DestinationsNavigator navigator, final Function4<? super Function0<Unit>, ? super MutableState<BottomSheetCloseData>, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(305581751);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(navBackStackEntry) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(navController) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(content) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(this) ? 16384 : 8192;
        }
        if ((i6 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(305581751, i6, -1, "dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetCustomDismissHandler.SetupHandling (BottomSheetCustomDismissHandler.kt:39)");
            }
            startRestartGroup.startReplaceGroup(1727164299);
            boolean changedInstance = startRestartGroup.changedInstance(this);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: S1.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SetupHandling$lambda$1$lambda$0;
                        SetupHandling$lambda$1$lambda$0 = BottomSheetCustomDismissHandler.SetupHandling$lambda$1$lambda$0(BottomSheetCustomDismissHandler.this);
                        return SetupHandling$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            int i7 = i6 >> 3;
            BackstackEntryLifecycleListenerKt.BackstackEntryLifecycleListener(navController, navBackStackEntry, (Function0) rememberedValue, startRestartGroup, (i7 & 14) | ((i6 << 3) & 112));
            CustomDismissSheet(navBackStackEntry, navigator, getSetSheetCloseConfirmCallback(), content, startRestartGroup, (i7 & 112) | (i6 & 14) | (i6 & 7168) | (i6 & 57344));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: S1.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SetupHandling$lambda$2;
                    SetupHandling$lambda$2 = BottomSheetCustomDismissHandler.SetupHandling$lambda$2(BottomSheetCustomDismissHandler.this, navBackStackEntry, navController, navigator, content, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SetupHandling$lambda$2;
                }
            });
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BottomSheetCustomDismissHandler)) {
            return false;
        }
        BottomSheetCustomDismissHandler bottomSheetCustomDismissHandler = (BottomSheetCustomDismissHandler) other;
        return Intrinsics.areEqual(this.setSheetCloseConfirmCallback, bottomSheetCustomDismissHandler.setSheetCloseConfirmCallback) && Intrinsics.areEqual(this.resetSheetCloseConfirmCallbackIfThisCallback, bottomSheetCustomDismissHandler.resetSheetCloseConfirmCallbackIfThisCallback);
    }

    public Function1<Function0<Boolean>, Unit> getResetSheetCloseConfirmCallbackIfThisCallback() {
        return this.resetSheetCloseConfirmCallbackIfThisCallback;
    }

    public Function1<Function0<Boolean>, Unit> getSetSheetCloseConfirmCallback() {
        return this.setSheetCloseConfirmCallback;
    }

    public int hashCode() {
        return (this.setSheetCloseConfirmCallback.hashCode() * 31) + this.resetSheetCloseConfirmCallbackIfThisCallback.hashCode();
    }

    public final void navigateWithoutClosingExistingCustomHandledSheet(DestinationsNavigator navigator, Direction destination, NavOptions navOptions) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(destination, "destination");
        this.forceNavigationWithoutClosingCustomHandledBottomSheets = true;
        DestinationsNavigator.DefaultImpls.navigate$default(navigator, destination, navOptions, null, 4, null);
    }

    public String toString() {
        return "BottomSheetCustomDismissHandler(setSheetCloseConfirmCallback=" + this.setSheetCloseConfirmCallback + ", resetSheetCloseConfirmCallbackIfThisCallback=" + this.resetSheetCloseConfirmCallbackIfThisCallback + ")";
    }
}
