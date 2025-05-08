package androidx.compose.animation;

import A2.d;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.AnimatedContentTransitionScopeImpl;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0089\u0001\u0010\u0012\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0004\u0012\u00020\u00060\u00042\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00042\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00100\u000eH\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a9\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u0015\u001a\u00020\u00142 \b\u0002\u0010\u0018\u001a\u001a\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00170\u000e¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001c\u0010\u001f\u001a\u00020\u0006*\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001dH\u0086\u0004¢\u0006\u0004\b\u001f\u0010 \u001a\u0081\u0001\u0010\u0012\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000!2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0004\u0012\u00020\u00060\u00042\b\b\u0002\u0010\t\u001a\u00020\b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00042\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00100\u000eH\u0007¢\u0006\u0004\b\u0012\u0010\"¨\u0006#"}, d2 = {"S", "targetState", "Landroidx/compose/ui/Modifier;", "modifier", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/compose/animation/ContentTransform;", "transitionSpec", "Landroidx/compose/ui/Alignment;", "contentAlignment", BuildConfig.FLAVOR, "label", BuildConfig.FLAVOR, "contentKey", "Lkotlin/Function2;", "Landroidx/compose/animation/AnimatedContentScope;", BuildConfig.FLAVOR, "content", "AnimatedContent", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", BuildConfig.FLAVOR, "clip", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "sizeAnimationSpec", "Landroidx/compose/animation/SizeTransform;", "SizeTransform", "(ZLkotlin/jvm/functions/Function2;)Landroidx/compose/animation/SizeTransform;", "Landroidx/compose/animation/EnterTransition;", "Landroidx/compose/animation/ExitTransition;", "exit", "togetherWith", "(Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;)Landroidx/compose/animation/ContentTransform;", "Landroidx/compose/animation/core/Transition;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AnimatedContentKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <S> void AnimatedContent(final S s5, Modifier modifier, Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function1, Alignment alignment, String str, Function1<? super S, ? extends Object> function12, final Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function13;
        int i9;
        Alignment alignment2;
        int i10;
        String str2;
        int i11;
        Function1<? super S, ? extends Object> function14;
        final Alignment topStart;
        final String str3;
        final Function1<? super S, ? extends Object> function15;
        Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(2132720749);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = ((i5 & 8) == 0 ? startRestartGroup.changed(s5) : startRestartGroup.changedInstance(s5) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i12 = i6 & 2;
        if (i12 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                function13 = function1;
                i7 |= startRestartGroup.changedInstance(function13) ? 256 : 128;
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
                        str2 = str;
                        i7 |= startRestartGroup.changed(str2) ? 16384 : 8192;
                        i11 = i6 & 32;
                        if (i11 != 0) {
                            i7 |= 196608;
                        } else if ((196608 & i5) == 0) {
                            function14 = function12;
                            i7 |= startRestartGroup.changedInstance(function14) ? 131072 : 65536;
                            if ((i6 & 64) == 0) {
                                i7 |= 1572864;
                            } else if ((i5 & 1572864) == 0) {
                                i7 |= startRestartGroup.changedInstance(function4) ? 1048576 : 524288;
                                if ((i7 & 599187) != 599186 && startRestartGroup.getSkipping()) {
                                    startRestartGroup.skipToGroupEnd();
                                    modifier2 = modifier;
                                    topStart = alignment2;
                                    str3 = str2;
                                    function15 = function14;
                                } else {
                                    Modifier modifier3 = i12 != 0 ? Modifier.INSTANCE : modifier;
                                    if (i8 != 0) {
                                        function13 = new Function1<AnimatedContentTransitionScope<S>, ContentTransform>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final ContentTransform invoke(AnimatedContentTransitionScope<S> animatedContentTransitionScope) {
                                                return AnimatedContentKt.togetherWith(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.0f, 2, null).plus(EnterExitTransitionKt.m29scaleInL8ZKhE$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.92f, 0L, 4, null)), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(90, 0, null, 6, null), 0.0f, 2, null));
                                            }
                                        };
                                    }
                                    topStart = i9 != 0 ? Alignment.INSTANCE.getTopStart() : alignment2;
                                    str3 = i10 != 0 ? "AnimatedContent" : str2;
                                    function15 = i11 != 0 ? new Function1<S, S>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final S invoke(S s6) {
                                            return s6;
                                        }
                                    } : function14;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2132720749, i7, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:140)");
                                    }
                                    Transition updateTransition = TransitionKt.updateTransition(s5, str3, startRestartGroup, (i7 & 14) | ((i7 >> 9) & 112), 0);
                                    int i13 = i7 & 8176;
                                    int i14 = i7 >> 3;
                                    AnimatedContent(updateTransition, modifier3, function13, topStart, function15, function4, startRestartGroup, i13 | (57344 & i14) | (i14 & 458752), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier2 = modifier3;
                                }
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                    final Modifier modifier4 = modifier2;
                                    final Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function16 = function13;
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$3
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
                                            AnimatedContentKt.AnimatedContent(s5, modifier4, function16, topStart, str3, function15, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            if ((i7 & 599187) != 599186) {
                            }
                            if (i12 != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i9 != 0) {
                            }
                            if (i10 != 0) {
                            }
                            if (i11 != 0) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            Transition updateTransition2 = TransitionKt.updateTransition(s5, str3, startRestartGroup, (i7 & 14) | ((i7 >> 9) & 112), 0);
                            int i132 = i7 & 8176;
                            int i142 = i7 >> 3;
                            AnimatedContent(updateTransition2, modifier3, function13, topStart, function15, function4, startRestartGroup, i132 | (57344 & i142) | (i142 & 458752), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier2 = modifier3;
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        function14 = function12;
                        if ((i6 & 64) == 0) {
                        }
                        if ((i7 & 599187) != 599186) {
                        }
                        if (i12 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if (i10 != 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        Transition updateTransition22 = TransitionKt.updateTransition(s5, str3, startRestartGroup, (i7 & 14) | ((i7 >> 9) & 112), 0);
                        int i1322 = i7 & 8176;
                        int i1422 = i7 >> 3;
                        AnimatedContent(updateTransition22, modifier3, function13, topStart, function15, function4, startRestartGroup, i1322 | (57344 & i1422) | (i1422 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier2 = modifier3;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    str2 = str;
                    i11 = i6 & 32;
                    if (i11 != 0) {
                    }
                    function14 = function12;
                    if ((i6 & 64) == 0) {
                    }
                    if ((i7 & 599187) != 599186) {
                    }
                    if (i12 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Transition updateTransition222 = TransitionKt.updateTransition(s5, str3, startRestartGroup, (i7 & 14) | ((i7 >> 9) & 112), 0);
                    int i13222 = i7 & 8176;
                    int i14222 = i7 >> 3;
                    AnimatedContent(updateTransition222, modifier3, function13, topStart, function15, function4, startRestartGroup, i13222 | (57344 & i14222) | (i14222 & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier2 = modifier3;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                alignment2 = alignment;
                i10 = i6 & 16;
                if (i10 == 0) {
                }
                str2 = str;
                i11 = i6 & 32;
                if (i11 != 0) {
                }
                function14 = function12;
                if ((i6 & 64) == 0) {
                }
                if ((i7 & 599187) != 599186) {
                }
                if (i12 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                Transition updateTransition2222 = TransitionKt.updateTransition(s5, str3, startRestartGroup, (i7 & 14) | ((i7 >> 9) & 112), 0);
                int i132222 = i7 & 8176;
                int i142222 = i7 >> 3;
                AnimatedContent(updateTransition2222, modifier3, function13, topStart, function15, function4, startRestartGroup, i132222 | (57344 & i142222) | (i142222 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier2 = modifier3;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function13 = function1;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            alignment2 = alignment;
            i10 = i6 & 16;
            if (i10 == 0) {
            }
            str2 = str;
            i11 = i6 & 32;
            if (i11 != 0) {
            }
            function14 = function12;
            if ((i6 & 64) == 0) {
            }
            if ((i7 & 599187) != 599186) {
            }
            if (i12 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Transition updateTransition22222 = TransitionKt.updateTransition(s5, str3, startRestartGroup, (i7 & 14) | ((i7 >> 9) & 112), 0);
            int i1322222 = i7 & 8176;
            int i1422222 = i7 >> 3;
            AnimatedContent(updateTransition22222, modifier3, function13, topStart, function15, function4, startRestartGroup, i1322222 | (57344 & i1422222) | (i1422222 & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier3;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        function13 = function1;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        alignment2 = alignment;
        i10 = i6 & 16;
        if (i10 == 0) {
        }
        str2 = str;
        i11 = i6 & 32;
        if (i11 != 0) {
        }
        function14 = function12;
        if ((i6 & 64) == 0) {
        }
        if ((i7 & 599187) != 599186) {
        }
        if (i12 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Transition updateTransition222222 = TransitionKt.updateTransition(s5, str3, startRestartGroup, (i7 & 14) | ((i7 >> 9) & 112), 0);
        int i13222222 = i7 & 8176;
        int i14222222 = i7 >> 3;
        AnimatedContent(updateTransition222222, modifier3, function13, topStart, function15, function4, startRestartGroup, i13222222 | (57344 & i14222222) | (i14222222 & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = modifier3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final SizeTransform SizeTransform(boolean z5, Function2<? super IntSize, ? super IntSize, ? extends FiniteAnimationSpec<IntSize>> function2) {
        return new SizeTransformImpl(z5, function2);
    }

    public static /* synthetic */ SizeTransform SizeTransform$default(boolean z5, Function2 function2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = true;
        }
        if ((i5 & 2) != 0) {
            function2 = new Function2<IntSize, IntSize, SpringSpec<IntSize>>() { // from class: androidx.compose.animation.AnimatedContentKt$SizeTransform$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ SpringSpec<IntSize> invoke(IntSize intSize, IntSize intSize2) {
                    return m18invokeTemP2vQ(intSize.getPackedValue(), intSize2.getPackedValue());
                }

                /* renamed from: invoke-TemP2vQ, reason: not valid java name */
                public final SpringSpec<IntSize> m18invokeTemP2vQ(long j5, long j6) {
                    return AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m2656boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
                }
            };
        }
        return SizeTransform(z5, function2);
    }

    public static final ContentTransform togetherWith(EnterTransition enterTransition, ExitTransition exitTransition) {
        return new ContentTransform(enterTransition, exitTransition, 0.0f, null, 12, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x023c A[LOOP:2: B:142:0x023a->B:143:0x023c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01f4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <S> void AnimatedContent(final Transition<S> transition, Modifier modifier, Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function1, Alignment alignment, Function1<? super S, ? extends Object> function12, final Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function13;
        int i9;
        Alignment alignment2;
        int i10;
        Function1<? super S, ? extends Object> function14;
        LayoutDirection layoutDirection;
        boolean z5;
        Object rememberedValue;
        AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl;
        boolean z6;
        Object rememberedValue2;
        SnapshotStateList snapshotStateList;
        boolean z7;
        Object rememberedValue3;
        MutableScatterMap mutableScatterMap;
        int size;
        int i11;
        SnapshotStateList snapshotStateList2;
        AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl2;
        Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function15;
        AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl3;
        boolean changed;
        ContentTransform rememberedValue4;
        Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function16;
        Object rememberedValue5;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        int size2;
        int i12;
        final Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function17;
        final Alignment alignment3;
        final Function1<? super S, ? extends Object> function18;
        final Modifier modifier3;
        Iterator<T> it;
        int i13;
        int i14;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-114689412);
        if ((i6 & Integer.MIN_VALUE) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(transition) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i15 = i6 & 1;
        if (i15 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i8 = i6 & 2;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                function13 = function1;
                i7 |= startRestartGroup.changedInstance(function13) ? 256 : 128;
                i9 = i6 & 4;
                if (i9 != 0) {
                    i7 |= 3072;
                } else if ((i5 & 3072) == 0) {
                    alignment2 = alignment;
                    i7 |= startRestartGroup.changed(alignment2) ? 2048 : 1024;
                    i10 = i6 & 8;
                    if (i10 == 0) {
                        i7 |= 24576;
                    } else if ((i5 & 24576) == 0) {
                        function14 = function12;
                        i7 |= startRestartGroup.changedInstance(function14) ? 16384 : 8192;
                        if ((i6 & 16) != 0) {
                            i7 |= 196608;
                        } else if ((i5 & 196608) == 0) {
                            i7 |= startRestartGroup.changedInstance(function4) ? 131072 : 65536;
                            if ((74899 & i7) != 74898 && startRestartGroup.getSkipping()) {
                                startRestartGroup.skipToGroupEnd();
                                modifier3 = modifier2;
                                function17 = function13;
                                alignment3 = alignment2;
                                function18 = function14;
                            } else {
                                Modifier modifier4 = i15 == 0 ? Modifier.INSTANCE : modifier2;
                                if (i8 != 0) {
                                    function13 = new Function1<AnimatedContentTransitionScope<S>, ContentTransform>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$4
                                        @Override // kotlin.jvm.functions.Function1
                                        public final ContentTransform invoke(AnimatedContentTransitionScope<S> animatedContentTransitionScope) {
                                            return AnimatedContentKt.togetherWith(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.0f, 2, null).plus(EnterExitTransitionKt.m29scaleInL8ZKhE$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.92f, 0L, 4, null)), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(90, 0, null, 6, null), 0.0f, 2, null));
                                        }
                                    };
                                }
                                if (i9 != 0) {
                                    alignment2 = Alignment.INSTANCE.getTopStart();
                                }
                                if (i10 != 0) {
                                    function14 = new Function1<S, S>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$5
                                        @Override // kotlin.jvm.functions.Function1
                                        public final S invoke(S s5) {
                                            return s5;
                                        }
                                    };
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-114689412, i7, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:713)");
                                }
                                layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                int i16 = i7 & 14;
                                z5 = i16 != 4;
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new AnimatedContentTransitionScopeImpl(transition, alignment2, layoutDirection);
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                animatedContentTransitionScopeImpl = rememberedValue;
                                z6 = i16 != 4;
                                rememberedValue2 = startRestartGroup.rememberedValue();
                                if (!z6 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                snapshotStateList = (SnapshotStateList) rememberedValue2;
                                z7 = i16 != 4;
                                rememberedValue3 = startRestartGroup.rememberedValue();
                                if (!z7 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = ScatterMapKt.mutableScatterMapOf();
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                }
                                mutableScatterMap = (MutableScatterMap) rememberedValue3;
                                if (!snapshotStateList.contains(transition.getCurrentState())) {
                                    snapshotStateList.clear();
                                    snapshotStateList.add(transition.getCurrentState());
                                }
                                if (Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
                                    if (snapshotStateList.size() != 1 || !Intrinsics.areEqual(snapshotStateList.get(0), transition.getCurrentState())) {
                                        snapshotStateList.clear();
                                        snapshotStateList.add(transition.getCurrentState());
                                    }
                                    if (mutableScatterMap.get_size() != 1 || mutableScatterMap.containsKey(transition.getCurrentState())) {
                                        mutableScatterMap.clear();
                                    }
                                    animatedContentTransitionScopeImpl.setContentAlignment(alignment2);
                                    animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                                }
                                if (!Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState()) && !snapshotStateList.contains(transition.getTargetState())) {
                                    it = snapshotStateList.iterator();
                                    i13 = 0;
                                    while (true) {
                                        if (it.hasNext()) {
                                            i14 = -1;
                                            i13 = -1;
                                            break;
                                        } else {
                                            if (Intrinsics.areEqual(function14.invoke((Object) it.next()), function14.invoke(transition.getTargetState()))) {
                                                i14 = -1;
                                                break;
                                            }
                                            i13++;
                                        }
                                    }
                                    if (i13 != i14) {
                                        snapshotStateList.add(transition.getTargetState());
                                    } else {
                                        snapshotStateList.set(i13, transition.getTargetState());
                                    }
                                }
                                if (!mutableScatterMap.containsKey(transition.getTargetState()) && mutableScatterMap.containsKey(transition.getCurrentState())) {
                                    startRestartGroup.startReplaceGroup(915535767);
                                    startRestartGroup.endReplaceGroup();
                                    snapshotStateList2 = snapshotStateList;
                                    animatedContentTransitionScopeImpl2 = animatedContentTransitionScopeImpl;
                                    function15 = function13;
                                } else {
                                    startRestartGroup.startReplaceGroup(912931457);
                                    mutableScatterMap.clear();
                                    size = snapshotStateList.size();
                                    i11 = 0;
                                    while (i11 < size) {
                                        final T t5 = snapshotStateList.get(i11);
                                        int i17 = i11;
                                        final Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function19 = function13;
                                        final SnapshotStateList snapshotStateList3 = snapshotStateList;
                                        final AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl4 = animatedContentTransitionScopeImpl;
                                        mutableScatterMap = mutableScatterMap;
                                        mutableScatterMap.set(t5, ComposableLambdaKt.rememberComposableLambda(885640742, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1
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

                                            /* JADX WARN: Multi-variable type inference failed */
                                            public final void invoke(Composer composer2, int i18) {
                                                Object initialContentExit;
                                                if ((i18 & 3) == 2 && composer2.getSkipping()) {
                                                    composer2.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(885640742, i18, -1, "androidx.compose.animation.AnimatedContent.<anonymous>.<anonymous> (AnimatedContent.kt:757)");
                                                }
                                                Function1<AnimatedContentTransitionScope<S>, ContentTransform> function110 = function19;
                                                Object obj = animatedContentTransitionScopeImpl4;
                                                ContentTransform rememberedValue6 = composer2.rememberedValue();
                                                Composer.Companion companion = Composer.INSTANCE;
                                                if (rememberedValue6 == companion.getEmpty()) {
                                                    rememberedValue6 = function110.invoke(obj);
                                                    composer2.updateRememberedValue(rememberedValue6);
                                                }
                                                final ContentTransform contentTransform = (ContentTransform) rememberedValue6;
                                                boolean changed2 = composer2.changed(Intrinsics.areEqual(transition.getSegment().getTargetState(), t5));
                                                Transition<S> transition2 = transition;
                                                S s5 = t5;
                                                Function1<AnimatedContentTransitionScope<S>, ContentTransform> function111 = function19;
                                                Object obj2 = animatedContentTransitionScopeImpl4;
                                                Object rememberedValue7 = composer2.rememberedValue();
                                                if (changed2 || rememberedValue7 == companion.getEmpty()) {
                                                    if (Intrinsics.areEqual(transition2.getSegment().getTargetState(), s5)) {
                                                        initialContentExit = ExitTransition.INSTANCE.getNone();
                                                    } else {
                                                        initialContentExit = function111.invoke(obj2).getInitialContentExit();
                                                    }
                                                    rememberedValue7 = initialContentExit;
                                                    composer2.updateRememberedValue(rememberedValue7);
                                                }
                                                final ExitTransition exitTransition = (ExitTransition) rememberedValue7;
                                                S s6 = t5;
                                                Transition<S> transition3 = transition;
                                                Object rememberedValue8 = composer2.rememberedValue();
                                                if (rememberedValue8 == companion.getEmpty()) {
                                                    rememberedValue8 = new AnimatedContentTransitionScopeImpl.ChildData(Intrinsics.areEqual(s6, transition3.getTargetState()));
                                                    composer2.updateRememberedValue(rememberedValue8);
                                                }
                                                AnimatedContentTransitionScopeImpl.ChildData childData = (AnimatedContentTransitionScopeImpl.ChildData) rememberedValue8;
                                                EnterTransition targetContentEnter = contentTransform.getTargetContentEnter();
                                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                                boolean changedInstance = composer2.changedInstance(contentTransform);
                                                Object rememberedValue9 = composer2.rememberedValue();
                                                if (changedInstance || rememberedValue9 == companion.getEmpty()) {
                                                    rememberedValue9 = new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$1$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                                            return m17invoke3p2s80s(measureScope, measurable, constraints.getValue());
                                                        }

                                                        /* renamed from: invoke-3p2s80s, reason: not valid java name */
                                                        public final MeasureResult m17invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j5) {
                                                            final Placeable mo1946measureBRTryo0 = measurable.mo1946measureBRTryo0(j5);
                                                            int width = mo1946measureBRTryo0.getWidth();
                                                            int height = mo1946measureBRTryo0.getHeight();
                                                            final ContentTransform contentTransform2 = ContentTransform.this;
                                                            return MeasureScope.layout$default(measureScope, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$1$1.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                    invoke2(placementScope);
                                                                    return Unit.INSTANCE;
                                                                }

                                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                public final void invoke2(Placeable.PlacementScope placementScope) {
                                                                    placementScope.place(Placeable.this, 0, 0, contentTransform2.getTargetContentZIndex());
                                                                }
                                                            }, 4, null);
                                                        }
                                                    };
                                                    composer2.updateRememberedValue(rememberedValue9);
                                                }
                                                Modifier layout = LayoutModifierKt.layout(companion2, (Function3) rememberedValue9);
                                                childData.setTarget(Intrinsics.areEqual(t5, transition.getTargetState()));
                                                Modifier then = layout.then(childData);
                                                Transition<S> transition4 = transition;
                                                boolean changedInstance2 = composer2.changedInstance(t5);
                                                final S s7 = t5;
                                                Object rememberedValue10 = composer2.rememberedValue();
                                                if (changedInstance2 || rememberedValue10 == companion.getEmpty()) {
                                                    rememberedValue10 = new Function1<S, Boolean>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$3$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Boolean invoke(S s8) {
                                                            return Boolean.valueOf(Intrinsics.areEqual(s8, s7));
                                                        }

                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Boolean invoke(Object obj3) {
                                                            return invoke((AnimatedContentKt$AnimatedContent$6$1$3$1<S>) obj3);
                                                        }
                                                    };
                                                    composer2.updateRememberedValue(rememberedValue10);
                                                }
                                                Function1 function112 = (Function1) rememberedValue10;
                                                boolean changed3 = composer2.changed(exitTransition);
                                                Object rememberedValue11 = composer2.rememberedValue();
                                                if (changed3 || rememberedValue11 == companion.getEmpty()) {
                                                    rememberedValue11 = new Function2<EnterExitState, EnterExitState, Boolean>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$4$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public final Boolean invoke(EnterExitState enterExitState, EnterExitState enterExitState2) {
                                                            EnterExitState enterExitState3 = EnterExitState.PostExit;
                                                            return Boolean.valueOf(enterExitState == enterExitState3 && enterExitState2 == enterExitState3 && !ExitTransition.this.getData().getHold());
                                                        }
                                                    };
                                                    composer2.updateRememberedValue(rememberedValue11);
                                                }
                                                Function2 function2 = (Function2) rememberedValue11;
                                                final SnapshotStateList<S> snapshotStateList4 = snapshotStateList3;
                                                final S s8 = t5;
                                                final AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl5 = animatedContentTransitionScopeImpl4;
                                                final Function4<AnimatedContentScope, S, Composer, Integer, Unit> function42 = function4;
                                                AnimatedVisibilityKt.AnimatedEnterExitImpl(transition4, function112, then, targetContentEnter, exitTransition, function2, null, ComposableLambdaKt.rememberComposableLambda(-616195562, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1.5
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                                                        invoke(animatedVisibilityScope, composer3, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, int i19) {
                                                        if ((i19 & 6) == 0) {
                                                            i19 |= (i19 & 8) == 0 ? composer3.changed(animatedVisibilityScope) : composer3.changedInstance(animatedVisibilityScope) ? 4 : 2;
                                                        }
                                                        if ((i19 & 19) == 18 && composer3.getSkipping()) {
                                                            composer3.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-616195562, i19, -1, "androidx.compose.animation.AnimatedContent.<anonymous>.<anonymous>.<anonymous> (AnimatedContent.kt:793)");
                                                        }
                                                        boolean changed4 = composer3.changed(snapshotStateList4) | composer3.changedInstance(s8) | composer3.changedInstance(animatedContentTransitionScopeImpl5);
                                                        final SnapshotStateList<S> snapshotStateList5 = snapshotStateList4;
                                                        final S s9 = s8;
                                                        final AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl6 = animatedContentTransitionScopeImpl5;
                                                        Object rememberedValue12 = composer3.rememberedValue();
                                                        if (changed4 || rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                                                            rememberedValue12 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$5$1$1
                                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                                                    final SnapshotStateList<S> snapshotStateList6 = snapshotStateList5;
                                                                    final S s10 = s9;
                                                                    final AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl7 = animatedContentTransitionScopeImpl6;
                                                                    return new DisposableEffectResult() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$5$1$1$invoke$$inlined$onDispose$1
                                                                        @Override // androidx.compose.runtime.DisposableEffectResult
                                                                        public void dispose() {
                                                                            SnapshotStateList.this.remove(s10);
                                                                            animatedContentTransitionScopeImpl7.getTargetSizeMap$animation_release().remove(s10);
                                                                        }
                                                                    };
                                                                }
                                                            };
                                                            composer3.updateRememberedValue(rememberedValue12);
                                                        }
                                                        EffectsKt.DisposableEffect(animatedVisibilityScope, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue12, composer3, i19 & 14);
                                                        MutableScatterMap targetSizeMap$animation_release = animatedContentTransitionScopeImpl5.getTargetSizeMap$animation_release();
                                                        S s10 = s8;
                                                        Intrinsics.checkNotNull(animatedVisibilityScope, "null cannot be cast to non-null type androidx.compose.animation.AnimatedVisibilityScopeImpl");
                                                        targetSizeMap$animation_release.set(s10, ((AnimatedVisibilityScopeImpl) animatedVisibilityScope).getTargetSize$animation_release());
                                                        Object rememberedValue13 = composer3.rememberedValue();
                                                        if (rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                                                            rememberedValue13 = new AnimatedContentScopeImpl(animatedVisibilityScope);
                                                            composer3.updateRememberedValue(rememberedValue13);
                                                        }
                                                        function42.invoke((AnimatedContentScopeImpl) rememberedValue13, s8, composer3, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }, composer2, 54), composer2, 12582912, 64);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, startRestartGroup, 54));
                                        i11 = i17 + 1;
                                        snapshotStateList = snapshotStateList3;
                                        animatedContentTransitionScopeImpl = animatedContentTransitionScopeImpl;
                                        function13 = function13;
                                    }
                                    snapshotStateList2 = snapshotStateList;
                                    animatedContentTransitionScopeImpl2 = animatedContentTransitionScopeImpl;
                                    function15 = function13;
                                    startRestartGroup.endReplaceGroup();
                                }
                                animatedContentTransitionScopeImpl3 = animatedContentTransitionScopeImpl2;
                                changed = startRestartGroup.changed(transition.getSegment()) | startRestartGroup.changed(animatedContentTransitionScopeImpl3);
                                rememberedValue4 = startRestartGroup.rememberedValue();
                                if (!changed || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    function16 = function15;
                                    rememberedValue4 = function16.invoke(animatedContentTransitionScopeImpl3);
                                    startRestartGroup.updateRememberedValue(rememberedValue4);
                                } else {
                                    function16 = function15;
                                }
                                Modifier then = modifier4.then(animatedContentTransitionScopeImpl3.createSizeAnimationModifier$animation_release((ContentTransform) rememberedValue4, startRestartGroup, 0));
                                rememberedValue5 = startRestartGroup.rememberedValue();
                                if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl3);
                                    startRestartGroup.updateRememberedValue(rememberedValue5);
                                }
                                AnimatedContentMeasurePolicy animatedContentMeasurePolicy = (AnimatedContentMeasurePolicy) rememberedValue5;
                                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, then);
                                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion.getConstructor();
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
                                Updater.m1227setimpl(m1226constructorimpl, animatedContentMeasurePolicy, companion.getSetMeasurePolicy());
                                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                                startRestartGroup.startReplaceGroup(-1491001814);
                                size2 = snapshotStateList2.size();
                                i12 = 0;
                                while (i12 < size2) {
                                    SnapshotStateList snapshotStateList4 = snapshotStateList2;
                                    d dVar = (Object) snapshotStateList4.get(i12);
                                    startRestartGroup.startMovableGroup(1908315325, function14.invoke(dVar));
                                    Function2 function2 = (Function2) mutableScatterMap.get(dVar);
                                    if (function2 == null) {
                                        startRestartGroup.startReplaceGroup(-971711888);
                                        startRestartGroup.endReplaceGroup();
                                    } else {
                                        startRestartGroup.startReplaceGroup(1908317105);
                                        function2.invoke(startRestartGroup, 0);
                                        startRestartGroup.endReplaceGroup();
                                    }
                                    startRestartGroup.endMovableGroup();
                                    i12++;
                                    snapshotStateList2 = snapshotStateList4;
                                }
                                startRestartGroup.endReplaceGroup();
                                startRestartGroup.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function17 = function16;
                                alignment3 = alignment2;
                                function18 = function14;
                                modifier3 = modifier4;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$9
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

                                    public final void invoke(Composer composer2, int i18) {
                                        AnimatedContentKt.AnimatedContent(transition, modifier3, function17, alignment3, function18, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if ((74899 & i7) != 74898) {
                        }
                        if (i15 == 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if (i10 != 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        int i162 = i7 & 14;
                        if (i162 != 4) {
                        }
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!z5) {
                        }
                        rememberedValue = new AnimatedContentTransitionScopeImpl(transition, alignment2, layoutDirection);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        animatedContentTransitionScopeImpl = rememberedValue;
                        if (i162 != 4) {
                        }
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (!z6) {
                        }
                        rememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                        snapshotStateList = (SnapshotStateList) rememberedValue2;
                        if (i162 != 4) {
                        }
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!z7) {
                        }
                        rememberedValue3 = ScatterMapKt.mutableScatterMapOf();
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                        mutableScatterMap = (MutableScatterMap) rememberedValue3;
                        if (!snapshotStateList.contains(transition.getCurrentState())) {
                        }
                        if (Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
                        }
                        if (!Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
                            it = snapshotStateList.iterator();
                            i13 = 0;
                            while (true) {
                                if (it.hasNext()) {
                                }
                                i13++;
                            }
                            if (i13 != i14) {
                            }
                        }
                        if (!mutableScatterMap.containsKey(transition.getTargetState())) {
                        }
                        startRestartGroup.startReplaceGroup(912931457);
                        mutableScatterMap.clear();
                        size = snapshotStateList.size();
                        i11 = 0;
                        while (i11 < size) {
                        }
                        snapshotStateList2 = snapshotStateList;
                        animatedContentTransitionScopeImpl2 = animatedContentTransitionScopeImpl;
                        function15 = function13;
                        startRestartGroup.endReplaceGroup();
                        animatedContentTransitionScopeImpl3 = animatedContentTransitionScopeImpl2;
                        changed = startRestartGroup.changed(transition.getSegment()) | startRestartGroup.changed(animatedContentTransitionScopeImpl3);
                        rememberedValue4 = startRestartGroup.rememberedValue();
                        if (changed) {
                        }
                        function16 = function15;
                        rememberedValue4 = function16.invoke(animatedContentTransitionScopeImpl3);
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                        Modifier then2 = modifier4.then(animatedContentTransitionScopeImpl3.createSizeAnimationModifier$animation_release((ContentTransform) rememberedValue4, startRestartGroup, 0));
                        rememberedValue5 = startRestartGroup.rememberedValue();
                        if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        }
                        AnimatedContentMeasurePolicy animatedContentMeasurePolicy2 = (AnimatedContentMeasurePolicy) rememberedValue5;
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, then2);
                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                        if (startRestartGroup.getApplier() == null) {
                        }
                        startRestartGroup.startReusableNode();
                        if (!startRestartGroup.getInserting()) {
                        }
                        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                        Updater.m1227setimpl(m1226constructorimpl, animatedContentMeasurePolicy2, companion2.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                        if (!m1226constructorimpl.getInserting()) {
                        }
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion2.getSetModifier());
                        startRestartGroup.startReplaceGroup(-1491001814);
                        size2 = snapshotStateList2.size();
                        i12 = 0;
                        while (i12 < size2) {
                        }
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        function17 = function16;
                        alignment3 = alignment2;
                        function18 = function14;
                        modifier3 = modifier4;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    function14 = function12;
                    if ((i6 & 16) != 0) {
                    }
                    if ((74899 & i7) != 74898) {
                    }
                    if (i15 == 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    int i1622 = i7 & 14;
                    if (i1622 != 4) {
                    }
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z5) {
                    }
                    rememberedValue = new AnimatedContentTransitionScopeImpl(transition, alignment2, layoutDirection);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    animatedContentTransitionScopeImpl = rememberedValue;
                    if (i1622 != 4) {
                    }
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!z6) {
                    }
                    rememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    snapshotStateList = (SnapshotStateList) rememberedValue2;
                    if (i1622 != 4) {
                    }
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (!z7) {
                    }
                    rememberedValue3 = ScatterMapKt.mutableScatterMapOf();
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                    mutableScatterMap = (MutableScatterMap) rememberedValue3;
                    if (!snapshotStateList.contains(transition.getCurrentState())) {
                    }
                    if (Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
                    }
                    if (!Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
                    }
                    if (!mutableScatterMap.containsKey(transition.getTargetState())) {
                    }
                    startRestartGroup.startReplaceGroup(912931457);
                    mutableScatterMap.clear();
                    size = snapshotStateList.size();
                    i11 = 0;
                    while (i11 < size) {
                    }
                    snapshotStateList2 = snapshotStateList;
                    animatedContentTransitionScopeImpl2 = animatedContentTransitionScopeImpl;
                    function15 = function13;
                    startRestartGroup.endReplaceGroup();
                    animatedContentTransitionScopeImpl3 = animatedContentTransitionScopeImpl2;
                    changed = startRestartGroup.changed(transition.getSegment()) | startRestartGroup.changed(animatedContentTransitionScopeImpl3);
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (changed) {
                    }
                    function16 = function15;
                    rememberedValue4 = function16.invoke(animatedContentTransitionScopeImpl3);
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                    Modifier then22 = modifier4.then(animatedContentTransitionScopeImpl3.createSizeAnimationModifier$animation_release((ContentTransform) rememberedValue4, startRestartGroup, 0));
                    rememberedValue5 = startRestartGroup.rememberedValue();
                    if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    }
                    AnimatedContentMeasurePolicy animatedContentMeasurePolicy22 = (AnimatedContentMeasurePolicy) rememberedValue5;
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, then22);
                    ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor22 = companion22.getConstructor();
                    if (startRestartGroup.getApplier() == null) {
                    }
                    startRestartGroup.startReusableNode();
                    if (!startRestartGroup.getInserting()) {
                    }
                    m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                    Updater.m1227setimpl(m1226constructorimpl, animatedContentMeasurePolicy22, companion22.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap22, companion22.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion22.getSetCompositeKeyHash();
                    if (!m1226constructorimpl.getInserting()) {
                    }
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier22, companion22.getSetModifier());
                    startRestartGroup.startReplaceGroup(-1491001814);
                    size2 = snapshotStateList2.size();
                    i12 = 0;
                    while (i12 < size2) {
                    }
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function17 = function16;
                    alignment3 = alignment2;
                    function18 = function14;
                    modifier3 = modifier4;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                alignment2 = alignment;
                i10 = i6 & 8;
                if (i10 == 0) {
                }
                function14 = function12;
                if ((i6 & 16) != 0) {
                }
                if ((74899 & i7) != 74898) {
                }
                if (i15 == 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                int i16222 = i7 & 14;
                if (i16222 != 4) {
                }
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z5) {
                }
                rememberedValue = new AnimatedContentTransitionScopeImpl(transition, alignment2, layoutDirection);
                startRestartGroup.updateRememberedValue(rememberedValue);
                animatedContentTransitionScopeImpl = rememberedValue;
                if (i16222 != 4) {
                }
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!z6) {
                }
                rememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                startRestartGroup.updateRememberedValue(rememberedValue2);
                snapshotStateList = (SnapshotStateList) rememberedValue2;
                if (i16222 != 4) {
                }
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!z7) {
                }
                rememberedValue3 = ScatterMapKt.mutableScatterMapOf();
                startRestartGroup.updateRememberedValue(rememberedValue3);
                mutableScatterMap = (MutableScatterMap) rememberedValue3;
                if (!snapshotStateList.contains(transition.getCurrentState())) {
                }
                if (Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
                }
                if (!Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
                }
                if (!mutableScatterMap.containsKey(transition.getTargetState())) {
                }
                startRestartGroup.startReplaceGroup(912931457);
                mutableScatterMap.clear();
                size = snapshotStateList.size();
                i11 = 0;
                while (i11 < size) {
                }
                snapshotStateList2 = snapshotStateList;
                animatedContentTransitionScopeImpl2 = animatedContentTransitionScopeImpl;
                function15 = function13;
                startRestartGroup.endReplaceGroup();
                animatedContentTransitionScopeImpl3 = animatedContentTransitionScopeImpl2;
                changed = startRestartGroup.changed(transition.getSegment()) | startRestartGroup.changed(animatedContentTransitionScopeImpl3);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (changed) {
                }
                function16 = function15;
                rememberedValue4 = function16.invoke(animatedContentTransitionScopeImpl3);
                startRestartGroup.updateRememberedValue(rememberedValue4);
                Modifier then222 = modifier4.then(animatedContentTransitionScopeImpl3.createSizeAnimationModifier$animation_release((ContentTransform) rememberedValue4, startRestartGroup, 0));
                rememberedValue5 = startRestartGroup.rememberedValue();
                if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                }
                AnimatedContentMeasurePolicy animatedContentMeasurePolicy222 = (AnimatedContentMeasurePolicy) rememberedValue5;
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, then222);
                ComposeUiNode.Companion companion222 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor222 = companion222.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (!startRestartGroup.getInserting()) {
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, animatedContentMeasurePolicy222, companion222.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap222, companion222.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = companion222.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting()) {
                }
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash222);
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier222, companion222.getSetModifier());
                startRestartGroup.startReplaceGroup(-1491001814);
                size2 = snapshotStateList2.size();
                i12 = 0;
                while (i12 < size2) {
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                }
                function17 = function16;
                alignment3 = alignment2;
                function18 = function14;
                modifier3 = modifier4;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            function13 = function1;
            i9 = i6 & 4;
            if (i9 != 0) {
            }
            alignment2 = alignment;
            i10 = i6 & 8;
            if (i10 == 0) {
            }
            function14 = function12;
            if ((i6 & 16) != 0) {
            }
            if ((74899 & i7) != 74898) {
            }
            if (i15 == 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            int i162222 = i7 & 14;
            if (i162222 != 4) {
            }
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z5) {
            }
            rememberedValue = new AnimatedContentTransitionScopeImpl(transition, alignment2, layoutDirection);
            startRestartGroup.updateRememberedValue(rememberedValue);
            animatedContentTransitionScopeImpl = rememberedValue;
            if (i162222 != 4) {
            }
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!z6) {
            }
            rememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
            startRestartGroup.updateRememberedValue(rememberedValue2);
            snapshotStateList = (SnapshotStateList) rememberedValue2;
            if (i162222 != 4) {
            }
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!z7) {
            }
            rememberedValue3 = ScatterMapKt.mutableScatterMapOf();
            startRestartGroup.updateRememberedValue(rememberedValue3);
            mutableScatterMap = (MutableScatterMap) rememberedValue3;
            if (!snapshotStateList.contains(transition.getCurrentState())) {
            }
            if (Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
            }
            if (!Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
            }
            if (!mutableScatterMap.containsKey(transition.getTargetState())) {
            }
            startRestartGroup.startReplaceGroup(912931457);
            mutableScatterMap.clear();
            size = snapshotStateList.size();
            i11 = 0;
            while (i11 < size) {
            }
            snapshotStateList2 = snapshotStateList;
            animatedContentTransitionScopeImpl2 = animatedContentTransitionScopeImpl;
            function15 = function13;
            startRestartGroup.endReplaceGroup();
            animatedContentTransitionScopeImpl3 = animatedContentTransitionScopeImpl2;
            changed = startRestartGroup.changed(transition.getSegment()) | startRestartGroup.changed(animatedContentTransitionScopeImpl3);
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed) {
            }
            function16 = function15;
            rememberedValue4 = function16.invoke(animatedContentTransitionScopeImpl3);
            startRestartGroup.updateRememberedValue(rememberedValue4);
            Modifier then2222 = modifier4.then(animatedContentTransitionScopeImpl3.createSizeAnimationModifier$animation_release((ContentTransform) rememberedValue4, startRestartGroup, 0));
            rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
            }
            AnimatedContentMeasurePolicy animatedContentMeasurePolicy2222 = (AnimatedContentMeasurePolicy) rememberedValue5;
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2222 = ComposedModifierKt.materializeModifier(startRestartGroup, then2222);
            ComposeUiNode.Companion companion2222 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor2222 = companion2222.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (!startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, animatedContentMeasurePolicy2222, companion2222.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2222, companion2222.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2222 = companion2222.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2222);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier2222, companion2222.getSetModifier());
            startRestartGroup.startReplaceGroup(-1491001814);
            size2 = snapshotStateList2.size();
            i12 = 0;
            while (i12 < size2) {
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            function17 = function16;
            alignment3 = alignment2;
            function18 = function14;
            modifier3 = modifier4;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 2;
        if (i8 == 0) {
        }
        function13 = function1;
        i9 = i6 & 4;
        if (i9 != 0) {
        }
        alignment2 = alignment;
        i10 = i6 & 8;
        if (i10 == 0) {
        }
        function14 = function12;
        if ((i6 & 16) != 0) {
        }
        if ((74899 & i7) != 74898) {
        }
        if (i15 == 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        int i1622222 = i7 & 14;
        if (i1622222 != 4) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z5) {
        }
        rememberedValue = new AnimatedContentTransitionScopeImpl(transition, alignment2, layoutDirection);
        startRestartGroup.updateRememberedValue(rememberedValue);
        animatedContentTransitionScopeImpl = rememberedValue;
        if (i1622222 != 4) {
        }
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!z6) {
        }
        rememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
        startRestartGroup.updateRememberedValue(rememberedValue2);
        snapshotStateList = (SnapshotStateList) rememberedValue2;
        if (i1622222 != 4) {
        }
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!z7) {
        }
        rememberedValue3 = ScatterMapKt.mutableScatterMapOf();
        startRestartGroup.updateRememberedValue(rememberedValue3);
        mutableScatterMap = (MutableScatterMap) rememberedValue3;
        if (!snapshotStateList.contains(transition.getCurrentState())) {
        }
        if (Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
        }
        if (!Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
        }
        if (!mutableScatterMap.containsKey(transition.getTargetState())) {
        }
        startRestartGroup.startReplaceGroup(912931457);
        mutableScatterMap.clear();
        size = snapshotStateList.size();
        i11 = 0;
        while (i11 < size) {
        }
        snapshotStateList2 = snapshotStateList;
        animatedContentTransitionScopeImpl2 = animatedContentTransitionScopeImpl;
        function15 = function13;
        startRestartGroup.endReplaceGroup();
        animatedContentTransitionScopeImpl3 = animatedContentTransitionScopeImpl2;
        changed = startRestartGroup.changed(transition.getSegment()) | startRestartGroup.changed(animatedContentTransitionScopeImpl3);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (changed) {
        }
        function16 = function15;
        rememberedValue4 = function16.invoke(animatedContentTransitionScopeImpl3);
        startRestartGroup.updateRememberedValue(rememberedValue4);
        Modifier then22222 = modifier4.then(animatedContentTransitionScopeImpl3.createSizeAnimationModifier$animation_release((ContentTransform) rememberedValue4, startRestartGroup, 0));
        rememberedValue5 = startRestartGroup.rememberedValue();
        if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
        }
        AnimatedContentMeasurePolicy animatedContentMeasurePolicy22222 = (AnimatedContentMeasurePolicy) rememberedValue5;
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap22222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier22222 = ComposedModifierKt.materializeModifier(startRestartGroup, then22222);
        ComposeUiNode.Companion companion22222 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor22222 = companion22222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (!startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, animatedContentMeasurePolicy22222, companion22222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap22222, companion22222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22222 = companion22222.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22222);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier22222, companion22222.getSetModifier());
        startRestartGroup.startReplaceGroup(-1491001814);
        size2 = snapshotStateList2.size();
        i12 = 0;
        while (i12 < size2) {
        }
        startRestartGroup.endReplaceGroup();
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        function17 = function16;
        alignment3 = alignment2;
        function18 = function14;
        modifier3 = modifier4;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
