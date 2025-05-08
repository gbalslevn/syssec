package com.ramcosta.composedestinations;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import com.ramcosta.composedestinations.DestinationsNavHostKt;
import com.ramcosta.composedestinations.animations.NavHostAnimatedDestinationStyle;
import com.ramcosta.composedestinations.manualcomposablecalls.ManualComposableCalls;
import com.ramcosta.composedestinations.manualcomposablecalls.ManualComposableCallsBuilder;
import com.ramcosta.composedestinations.navigation.DependenciesContainerBuilder;
import com.ramcosta.composedestinations.spec.Direction;
import com.ramcosta.composedestinations.spec.NavHostEngine;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import com.ramcosta.composedestinations.spec.TypedNavGraphSpec;
import com.ramcosta.composedestinations.spec.TypedNavHostGraphSpec;
import com.ramcosta.composedestinations.utils.NavGraphRegistry;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\u001a\u0081\u0001\u0010\u0013\u001a\u00020\u000f2\u000e\u0010\u0002\u001a\n\u0012\u0002\b\u00030\u0000j\u0002`\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000f0\rH\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a'\u0010\u0015\u001a\u00020\u000f2\u000e\u0010\u0002\u001a\n\u0012\u0002\b\u00030\u0000j\u0002`\u00012\u0006\u0010\f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\u0015\u0010\u0016\u001aW\u0010\u001c\u001a\u00020\u000f*\u00020\u00172\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u0002\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0018j\u0002`\u00192\u0006\u0010\f\u001a\u00020\u000b2\u0016\u0010\u0010\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a]\u0010 \u001a\u00020\u000f*\u00020\u00172\u0006\u0010\n\u001a\u00020\t2\u0018\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0018j\u0002`\u00190\u001e2\u0006\u0010\f\u001a\u00020\u000b2\u0016\u0010\u0010\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/ramcosta/composedestinations/spec/TypedNavHostGraphSpec;", "Lcom/ramcosta/composedestinations/spec/NavHostGraphSpec;", "navGraph", "Landroidx/compose/ui/Modifier;", "modifier", "Lcom/ramcosta/composedestinations/spec/Direction;", "start", "Lcom/ramcosta/composedestinations/animations/NavHostAnimatedDestinationStyle;", "defaultTransitions", "Lcom/ramcosta/composedestinations/spec/NavHostEngine;", "engine", "Landroidx/navigation/NavHostController;", "navController", "Lkotlin/Function1;", "Lcom/ramcosta/composedestinations/navigation/DependenciesContainerBuilder;", BuildConfig.FLAVOR, "dependenciesContainerBuilder", "Lcom/ramcosta/composedestinations/manualcomposablecalls/ManualComposableCallsBuilder;", "manualComposableCallsBuilder", "DestinationsNavHost", "(Lcom/ramcosta/composedestinations/spec/TypedNavHostGraphSpec;Landroidx/compose/ui/Modifier;Lcom/ramcosta/composedestinations/spec/Direction;Lcom/ramcosta/composedestinations/animations/NavHostAnimatedDestinationStyle;Lcom/ramcosta/composedestinations/spec/NavHostEngine;Landroidx/navigation/NavHostController;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "HandleNavGraphRegistry", "(Lcom/ramcosta/composedestinations/spec/TypedNavHostGraphSpec;Landroidx/navigation/NavHostController;Landroidx/compose/runtime/Composer;I)V", "Landroidx/navigation/NavGraphBuilder;", "Lcom/ramcosta/composedestinations/spec/TypedNavGraphSpec;", "Lcom/ramcosta/composedestinations/spec/NavGraphSpec;", "Lcom/ramcosta/composedestinations/manualcomposablecalls/ManualComposableCalls;", "manualComposableCalls", "addNavGraphDestinations", "(Landroidx/navigation/NavGraphBuilder;Lcom/ramcosta/composedestinations/spec/NavHostEngine;Lcom/ramcosta/composedestinations/spec/TypedNavGraphSpec;Landroidx/navigation/NavHostController;Lkotlin/jvm/functions/Function3;Lcom/ramcosta/composedestinations/manualcomposablecalls/ManualComposableCalls;)V", BuildConfig.FLAVOR, "nestedNavGraphs", "addNestedNavGraphs", "(Landroidx/navigation/NavGraphBuilder;Lcom/ramcosta/composedestinations/spec/NavHostEngine;Ljava/util/List;Landroidx/navigation/NavHostController;Lkotlin/jvm/functions/Function3;Lcom/ramcosta/composedestinations/manualcomposablecalls/ManualComposableCalls;)V", "compose-destinations_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DestinationsNavHostKt {
    /* JADX WARN: Removed duplicated region for block: B:102:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0223  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DestinationsNavHost(final TypedNavHostGraphSpec<?> navGraph, Modifier modifier, Direction direction, NavHostAnimatedDestinationStyle navHostAnimatedDestinationStyle, NavHostEngine navHostEngine, NavHostController navHostController, Function3<? super DependenciesContainerBuilder<?>, ? super Composer, ? super Integer, Unit> function3, Function1<? super ManualComposableCallsBuilder, Unit> function1, Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        NavHostAnimatedDestinationStyle navHostAnimatedDestinationStyle2;
        NavHostController navHostController2;
        int i8;
        Function3<? super DependenciesContainerBuilder<?>, ? super Composer, ? super Integer, Unit> function32;
        int i9;
        Function1<? super ManualComposableCallsBuilder, Unit> function12;
        Direction direction2;
        NavHostAnimatedDestinationStyle navHostAnimatedDestinationStyle3;
        int i10;
        NavHostController navHostController3;
        Function1<? super ManualComposableCallsBuilder, Unit> function13;
        int i11;
        int i12;
        boolean z5;
        boolean changedInstance;
        Object rememberedValue;
        final NavHostEngine navHostEngine2;
        final Modifier modifier3;
        final Function1<? super ManualComposableCallsBuilder, Unit> function14;
        final NavHostController navHostController4;
        final Direction direction3;
        ScopeUpdateScope endRestartGroup;
        int i13;
        int i14;
        int i15;
        int i16;
        NavHostEngine navHostEngine3 = navHostEngine;
        Intrinsics.checkNotNullParameter(navGraph, "navGraph");
        Composer startRestartGroup = composer.startRestartGroup(605005710);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = ((i5 & 8) == 0 ? startRestartGroup.changed(navGraph) : startRestartGroup.changedInstance(navGraph) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i17 = i6 & 2;
        if (i17 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i5 & 384) == 0) {
                if ((i6 & 4) == 0) {
                    if ((i5 & 512) == 0 ? startRestartGroup.changed(direction) : startRestartGroup.changedInstance(direction)) {
                        i16 = 256;
                        i7 |= i16;
                    }
                }
                i16 = 128;
                i7 |= i16;
            }
            if ((i5 & 3072) != 0) {
                if ((i6 & 8) == 0) {
                    navHostAnimatedDestinationStyle2 = navHostAnimatedDestinationStyle;
                    if (startRestartGroup.changed(navHostAnimatedDestinationStyle2)) {
                        i15 = 2048;
                        i7 |= i15;
                    }
                } else {
                    navHostAnimatedDestinationStyle2 = navHostAnimatedDestinationStyle;
                }
                i15 = 1024;
                i7 |= i15;
            } else {
                navHostAnimatedDestinationStyle2 = navHostAnimatedDestinationStyle;
            }
            if ((i5 & 24576) == 0) {
                if ((i6 & 16) == 0) {
                    if ((32768 & i5) == 0 ? startRestartGroup.changed(navHostEngine3) : startRestartGroup.changedInstance(navHostEngine3)) {
                        i14 = 16384;
                        i7 |= i14;
                    }
                }
                i14 = 8192;
                i7 |= i14;
            }
            if ((196608 & i5) != 0) {
                if ((i6 & 32) == 0) {
                    navHostController2 = navHostController;
                    if (startRestartGroup.changedInstance(navHostController2)) {
                        i13 = 131072;
                        i7 |= i13;
                    }
                } else {
                    navHostController2 = navHostController;
                }
                i13 = 65536;
                i7 |= i13;
            } else {
                navHostController2 = navHostController;
            }
            i8 = i6 & 64;
            if (i8 == 0) {
                i7 |= 1572864;
                function32 = function3;
            } else {
                function32 = function3;
                if ((i5 & 1572864) == 0) {
                    i7 |= startRestartGroup.changedInstance(function32) ? 1048576 : 524288;
                }
            }
            i9 = i6 & 128;
            if (i9 == 0) {
                i7 |= 12582912;
                function12 = function1;
            } else {
                function12 = function1;
                if ((i5 & 12582912) == 0) {
                    i7 |= startRestartGroup.changedInstance(function12) ? 8388608 : 4194304;
                }
            }
            if ((i7 & 4793491) == 4793490 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    if (i17 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i6 & 4) == 0) {
                        direction2 = navGraph.getDefaultStartDirection();
                        i7 &= -897;
                    } else {
                        direction2 = direction;
                    }
                    if ((i6 & 8) == 0) {
                        navHostAnimatedDestinationStyle3 = navGraph.getDefaultTransitions();
                        i7 &= -7169;
                    } else {
                        navHostAnimatedDestinationStyle3 = navHostAnimatedDestinationStyle2;
                    }
                    if ((i6 & 16) == 0) {
                        i10 = 0;
                        navHostEngine3 = DefaultNavHostEngineKt.rememberNavHostEngine(null, startRestartGroup, 0, 1);
                        i7 &= -57345;
                    } else {
                        i10 = 0;
                    }
                    if ((i6 & 32) != 0) {
                        NavHostController rememberNavController = navHostEngine3.rememberNavController(new Navigator[i10], startRestartGroup, (i7 >> 9) & 112);
                        i7 &= -458753;
                        navHostController2 = rememberNavController;
                    }
                    if (i8 != 0) {
                        function32 = ComposableSingletons$DestinationsNavHostKt.INSTANCE.m3032getLambda1$compose_destinations_release();
                    }
                    if (i9 == 0) {
                        startRestartGroup.startReplaceGroup(-1354590362);
                        Object rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = new Function1() { // from class: d1.a
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    Unit DestinationsNavHost$lambda$1$lambda$0;
                                    DestinationsNavHost$lambda$1$lambda$0 = DestinationsNavHostKt.DestinationsNavHost$lambda$1$lambda$0((ManualComposableCallsBuilder) obj);
                                    return DestinationsNavHost$lambda$1$lambda$0;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        startRestartGroup.endReplaceGroup();
                        function13 = (Function1) rememberedValue2;
                        navHostController3 = navHostController2;
                    } else {
                        navHostController3 = navHostController2;
                        function13 = function12;
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i6 & 4) != 0) {
                        i7 &= -897;
                    }
                    if ((i6 & 8) != 0) {
                        i7 &= -7169;
                    }
                    if ((i6 & 16) != 0) {
                        i7 &= -57345;
                    }
                    if ((i6 & 32) != 0) {
                        i7 &= -458753;
                    }
                    direction2 = direction;
                    navHostAnimatedDestinationStyle3 = navHostAnimatedDestinationStyle2;
                    navHostController3 = navHostController2;
                    function13 = function12;
                }
                i11 = i7;
                final Function3<? super DependenciesContainerBuilder<?>, ? super Composer, ? super Integer, Unit> function33 = function32;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(605005710, i11, -1, "com.ramcosta.composedestinations.DestinationsNavHost (DestinationsNavHost.kt:72)");
                }
                int i18 = i11 & 14;
                HandleNavGraphRegistry(navGraph, navHostController3, startRestartGroup, ((i11 >> 12) & 112) | i18);
                String route = navGraph.getRoute();
                startRestartGroup.startReplaceGroup(-1354581718);
                if ((((57344 & i11) ^ 24576) > 16384 || !startRestartGroup.changedInstance(navHostEngine3)) && (i11 & 24576) != 16384) {
                    i12 = 4;
                    z5 = false;
                } else {
                    i12 = 4;
                    z5 = true;
                }
                changedInstance = (i18 != i12 || ((i11 & 8) != 0 && startRestartGroup.changedInstance(navGraph))) | z5 | startRestartGroup.changedInstance(navHostController3) | ((3670016 & i11) != 1048576) | ((29360128 & i11) != 8388608);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    final NavHostEngine navHostEngine4 = navHostEngine3;
                    final NavHostController navHostController5 = navHostController3;
                    final Function1<? super ManualComposableCallsBuilder, Unit> function15 = function13;
                    rememberedValue = new Function1() { // from class: d1.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit DestinationsNavHost$lambda$4$lambda$3;
                            DestinationsNavHost$lambda$4$lambda$3 = DestinationsNavHostKt.DestinationsNavHost$lambda$4$lambda$3(NavHostEngine.this, navGraph, navHostController5, function33, function15, (NavGraphBuilder) obj);
                            return DestinationsNavHost$lambda$4$lambda$3;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                int i19 = i11 >> 3;
                navHostEngine3.NavHost(modifier2, route, direction2, navHostAnimatedDestinationStyle3, navHostController3, (Function1) rememberedValue, startRestartGroup, (i19 & 57344) | (i19 & 14) | (i11 & 896) | (i11 & 7168) | ((i11 << 6) & 3670016));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function32 = function33;
                navHostEngine2 = navHostEngine3;
                modifier3 = modifier2;
                function14 = function13;
                navHostController4 = navHostController3;
                direction3 = direction2;
            } else {
                startRestartGroup.skipToGroupEnd();
                direction3 = direction;
                navHostEngine2 = navHostEngine3;
                modifier3 = modifier2;
                navHostAnimatedDestinationStyle3 = navHostAnimatedDestinationStyle2;
                navHostController4 = navHostController2;
                function14 = function12;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final NavHostAnimatedDestinationStyle navHostAnimatedDestinationStyle4 = navHostAnimatedDestinationStyle3;
                final Function3<? super DependenciesContainerBuilder<?>, ? super Composer, ? super Integer, Unit> function34 = function32;
                endRestartGroup.updateScope(new Function2() { // from class: d1.c
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit DestinationsNavHost$lambda$5;
                        DestinationsNavHost$lambda$5 = DestinationsNavHostKt.DestinationsNavHost$lambda$5(TypedNavHostGraphSpec.this, modifier3, direction3, navHostAnimatedDestinationStyle4, navHostEngine2, navHostController4, function34, function14, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                        return DestinationsNavHost$lambda$5;
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i5 & 384) == 0) {
        }
        if ((i5 & 3072) != 0) {
        }
        if ((i5 & 24576) == 0) {
        }
        if ((196608 & i5) != 0) {
        }
        i8 = i6 & 64;
        if (i8 == 0) {
        }
        i9 = i6 & 128;
        if (i9 == 0) {
        }
        if ((i7 & 4793491) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i17 != 0) {
        }
        if ((i6 & 4) == 0) {
        }
        if ((i6 & 8) == 0) {
        }
        if ((i6 & 16) == 0) {
        }
        if ((i6 & 32) != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 == 0) {
        }
        i11 = i7;
        final Function3 function332 = function32;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i182 = i11 & 14;
        HandleNavGraphRegistry(navGraph, navHostController3, startRestartGroup, ((i11 >> 12) & 112) | i182);
        String route2 = navGraph.getRoute();
        startRestartGroup.startReplaceGroup(-1354581718);
        if (((57344 & i11) ^ 24576) > 16384) {
        }
        i12 = 4;
        z5 = false;
        changedInstance = (i182 != i12 || ((i11 & 8) != 0 && startRestartGroup.changedInstance(navGraph))) | z5 | startRestartGroup.changedInstance(navHostController3) | ((3670016 & i11) != 1048576) | ((29360128 & i11) != 8388608);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        final NavHostEngine navHostEngine42 = navHostEngine3;
        final NavHostController navHostController52 = navHostController3;
        final Function1 function152 = function13;
        rememberedValue = new Function1() { // from class: d1.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit DestinationsNavHost$lambda$4$lambda$3;
                DestinationsNavHost$lambda$4$lambda$3 = DestinationsNavHostKt.DestinationsNavHost$lambda$4$lambda$3(NavHostEngine.this, navGraph, navHostController52, function332, function152, (NavGraphBuilder) obj);
                return DestinationsNavHost$lambda$4$lambda$3;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceGroup();
        int i192 = i11 >> 3;
        navHostEngine3.NavHost(modifier2, route2, direction2, navHostAnimatedDestinationStyle3, navHostController3, (Function1) rememberedValue, startRestartGroup, (i192 & 57344) | (i192 & 14) | (i11 & 896) | (i11 & 7168) | ((i11 << 6) & 3670016));
        if (ComposerKt.isTraceInProgress()) {
        }
        function32 = function332;
        navHostEngine2 = navHostEngine3;
        modifier3 = modifier2;
        function14 = function13;
        navHostController4 = navHostController3;
        direction3 = direction2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DestinationsNavHost$lambda$1$lambda$0(ManualComposableCallsBuilder manualComposableCallsBuilder) {
        Intrinsics.checkNotNullParameter(manualComposableCallsBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DestinationsNavHost$lambda$4$lambda$3(NavHostEngine navHostEngine, TypedNavHostGraphSpec typedNavHostGraphSpec, NavHostController navHostController, Function3 function3, Function1 function1, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        ManualComposableCallsBuilder manualComposableCallsBuilder = new ManualComposableCallsBuilder(navHostEngine.getType());
        function1.invoke(manualComposableCallsBuilder);
        Unit unit = Unit.INSTANCE;
        addNavGraphDestinations(NavHost, navHostEngine, typedNavHostGraphSpec, navHostController, function3, manualComposableCallsBuilder.build$compose_destinations_release());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DestinationsNavHost$lambda$5(TypedNavHostGraphSpec typedNavHostGraphSpec, Modifier modifier, Direction direction, NavHostAnimatedDestinationStyle navHostAnimatedDestinationStyle, NavHostEngine navHostEngine, NavHostController navHostController, Function3 function3, Function1 function1, int i5, int i6, Composer composer, int i7) {
        DestinationsNavHost(typedNavHostGraphSpec, modifier, direction, navHostAnimatedDestinationStyle, navHostEngine, navHostController, function3, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    private static final void HandleNavGraphRegistry(final TypedNavHostGraphSpec<?> typedNavHostGraphSpec, final NavHostController navHostController, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-1682816389);
        if ((i5 & 6) == 0) {
            i6 = ((i5 & 8) == 0 ? startRestartGroup.changed(typedNavHostGraphSpec) : startRestartGroup.changedInstance(typedNavHostGraphSpec) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(navHostController) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1682816389, i6, -1, "com.ramcosta.composedestinations.HandleNavGraphRegistry (DestinationsNavHost.kt:100)");
            }
            NavGraphRegistry.INSTANCE.addGraph(navHostController, typedNavHostGraphSpec);
            startRestartGroup.startReplaceGroup(-291370672);
            boolean changedInstance = startRestartGroup.changedInstance(navHostController);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: d1.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DisposableEffectResult HandleNavGraphRegistry$lambda$8$lambda$7;
                        HandleNavGraphRegistry$lambda$8$lambda$7 = DestinationsNavHostKt.HandleNavGraphRegistry$lambda$8$lambda$7(NavHostController.this, (DisposableEffectScope) obj);
                        return HandleNavGraphRegistry$lambda$8$lambda$7;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.DisposableEffect(navHostController, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue, startRestartGroup, (i6 >> 3) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: d1.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit HandleNavGraphRegistry$lambda$9;
                    HandleNavGraphRegistry$lambda$9 = DestinationsNavHostKt.HandleNavGraphRegistry$lambda$9(TypedNavHostGraphSpec.this, navHostController, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return HandleNavGraphRegistry$lambda$9;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult HandleNavGraphRegistry$lambda$8$lambda$7(final NavHostController navHostController, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: com.ramcosta.composedestinations.DestinationsNavHostKt$HandleNavGraphRegistry$lambda$8$lambda$7$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                NavGraphRegistry.INSTANCE.removeGraph(NavHostController.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HandleNavGraphRegistry$lambda$9(TypedNavHostGraphSpec typedNavHostGraphSpec, NavHostController navHostController, int i5, Composer composer, int i6) {
        HandleNavGraphRegistry(typedNavHostGraphSpec, navHostController, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void addNavGraphDestinations(NavGraphBuilder navGraphBuilder, NavHostEngine navHostEngine, TypedNavGraphSpec<?, ?> typedNavGraphSpec, NavHostController navHostController, Function3<? super DependenciesContainerBuilder<?>, ? super Composer, ? super Integer, Unit> function3, ManualComposableCalls manualComposableCalls) {
        Iterator<T> it = typedNavGraphSpec.getDestinations().iterator();
        while (it.hasNext()) {
            navHostEngine.composable(navGraphBuilder, (TypedDestinationSpec) it.next(), navHostController, function3, manualComposableCalls);
        }
        addNestedNavGraphs(navGraphBuilder, navHostEngine, typedNavGraphSpec.getNestedNavGraphs(), navHostController, function3, manualComposableCalls);
    }

    private static final void addNestedNavGraphs(NavGraphBuilder navGraphBuilder, final NavHostEngine navHostEngine, List<? extends TypedNavGraphSpec<?, ?>> list, final NavHostController navHostController, final Function3<? super DependenciesContainerBuilder<?>, ? super Composer, ? super Integer, Unit> function3, final ManualComposableCalls manualComposableCalls) {
        for (final TypedNavGraphSpec<?, ?> typedNavGraphSpec : list) {
            navHostEngine.navigation(navGraphBuilder, typedNavGraphSpec, manualComposableCalls, new Function1() { // from class: d1.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit addNestedNavGraphs$lambda$14$lambda$13$lambda$12;
                    addNestedNavGraphs$lambda$14$lambda$13$lambda$12 = DestinationsNavHostKt.addNestedNavGraphs$lambda$14$lambda$13$lambda$12(NavHostEngine.this, typedNavGraphSpec, navHostController, function3, manualComposableCalls, (NavGraphBuilder) obj);
                    return addNestedNavGraphs$lambda$14$lambda$13$lambda$12;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addNestedNavGraphs$lambda$14$lambda$13$lambda$12(NavHostEngine navHostEngine, TypedNavGraphSpec typedNavGraphSpec, NavHostController navHostController, Function3 function3, ManualComposableCalls manualComposableCalls, NavGraphBuilder navigation) {
        Intrinsics.checkNotNullParameter(navigation, "$this$navigation");
        addNavGraphDestinations(navigation, navHostEngine, typedNavGraphSpec, navHostController, function3, manualComposableCalls);
        return Unit.INSTANCE;
    }
}
