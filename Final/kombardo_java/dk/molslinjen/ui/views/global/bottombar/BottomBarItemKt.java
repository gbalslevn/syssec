package dk.molslinjen.ui.views.global.bottombar;

import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.BadgeKt;
import androidx.compose.material3.NavigationBarItemDefaults;
import androidx.compose.material3.NavigationBarKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.LottieAnimationKt;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.airbnb.lottie.compose.LottieCompositionSpec;
import com.airbnb.lottie.compose.RememberLottieCompositionKt;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.global.bottombar.BottomBarItemKt;
import dk.molslinjen.ui.views.reusable.NoRippleCompositionProviderKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aK\u0010\f\u001a\u00020\n*\u00020\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0002\b\u0003\u0018\u00010\u0001j\u0004\u0018\u0001`\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010²\u0006\u000e\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/foundation/layout/RowScope;", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Lcom/ramcosta/composedestinations/spec/DestinationSpec;", "selectedDestination", "Ldk/molslinjen/ui/views/global/bottombar/BottomBarButtonConfiguration;", "buttonConfig", "Landroidx/compose/runtime/MutableState;", BuildConfig.FLAVOR, "textHeight", "Lkotlin/Function0;", BuildConfig.FLAVOR, "action", "BottomBarItem", "(Landroidx/compose/foundation/layout/RowScope;Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;Ldk/molslinjen/ui/views/global/bottombar/BottomBarButtonConfiguration;Landroidx/compose/runtime/MutableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Lcom/airbnb/lottie/LottieComposition;", "lottieComposition", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BottomBarItemKt {
    public static final void BottomBarItem(final RowScope rowScope, final TypedDestinationSpec<?> typedDestinationSpec, final BottomBarButtonConfiguration buttonConfig, final MutableState<Integer> textHeight, final Function0<Unit> action, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(rowScope, "<this>");
        Intrinsics.checkNotNullParameter(buttonConfig, "buttonConfig");
        Intrinsics.checkNotNullParameter(textHeight, "textHeight");
        Intrinsics.checkNotNullParameter(action, "action");
        Composer startRestartGroup = composer.startRestartGroup(1807183177);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(rowScope) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(typedDestinationSpec) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(buttonConfig) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(textHeight) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(action) ? 16384 : 8192;
        }
        if ((i6 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1807183177, i6, -1, "dk.molslinjen.ui.views.global.bottombar.BottomBarItem (BottomBarItem.kt:42)");
            }
            final String stringResource = StringResources_androidKt.stringResource(buttonConfig.getTitleRes(), startRestartGroup, 0);
            final StateFlow<Integer> badge = buttonConfig.getBadge();
            final boolean areEqual = Intrinsics.areEqual(buttonConfig.getDestination(), typedDestinationSpec);
            final LottieCompositionResult rememberLottieComposition = RememberLottieCompositionKt.rememberLottieComposition(LottieCompositionSpec.RawRes.m2761boximpl(LottieCompositionSpec.RawRes.m2762constructorimpl(buttonConfig.getLottieRes())), null, null, null, null, null, startRestartGroup, 0, 62);
            composer2 = startRestartGroup;
            NoRippleCompositionProviderKt.NoRippleCompositionProvider(ComposableLambdaKt.rememberComposableLambda(-1179568534, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.bottombar.BottomBarItemKt$BottomBarItem$1

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                /* renamed from: dk.molslinjen.ui.views.global.bottombar.BottomBarItemKt$BottomBarItem$1$2, reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass2 implements Function2<Composer, Integer, Unit> {
                    final /* synthetic */ MutableState<Integer> $textHeight;
                    final /* synthetic */ String $title;

                    AnonymousClass2(MutableState<Integer> mutableState, String str) {
                        this.$textHeight = mutableState;
                        this.$title = str;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$1$lambda$0(MutableState mutableState, LayoutCoordinates it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (IntSize.m2660getHeightimpl(it.mo1948getSizeYbymL2g()) > ((Number) mutableState.getValue()).intValue()) {
                            mutableState.setValue(Integer.valueOf(IntSize.m2660getHeightimpl(it.mo1948getSizeYbymL2g())));
                        }
                        return Unit.INSTANCE;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i5) {
                        TextStyle m2295copyp1EtxEg;
                        if ((i5 & 3) == 2 && composer.getSkipping()) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(640937900, i5, -1, "dk.molslinjen.ui.views.global.bottombar.BottomBarItem.<anonymous>.<anonymous> (BottomBarItem.kt:83)");
                        }
                        Modifier.Companion companion = Modifier.INSTANCE;
                        composer.startReplaceGroup(-112787034);
                        boolean changed = composer.changed(this.$textHeight);
                        final MutableState<Integer> mutableState = this.$textHeight;
                        Object rememberedValue = composer.rememberedValue();
                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = 
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0046: CONSTRUCTOR (r4v1 'rememberedValue' java.lang.Object) = (r3v1 'mutableState' androidx.compose.runtime.MutableState<java.lang.Integer> A[DONT_INLINE]) A[MD:(androidx.compose.runtime.MutableState):void (m)] (LINE:9) call: dk.molslinjen.ui.views.global.bottombar.a.<init>(androidx.compose.runtime.MutableState):void type: CONSTRUCTOR in method: dk.molslinjen.ui.views.global.bottombar.BottomBarItemKt$BottomBarItem$1.2.invoke(androidx.compose.runtime.Composer, int):void, file: classes2.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: dk.molslinjen.ui.views.global.bottombar.a, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	... 25 more
                                */
                            /*
                                Method dump skipped, instructions count: 251
                                To view this dump add '--comments-level debug' option
                            */
                            throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.ui.views.global.bottombar.BottomBarItemKt$BottomBarItem$1.AnonymousClass2.invoke(androidx.compose.runtime.Composer, int):void");
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i7) {
                        if ((i7 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1179568534, i7, -1, "dk.molslinjen.ui.views.global.bottombar.BottomBarItem.<anonymous> (BottomBarItem.kt:50)");
                        }
                        RowScope rowScope2 = RowScope.this;
                        final boolean z5 = areEqual;
                        Function0<Unit> function0 = action;
                        final StateFlow<Integer> stateFlow = badge;
                        final LottieCompositionResult lottieCompositionResult = rememberLottieComposition;
                        ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1953293297, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.bottombar.BottomBarItemKt$BottomBarItem$1.1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i8) {
                                if ((i8 & 3) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1953293297, i8, -1, "dk.molslinjen.ui.views.global.bottombar.BottomBarItem.<anonymous>.<anonymous> (BottomBarItem.kt:54)");
                                }
                                final StateFlow<Integer> stateFlow2 = stateFlow;
                                ComposableLambda rememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1260836729, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.bottombar.BottomBarItemKt.BottomBarItem.1.1.1
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer5, Integer num) {
                                        invoke(boxScope, composer5, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(BoxScope BadgedBox, Composer composer5, int i9) {
                                        int i10;
                                        Intrinsics.checkNotNullParameter(BadgedBox, "$this$BadgedBox");
                                        if ((i9 & 6) == 0) {
                                            i10 = (composer5.changed(BadgedBox) ? 4 : 2) | i9;
                                        } else {
                                            i10 = i9;
                                        }
                                        if ((i10 & 19) == 18 && composer5.getSkipping()) {
                                            composer5.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1260836729, i10, -1, "dk.molslinjen.ui.views.global.bottombar.BottomBarItem.<anonymous>.<anonymous>.<anonymous> (BottomBarItem.kt:56)");
                                        }
                                        final int intValue = ((Number) SnapshotStateKt.collectAsState(stateFlow2, null, composer5, 0, 1).getValue()).intValue();
                                        if (intValue > 0) {
                                            Modifier m294offsetVpY3zN4 = OffsetKt.m294offsetVpY3zN4(Modifier.INSTANCE, Dp.m2599constructorimpl(-8), Dp.m2599constructorimpl(10));
                                            float f5 = 2;
                                            float m2599constructorimpl = Dp.m2599constructorimpl(f5);
                                            AppColor appColor = AppColor.INSTANCE;
                                            BadgeKt.m775BadgeeopBjH0(BadgedBox.align(PaddingKt.m311padding3ABfNKs(BorderKt.m108borderxT4_qwU(m294offsetVpY3zN4, m2599constructorimpl, appColor.m3281getWhite0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.m2599constructorimpl(f5)), Alignment.INSTANCE.getCenter()), appColor.m3255getBrandBlue10d7_KjU(), 0L, ComposableLambdaKt.rememberComposableLambda(368467007, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.bottombar.BottomBarItemKt.BottomBarItem.1.1.1.1
                                                @Override // kotlin.jvm.functions.Function3
                                                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope3, Composer composer6, Integer num) {
                                                    invoke(rowScope3, composer6, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(RowScope Badge, Composer composer6, int i11) {
                                                    Intrinsics.checkNotNullParameter(Badge, "$this$Badge");
                                                    if ((i11 & 17) == 16 && composer6.getSkipping()) {
                                                        composer6.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(368467007, i11, -1, "dk.molslinjen.ui.views.global.bottombar.BottomBarItem.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BottomBarItem.kt:66)");
                                                    }
                                                    TextKt.m940Text4IGK_g(String.valueOf(intValue), null, AppColor.INSTANCE.m3281getWhite0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer6, 384, 0, 131066);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }, composer5, 54), composer5, 3120, 4);
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer4, 54);
                                final boolean z6 = z5;
                                final LottieCompositionResult lottieCompositionResult2 = lottieCompositionResult;
                                BadgeKt.BadgedBox(rememberComposableLambda2, null, ComposableLambdaKt.rememberComposableLambda(-106445303, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.bottombar.BottomBarItemKt.BottomBarItem.1.1.2
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer5, Integer num) {
                                        invoke(boxScope, composer5, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(BoxScope BadgedBox, Composer composer5, int i9) {
                                        LottieComposition BottomBarItem$lambda$0;
                                        Intrinsics.checkNotNullParameter(BadgedBox, "$this$BadgedBox");
                                        if ((i9 & 17) == 16 && composer5.getSkipping()) {
                                            composer5.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-106445303, i9, -1, "dk.molslinjen.ui.views.global.bottombar.BottomBarItem.<anonymous>.<anonymous>.<anonymous> (BottomBarItem.kt:74)");
                                        }
                                        BottomBarItem$lambda$0 = BottomBarItemKt.BottomBarItem$lambda$0(lottieCompositionResult2);
                                        LottieAnimationKt.LottieAnimation(BottomBarItem$lambda$0, SizeKt.m331size3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(31)), false, false, null, z6 ? 2.0f : -2.0f, 0, false, false, false, null, false, false, null, null, null, false, null, composer5, 48, 0, 262108);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer4, 54), composer4, 390, 2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer3, 54);
                        ComposableLambda rememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(640937900, true, new AnonymousClass2(textHeight, stringResource), composer3, 54);
                        NavigationBarItemDefaults navigationBarItemDefaults = NavigationBarItemDefaults.INSTANCE;
                        AppColor appColor = AppColor.INSTANCE;
                        NavigationBarKt.NavigationBarItem(rowScope2, z5, function0, rememberComposableLambda, null, false, rememberComposableLambda2, false, navigationBarItemDefaults.m872colors69fazGs(0L, appColor.m3255getBrandBlue10d7_KjU(), appColor.m3281getWhite0d7_KjU(), 0L, appColor.m3264getGrey10d7_KjU(), 0L, 0L, composer3, (NavigationBarItemDefaults.$stable << 21) | 25008, 105), null, composer3, 1575936, 344);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer2, 54), composer2, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new Function2() { // from class: Q1.a
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit BottomBarItem$lambda$1;
                        BottomBarItem$lambda$1 = BottomBarItemKt.BottomBarItem$lambda$1(RowScope.this, typedDestinationSpec, buttonConfig, textHeight, action, i5, (Composer) obj, ((Integer) obj2).intValue());
                        return BottomBarItem$lambda$1;
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final LottieComposition BottomBarItem$lambda$0(LottieCompositionResult lottieCompositionResult) {
            return lottieCompositionResult.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit BottomBarItem$lambda$1(RowScope rowScope, TypedDestinationSpec typedDestinationSpec, BottomBarButtonConfiguration bottomBarButtonConfiguration, MutableState mutableState, Function0 function0, int i5, Composer composer, int i6) {
            BottomBarItem(rowScope, typedDestinationSpec, bottomBarButtonConfiguration, mutableState, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
            return Unit.INSTANCE;
        }
    }
