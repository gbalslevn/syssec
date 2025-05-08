package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001aU\u0010\f\u001a\u00020\n\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\f\u0010\r\u001ae\u0010\f\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000e2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\f\u0010\u0011¨\u0006\u0013²\u0006\u0012\u0010\u0012\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00008\nX\u008a\u0084\u0002"}, d2 = {"T", "targetState", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/animation/core/FiniteAnimationSpec;", BuildConfig.FLAVOR, "animationSpec", BuildConfig.FLAVOR, "label", "Lkotlin/Function1;", BuildConfig.FLAVOR, "content", "Crossfade", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/animation/core/Transition;", BuildConfig.FLAVOR, "contentKey", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "alpha", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class CrossfadeKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> void Crossfade(final T t5, Modifier modifier, FiniteAnimationSpec<Float> finiteAnimationSpec, String str, final Function3<? super T, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        FiniteAnimationSpec<Float> finiteAnimationSpec2;
        int i9;
        String str2;
        Modifier modifier3;
        final FiniteAnimationSpec<Float> finiteAnimationSpec3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-310686752);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = ((i5 & 8) == 0 ? startRestartGroup.changed(t5) : startRestartGroup.changedInstance(t5) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i10 = i6 & 2;
        if (i10 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                finiteAnimationSpec2 = finiteAnimationSpec;
                i7 |= startRestartGroup.changedInstance(finiteAnimationSpec2) ? 256 : 128;
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else if ((i5 & 3072) == 0) {
                    str2 = str;
                    i7 |= startRestartGroup.changed(str2) ? 2048 : 1024;
                    if ((i6 & 16) == 0) {
                        i7 |= 24576;
                    } else if ((i5 & 24576) == 0) {
                        i7 |= startRestartGroup.changedInstance(function3) ? 16384 : 8192;
                    }
                    if ((i7 & 9363) != 9362 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        finiteAnimationSpec3 = finiteAnimationSpec2;
                    } else {
                        modifier3 = i10 == 0 ? Modifier.INSTANCE : modifier2;
                        FiniteAnimationSpec<Float> tween$default = i8 == 0 ? AnimationSpecKt.tween$default(0, 0, null, 7, null) : finiteAnimationSpec2;
                        String str3 = i9 == 0 ? "Crossfade" : str2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-310686752, i7, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:55)");
                        }
                        int i11 = i7 & 58352;
                        String str4 = str3;
                        Crossfade(TransitionKt.updateTransition(t5, str3, startRestartGroup, (i7 & 14) | ((i7 >> 6) & 112), 0), modifier3, tween$default, (Function1) null, function3, startRestartGroup, i11, 4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str2 = str4;
                        finiteAnimationSpec3 = tween$default;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final Modifier modifier4 = modifier3;
                        final String str5 = str2;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$1
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

                            public final void invoke(Composer composer2, int i12) {
                                CrossfadeKt.Crossfade(t5, modifier4, finiteAnimationSpec3, str5, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                            }
                        });
                        return;
                    }
                    return;
                }
                str2 = str;
                if ((i6 & 16) == 0) {
                }
                if ((i7 & 9363) != 9362) {
                }
                if (i10 == 0) {
                }
                if (i8 == 0) {
                }
                if (i9 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                int i112 = i7 & 58352;
                String str42 = str3;
                Crossfade(TransitionKt.updateTransition(t5, str3, startRestartGroup, (i7 & 14) | ((i7 >> 6) & 112), 0), modifier3, tween$default, (Function1) null, function3, startRestartGroup, i112, 4);
                if (ComposerKt.isTraceInProgress()) {
                }
                str2 = str42;
                finiteAnimationSpec3 = tween$default;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            finiteAnimationSpec2 = finiteAnimationSpec;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            str2 = str;
            if ((i6 & 16) == 0) {
            }
            if ((i7 & 9363) != 9362) {
            }
            if (i10 == 0) {
            }
            if (i8 == 0) {
            }
            if (i9 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int i1122 = i7 & 58352;
            String str422 = str3;
            Crossfade(TransitionKt.updateTransition(t5, str3, startRestartGroup, (i7 & 14) | ((i7 >> 6) & 112), 0), modifier3, tween$default, (Function1) null, function3, startRestartGroup, i1122, 4);
            if (ComposerKt.isTraceInProgress()) {
            }
            str2 = str422;
            finiteAnimationSpec3 = tween$default;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        finiteAnimationSpec2 = finiteAnimationSpec;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        str2 = str;
        if ((i6 & 16) == 0) {
        }
        if ((i7 & 9363) != 9362) {
        }
        if (i10 == 0) {
        }
        if (i8 == 0) {
        }
        if (i9 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        int i11222 = i7 & 58352;
        String str4222 = str3;
        Crossfade(TransitionKt.updateTransition(t5, str3, startRestartGroup, (i7 & 14) | ((i7 >> 6) & 112), 0), modifier3, tween$default, (Function1) null, function3, startRestartGroup, i11222, 4);
        if (ComposerKt.isTraceInProgress()) {
        }
        str2 = str4222;
        finiteAnimationSpec3 = tween$default;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x020d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> void Crossfade(final Transition<T> transition, Modifier modifier, FiniteAnimationSpec<Float> finiteAnimationSpec, Function1<? super T, ? extends Object> function1, final Function3<? super T, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        FiniteAnimationSpec<Float> finiteAnimationSpec2;
        int i9;
        Function1<? super T, ? extends Object> function12;
        Object rememberedValue;
        Composer.Companion companion;
        Object rememberedValue2;
        MutableScatterMap mutableScatterMap;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        int size;
        int i10;
        final Modifier modifier3;
        int i11;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(679005231);
        if ((i6 & Integer.MIN_VALUE) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(transition) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i12 = i6 & 1;
        if (i12 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i8 = i6 & 2;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                finiteAnimationSpec2 = finiteAnimationSpec;
                i7 |= startRestartGroup.changedInstance(finiteAnimationSpec2) ? 256 : 128;
                i9 = i6 & 4;
                if (i9 != 0) {
                    i7 |= 3072;
                } else if ((i5 & 3072) == 0) {
                    function12 = function1;
                    i7 |= startRestartGroup.changedInstance(function12) ? 2048 : 1024;
                    if ((i6 & 8) == 0) {
                        i7 |= 24576;
                    } else if ((i5 & 24576) == 0) {
                        i7 |= startRestartGroup.changedInstance(function3) ? 16384 : 8192;
                    }
                    if ((i7 & 9363) != 9362 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                    } else {
                        Modifier modifier4 = i12 == 0 ? Modifier.INSTANCE : modifier2;
                        if (i8 != 0) {
                            finiteAnimationSpec2 = AnimationSpecKt.tween$default(0, 0, null, 7, null);
                        }
                        if (i9 != 0) {
                            function12 = new Function1<T, T>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$3
                                @Override // kotlin.jvm.functions.Function1
                                public final T invoke(T t5) {
                                    return t5;
                                }
                            };
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(679005231, i7, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:103)");
                        }
                        rememberedValue = startRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        Object obj = rememberedValue;
                        if (rememberedValue == companion.getEmpty()) {
                            SnapshotStateList mutableStateListOf = SnapshotStateKt.mutableStateListOf();
                            mutableStateListOf.add(transition.getCurrentState());
                            startRestartGroup.updateRememberedValue(mutableStateListOf);
                            obj = mutableStateListOf;
                        }
                        SnapshotStateList snapshotStateList = (SnapshotStateList) obj;
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == companion.getEmpty()) {
                            rememberedValue2 = ScatterMapKt.mutableScatterMapOf();
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        mutableScatterMap = (MutableScatterMap) rememberedValue2;
                        if (!Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
                            startRestartGroup.startReplaceGroup(860660313);
                            if (snapshotStateList.size() == 1 && Intrinsics.areEqual(snapshotStateList.get(0), transition.getTargetState())) {
                                startRestartGroup.startReplaceGroup(860984945);
                                startRestartGroup.endReplaceGroup();
                            } else {
                                startRestartGroup.startReplaceGroup(860794667);
                                boolean z5 = (i7 & 14) == 4;
                                Object rememberedValue3 = startRestartGroup.rememberedValue();
                                if (z5 || rememberedValue3 == companion.getEmpty()) {
                                    rememberedValue3 = new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Boolean invoke(T t5) {
                                            return Boolean.valueOf(!Intrinsics.areEqual(t5, transition.getTargetState()));
                                        }

                                        /* JADX WARN: Multi-variable type inference failed */
                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Boolean invoke(Object obj2) {
                                            return invoke((CrossfadeKt$Crossfade$4$1<T>) obj2);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                }
                                CollectionsKt.removeAll((List) snapshotStateList, (Function1) rememberedValue3);
                                mutableScatterMap.clear();
                                startRestartGroup.endReplaceGroup();
                            }
                            startRestartGroup.endReplaceGroup();
                        } else {
                            startRestartGroup.startReplaceGroup(860990897);
                            startRestartGroup.endReplaceGroup();
                        }
                        if (mutableScatterMap.contains(transition.getTargetState())) {
                            startRestartGroup.startReplaceGroup(861052122);
                            Iterator<T> it = snapshotStateList.iterator();
                            int i13 = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    i11 = -1;
                                    i13 = -1;
                                    break;
                                } else {
                                    if (Intrinsics.areEqual(function12.invoke(it.next()), function12.invoke(transition.getTargetState()))) {
                                        i11 = -1;
                                        break;
                                    }
                                    i13++;
                                }
                            }
                            if (i13 == i11) {
                                snapshotStateList.add(transition.getTargetState());
                            } else {
                                snapshotStateList.set(i13, transition.getTargetState());
                            }
                            mutableScatterMap.clear();
                            int size2 = snapshotStateList.size();
                            for (int i14 = 0; i14 < size2; i14++) {
                                T t5 = snapshotStateList.get(i14);
                                mutableScatterMap.set(t5, ComposableLambdaKt.rememberComposableLambda(-1426421288, true, new CrossfadeKt$Crossfade$5$1(transition, finiteAnimationSpec2, t5, function3), startRestartGroup, 54));
                            }
                            startRestartGroup.endReplaceGroup();
                        } else {
                            startRestartGroup.startReplaceGroup(861812273);
                            startRestartGroup.endReplaceGroup();
                        }
                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                        if (startRestartGroup.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        startRestartGroup.startReusableNode();
                        if (!startRestartGroup.getInserting()) {
                            startRestartGroup.createNode(constructor);
                        } else {
                            startRestartGroup.useNode();
                        }
                        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                        if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        startRestartGroup.startReplaceGroup(-187482432);
                        size = snapshotStateList.size();
                        for (i10 = 0; i10 < size; i10++) {
                            T t6 = snapshotStateList.get(i10);
                            startRestartGroup.startMovableGroup(-1081873445, function12.invoke(t6));
                            Function2 function2 = (Function2) mutableScatterMap.get(t6);
                            if (function2 == null) {
                                startRestartGroup.startReplaceGroup(821713034);
                                startRestartGroup.endReplaceGroup();
                            } else {
                                startRestartGroup.startReplaceGroup(-1081871785);
                                function2.invoke(startRestartGroup, 0);
                                startRestartGroup.endReplaceGroup();
                            }
                            startRestartGroup.endMovableGroup();
                        }
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                    }
                    final FiniteAnimationSpec<Float> finiteAnimationSpec3 = finiteAnimationSpec2;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final Function1<? super T, ? extends Object> function13 = function12;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$7
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

                            public final void invoke(Composer composer2, int i15) {
                                CrossfadeKt.Crossfade(transition, modifier3, finiteAnimationSpec3, function13, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                            }
                        });
                        return;
                    }
                    return;
                }
                function12 = function1;
                if ((i6 & 8) == 0) {
                }
                if ((i7 & 9363) != 9362) {
                }
                if (i12 == 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                Object obj2 = rememberedValue;
                if (rememberedValue == companion.getEmpty()) {
                }
                SnapshotStateList snapshotStateList2 = (SnapshotStateList) obj2;
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                }
                mutableScatterMap = (MutableScatterMap) rememberedValue2;
                if (!Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
                }
                if (mutableScatterMap.contains(transition.getTargetState())) {
                }
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
                ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor2 = companion22.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (!startRestartGroup.getInserting()) {
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy2, companion22.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion22.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion22.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting()) {
                }
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion22.getSetModifier());
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                startRestartGroup.startReplaceGroup(-187482432);
                size = snapshotStateList2.size();
                while (i10 < size) {
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier4;
                final FiniteAnimationSpec<Float> finiteAnimationSpec32 = finiteAnimationSpec2;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            finiteAnimationSpec2 = finiteAnimationSpec;
            i9 = i6 & 4;
            if (i9 != 0) {
            }
            function12 = function1;
            if ((i6 & 8) == 0) {
            }
            if ((i7 & 9363) != 9362) {
            }
            if (i12 == 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            rememberedValue = startRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            Object obj22 = rememberedValue;
            if (rememberedValue == companion.getEmpty()) {
            }
            SnapshotStateList snapshotStateList22 = (SnapshotStateList) obj22;
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
            }
            mutableScatterMap = (MutableScatterMap) rememberedValue2;
            if (!Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
            }
            if (mutableScatterMap.contains(transition.getTargetState())) {
            }
            MeasurePolicy maybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
            ComposeUiNode.Companion companion222 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor22 = companion222.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (!startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy22, companion222.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap22, companion222.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion222.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier22, companion222.getSetModifier());
            BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(-187482432);
            size = snapshotStateList22.size();
            while (i10 < size) {
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier4;
            final FiniteAnimationSpec<Float> finiteAnimationSpec322 = finiteAnimationSpec2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 2;
        if (i8 == 0) {
        }
        finiteAnimationSpec2 = finiteAnimationSpec;
        i9 = i6 & 4;
        if (i9 != 0) {
        }
        function12 = function1;
        if ((i6 & 8) == 0) {
        }
        if ((i7 & 9363) != 9362) {
        }
        if (i12 == 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        Object obj222 = rememberedValue;
        if (rememberedValue == companion.getEmpty()) {
        }
        SnapshotStateList snapshotStateList222 = (SnapshotStateList) obj222;
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
        }
        mutableScatterMap = (MutableScatterMap) rememberedValue2;
        if (!Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
        }
        if (mutableScatterMap.contains(transition.getTargetState())) {
        }
        MeasurePolicy maybeCachedBoxMeasurePolicy222 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
        ComposeUiNode.Companion companion2222 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor222 = companion2222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (!startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy222, companion2222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap222, companion2222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = companion2222.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash222);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier222, companion2222.getSetModifier());
        BoxScopeInstance boxScopeInstance222 = BoxScopeInstance.INSTANCE;
        startRestartGroup.startReplaceGroup(-187482432);
        size = snapshotStateList222.size();
        while (i10 < size) {
        }
        startRestartGroup.endReplaceGroup();
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier4;
        final FiniteAnimationSpec<Float> finiteAnimationSpec3222 = finiteAnimationSpec2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
