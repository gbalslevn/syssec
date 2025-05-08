package dk.molslinjen.ui.views.global.navigation;

import androidx.compose.material.ModalBottomSheetKt;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.material.navigation.BottomSheetNavigator;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavHostControllerKt;
import dk.molslinjen.ui.views.global.navigation.SimpleScreenConfig;
import dk.molslinjen.ui.views.screens.main.MainScreenKt;
import dk.molslinjen.ui.views.screens.main.MainViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class MainActivity$onCreate$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MainActivity this$0;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ModalBottomSheetValue.values().length];
            try {
                iArr[ModalBottomSheetValue.Hidden.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ModalBottomSheetValue.Expanded.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ModalBottomSheetValue.HalfExpanded.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MainActivity$onCreate$1(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$1(Ref$ObjectRef ref$ObjectRef, ModalBottomSheetValue it) {
        Intrinsics.checkNotNullParameter(it, "it");
        int i5 = WhenMappings.$EnumSwitchMapping$0[it.ordinal()];
        if (i5 != 1) {
            if (i5 == 2 || i5 == 3) {
                return true;
            }
            throw new NoWhenBranchMatchedException();
        }
        Function0 function0 = (Function0) ref$ObjectRef.element;
        if (function0 != null) {
            return ((Boolean) function0.invoke()).booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit invoke$lambda$3(Ref$ObjectRef ref$ObjectRef, Function0 function0) {
        ref$ObjectRef.element = function0;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4(Ref$ObjectRef ref$ObjectRef, Function0 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (Intrinsics.areEqual(ref$ObjectRef.element, callback)) {
            ref$ObjectRef.element = null;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [T, kotlin.jvm.functions.Function0] */
    public final void invoke(Composer composer, int i5) {
        NavHostController navHostController;
        CreationExtras creationExtras;
        NavHostController navHostController2;
        MutableStateFlow mutableStateFlow;
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-998842175, i5, -1, "dk.molslinjen.ui.views.global.navigation.MainActivity.onCreate.<anonymous> (MainActivity.kt:122)");
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        composer.startReplaceGroup(1921085732);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            composer.updateRememberedValue(null);
            rememberedValue = null;
        }
        composer.endReplaceGroup();
        ref$ObjectRef.element = (Function0) rememberedValue;
        ModalBottomSheetState rememberModalBottomSheetState = ModalBottomSheetKt.rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, null, new Function1() { // from class: dk.molslinjen.ui.views.global.navigation.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean invoke$lambda$1;
                invoke$lambda$1 = MainActivity$onCreate$1.invoke$lambda$1(Ref$ObjectRef.this, (ModalBottomSheetValue) obj);
                return Boolean.valueOf(invoke$lambda$1);
            }
        }, true, composer, 3078, 2);
        composer.startReplaceGroup(1921105867);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new BottomSheetNavigator(rememberModalBottomSheetState);
            composer.updateRememberedValue(rememberedValue2);
        }
        BottomSheetNavigator bottomSheetNavigator = (BottomSheetNavigator) rememberedValue2;
        composer.endReplaceGroup();
        this.this$0.navHostController = NavHostControllerKt.rememberNavController(new Navigator[]{bottomSheetNavigator}, composer, 0);
        MainActivity mainActivity = this.this$0;
        navHostController = mainActivity.navHostController;
        if (navHostController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navHostController");
            navHostController = null;
        }
        mainActivity.ensureNavigationState(navHostController);
        SimpleScreenConfig.Companion companion2 = SimpleScreenConfig.INSTANCE;
        companion2.initBottomBar(this.this$0.getTicketsManager());
        companion2.initTopBar(this.this$0.getUserManager(), this.this$0.getCompanyViewHelper());
        composer.startReplaceableGroup(1890788296);
        ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
        if (current != null) {
            ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
            composer.startReplaceableGroup(1729797275);
            if (current instanceof HasDefaultViewModelProviderFactory) {
                creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
            } else {
                creationExtras = CreationExtras.Empty.INSTANCE;
            }
            ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) MainViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            MainViewModel mainViewModel = (MainViewModel) viewModel;
            navHostController2 = this.this$0.navHostController;
            if (navHostController2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navHostController");
                navHostController2 = null;
            }
            Function1 function1 = new Function1() { // from class: dk.molslinjen.ui.views.global.navigation.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$3;
                    invoke$lambda$3 = MainActivity$onCreate$1.invoke$lambda$3(Ref$ObjectRef.this, (Function0) obj);
                    return invoke$lambda$3;
                }
            };
            Function1 function12 = new Function1() { // from class: dk.molslinjen.ui.views.global.navigation.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$4;
                    invoke$lambda$4 = MainActivity$onCreate$1.invoke$lambda$4(Ref$ObjectRef.this, (Function0) obj);
                    return invoke$lambda$4;
                }
            };
            mutableStateFlow = this.this$0.pushDeepLinkEventRoute;
            MainScreenKt.MainScreen(mainViewModel, navHostController2, bottomSheetNavigator, function1, function12, mutableStateFlow, composer, BottomSheetNavigator.$stable << 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
    }
}
