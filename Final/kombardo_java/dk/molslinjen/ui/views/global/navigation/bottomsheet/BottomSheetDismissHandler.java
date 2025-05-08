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
import androidx.view.compose.BackHandlerKt;
import androidx.view.compose.LocalOnBackPressedDispatcherOwner;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.spec.Direction;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import dk.molslinjen.ui.views.global.navigation.BackstackEntryLifecycleListenerKt;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetDismissHandler;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001BG\u0012 \u0010\u0007\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0004\u0018\u0001`\u0005\u0012\u0004\u0012\u00020\u00060\u0002\u0012\u001c\u0010\b\u001a\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005\u0012\u0004\u0012\u00020\u00060\u0002¢\u0006\u0004\b\t\u0010\nJ1\u0010\u0013\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0003¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0017\u0010\u0018J5\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0002\b\u0003\u0018\u00010\u0019j\u0004\u0018\u0001`\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ)\u0010\"\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\"\u0010#J\u001b\u0010\u001d\u001a\u00020\u00062\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u001d\u0010%R4\u0010\u0007\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0004\u0018\u0001`\u0005\u0012\u0004\u0012\u00020\u00060\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010&\u001a\u0004\b'\u0010(R0\u0010\b\u001a\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005\u0012\u0004\u0012\u00020\u00060\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010&\u001a\u0004\b)\u0010(R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010.R$\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00048\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u00104\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u00066"}, d2 = {"Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetDismissHandler;", BuildConfig.FLAVOR, "Lkotlin/Function1;", "Lkotlin/Function0;", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetCloseCallback;", BuildConfig.FLAVOR, "setSheetCloseConfirmCallback", "resetSheetCloseConfirmCallbackIfThisCallback", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BlockedDismissType;", "blockedDismissType", "Landroidx/activity/OnBackPressedDispatcherOwner;", "onBackPressedDispatcherOwner", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Landroidx/navigation/NavBackStackEntry;", "navBackStackEntry", "SetupOnBackPressedDispatcher", "(Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BlockedDismissType;Landroidx/activity/OnBackPressedDispatcherOwner;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/navigation/NavBackStackEntry;Landroidx/compose/runtime/Composer;I)V", "Landroidx/navigation/NavController;", "navController", "SetupHandling", "(Landroidx/navigation/NavBackStackEntry;Landroidx/navigation/NavController;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BlockedDismissType;Landroidx/compose/runtime/Composer;I)V", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Lcom/ramcosta/composedestinations/spec/DestinationSpec;", "destination", "inclusive", "dismissPopBlockingSheets", "(Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;Z)V", "Lcom/ramcosta/composedestinations/spec/Direction;", "Landroidx/navigation/NavOptions;", "navOptions", "navigatePopBlockingSheets", "(Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Lcom/ramcosta/composedestinations/spec/Direction;Landroidx/navigation/NavOptions;)V", "customDismiss", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/jvm/functions/Function1;", "getSetSheetCloseConfirmCallback", "()Lkotlin/jvm/functions/Function1;", "getResetSheetCloseConfirmCallbackIfThisCallback", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/runtime/MutableState;", "value", "forceDismissBottomSheetsAllowed", "Z", "setForceDismissBottomSheetsAllowed", "(Z)V", "sheetCloseConfirmCallback", "Lkotlin/jvm/functions/Function0;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BottomSheetDismissHandler {
    private final MutableState<BlockedDismissType> blockedDismissType;
    private final CoroutineScope coroutineScope;
    private boolean forceDismissBottomSheetsAllowed;
    private final Function1<Function0<Boolean>, Unit> resetSheetCloseConfirmCallbackIfThisCallback;
    private final Function1<Function0<Boolean>, Unit> setSheetCloseConfirmCallback;
    private final Function0<Boolean> sheetCloseConfirmCallback;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BlockedDismissType.values().length];
            try {
                iArr[BlockedDismissType.DragToDismiss.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BlockedDismissType.DragToDismissAndBackAction.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BlockedDismissType.BackAction.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BlockedDismissType.None.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BottomSheetDismissHandler(Function1<? super Function0<Boolean>, Unit> setSheetCloseConfirmCallback, Function1<? super Function0<Boolean>, Unit> resetSheetCloseConfirmCallbackIfThisCallback) {
        MutableState<BlockedDismissType> mutableStateOf$default;
        Intrinsics.checkNotNullParameter(setSheetCloseConfirmCallback, "setSheetCloseConfirmCallback");
        Intrinsics.checkNotNullParameter(resetSheetCloseConfirmCallbackIfThisCallback, "resetSheetCloseConfirmCallbackIfThisCallback");
        this.setSheetCloseConfirmCallback = setSheetCloseConfirmCallback;
        this.resetSheetCloseConfirmCallbackIfThisCallback = resetSheetCloseConfirmCallbackIfThisCallback;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(BlockedDismissType.None, null, 2, null);
        this.blockedDismissType = mutableStateOf$default;
        this.sheetCloseConfirmCallback = new Function0() { // from class: S1.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean sheetCloseConfirmCallback$lambda$3;
                sheetCloseConfirmCallback$lambda$3 = BottomSheetDismissHandler.sheetCloseConfirmCallback$lambda$3(BottomSheetDismissHandler.this);
                return Boolean.valueOf(sheetCloseConfirmCallback$lambda$3);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetupHandling$lambda$1$lambda$0(BottomSheetDismissHandler bottomSheetDismissHandler) {
        BuildersKt__Builders_commonKt.launch$default(bottomSheetDismissHandler.coroutineScope, null, null, new BottomSheetDismissHandler$SetupHandling$1$1$1(bottomSheetDismissHandler, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetupHandling$lambda$2(BottomSheetDismissHandler bottomSheetDismissHandler, NavBackStackEntry navBackStackEntry, NavController navController, DestinationsNavigator destinationsNavigator, BlockedDismissType blockedDismissType, int i5, Composer composer, int i6) {
        bottomSheetDismissHandler.SetupHandling(navBackStackEntry, navController, destinationsNavigator, blockedDismissType, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private final void SetupOnBackPressedDispatcher(final BlockedDismissType blockedDismissType, final OnBackPressedDispatcherOwner onBackPressedDispatcherOwner, final DestinationsNavigator destinationsNavigator, final NavBackStackEntry navBackStackEntry, Composer composer, final int i5) {
        int i6;
        OnBackPressedDispatcher onBackPressedDispatcher;
        int i7;
        boolean z5;
        Composer startRestartGroup = composer.startRestartGroup(-1075087491);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(blockedDismissType) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(onBackPressedDispatcherOwner) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(destinationsNavigator) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(navBackStackEntry) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(this) ? 16384 : 8192;
        }
        if ((i6 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1075087491, i6, -1, "dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetDismissHandler.SetupOnBackPressedDispatcher (BottomSheetDismissHandler.kt:99)");
            }
            int i8 = WhenMappings.$EnumSwitchMapping$0[blockedDismissType.ordinal()];
            if (i8 == 1) {
                startRestartGroup.startReplaceGroup(1134739590);
                onBackPressedDispatcher = onBackPressedDispatcherOwner != null ? onBackPressedDispatcherOwner.getOnBackPressedDispatcher() : null;
                if (onBackPressedDispatcher != null) {
                    startRestartGroup.startReplaceGroup(1283533950);
                    boolean changedInstance = startRestartGroup.changedInstance(this) | ((i6 & 896) == 256);
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function1() { // from class: S1.p
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit SetupOnBackPressedDispatcher$lambda$9$lambda$8;
                                SetupOnBackPressedDispatcher$lambda$9$lambda$8 = BottomSheetDismissHandler.SetupOnBackPressedDispatcher$lambda$9$lambda$8(BottomSheetDismissHandler.this, destinationsNavigator, (OnBackPressedCallback) obj);
                                return SetupOnBackPressedDispatcher$lambda$9$lambda$8;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceGroup();
                    OnBackPressedDispatcherKt.addCallback$default(onBackPressedDispatcher, navBackStackEntry, false, (Function1) rememberedValue, 2, null);
                }
                startRestartGroup.endReplaceGroup();
            } else if (i8 == 2 || i8 == 3) {
                startRestartGroup.startReplaceGroup(1134374906);
                onBackPressedDispatcher = onBackPressedDispatcherOwner != null ? onBackPressedDispatcherOwner.getOnBackPressedDispatcher() : null;
                startRestartGroup.startReplaceGroup(1283520865);
                if (onBackPressedDispatcher == null) {
                    i7 = 1;
                    z5 = false;
                } else {
                    startRestartGroup.startReplaceGroup(1283522074);
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new Function1() { // from class: S1.n
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit SetupOnBackPressedDispatcher$lambda$5$lambda$4;
                                SetupOnBackPressedDispatcher$lambda$5$lambda$4 = BottomSheetDismissHandler.SetupOnBackPressedDispatcher$lambda$5$lambda$4((OnBackPressedCallback) obj);
                                return SetupOnBackPressedDispatcher$lambda$5$lambda$4;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    startRestartGroup.endReplaceGroup();
                    i7 = 1;
                    z5 = false;
                    OnBackPressedDispatcherKt.addCallback$default(onBackPressedDispatcher, navBackStackEntry, false, (Function1) rememberedValue2, 2, null);
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1283525658);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: S1.o
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                BackHandlerKt.BackHandler(z5, (Function0) rememberedValue3, startRestartGroup, 48, i7);
                startRestartGroup.endReplaceGroup();
            } else {
                if (i8 != 4) {
                    startRestartGroup.startReplaceGroup(1283514993);
                    startRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                startRestartGroup.startReplaceGroup(1134986288);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: S1.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SetupOnBackPressedDispatcher$lambda$10;
                    SetupOnBackPressedDispatcher$lambda$10 = BottomSheetDismissHandler.SetupOnBackPressedDispatcher$lambda$10(BottomSheetDismissHandler.this, blockedDismissType, onBackPressedDispatcherOwner, destinationsNavigator, navBackStackEntry, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SetupOnBackPressedDispatcher$lambda$10;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetupOnBackPressedDispatcher$lambda$10(BottomSheetDismissHandler bottomSheetDismissHandler, BlockedDismissType blockedDismissType, OnBackPressedDispatcherOwner onBackPressedDispatcherOwner, DestinationsNavigator destinationsNavigator, NavBackStackEntry navBackStackEntry, int i5, Composer composer, int i6) {
        bottomSheetDismissHandler.SetupOnBackPressedDispatcher(blockedDismissType, onBackPressedDispatcherOwner, destinationsNavigator, navBackStackEntry, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetupOnBackPressedDispatcher$lambda$5$lambda$4(OnBackPressedCallback addCallback) {
        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetupOnBackPressedDispatcher$lambda$9$lambda$8(BottomSheetDismissHandler bottomSheetDismissHandler, DestinationsNavigator destinationsNavigator, OnBackPressedCallback addCallback) {
        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
        dismissPopBlockingSheets$default(bottomSheetDismissHandler, destinationsNavigator, null, false, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void dismissPopBlockingSheets$default(BottomSheetDismissHandler bottomSheetDismissHandler, DestinationsNavigator destinationsNavigator, TypedDestinationSpec typedDestinationSpec, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            typedDestinationSpec = null;
        }
        if ((i5 & 4) != 0) {
            z5 = false;
        }
        bottomSheetDismissHandler.dismissPopBlockingSheets(destinationsNavigator, typedDestinationSpec, z5);
    }

    public static /* synthetic */ void navigatePopBlockingSheets$default(BottomSheetDismissHandler bottomSheetDismissHandler, DestinationsNavigator destinationsNavigator, Direction direction, NavOptions navOptions, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            navOptions = null;
        }
        bottomSheetDismissHandler.navigatePopBlockingSheets(destinationsNavigator, direction, navOptions);
    }

    private final void setForceDismissBottomSheetsAllowed(boolean z5) {
        this.forceDismissBottomSheetsAllowed = z5;
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new BottomSheetDismissHandler$forceDismissBottomSheetsAllowed$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean sheetCloseConfirmCallback$lambda$3(BottomSheetDismissHandler bottomSheetDismissHandler) {
        if (bottomSheetDismissHandler.forceDismissBottomSheetsAllowed) {
            return true;
        }
        int i5 = WhenMappings.$EnumSwitchMapping$0[bottomSheetDismissHandler.blockedDismissType.getValue().ordinal()];
        if (i5 == 1 || i5 == 2) {
            return false;
        }
        if (i5 == 3 || i5 == 4) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void SetupHandling(final NavBackStackEntry navBackStackEntry, final NavController navController, final DestinationsNavigator navigator, final BlockedDismissType blockedDismissType, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(blockedDismissType, "blockedDismissType");
        Composer startRestartGroup = composer.startRestartGroup(-19853846);
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
            i6 |= startRestartGroup.changed(blockedDismissType) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(this) ? 16384 : 8192;
        }
        if ((i6 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-19853846, i6, -1, "dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetDismissHandler.SetupHandling (BottomSheetDismissHandler.kt:51)");
            }
            this.blockedDismissType.setValue(blockedDismissType);
            startRestartGroup.startReplaceGroup(1016943694);
            boolean changedInstance = startRestartGroup.changedInstance(this);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: S1.l
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SetupHandling$lambda$1$lambda$0;
                        SetupHandling$lambda$1$lambda$0 = BottomSheetDismissHandler.SetupHandling$lambda$1$lambda$0(BottomSheetDismissHandler.this);
                        return SetupHandling$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            BackstackEntryLifecycleListenerKt.BackstackEntryLifecycleListener(navController, navBackStackEntry, (Function0) rememberedValue, startRestartGroup, ((i6 >> 3) & 14) | ((i6 << 3) & 112));
            getSetSheetCloseConfirmCallback().invoke(this.sheetCloseConfirmCallback);
            SetupOnBackPressedDispatcher(blockedDismissType, LocalOnBackPressedDispatcherOwner.INSTANCE.getCurrent(startRestartGroup, LocalOnBackPressedDispatcherOwner.$stable), navigator, navBackStackEntry, startRestartGroup, ((i6 >> 9) & 14) | (i6 & 896) | ((i6 << 9) & 7168) | (i6 & 57344));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: S1.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SetupHandling$lambda$2;
                    SetupHandling$lambda$2 = BottomSheetDismissHandler.SetupHandling$lambda$2(BottomSheetDismissHandler.this, navBackStackEntry, navController, navigator, blockedDismissType, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SetupHandling$lambda$2;
                }
            });
        }
    }

    public final void dismissPopBlockingSheets(DestinationsNavigator navigator, TypedDestinationSpec<?> destination, boolean inclusive) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        setForceDismissBottomSheetsAllowed(true);
        if (destination != null) {
            DestinationsNavigator.DefaultImpls.popBackStack$default(navigator, destination, inclusive, false, 4, null);
        } else {
            navigator.popBackStack();
        }
    }

    public Function1<Function0<Boolean>, Unit> getResetSheetCloseConfirmCallbackIfThisCallback() {
        return this.resetSheetCloseConfirmCallbackIfThisCallback;
    }

    public Function1<Function0<Boolean>, Unit> getSetSheetCloseConfirmCallback() {
        return this.setSheetCloseConfirmCallback;
    }

    public final void navigatePopBlockingSheets(DestinationsNavigator navigator, Direction destination, NavOptions navOptions) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(destination, "destination");
        setForceDismissBottomSheetsAllowed(true);
        DestinationsNavigator.DefaultImpls.navigate$default(navigator, destination, navOptions, null, 4, null);
    }

    public final void dismissPopBlockingSheets(Function0<Unit> customDismiss) {
        Intrinsics.checkNotNullParameter(customDismiss, "customDismiss");
        setForceDismissBottomSheetsAllowed(true);
        customDismiss.invoke();
    }
}
