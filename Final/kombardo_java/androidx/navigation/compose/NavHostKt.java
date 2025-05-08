package androidx.navigation.compose;

import android.annotation.SuppressLint;
import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.SizeTransform;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateHolderKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.compose.ComposeNavGraphNavigator;
import androidx.navigation.compose.ComposeNavigator;
import androidx.view.compose.PredictiveBackHandlerKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001aã\u0001\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\u001a\b\u0002\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\f0\t2\u001a\b\u0002\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u000e0\t2\u001a\b\u0002\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\f0\t2\u001a\b\u0002\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u000e0\t2\u001e\b\u0002\u0010\u0013\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\t2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\tH\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001aÃ\u0001\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u001a\b\u0002\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\f0\t2\u001a\b\u0002\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u000e0\t2\u001a\b\u0002\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\f0\t2\u001a\b\u0002\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u000e0\t2\u001e\b\u0002\u0010\u0013\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\tH\u0007¢\u0006\u0004\b\u0017\u0010\u001b\u001a#\u0010\u001e\u001a\u0004\u0018\u00010\f*\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\u001e\u0010\u001f\u001a#\u0010 \u001a\u0004\u0018\u00010\u000e*\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b \u0010!\u001a#\u0010\"\u001a\u0004\u0018\u00010\f*\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\"\u0010\u001f\u001a#\u0010#\u001a\u0004\u0018\u00010\u000e*\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b#\u0010!\u001a#\u0010$\u001a\u0004\u0018\u00010\u0012*\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b$\u0010%¨\u0006.²\u0006\u0012\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000b0&8\nX\u008a\u0084\u0002²\u0006\u000e\u0010)\u001a\u00020(8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010+\u001a\u00020*8\n@\nX\u008a\u008e\u0002²\u0006\u0012\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000b0&8\nX\u008a\u0084\u0002²\u0006\u0012\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000b0&8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/navigation/NavHostController;", "navController", BuildConfig.FLAVOR, "startDestination", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/Alignment;", "contentAlignment", "route", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/navigation/NavBackStackEntry;", "Landroidx/compose/animation/EnterTransition;", "enterTransition", "Landroidx/compose/animation/ExitTransition;", "exitTransition", "popEnterTransition", "popExitTransition", "Landroidx/compose/animation/SizeTransform;", "sizeTransform", "Landroidx/navigation/NavGraphBuilder;", BuildConfig.FLAVOR, "builder", "NavHost", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "Landroidx/navigation/NavGraph;", "graph", "(Landroidx/navigation/NavHostController;Landroidx/navigation/NavGraph;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "Landroidx/navigation/NavDestination;", "scope", "createEnterTransition", "(Landroidx/navigation/NavDestination;Landroidx/compose/animation/AnimatedContentTransitionScope;)Landroidx/compose/animation/EnterTransition;", "createExitTransition", "(Landroidx/navigation/NavDestination;Landroidx/compose/animation/AnimatedContentTransitionScope;)Landroidx/compose/animation/ExitTransition;", "createPopEnterTransition", "createPopExitTransition", "createSizeTransform", "(Landroidx/navigation/NavDestination;Landroidx/compose/animation/AnimatedContentTransitionScope;)Landroidx/compose/animation/SizeTransform;", BuildConfig.FLAVOR, "currentBackStack", BuildConfig.FLAVOR, "progress", BuildConfig.FLAVOR, "inPredictiveBack", "allVisibleEntries", "visibleEntries", "navigation-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class NavHostKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavHost(final NavHostController navHostController, final String str, Modifier modifier, Alignment alignment, String str2, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function12, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function13, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function14, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function15, final Function1<? super NavGraphBuilder, Unit> function16, Composer composer, final int i5, final int i6, final int i7) {
        int i8;
        Modifier modifier2;
        int i9;
        Alignment alignment2;
        int i10;
        String str3;
        int i11;
        int i12;
        int i13;
        int i14;
        Modifier modifier3;
        Alignment topStart;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function17;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function18;
        int i15;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function19;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function110;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function111;
        boolean z5;
        Object rememberedValue;
        final Modifier modifier4;
        final Alignment alignment3;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function112;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function113;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function114;
        final String str4;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function115;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function116;
        ScopeUpdateScope endRestartGroup;
        int i16;
        int i17;
        Composer startRestartGroup = composer.startRestartGroup(1840250294);
        if ((i7 & 1) != 0) {
            i8 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i8 = (startRestartGroup.changedInstance(navHostController) ? 4 : 2) | i5;
        } else {
            i8 = i5;
        }
        if ((i7 & 2) != 0) {
            i8 |= 48;
        } else if ((i5 & 48) == 0) {
            i8 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        int i18 = i7 & 4;
        if (i18 != 0) {
            i8 |= 384;
        } else if ((i5 & 384) == 0) {
            modifier2 = modifier;
            i8 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i9 = i7 & 8;
            if (i9 == 0) {
                i8 |= 3072;
            } else if ((i5 & 3072) == 0) {
                alignment2 = alignment;
                i8 |= startRestartGroup.changed(alignment2) ? 2048 : 1024;
                i10 = i7 & 16;
                if (i10 != 0) {
                    i8 |= 24576;
                } else if ((i5 & 24576) == 0) {
                    str3 = str2;
                    i8 |= startRestartGroup.changed(str3) ? 16384 : 8192;
                    i11 = i7 & 32;
                    if (i11 == 0) {
                        i8 |= 196608;
                    } else if ((i5 & 196608) == 0) {
                        i8 |= startRestartGroup.changedInstance(function1) ? 131072 : 65536;
                    }
                    i12 = i7 & 64;
                    if (i12 == 0) {
                        i8 |= 1572864;
                    } else if ((i5 & 1572864) == 0) {
                        i8 |= startRestartGroup.changedInstance(function12) ? 1048576 : 524288;
                    }
                    if ((i5 & 12582912) == 0) {
                        if ((i7 & 128) == 0 && startRestartGroup.changedInstance(function13)) {
                            i17 = 8388608;
                            i8 |= i17;
                        }
                        i17 = 4194304;
                        i8 |= i17;
                    }
                    if ((i5 & 100663296) == 0) {
                        if ((i7 & 256) == 0 && startRestartGroup.changedInstance(function14)) {
                            i16 = 67108864;
                            i8 |= i16;
                        }
                        i16 = 33554432;
                        i8 |= i16;
                    }
                    i13 = i7 & 512;
                    if (i13 == 0) {
                        i8 |= 805306368;
                    } else if ((i5 & 805306368) == 0) {
                        i8 |= startRestartGroup.changedInstance(function15) ? 536870912 : 268435456;
                    }
                    if ((i7 & 1024) == 0) {
                        i14 = i6 | 6;
                    } else if ((i6 & 6) == 0) {
                        i14 = i6 | (startRestartGroup.changedInstance(function16) ? 4 : 2);
                    } else {
                        i14 = i6;
                    }
                    if ((i8 & 306783379) != 306783378 && (i14 & 3) == 2 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        function116 = function1;
                        function112 = function12;
                        function113 = function15;
                        str4 = str3;
                        modifier4 = modifier2;
                        alignment3 = alignment2;
                        function115 = function13;
                        function114 = function14;
                    } else {
                        startRestartGroup.startDefaults();
                        if ((i5 & 1) == 0 && !startRestartGroup.getDefaultsInvalid()) {
                            startRestartGroup.skipToGroupEnd();
                            if ((i7 & 128) != 0) {
                                i8 &= -29360129;
                            }
                            if ((i7 & 256) != 0) {
                                i8 &= -234881025;
                            }
                            function18 = function12;
                            function110 = function14;
                            function111 = function15;
                            modifier3 = modifier2;
                            topStart = alignment2;
                            function17 = function1;
                            i15 = i8;
                            function19 = function13;
                        } else {
                            modifier3 = i18 == 0 ? Modifier.INSTANCE : modifier2;
                            topStart = i9 == 0 ? Alignment.INSTANCE.getTopStart() : alignment2;
                            if (i10 != 0) {
                                str3 = null;
                            }
                            function17 = i11 == 0 ? new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$7
                                @Override // kotlin.jvm.functions.Function1
                                public final EnterTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
                                    return EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(700, 0, null, 6, null), 0.0f, 2, null);
                                }
                            } : function1;
                            function18 = i12 == 0 ? new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$8
                                @Override // kotlin.jvm.functions.Function1
                                public final ExitTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
                                    return EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(700, 0, null, 6, null), 0.0f, 2, null);
                                }
                            } : function12;
                            if ((i7 & 128) == 0) {
                                i15 = i8 & (-29360129);
                                function19 = function17;
                            } else {
                                i15 = i8;
                                function19 = function13;
                            }
                            if ((i7 & 256) == 0) {
                                i15 = (-234881025) & i15;
                                function110 = function18;
                            } else {
                                function110 = function14;
                            }
                            function111 = i13 == 0 ? null : function15;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1840250294, i15, i14, "androidx.navigation.compose.NavHost (NavHost.kt:210)");
                        }
                        z5 = ((57344 & i15) != 16384) | ((i15 & 112) != 32) | ((i14 & 14) != 4);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHostController.get_navigatorProvider(), str, str3);
                            function16.invoke(navGraphBuilder);
                            rememberedValue = navGraphBuilder.build();
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        NavGraph navGraph = (NavGraph) rememberedValue;
                        int i19 = i15 >> 3;
                        NavHost(navHostController, navGraph, modifier3, topStart, function17, function18, function19, function110, function111, startRestartGroup, (i15 & 8078) | (57344 & i19) | (458752 & i19) | (3670016 & i19) | (29360128 & i19) | (i19 & 234881024), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        alignment3 = topStart;
                        function112 = function18;
                        function113 = function111;
                        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function117 = function17;
                        function114 = function110;
                        str4 = str3;
                        function115 = function19;
                        function116 = function117;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$10
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i20) {
                                NavHostKt.NavHost(NavHostController.this, str, modifier4, alignment3, str4, function116, function112, function115, function114, function113, function16, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6), i7);
                            }
                        });
                        return;
                    }
                    return;
                }
                str3 = str2;
                i11 = i7 & 32;
                if (i11 == 0) {
                }
                i12 = i7 & 64;
                if (i12 == 0) {
                }
                if ((i5 & 12582912) == 0) {
                }
                if ((i5 & 100663296) == 0) {
                }
                i13 = i7 & 512;
                if (i13 == 0) {
                }
                if ((i7 & 1024) == 0) {
                }
                if ((i8 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i5 & 1) == 0) {
                }
                if (i18 == 0) {
                }
                if (i9 == 0) {
                }
                if (i10 != 0) {
                }
                if (i11 == 0) {
                }
                if (i12 == 0) {
                }
                if ((i7 & 128) == 0) {
                }
                if ((i7 & 256) == 0) {
                }
                if (i13 == 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                z5 = ((57344 & i15) != 16384) | ((i15 & 112) != 32) | ((i14 & 14) != 4);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z5) {
                }
                NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navHostController.get_navigatorProvider(), str, str3);
                function16.invoke(navGraphBuilder2);
                rememberedValue = navGraphBuilder2.build();
                startRestartGroup.updateRememberedValue(rememberedValue);
                NavGraph navGraph2 = (NavGraph) rememberedValue;
                int i192 = i15 >> 3;
                NavHost(navHostController, navGraph2, modifier3, topStart, function17, function18, function19, function110, function111, startRestartGroup, (i15 & 8078) | (57344 & i192) | (458752 & i192) | (3670016 & i192) | (29360128 & i192) | (i192 & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                alignment3 = topStart;
                function112 = function18;
                function113 = function111;
                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1172 = function17;
                function114 = function110;
                str4 = str3;
                function115 = function19;
                function116 = function1172;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            alignment2 = alignment;
            i10 = i7 & 16;
            if (i10 != 0) {
            }
            str3 = str2;
            i11 = i7 & 32;
            if (i11 == 0) {
            }
            i12 = i7 & 64;
            if (i12 == 0) {
            }
            if ((i5 & 12582912) == 0) {
            }
            if ((i5 & 100663296) == 0) {
            }
            i13 = i7 & 512;
            if (i13 == 0) {
            }
            if ((i7 & 1024) == 0) {
            }
            if ((i8 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) == 0) {
            }
            if (i18 == 0) {
            }
            if (i9 == 0) {
            }
            if (i10 != 0) {
            }
            if (i11 == 0) {
            }
            if (i12 == 0) {
            }
            if ((i7 & 128) == 0) {
            }
            if ((i7 & 256) == 0) {
            }
            if (i13 == 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            z5 = ((57344 & i15) != 16384) | ((i15 & 112) != 32) | ((i14 & 14) != 4);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z5) {
            }
            NavGraphBuilder navGraphBuilder22 = new NavGraphBuilder(navHostController.get_navigatorProvider(), str, str3);
            function16.invoke(navGraphBuilder22);
            rememberedValue = navGraphBuilder22.build();
            startRestartGroup.updateRememberedValue(rememberedValue);
            NavGraph navGraph22 = (NavGraph) rememberedValue;
            int i1922 = i15 >> 3;
            NavHost(navHostController, navGraph22, modifier3, topStart, function17, function18, function19, function110, function111, startRestartGroup, (i15 & 8078) | (57344 & i1922) | (458752 & i1922) | (3670016 & i1922) | (29360128 & i1922) | (i1922 & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            alignment3 = topStart;
            function112 = function18;
            function113 = function111;
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function11722 = function17;
            function114 = function110;
            str4 = str3;
            function115 = function19;
            function116 = function11722;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i9 = i7 & 8;
        if (i9 == 0) {
        }
        alignment2 = alignment;
        i10 = i7 & 16;
        if (i10 != 0) {
        }
        str3 = str2;
        i11 = i7 & 32;
        if (i11 == 0) {
        }
        i12 = i7 & 64;
        if (i12 == 0) {
        }
        if ((i5 & 12582912) == 0) {
        }
        if ((i5 & 100663296) == 0) {
        }
        i13 = i7 & 512;
        if (i13 == 0) {
        }
        if ((i7 & 1024) == 0) {
        }
        if ((i8 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) == 0) {
        }
        if (i18 == 0) {
        }
        if (i9 == 0) {
        }
        if (i10 != 0) {
        }
        if (i11 == 0) {
        }
        if (i12 == 0) {
        }
        if ((i7 & 128) == 0) {
        }
        if ((i7 & 256) == 0) {
        }
        if (i13 == 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        z5 = ((57344 & i15) != 16384) | ((i15 & 112) != 32) | ((i14 & 14) != 4);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z5) {
        }
        NavGraphBuilder navGraphBuilder222 = new NavGraphBuilder(navHostController.get_navigatorProvider(), str, str3);
        function16.invoke(navGraphBuilder222);
        rememberedValue = navGraphBuilder222.build();
        startRestartGroup.updateRememberedValue(rememberedValue);
        NavGraph navGraph222 = (NavGraph) rememberedValue;
        int i19222 = i15 >> 3;
        NavHost(navHostController, navGraph222, modifier3, topStart, function17, function18, function19, function110, function111, startRestartGroup, (i15 & 8078) | (57344 & i19222) | (458752 & i19222) | (3670016 & i19222) | (29360128 & i19222) | (i19222 & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        alignment3 = topStart;
        function112 = function18;
        function113 = function111;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function117222 = function17;
        function114 = function110;
        str4 = str3;
        function115 = function19;
        function116 = function117222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean NavHost$lambda$11(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NavHost$lambda$12(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<NavBackStackEntry> NavHost$lambda$15(State<? extends List<NavBackStackEntry>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<NavBackStackEntry> NavHost$lambda$17(State<? extends List<NavBackStackEntry>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<NavBackStackEntry> NavHost$lambda$6(State<? extends List<NavBackStackEntry>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition createEnterTransition(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> enterTransition$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> enterTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getEnterTransition$navigation_compose_release();
            if (enterTransition$navigation_compose_release2 != null) {
                return enterTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (enterTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getEnterTransition$navigation_compose_release()) == null) {
            return null;
        }
        return enterTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition createExitTransition(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> exitTransition$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> exitTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getExitTransition$navigation_compose_release();
            if (exitTransition$navigation_compose_release2 != null) {
                return exitTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (exitTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getExitTransition$navigation_compose_release()) == null) {
            return null;
        }
        return exitTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition createPopEnterTransition(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> popEnterTransition$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> popEnterTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getPopEnterTransition$navigation_compose_release();
            if (popEnterTransition$navigation_compose_release2 != null) {
                return popEnterTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (popEnterTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getPopEnterTransition$navigation_compose_release()) == null) {
            return null;
        }
        return popEnterTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition createPopExitTransition(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> popExitTransition$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> popExitTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getPopExitTransition$navigation_compose_release();
            if (popExitTransition$navigation_compose_release2 != null) {
                return popExitTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (popExitTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getPopExitTransition$navigation_compose_release()) == null) {
            return null;
        }
        return popExitTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SizeTransform createSizeTransform(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> sizeTransform$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> sizeTransform$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getSizeTransform$navigation_compose_release();
            if (sizeTransform$navigation_compose_release2 != null) {
                return sizeTransform$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (sizeTransform$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getSizeTransform$navigation_compose_release()) == null) {
            return null;
        }
        return sizeTransform$navigation_compose_release.invoke(animatedContentTransitionScope);
    }

    /* JADX WARN: Code restructure failed: missing block: B:140:0x03a9, code lost:
    
        if (r14 == r29.getEmpty()) goto L235;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x059a  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01be  */
    @SuppressLint({"StateFlowValueCalledInComposition"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavHost(final NavHostController navHostController, final NavGraph navGraph, Modifier modifier, Alignment alignment, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function12, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function13, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function14, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function15, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        Modifier modifier2;
        int i9;
        Alignment alignment2;
        int i10;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function16;
        int i11;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function17;
        int i12;
        Modifier modifier3;
        Alignment topStart;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function18;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function19;
        int i13;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function110;
        int i14;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function111;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function112;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function113;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function114;
        ViewModelStoreOwner current;
        Alignment alignment3;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function115;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function116;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function117;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function118;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function119;
        DialogNavigator dialogNavigator;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function120;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function121;
        final Alignment alignment4;
        final Modifier modifier4;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function122;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function123;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function124;
        Map map;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(-1964664536);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(navHostController) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(navGraph) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                modifier2 = modifier;
                i7 |= startRestartGroup.changed(modifier2) ? 256 : 128;
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else if ((i5 & 3072) == 0) {
                    alignment2 = alignment;
                    i7 |= startRestartGroup.changed(alignment2) ? 2048 : 1024;
                    i10 = i6 & 16;
                    if (i10 == 0) {
                        i7 |= 24576;
                    } else if ((i5 & 24576) == 0) {
                        function16 = function1;
                        i7 |= startRestartGroup.changedInstance(function16) ? 16384 : 8192;
                        i11 = i6 & 32;
                        if (i11 != 0) {
                            i7 |= 196608;
                            function17 = function12;
                        } else {
                            function17 = function12;
                            if ((i5 & 196608) == 0) {
                                i7 |= startRestartGroup.changedInstance(function17) ? 131072 : 65536;
                            }
                        }
                        if ((i5 & 1572864) == 0) {
                            i7 |= ((i6 & 64) == 0 && startRestartGroup.changedInstance(function13)) ? 1048576 : 524288;
                        }
                        if ((i5 & 12582912) == 0) {
                            if ((i6 & 128) == 0 && startRestartGroup.changedInstance(function14)) {
                                i15 = 8388608;
                                i7 |= i15;
                            }
                            i15 = 4194304;
                            i7 |= i15;
                        }
                        i12 = i6 & 256;
                        if (i12 != 0) {
                            i7 |= 100663296;
                        } else if ((i5 & 100663296) == 0) {
                            i7 |= startRestartGroup.changedInstance(function15) ? 67108864 : 33554432;
                        }
                        if ((i7 & 38347923) != 38347922 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            function121 = function14;
                            modifier4 = modifier2;
                            alignment4 = alignment2;
                            function122 = function17;
                            function123 = function16;
                            function120 = function13;
                            function118 = function15;
                        } else {
                            startRestartGroup.startDefaults();
                            if ((i5 & 1) == 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i6 & 64) != 0) {
                                    i7 &= -3670017;
                                }
                                if ((i6 & 128) != 0) {
                                    i7 &= -29360129;
                                }
                                function113 = function14;
                                modifier3 = modifier2;
                                topStart = alignment2;
                                function19 = function17;
                                function18 = function16;
                                function114 = function13;
                                function112 = function15;
                            } else {
                                modifier3 = i8 != 0 ? Modifier.INSTANCE : modifier2;
                                topStart = i9 != 0 ? Alignment.INSTANCE.getTopStart() : alignment2;
                                function18 = i10 != 0 ? new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$23
                                    @Override // kotlin.jvm.functions.Function1
                                    public final EnterTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
                                        return EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(700, 0, null, 6, null), 0.0f, 2, null);
                                    }
                                } : function16;
                                function19 = i11 != 0 ? new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$24
                                    @Override // kotlin.jvm.functions.Function1
                                    public final ExitTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
                                        return EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(700, 0, null, 6, null), 0.0f, 2, null);
                                    }
                                } : function17;
                                if ((i6 & 64) != 0) {
                                    i13 = i7 & (-3670017);
                                    function110 = function18;
                                } else {
                                    i13 = i7;
                                    function110 = function13;
                                }
                                if ((i6 & 128) != 0) {
                                    i14 = i13 & (-29360129);
                                    function111 = function19;
                                } else {
                                    i14 = i13;
                                    function111 = function14;
                                }
                                function112 = i12 != 0 ? null : function15;
                                function113 = function111;
                                function114 = function110;
                                i7 = i14;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1964664536, i7, -1, "androidx.navigation.compose.NavHost (NavHost.kt:490)");
                            }
                            final LifecycleOwner lifecycleOwner = (LifecycleOwner) startRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
                            current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, LocalViewModelStoreOwner.$stable);
                            if (current != null) {
                                navHostController.setViewModelStore(current.getViewModelStore());
                                navHostController.setGraph(navGraph);
                                Navigator navigator = navHostController.get_navigatorProvider().getNavigator("composable");
                                final ComposeNavigator composeNavigator = navigator instanceof ComposeNavigator ? (ComposeNavigator) navigator : null;
                                if (composeNavigator == null) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                                    if (endRestartGroup != null) {
                                        final Modifier modifier5 = modifier3;
                                        final Alignment alignment5 = topStart;
                                        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function125 = function18;
                                        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function126 = function19;
                                        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function127 = function114;
                                        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function128 = function113;
                                        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function129 = function112;
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$composeNavigator$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                                invoke(composer2, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer2, int i16) {
                                                NavHostKt.NavHost(NavHostController.this, navGraph, modifier5, alignment5, function125, function126, function127, function128, function129, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                State collectAsState = SnapshotStateKt.collectAsState(composeNavigator.getBackStack(), null, startRestartGroup, 0, 1);
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                Composer.Companion companion = Composer.INSTANCE;
                                if (rememberedValue == companion.getEmpty()) {
                                    rememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                MutableFloatState mutableFloatState = (MutableFloatState) rememberedValue;
                                Object rememberedValue2 = startRestartGroup.rememberedValue();
                                if (rememberedValue2 == companion.getEmpty()) {
                                    alignment3 = topStart;
                                    rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                } else {
                                    alignment3 = topStart;
                                }
                                final MutableState mutableState = (MutableState) rememberedValue2;
                                boolean z5 = NavHost$lambda$6(collectAsState).size() > 1;
                                boolean changed = startRestartGroup.changed(collectAsState) | startRestartGroup.changed(composeNavigator);
                                final Modifier modifier6 = modifier3;
                                Object rememberedValue3 = startRestartGroup.rememberedValue();
                                if (changed || rememberedValue3 == companion.getEmpty()) {
                                    rememberedValue3 = new NavHostKt$NavHost$25$1(composeNavigator, collectAsState, mutableFloatState, mutableState, null);
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                }
                                PredictiveBackHandlerKt.PredictiveBackHandler(z5, (Function2) rememberedValue3, startRestartGroup, 0, 0);
                                boolean changedInstance = startRestartGroup.changedInstance(navHostController) | startRestartGroup.changedInstance(lifecycleOwner);
                                Object rememberedValue4 = startRestartGroup.rememberedValue();
                                if (changedInstance || rememberedValue4 == companion.getEmpty()) {
                                    rememberedValue4 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$26$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                            NavHostController.this.setLifecycleOwner(lifecycleOwner);
                                            return new DisposableEffectResult() { // from class: androidx.navigation.compose.NavHostKt$NavHost$26$1$invoke$$inlined$onDispose$1
                                                @Override // androidx.compose.runtime.DisposableEffectResult
                                                public void dispose() {
                                                }
                                            };
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue4);
                                }
                                EffectsKt.DisposableEffect(lifecycleOwner, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue4, startRestartGroup, 0);
                                final SaveableStateHolder rememberSaveableStateHolder = SaveableStateHolderKt.rememberSaveableStateHolder(startRestartGroup, 0);
                                final State collectAsState2 = SnapshotStateKt.collectAsState(navHostController.getVisibleEntries(), null, startRestartGroup, 0, 1);
                                Object rememberedValue5 = startRestartGroup.rememberedValue();
                                if (rememberedValue5 == companion.getEmpty()) {
                                    rememberedValue5 = SnapshotStateKt.derivedStateOf(new Function0<List<? extends NavBackStackEntry>>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$visibleEntries$2$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final List<? extends NavBackStackEntry> invoke() {
                                            List NavHost$lambda$15;
                                            NavHost$lambda$15 = NavHostKt.NavHost$lambda$15(collectAsState2);
                                            ArrayList arrayList = new ArrayList();
                                            for (Object obj : NavHost$lambda$15) {
                                                if (Intrinsics.areEqual(((NavBackStackEntry) obj).getDestination().getNavigatorName(), "composable")) {
                                                    arrayList.add(obj);
                                                }
                                            }
                                            return arrayList;
                                        }
                                    });
                                    startRestartGroup.updateRememberedValue(rememberedValue5);
                                }
                                final State state = (State) rememberedValue5;
                                final NavBackStackEntry navBackStackEntry = (NavBackStackEntry) CollectionsKt.lastOrNull((List) NavHost$lambda$17(state));
                                Object rememberedValue6 = startRestartGroup.rememberedValue();
                                if (rememberedValue6 == companion.getEmpty()) {
                                    rememberedValue6 = new LinkedHashMap();
                                    startRestartGroup.updateRememberedValue(rememberedValue6);
                                }
                                Map map2 = (Map) rememberedValue6;
                                startRestartGroup.startReplaceGroup(653365120);
                                if (navBackStackEntry != null) {
                                    boolean changed2 = ((((i7 & 3670016) ^ 1572864) > 1048576 && startRestartGroup.changed(function114)) || (i7 & 1572864) == 1048576) | startRestartGroup.changed(composeNavigator) | ((57344 & i7) == 16384);
                                    Object rememberedValue7 = startRestartGroup.rememberedValue();
                                    if (changed2 || rememberedValue7 == companion.getEmpty()) {
                                        rememberedValue7 = new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$finalEnter$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final EnterTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
                                                EnterTransition createPopEnterTransition;
                                                boolean NavHost$lambda$11;
                                                EnterTransition createEnterTransition;
                                                NavDestination destination = animatedContentTransitionScope.getTargetState().getDestination();
                                                Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
                                                ComposeNavigator.Destination destination2 = (ComposeNavigator.Destination) destination;
                                                EnterTransition enterTransition = null;
                                                if (!ComposeNavigator.this.isPop$navigation_compose_release().getValue().booleanValue()) {
                                                    NavHost$lambda$11 = NavHostKt.NavHost$lambda$11(mutableState);
                                                    if (!NavHost$lambda$11) {
                                                        Iterator<NavDestination> it = NavDestination.INSTANCE.getHierarchy(destination2).iterator();
                                                        while (true) {
                                                            if (!it.hasNext()) {
                                                                break;
                                                            }
                                                            createEnterTransition = NavHostKt.createEnterTransition(it.next(), animatedContentTransitionScope);
                                                            if (createEnterTransition != null) {
                                                                enterTransition = createEnterTransition;
                                                                break;
                                                            }
                                                        }
                                                        return enterTransition == null ? function18.invoke(animatedContentTransitionScope) : enterTransition;
                                                    }
                                                }
                                                Iterator<NavDestination> it2 = NavDestination.INSTANCE.getHierarchy(destination2).iterator();
                                                while (true) {
                                                    if (!it2.hasNext()) {
                                                        break;
                                                    }
                                                    createPopEnterTransition = NavHostKt.createPopEnterTransition(it2.next(), animatedContentTransitionScope);
                                                    if (createPopEnterTransition != null) {
                                                        enterTransition = createPopEnterTransition;
                                                        break;
                                                    }
                                                }
                                                return enterTransition == null ? function114.invoke(animatedContentTransitionScope) : enterTransition;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue7);
                                    }
                                    final Function1 function130 = (Function1) rememberedValue7;
                                    function117 = function114;
                                    boolean changed3 = startRestartGroup.changed(composeNavigator) | ((((29360128 & i7) ^ 12582912) > 8388608 && startRestartGroup.changed(function113)) || (i7 & 12582912) == 8388608) | ((458752 & i7) == 131072);
                                    Object rememberedValue8 = startRestartGroup.rememberedValue();
                                    if (changed3 || rememberedValue8 == companion.getEmpty()) {
                                        rememberedValue8 = new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$finalExit$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final ExitTransition invoke(AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
                                                ExitTransition createPopExitTransition;
                                                boolean NavHost$lambda$11;
                                                ExitTransition createExitTransition;
                                                NavDestination destination = animatedContentTransitionScope.getInitialState().getDestination();
                                                Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
                                                ComposeNavigator.Destination destination2 = (ComposeNavigator.Destination) destination;
                                                ExitTransition exitTransition = null;
                                                if (!ComposeNavigator.this.isPop$navigation_compose_release().getValue().booleanValue()) {
                                                    NavHost$lambda$11 = NavHostKt.NavHost$lambda$11(mutableState);
                                                    if (!NavHost$lambda$11) {
                                                        Iterator<NavDestination> it = NavDestination.INSTANCE.getHierarchy(destination2).iterator();
                                                        while (true) {
                                                            if (!it.hasNext()) {
                                                                break;
                                                            }
                                                            createExitTransition = NavHostKt.createExitTransition(it.next(), animatedContentTransitionScope);
                                                            if (createExitTransition != null) {
                                                                exitTransition = createExitTransition;
                                                                break;
                                                            }
                                                        }
                                                        return exitTransition == null ? function19.invoke(animatedContentTransitionScope) : exitTransition;
                                                    }
                                                }
                                                Iterator<NavDestination> it2 = NavDestination.INSTANCE.getHierarchy(destination2).iterator();
                                                while (true) {
                                                    if (!it2.hasNext()) {
                                                        break;
                                                    }
                                                    createPopExitTransition = NavHostKt.createPopExitTransition(it2.next(), animatedContentTransitionScope);
                                                    if (createPopExitTransition != null) {
                                                        exitTransition = createPopExitTransition;
                                                        break;
                                                    }
                                                }
                                                return exitTransition == null ? function113.invoke(animatedContentTransitionScope) : exitTransition;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue8);
                                    }
                                    final Function1 function131 = (Function1) rememberedValue8;
                                    boolean z6 = (234881024 & i7) == 67108864;
                                    Object rememberedValue9 = startRestartGroup.rememberedValue();
                                    if (z6 || rememberedValue9 == companion.getEmpty()) {
                                        rememberedValue9 = new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$finalSizeTransform$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final SizeTransform invoke(AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
                                                SizeTransform sizeTransform;
                                                NavDestination destination = animatedContentTransitionScope.getTargetState().getDestination();
                                                Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
                                                Iterator<NavDestination> it = NavDestination.INSTANCE.getHierarchy((ComposeNavigator.Destination) destination).iterator();
                                                while (true) {
                                                    if (!it.hasNext()) {
                                                        sizeTransform = null;
                                                        break;
                                                    }
                                                    sizeTransform = NavHostKt.createSizeTransform(it.next(), animatedContentTransitionScope);
                                                    if (sizeTransform != null) {
                                                        break;
                                                    }
                                                }
                                                if (sizeTransform != null) {
                                                    return sizeTransform;
                                                }
                                                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function132 = function112;
                                                if (function132 != null) {
                                                    return function132.invoke(animatedContentTransitionScope);
                                                }
                                                return null;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue9);
                                    }
                                    final Function1 function132 = (Function1) rememberedValue9;
                                    Boolean bool = Boolean.TRUE;
                                    boolean changed4 = startRestartGroup.changed(composeNavigator);
                                    Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function133 = function112;
                                    Object rememberedValue10 = startRestartGroup.rememberedValue();
                                    if (changed4) {
                                        function124 = function113;
                                    } else {
                                        function124 = function113;
                                    }
                                    rememberedValue10 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$27$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                            final State<List<NavBackStackEntry>> state2 = state;
                                            final ComposeNavigator composeNavigator2 = composeNavigator;
                                            return new DisposableEffectResult() { // from class: androidx.navigation.compose.NavHostKt$NavHost$27$1$invoke$$inlined$onDispose$1
                                                @Override // androidx.compose.runtime.DisposableEffectResult
                                                public void dispose() {
                                                    List NavHost$lambda$17;
                                                    NavHost$lambda$17 = NavHostKt.NavHost$lambda$17(State.this);
                                                    Iterator it = NavHost$lambda$17.iterator();
                                                    while (it.hasNext()) {
                                                        composeNavigator2.onTransitionComplete((NavBackStackEntry) it.next());
                                                    }
                                                }
                                            };
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue10);
                                    EffectsKt.DisposableEffect(bool, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue10, startRestartGroup, 6);
                                    Object rememberedValue11 = startRestartGroup.rememberedValue();
                                    if (rememberedValue11 == companion.getEmpty()) {
                                        rememberedValue11 = new SeekableTransitionState(navBackStackEntry);
                                        startRestartGroup.updateRememberedValue(rememberedValue11);
                                    }
                                    final SeekableTransitionState seekableTransitionState = (SeekableTransitionState) rememberedValue11;
                                    function116 = function19;
                                    Transition rememberTransition = TransitionKt.rememberTransition(seekableTransitionState, "entry", startRestartGroup, SeekableTransitionState.$stable | 48, 0);
                                    if (NavHost$lambda$11(mutableState)) {
                                        startRestartGroup.startReplaceGroup(-1218260648);
                                        Float valueOf = Float.valueOf(mutableFloatState.getFloatValue());
                                        boolean changed5 = startRestartGroup.changed(collectAsState) | startRestartGroup.changedInstance(seekableTransitionState);
                                        function115 = function18;
                                        Object rememberedValue12 = startRestartGroup.rememberedValue();
                                        if (changed5 || rememberedValue12 == companion.getEmpty()) {
                                            rememberedValue12 = new NavHostKt$NavHost$28$1(seekableTransitionState, collectAsState, mutableFloatState, null);
                                            startRestartGroup.updateRememberedValue(rememberedValue12);
                                        }
                                        EffectsKt.LaunchedEffect(valueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue12, startRestartGroup, 0);
                                        startRestartGroup.endReplaceGroup();
                                        map = map2;
                                        dialogNavigator = null;
                                    } else {
                                        function115 = function18;
                                        startRestartGroup.startReplaceGroup(-1218005611);
                                        boolean changedInstance2 = startRestartGroup.changedInstance(seekableTransitionState) | startRestartGroup.changedInstance(navBackStackEntry) | startRestartGroup.changed(rememberTransition);
                                        Object rememberedValue13 = startRestartGroup.rememberedValue();
                                        if (changedInstance2 || rememberedValue13 == companion.getEmpty()) {
                                            dialogNavigator = null;
                                            rememberedValue13 = new NavHostKt$NavHost$29$1(seekableTransitionState, navBackStackEntry, rememberTransition, null);
                                            startRestartGroup.updateRememberedValue(rememberedValue13);
                                        } else {
                                            dialogNavigator = null;
                                        }
                                        EffectsKt.LaunchedEffect(navBackStackEntry, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue13, startRestartGroup, 0);
                                        startRestartGroup.endReplaceGroup();
                                        map = map2;
                                    }
                                    boolean changedInstance3 = startRestartGroup.changedInstance(map) | startRestartGroup.changed(composeNavigator) | startRestartGroup.changed(function130) | startRestartGroup.changed(function131) | startRestartGroup.changed(function132);
                                    Object rememberedValue14 = startRestartGroup.rememberedValue();
                                    if (changedInstance3 || rememberedValue14 == companion.getEmpty()) {
                                        final Map map3 = map;
                                        final ComposeNavigator composeNavigator2 = composeNavigator;
                                        rememberedValue14 = new Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ContentTransform>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$30$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final ContentTransform invoke(AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
                                                List NavHost$lambda$17;
                                                float f5;
                                                boolean NavHost$lambda$11;
                                                NavHost$lambda$17 = NavHostKt.NavHost$lambda$17(state);
                                                if (NavHost$lambda$17.contains(animatedContentTransitionScope.getInitialState())) {
                                                    Float f6 = map3.get(animatedContentTransitionScope.getInitialState().getId());
                                                    if (f6 != null) {
                                                        f5 = f6.floatValue();
                                                    } else {
                                                        map3.put(animatedContentTransitionScope.getInitialState().getId(), Float.valueOf(0.0f));
                                                        f5 = 0.0f;
                                                    }
                                                    if (!Intrinsics.areEqual(animatedContentTransitionScope.getTargetState().getId(), animatedContentTransitionScope.getInitialState().getId())) {
                                                        if (!composeNavigator2.isPop$navigation_compose_release().getValue().booleanValue()) {
                                                            NavHost$lambda$11 = NavHostKt.NavHost$lambda$11(mutableState);
                                                            if (!NavHost$lambda$11) {
                                                                f5 += 1.0f;
                                                            }
                                                        }
                                                        f5 -= 1.0f;
                                                    }
                                                    map3.put(animatedContentTransitionScope.getTargetState().getId(), Float.valueOf(f5));
                                                    return new ContentTransform(function130.invoke(animatedContentTransitionScope), function131.invoke(animatedContentTransitionScope), f5, function132.invoke(animatedContentTransitionScope));
                                                }
                                                return AnimatedContentKt.togetherWith(EnterTransition.INSTANCE.getNone(), ExitTransition.INSTANCE.getNone());
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue14);
                                    }
                                    ComposeNavigator composeNavigator3 = composeNavigator;
                                    function118 = function133;
                                    function119 = function124;
                                    AnimatedContentKt.AnimatedContent(rememberTransition, modifier6, (Function1) rememberedValue14, alignment3, new Function1<NavBackStackEntry, Object>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$31
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(NavBackStackEntry navBackStackEntry2) {
                                            return navBackStackEntry2.getId();
                                        }
                                    }, ComposableLambdaKt.rememberComposableLambda(820763100, true, new Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$32
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry2, Composer composer2, Integer num) {
                                            invoke(animatedContentScope, navBackStackEntry2, composer2, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX WARN: Multi-variable type inference failed */
                                        /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Object] */
                                        /* JADX WARN: Type inference failed for: r0v8 */
                                        /* JADX WARN: Type inference failed for: r0v9 */
                                        public final void invoke(final AnimatedContentScope animatedContentScope, final NavBackStackEntry navBackStackEntry2, Composer composer2, int i16) {
                                            boolean NavHost$lambda$11;
                                            List NavHost$lambda$17;
                                            NavBackStackEntry navBackStackEntry3;
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(820763100, i16, -1, "androidx.navigation.compose.NavHost.<anonymous> (NavHost.kt:689)");
                                            }
                                            boolean areEqual = Intrinsics.areEqual(seekableTransitionState.getCurrentState(), navBackStackEntry);
                                            NavHost$lambda$11 = NavHostKt.NavHost$lambda$11(mutableState);
                                            if (!NavHost$lambda$11 && !areEqual) {
                                                NavHost$lambda$17 = NavHostKt.NavHost$lambda$17(state);
                                                ListIterator listIterator = NavHost$lambda$17.listIterator(NavHost$lambda$17.size());
                                                while (true) {
                                                    if (!listIterator.hasPrevious()) {
                                                        navBackStackEntry3 = 0;
                                                        break;
                                                    } else {
                                                        navBackStackEntry3 = listIterator.previous();
                                                        if (Intrinsics.areEqual(navBackStackEntry2, (NavBackStackEntry) navBackStackEntry3)) {
                                                            break;
                                                        }
                                                    }
                                                }
                                                navBackStackEntry2 = navBackStackEntry3;
                                            }
                                            if (navBackStackEntry2 != null) {
                                                NavBackStackEntryProviderKt.LocalOwnersProvider(navBackStackEntry2, rememberSaveableStateHolder, ComposableLambdaKt.rememberComposableLambda(-1263531443, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$32.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                        invoke(composer3, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer3, int i17) {
                                                        if ((i17 & 3) == 2 && composer3.getSkipping()) {
                                                            composer3.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1263531443, i17, -1, "androidx.navigation.compose.NavHost.<anonymous>.<anonymous> (NavHost.kt:703)");
                                                        }
                                                        NavDestination destination = NavBackStackEntry.this.getDestination();
                                                        Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
                                                        ((ComposeNavigator.Destination) destination).getContent$navigation_compose_release().invoke(animatedContentScope, NavBackStackEntry.this, composer3, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }, composer2, 54), composer2, 384);
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, startRestartGroup, 54), startRestartGroup, ((i7 >> 3) & 112) | 221184 | (i7 & 7168), 0);
                                    Object currentState = rememberTransition.getCurrentState();
                                    Object targetState = rememberTransition.getTargetState();
                                    boolean changed6 = startRestartGroup.changed(rememberTransition) | startRestartGroup.changedInstance(navHostController) | startRestartGroup.changed(composeNavigator3) | startRestartGroup.changedInstance(map);
                                    Object rememberedValue15 = startRestartGroup.rememberedValue();
                                    if (changed6 || rememberedValue15 == companion.getEmpty()) {
                                        rememberedValue15 = new NavHostKt$NavHost$33$1(rememberTransition, navHostController, map, state, composeNavigator3, null);
                                        startRestartGroup.updateRememberedValue(rememberedValue15);
                                    }
                                    EffectsKt.LaunchedEffect(currentState, targetState, (Function2) rememberedValue15, startRestartGroup, 0);
                                } else {
                                    function115 = function18;
                                    function116 = function19;
                                    function117 = function114;
                                    function118 = function112;
                                    function119 = function113;
                                    dialogNavigator = null;
                                }
                                startRestartGroup.endReplaceGroup();
                                Navigator navigator2 = navHostController.get_navigatorProvider().getNavigator("dialog");
                                DialogNavigator dialogNavigator2 = navigator2 instanceof DialogNavigator ? (DialogNavigator) navigator2 : dialogNavigator;
                                if (dialogNavigator2 == null) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
                                    if (endRestartGroup2 != null) {
                                        final Alignment alignment6 = alignment3;
                                        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function134 = function115;
                                        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function135 = function116;
                                        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function136 = function117;
                                        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function137 = function119;
                                        endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$dialogNavigator$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                                invoke(composer2, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer2, int i16) {
                                                NavHostKt.NavHost(NavHostController.this, navGraph, modifier6, alignment6, function134, function135, function136, function137, function118, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                DialogHostKt.DialogHost(dialogNavigator2, startRestartGroup, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function120 = function117;
                                function121 = function119;
                                alignment4 = alignment3;
                                modifier4 = modifier6;
                                function122 = function116;
                                function123 = function115;
                            } else {
                                throw new IllegalStateException("NavHost requires a ViewModelStoreOwner to be provided via LocalViewModelStoreOwner");
                            }
                        }
                        ScopeUpdateScope endRestartGroup3 = startRestartGroup.endRestartGroup();
                        if (endRestartGroup3 != null) {
                            endRestartGroup3.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$34
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i16) {
                                    NavHostKt.NavHost(NavHostController.this, navGraph, modifier4, alignment4, function123, function122, function120, function121, function118, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    function16 = function1;
                    i11 = i6 & 32;
                    if (i11 != 0) {
                    }
                    if ((i5 & 1572864) == 0) {
                    }
                    if ((i5 & 12582912) == 0) {
                    }
                    i12 = i6 & 256;
                    if (i12 != 0) {
                    }
                    if ((i7 & 38347923) != 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i5 & 1) == 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if ((i6 & 64) != 0) {
                    }
                    if ((i6 & 128) != 0) {
                    }
                    if (i12 != 0) {
                    }
                    function113 = function111;
                    function114 = function110;
                    i7 = i14;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final LifecycleOwner lifecycleOwner2 = (LifecycleOwner) startRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
                    current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, LocalViewModelStoreOwner.$stable);
                    if (current != null) {
                    }
                }
                alignment2 = alignment;
                i10 = i6 & 16;
                if (i10 == 0) {
                }
                function16 = function1;
                i11 = i6 & 32;
                if (i11 != 0) {
                }
                if ((i5 & 1572864) == 0) {
                }
                if ((i5 & 12582912) == 0) {
                }
                i12 = i6 & 256;
                if (i12 != 0) {
                }
                if ((i7 & 38347923) != 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i5 & 1) == 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if ((i6 & 64) != 0) {
                }
                if ((i6 & 128) != 0) {
                }
                if (i12 != 0) {
                }
                function113 = function111;
                function114 = function110;
                i7 = i14;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final LifecycleOwner lifecycleOwner22 = (LifecycleOwner) startRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
                current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, LocalViewModelStoreOwner.$stable);
                if (current != null) {
                }
            }
            modifier2 = modifier;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            alignment2 = alignment;
            i10 = i6 & 16;
            if (i10 == 0) {
            }
            function16 = function1;
            i11 = i6 & 32;
            if (i11 != 0) {
            }
            if ((i5 & 1572864) == 0) {
            }
            if ((i5 & 12582912) == 0) {
            }
            i12 = i6 & 256;
            if (i12 != 0) {
            }
            if ((i7 & 38347923) != 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) == 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if ((i6 & 64) != 0) {
            }
            if ((i6 & 128) != 0) {
            }
            if (i12 != 0) {
            }
            function113 = function111;
            function114 = function110;
            i7 = i14;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final LifecycleOwner lifecycleOwner222 = (LifecycleOwner) startRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
            current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, LocalViewModelStoreOwner.$stable);
            if (current != null) {
            }
        }
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        modifier2 = modifier;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        alignment2 = alignment;
        i10 = i6 & 16;
        if (i10 == 0) {
        }
        function16 = function1;
        i11 = i6 & 32;
        if (i11 != 0) {
        }
        if ((i5 & 1572864) == 0) {
        }
        if ((i5 & 12582912) == 0) {
        }
        i12 = i6 & 256;
        if (i12 != 0) {
        }
        if ((i7 & 38347923) != 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) == 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if ((i6 & 64) != 0) {
        }
        if ((i6 & 128) != 0) {
        }
        if (i12 != 0) {
        }
        function113 = function111;
        function114 = function110;
        i7 = i14;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final LifecycleOwner lifecycleOwner2222 = (LifecycleOwner) startRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
        current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, LocalViewModelStoreOwner.$stable);
        if (current != null) {
        }
    }
}
