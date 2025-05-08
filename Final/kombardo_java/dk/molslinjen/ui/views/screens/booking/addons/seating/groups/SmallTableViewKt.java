package dk.molslinjen.ui.views.screens.booking.addons.seating.groups;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import dk.molslinjen.extensions.domain.FerrySeatingGroupTypeExtensionsKt;
import dk.molslinjen.ui.views.screens.booking.addons.seating.groups.SmallTableViewKt;
import dk.molslinjen.ui.views.screens.booking.addons.seating.seat.SeatOrientation;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FerrySeat;
import uniffi.molslinjen_shared.FerrySeatType;
import uniffi.molslinjen_shared.FerrySeatingGroupType;
import uniffi.molslinjen_shared.Point;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001aI\u0010\f\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Luniffi/molslinjen_shared/FerrySeatingGroupType$SmallTable;", "smallTable", "Luniffi/molslinjen_shared/Point;", "origin", BuildConfig.FLAVOR, "rotation", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/FerrySeat;", "selectedSeats", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onSeatPressed", "SmallTableView", "(Luniffi/molslinjen_shared/FerrySeatingGroupType$SmallTable;Luniffi/molslinjen_shared/Point;FLjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SmallTableViewKt {
    public static final void SmallTableView(final FerrySeatingGroupType.SmallTable smallTable, final Point origin, final float f5, final List<FerrySeat> selectedSeats, final Function1<? super FerrySeat, Unit> onSeatPressed, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(smallTable, "smallTable");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(selectedSeats, "selectedSeats");
        Intrinsics.checkNotNullParameter(onSeatPressed, "onSeatPressed");
        Composer startRestartGroup = composer.startRestartGroup(255146386);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(smallTable) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(origin) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(f5) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(selectedSeats) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(onSeatPressed) ? 16384 : 8192;
        }
        if ((i6 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(255146386, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.groups.SmallTableView (SmallTableView.kt:19)");
            }
            int i7 = i6 >> 3;
            BaseSeatingViewsKt.BaseSeatingContainer(origin, f5, ComposableLambdaKt.rememberComposableLambda(43813734, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.SmallTableViewKt$SmallTableView$1

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                /* renamed from: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.SmallTableViewKt$SmallTableView$1$1, reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass1 implements Function3<RowScope, Composer, Integer, Unit> {
                    final /* synthetic */ Function1<FerrySeat, Unit> $onSeatPressed;
                    final /* synthetic */ float $rotation;
                    final /* synthetic */ List<FerrySeat> $selectedSeats;
                    final /* synthetic */ FerrySeatingGroupType.SmallTable $smallTable;
                    final /* synthetic */ FerrySeat $top;

                    /* JADX WARN: Multi-variable type inference failed */
                    AnonymousClass1(FerrySeatingGroupType.SmallTable smallTable, FerrySeat ferrySeat, float f5, List<FerrySeat> list, Function1<? super FerrySeat, Unit> function1) {
                        this.$smallTable = smallTable;
                        this.$top = ferrySeat;
                        this.$rotation = f5;
                        this.$selectedSeats = list;
                        this.$onSeatPressed = function1;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$1$lambda$0(Function1 function1, FerrySeat ferrySeat) {
                        function1.invoke(ferrySeat);
                        return Unit.INSTANCE;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                        invoke(rowScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope BaseSeatingRow, Composer composer, int i5) {
                        Intrinsics.checkNotNullParameter(BaseSeatingRow, "$this$BaseSeatingRow");
                        if ((i5 & 17) == 16 && composer.getSkipping()) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1276483799, i5, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.groups.SmallTableView.<anonymous>.<anonymous> (SmallTableView.kt:26)");
                        }
                        FerrySeatingGroupType.SmallTable smallTable = this.$smallTable;
                        FerrySeatType seatType = this.$top.getSeatType();
                        float f5 = this.$rotation;
                        boolean contains = this.$selectedSeats.contains(this.$top);
                        composer.startReplaceGroup(-84664920);
                        boolean changed = composer.changed(this.$onSeatPressed) | composer.changedInstance(this.$top);
                        final Function1<FerrySeat, Unit> function1 = this.$onSeatPressed;
                        final FerrySeat ferrySeat = this.$top;
                        Object rememberedValue = composer.rememberedValue();
                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = 
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x005e: CONSTRUCTOR (r7v1 'rememberedValue' java.lang.Object) = 
                                  (r3v3 'function1' kotlin.jvm.functions.Function1<uniffi.molslinjen_shared.FerrySeat, kotlin.Unit> A[DONT_INLINE])
                                  (r4v0 'ferrySeat' uniffi.molslinjen_shared.FerrySeat A[DONT_INLINE])
                                 A[MD:(kotlin.jvm.functions.Function1, uniffi.molslinjen_shared.FerrySeat):void (m)] (LINE:12) call: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.t.<init>(kotlin.jvm.functions.Function1, uniffi.molslinjen_shared.FerrySeat):void type: CONSTRUCTOR in method: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.SmallTableViewKt$SmallTableView$1.1.invoke(androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, int):void, file: classes2.dex
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
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.t, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	... 25 more
                                */
                            /*
                                this = this;
                                java.lang.String r1 = "$this$BaseSeatingRow"
                                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
                                r1 = r14 & 17
                                r2 = 16
                                if (r1 != r2) goto L16
                                boolean r1 = r13.getSkipping()
                                if (r1 != 0) goto L12
                                goto L16
                            L12:
                                r13.skipToGroupEnd()
                                goto L7d
                            L16:
                                boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                if (r1 == 0) goto L25
                                r1 = -1
                                java.lang.String r2 = "dk.molslinjen.ui.views.screens.booking.addons.seating.groups.SmallTableView.<anonymous>.<anonymous> (SmallTableView.kt:26)"
                                r3 = -1276483799(0xffffffffb3ea6729, float:-1.0915239E-7)
                                androidx.compose.runtime.ComposerKt.traceEventStart(r3, r14, r1, r2)
                            L25:
                                uniffi.molslinjen_shared.FerrySeatingGroupType$SmallTable r0 = r11.$smallTable
                                uniffi.molslinjen_shared.FerrySeat r1 = r11.$top
                                uniffi.molslinjen_shared.FerrySeatType r2 = r1.getSeatType()
                                float r5 = r11.$rotation
                                java.util.List<uniffi.molslinjen_shared.FerrySeat> r1 = r11.$selectedSeats
                                uniffi.molslinjen_shared.FerrySeat r3 = r11.$top
                                boolean r6 = r1.contains(r3)
                                r1 = -84664920(0xfffffffffaf41da8, float:-6.3376097E35)
                                r13.startReplaceGroup(r1)
                                kotlin.jvm.functions.Function1<uniffi.molslinjen_shared.FerrySeat, kotlin.Unit> r1 = r11.$onSeatPressed
                                boolean r1 = r13.changed(r1)
                                uniffi.molslinjen_shared.FerrySeat r3 = r11.$top
                                boolean r3 = r13.changedInstance(r3)
                                r1 = r1 | r3
                                kotlin.jvm.functions.Function1<uniffi.molslinjen_shared.FerrySeat, kotlin.Unit> r3 = r11.$onSeatPressed
                                uniffi.molslinjen_shared.FerrySeat r4 = r11.$top
                                java.lang.Object r7 = r13.rememberedValue()
                                if (r1 != 0) goto L5c
                                androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.INSTANCE
                                java.lang.Object r1 = r1.getEmpty()
                                if (r7 != r1) goto L64
                            L5c:
                                dk.molslinjen.ui.views.screens.booking.addons.seating.groups.t r7 = new dk.molslinjen.ui.views.screens.booking.addons.seating.groups.t
                                r7.<init>(r3, r4)
                                r13.updateRememberedValue(r7)
                            L64:
                                kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
                                r13.endReplaceGroup()
                                r9 = 48
                                r10 = 24
                                r1 = 1
                                r3 = 0
                                r4 = 0
                                r8 = r13
                                dk.molslinjen.ui.views.screens.booking.addons.seating.seat.FerrySeatViewKt.m3442FerrySeatViewaA_HZ9I(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                                boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                if (r0 == 0) goto L7d
                                androidx.compose.runtime.ComposerKt.traceEventEnd()
                            L7d:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.SmallTableViewKt$SmallTableView$1.AnonymousClass1.invoke(androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, int):void");
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                    /* renamed from: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.SmallTableViewKt$SmallTableView$1$3, reason: invalid class name */
                    /* loaded from: classes2.dex */
                    public static final class AnonymousClass3 implements Function3<RowScope, Composer, Integer, Unit> {
                        final /* synthetic */ FerrySeat $bottom;
                        final /* synthetic */ Function1<FerrySeat, Unit> $onSeatPressed;
                        final /* synthetic */ float $rotation;
                        final /* synthetic */ List<FerrySeat> $selectedSeats;
                        final /* synthetic */ FerrySeatingGroupType.SmallTable $smallTable;

                        /* JADX WARN: Multi-variable type inference failed */
                        AnonymousClass3(FerrySeatingGroupType.SmallTable smallTable, FerrySeat ferrySeat, float f5, List<FerrySeat> list, Function1<? super FerrySeat, Unit> function1) {
                            this.$smallTable = smallTable;
                            this.$bottom = ferrySeat;
                            this.$rotation = f5;
                            this.$selectedSeats = list;
                            this.$onSeatPressed = function1;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final Unit invoke$lambda$1$lambda$0(Function1 function1, FerrySeat ferrySeat) {
                            function1.invoke(ferrySeat);
                            return Unit.INSTANCE;
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                            invoke(rowScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RowScope BaseSeatingRow, Composer composer, int i5) {
                            Intrinsics.checkNotNullParameter(BaseSeatingRow, "$this$BaseSeatingRow");
                            if ((i5 & 17) == 16 && composer.getSkipping()) {
                                composer.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(176822753, i5, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.groups.SmallTableView.<anonymous>.<anonymous> (SmallTableView.kt:40)");
                            }
                            FerrySeatingGroupType.SmallTable smallTable = this.$smallTable;
                            FerrySeatType seatType = this.$bottom.getSeatType();
                            SeatOrientation seatOrientation = SeatOrientation.Up;
                            float f5 = this.$rotation;
                            boolean contains = this.$selectedSeats.contains(this.$bottom);
                            composer.startReplaceGroup(-84648213);
                            boolean changed = composer.changed(this.$onSeatPressed) | composer.changedInstance(this.$bottom);
                            final Function1<FerrySeat, Unit> function1 = this.$onSeatPressed;
                            final FerrySeat ferrySeat = this.$bottom;
                            Object rememberedValue = composer.rememberedValue();
                            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = 
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0060: CONSTRUCTOR (r9v1 'rememberedValue' java.lang.Object) = 
                                      (r3v3 'function1' kotlin.jvm.functions.Function1<uniffi.molslinjen_shared.FerrySeat, kotlin.Unit> A[DONT_INLINE])
                                      (r7v0 'ferrySeat' uniffi.molslinjen_shared.FerrySeat A[DONT_INLINE])
                                     A[MD:(kotlin.jvm.functions.Function1, uniffi.molslinjen_shared.FerrySeat):void (m)] (LINE:13) call: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.u.<init>(kotlin.jvm.functions.Function1, uniffi.molslinjen_shared.FerrySeat):void type: CONSTRUCTOR in method: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.SmallTableViewKt$SmallTableView$1.3.invoke(androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, int):void, file: classes2.dex
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
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.u, state: NOT_LOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                    	... 25 more
                                    */
                                /*
                                    this = this;
                                    java.lang.String r1 = "$this$BaseSeatingRow"
                                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
                                    r1 = r14 & 17
                                    r2 = 16
                                    if (r1 != r2) goto L16
                                    boolean r1 = r13.getSkipping()
                                    if (r1 != 0) goto L12
                                    goto L16
                                L12:
                                    r13.skipToGroupEnd()
                                    goto L7f
                                L16:
                                    boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                    if (r1 == 0) goto L25
                                    r1 = -1
                                    java.lang.String r2 = "dk.molslinjen.ui.views.screens.booking.addons.seating.groups.SmallTableView.<anonymous>.<anonymous> (SmallTableView.kt:40)"
                                    r3 = 176822753(0xa8a19e1, float:1.3298651E-32)
                                    androidx.compose.runtime.ComposerKt.traceEventStart(r3, r14, r1, r2)
                                L25:
                                    uniffi.molslinjen_shared.FerrySeatingGroupType$SmallTable r0 = r11.$smallTable
                                    uniffi.molslinjen_shared.FerrySeat r1 = r11.$bottom
                                    uniffi.molslinjen_shared.FerrySeatType r2 = r1.getSeatType()
                                    dk.molslinjen.ui.views.screens.booking.addons.seating.seat.SeatOrientation r4 = dk.molslinjen.ui.views.screens.booking.addons.seating.seat.SeatOrientation.Up
                                    float r5 = r11.$rotation
                                    java.util.List<uniffi.molslinjen_shared.FerrySeat> r1 = r11.$selectedSeats
                                    uniffi.molslinjen_shared.FerrySeat r3 = r11.$bottom
                                    boolean r6 = r1.contains(r3)
                                    r1 = -84648213(0xfffffffffaf45eeb, float:-6.344228E35)
                                    r13.startReplaceGroup(r1)
                                    kotlin.jvm.functions.Function1<uniffi.molslinjen_shared.FerrySeat, kotlin.Unit> r1 = r11.$onSeatPressed
                                    boolean r1 = r13.changed(r1)
                                    uniffi.molslinjen_shared.FerrySeat r3 = r11.$bottom
                                    boolean r3 = r13.changedInstance(r3)
                                    r1 = r1 | r3
                                    kotlin.jvm.functions.Function1<uniffi.molslinjen_shared.FerrySeat, kotlin.Unit> r3 = r11.$onSeatPressed
                                    uniffi.molslinjen_shared.FerrySeat r7 = r11.$bottom
                                    java.lang.Object r9 = r13.rememberedValue()
                                    if (r1 != 0) goto L5e
                                    androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.INSTANCE
                                    java.lang.Object r1 = r1.getEmpty()
                                    if (r9 != r1) goto L66
                                L5e:
                                    dk.molslinjen.ui.views.screens.booking.addons.seating.groups.u r9 = new dk.molslinjen.ui.views.screens.booking.addons.seating.groups.u
                                    r9.<init>(r3, r7)
                                    r13.updateRememberedValue(r9)
                                L66:
                                    r7 = r9
                                    kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
                                    r13.endReplaceGroup()
                                    r9 = 24624(0x6030, float:3.4506E-41)
                                    r10 = 8
                                    r1 = 2
                                    r3 = 0
                                    r8 = r13
                                    dk.molslinjen.ui.views.screens.booking.addons.seating.seat.FerrySeatViewKt.m3442FerrySeatViewaA_HZ9I(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                                    boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                    if (r0 == 0) goto L7f
                                    androidx.compose.runtime.ComposerKt.traceEventEnd()
                                L7f:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.SmallTableViewKt$SmallTableView$1.AnonymousClass3.invoke(androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, int):void");
                            }
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                            invoke(columnScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ColumnScope BaseSeatingContainer, Composer composer2, int i8) {
                            Intrinsics.checkNotNullParameter(BaseSeatingContainer, "$this$BaseSeatingContainer");
                            if ((i8 & 6) == 0) {
                                i8 |= composer2.changed(BaseSeatingContainer) ? 4 : 2;
                            }
                            if ((i8 & 19) == 18 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(43813734, i8, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.groups.SmallTableView.<anonymous> (SmallTableView.kt:24)");
                            }
                            int i9 = (i8 & 14) | 48;
                            BaseSeatingViewsKt.BaseSeatingRow(BaseSeatingContainer, ComposableLambdaKt.rememberComposableLambda(-1276483799, true, new AnonymousClass1(FerrySeatingGroupType.SmallTable.this, FerrySeatingGroupType.SmallTable.this.getTop(), f5, selectedSeats, onSeatPressed), composer2, 54), composer2, i9);
                            final FerrySeatingGroupType.SmallTable smallTable2 = FerrySeatingGroupType.SmallTable.this;
                            BaseSeatingViewsKt.BaseSeatingRow(BaseSeatingContainer, ComposableLambdaKt.rememberComposableLambda(-1089248032, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.SmallTableViewKt$SmallTableView$1.2
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                                    invoke(rowScope, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(RowScope BaseSeatingRow, Composer composer3, int i10) {
                                    Intrinsics.checkNotNullParameter(BaseSeatingRow, "$this$BaseSeatingRow");
                                    if ((i10 & 6) == 0) {
                                        i10 |= composer3.changed(BaseSeatingRow) ? 4 : 2;
                                    }
                                    if ((i10 & 19) == 18 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1089248032, i10, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.groups.SmallTableView.<anonymous>.<anonymous> (SmallTableView.kt:36)");
                                    }
                                    BaseSeatingViewsKt.SeatTableView(BaseSeatingRow, FerrySeatingGroupTypeExtensionsKt.getTableRes(FerrySeatingGroupType.SmallTable.this), composer3, i10 & 14);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer2, 54), composer2, i9);
                            BaseSeatingViewsKt.BaseSeatingRow(BaseSeatingContainer, ComposableLambdaKt.rememberComposableLambda(176822753, true, new AnonymousClass3(FerrySeatingGroupType.SmallTable.this, FerrySeatingGroupType.SmallTable.this.getBottom(), f5, selectedSeats, onSeatPressed), composer2, 54), composer2, i9);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), startRestartGroup, (i7 & 112) | (i7 & 14) | 384);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: F2.j
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit SmallTableView$lambda$0;
                            SmallTableView$lambda$0 = SmallTableViewKt.SmallTableView$lambda$0(FerrySeatingGroupType.SmallTable.this, origin, f5, selectedSeats, onSeatPressed, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return SmallTableView$lambda$0;
                        }
                    });
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit SmallTableView$lambda$0(FerrySeatingGroupType.SmallTable smallTable, Point point, float f5, List list, Function1 function1, int i5, Composer composer, int i6) {
                SmallTableView(smallTable, point, f5, list, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                return Unit.INSTANCE;
            }
        }
