package dk.molslinjen.ui.views.screens.booking.addons.seating.groups;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import dk.molslinjen.ui.views.screens.booking.addons.seating.groups.CornerTableLargeViewKt;
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

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001aI\u0010\f\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Luniffi/molslinjen_shared/FerrySeatingGroupType$CornerTableLarge;", "largeCornerTable", "Luniffi/molslinjen_shared/Point;", "origin", BuildConfig.FLAVOR, "rotation", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/FerrySeat;", "selectedSeats", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onSeatPressed", "CornerTableLargeView", "(Luniffi/molslinjen_shared/FerrySeatingGroupType$CornerTableLarge;Luniffi/molslinjen_shared/Point;FLjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CornerTableLargeViewKt {
    public static final void CornerTableLargeView(final FerrySeatingGroupType.CornerTableLarge largeCornerTable, final Point origin, final float f5, final List<FerrySeat> selectedSeats, final Function1<? super FerrySeat, Unit> onSeatPressed, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(largeCornerTable, "largeCornerTable");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(selectedSeats, "selectedSeats");
        Intrinsics.checkNotNullParameter(onSeatPressed, "onSeatPressed");
        Composer startRestartGroup = composer.startRestartGroup(-1654751849);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(largeCornerTable) ? 4 : 2) | i5;
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
                ComposerKt.traceEventStart(-1654751849, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.groups.CornerTableLargeView (CornerTableLargeView.kt:19)");
            }
            int i7 = i6 >> 3;
            BaseSeatingViewsKt.BaseSeatingContainer(origin, f5, ComposableLambdaKt.rememberComposableLambda(1594655339, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.CornerTableLargeViewKt$CornerTableLargeView$1

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                /* renamed from: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.CornerTableLargeViewKt$CornerTableLargeView$1$1, reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass1 implements Function3<RowScope, Composer, Integer, Unit> {
                    final /* synthetic */ FerrySeatingGroupType.CornerTableLarge $largeCornerTable;
                    final /* synthetic */ Function1<FerrySeat, Unit> $onSeatPressed;
                    final /* synthetic */ float $rotation;
                    final /* synthetic */ List<FerrySeat> $selectedSeats;

                    /* JADX WARN: Multi-variable type inference failed */
                    AnonymousClass1(FerrySeatingGroupType.CornerTableLarge cornerTableLarge, float f5, List<FerrySeat> list, Function1<? super FerrySeat, Unit> function1) {
                        this.$largeCornerTable = cornerTableLarge;
                        this.$rotation = f5;
                        this.$selectedSeats = list;
                        this.$onSeatPressed = function1;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$1$lambda$0(Function1 function1, FerrySeatingGroupType.CornerTableLarge cornerTableLarge) {
                        function1.invoke(cornerTableLarge.getTopLeft());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$3$lambda$2(Function1 function1, FerrySeatingGroupType.CornerTableLarge cornerTableLarge) {
                        function1.invoke(cornerTableLarge.getTopMiddle());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$5$lambda$4(Function1 function1, FerrySeatingGroupType.CornerTableLarge cornerTableLarge) {
                        function1.invoke(cornerTableLarge.getTopRight());
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
                            ComposerKt.traceEventStart(-1585310866, i5, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.groups.CornerTableLargeView.<anonymous>.<anonymous> (CornerTableLargeView.kt:25)");
                        }
                        FerrySeatingGroupType.CornerTableLarge cornerTableLarge = this.$largeCornerTable;
                        FerrySeatType seatType = cornerTableLarge.getTopLeft().getSeatType();
                        SeatOrientation seatOrientation = SeatOrientation.Right;
                        float f5 = this.$rotation;
                        boolean contains = this.$selectedSeats.contains(this.$largeCornerTable.getTopLeft());
                        composer.startReplaceGroup(1795792536);
                        boolean changed = composer.changed(this.$onSeatPressed) | composer.changedInstance(this.$largeCornerTable);
                        final Function1<FerrySeat, Unit> function1 = this.$onSeatPressed;
                        final FerrySeatingGroupType.CornerTableLarge cornerTableLarge2 = this.$largeCornerTable;
                        Object rememberedValue = composer.rememberedValue();
                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = 
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x006c: CONSTRUCTOR (r9v1 'rememberedValue' java.lang.Object) = 
                                  (r4v4 'function1' kotlin.jvm.functions.Function1<uniffi.molslinjen_shared.FerrySeat, kotlin.Unit> A[DONT_INLINE])
                                  (r8v0 'cornerTableLarge2' uniffi.molslinjen_shared.FerrySeatingGroupType$CornerTableLarge A[DONT_INLINE])
                                 A[MD:(kotlin.jvm.functions.Function1, uniffi.molslinjen_shared.FerrySeatingGroupType$CornerTableLarge):void (m)] (LINE:13) call: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.a.<init>(kotlin.jvm.functions.Function1, uniffi.molslinjen_shared.FerrySeatingGroupType$CornerTableLarge):void type: CONSTRUCTOR in method: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.CornerTableLargeViewKt$CornerTableLargeView$1.1.invoke(androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, int):void, file: classes2.dex
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
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.a, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	... 25 more
                                */
                            /*
                                Method dump skipped, instructions count: 310
                                To view this dump add '--comments-level debug' option
                            */
                            throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.CornerTableLargeViewKt$CornerTableLargeView$1.AnonymousClass1.invoke(androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, int):void");
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                    /* renamed from: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.CornerTableLargeViewKt$CornerTableLargeView$1$2, reason: invalid class name */
                    /* loaded from: classes2.dex */
                    public static final class AnonymousClass2 implements Function3<RowScope, Composer, Integer, Unit> {
                        final /* synthetic */ FerrySeatingGroupType.CornerTableLarge $largeCornerTable;
                        final /* synthetic */ Function1<FerrySeat, Unit> $onSeatPressed;
                        final /* synthetic */ float $rotation;
                        final /* synthetic */ List<FerrySeat> $selectedSeats;

                        /* JADX WARN: Multi-variable type inference failed */
                        AnonymousClass2(FerrySeatingGroupType.CornerTableLarge cornerTableLarge, float f5, List<FerrySeat> list, Function1<? super FerrySeat, Unit> function1) {
                            this.$largeCornerTable = cornerTableLarge;
                            this.$rotation = f5;
                            this.$selectedSeats = list;
                            this.$onSeatPressed = function1;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final Unit invoke$lambda$1$lambda$0(Function1 function1, FerrySeatingGroupType.CornerTableLarge cornerTableLarge) {
                            function1.invoke(cornerTableLarge.getMiddle());
                            return Unit.INSTANCE;
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                            invoke(rowScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RowScope BaseSeatingRow, Composer composer, int i5) {
                            int i6;
                            Intrinsics.checkNotNullParameter(BaseSeatingRow, "$this$BaseSeatingRow");
                            if ((i5 & 6) == 0) {
                                i6 = i5 | (composer.changed(BaseSeatingRow) ? 4 : 2);
                            } else {
                                i6 = i5;
                            }
                            if ((i6 & 19) == 18 && composer.getSkipping()) {
                                composer.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1710116507, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.groups.CornerTableLargeView.<anonymous>.<anonymous> (CornerTableLargeView.kt:53)");
                            }
                            FerrySeatingGroupType.CornerTableLarge cornerTableLarge = this.$largeCornerTable;
                            FerrySeatType seatType = cornerTableLarge.getMiddle().getSeatType();
                            SeatOrientation seatOrientation = SeatOrientation.Right;
                            float f5 = this.$rotation;
                            boolean contains = this.$selectedSeats.contains(this.$largeCornerTable.getMiddle());
                            composer.startReplaceGroup(1795831991);
                            boolean changed = composer.changed(this.$onSeatPressed) | composer.changedInstance(this.$largeCornerTable);
                            final Function1<FerrySeat, Unit> function1 = this.$onSeatPressed;
                            final FerrySeatingGroupType.CornerTableLarge cornerTableLarge2 = this.$largeCornerTable;
                            Object rememberedValue = composer.rememberedValue();
                            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = 
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x007f: CONSTRUCTOR (r10v1 'rememberedValue' java.lang.Object) = 
                                      (r5v4 'function1' kotlin.jvm.functions.Function1<uniffi.molslinjen_shared.FerrySeat, kotlin.Unit> A[DONT_INLINE])
                                      (r9v0 'cornerTableLarge2' uniffi.molslinjen_shared.FerrySeatingGroupType$CornerTableLarge A[DONT_INLINE])
                                     A[MD:(kotlin.jvm.functions.Function1, uniffi.molslinjen_shared.FerrySeatingGroupType$CornerTableLarge):void (m)] (LINE:13) call: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.d.<init>(kotlin.jvm.functions.Function1, uniffi.molslinjen_shared.FerrySeatingGroupType$CornerTableLarge):void type: CONSTRUCTOR in method: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.CornerTableLargeViewKt$CornerTableLargeView$1.2.invoke(androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, int):void, file: classes2.dex
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
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.d, state: NOT_LOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                    	... 25 more
                                    */
                                /*
                                    this = this;
                                    r0 = r15
                                    r1 = r16
                                    r13 = r17
                                    java.lang.String r2 = "$this$BaseSeatingRow"
                                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
                                    r2 = r18 & 6
                                    if (r2 != 0) goto L1b
                                    boolean r2 = r13.changed(r1)
                                    if (r2 == 0) goto L16
                                    r2 = 4
                                    goto L17
                                L16:
                                    r2 = 2
                                L17:
                                    r2 = r18 | r2
                                    r14 = r2
                                    goto L1d
                                L1b:
                                    r14 = r18
                                L1d:
                                    r2 = r14 & 19
                                    r3 = 18
                                    if (r2 != r3) goto L2f
                                    boolean r2 = r17.getSkipping()
                                    if (r2 != 0) goto L2a
                                    goto L2f
                                L2a:
                                    r17.skipToGroupEnd()
                                    goto Laa
                                L2f:
                                    boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                    if (r2 == 0) goto L3e
                                    r2 = -1
                                    java.lang.String r3 = "dk.molslinjen.ui.views.screens.booking.addons.seating.groups.CornerTableLargeView.<anonymous>.<anonymous> (CornerTableLargeView.kt:53)"
                                    r4 = -1710116507(0xffffffff9a11b165, float:-3.0128595E-23)
                                    androidx.compose.runtime.ComposerKt.traceEventStart(r4, r14, r2, r3)
                                L3e:
                                    uniffi.molslinjen_shared.FerrySeatingGroupType$CornerTableLarge r2 = r0.$largeCornerTable
                                    uniffi.molslinjen_shared.FerrySeat r3 = r2.getMiddle()
                                    uniffi.molslinjen_shared.FerrySeatType r4 = r3.getSeatType()
                                    dk.molslinjen.ui.views.screens.booking.addons.seating.seat.SeatOrientation r6 = dk.molslinjen.ui.views.screens.booking.addons.seating.seat.SeatOrientation.Right
                                    float r7 = r0.$rotation
                                    java.util.List<uniffi.molslinjen_shared.FerrySeat> r3 = r0.$selectedSeats
                                    uniffi.molslinjen_shared.FerrySeatingGroupType$CornerTableLarge r5 = r0.$largeCornerTable
                                    uniffi.molslinjen_shared.FerrySeat r5 = r5.getMiddle()
                                    boolean r8 = r3.contains(r5)
                                    r3 = 1795831991(0x6b0a38b7, float:1.670996E26)
                                    r13.startReplaceGroup(r3)
                                    kotlin.jvm.functions.Function1<uniffi.molslinjen_shared.FerrySeat, kotlin.Unit> r3 = r0.$onSeatPressed
                                    boolean r3 = r13.changed(r3)
                                    uniffi.molslinjen_shared.FerrySeatingGroupType$CornerTableLarge r5 = r0.$largeCornerTable
                                    boolean r5 = r13.changedInstance(r5)
                                    r3 = r3 | r5
                                    kotlin.jvm.functions.Function1<uniffi.molslinjen_shared.FerrySeat, kotlin.Unit> r5 = r0.$onSeatPressed
                                    uniffi.molslinjen_shared.FerrySeatingGroupType$CornerTableLarge r9 = r0.$largeCornerTable
                                    java.lang.Object r10 = r17.rememberedValue()
                                    if (r3 != 0) goto L7d
                                    androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.INSTANCE
                                    java.lang.Object r3 = r3.getEmpty()
                                    if (r10 != r3) goto L85
                                L7d:
                                    dk.molslinjen.ui.views.screens.booking.addons.seating.groups.d r10 = new dk.molslinjen.ui.views.screens.booking.addons.seating.groups.d
                                    r10.<init>(r5, r9)
                                    r13.updateRememberedValue(r10)
                                L85:
                                    r9 = r10
                                    kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
                                    r17.endReplaceGroup()
                                    r11 = 24624(0x6030, float:3.4506E-41)
                                    r12 = 8
                                    r3 = 4
                                    r5 = 0
                                    r10 = r17
                                    dk.molslinjen.ui.views.screens.booking.addons.seating.seat.FerrySeatViewKt.m3442FerrySeatViewaA_HZ9I(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
                                    uniffi.molslinjen_shared.FerrySeatingGroupType$CornerTableLarge r2 = r0.$largeCornerTable
                                    java.lang.Integer r2 = dk.molslinjen.extensions.domain.FerrySeatingGroupTypeExtensionsKt.getTableRes(r2)
                                    r3 = r14 & 14
                                    dk.molslinjen.ui.views.screens.booking.addons.seating.groups.BaseSeatingViewsKt.SeatTableView(r1, r2, r13, r3)
                                    boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                    if (r1 == 0) goto Laa
                                    androidx.compose.runtime.ComposerKt.traceEventEnd()
                                Laa:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.CornerTableLargeViewKt$CornerTableLargeView$1.AnonymousClass2.invoke(androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, int):void");
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: package-private */
                        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                        /* renamed from: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.CornerTableLargeViewKt$CornerTableLargeView$1$3, reason: invalid class name */
                        /* loaded from: classes2.dex */
                        public static final class AnonymousClass3 implements Function3<RowScope, Composer, Integer, Unit> {
                            final /* synthetic */ FerrySeatingGroupType.CornerTableLarge $largeCornerTable;
                            final /* synthetic */ Function1<FerrySeat, Unit> $onSeatPressed;
                            final /* synthetic */ float $rotation;
                            final /* synthetic */ List<FerrySeat> $selectedSeats;

                            /* JADX WARN: Multi-variable type inference failed */
                            AnonymousClass3(FerrySeatingGroupType.CornerTableLarge cornerTableLarge, float f5, List<FerrySeat> list, Function1<? super FerrySeat, Unit> function1) {
                                this.$largeCornerTable = cornerTableLarge;
                                this.$rotation = f5;
                                this.$selectedSeats = list;
                                this.$onSeatPressed = function1;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final Unit invoke$lambda$1$lambda$0(Function1 function1, FerrySeatingGroupType.CornerTableLarge cornerTableLarge) {
                                function1.invoke(cornerTableLarge.getBottomLeft());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final Unit invoke$lambda$3$lambda$2(Function1 function1, FerrySeatingGroupType.CornerTableLarge cornerTableLarge) {
                                function1.invoke(cornerTableLarge.getBottomMiddle());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final Unit invoke$lambda$5$lambda$4(Function1 function1, FerrySeatingGroupType.CornerTableLarge cornerTableLarge) {
                                function1.invoke(cornerTableLarge.getBottomRight());
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
                                    ComposerKt.traceEventStart(2026866726, i5, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.groups.CornerTableLargeView.<anonymous>.<anonymous> (CornerTableLargeView.kt:65)");
                                }
                                FerrySeatingGroupType.CornerTableLarge cornerTableLarge = this.$largeCornerTable;
                                FerrySeatType seatType = cornerTableLarge.getBottomLeft().getSeatType();
                                SeatOrientation seatOrientation = SeatOrientation.Right;
                                float f5 = this.$rotation;
                                boolean contains = this.$selectedSeats.contains(this.$largeCornerTable.getBottomLeft());
                                composer.startReplaceGroup(1795848795);
                                boolean changed = composer.changed(this.$onSeatPressed) | composer.changedInstance(this.$largeCornerTable);
                                final Function1<FerrySeat, Unit> function1 = this.$onSeatPressed;
                                final FerrySeatingGroupType.CornerTableLarge cornerTableLarge2 = this.$largeCornerTable;
                                Object rememberedValue = composer.rememberedValue();
                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = 
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x006d: CONSTRUCTOR (r9v1 'rememberedValue' java.lang.Object) = 
                                          (r4v4 'function1' kotlin.jvm.functions.Function1<uniffi.molslinjen_shared.FerrySeat, kotlin.Unit> A[DONT_INLINE])
                                          (r8v0 'cornerTableLarge2' uniffi.molslinjen_shared.FerrySeatingGroupType$CornerTableLarge A[DONT_INLINE])
                                         A[MD:(kotlin.jvm.functions.Function1, uniffi.molslinjen_shared.FerrySeatingGroupType$CornerTableLarge):void (m)] (LINE:13) call: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.e.<init>(kotlin.jvm.functions.Function1, uniffi.molslinjen_shared.FerrySeatingGroupType$CornerTableLarge):void type: CONSTRUCTOR in method: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.CornerTableLargeViewKt$CornerTableLargeView$1.3.invoke(androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, int):void, file: classes2.dex
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
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.e, state: NOT_LOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                        	... 25 more
                                        */
                                    /*
                                        Method dump skipped, instructions count: 316
                                        To view this dump add '--comments-level debug' option
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.CornerTableLargeViewKt$CornerTableLargeView$1.AnonymousClass3.invoke(androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, int):void");
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
                                    ComposerKt.traceEventStart(1594655339, i8, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.groups.CornerTableLargeView.<anonymous> (CornerTableLargeView.kt:24)");
                                }
                                int i9 = (i8 & 14) | 48;
                                BaseSeatingViewsKt.BaseSeatingRow(BaseSeatingContainer, ComposableLambdaKt.rememberComposableLambda(-1585310866, true, new AnonymousClass1(FerrySeatingGroupType.CornerTableLarge.this, f5, selectedSeats, onSeatPressed), composer2, 54), composer2, i9);
                                BaseSeatingViewsKt.BaseSeatingRow(BaseSeatingContainer, ComposableLambdaKt.rememberComposableLambda(-1710116507, true, new AnonymousClass2(FerrySeatingGroupType.CornerTableLarge.this, f5, selectedSeats, onSeatPressed), composer2, 54), composer2, i9);
                                BaseSeatingViewsKt.BaseSeatingRow(BaseSeatingContainer, ComposableLambdaKt.rememberComposableLambda(2026866726, true, new AnonymousClass3(FerrySeatingGroupType.CornerTableLarge.this, f5, selectedSeats, onSeatPressed), composer2, 54), composer2, i9);
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
                        endRestartGroup.updateScope(new Function2() { // from class: F2.e
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit CornerTableLargeView$lambda$0;
                                CornerTableLargeView$lambda$0 = CornerTableLargeViewKt.CornerTableLargeView$lambda$0(FerrySeatingGroupType.CornerTableLarge.this, origin, f5, selectedSeats, onSeatPressed, i5, (Composer) obj, ((Integer) obj2).intValue());
                                return CornerTableLargeView$lambda$0;
                            }
                        });
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit CornerTableLargeView$lambda$0(FerrySeatingGroupType.CornerTableLarge cornerTableLarge, Point point, float f5, List list, Function1 function1, int i5, Composer composer, int i6) {
                    CornerTableLargeView(cornerTableLarge, point, f5, list, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                    return Unit.INSTANCE;
                }
            }
