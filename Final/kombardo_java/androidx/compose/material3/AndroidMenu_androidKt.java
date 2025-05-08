package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material3.internal.DropdownMenuPositionProvider;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000N\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0098\u0001\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00030\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\"\u001a\u0010\u001c\u001a\u00020\u000b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {BuildConfig.FLAVOR, "expanded", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onDismissRequest", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/unit/DpOffset;", "offset", "Landroidx/compose/foundation/ScrollState;", "scrollState", "Landroidx/compose/ui/window/PopupProperties;", "properties", "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/ui/graphics/Color;", "containerColor", "Landroidx/compose/ui/unit/Dp;", "tonalElevation", "shadowElevation", "Landroidx/compose/foundation/BorderStroke;", "border", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "content", "DropdownMenu-IlH_yew", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/ScrollState;Landroidx/compose/ui/window/PopupProperties;Landroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "DropdownMenu", "DefaultMenuProperties", "Landroidx/compose/ui/window/PopupProperties;", "getDefaultMenuProperties", "()Landroidx/compose/ui/window/PopupProperties;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AndroidMenu_androidKt {
    private static final PopupProperties DefaultMenuProperties = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);

    /* JADX WARN: Removed duplicated region for block: B:102:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0293  */
    /* renamed from: DropdownMenu-IlH_yew, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m769DropdownMenuIlH_yew(final boolean z5, final Function0<Unit> function0, Modifier modifier, long j5, ScrollState scrollState, PopupProperties popupProperties, Shape shape, long j6, float f5, float f6, BorderStroke borderStroke, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i5, final int i6, final int i7) {
        int i8;
        int i9;
        Modifier modifier2;
        int i10;
        int i11;
        PopupProperties popupProperties2;
        Shape shape2;
        int i12;
        int i13;
        int i14;
        int i15;
        Modifier modifier3;
        long j7;
        ScrollState scrollState2;
        PopupProperties popupProperties3;
        long j8;
        BorderStroke borderStroke2;
        int i16;
        float f7;
        float f8;
        long j9;
        Object rememberedValue;
        Composer.Companion companion;
        final MutableTransitionState mutableTransitionState;
        Object rememberedValue2;
        PopupProperties popupProperties4;
        boolean changed;
        Object rememberedValue3;
        final PopupProperties popupProperties5;
        final BorderStroke borderStroke3;
        final Shape shape3;
        final float f9;
        final float f10;
        final long j10;
        final Modifier modifier4;
        final long j11;
        final ScrollState scrollState3;
        ScopeUpdateScope endRestartGroup;
        int i17;
        Composer startRestartGroup = composer.startRestartGroup(1431928300);
        if ((i7 & 1) != 0) {
            i8 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i8 = (startRestartGroup.changed(z5) ? 4 : 2) | i5;
        } else {
            i8 = i5;
        }
        if ((i7 & 2) != 0) {
            i8 |= 48;
        } else if ((i5 & 48) == 0) {
            i8 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
            i9 = i7 & 4;
            if (i9 == 0) {
                i8 |= 384;
            } else if ((i5 & 384) == 0) {
                modifier2 = modifier;
                i8 |= startRestartGroup.changed(modifier2) ? 256 : 128;
                i10 = i7 & 8;
                if (i10 != 0) {
                    i8 |= 3072;
                } else if ((i5 & 3072) == 0) {
                    i8 |= startRestartGroup.changed(j5) ? 2048 : 1024;
                }
                if ((i5 & 24576) == 0) {
                    if ((i7 & 16) == 0 && startRestartGroup.changed(scrollState)) {
                        i17 = 16384;
                        i8 |= i17;
                    }
                    i17 = 8192;
                    i8 |= i17;
                }
                i11 = i7 & 32;
                if (i11 != 0) {
                    i8 |= 196608;
                    popupProperties2 = popupProperties;
                } else {
                    popupProperties2 = popupProperties;
                    if ((i5 & 196608) == 0) {
                        i8 |= startRestartGroup.changed(popupProperties2) ? 131072 : 65536;
                    }
                }
                if ((i5 & 1572864) == 0) {
                    shape2 = shape;
                    i8 |= ((i7 & 64) == 0 && startRestartGroup.changed(shape2)) ? 1048576 : 524288;
                } else {
                    shape2 = shape;
                }
                if ((i5 & 12582912) == 0) {
                    i8 |= ((i7 & 128) == 0 && startRestartGroup.changed(j6)) ? 8388608 : 4194304;
                }
                i12 = i7 & 256;
                if (i12 != 0) {
                    i8 |= 100663296;
                } else if ((i5 & 100663296) == 0) {
                    i8 |= startRestartGroup.changed(f5) ? 67108864 : 33554432;
                }
                i13 = i7 & 512;
                if (i13 != 0) {
                    i8 |= 805306368;
                } else if ((i5 & 805306368) == 0) {
                    i8 |= startRestartGroup.changed(f6) ? 536870912 : 268435456;
                }
                i14 = i7 & 1024;
                if (i14 != 0) {
                    i15 = i6 | 6;
                } else if ((i6 & 6) == 0) {
                    i15 = i6 | (startRestartGroup.changed(borderStroke) ? 4 : 2);
                } else {
                    i15 = i6;
                }
                if ((i7 & 2048) != 0) {
                    i15 |= 48;
                } else if ((i6 & 48) == 0) {
                    i15 |= startRestartGroup.changedInstance(function3) ? 32 : 16;
                }
                int i18 = i15;
                if ((i8 & 306783379) != 306783378 && (i18 & 19) == 18 && startRestartGroup.getSkipping()) {
                    startRestartGroup.skipToGroupEnd();
                    j11 = j5;
                    scrollState3 = scrollState;
                    f10 = f5;
                    modifier4 = modifier2;
                    shape3 = shape2;
                    popupProperties5 = popupProperties2;
                    j10 = j6;
                    f9 = f6;
                    borderStroke3 = borderStroke;
                } else {
                    startRestartGroup.startDefaults();
                    if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        modifier3 = i9 != 0 ? Modifier.INSTANCE : modifier2;
                        if (i10 != 0) {
                            float f11 = 0;
                            j7 = DpKt.m2609DpOffsetYgX7TsA(Dp.m2599constructorimpl(f11), Dp.m2599constructorimpl(f11));
                        } else {
                            j7 = j5;
                        }
                        if ((i7 & 16) != 0) {
                            scrollState2 = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
                            i8 &= -57345;
                        } else {
                            scrollState2 = scrollState;
                        }
                        popupProperties3 = i11 != 0 ? DefaultMenuProperties : popupProperties2;
                        if ((i7 & 64) != 0) {
                            shape2 = MenuDefaults.INSTANCE.getShape(startRestartGroup, 6);
                            i8 &= -3670017;
                        }
                        if ((i7 & 128) != 0) {
                            j8 = MenuDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                            i8 &= -29360129;
                        } else {
                            j8 = j6;
                        }
                        float m865getTonalElevationD9Ej5fM = i12 != 0 ? MenuDefaults.INSTANCE.m865getTonalElevationD9Ej5fM() : f5;
                        float m864getShadowElevationD9Ej5fM = i13 != 0 ? MenuDefaults.INSTANCE.m864getShadowElevationD9Ej5fM() : f6;
                        if (i14 != 0) {
                            i16 = i8;
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                            i16 = i8;
                        }
                        f7 = m864getShadowElevationD9Ej5fM;
                        f8 = m865getTonalElevationD9Ej5fM;
                        j9 = j8;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i7 & 16) != 0) {
                            i8 &= -57345;
                        }
                        if ((i7 & 64) != 0) {
                            i8 &= -3670017;
                        }
                        if ((i7 & 128) != 0) {
                            i8 &= -29360129;
                        }
                        scrollState2 = scrollState;
                        j9 = j6;
                        f8 = f5;
                        borderStroke2 = borderStroke;
                        modifier3 = modifier2;
                        popupProperties3 = popupProperties2;
                        j7 = j5;
                        i16 = i8;
                        f7 = f6;
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1431928300, i16, i18, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:54)");
                    }
                    rememberedValue = startRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (rememberedValue == companion.getEmpty()) {
                        rememberedValue = new MutableTransitionState(Boolean.FALSE);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    mutableTransitionState = (MutableTransitionState) rememberedValue;
                    mutableTransitionState.setTargetState(Boolean.valueOf(z5));
                    if (!((Boolean) mutableTransitionState.getCurrentState()).booleanValue() || ((Boolean) mutableTransitionState.getTargetState()).booleanValue()) {
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == companion.getEmpty()) {
                            popupProperties4 = popupProperties3;
                            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m1626boximpl(TransformOrigin.INSTANCE.m1635getCenterSzJe1aQ()), null, 2, null);
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        } else {
                            popupProperties4 = popupProperties3;
                        }
                        final MutableState mutableState = (MutableState) rememberedValue2;
                        Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        int i19 = i16;
                        changed = ((i16 & 7168) == 2048) | startRestartGroup.changed(density);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!changed || rememberedValue3 == companion.getEmpty()) {
                            rememberedValue3 = new DropdownMenuPositionProvider(j7, density, 0, new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(IntRect intRect, IntRect intRect2) {
                                    invoke2(intRect, intRect2);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(IntRect intRect, IntRect intRect2) {
                                    mutableState.setValue(TransformOrigin.m1626boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
                                }
                            }, 4, null);
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                        }
                        final Modifier modifier5 = modifier3;
                        final ScrollState scrollState4 = scrollState2;
                        final Shape shape4 = shape2;
                        final long j12 = j9;
                        final float f12 = f8;
                        final float f13 = f7;
                        final BorderStroke borderStroke4 = borderStroke2;
                        AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) rememberedValue3, function0, popupProperties4, ComposableLambdaKt.rememberComposableLambda(2126968933, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$1
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

                            public final void invoke(Composer composer2, int i20) {
                                if ((i20 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2126968933, i20, -1, "androidx.compose.material3.DropdownMenu.<anonymous> (AndroidMenu.android.kt:73)");
                                }
                                MenuKt.m866DropdownMenuContentQj0Zi0g(Modifier.this, mutableTransitionState, mutableState, scrollState4, shape4, j12, f12, f13, borderStroke4, function3, composer2, (MutableTransitionState.$stable << 3) | 384);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, startRestartGroup, 54), startRestartGroup, (i19 & 112) | 3072 | ((i19 >> 9) & 896), 0);
                    } else {
                        popupProperties4 = popupProperties3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    popupProperties5 = popupProperties4;
                    borderStroke3 = borderStroke2;
                    shape3 = shape2;
                    f9 = f7;
                    f10 = f8;
                    j10 = j9;
                    modifier4 = modifier3;
                    j11 = j7;
                    scrollState3 = scrollState2;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$2
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

                        public final void invoke(Composer composer2, int i20) {
                            AndroidMenu_androidKt.m769DropdownMenuIlH_yew(z5, function0, modifier4, j11, scrollState3, popupProperties5, shape3, j10, f10, f9, borderStroke3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6), i7);
                        }
                    });
                    return;
                }
                return;
            }
            modifier2 = modifier;
            i10 = i7 & 8;
            if (i10 != 0) {
            }
            if ((i5 & 24576) == 0) {
            }
            i11 = i7 & 32;
            if (i11 != 0) {
            }
            if ((i5 & 1572864) == 0) {
            }
            if ((i5 & 12582912) == 0) {
            }
            i12 = i7 & 256;
            if (i12 != 0) {
            }
            i13 = i7 & 512;
            if (i13 != 0) {
            }
            i14 = i7 & 1024;
            if (i14 != 0) {
            }
            if ((i7 & 2048) != 0) {
            }
            int i182 = i15;
            if ((i8 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if ((i7 & 16) != 0) {
            }
            if (i11 != 0) {
            }
            if ((i7 & 64) != 0) {
            }
            if ((i7 & 128) != 0) {
            }
            if (i12 != 0) {
            }
            if (i13 != 0) {
            }
            if (i14 != 0) {
            }
            f7 = m864getShadowElevationD9Ej5fM;
            f8 = m865getTonalElevationD9Ej5fM;
            j9 = j8;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            rememberedValue = startRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
            }
            mutableTransitionState = (MutableTransitionState) rememberedValue;
            mutableTransitionState.setTargetState(Boolean.valueOf(z5));
            if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
            }
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
            }
            final MutableState<TransformOrigin> mutableState2 = (MutableState) rememberedValue2;
            Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            int i192 = i16;
            changed = ((i16 & 7168) == 2048) | startRestartGroup.changed(density2);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue3 = new DropdownMenuPositionProvider(j7, density2, 0, new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(IntRect intRect, IntRect intRect2) {
                    invoke2(intRect, intRect2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(IntRect intRect, IntRect intRect2) {
                    mutableState2.setValue(TransformOrigin.m1626boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
                }
            }, 4, null);
            startRestartGroup.updateRememberedValue(rememberedValue3);
            final Modifier modifier52 = modifier3;
            final ScrollState scrollState42 = scrollState2;
            final Shape shape42 = shape2;
            final long j122 = j9;
            final float f122 = f8;
            final float f132 = f7;
            final BorderStroke borderStroke42 = borderStroke2;
            AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) rememberedValue3, function0, popupProperties4, ComposableLambdaKt.rememberComposableLambda(2126968933, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$1
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

                public final void invoke(Composer composer2, int i20) {
                    if ((i20 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2126968933, i20, -1, "androidx.compose.material3.DropdownMenu.<anonymous> (AndroidMenu.android.kt:73)");
                    }
                    MenuKt.m866DropdownMenuContentQj0Zi0g(Modifier.this, mutableTransitionState, mutableState2, scrollState42, shape42, j122, f122, f132, borderStroke42, function3, composer2, (MutableTransitionState.$stable << 3) | 384);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, (i192 & 112) | 3072 | ((i192 >> 9) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            popupProperties5 = popupProperties4;
            borderStroke3 = borderStroke2;
            shape3 = shape2;
            f9 = f7;
            f10 = f8;
            j10 = j9;
            modifier4 = modifier3;
            j11 = j7;
            scrollState3 = scrollState2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i9 = i7 & 4;
        if (i9 == 0) {
        }
        modifier2 = modifier;
        i10 = i7 & 8;
        if (i10 != 0) {
        }
        if ((i5 & 24576) == 0) {
        }
        i11 = i7 & 32;
        if (i11 != 0) {
        }
        if ((i5 & 1572864) == 0) {
        }
        if ((i5 & 12582912) == 0) {
        }
        i12 = i7 & 256;
        if (i12 != 0) {
        }
        i13 = i7 & 512;
        if (i13 != 0) {
        }
        i14 = i7 & 1024;
        if (i14 != 0) {
        }
        if ((i7 & 2048) != 0) {
        }
        int i1822 = i15;
        if ((i8 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if ((i7 & 16) != 0) {
        }
        if (i11 != 0) {
        }
        if ((i7 & 64) != 0) {
        }
        if ((i7 & 128) != 0) {
        }
        if (i12 != 0) {
        }
        if (i13 != 0) {
        }
        if (i14 != 0) {
        }
        f7 = m864getShadowElevationD9Ej5fM;
        f8 = m865getTonalElevationD9Ej5fM;
        j9 = j8;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        mutableTransitionState = (MutableTransitionState) rememberedValue;
        mutableTransitionState.setTargetState(Boolean.valueOf(z5));
        if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
        }
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
        }
        final MutableState<TransformOrigin> mutableState22 = (MutableState) rememberedValue2;
        Density density22 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        int i1922 = i16;
        changed = ((i16 & 7168) == 2048) | startRestartGroup.changed(density22);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue3 = new DropdownMenuPositionProvider(j7, density22, 0, new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(IntRect intRect, IntRect intRect2) {
                invoke2(intRect, intRect2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IntRect intRect, IntRect intRect2) {
                mutableState22.setValue(TransformOrigin.m1626boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
            }
        }, 4, null);
        startRestartGroup.updateRememberedValue(rememberedValue3);
        final Modifier modifier522 = modifier3;
        final ScrollState scrollState422 = scrollState2;
        final Shape shape422 = shape2;
        final long j1222 = j9;
        final float f1222 = f8;
        final float f1322 = f7;
        final BorderStroke borderStroke422 = borderStroke2;
        AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) rememberedValue3, function0, popupProperties4, ComposableLambdaKt.rememberComposableLambda(2126968933, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$1
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

            public final void invoke(Composer composer2, int i20) {
                if ((i20 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2126968933, i20, -1, "androidx.compose.material3.DropdownMenu.<anonymous> (AndroidMenu.android.kt:73)");
                }
                MenuKt.m866DropdownMenuContentQj0Zi0g(Modifier.this, mutableTransitionState, mutableState22, scrollState422, shape422, j1222, f1222, f1322, borderStroke422, function3, composer2, (MutableTransitionState.$stable << 3) | 384);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), startRestartGroup, (i1922 & 112) | 3072 | ((i1922 >> 9) & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        popupProperties5 = popupProperties4;
        borderStroke3 = borderStroke2;
        shape3 = shape2;
        f9 = f7;
        f10 = f8;
        j10 = j9;
        modifier4 = modifier3;
        j11 = j7;
        scrollState3 = scrollState2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
