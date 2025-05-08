package dk.molslinjen.ui.views.screens.booking.addons.seating.groups;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import dk.molslinjen.ui.views.screens.booking.addons.seating.groups.DoubleSeatViewKt;
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

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001aI\u0010\f\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Luniffi/molslinjen_shared/FerrySeatingGroupType$DoubleSeat;", "doubleSeat", "Luniffi/molslinjen_shared/Point;", "origin", BuildConfig.FLAVOR, "rotation", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/FerrySeat;", "selectedSeats", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onSeatPressed", "DoubleSeatView", "(Luniffi/molslinjen_shared/FerrySeatingGroupType$DoubleSeat;Luniffi/molslinjen_shared/Point;FLjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DoubleSeatViewKt {
    public static final void DoubleSeatView(final FerrySeatingGroupType.DoubleSeat doubleSeat, final Point origin, final float f5, final List<FerrySeat> selectedSeats, final Function1<? super FerrySeat, Unit> onSeatPressed, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(doubleSeat, "doubleSeat");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(selectedSeats, "selectedSeats");
        Intrinsics.checkNotNullParameter(onSeatPressed, "onSeatPressed");
        Composer startRestartGroup = composer.startRestartGroup(1419827299);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(doubleSeat) ? 4 : 2) | i5;
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
                ComposerKt.traceEventStart(1419827299, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.groups.DoubleSeatView (DoubleSeatView.kt:17)");
            }
            int i7 = i6 >> 3;
            BaseSeatingViewsKt.BaseSeatingContainer(origin, f5, ComposableLambdaKt.rememberComposableLambda(1208494647, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.DoubleSeatViewKt$DoubleSeatView$1

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                /* renamed from: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.DoubleSeatViewKt$DoubleSeatView$1$1, reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass1 implements Function3<RowScope, Composer, Integer, Unit> {
                    final /* synthetic */ FerrySeatingGroupType.DoubleSeat $doubleSeat;
                    final /* synthetic */ Function1<FerrySeat, Unit> $onSeatPressed;
                    final /* synthetic */ float $rotation;
                    final /* synthetic */ List<FerrySeat> $selectedSeats;

                    /* JADX WARN: Multi-variable type inference failed */
                    AnonymousClass1(FerrySeatingGroupType.DoubleSeat doubleSeat, float f5, List<FerrySeat> list, Function1<? super FerrySeat, Unit> function1) {
                        this.$doubleSeat = doubleSeat;
                        this.$rotation = f5;
                        this.$selectedSeats = list;
                        this.$onSeatPressed = function1;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$1$lambda$0(Function1 function1, FerrySeatingGroupType.DoubleSeat doubleSeat) {
                        function1.invoke(doubleSeat.getLeft());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$3$lambda$2(Function1 function1, FerrySeatingGroupType.DoubleSeat doubleSeat) {
                        function1.invoke(doubleSeat.getRight());
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
                            ComposerKt.traceEventStart(-111802886, i5, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.groups.DoubleSeatView.<anonymous>.<anonymous> (DoubleSeatView.kt:23)");
                        }
                        FerrySeatingGroupType.DoubleSeat doubleSeat = this.$doubleSeat;
                        FerrySeatType seatType = doubleSeat.getLeft().getSeatType();
                        float f5 = this.$rotation;
                        boolean contains = this.$selectedSeats.contains(this.$doubleSeat.getLeft());
                        composer.startReplaceGroup(-1646589309);
                        boolean changed = composer.changed(this.$onSeatPressed) | composer.changedInstance(this.$doubleSeat);
                        final Function1<FerrySeat, Unit> function1 = this.$onSeatPressed;
                        final FerrySeatingGroupType.DoubleSeat doubleSeat2 = this.$doubleSeat;
                        Object rememberedValue = composer.rememberedValue();
                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = 
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x006a: CONSTRUCTOR (r8v1 'rememberedValue' java.lang.Object) = 
                                  (r4v4 'function1' kotlin.jvm.functions.Function1<uniffi.molslinjen_shared.FerrySeat, kotlin.Unit> A[DONT_INLINE])
                                  (r5v0 'doubleSeat2' uniffi.molslinjen_shared.FerrySeatingGroupType$DoubleSeat A[DONT_INLINE])
                                 A[MD:(kotlin.jvm.functions.Function1, uniffi.molslinjen_shared.FerrySeatingGroupType$DoubleSeat):void (m)] (LINE:12) call: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.m.<init>(kotlin.jvm.functions.Function1, uniffi.molslinjen_shared.FerrySeatingGroupType$DoubleSeat):void type: CONSTRUCTOR in method: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.DoubleSeatViewKt$DoubleSeatView$1.1.invoke(androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, int):void, file: classes2.dex
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
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.m, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	... 25 more
                                */
                            /*
                                this = this;
                                r0 = r13
                                r12 = r15
                                r1 = r16
                                java.lang.String r2 = "$this$BaseSeatingRow"
                                r3 = r14
                                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r2)
                                r2 = r1 & 17
                                r3 = 16
                                if (r2 != r3) goto L1c
                                boolean r2 = r15.getSkipping()
                                if (r2 != 0) goto L17
                                goto L1c
                            L17:
                                r15.skipToGroupEnd()
                                goto Lde
                            L1c:
                                boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                if (r2 == 0) goto L2b
                                r2 = -1
                                java.lang.String r3 = "dk.molslinjen.ui.views.screens.booking.addons.seating.groups.DoubleSeatView.<anonymous>.<anonymous> (DoubleSeatView.kt:23)"
                                r4 = -111802886(0xfffffffff95605fa, float:-6.9454547E34)
                                androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r2, r3)
                            L2b:
                                uniffi.molslinjen_shared.FerrySeatingGroupType$DoubleSeat r1 = r0.$doubleSeat
                                uniffi.molslinjen_shared.FerrySeat r2 = r1.getLeft()
                                uniffi.molslinjen_shared.FerrySeatType r3 = r2.getSeatType()
                                float r6 = r0.$rotation
                                java.util.List<uniffi.molslinjen_shared.FerrySeat> r2 = r0.$selectedSeats
                                uniffi.molslinjen_shared.FerrySeatingGroupType$DoubleSeat r4 = r0.$doubleSeat
                                uniffi.molslinjen_shared.FerrySeat r4 = r4.getLeft()
                                boolean r7 = r2.contains(r4)
                                r2 = -1646589309(0xffffffff9ddb0a83, float:-5.7979686E-21)
                                r15.startReplaceGroup(r2)
                                kotlin.jvm.functions.Function1<uniffi.molslinjen_shared.FerrySeat, kotlin.Unit> r2 = r0.$onSeatPressed
                                boolean r2 = r15.changed(r2)
                                uniffi.molslinjen_shared.FerrySeatingGroupType$DoubleSeat r4 = r0.$doubleSeat
                                boolean r4 = r15.changedInstance(r4)
                                r2 = r2 | r4
                                kotlin.jvm.functions.Function1<uniffi.molslinjen_shared.FerrySeat, kotlin.Unit> r4 = r0.$onSeatPressed
                                uniffi.molslinjen_shared.FerrySeatingGroupType$DoubleSeat r5 = r0.$doubleSeat
                                java.lang.Object r8 = r15.rememberedValue()
                                if (r2 != 0) goto L68
                                androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.INSTANCE
                                java.lang.Object r2 = r2.getEmpty()
                                if (r8 != r2) goto L70
                            L68:
                                dk.molslinjen.ui.views.screens.booking.addons.seating.groups.m r8 = new dk.molslinjen.ui.views.screens.booking.addons.seating.groups.m
                                r8.<init>(r4, r5)
                                r15.updateRememberedValue(r8)
                            L70:
                                kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
                                r15.endReplaceGroup()
                                r10 = 48
                                r11 = 24
                                r2 = 1
                                r4 = 0
                                r5 = 0
                                r9 = r15
                                dk.molslinjen.ui.views.screens.booking.addons.seating.seat.FerrySeatViewKt.m3442FerrySeatViewaA_HZ9I(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                                uniffi.molslinjen_shared.FerrySeatingGroupType$DoubleSeat r1 = r0.$doubleSeat
                                uniffi.molslinjen_shared.FerrySeat r2 = r1.getRight()
                                uniffi.molslinjen_shared.FerrySeatType r3 = r2.getSeatType()
                                float r6 = r0.$rotation
                                java.util.List<uniffi.molslinjen_shared.FerrySeat> r2 = r0.$selectedSeats
                                uniffi.molslinjen_shared.FerrySeatingGroupType$DoubleSeat r4 = r0.$doubleSeat
                                uniffi.molslinjen_shared.FerrySeat r4 = r4.getRight()
                                boolean r7 = r2.contains(r4)
                                r2 = -1646578172(0xffffffff9ddb3604, float:-5.802467E-21)
                                r15.startReplaceGroup(r2)
                                kotlin.jvm.functions.Function1<uniffi.molslinjen_shared.FerrySeat, kotlin.Unit> r2 = r0.$onSeatPressed
                                boolean r2 = r15.changed(r2)
                                uniffi.molslinjen_shared.FerrySeatingGroupType$DoubleSeat r4 = r0.$doubleSeat
                                boolean r4 = r15.changedInstance(r4)
                                r2 = r2 | r4
                                kotlin.jvm.functions.Function1<uniffi.molslinjen_shared.FerrySeat, kotlin.Unit> r4 = r0.$onSeatPressed
                                uniffi.molslinjen_shared.FerrySeatingGroupType$DoubleSeat r5 = r0.$doubleSeat
                                java.lang.Object r8 = r15.rememberedValue()
                                if (r2 != 0) goto Lbd
                                androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.INSTANCE
                                java.lang.Object r2 = r2.getEmpty()
                                if (r8 != r2) goto Lc5
                            Lbd:
                                dk.molslinjen.ui.views.screens.booking.addons.seating.groups.n r8 = new dk.molslinjen.ui.views.screens.booking.addons.seating.groups.n
                                r8.<init>(r4, r5)
                                r15.updateRememberedValue(r8)
                            Lc5:
                                kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
                                r15.endReplaceGroup()
                                r10 = 48
                                r11 = 24
                                r2 = 2
                                r4 = 0
                                r5 = 0
                                r9 = r15
                                dk.molslinjen.ui.views.screens.booking.addons.seating.seat.FerrySeatViewKt.m3442FerrySeatViewaA_HZ9I(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                                boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                if (r1 == 0) goto Lde
                                androidx.compose.runtime.ComposerKt.traceEventEnd()
                            Lde:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.DoubleSeatViewKt$DoubleSeatView$1.AnonymousClass1.invoke(androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, int):void");
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
                            ComposerKt.traceEventStart(1208494647, i8, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.groups.DoubleSeatView.<anonymous> (DoubleSeatView.kt:22)");
                        }
                        BaseSeatingViewsKt.BaseSeatingRow(BaseSeatingContainer, ComposableLambdaKt.rememberComposableLambda(-111802886, true, new AnonymousClass1(FerrySeatingGroupType.DoubleSeat.this, f5, selectedSeats, onSeatPressed), composer2, 54), composer2, (i8 & 14) | 48);
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
                endRestartGroup.updateScope(new Function2() { // from class: F2.g
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit DoubleSeatView$lambda$0;
                        DoubleSeatView$lambda$0 = DoubleSeatViewKt.DoubleSeatView$lambda$0(FerrySeatingGroupType.DoubleSeat.this, origin, f5, selectedSeats, onSeatPressed, i5, (Composer) obj, ((Integer) obj2).intValue());
                        return DoubleSeatView$lambda$0;
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit DoubleSeatView$lambda$0(FerrySeatingGroupType.DoubleSeat doubleSeat, Point point, float f5, List list, Function1 function1, int i5, Composer composer, int i6) {
            DoubleSeatView(doubleSeat, point, f5, list, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
            return Unit.INSTANCE;
        }
    }
