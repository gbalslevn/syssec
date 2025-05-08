package dk.molslinjen.ui.views.screens.profile.contact;

import android.content.Context;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.core.helpers.ExternalActionHelper;
import dk.molslinjen.domain.model.config.SiteSupportInfo;
import dk.molslinjen.domain.model.site.SiteInfo;
import dk.molslinjen.extensions.SiteInfoExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.reusable.input.dropdown.DropdownItem;
import dk.molslinjen.ui.views.reusable.input.dropdown.DropdownPickerKt;
import dk.molslinjen.ui.views.screens.profile.contact.ContactScreenKt;
import dk.molslinjen.ui.views.screens.profile.contact.ContactScreenViewModel;
import java.util.ArrayList;
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
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a[\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000bH\u0003¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/contact/ContactScreenViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "ContactScreen", "(Ldk/molslinjen/ui/views/screens/profile/contact/ContactScreenViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/domain/model/site/SiteInfo;", "selectedSite", BuildConfig.FLAVOR, "sites", "Lkotlin/Function1;", "onSiteSelected", "Lkotlin/Function0;", "onEmailCopied", BuildConfig.FLAVOR, "call", "ContactScreenContent", "(Ldk/molslinjen/domain/model/site/SiteInfo;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ContactScreenKt {
    public static final void ContactScreen(final ContactScreenViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(493782446);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(493782446, i6, -1, "dk.molslinjen.ui.views.screens.profile.contact.ContactScreen (ContactScreen.kt:41)");
            }
            ContactScreenViewModel.ViewState viewState = (ContactScreenViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            final SiteInfo selectedSite = viewState.getSelectedSite();
            final List<SiteInfo> sites = viewState.getSites();
            final boolean isLoading = viewState.getIsLoading();
            ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
            final Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Modifier verticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), rememberScrollState, false, null, false, 14, null);
            String stringResource = StringResources_androidKt.stringResource(R.string.profile_contactTitle, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(-555245109);
            int i7 = i6 & 112;
            boolean z5 = i7 == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new ContactScreenKt$ContactScreen$1$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function0 function0 = (Function0) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-555243541);
            boolean z6 = i7 == 32;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new ContactScreenKt$ContactScreen$2$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(verticalScroll$default, 0.0f, stringResource, null, 0L, function0, (Function0) rememberedValue2, rememberScrollState, null, ComposableLambdaKt.rememberComposableLambda(-1279203397, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.contact.ContactScreenKt$ContactScreen$3

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                /* renamed from: dk.molslinjen.ui.views.screens.profile.contact.ContactScreenKt$ContactScreen$3$1, reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
                    final /* synthetic */ Context $context;
                    final /* synthetic */ SiteInfo $selectedSite;
                    final /* synthetic */ List<SiteInfo> $sites;
                    final /* synthetic */ ContactScreenViewModel $viewModel;

                    AnonymousClass1(SiteInfo siteInfo, List<SiteInfo> list, ContactScreenViewModel contactScreenViewModel, Context context) {
                        this.$selectedSite = siteInfo;
                        this.$sites = list;
                        this.$viewModel = contactScreenViewModel;
                        this.$context = context;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$3$lambda$2(Context context, ContactScreenViewModel contactScreenViewModel, String phoneNumber) {
                        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
                        ExternalActionHelper.INSTANCE.openDialer(context, phoneNumber);
                        contactScreenViewModel.trackCall();
                        return Unit.INSTANCE;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i5) {
                        List<SiteInfo> list;
                        if ((i5 & 3) == 2 && composer.getSkipping()) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-54009081, i5, -1, "dk.molslinjen.ui.views.screens.profile.contact.ContactScreen.<anonymous>.<anonymous> (ContactScreen.kt:64)");
                        }
                        SiteInfo siteInfo = this.$selectedSite;
                        if (siteInfo != null && (list = this.$sites) != null) {
                            ContactScreenViewModel contactScreenViewModel = this.$viewModel;
                            composer.startReplaceGroup(-956867157);
                            boolean changedInstance = composer.changedInstance(contactScreenViewModel);
                            Object rememberedValue = composer.rememberedValue();
                            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = new ContactScreenKt$ContactScreen$3$1$1$1(contactScreenViewModel);
                                composer.updateRememberedValue(rememberedValue);
                            }
                            composer.endReplaceGroup();
                            Function1 function1 = (Function1) ((KFunction) rememberedValue);
                            ContactScreenViewModel contactScreenViewModel2 = this.$viewModel;
                            composer.startReplaceGroup(-956865142);
                            boolean changedInstance2 = composer.changedInstance(contactScreenViewModel2);
                            Object rememberedValue2 = composer.rememberedValue();
                            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = new ContactScreenKt$ContactScreen$3$1$2$1(contactScreenViewModel2);
                                composer.updateRememberedValue(rememberedValue2);
                            }
                            composer.endReplaceGroup();
                            Function0 function0 = (Function0) ((KFunction) rememberedValue2);
                            composer.startReplaceGroup(-956863308);
                            boolean changedInstance3 = composer.changedInstance(this.$context) | composer.changedInstance(this.$viewModel);
                            final Context context = this.$context;
                            final ContactScreenViewModel contactScreenViewModel3 = this.$viewModel;
                            Object rememberedValue3 = composer.rememberedValue();
                            if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = 
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a3: CONSTRUCTOR (r2v1 'rememberedValue3' java.lang.Object) = 
                                      (r0v8 'context' android.content.Context A[DONT_INLINE])
                                      (r1v9 'contactScreenViewModel3' dk.molslinjen.ui.views.screens.profile.contact.ContactScreenViewModel A[DONT_INLINE])
                                     A[MD:(android.content.Context, dk.molslinjen.ui.views.screens.profile.contact.ContactScreenViewModel):void (m)] (LINE:20) call: dk.molslinjen.ui.views.screens.profile.contact.a.<init>(android.content.Context, dk.molslinjen.ui.views.screens.profile.contact.ContactScreenViewModel):void type: CONSTRUCTOR in method: dk.molslinjen.ui.views.screens.profile.contact.ContactScreenKt$ContactScreen$3.1.invoke(androidx.compose.runtime.Composer, int):void, file: classes2.dex
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
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: dk.molslinjen.ui.views.screens.profile.contact.a, state: NOT_LOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                    	... 31 more
                                    */
                                /*
                                    this = this;
                                    r0 = r12 & 3
                                    r1 = 2
                                    if (r0 != r1) goto L11
                                    boolean r0 = r11.getSkipping()
                                    if (r0 != 0) goto Lc
                                    goto L11
                                Lc:
                                    r11.skipToGroupEnd()
                                    goto Lbd
                                L11:
                                    boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                    if (r0 == 0) goto L20
                                    r0 = -1
                                    java.lang.String r1 = "dk.molslinjen.ui.views.screens.profile.contact.ContactScreen.<anonymous>.<anonymous> (ContactScreen.kt:64)"
                                    r2 = -54009081(0xfffffffffcc7e307, float:-8.302974E36)
                                    androidx.compose.runtime.ComposerKt.traceEventStart(r2, r12, r0, r1)
                                L20:
                                    dk.molslinjen.domain.model.site.SiteInfo r3 = r10.$selectedSite
                                    if (r3 == 0) goto Lb4
                                    java.util.List<dk.molslinjen.domain.model.site.SiteInfo> r4 = r10.$sites
                                    if (r4 == 0) goto Lb4
                                    dk.molslinjen.ui.views.screens.profile.contact.ContactScreenViewModel r12 = r10.$viewModel
                                    r0 = -956867157(0xffffffffc6f75dab, float:-31662.834)
                                    r11.startReplaceGroup(r0)
                                    boolean r0 = r11.changedInstance(r12)
                                    java.lang.Object r1 = r11.rememberedValue()
                                    if (r0 != 0) goto L42
                                    androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.INSTANCE
                                    java.lang.Object r0 = r0.getEmpty()
                                    if (r1 != r0) goto L4a
                                L42:
                                    dk.molslinjen.ui.views.screens.profile.contact.ContactScreenKt$ContactScreen$3$1$1$1 r1 = new dk.molslinjen.ui.views.screens.profile.contact.ContactScreenKt$ContactScreen$3$1$1$1
                                    r1.<init>(r12)
                                    r11.updateRememberedValue(r1)
                                L4a:
                                    kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
                                    r11.endReplaceGroup()
                                    r5 = r1
                                    kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
                                    dk.molslinjen.ui.views.screens.profile.contact.ContactScreenViewModel r12 = r10.$viewModel
                                    r0 = -956865142(0xffffffffc6f7658a, float:-31666.77)
                                    r11.startReplaceGroup(r0)
                                    boolean r0 = r11.changedInstance(r12)
                                    java.lang.Object r1 = r11.rememberedValue()
                                    if (r0 != 0) goto L6c
                                    androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.INSTANCE
                                    java.lang.Object r0 = r0.getEmpty()
                                    if (r1 != r0) goto L74
                                L6c:
                                    dk.molslinjen.ui.views.screens.profile.contact.ContactScreenKt$ContactScreen$3$1$2$1 r1 = new dk.molslinjen.ui.views.screens.profile.contact.ContactScreenKt$ContactScreen$3$1$2$1
                                    r1.<init>(r12)
                                    r11.updateRememberedValue(r1)
                                L74:
                                    kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
                                    r11.endReplaceGroup()
                                    r6 = r1
                                    kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
                                    r12 = -956863308(0xffffffffc6f76cb4, float:-31670.352)
                                    r11.startReplaceGroup(r12)
                                    android.content.Context r12 = r10.$context
                                    boolean r12 = r11.changedInstance(r12)
                                    dk.molslinjen.ui.views.screens.profile.contact.ContactScreenViewModel r0 = r10.$viewModel
                                    boolean r0 = r11.changedInstance(r0)
                                    r12 = r12 | r0
                                    android.content.Context r0 = r10.$context
                                    dk.molslinjen.ui.views.screens.profile.contact.ContactScreenViewModel r1 = r10.$viewModel
                                    java.lang.Object r2 = r11.rememberedValue()
                                    if (r12 != 0) goto La1
                                    androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.INSTANCE
                                    java.lang.Object r12 = r12.getEmpty()
                                    if (r2 != r12) goto La9
                                La1:
                                    dk.molslinjen.ui.views.screens.profile.contact.a r2 = new dk.molslinjen.ui.views.screens.profile.contact.a
                                    r2.<init>(r0, r1)
                                    r11.updateRememberedValue(r2)
                                La9:
                                    r7 = r2
                                    kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
                                    r11.endReplaceGroup()
                                    r9 = 0
                                    r8 = r11
                                    dk.molslinjen.ui.views.screens.profile.contact.ContactScreenKt.access$ContactScreenContent(r3, r4, r5, r6, r7, r8, r9)
                                Lb4:
                                    boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                    if (r11 == 0) goto Lbd
                                    androidx.compose.runtime.ComposerKt.traceEventEnd()
                                Lbd:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.ui.views.screens.profile.contact.ContactScreenKt$ContactScreen$3.AnonymousClass1.invoke(androidx.compose.runtime.Composer, int):void");
                            }
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                            invoke(columnScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ColumnScope BottomSheetContainer, Composer composer3, int i8) {
                            Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
                            if ((i8 & 17) == 16 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1279203397, i8, -1, "dk.molslinjen.ui.views.screens.profile.contact.ContactScreen.<anonymous> (ContactScreen.kt:60)");
                            }
                            boolean z7 = isLoading;
                            SiteInfo siteInfo = selectedSite;
                            LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, 0.0f, z7, 0, siteInfo == null || sites == null, null, ComposableLambdaKt.rememberComposableLambda(-54009081, true, new AnonymousClass1(siteInfo, sites, viewModel, context), composer3, 54), composer3, 1572864, 43);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), composer2, 805306368, 282);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: H3.j
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit ContactScreen$lambda$3;
                            ContactScreen$lambda$3 = ContactScreenKt.ContactScreen$lambda$3(ContactScreenViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return ContactScreen$lambda$3;
                        }
                    });
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit ContactScreen$lambda$3(ContactScreenViewModel contactScreenViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
                ContactScreen(contactScreenViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void ContactScreenContent(final SiteInfo siteInfo, final List<SiteInfo> list, final Function1<? super SiteInfo, Unit> function1, final Function0<Unit> function0, final Function1<? super String, Unit> function12, Composer composer, final int i5) {
                int i6;
                int i7;
                float f5;
                Unit unit;
                int i8;
                String supportEmail;
                Composer startRestartGroup = composer.startRestartGroup(-1746771276);
                if ((i5 & 6) == 0) {
                    i6 = (startRestartGroup.changedInstance(siteInfo) ? 4 : 2) | i5;
                } else {
                    i6 = i5;
                }
                if ((i5 & 48) == 0) {
                    i6 |= startRestartGroup.changedInstance(list) ? 32 : 16;
                }
                if ((i5 & 384) == 0) {
                    i6 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
                }
                if ((i5 & 3072) == 0) {
                    i6 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
                }
                if ((i5 & 24576) == 0) {
                    i6 |= startRestartGroup.changedInstance(function12) ? 16384 : 8192;
                }
                int i9 = i6;
                if ((i9 & 9363) == 9362 && startRestartGroup.getSkipping()) {
                    startRestartGroup.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1746771276, i9, -1, "dk.molslinjen.ui.views.screens.profile.contact.ContactScreenContent (ContactScreen.kt:87)");
                    }
                    SiteSupportInfo supportInfo = siteInfo.getSupportInfo();
                    float f6 = 24;
                    Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m2599constructorimpl(f6), 0.0f, 2, null);
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default);
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
                    Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                    if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    startRestartGroup.startReplaceGroup(-1433251381);
                    if (list.size() > 1) {
                        DropdownItem<SiteInfo> dropdownItem = SiteInfoExtensionsKt.toDropdownItem(siteInfo);
                        List<SiteInfo> list2 = list;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                        Iterator<T> it = list2.iterator();
                        while (it.hasNext()) {
                            arrayList.add(SiteInfoExtensionsKt.toDropdownItem((SiteInfo) it.next()));
                        }
                        startRestartGroup.startReplaceGroup(-1433244988);
                        boolean z5 = (i9 & 896) == 256;
                        Object rememberedValue = startRestartGroup.rememberedValue();
                        if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new Function1() { // from class: H3.k
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    Unit ContactScreenContent$lambda$12$lambda$6$lambda$5;
                                    ContactScreenContent$lambda$12$lambda$6$lambda$5 = ContactScreenKt.ContactScreenContent$lambda$12$lambda$6$lambda$5(Function1.this, (DropdownItem) obj);
                                    return ContactScreenContent$lambda$12$lambda$6$lambda$5;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        startRestartGroup.endReplaceGroup();
                        i7 = i9;
                        DropdownPickerKt.DropdownPicker(dropdownItem, arrayList, (Function1) rememberedValue, null, startRestartGroup, 0, 8);
                    } else {
                        i7 = i9;
                    }
                    startRestartGroup.endReplaceGroup();
                    String zendeskUrl = supportInfo.getContactInfo().getZendeskUrl();
                    startRestartGroup.startReplaceGroup(-1433240591);
                    if (zendeskUrl == null) {
                        unit = null;
                        f5 = 0.0f;
                    } else {
                        f5 = 0.0f;
                        ContactZendeskKt.ContactZendesk(SizeKt.fillMaxWidth$default(PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(f6), 0.0f, 0.0f, 13, null), 0.0f, 1, null), zendeskUrl, startRestartGroup, 6, 0);
                        unit = Unit.INSTANCE;
                    }
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(-1433241419);
                    if (unit == null && (supportEmail = supportInfo.getContactInfo().getSupportEmail()) != null) {
                        ContactEmailKt.ContactEmail(SizeKt.fillMaxWidth$default(PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(f6), 0.0f, 0.0f, 13, null), f5, 1, null), function0, supportEmail, startRestartGroup, ((i7 >> 6) & 112) | 6, 0);
                    }
                    startRestartGroup.endReplaceGroup();
                    String supportPhoneNumber = supportInfo.getContactInfo().getSupportPhoneNumber();
                    startRestartGroup.startReplaceGroup(-1433223035);
                    if (supportPhoneNumber != null) {
                        ContactPhoneKt.ContactPhone(PaddingKt.m315paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, f5, 1, null), 0.0f, Dp.m2599constructorimpl(f6), 0.0f, 0.0f, 13, null), supportPhoneNumber, supportInfo.getOpeningHours(), function12, startRestartGroup, ((i7 >> 3) & 7168) | 6, 0);
                    }
                    startRestartGroup.endReplaceGroup();
                    String lostAndFoundPageUrl = supportInfo.getLostAndFoundPageUrl();
                    startRestartGroup.startReplaceGroup(-1433212530);
                    if (lostAndFoundPageUrl != null) {
                        ContactLostPropertyKt.ContactLostProperty(SizeKt.fillMaxWidth$default(PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(48), 0.0f, 0.0f, 13, null), f5, 1, null), lostAndFoundPageUrl, startRestartGroup, 6, 0);
                    }
                    startRestartGroup.endReplaceGroup();
                    String suggestionsAndComplaintsPageUrl = supportInfo.getSuggestionsAndComplaintsPageUrl();
                    startRestartGroup.startReplaceGroup(-1433204310);
                    if (suggestionsAndComplaintsPageUrl == null) {
                        i8 = 6;
                    } else {
                        i8 = 6;
                        ContactFeedbackKt.ContactFeedback(SizeKt.fillMaxWidth$default(PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(32), 0.0f, 0.0f, 13, null), f5, 1, null), suggestionsAndComplaintsPageUrl, startRestartGroup, 6, 0);
                    }
                    startRestartGroup.endReplaceGroup();
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(64)), startRestartGroup, i8);
                    startRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: H3.l
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit ContactScreenContent$lambda$13;
                            ContactScreenContent$lambda$13 = ContactScreenKt.ContactScreenContent$lambda$13(SiteInfo.this, list, function1, function0, function12, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return ContactScreenContent$lambda$13;
                        }
                    });
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit ContactScreenContent$lambda$12$lambda$6$lambda$5(Function1 function1, DropdownItem it) {
                Intrinsics.checkNotNullParameter(it, "it");
                function1.invoke(it.getValue());
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit ContactScreenContent$lambda$13(SiteInfo siteInfo, List list, Function1 function1, Function0 function0, Function1 function12, int i5, Composer composer, int i6) {
                ContactScreenContent(siteInfo, list, function1, function0, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                return Unit.INSTANCE;
            }
        }
