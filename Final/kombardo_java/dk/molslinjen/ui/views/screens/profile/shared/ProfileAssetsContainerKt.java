package dk.molslinjen.ui.views.screens.profile.shared;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt;
import dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aµ\u0001\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0001\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00002\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {BuildConfig.FLAVOR, "screenTitle", "Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData;", "accountCardData", BuildConfig.FLAVOR, "isLoading", "isEmpty", "Lkotlin/Function0;", BuildConfig.FLAVOR, "dismissAction", "backAction", BuildConfig.FLAVOR, "emptyIcon", "emptyDescription", "emptySubDescription", "registerButtonText", "onRegisterButtonClick", "onSignup", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "content", "ProfileAssetsListContainer", "(Ljava/lang/String;Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData;ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ProfileAssetsContainerKt {
    /* JADX WARN: Removed duplicated region for block: B:104:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x014b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ProfileAssetsListContainer(final String screenTitle, AccountCardData accountCardData, final boolean z5, final boolean z6, final Function0<Unit> dismissAction, Function0<Unit> function0, final int i5, final String emptyDescription, String str, String str2, Function0<Unit> function02, Function0<Unit> function03, final Function1<? super LazyListScope, Unit> content, Composer composer, final int i6, final int i7, final int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        Composer composer2;
        final AccountCardData accountCardData2;
        final Function0<Unit> function04;
        final String str3;
        final String str4;
        final Function0<Unit> function05;
        final Function0<Unit> function06;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(screenTitle, "screenTitle");
        Intrinsics.checkNotNullParameter(dismissAction, "dismissAction");
        Intrinsics.checkNotNullParameter(emptyDescription, "emptyDescription");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(-399787212);
        if ((i8 & 1) != 0) {
            i9 = i6 | 6;
        } else if ((i6 & 6) == 0) {
            i9 = (startRestartGroup.changed(screenTitle) ? 4 : 2) | i6;
        } else {
            i9 = i6;
        }
        int i16 = i8 & 2;
        if (i16 != 0) {
            i9 |= 48;
        } else if ((i6 & 48) == 0) {
            i9 |= startRestartGroup.changed(accountCardData) ? 32 : 16;
            if ((i8 & 4) == 0) {
                i9 |= 384;
            } else if ((i6 & 384) == 0) {
                i9 |= startRestartGroup.changed(z5) ? 256 : 128;
                if ((i8 & 8) != 0) {
                    i9 |= 3072;
                } else if ((i6 & 3072) == 0) {
                    i9 |= startRestartGroup.changed(z6) ? 2048 : 1024;
                    if ((i8 & 16) == 0) {
                        i9 |= 24576;
                    } else if ((i6 & 24576) == 0) {
                        i9 |= startRestartGroup.changedInstance(dismissAction) ? 16384 : 8192;
                    }
                    i10 = i8 & 32;
                    if (i10 == 0) {
                        i9 |= 196608;
                    } else if ((i6 & 196608) == 0) {
                        i9 |= startRestartGroup.changedInstance(function0) ? 131072 : 65536;
                    }
                    if ((i8 & 64) == 0) {
                        i9 |= 1572864;
                    } else if ((i6 & 1572864) == 0) {
                        i9 |= startRestartGroup.changed(i5) ? 1048576 : 524288;
                    }
                    if ((i8 & 128) == 0) {
                        i9 |= 12582912;
                    } else if ((i6 & 12582912) == 0) {
                        i9 |= startRestartGroup.changed(emptyDescription) ? 8388608 : 4194304;
                    }
                    i11 = i8 & 256;
                    if (i11 == 0) {
                        i9 |= 100663296;
                    } else if ((i6 & 100663296) == 0) {
                        i9 |= startRestartGroup.changed(str) ? 67108864 : 33554432;
                    }
                    i12 = i8 & 512;
                    if (i12 == 0) {
                        i9 |= 805306368;
                    } else if ((i6 & 805306368) == 0) {
                        i9 |= startRestartGroup.changed(str2) ? 536870912 : 268435456;
                    }
                    i13 = i8 & 1024;
                    if (i13 == 0) {
                        i14 = i7 | 6;
                    } else if ((i7 & 6) == 0) {
                        i14 = i7 | (startRestartGroup.changedInstance(function02) ? 4 : 2);
                    } else {
                        i14 = i7;
                    }
                    i15 = i8 & 2048;
                    if (i15 == 0) {
                        i14 |= 48;
                    } else if ((i7 & 48) == 0) {
                        i14 |= startRestartGroup.changedInstance(function03) ? 32 : 16;
                    }
                    int i17 = i14;
                    if ((i8 & 4096) == 0) {
                        i17 |= 384;
                    } else if ((i7 & 384) == 0) {
                        i17 |= startRestartGroup.changedInstance(content) ? 256 : 128;
                    }
                    if ((306783379 & i9) != 306783378 && (i17 & 147) == 146 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        accountCardData2 = accountCardData;
                        function04 = function0;
                        str3 = str;
                        str4 = str2;
                        function05 = function02;
                        function06 = function03;
                        composer2 = startRestartGroup;
                    } else {
                        AccountCardData accountCardData3 = i16 == 0 ? null : accountCardData;
                        Function0<Unit> function07 = i10 == 0 ? null : function0;
                        String str5 = i11 == 0 ? null : str;
                        String str6 = i12 == 0 ? null : str2;
                        Function0<Unit> function08 = i13 == 0 ? null : function02;
                        Function0<Unit> function09 = i15 == 0 ? null : function03;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-399787212, i9, i17, "dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsListContainer (ProfileAssetsContainer.kt:41)");
                        }
                        final LazyListState rememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
                        int i18 = i9;
                        final String str7 = str5;
                        final String str8 = str6;
                        final Function0<Unit> function010 = function08;
                        final AccountCardData accountCardData4 = accountCardData3;
                        final Function0<Unit> function011 = function09;
                        int i19 = i18 << 6;
                        composer2 = startRestartGroup;
                        BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, screenTitle, null, 0L, function07, dismissAction, rememberLazyListState, null, ComposableLambdaKt.rememberComposableLambda(612404993, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1

                            /* JADX INFO: Access modifiers changed from: package-private */
                            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                            /* renamed from: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1, reason: invalid class name */
                            /* loaded from: classes2.dex */
                            public static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
                                final /* synthetic */ AccountCardData $accountCardData;
                                final /* synthetic */ Function1<LazyListScope, Unit> $content;
                                final /* synthetic */ String $emptyDescription;
                                final /* synthetic */ int $emptyIcon;
                                final /* synthetic */ String $emptySubDescription;
                                final /* synthetic */ boolean $isEmpty;
                                final /* synthetic */ LazyListState $lazyListState;
                                final /* synthetic */ Function0<Unit> $onRegisterButtonClick;
                                final /* synthetic */ Function0<Unit> $onSignup;
                                final /* synthetic */ String $registerButtonText;

                                /* JADX WARN: Multi-variable type inference failed */
                                AnonymousClass1(boolean z5, int i5, String str, String str2, String str3, Function0<Unit> function0, LazyListState lazyListState, AccountCardData accountCardData, Function0<Unit> function02, Function1<? super LazyListScope, Unit> function1) {
                                    this.$isEmpty = z5;
                                    this.$emptyIcon = i5;
                                    this.$emptyDescription = str;
                                    this.$emptySubDescription = str2;
                                    this.$registerButtonText = str3;
                                    this.$onRegisterButtonClick = function0;
                                    this.$lazyListState = lazyListState;
                                    this.$accountCardData = accountCardData;
                                    this.$onSignup = function02;
                                    this.$content = function1;
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public static final Unit invoke$lambda$1$lambda$0(Function1 function1, AccountCardData accountCardData, Function0 function0, final String str, final Function0 function02, LazyListScope LazyColumn) {
                                    Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                    LazyListScope.item$default(LazyColumn, "AccountStateCard", null, ComposableLambdaKt.composableLambdaInstance(-2001337579, true, new ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1$1$1$1(accountCardData, function0)), 2, null);
                                    LazyListScope.item$default(LazyColumn, "RegisterButton", null, ComposableLambdaKt.composableLambdaInstance(907376446, true, 
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002d: INVOKE 
                                          (r12v0 'LazyColumn' androidx.compose.foundation.lazy.LazyListScope)
                                          ("RegisterButton")
                                          (null java.lang.Object)
                                          (wrap:androidx.compose.runtime.internal.ComposableLambda:0x0023: INVOKE 
                                          (907376446 int)
                                          true
                                          (wrap:kotlin.jvm.functions.Function3<androidx.compose.foundation.lazy.LazyItemScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>:0x001d: CONSTRUCTOR (r10v0 'str' java.lang.String A[DONT_INLINE]), (r11v0 'function02' kotlin.jvm.functions.Function0 A[DONT_INLINE]) A[MD:(java.lang.String, kotlin.jvm.functions.Function0<kotlin.Unit>):void (m), WRAPPED] call: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1$1$1$2.<init>(java.lang.String, kotlin.jvm.functions.Function0):void type: CONSTRUCTOR)
                                         STATIC call: androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(int, boolean, java.lang.Object):androidx.compose.runtime.internal.ComposableLambda A[MD:(int, boolean, java.lang.Object):androidx.compose.runtime.internal.ComposableLambda (m), WRAPPED])
                                          (2 int)
                                          (null java.lang.Object)
                                         STATIC call: androidx.compose.foundation.lazy.LazyListScope.item$default(androidx.compose.foundation.lazy.LazyListScope, java.lang.Object, java.lang.Object, kotlin.jvm.functions.Function3, int, java.lang.Object):void A[MD:(androidx.compose.foundation.lazy.LazyListScope, java.lang.Object, java.lang.Object, kotlin.jvm.functions.Function3, int, java.lang.Object):void (m)] in method: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1.1.invoke$lambda$1$lambda$0(kotlin.jvm.functions.Function1, dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData, kotlin.jvm.functions.Function0, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.foundation.lazy.LazyListScope):kotlin.Unit, file: classes2.dex
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
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1$1$1$2, state: NOT_LOADED
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
                                        java.lang.String r0 = "$this$LazyColumn"
                                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
                                        dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1$1$1$1 r0 = new dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1$1$1$1
                                        r0.<init>(r8, r9)
                                        r8 = -2001337579(0xffffffff88b60315, float:-1.0954451E-33)
                                        r9 = 1
                                        androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r8, r9, r0)
                                        r5 = 2
                                        r6 = 0
                                        java.lang.String r2 = "AccountStateCard"
                                        r3 = 0
                                        r1 = r12
                                        androidx.compose.foundation.lazy.LazyListScope.item$default(r1, r2, r3, r4, r5, r6)
                                        dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1$1$1$2 r8 = new dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1$1$1$2
                                        r8.<init>(r10, r11)
                                        r10 = 907376446(0x3615773e, float:2.2272138E-6)
                                        androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r10, r9, r8)
                                        r4 = 2
                                        r5 = 0
                                        java.lang.String r1 = "RegisterButton"
                                        r2 = 0
                                        r0 = r12
                                        androidx.compose.foundation.lazy.LazyListScope.item$default(r0, r1, r2, r3, r4, r5)
                                        r7.invoke(r12)
                                        kotlin.Unit r7 = kotlin.Unit.INSTANCE
                                        return r7
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1.AnonymousClass1.invoke$lambda$1$lambda$0(kotlin.jvm.functions.Function1, dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData, kotlin.jvm.functions.Function0, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.foundation.lazy.LazyListScope):kotlin.Unit");
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                    invoke(composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer, int i5) {
                                    if ((i5 & 3) == 2 && composer.getSkipping()) {
                                        composer.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-356752563, i5, -1, "dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsListContainer.<anonymous>.<anonymous> (ProfileAssetsContainer.kt:52)");
                                    }
                                    if (this.$isEmpty) {
                                        composer.startReplaceGroup(480695779);
                                        ProfileAssetsEmptyViewKt.ProfileItemsEmptyView(this.$emptyIcon, this.$emptyDescription, this.$emptySubDescription, this.$registerButtonText, this.$onRegisterButtonClick, composer, 0, 0);
                                        composer.endReplaceGroup();
                                    } else {
                                        composer.startReplaceGroup(481065485);
                                        LazyListState lazyListState = this.$lazyListState;
                                        composer.startReplaceGroup(-400122157);
                                        boolean changed = composer.changed(this.$accountCardData) | composer.changed(this.$onSignup) | composer.changed(this.$registerButtonText) | composer.changed(this.$onRegisterButtonClick) | composer.changed(this.$content);
                                        final Function1<LazyListScope, Unit> function1 = this.$content;
                                        final AccountCardData accountCardData = this.$accountCardData;
                                        final Function0<Unit> function0 = this.$onSignup;
                                        final String str = this.$registerButtonText;
                                        final Function0<Unit> function02 = this.$onRegisterButtonClick;
                                        Object rememberedValue = composer.rememberedValue();
                                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = 
                                            /*  JADX ERROR: Method code generation error
                                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0089: CONSTRUCTOR (r0v11 'rememberedValue' java.lang.Object) = 
                                                  (r3v0 'function1' kotlin.jvm.functions.Function1<androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> A[DONT_INLINE])
                                                  (r4v0 'accountCardData' dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData A[DONT_INLINE])
                                                  (r5v0 'function0' kotlin.jvm.functions.Function0<kotlin.Unit> A[DONT_INLINE])
                                                  (r6v0 'str' java.lang.String A[DONT_INLINE])
                                                  (r7v0 'function02' kotlin.jvm.functions.Function0<kotlin.Unit> A[DONT_INLINE])
                                                 A[MD:(kotlin.jvm.functions.Function1, dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData, kotlin.jvm.functions.Function0, java.lang.String, kotlin.jvm.functions.Function0):void (m)] (LINE:16) call: dk.molslinjen.ui.views.screens.profile.shared.a.<init>(kotlin.jvm.functions.Function1, dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData, kotlin.jvm.functions.Function0, java.lang.String, kotlin.jvm.functions.Function0):void type: CONSTRUCTOR in method: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1.1.invoke(androidx.compose.runtime.Composer, int):void, file: classes2.dex
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
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
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
                                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: dk.molslinjen.ui.views.screens.profile.shared.a, state: NOT_LOADED
                                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                                	... 31 more
                                                */
                                            /*
                                                this = this;
                                                r0 = r14 & 3
                                                r1 = 2
                                                if (r0 != r1) goto L11
                                                boolean r0 = r13.getSkipping()
                                                if (r0 != 0) goto Lc
                                                goto L11
                                            Lc:
                                                r13.skipToGroupEnd()
                                                goto Laf
                                            L11:
                                                boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                                if (r0 == 0) goto L20
                                                r0 = -1
                                                java.lang.String r1 = "dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsListContainer.<anonymous>.<anonymous> (ProfileAssetsContainer.kt:52)"
                                                r2 = -356752563(0xffffffffeabc634d, float:-1.1387349E26)
                                                androidx.compose.runtime.ComposerKt.traceEventStart(r2, r14, r0, r1)
                                            L20:
                                                boolean r14 = r12.$isEmpty
                                                if (r14 == 0) goto L3e
                                                r14 = 480695779(0x1ca6d5e3, float:1.1040247E-21)
                                                r13.startReplaceGroup(r14)
                                                int r0 = r12.$emptyIcon
                                                java.lang.String r1 = r12.$emptyDescription
                                                java.lang.String r2 = r12.$emptySubDescription
                                                java.lang.String r3 = r12.$registerButtonText
                                                kotlin.jvm.functions.Function0<kotlin.Unit> r4 = r12.$onRegisterButtonClick
                                                r6 = 0
                                                r7 = 0
                                                r5 = r13
                                                dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsEmptyViewKt.ProfileItemsEmptyView(r0, r1, r2, r3, r4, r5, r6, r7)
                                                r13.endReplaceGroup()
                                                goto La6
                                            L3e:
                                                r14 = 481065485(0x1cac7a0d, float:1.1413555E-21)
                                                r13.startReplaceGroup(r14)
                                                androidx.compose.foundation.lazy.LazyListState r1 = r12.$lazyListState
                                                r14 = -400122157(0xffffffffe8269ed3, float:-3.1473705E24)
                                                r13.startReplaceGroup(r14)
                                                dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData r14 = r12.$accountCardData
                                                boolean r14 = r13.changed(r14)
                                                kotlin.jvm.functions.Function0<kotlin.Unit> r0 = r12.$onSignup
                                                boolean r0 = r13.changed(r0)
                                                r14 = r14 | r0
                                                java.lang.String r0 = r12.$registerButtonText
                                                boolean r0 = r13.changed(r0)
                                                r14 = r14 | r0
                                                kotlin.jvm.functions.Function0<kotlin.Unit> r0 = r12.$onRegisterButtonClick
                                                boolean r0 = r13.changed(r0)
                                                r14 = r14 | r0
                                                kotlin.jvm.functions.Function1<androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r0 = r12.$content
                                                boolean r0 = r13.changed(r0)
                                                r14 = r14 | r0
                                                kotlin.jvm.functions.Function1<androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r3 = r12.$content
                                                dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData r4 = r12.$accountCardData
                                                kotlin.jvm.functions.Function0<kotlin.Unit> r5 = r12.$onSignup
                                                java.lang.String r6 = r12.$registerButtonText
                                                kotlin.jvm.functions.Function0<kotlin.Unit> r7 = r12.$onRegisterButtonClick
                                                java.lang.Object r0 = r13.rememberedValue()
                                                if (r14 != 0) goto L86
                                                androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.INSTANCE
                                                java.lang.Object r14 = r14.getEmpty()
                                                if (r0 != r14) goto L8f
                                            L86:
                                                dk.molslinjen.ui.views.screens.profile.shared.a r0 = new dk.molslinjen.ui.views.screens.profile.shared.a
                                                r2 = r0
                                                r2.<init>(r3, r4, r5, r6, r7)
                                                r13.updateRememberedValue(r0)
                                            L8f:
                                                r8 = r0
                                                kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
                                                r13.endReplaceGroup()
                                                r10 = 0
                                                r11 = 253(0xfd, float:3.55E-43)
                                                r0 = 0
                                                r2 = 0
                                                r3 = 0
                                                r4 = 0
                                                r5 = 0
                                                r6 = 0
                                                r7 = 0
                                                r9 = r13
                                                androidx.compose.foundation.lazy.LazyDslKt.LazyColumn(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                                                r13.endReplaceGroup()
                                            La6:
                                                boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                                if (r13 == 0) goto Laf
                                                androidx.compose.runtime.ComposerKt.traceEventEnd()
                                            Laf:
                                                return
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1.AnonymousClass1.invoke(androidx.compose.runtime.Composer, int):void");
                                        }
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                                        invoke(columnScope, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(ColumnScope BottomSheetContainer, Composer composer3, int i20) {
                                        Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
                                        if ((i20 & 17) == 16 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(612404993, i20, -1, "dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsListContainer.<anonymous> (ProfileAssetsContainer.kt:51)");
                                        }
                                        LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, 0.0f, z5, 0, false, null, ComposableLambdaKt.rememberComposableLambda(-356752563, true, new AnonymousClass1(z6, i5, emptyDescription, str7, str8, function010, rememberLazyListState, accountCardData4, function011, content), composer3, 54), composer3, 1572864, 59);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, startRestartGroup, 54), startRestartGroup, (i19 & 896) | 805306374 | (i18 & 458752) | (i19 & 3670016), 282);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                accountCardData2 = accountCardData3;
                                function04 = function07;
                                str3 = str5;
                                str4 = str6;
                                function05 = function08;
                                function06 = function09;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2() { // from class: W3.a
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit ProfileAssetsListContainer$lambda$0;
                                        ProfileAssetsListContainer$lambda$0 = ProfileAssetsContainerKt.ProfileAssetsListContainer$lambda$0(screenTitle, accountCardData2, z5, z6, dismissAction, function04, i5, emptyDescription, str3, str4, function05, function06, content, i6, i7, i8, (Composer) obj, ((Integer) obj2).intValue());
                                        return ProfileAssetsListContainer$lambda$0;
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if ((i8 & 16) == 0) {
                        }
                        i10 = i8 & 32;
                        if (i10 == 0) {
                        }
                        if ((i8 & 64) == 0) {
                        }
                        if ((i8 & 128) == 0) {
                        }
                        i11 = i8 & 256;
                        if (i11 == 0) {
                        }
                        i12 = i8 & 512;
                        if (i12 == 0) {
                        }
                        i13 = i8 & 1024;
                        if (i13 == 0) {
                        }
                        i15 = i8 & 2048;
                        if (i15 == 0) {
                        }
                        int i172 = i14;
                        if ((i8 & 4096) == 0) {
                        }
                        if ((306783379 & i9) != 306783378) {
                        }
                        if (i16 == 0) {
                        }
                        if (i10 == 0) {
                        }
                        if (i11 == 0) {
                        }
                        if (i12 == 0) {
                        }
                        if (i13 == 0) {
                        }
                        if (i15 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final LazyListState rememberLazyListState2 = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
                        int i182 = i9;
                        final String str72 = str5;
                        final String str82 = str6;
                        final Function0<Unit> function0102 = function08;
                        final AccountCardData accountCardData42 = accountCardData3;
                        final Function0<Unit> function0112 = function09;
                        int i192 = i182 << 6;
                        composer2 = startRestartGroup;
                        BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, screenTitle, null, 0L, function07, dismissAction, rememberLazyListState2, null, ComposableLambdaKt.rememberComposableLambda(612404993, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1

                            /* JADX INFO: Access modifiers changed from: package-private */
                            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                            /* renamed from: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1, reason: invalid class name */
                            /* loaded from: classes2.dex */
                            public static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
                                final /* synthetic */ AccountCardData $accountCardData;
                                final /* synthetic */ Function1<LazyListScope, Unit> $content;
                                final /* synthetic */ String $emptyDescription;
                                final /* synthetic */ int $emptyIcon;
                                final /* synthetic */ String $emptySubDescription;
                                final /* synthetic */ boolean $isEmpty;
                                final /* synthetic */ LazyListState $lazyListState;
                                final /* synthetic */ Function0<Unit> $onRegisterButtonClick;
                                final /* synthetic */ Function0<Unit> $onSignup;
                                final /* synthetic */ String $registerButtonText;

                                /* JADX WARN: Multi-variable type inference failed */
                                AnonymousClass1(boolean z5, int i5, String str, String str2, String str3, Function0<Unit> function0, LazyListState lazyListState, AccountCardData accountCardData, Function0<Unit> function02, Function1<? super LazyListScope, Unit> function1) {
                                    this.$isEmpty = z5;
                                    this.$emptyIcon = i5;
                                    this.$emptyDescription = str;
                                    this.$emptySubDescription = str2;
                                    this.$registerButtonText = str3;
                                    this.$onRegisterButtonClick = function0;
                                    this.$lazyListState = lazyListState;
                                    this.$accountCardData = accountCardData;
                                    this.$onSignup = function02;
                                    this.$content = function1;
                                }

                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002d: INVOKE 
                                      (r12v0 'LazyColumn' androidx.compose.foundation.lazy.LazyListScope)
                                      ("RegisterButton")
                                      (null java.lang.Object)
                                      (wrap:androidx.compose.runtime.internal.ComposableLambda:0x0023: INVOKE 
                                      (907376446 int)
                                      true
                                      (wrap:kotlin.jvm.functions.Function3<androidx.compose.foundation.lazy.LazyItemScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>:0x001d: CONSTRUCTOR (r10v0 'str' java.lang.String A[DONT_INLINE]), (r11v0 'function02' kotlin.jvm.functions.Function0 A[DONT_INLINE]) A[MD:(java.lang.String, kotlin.jvm.functions.Function0<kotlin.Unit>):void (m), WRAPPED] call: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1$1$1$2.<init>(java.lang.String, kotlin.jvm.functions.Function0):void type: CONSTRUCTOR)
                                     STATIC call: androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(int, boolean, java.lang.Object):androidx.compose.runtime.internal.ComposableLambda A[MD:(int, boolean, java.lang.Object):androidx.compose.runtime.internal.ComposableLambda (m), WRAPPED])
                                      (2 int)
                                      (null java.lang.Object)
                                     STATIC call: androidx.compose.foundation.lazy.LazyListScope.item$default(androidx.compose.foundation.lazy.LazyListScope, java.lang.Object, java.lang.Object, kotlin.jvm.functions.Function3, int, java.lang.Object):void A[MD:(androidx.compose.foundation.lazy.LazyListScope, java.lang.Object, java.lang.Object, kotlin.jvm.functions.Function3, int, java.lang.Object):void (m)] in method: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1.1.invoke$lambda$1$lambda$0(kotlin.jvm.functions.Function1, dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData, kotlin.jvm.functions.Function0, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.foundation.lazy.LazyListScope):kotlin.Unit, file: classes2.dex
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
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1$1$1$2, state: NOT_LOADED
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
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                    	... 10 more
                                    */
                                public static final kotlin.Unit invoke$lambda$1$lambda$0(kotlin.jvm.functions.Function1 r7, dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData r8, kotlin.jvm.functions.Function0 r9, java.lang.String r10, kotlin.jvm.functions.Function0 r11, androidx.compose.foundation.lazy.LazyListScope r12) {
                                    /*
                                        java.lang.String r0 = "$this$LazyColumn"
                                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
                                        dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1$1$1$1 r0 = new dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1$1$1$1
                                        r0.<init>(r8, r9)
                                        r8 = -2001337579(0xffffffff88b60315, float:-1.0954451E-33)
                                        r9 = 1
                                        androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r8, r9, r0)
                                        r5 = 2
                                        r6 = 0
                                        java.lang.String r2 = "AccountStateCard"
                                        r3 = 0
                                        r1 = r12
                                        androidx.compose.foundation.lazy.LazyListScope.item$default(r1, r2, r3, r4, r5, r6)
                                        dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1$1$1$2 r8 = new dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1$1$1$2
                                        r8.<init>(r10, r11)
                                        r10 = 907376446(0x3615773e, float:2.2272138E-6)
                                        androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r10, r9, r8)
                                        r4 = 2
                                        r5 = 0
                                        java.lang.String r1 = "RegisterButton"
                                        r2 = 0
                                        r0 = r12
                                        androidx.compose.foundation.lazy.LazyListScope.item$default(r0, r1, r2, r3, r4, r5)
                                        r7.invoke(r12)
                                        kotlin.Unit r7 = kotlin.Unit.INSTANCE
                                        return r7
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1.AnonymousClass1.invoke$lambda$1$lambda$0(kotlin.jvm.functions.Function1, dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData, kotlin.jvm.functions.Function0, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.foundation.lazy.LazyListScope):kotlin.Unit");
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                    invoke(composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0089: CONSTRUCTOR (r0v11 'rememberedValue' java.lang.Object) = 
                                      (r3v0 'function1' kotlin.jvm.functions.Function1<androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> A[DONT_INLINE])
                                      (r4v0 'accountCardData' dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData A[DONT_INLINE])
                                      (r5v0 'function0' kotlin.jvm.functions.Function0<kotlin.Unit> A[DONT_INLINE])
                                      (r6v0 'str' java.lang.String A[DONT_INLINE])
                                      (r7v0 'function02' kotlin.jvm.functions.Function0<kotlin.Unit> A[DONT_INLINE])
                                     A[MD:(kotlin.jvm.functions.Function1, dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData, kotlin.jvm.functions.Function0, java.lang.String, kotlin.jvm.functions.Function0):void (m)] (LINE:16) call: dk.molslinjen.ui.views.screens.profile.shared.a.<init>(kotlin.jvm.functions.Function1, dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData, kotlin.jvm.functions.Function0, java.lang.String, kotlin.jvm.functions.Function0):void type: CONSTRUCTOR in method: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1.1.invoke(androidx.compose.runtime.Composer, int):void, file: classes2.dex
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
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
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
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: dk.molslinjen.ui.views.screens.profile.shared.a, state: NOT_LOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                    	... 26 more
                                    */
                                public final void invoke(androidx.compose.runtime.Composer r13, int r14) {
                                    /*
                                        r12 = this;
                                        r0 = r14 & 3
                                        r1 = 2
                                        if (r0 != r1) goto L11
                                        boolean r0 = r13.getSkipping()
                                        if (r0 != 0) goto Lc
                                        goto L11
                                    Lc:
                                        r13.skipToGroupEnd()
                                        goto Laf
                                    L11:
                                        boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                        if (r0 == 0) goto L20
                                        r0 = -1
                                        java.lang.String r1 = "dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsListContainer.<anonymous>.<anonymous> (ProfileAssetsContainer.kt:52)"
                                        r2 = -356752563(0xffffffffeabc634d, float:-1.1387349E26)
                                        androidx.compose.runtime.ComposerKt.traceEventStart(r2, r14, r0, r1)
                                    L20:
                                        boolean r14 = r12.$isEmpty
                                        if (r14 == 0) goto L3e
                                        r14 = 480695779(0x1ca6d5e3, float:1.1040247E-21)
                                        r13.startReplaceGroup(r14)
                                        int r0 = r12.$emptyIcon
                                        java.lang.String r1 = r12.$emptyDescription
                                        java.lang.String r2 = r12.$emptySubDescription
                                        java.lang.String r3 = r12.$registerButtonText
                                        kotlin.jvm.functions.Function0<kotlin.Unit> r4 = r12.$onRegisterButtonClick
                                        r6 = 0
                                        r7 = 0
                                        r5 = r13
                                        dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsEmptyViewKt.ProfileItemsEmptyView(r0, r1, r2, r3, r4, r5, r6, r7)
                                        r13.endReplaceGroup()
                                        goto La6
                                    L3e:
                                        r14 = 481065485(0x1cac7a0d, float:1.1413555E-21)
                                        r13.startReplaceGroup(r14)
                                        androidx.compose.foundation.lazy.LazyListState r1 = r12.$lazyListState
                                        r14 = -400122157(0xffffffffe8269ed3, float:-3.1473705E24)
                                        r13.startReplaceGroup(r14)
                                        dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData r14 = r12.$accountCardData
                                        boolean r14 = r13.changed(r14)
                                        kotlin.jvm.functions.Function0<kotlin.Unit> r0 = r12.$onSignup
                                        boolean r0 = r13.changed(r0)
                                        r14 = r14 | r0
                                        java.lang.String r0 = r12.$registerButtonText
                                        boolean r0 = r13.changed(r0)
                                        r14 = r14 | r0
                                        kotlin.jvm.functions.Function0<kotlin.Unit> r0 = r12.$onRegisterButtonClick
                                        boolean r0 = r13.changed(r0)
                                        r14 = r14 | r0
                                        kotlin.jvm.functions.Function1<androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r0 = r12.$content
                                        boolean r0 = r13.changed(r0)
                                        r14 = r14 | r0
                                        kotlin.jvm.functions.Function1<androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r3 = r12.$content
                                        dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData r4 = r12.$accountCardData
                                        kotlin.jvm.functions.Function0<kotlin.Unit> r5 = r12.$onSignup
                                        java.lang.String r6 = r12.$registerButtonText
                                        kotlin.jvm.functions.Function0<kotlin.Unit> r7 = r12.$onRegisterButtonClick
                                        java.lang.Object r0 = r13.rememberedValue()
                                        if (r14 != 0) goto L86
                                        androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.INSTANCE
                                        java.lang.Object r14 = r14.getEmpty()
                                        if (r0 != r14) goto L8f
                                    L86:
                                        dk.molslinjen.ui.views.screens.profile.shared.a r0 = new dk.molslinjen.ui.views.screens.profile.shared.a
                                        r2 = r0
                                        r2.<init>(r3, r4, r5, r6, r7)
                                        r13.updateRememberedValue(r0)
                                    L8f:
                                        r8 = r0
                                        kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
                                        r13.endReplaceGroup()
                                        r10 = 0
                                        r11 = 253(0xfd, float:3.55E-43)
                                        r0 = 0
                                        r2 = 0
                                        r3 = 0
                                        r4 = 0
                                        r5 = 0
                                        r6 = 0
                                        r7 = 0
                                        r9 = r13
                                        androidx.compose.foundation.lazy.LazyDslKt.LazyColumn(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                                        r13.endReplaceGroup()
                                    La6:
                                        boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                        if (r13 == 0) goto Laf
                                        androidx.compose.runtime.ComposerKt.traceEventEnd()
                                    Laf:
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1.AnonymousClass1.invoke(androidx.compose.runtime.Composer, int):void");
                                }
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                                invoke(columnScope, composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ColumnScope BottomSheetContainer, Composer composer3, int i20) {
                                Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
                                if ((i20 & 17) == 16 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(612404993, i20, -1, "dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsListContainer.<anonymous> (ProfileAssetsContainer.kt:51)");
                                }
                                LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, 0.0f, z5, 0, false, null, ComposableLambdaKt.rememberComposableLambda(-356752563, true, new AnonymousClass1(z6, i5, emptyDescription, str72, str82, function0102, rememberLazyListState2, accountCardData42, function0112, content), composer3, 54), composer3, 1572864, 59);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, startRestartGroup, 54), startRestartGroup, (i192 & 896) | 805306374 | (i182 & 458752) | (i192 & 3670016), 282);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        accountCardData2 = accountCardData3;
                        function04 = function07;
                        str3 = str5;
                        str4 = str6;
                        function05 = function08;
                        function06 = function09;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    if ((i8 & 8) != 0) {
                    }
                    if ((i8 & 16) == 0) {
                    }
                    i10 = i8 & 32;
                    if (i10 == 0) {
                    }
                    if ((i8 & 64) == 0) {
                    }
                    if ((i8 & 128) == 0) {
                    }
                    i11 = i8 & 256;
                    if (i11 == 0) {
                    }
                    i12 = i8 & 512;
                    if (i12 == 0) {
                    }
                    i13 = i8 & 1024;
                    if (i13 == 0) {
                    }
                    i15 = i8 & 2048;
                    if (i15 == 0) {
                    }
                    int i1722 = i14;
                    if ((i8 & 4096) == 0) {
                    }
                    if ((306783379 & i9) != 306783378) {
                    }
                    if (i16 == 0) {
                    }
                    if (i10 == 0) {
                    }
                    if (i11 == 0) {
                    }
                    if (i12 == 0) {
                    }
                    if (i13 == 0) {
                    }
                    if (i15 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final LazyListState rememberLazyListState22 = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
                    int i1822 = i9;
                    final String str722 = str5;
                    final String str822 = str6;
                    final Function0<Unit> function01022 = function08;
                    final AccountCardData accountCardData422 = accountCardData3;
                    final Function0<Unit> function01122 = function09;
                    int i1922 = i1822 << 6;
                    composer2 = startRestartGroup;
                    BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, screenTitle, null, 0L, function07, dismissAction, rememberLazyListState22, null, ComposableLambdaKt.rememberComposableLambda(612404993, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1

                        /* JADX INFO: Access modifiers changed from: package-private */
                        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                        /* renamed from: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1, reason: invalid class name */
                        /* loaded from: classes2.dex */
                        public static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
                            final /* synthetic */ AccountCardData $accountCardData;
                            final /* synthetic */ Function1<LazyListScope, Unit> $content;
                            final /* synthetic */ String $emptyDescription;
                            final /* synthetic */ int $emptyIcon;
                            final /* synthetic */ String $emptySubDescription;
                            final /* synthetic */ boolean $isEmpty;
                            final /* synthetic */ LazyListState $lazyListState;
                            final /* synthetic */ Function0<Unit> $onRegisterButtonClick;
                            final /* synthetic */ Function0<Unit> $onSignup;
                            final /* synthetic */ String $registerButtonText;

                            /* JADX WARN: Multi-variable type inference failed */
                            AnonymousClass1(boolean z5, int i5, String str, String str2, String str3, Function0<Unit> function0, LazyListState lazyListState, AccountCardData accountCardData, Function0<Unit> function02, Function1<? super LazyListScope, Unit> function1) {
                                this.$isEmpty = z5;
                                this.$emptyIcon = i5;
                                this.$emptyDescription = str;
                                this.$emptySubDescription = str2;
                                this.$registerButtonText = str3;
                                this.$onRegisterButtonClick = function0;
                                this.$lazyListState = lazyListState;
                                this.$accountCardData = accountCardData;
                                this.$onSignup = function02;
                                this.$content = function1;
                            }

                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002d: INVOKE 
                                  (r12v0 'LazyColumn' androidx.compose.foundation.lazy.LazyListScope)
                                  ("RegisterButton")
                                  (null java.lang.Object)
                                  (wrap:androidx.compose.runtime.internal.ComposableLambda:0x0023: INVOKE 
                                  (907376446 int)
                                  true
                                  (wrap:kotlin.jvm.functions.Function3<androidx.compose.foundation.lazy.LazyItemScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>:0x001d: CONSTRUCTOR (r10v0 'str' java.lang.String A[DONT_INLINE]), (r11v0 'function02' kotlin.jvm.functions.Function0 A[DONT_INLINE]) A[MD:(java.lang.String, kotlin.jvm.functions.Function0<kotlin.Unit>):void (m), WRAPPED] call: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1$1$1$2.<init>(java.lang.String, kotlin.jvm.functions.Function0):void type: CONSTRUCTOR)
                                 STATIC call: androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(int, boolean, java.lang.Object):androidx.compose.runtime.internal.ComposableLambda A[MD:(int, boolean, java.lang.Object):androidx.compose.runtime.internal.ComposableLambda (m), WRAPPED])
                                  (2 int)
                                  (null java.lang.Object)
                                 STATIC call: androidx.compose.foundation.lazy.LazyListScope.item$default(androidx.compose.foundation.lazy.LazyListScope, java.lang.Object, java.lang.Object, kotlin.jvm.functions.Function3, int, java.lang.Object):void A[MD:(androidx.compose.foundation.lazy.LazyListScope, java.lang.Object, java.lang.Object, kotlin.jvm.functions.Function3, int, java.lang.Object):void (m)] in method: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1.1.invoke$lambda$1$lambda$0(kotlin.jvm.functions.Function1, dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData, kotlin.jvm.functions.Function0, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.foundation.lazy.LazyListScope):kotlin.Unit, file: classes2.dex
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
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1$1$1$2, state: NOT_LOADED
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
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	... 9 more
                                */
                            public static final kotlin.Unit invoke$lambda$1$lambda$0(kotlin.jvm.functions.Function1 r7, dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData r8, kotlin.jvm.functions.Function0 r9, java.lang.String r10, kotlin.jvm.functions.Function0 r11, androidx.compose.foundation.lazy.LazyListScope r12) {
                                /*
                                    java.lang.String r0 = "$this$LazyColumn"
                                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
                                    dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1$1$1$1 r0 = new dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1$1$1$1
                                    r0.<init>(r8, r9)
                                    r8 = -2001337579(0xffffffff88b60315, float:-1.0954451E-33)
                                    r9 = 1
                                    androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r8, r9, r0)
                                    r5 = 2
                                    r6 = 0
                                    java.lang.String r2 = "AccountStateCard"
                                    r3 = 0
                                    r1 = r12
                                    androidx.compose.foundation.lazy.LazyListScope.item$default(r1, r2, r3, r4, r5, r6)
                                    dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1$1$1$2 r8 = new dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1$1$1$2
                                    r8.<init>(r10, r11)
                                    r10 = 907376446(0x3615773e, float:2.2272138E-6)
                                    androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r10, r9, r8)
                                    r4 = 2
                                    r5 = 0
                                    java.lang.String r1 = "RegisterButton"
                                    r2 = 0
                                    r0 = r12
                                    androidx.compose.foundation.lazy.LazyListScope.item$default(r0, r1, r2, r3, r4, r5)
                                    r7.invoke(r12)
                                    kotlin.Unit r7 = kotlin.Unit.INSTANCE
                                    return r7
                                */
                                throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1.AnonymousClass1.invoke$lambda$1$lambda$0(kotlin.jvm.functions.Function1, dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData, kotlin.jvm.functions.Function0, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.foundation.lazy.LazyListScope):kotlin.Unit");
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0089: CONSTRUCTOR (r0v11 'rememberedValue' java.lang.Object) = 
                                  (r3v0 'function1' kotlin.jvm.functions.Function1<androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> A[DONT_INLINE])
                                  (r4v0 'accountCardData' dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData A[DONT_INLINE])
                                  (r5v0 'function0' kotlin.jvm.functions.Function0<kotlin.Unit> A[DONT_INLINE])
                                  (r6v0 'str' java.lang.String A[DONT_INLINE])
                                  (r7v0 'function02' kotlin.jvm.functions.Function0<kotlin.Unit> A[DONT_INLINE])
                                 A[MD:(kotlin.jvm.functions.Function1, dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData, kotlin.jvm.functions.Function0, java.lang.String, kotlin.jvm.functions.Function0):void (m)] (LINE:16) call: dk.molslinjen.ui.views.screens.profile.shared.a.<init>(kotlin.jvm.functions.Function1, dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData, kotlin.jvm.functions.Function0, java.lang.String, kotlin.jvm.functions.Function0):void type: CONSTRUCTOR in method: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1.1.invoke(androidx.compose.runtime.Composer, int):void, file: classes2.dex
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
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
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
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: dk.molslinjen.ui.views.screens.profile.shared.a, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	... 25 more
                                */
                            public final void invoke(androidx.compose.runtime.Composer r13, int r14) {
                                /*
                                    r12 = this;
                                    r0 = r14 & 3
                                    r1 = 2
                                    if (r0 != r1) goto L11
                                    boolean r0 = r13.getSkipping()
                                    if (r0 != 0) goto Lc
                                    goto L11
                                Lc:
                                    r13.skipToGroupEnd()
                                    goto Laf
                                L11:
                                    boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                    if (r0 == 0) goto L20
                                    r0 = -1
                                    java.lang.String r1 = "dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsListContainer.<anonymous>.<anonymous> (ProfileAssetsContainer.kt:52)"
                                    r2 = -356752563(0xffffffffeabc634d, float:-1.1387349E26)
                                    androidx.compose.runtime.ComposerKt.traceEventStart(r2, r14, r0, r1)
                                L20:
                                    boolean r14 = r12.$isEmpty
                                    if (r14 == 0) goto L3e
                                    r14 = 480695779(0x1ca6d5e3, float:1.1040247E-21)
                                    r13.startReplaceGroup(r14)
                                    int r0 = r12.$emptyIcon
                                    java.lang.String r1 = r12.$emptyDescription
                                    java.lang.String r2 = r12.$emptySubDescription
                                    java.lang.String r3 = r12.$registerButtonText
                                    kotlin.jvm.functions.Function0<kotlin.Unit> r4 = r12.$onRegisterButtonClick
                                    r6 = 0
                                    r7 = 0
                                    r5 = r13
                                    dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsEmptyViewKt.ProfileItemsEmptyView(r0, r1, r2, r3, r4, r5, r6, r7)
                                    r13.endReplaceGroup()
                                    goto La6
                                L3e:
                                    r14 = 481065485(0x1cac7a0d, float:1.1413555E-21)
                                    r13.startReplaceGroup(r14)
                                    androidx.compose.foundation.lazy.LazyListState r1 = r12.$lazyListState
                                    r14 = -400122157(0xffffffffe8269ed3, float:-3.1473705E24)
                                    r13.startReplaceGroup(r14)
                                    dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData r14 = r12.$accountCardData
                                    boolean r14 = r13.changed(r14)
                                    kotlin.jvm.functions.Function0<kotlin.Unit> r0 = r12.$onSignup
                                    boolean r0 = r13.changed(r0)
                                    r14 = r14 | r0
                                    java.lang.String r0 = r12.$registerButtonText
                                    boolean r0 = r13.changed(r0)
                                    r14 = r14 | r0
                                    kotlin.jvm.functions.Function0<kotlin.Unit> r0 = r12.$onRegisterButtonClick
                                    boolean r0 = r13.changed(r0)
                                    r14 = r14 | r0
                                    kotlin.jvm.functions.Function1<androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r0 = r12.$content
                                    boolean r0 = r13.changed(r0)
                                    r14 = r14 | r0
                                    kotlin.jvm.functions.Function1<androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r3 = r12.$content
                                    dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData r4 = r12.$accountCardData
                                    kotlin.jvm.functions.Function0<kotlin.Unit> r5 = r12.$onSignup
                                    java.lang.String r6 = r12.$registerButtonText
                                    kotlin.jvm.functions.Function0<kotlin.Unit> r7 = r12.$onRegisterButtonClick
                                    java.lang.Object r0 = r13.rememberedValue()
                                    if (r14 != 0) goto L86
                                    androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.INSTANCE
                                    java.lang.Object r14 = r14.getEmpty()
                                    if (r0 != r14) goto L8f
                                L86:
                                    dk.molslinjen.ui.views.screens.profile.shared.a r0 = new dk.molslinjen.ui.views.screens.profile.shared.a
                                    r2 = r0
                                    r2.<init>(r3, r4, r5, r6, r7)
                                    r13.updateRememberedValue(r0)
                                L8f:
                                    r8 = r0
                                    kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
                                    r13.endReplaceGroup()
                                    r10 = 0
                                    r11 = 253(0xfd, float:3.55E-43)
                                    r0 = 0
                                    r2 = 0
                                    r3 = 0
                                    r4 = 0
                                    r5 = 0
                                    r6 = 0
                                    r7 = 0
                                    r9 = r13
                                    androidx.compose.foundation.lazy.LazyDslKt.LazyColumn(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                                    r13.endReplaceGroup()
                                La6:
                                    boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                    if (r13 == 0) goto Laf
                                    androidx.compose.runtime.ComposerKt.traceEventEnd()
                                Laf:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1.AnonymousClass1.invoke(androidx.compose.runtime.Composer, int):void");
                            }
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                            invoke(columnScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ColumnScope BottomSheetContainer, Composer composer3, int i20) {
                            Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
                            if ((i20 & 17) == 16 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(612404993, i20, -1, "dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsListContainer.<anonymous> (ProfileAssetsContainer.kt:51)");
                            }
                            LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, 0.0f, z5, 0, false, null, ComposableLambdaKt.rememberComposableLambda(-356752563, true, new AnonymousClass1(z6, i5, emptyDescription, str722, str822, function01022, rememberLazyListState22, accountCardData422, function01122, content), composer3, 54), composer3, 1572864, 59);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), startRestartGroup, (i1922 & 896) | 805306374 | (i1822 & 458752) | (i1922 & 3670016), 282);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    accountCardData2 = accountCardData3;
                    function04 = function07;
                    str3 = str5;
                    str4 = str6;
                    function05 = function08;
                    function06 = function09;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                if ((i8 & 4) == 0) {
                }
                if ((i8 & 8) != 0) {
                }
                if ((i8 & 16) == 0) {
                }
                i10 = i8 & 32;
                if (i10 == 0) {
                }
                if ((i8 & 64) == 0) {
                }
                if ((i8 & 128) == 0) {
                }
                i11 = i8 & 256;
                if (i11 == 0) {
                }
                i12 = i8 & 512;
                if (i12 == 0) {
                }
                i13 = i8 & 1024;
                if (i13 == 0) {
                }
                i15 = i8 & 2048;
                if (i15 == 0) {
                }
                int i17222 = i14;
                if ((i8 & 4096) == 0) {
                }
                if ((306783379 & i9) != 306783378) {
                }
                if (i16 == 0) {
                }
                if (i10 == 0) {
                }
                if (i11 == 0) {
                }
                if (i12 == 0) {
                }
                if (i13 == 0) {
                }
                if (i15 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                final LazyListState rememberLazyListState222 = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
                int i18222 = i9;
                final String str7222 = str5;
                final String str8222 = str6;
                final Function0<Unit> function010222 = function08;
                final AccountCardData accountCardData4222 = accountCardData3;
                final Function0<Unit> function011222 = function09;
                int i19222 = i18222 << 6;
                composer2 = startRestartGroup;
                BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, screenTitle, null, 0L, function07, dismissAction, rememberLazyListState222, null, ComposableLambdaKt.rememberComposableLambda(612404993, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1

                    /* JADX INFO: Access modifiers changed from: package-private */
                    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                    /* renamed from: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1, reason: invalid class name */
                    /* loaded from: classes2.dex */
                    public static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
                        final /* synthetic */ AccountCardData $accountCardData;
                        final /* synthetic */ Function1<LazyListScope, Unit> $content;
                        final /* synthetic */ String $emptyDescription;
                        final /* synthetic */ int $emptyIcon;
                        final /* synthetic */ String $emptySubDescription;
                        final /* synthetic */ boolean $isEmpty;
                        final /* synthetic */ LazyListState $lazyListState;
                        final /* synthetic */ Function0<Unit> $onRegisterButtonClick;
                        final /* synthetic */ Function0<Unit> $onSignup;
                        final /* synthetic */ String $registerButtonText;

                        /* JADX WARN: Multi-variable type inference failed */
                        AnonymousClass1(boolean z5, int i5, String str, String str2, String str3, Function0<Unit> function0, LazyListState lazyListState, AccountCardData accountCardData, Function0<Unit> function02, Function1<? super LazyListScope, Unit> function1) {
                            this.$isEmpty = z5;
                            this.$emptyIcon = i5;
                            this.$emptyDescription = str;
                            this.$emptySubDescription = str2;
                            this.$registerButtonText = str3;
                            this.$onRegisterButtonClick = function0;
                            this.$lazyListState = lazyListState;
                            this.$accountCardData = accountCardData;
                            this.$onSignup = function02;
                            this.$content = function1;
                        }

                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002d: INVOKE 
                              (r12v0 'LazyColumn' androidx.compose.foundation.lazy.LazyListScope)
                              ("RegisterButton")
                              (null java.lang.Object)
                              (wrap:androidx.compose.runtime.internal.ComposableLambda:0x0023: INVOKE 
                              (907376446 int)
                              true
                              (wrap:kotlin.jvm.functions.Function3<androidx.compose.foundation.lazy.LazyItemScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>:0x001d: CONSTRUCTOR (r10v0 'str' java.lang.String A[DONT_INLINE]), (r11v0 'function02' kotlin.jvm.functions.Function0 A[DONT_INLINE]) A[MD:(java.lang.String, kotlin.jvm.functions.Function0<kotlin.Unit>):void (m), WRAPPED] call: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1$1$1$2.<init>(java.lang.String, kotlin.jvm.functions.Function0):void type: CONSTRUCTOR)
                             STATIC call: androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(int, boolean, java.lang.Object):androidx.compose.runtime.internal.ComposableLambda A[MD:(int, boolean, java.lang.Object):androidx.compose.runtime.internal.ComposableLambda (m), WRAPPED])
                              (2 int)
                              (null java.lang.Object)
                             STATIC call: androidx.compose.foundation.lazy.LazyListScope.item$default(androidx.compose.foundation.lazy.LazyListScope, java.lang.Object, java.lang.Object, kotlin.jvm.functions.Function3, int, java.lang.Object):void A[MD:(androidx.compose.foundation.lazy.LazyListScope, java.lang.Object, java.lang.Object, kotlin.jvm.functions.Function3, int, java.lang.Object):void (m)] in method: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1.1.invoke$lambda$1$lambda$0(kotlin.jvm.functions.Function1, dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData, kotlin.jvm.functions.Function0, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.foundation.lazy.LazyListScope):kotlin.Unit, file: classes2.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1$1$1$2, state: NOT_LOADED
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
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                            	... 8 more
                            */
                        public static final kotlin.Unit invoke$lambda$1$lambda$0(kotlin.jvm.functions.Function1 r7, dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData r8, kotlin.jvm.functions.Function0 r9, java.lang.String r10, kotlin.jvm.functions.Function0 r11, androidx.compose.foundation.lazy.LazyListScope r12) {
                            /*
                                java.lang.String r0 = "$this$LazyColumn"
                                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
                                dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1$1$1$1 r0 = new dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1$1$1$1
                                r0.<init>(r8, r9)
                                r8 = -2001337579(0xffffffff88b60315, float:-1.0954451E-33)
                                r9 = 1
                                androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r8, r9, r0)
                                r5 = 2
                                r6 = 0
                                java.lang.String r2 = "AccountStateCard"
                                r3 = 0
                                r1 = r12
                                androidx.compose.foundation.lazy.LazyListScope.item$default(r1, r2, r3, r4, r5, r6)
                                dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1$1$1$2 r8 = new dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1$1$1$2
                                r8.<init>(r10, r11)
                                r10 = 907376446(0x3615773e, float:2.2272138E-6)
                                androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r10, r9, r8)
                                r4 = 2
                                r5 = 0
                                java.lang.String r1 = "RegisterButton"
                                r2 = 0
                                r0 = r12
                                androidx.compose.foundation.lazy.LazyListScope.item$default(r0, r1, r2, r3, r4, r5)
                                r7.invoke(r12)
                                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                                return r7
                            */
                            throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1.AnonymousClass1.invoke$lambda$1$lambda$0(kotlin.jvm.functions.Function1, dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData, kotlin.jvm.functions.Function0, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.foundation.lazy.LazyListScope):kotlin.Unit");
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0089: CONSTRUCTOR (r0v11 'rememberedValue' java.lang.Object) = 
                              (r3v0 'function1' kotlin.jvm.functions.Function1<androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> A[DONT_INLINE])
                              (r4v0 'accountCardData' dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData A[DONT_INLINE])
                              (r5v0 'function0' kotlin.jvm.functions.Function0<kotlin.Unit> A[DONT_INLINE])
                              (r6v0 'str' java.lang.String A[DONT_INLINE])
                              (r7v0 'function02' kotlin.jvm.functions.Function0<kotlin.Unit> A[DONT_INLINE])
                             A[MD:(kotlin.jvm.functions.Function1, dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData, kotlin.jvm.functions.Function0, java.lang.String, kotlin.jvm.functions.Function0):void (m)] (LINE:16) call: dk.molslinjen.ui.views.screens.profile.shared.a.<init>(kotlin.jvm.functions.Function1, dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData, kotlin.jvm.functions.Function0, java.lang.String, kotlin.jvm.functions.Function0):void type: CONSTRUCTOR in method: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1.1.invoke(androidx.compose.runtime.Composer, int):void, file: classes2.dex
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
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
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
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: dk.molslinjen.ui.views.screens.profile.shared.a, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                            	... 24 more
                            */
                        public final void invoke(androidx.compose.runtime.Composer r13, int r14) {
                            /*
                                r12 = this;
                                r0 = r14 & 3
                                r1 = 2
                                if (r0 != r1) goto L11
                                boolean r0 = r13.getSkipping()
                                if (r0 != 0) goto Lc
                                goto L11
                            Lc:
                                r13.skipToGroupEnd()
                                goto Laf
                            L11:
                                boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                if (r0 == 0) goto L20
                                r0 = -1
                                java.lang.String r1 = "dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsListContainer.<anonymous>.<anonymous> (ProfileAssetsContainer.kt:52)"
                                r2 = -356752563(0xffffffffeabc634d, float:-1.1387349E26)
                                androidx.compose.runtime.ComposerKt.traceEventStart(r2, r14, r0, r1)
                            L20:
                                boolean r14 = r12.$isEmpty
                                if (r14 == 0) goto L3e
                                r14 = 480695779(0x1ca6d5e3, float:1.1040247E-21)
                                r13.startReplaceGroup(r14)
                                int r0 = r12.$emptyIcon
                                java.lang.String r1 = r12.$emptyDescription
                                java.lang.String r2 = r12.$emptySubDescription
                                java.lang.String r3 = r12.$registerButtonText
                                kotlin.jvm.functions.Function0<kotlin.Unit> r4 = r12.$onRegisterButtonClick
                                r6 = 0
                                r7 = 0
                                r5 = r13
                                dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsEmptyViewKt.ProfileItemsEmptyView(r0, r1, r2, r3, r4, r5, r6, r7)
                                r13.endReplaceGroup()
                                goto La6
                            L3e:
                                r14 = 481065485(0x1cac7a0d, float:1.1413555E-21)
                                r13.startReplaceGroup(r14)
                                androidx.compose.foundation.lazy.LazyListState r1 = r12.$lazyListState
                                r14 = -400122157(0xffffffffe8269ed3, float:-3.1473705E24)
                                r13.startReplaceGroup(r14)
                                dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData r14 = r12.$accountCardData
                                boolean r14 = r13.changed(r14)
                                kotlin.jvm.functions.Function0<kotlin.Unit> r0 = r12.$onSignup
                                boolean r0 = r13.changed(r0)
                                r14 = r14 | r0
                                java.lang.String r0 = r12.$registerButtonText
                                boolean r0 = r13.changed(r0)
                                r14 = r14 | r0
                                kotlin.jvm.functions.Function0<kotlin.Unit> r0 = r12.$onRegisterButtonClick
                                boolean r0 = r13.changed(r0)
                                r14 = r14 | r0
                                kotlin.jvm.functions.Function1<androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r0 = r12.$content
                                boolean r0 = r13.changed(r0)
                                r14 = r14 | r0
                                kotlin.jvm.functions.Function1<androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r3 = r12.$content
                                dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData r4 = r12.$accountCardData
                                kotlin.jvm.functions.Function0<kotlin.Unit> r5 = r12.$onSignup
                                java.lang.String r6 = r12.$registerButtonText
                                kotlin.jvm.functions.Function0<kotlin.Unit> r7 = r12.$onRegisterButtonClick
                                java.lang.Object r0 = r13.rememberedValue()
                                if (r14 != 0) goto L86
                                androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.INSTANCE
                                java.lang.Object r14 = r14.getEmpty()
                                if (r0 != r14) goto L8f
                            L86:
                                dk.molslinjen.ui.views.screens.profile.shared.a r0 = new dk.molslinjen.ui.views.screens.profile.shared.a
                                r2 = r0
                                r2.<init>(r3, r4, r5, r6, r7)
                                r13.updateRememberedValue(r0)
                            L8f:
                                r8 = r0
                                kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
                                r13.endReplaceGroup()
                                r10 = 0
                                r11 = 253(0xfd, float:3.55E-43)
                                r0 = 0
                                r2 = 0
                                r3 = 0
                                r4 = 0
                                r5 = 0
                                r6 = 0
                                r7 = 0
                                r9 = r13
                                androidx.compose.foundation.lazy.LazyDslKt.LazyColumn(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                                r13.endReplaceGroup()
                            La6:
                                boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                if (r13 == 0) goto Laf
                                androidx.compose.runtime.ComposerKt.traceEventEnd()
                            Laf:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt$ProfileAssetsListContainer$1.AnonymousClass1.invoke(androidx.compose.runtime.Composer, int):void");
                        }
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                        invoke(columnScope, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ColumnScope BottomSheetContainer, Composer composer3, int i20) {
                        Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
                        if ((i20 & 17) == 16 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(612404993, i20, -1, "dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsListContainer.<anonymous> (ProfileAssetsContainer.kt:51)");
                        }
                        LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, 0.0f, z5, 0, false, null, ComposableLambdaKt.rememberComposableLambda(-356752563, true, new AnonymousClass1(z6, i5, emptyDescription, str7222, str8222, function010222, rememberLazyListState222, accountCardData4222, function011222, content), composer3, 54), composer3, 1572864, 59);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, (i19222 & 896) | 805306374 | (i18222 & 458752) | (i19222 & 3670016), 282);
                if (ComposerKt.isTraceInProgress()) {
                }
                accountCardData2 = accountCardData3;
                function04 = function07;
                str3 = str5;
                str4 = str6;
                function05 = function08;
                function06 = function09;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit ProfileAssetsListContainer$lambda$0(String str, AccountCardData accountCardData, boolean z5, boolean z6, Function0 function0, Function0 function02, int i5, String str2, String str3, String str4, Function0 function03, Function0 function04, Function1 function1, int i6, int i7, int i8, Composer composer, int i9) {
                ProfileAssetsListContainer(str, accountCardData, z5, z6, function0, function02, i5, str2, str3, str4, function03, function04, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), RecomposeScopeImplKt.updateChangedFlags(i7), i8);
                return Unit.INSTANCE;
            }
        }
