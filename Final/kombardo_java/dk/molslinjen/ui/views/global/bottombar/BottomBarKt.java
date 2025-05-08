package dk.molslinjen.ui.views.global.bottombar;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.NavigationBarKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.PopUpToBuilder;
import androidx.navigation.compose.NavHostControllerKt;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.global.bottombar.BottomBarKt;
import dk.molslinjen.ui.views.global.bottombar.BottomBarViewModel;
import dk.molslinjen.ui.views.reusable.NoRippleCompositionProviderKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001aA\u0010\u0007\u001a\u00020\u00012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00052\u001a\u0010\u000b\u001a\u0016\u0012\f\u0012\n\u0012\u0002\b\u00030\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u00010\fH\u0003¢\u0006\u0002\u0010\u000f\u001a+\u0010\u0010\u001a\u000e\u0012\u0002\b\u0003\u0018\u00010\rj\u0004\u0018\u0001`\u000e*\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0003¢\u0006\u0002\u0010\u0012\u001a\u0014\u0010\u0013\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002¨\u0006\u0018"}, d2 = {"BottomBar", BuildConfig.FLAVOR, "viewModel", "Ldk/molslinjen/ui/views/global/bottombar/BottomBarViewModel;", "navController", "Landroidx/navigation/NavController;", "(Ldk/molslinjen/ui/views/global/bottombar/BottomBarViewModel;Landroidx/navigation/NavController;Landroidx/compose/runtime/Composer;I)V", "CustomMaterialBottomBarContent", "buttons", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/global/bottombar/BottomBarButtonConfiguration;", "trackChangeTab", "Lkotlin/Function1;", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Lcom/ramcosta/composedestinations/spec/DestinationSpec;", "(Ljava/util/List;Landroidx/navigation/NavController;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "getSelectedRoute", "bottomBarButtons", "(Landroidx/navigation/NavController;Ljava/util/List;Landroidx/compose/runtime/Composer;I)Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "startsWithRoute", BuildConfig.FLAVOR, "Landroidx/navigation/NavBackStackEntry;", "baseRoute", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BottomBarKt {
    public static final void BottomBar(final BottomBarViewModel viewModel, final NavController navController, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Composer startRestartGroup = composer.startRestartGroup(200811052);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(navController) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(200811052, i6, -1, "dk.molslinjen.ui.views.global.bottombar.BottomBar (BottomBar.kt:18)");
            }
            State collectAsState = SnapshotStateKt.collectAsState(viewModel.getStateConfig(), null, startRestartGroup, 0, 1);
            if (((BottomBarConfiguration) collectAsState.getValue()).getIsVisible()) {
                List<BottomBarButtonConfiguration> buttons = ((BottomBarConfiguration) collectAsState.getValue()).getButtons();
                startRestartGroup.startReplaceGroup(1515682158);
                boolean changedInstance = startRestartGroup.changedInstance(viewModel);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new BottomBarKt$BottomBar$1$1(viewModel);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                CustomMaterialBottomBarContent(buttons, navController, (Function1) ((KFunction) rememberedValue), startRestartGroup, i6 & 112);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: Q1.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit BottomBar$lambda$1;
                    BottomBar$lambda$1 = BottomBarKt.BottomBar$lambda$1(BottomBarViewModel.this, navController, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return BottomBar$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBar$lambda$1(BottomBarViewModel bottomBarViewModel, NavController navController, int i5, Composer composer, int i6) {
        BottomBar(bottomBarViewModel, navController, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r1v11, types: [T, androidx.compose.runtime.MutableState] */
    private static final void CustomMaterialBottomBarContent(final List<BottomBarButtonConfiguration> list, final NavController navController, final Function1<? super TypedDestinationSpec<?>, Unit> function1, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(1951430490);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(list) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(navController) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1951430490, i6, -1, "dk.molslinjen.ui.views.global.bottombar.CustomMaterialBottomBarContent (BottomBar.kt:35)");
            }
            startRestartGroup.startReplaceGroup(954618342);
            final TypedDestinationSpec<?> selectedRoute = list == null ? null : getSelectedRoute(navController, list, startRestartGroup, (i6 >> 3) & 14);
            startRestartGroup.endReplaceGroup();
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            startRestartGroup.startReplaceGroup(954620378);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            ref$ObjectRef.element = (MutableState) rememberedValue;
            NoRippleCompositionProviderKt.NoRippleCompositionProvider(ComposableLambdaKt.rememberComposableLambda(-1992641157, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.bottombar.BottomBarKt$CustomMaterialBottomBarContent$1

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                /* renamed from: dk.molslinjen.ui.views.global.bottombar.BottomBarKt$CustomMaterialBottomBarContent$1$1, reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass1 implements Function3<RowScope, Composer, Integer, Unit> {
                    final /* synthetic */ List<BottomBarButtonConfiguration> $buttons;
                    final /* synthetic */ NavController $navController;
                    final /* synthetic */ TypedDestinationSpec<?> $selectedRoute;
                    final /* synthetic */ Ref$ObjectRef<MutableState<Integer>> $textHeight;
                    final /* synthetic */ Function1<TypedDestinationSpec<?>, Unit> $trackChangeTab;

                    /* JADX WARN: Multi-variable type inference failed */
                    AnonymousClass1(List<BottomBarButtonConfiguration> list, TypedDestinationSpec<?> typedDestinationSpec, Ref$ObjectRef<MutableState<Integer>> ref$ObjectRef, Function1<? super TypedDestinationSpec<?>, Unit> function1, NavController navController) {
                        this.$buttons = list;
                        this.$selectedRoute = typedDestinationSpec;
                        this.$textHeight = ref$ObjectRef;
                        this.$trackChangeTab = function1;
                        this.$navController = navController;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$4$lambda$3$lambda$2(final BottomBarButtonConfiguration bottomBarButtonConfiguration, TypedDestinationSpec typedDestinationSpec, Function1 function1, NavController navController) {
                        if (Intrinsics.areEqual(bottomBarButtonConfiguration.getDestination(), typedDestinationSpec)) {
                            return Unit.INSTANCE;
                        }
                        function1.invoke(bottomBarButtonConfiguration.getDestination());
                        navController.navigate(bottomBarButtonConfiguration.getDestination().getRoute(), 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0021: INVOKE 
                              (r4v0 'navController' androidx.navigation.NavController)
                              (wrap:java.lang.String:0x0018: INVOKE 
                              (wrap:com.ramcosta.composedestinations.spec.TypedDestinationSpec<?>:0x0014: INVOKE (r1v0 'bottomBarButtonConfiguration' dk.molslinjen.ui.views.global.bottombar.BottomBarButtonConfiguration) VIRTUAL call: dk.molslinjen.ui.views.global.bottombar.BottomBarButtonConfiguration.getDestination():com.ramcosta.composedestinations.spec.TypedDestinationSpec A[MD:():com.ramcosta.composedestinations.spec.TypedDestinationSpec<?> (m), WRAPPED])
                             INTERFACE call: com.ramcosta.composedestinations.spec.TypedRoute.getRoute():java.lang.String A[MD:():java.lang.String (m), WRAPPED])
                              (wrap:kotlin.jvm.functions.Function1<? super androidx.navigation.NavOptionsBuilder, kotlin.Unit>:0x001e: CONSTRUCTOR 
                              (r1v0 'bottomBarButtonConfiguration' dk.molslinjen.ui.views.global.bottombar.BottomBarButtonConfiguration A[DONT_INLINE])
                             A[MD:(dk.molslinjen.ui.views.global.bottombar.BottomBarButtonConfiguration):void (m), WRAPPED] call: dk.molslinjen.ui.views.global.bottombar.c.<init>(dk.molslinjen.ui.views.global.bottombar.BottomBarButtonConfiguration):void type: CONSTRUCTOR)
                             VIRTUAL call: androidx.navigation.NavController.navigate(java.lang.String, kotlin.jvm.functions.Function1):void A[MD:(java.lang.String, kotlin.jvm.functions.Function1<? super androidx.navigation.NavOptionsBuilder, kotlin.Unit>):void (m)] in method: dk.molslinjen.ui.views.global.bottombar.BottomBarKt$CustomMaterialBottomBarContent$1.1.invoke$lambda$4$lambda$3$lambda$2(dk.molslinjen.ui.views.global.bottombar.BottomBarButtonConfiguration, com.ramcosta.composedestinations.spec.TypedDestinationSpec, kotlin.jvm.functions.Function1, androidx.navigation.NavController):kotlin.Unit, file: classes2.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
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
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: dk.molslinjen.ui.views.global.bottombar.c, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                            	... 19 more
                            */
                        /*
                            com.ramcosta.composedestinations.spec.TypedDestinationSpec r0 = r1.getDestination()
                            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
                            if (r2 == 0) goto Ld
                            kotlin.Unit r1 = kotlin.Unit.INSTANCE
                            return r1
                        Ld:
                            com.ramcosta.composedestinations.spec.TypedDestinationSpec r2 = r1.getDestination()
                            r3.invoke(r2)
                            com.ramcosta.composedestinations.spec.TypedDestinationSpec r2 = r1.getDestination()
                            java.lang.String r2 = r2.getRoute()
                            dk.molslinjen.ui.views.global.bottombar.c r3 = new dk.molslinjen.ui.views.global.bottombar.c
                            r3.<init>(r1)
                            r4.navigate(r2, r3)
                            kotlin.Unit r1 = kotlin.Unit.INSTANCE
                            return r1
                        */
                        throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.ui.views.global.bottombar.BottomBarKt$CustomMaterialBottomBarContent$1.AnonymousClass1.invoke$lambda$4$lambda$3$lambda$2(dk.molslinjen.ui.views.global.bottombar.BottomBarButtonConfiguration, com.ramcosta.composedestinations.spec.TypedDestinationSpec, kotlin.jvm.functions.Function1, androidx.navigation.NavController):kotlin.Unit");
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$4$lambda$3$lambda$2$lambda$1(BottomBarButtonConfiguration bottomBarButtonConfiguration, NavOptionsBuilder navigate) {
                        Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
                        navigate.popUpTo(bottomBarButtonConfiguration.getDestination().getRoute(), 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE 
                              (r2v0 'navigate' androidx.navigation.NavOptionsBuilder)
                              (wrap:java.lang.String:0x0009: INVOKE 
                              (wrap:com.ramcosta.composedestinations.spec.TypedDestinationSpec<?>:0x0005: INVOKE (r1v0 'bottomBarButtonConfiguration' dk.molslinjen.ui.views.global.bottombar.BottomBarButtonConfiguration) VIRTUAL call: dk.molslinjen.ui.views.global.bottombar.BottomBarButtonConfiguration.getDestination():com.ramcosta.composedestinations.spec.TypedDestinationSpec A[MD:():com.ramcosta.composedestinations.spec.TypedDestinationSpec<?> (m), WRAPPED])
                             INTERFACE call: com.ramcosta.composedestinations.spec.TypedRoute.getRoute():java.lang.String A[MD:():java.lang.String (m), WRAPPED])
                              (wrap:kotlin.jvm.functions.Function1<? super androidx.navigation.PopUpToBuilder, kotlin.Unit>:0x000f: CONSTRUCTOR  A[MD:():void (m), WRAPPED] call: dk.molslinjen.ui.views.global.bottombar.d.<init>():void type: CONSTRUCTOR)
                             VIRTUAL call: androidx.navigation.NavOptionsBuilder.popUpTo(java.lang.String, kotlin.jvm.functions.Function1):void A[MD:(java.lang.String, kotlin.jvm.functions.Function1<? super androidx.navigation.PopUpToBuilder, kotlin.Unit>):void (m)] in method: dk.molslinjen.ui.views.global.bottombar.BottomBarKt$CustomMaterialBottomBarContent$1.1.invoke$lambda$4$lambda$3$lambda$2$lambda$1(dk.molslinjen.ui.views.global.bottombar.BottomBarButtonConfiguration, androidx.navigation.NavOptionsBuilder):kotlin.Unit, file: classes2.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
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
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: dk.molslinjen.ui.views.global.bottombar.d, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                            	... 15 more
                            */
                        /*
                            java.lang.String r0 = "$this$navigate"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                            com.ramcosta.composedestinations.spec.TypedDestinationSpec r1 = r1.getDestination()
                            java.lang.String r1 = r1.getRoute()
                            dk.molslinjen.ui.views.global.bottombar.d r0 = new dk.molslinjen.ui.views.global.bottombar.d
                            r0.<init>()
                            r2.popUpTo(r1, r0)
                            r1 = 1
                            r2.setLaunchSingleTop(r1)
                            kotlin.Unit r1 = kotlin.Unit.INSTANCE
                            return r1
                        */
                        throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.ui.views.global.bottombar.BottomBarKt$CustomMaterialBottomBarContent$1.AnonymousClass1.invoke$lambda$4$lambda$3$lambda$2$lambda$1(dk.molslinjen.ui.views.global.bottombar.BottomBarButtonConfiguration, androidx.navigation.NavOptionsBuilder):kotlin.Unit");
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$4$lambda$3$lambda$2$lambda$1$lambda$0(PopUpToBuilder popUpTo) {
                        Intrinsics.checkNotNullParameter(popUpTo, "$this$popUpTo");
                        popUpTo.setSaveState(true);
                        return Unit.INSTANCE;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                        invoke(rowScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope NavigationBar, Composer composer, int i5) {
                        Intrinsics.checkNotNullParameter(NavigationBar, "$this$NavigationBar");
                        if ((i5 & 6) == 0) {
                            i5 |= composer.changed(NavigationBar) ? 4 : 2;
                        }
                        if ((i5 & 19) == 18 && composer.getSkipping()) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1287373794, i5, -1, "dk.molslinjen.ui.views.global.bottombar.CustomMaterialBottomBarContent.<anonymous>.<anonymous> (BottomBar.kt:46)");
                        }
                        List<BottomBarButtonConfiguration> list = this.$buttons;
                        if (list != null) {
                            final TypedDestinationSpec<?> typedDestinationSpec = this.$selectedRoute;
                            Ref$ObjectRef<MutableState<Integer>> ref$ObjectRef = this.$textHeight;
                            final Function1<TypedDestinationSpec<?>, Unit> function1 = this.$trackChangeTab;
                            final NavController navController = this.$navController;
                            for (final BottomBarButtonConfiguration bottomBarButtonConfiguration : list) {
                                MutableState<Integer> mutableState = ref$ObjectRef.element;
                                composer.startReplaceGroup(-1483229171);
                                boolean changedInstance = composer.changedInstance(bottomBarButtonConfiguration) | composer.changedInstance(typedDestinationSpec) | composer.changed(function1) | composer.changedInstance(navController);
                                Object rememberedValue = composer.rememberedValue();
                                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = 
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0082: CONSTRUCTOR (r2v4 'rememberedValue' java.lang.Object) = 
                                          (r3v1 'bottomBarButtonConfiguration' dk.molslinjen.ui.views.global.bottombar.BottomBarButtonConfiguration A[DONT_INLINE])
                                          (r8v0 'typedDestinationSpec' com.ramcosta.composedestinations.spec.TypedDestinationSpec<?> A[DONT_INLINE])
                                          (r10v0 'function1' kotlin.jvm.functions.Function1<com.ramcosta.composedestinations.spec.TypedDestinationSpec<?>, kotlin.Unit> A[DONT_INLINE])
                                          (r11v0 'navController' androidx.navigation.NavController A[DONT_INLINE])
                                         A[MD:(dk.molslinjen.ui.views.global.bottombar.BottomBarButtonConfiguration, com.ramcosta.composedestinations.spec.TypedDestinationSpec, kotlin.jvm.functions.Function1, androidx.navigation.NavController):void (m)] (LINE:9) call: dk.molslinjen.ui.views.global.bottombar.b.<init>(dk.molslinjen.ui.views.global.bottombar.BottomBarButtonConfiguration, com.ramcosta.composedestinations.spec.TypedDestinationSpec, kotlin.jvm.functions.Function1, androidx.navigation.NavController):void type: CONSTRUCTOR in method: dk.molslinjen.ui.views.global.bottombar.BottomBarKt$CustomMaterialBottomBarContent$1.1.invoke(androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, int):void, file: classes2.dex
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
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:207)
                                        	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:171)
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
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: dk.molslinjen.ui.views.global.bottombar.b, state: NOT_LOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                        	... 37 more
                                        */
                                    /*
                                        this = this;
                                        java.lang.String r0 = "$this$NavigationBar"
                                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
                                        r0 = r15 & 6
                                        if (r0 != 0) goto L13
                                        boolean r0 = r14.changed(r13)
                                        if (r0 == 0) goto L11
                                        r0 = 4
                                        goto L12
                                    L11:
                                        r0 = 2
                                    L12:
                                        r15 = r15 | r0
                                    L13:
                                        r0 = r15 & 19
                                        r1 = 18
                                        if (r0 != r1) goto L25
                                        boolean r0 = r14.getSkipping()
                                        if (r0 != 0) goto L20
                                        goto L25
                                    L20:
                                        r14.skipToGroupEnd()
                                        goto La0
                                    L25:
                                        boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                        if (r0 == 0) goto L34
                                        r0 = -1
                                        java.lang.String r1 = "dk.molslinjen.ui.views.global.bottombar.CustomMaterialBottomBarContent.<anonymous>.<anonymous> (BottomBar.kt:46)"
                                        r2 = 1287373794(0x4cbbc3e2, float:9.844302E7)
                                        androidx.compose.runtime.ComposerKt.traceEventStart(r2, r15, r0, r1)
                                    L34:
                                        java.util.List<dk.molslinjen.ui.views.global.bottombar.BottomBarButtonConfiguration> r0 = r12.$buttons
                                        if (r0 != 0) goto L39
                                        goto L97
                                    L39:
                                        java.lang.Iterable r0 = (java.lang.Iterable) r0
                                        com.ramcosta.composedestinations.spec.TypedDestinationSpec<?> r8 = r12.$selectedRoute
                                        kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.runtime.MutableState<java.lang.Integer>> r9 = r12.$textHeight
                                        kotlin.jvm.functions.Function1<com.ramcosta.composedestinations.spec.TypedDestinationSpec<?>, kotlin.Unit> r10 = r12.$trackChangeTab
                                        androidx.navigation.NavController r11 = r12.$navController
                                        java.util.Iterator r0 = r0.iterator()
                                    L47:
                                        boolean r1 = r0.hasNext()
                                        if (r1 == 0) goto L97
                                        java.lang.Object r1 = r0.next()
                                        r3 = r1
                                        dk.molslinjen.ui.views.global.bottombar.BottomBarButtonConfiguration r3 = (dk.molslinjen.ui.views.global.bottombar.BottomBarButtonConfiguration) r3
                                        T r1 = r9.element
                                        r4 = r1
                                        androidx.compose.runtime.MutableState r4 = (androidx.compose.runtime.MutableState) r4
                                        r1 = -1483229171(0xffffffffa797b80d, float:-4.2110467E-15)
                                        r14.startReplaceGroup(r1)
                                        boolean r1 = r14.changedInstance(r3)
                                        boolean r2 = r14.changedInstance(r8)
                                        r1 = r1 | r2
                                        boolean r2 = r14.changed(r10)
                                        r1 = r1 | r2
                                        boolean r2 = r14.changedInstance(r11)
                                        r1 = r1 | r2
                                        java.lang.Object r2 = r14.rememberedValue()
                                        if (r1 != 0) goto L80
                                        androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.INSTANCE
                                        java.lang.Object r1 = r1.getEmpty()
                                        if (r2 != r1) goto L88
                                    L80:
                                        dk.molslinjen.ui.views.global.bottombar.b r2 = new dk.molslinjen.ui.views.global.bottombar.b
                                        r2.<init>(r3, r8, r10, r11)
                                        r14.updateRememberedValue(r2)
                                    L88:
                                        r5 = r2
                                        kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
                                        r14.endReplaceGroup()
                                        r7 = r15 & 14
                                        r1 = r13
                                        r2 = r8
                                        r6 = r14
                                        dk.molslinjen.ui.views.global.bottombar.BottomBarItemKt.BottomBarItem(r1, r2, r3, r4, r5, r6, r7)
                                        goto L47
                                    L97:
                                        boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                        if (r13 == 0) goto La0
                                        androidx.compose.runtime.ComposerKt.traceEventEnd()
                                    La0:
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.ui.views.global.bottombar.BottomBarKt$CustomMaterialBottomBarContent$1.AnonymousClass1.invoke(androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, int):void");
                                }
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i7) {
                                if ((i7 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1992641157, i7, -1, "dk.molslinjen.ui.views.global.bottombar.CustomMaterialBottomBarContent.<anonymous> (BottomBar.kt:40)");
                                }
                                NavigationBarKt.m873NavigationBarHsRjFd4(ModifierExtensionsKt.topShadow(Modifier.INSTANCE), AppColor.INSTANCE.m3281getWhite0d7_KjU(), 0L, Dp.m2599constructorimpl(0), null, ComposableLambdaKt.rememberComposableLambda(1287373794, true, new AnonymousClass1(list, selectedRoute, ref$ObjectRef, function1, navController), composer2, 54), composer2, 199728, 20);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, startRestartGroup, 54), startRestartGroup, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.updateScope(new Function2() { // from class: Q1.c
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit CustomMaterialBottomBarContent$lambda$4;
                                CustomMaterialBottomBarContent$lambda$4 = BottomBarKt.CustomMaterialBottomBarContent$lambda$4(list, navController, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                                return CustomMaterialBottomBarContent$lambda$4;
                            }
                        });
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit CustomMaterialBottomBarContent$lambda$4(List list, NavController navController, Function1 function1, int i5, Composer composer, int i6) {
                    CustomMaterialBottomBarContent(list, navController, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                    return Unit.INSTANCE;
                }

                private static final TypedDestinationSpec<?> getSelectedRoute(NavController navController, List<BottomBarButtonConfiguration> list, Composer composer, int i5) {
                    Object obj;
                    Object obj2;
                    composer.startReplaceGroup(-738609613);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-738609613, i5, -1, "dk.molslinjen.ui.views.global.bottombar.getSelectedRoute (BottomBar.kt:66)");
                    }
                    NavBackStackEntry value = NavHostControllerKt.currentBackStackEntryAsState(navController, composer, i5 & 14).getValue();
                    List<BottomBarButtonConfiguration> list2 = list;
                    Iterator<T> it = list2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        BottomBarButtonConfiguration bottomBarButtonConfiguration = (BottomBarButtonConfiguration) obj;
                        if (value != null && startsWithRoute(value, bottomBarButtonConfiguration.getDestination().getBaseRoute())) {
                            break;
                        }
                    }
                    BottomBarButtonConfiguration bottomBarButtonConfiguration2 = (BottomBarButtonConfiguration) obj;
                    if (bottomBarButtonConfiguration2 != null) {
                        TypedDestinationSpec<?> destination = bottomBarButtonConfiguration2.getDestination();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer.endReplaceGroup();
                        return destination;
                    }
                    for (NavBackStackEntry navBackStackEntry : CollectionsKt.reversed((Iterable) SnapshotStateKt.collectAsState(navController.getCurrentBackStack(), null, composer, 0, 1).getValue())) {
                        Iterator<T> it2 = list2.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            obj2 = it2.next();
                            if (startsWithRoute(navBackStackEntry, ((BottomBarButtonConfiguration) obj2).getDestination().getBaseRoute())) {
                                break;
                            }
                        }
                        BottomBarButtonConfiguration bottomBarButtonConfiguration3 = (BottomBarButtonConfiguration) obj2;
                        if (bottomBarButtonConfiguration3 != null) {
                            TypedDestinationSpec<?> destination2 = bottomBarButtonConfiguration3.getDestination();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer.endReplaceGroup();
                            return destination2;
                        }
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer.endReplaceGroup();
                    return null;
                }

                private static final boolean startsWithRoute(NavBackStackEntry navBackStackEntry, String str) {
                    String route = navBackStackEntry.getDestination().getRoute();
                    return route != null && StringsKt.indexOf$default((CharSequence) route, str, 0, false, 6, (Object) null) == 0;
                }
            }
