package dk.molslinjen.ui.views.reusable;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a_\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00042\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/unit/Dp;", "animationSize", BuildConfig.FLAVOR, "isLoading", BuildConfig.FLAVOR, "loadingResource", "hasError", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onRetry", "content", "LoadingComponent-jfnsLPA", "(Landroidx/compose/ui/Modifier;FZIZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "LoadingComponent", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class LoadingComponentKt {
    /* JADX WARN: Removed duplicated region for block: B:102:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00ae  */
    /* renamed from: LoadingComponent-jfnsLPA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3392LoadingComponentjfnsLPA(Modifier modifier, float f5, final boolean z5, int i5, boolean z6, Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i6, final int i7) {
        Modifier modifier2;
        int i8;
        float f6;
        int i9;
        int i10;
        int i11;
        boolean z7;
        int i12;
        final Function0<Unit> function02;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(1554293564);
        int i13 = i7 & 1;
        if (i13 != 0) {
            i8 = i6 | 6;
            modifier2 = modifier;
        } else if ((i6 & 6) == 0) {
            modifier2 = modifier;
            i8 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i6;
        } else {
            modifier2 = modifier;
            i8 = i6;
        }
        int i14 = i7 & 2;
        if (i14 != 0) {
            i8 |= 48;
        } else if ((i6 & 48) == 0) {
            f6 = f5;
            i8 |= startRestartGroup.changed(f6) ? 32 : 16;
            if ((i7 & 4) == 0) {
                i8 |= 384;
            } else if ((i6 & 384) == 0) {
                i8 |= startRestartGroup.changed(z5) ? 256 : 128;
            }
            i9 = i7 & 8;
            if (i9 == 0) {
                i8 |= 3072;
            } else if ((i6 & 3072) == 0) {
                i10 = i5;
                i8 |= startRestartGroup.changed(i10) ? 2048 : 1024;
                i11 = i7 & 16;
                if (i11 != 0) {
                    i8 |= 24576;
                } else if ((i6 & 24576) == 0) {
                    z7 = z6;
                    i8 |= startRestartGroup.changed(z7) ? 16384 : 8192;
                    i12 = i7 & 32;
                    if (i12 == 0) {
                        i8 |= 196608;
                    } else if ((i6 & 196608) == 0) {
                        i8 |= startRestartGroup.changedInstance(function0) ? 131072 : 65536;
                    }
                    if ((i7 & 64) == 0) {
                        i8 |= 1572864;
                    } else if ((i6 & 1572864) == 0) {
                        i8 |= startRestartGroup.changedInstance(content) ? 1048576 : 524288;
                    }
                    if ((i8 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i14 != 0) {
                            f6 = Dp.m2599constructorimpl(64);
                        }
                        if (i9 != 0) {
                            i10 = R.raw.animation_lottie_loading_throbber;
                        }
                        if (i11 != 0) {
                            z7 = false;
                        }
                        Function0<Unit> function03 = i12 == 0 ? null : function0;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1554293564, i8, -1, "dk.molslinjen.ui.views.reusable.LoadingComponent (LoadingComponent.kt:26)");
                        }
                        if (!z5) {
                            startRestartGroup.startReplaceGroup(-1577280613);
                            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null);
                            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default);
                            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion.getConstructor();
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
                            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            LoadingViewKt.m3393LoadingVieworJrPs(f6, i10, startRestartGroup, ((i8 >> 3) & 14) | ((i8 >> 6) & 112), 0);
                            startRestartGroup.endNode();
                            startRestartGroup.endReplaceGroup();
                        } else if (z7) {
                            startRestartGroup.startReplaceGroup(-1577069472);
                            Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null);
                            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default2);
                            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
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
                            Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion2.getSetModifier());
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            ErrorRetryComponentKt.ErrorRetryComponent(function03, startRestartGroup, (i8 >> 15) & 14, 0);
                            startRestartGroup.endNode();
                            startRestartGroup.endReplaceGroup();
                        } else {
                            startRestartGroup.startReplaceGroup(-1576882077);
                            content.invoke(startRestartGroup, Integer.valueOf((i8 >> 18) & 14));
                            startRestartGroup.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function02 = function03;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        function02 = function0;
                    }
                    final boolean z8 = z7;
                    final Modifier modifier3 = modifier2;
                    final float f7 = f6;
                    final int i15 = i10;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: W1.z
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit LoadingComponent_jfnsLPA$lambda$2;
                                LoadingComponent_jfnsLPA$lambda$2 = LoadingComponentKt.LoadingComponent_jfnsLPA$lambda$2(Modifier.this, f7, z5, i15, z8, function02, content, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                                return LoadingComponent_jfnsLPA$lambda$2;
                            }
                        });
                        return;
                    }
                    return;
                }
                z7 = z6;
                i12 = i7 & 32;
                if (i12 == 0) {
                }
                if ((i7 & 64) == 0) {
                }
                if ((i8 & 599187) == 599186) {
                }
                if (i13 != 0) {
                }
                if (i14 != 0) {
                }
                if (i9 != 0) {
                }
                if (i11 != 0) {
                }
                if (i12 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                if (!z5) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                function02 = function03;
                final boolean z82 = z7;
                final Modifier modifier32 = modifier2;
                final float f72 = f6;
                final int i152 = i10;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i10 = i5;
            i11 = i7 & 16;
            if (i11 != 0) {
            }
            z7 = z6;
            i12 = i7 & 32;
            if (i12 == 0) {
            }
            if ((i7 & 64) == 0) {
            }
            if ((i8 & 599187) == 599186) {
            }
            if (i13 != 0) {
            }
            if (i14 != 0) {
            }
            if (i9 != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            if (!z5) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            function02 = function03;
            final boolean z822 = z7;
            final Modifier modifier322 = modifier2;
            final float f722 = f6;
            final int i1522 = i10;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        f6 = f5;
        if ((i7 & 4) == 0) {
        }
        i9 = i7 & 8;
        if (i9 == 0) {
        }
        i10 = i5;
        i11 = i7 & 16;
        if (i11 != 0) {
        }
        z7 = z6;
        i12 = i7 & 32;
        if (i12 == 0) {
        }
        if ((i7 & 64) == 0) {
        }
        if ((i8 & 599187) == 599186) {
        }
        if (i13 != 0) {
        }
        if (i14 != 0) {
        }
        if (i9 != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        if (!z5) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        function02 = function03;
        final boolean z8222 = z7;
        final Modifier modifier3222 = modifier2;
        final float f7222 = f6;
        final int i15222 = i10;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadingComponent_jfnsLPA$lambda$2(Modifier modifier, float f5, boolean z5, int i5, boolean z6, Function0 function0, Function2 function2, int i6, int i7, Composer composer, int i8) {
        m3392LoadingComponentjfnsLPA(modifier, f5, z5, i5, z6, function0, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }
}
