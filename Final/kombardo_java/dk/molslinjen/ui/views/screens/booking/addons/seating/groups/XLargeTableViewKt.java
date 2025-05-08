package dk.molslinjen.ui.views.screens.booking.addons.seating.groups;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import dk.molslinjen.ui.views.screens.booking.addons.seating.groups.XLargeTableViewKt;
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

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001aI\u0010\f\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Luniffi/molslinjen_shared/FerrySeatingGroupType$XLargeTable;", "xLargeTable", "Luniffi/molslinjen_shared/Point;", "origin", BuildConfig.FLAVOR, "rotation", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/FerrySeat;", "selectedSeats", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onSeatPressed", "XLargeTableView", "(Luniffi/molslinjen_shared/FerrySeatingGroupType$XLargeTable;Luniffi/molslinjen_shared/Point;FLjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class XLargeTableViewKt {
    public static final void XLargeTableView(final FerrySeatingGroupType.XLargeTable xLargeTable, final Point origin, final float f5, final List<FerrySeat> selectedSeats, final Function1<? super FerrySeat, Unit> onSeatPressed, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(xLargeTable, "xLargeTable");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(selectedSeats, "selectedSeats");
        Intrinsics.checkNotNullParameter(onSeatPressed, "onSeatPressed");
        Composer startRestartGroup = composer.startRestartGroup(-176259920);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(xLargeTable) ? 4 : 2) | i5;
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
                ComposerKt.traceEventStart(-176259920, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.groups.XLargeTableView (XLargeTableView.kt:19)");
            }
            int i7 = i6 >> 3;
            BaseSeatingViewsKt.BaseSeatingContainer(origin, f5, ComposableLambdaKt.rememberComposableLambda(434760284, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.XLargeTableViewKt$XLargeTableView$1

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                /* renamed from: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.XLargeTableViewKt$XLargeTableView$1$1, reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass1 implements Function3<RowScope, Composer, Integer, Unit> {
                    final /* synthetic */ Function1<FerrySeat, Unit> $onSeatPressed;
                    final /* synthetic */ float $rotation;
                    final /* synthetic */ List<FerrySeat> $selectedSeats;
                    final /* synthetic */ FerrySeatingGroupType.XLargeTable $xLargeTable;

                    /* JADX WARN: Multi-variable type inference failed */
                    AnonymousClass1(FerrySeatingGroupType.XLargeTable xLargeTable, float f5, List<FerrySeat> list, Function1<? super FerrySeat, Unit> function1) {
                        this.$xLargeTable = xLargeTable;
                        this.$rotation = f5;
                        this.$selectedSeats = list;
                        this.$onSeatPressed = function1;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$1$lambda$0(Function1 function1, FerrySeatingGroupType.XLargeTable xLargeTable) {
                        function1.invoke(xLargeTable.getTopLeft());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$3$lambda$2(Function1 function1, FerrySeatingGroupType.XLargeTable xLargeTable) {
                        function1.invoke(xLargeTable.getTopMiddle());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$5$lambda$4(Function1 function1, FerrySeatingGroupType.XLargeTable xLargeTable) {
                        function1.invoke(xLargeTable.getTopRight());
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
                            ComposerKt.traceEventStart(761451449, i5, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.groups.XLargeTableView.<anonymous>.<anonymous> (XLargeTableView.kt:25)");
                        }
                        FerrySeatingGroupType.XLargeTable xLargeTable = this.$xLargeTable;
                        FerrySeatType seatType = xLargeTable.getTopLeft().getSeatType();
                        float f5 = this.$rotation;
                        boolean contains = this.$selectedSeats.contains(this.$xLargeTable.getTopLeft());
                        composer.startReplaceGroup(-1780915380);
                        boolean changed = composer.changed(this.$onSeatPressed) | composer.changedInstance(this.$xLargeTable);
                        final Function1<FerrySeat, Unit> function1 = this.$onSeatPressed;
                        final FerrySeatingGroupType.XLargeTable xLargeTable2 = this.$xLargeTable;
                        Object rememberedValue = composer.rememberedValue();
                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = 
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x006a: CONSTRUCTOR (r8v1 'rememberedValue' java.lang.Object) = 
                                  (r4v4 'function1' kotlin.jvm.functions.Function1<uniffi.molslinjen_shared.FerrySeat, kotlin.Unit> A[DONT_INLINE])
                                  (r5v0 'xLargeTable2' uniffi.molslinjen_shared.FerrySeatingGroupType$XLargeTable A[DONT_INLINE])
                                 A[MD:(kotlin.jvm.functions.Function1, uniffi.molslinjen_shared.FerrySeatingGroupType$XLargeTable):void (m)] (LINE:12) call: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.v.<init>(kotlin.jvm.functions.Function1, uniffi.molslinjen_shared.FerrySeatingGroupType$XLargeTable):void type: CONSTRUCTOR in method: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.XLargeTableViewKt$XLargeTableView$1.1.invoke(androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, int):void, file: classes2.dex
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
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.v, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	... 25 more
                                */
                            /*
                                Method dump skipped, instructions count: 308
                                To view this dump add '--comments-level debug' option
                            */
                            throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.XLargeTableViewKt$XLargeTableView$1.AnonymousClass1.invoke(androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, int):void");
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                    /* renamed from: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.XLargeTableViewKt$XLargeTableView$1$2, reason: invalid class name */
                    /* loaded from: classes2.dex */
                    public static final class AnonymousClass2 implements Function3<RowScope, Composer, Integer, Unit> {
                        final /* synthetic */ Function1<FerrySeat, Unit> $onSeatPressed;
                        final /* synthetic */ float $rotation;
                        final /* synthetic */ List<FerrySeat> $selectedSeats;
                        final /* synthetic */ FerrySeatingGroupType.XLargeTable $xLargeTable;

                        /* JADX WARN: Multi-variable type inference failed */
                        AnonymousClass2(FerrySeatingGroupType.XLargeTable xLargeTable, float f5, List<FerrySeat> list, Function1<? super FerrySeat, Unit> function1) {
                            this.$xLargeTable = xLargeTable;
                            this.$rotation = f5;
                            this.$selectedSeats = list;
                            this.$onSeatPressed = function1;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final Unit invoke$lambda$1$lambda$0(Function1 function1, FerrySeatingGroupType.XLargeTable xLargeTable) {
                            function1.invoke(xLargeTable.getBottomLeft());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final Unit invoke$lambda$3$lambda$2(Function1 function1, FerrySeatingGroupType.XLargeTable xLargeTable) {
                            function1.invoke(xLargeTable.getBottomMiddle());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final Unit invoke$lambda$5$lambda$4(Function1 function1, FerrySeatingGroupType.XLargeTable xLargeTable) {
                            function1.invoke(xLargeTable.getBottomRight());
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
                                ComposerKt.traceEventStart(-1348368895, i5, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.groups.XLargeTableView.<anonymous>.<anonymous> (XLargeTableView.kt:54)");
                            }
                            FerrySeatingGroupType.XLargeTable xLargeTable = this.$xLargeTable;
                            FerrySeatType seatType = xLargeTable.getBottomLeft().getSeatType();
                            SeatOrientation seatOrientation = SeatOrientation.Up;
                            float f5 = this.$rotation;
                            boolean contains = this.$selectedSeats.contains(this.$xLargeTable.getBottomLeft());
                            composer.startReplaceGroup(-1780874449);
                            boolean changed = composer.changed(this.$onSeatPressed) | composer.changedInstance(this.$xLargeTable);
                            final Function1<FerrySeat, Unit> function1 = this.$onSeatPressed;
                            final FerrySeatingGroupType.XLargeTable xLargeTable2 = this.$xLargeTable;
                            Object rememberedValue = composer.rememberedValue();
                            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = 
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x006d: CONSTRUCTOR (r8v1 'rememberedValue' java.lang.Object) = 
                                      (r4v4 'function1' kotlin.jvm.functions.Function1<uniffi.molslinjen_shared.FerrySeat, kotlin.Unit> A[DONT_INLINE])
                                      (r5v0 'xLargeTable2' uniffi.molslinjen_shared.FerrySeatingGroupType$XLargeTable A[DONT_INLINE])
                                     A[MD:(kotlin.jvm.functions.Function1, uniffi.molslinjen_shared.FerrySeatingGroupType$XLargeTable):void (m)] (LINE:13) call: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.y.<init>(kotlin.jvm.functions.Function1, uniffi.molslinjen_shared.FerrySeatingGroupType$XLargeTable):void type: CONSTRUCTOR in method: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.XLargeTableViewKt$XLargeTableView$1.2.invoke(androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, int):void, file: classes2.dex
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
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.y, state: NOT_LOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                    	... 25 more
                                    */
                                /*
                                    Method dump skipped, instructions count: 314
                                    To view this dump add '--comments-level debug' option
                                */
                                throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.XLargeTableViewKt$XLargeTableView$1.AnonymousClass2.invoke(androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, int):void");
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
                                ComposerKt.traceEventStart(434760284, i8, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.groups.XLargeTableView.<anonymous> (XLargeTableView.kt:24)");
                            }
                            int i9 = (i8 & 14) | 48;
                            BaseSeatingViewsKt.BaseSeatingRow(BaseSeatingContainer, ComposableLambdaKt.rememberComposableLambda(761451449, true, new AnonymousClass1(FerrySeatingGroupType.XLargeTable.this, f5, selectedSeats, onSeatPressed), composer2, 54), composer2, i9);
                            BaseSeatingViewsKt.BaseSeatingRow(BaseSeatingContainer, ComposableSingletons$XLargeTableViewKt.INSTANCE.m3441getLambda1$app_kombardoProd(), composer2, i9);
                            BaseSeatingViewsKt.BaseSeatingRow(BaseSeatingContainer, ComposableLambdaKt.rememberComposableLambda(-1348368895, true, new AnonymousClass2(FerrySeatingGroupType.XLargeTable.this, f5, selectedSeats, onSeatPressed), composer2, 54), composer2, i9);
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
                    endRestartGroup.updateScope(new Function2() { // from class: F2.k
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit XLargeTableView$lambda$0;
                            XLargeTableView$lambda$0 = XLargeTableViewKt.XLargeTableView$lambda$0(FerrySeatingGroupType.XLargeTable.this, origin, f5, selectedSeats, onSeatPressed, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return XLargeTableView$lambda$0;
                        }
                    });
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit XLargeTableView$lambda$0(FerrySeatingGroupType.XLargeTable xLargeTable, Point point, float f5, List list, Function1 function1, int i5, Composer composer, int i6) {
                XLargeTableView(xLargeTable, point, f5, list, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                return Unit.INSTANCE;
            }
        }
