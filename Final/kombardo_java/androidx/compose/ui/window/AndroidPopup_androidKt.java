package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u001aP\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001aA\u0010\f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\f\u0010\u000f\u001a'\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0013\u0010\u0019\u001a\u00020\u0010*\u00020\u0018H\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001b\u0010\u001c\u001a\u00020\u0015*\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0013\u0010 \u001a\u00020\u001f*\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!\"\u0014\u0010\"\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010#\" \u0010&\u001a\b\u0012\u0004\u0012\u00020%0$8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006+²\u0006\u0012\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/ui/Alignment;", "alignment", "Landroidx/compose/ui/unit/IntOffset;", "offset", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onDismissRequest", "Landroidx/compose/ui/window/PopupProperties;", "properties", "content", "Popup-K5zGePQ", "(Landroidx/compose/ui/Alignment;JLkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Popup", "Landroidx/compose/ui/window/PopupPositionProvider;", "popupPositionProvider", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", BuildConfig.FLAVOR, "focusable", "Landroidx/compose/ui/window/SecureFlagPolicy;", "securePolicy", "clippingEnabled", BuildConfig.FLAVOR, "createFlags", "(ZLandroidx/compose/ui/window/SecureFlagPolicy;Z)I", "Landroid/view/View;", "isFlagSecureEnabled", "(Landroid/view/View;)Z", "isParentFlagSecureEnabled", "flagsWithSecureFlagInherited", "(Landroidx/compose/ui/window/PopupProperties;Z)I", "Landroid/graphics/Rect;", "Landroidx/compose/ui/unit/IntRect;", "toIntBounds", "(Landroid/graphics/Rect;)Landroidx/compose/ui/unit/IntRect;", "PopupPropertiesBaseFlags", "I", "Landroidx/compose/runtime/ProvidableCompositionLocal;", BuildConfig.FLAVOR, "LocalPopupTestTag", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalPopupTestTag", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "currentContent", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AndroidPopup_androidKt {
    private static final ProvidableCompositionLocal<String> LocalPopupTestTag = CompositionLocalKt.compositionLocalOf$default(null, new Function0<String>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$LocalPopupTestTag$1
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return "DEFAULT_TEST_TAG";
        }
    }, 1, null);
    private static final int PopupPropertiesBaseFlags = 262144;

    /* JADX WARN: Removed duplicated region for block: B:100:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Popup(final PopupPositionProvider popupPositionProvider, Function0<Unit> function0, PopupProperties popupProperties, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i5, final int i6) {
        int i7;
        Function0<Unit> function02;
        int i8;
        PopupProperties popupProperties2;
        int i9;
        Function0<Unit> function03;
        PopupProperties popupProperties3;
        Object rememberedValue;
        Composer.Companion companion;
        String str;
        boolean z5;
        int i10;
        int i11;
        Object obj;
        boolean changedInstance;
        Object rememberedValue2;
        boolean changedInstance2;
        Object rememberedValue3;
        boolean changedInstance3;
        Object rememberedValue4;
        boolean changedInstance4;
        Object rememberedValue5;
        boolean changedInstance5;
        Object rememberedValue6;
        boolean changedInstance6;
        Object rememberedValue7;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        final Function0<Unit> function04;
        final PopupProperties popupProperties4;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-830247068);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(popupPositionProvider) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i12 = i6 & 2;
        if (i12 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            function02 = function0;
            i7 |= startRestartGroup.changedInstance(function02) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                popupProperties2 = popupProperties;
                i7 |= startRestartGroup.changed(popupProperties2) ? 256 : 128;
                if ((i6 & 8) != 0) {
                    i7 |= 3072;
                } else if ((i5 & 3072) == 0) {
                    i7 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
                }
                i9 = i7;
                if ((i9 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                    function03 = i12 != 0 ? null : function02;
                    popupProperties3 = i8 != 0 ? new PopupProperties(false, false, false, false, 15, (DefaultConstructorMarker) null) : popupProperties2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-830247068, i9, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:302)");
                    }
                    View view = (View) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
                    Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    String str2 = (String) startRestartGroup.consume(LocalPopupTestTag);
                    final LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    CompositionContext rememberCompositionContext = ComposablesKt.rememberCompositionContext(startRestartGroup, 0);
                    final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, startRestartGroup, (i9 >> 9) & 14);
                    UUID uuid = (UUID) RememberSaveableKt.rememberSaveable(new Object[0], null, null, new Function0<UUID>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupId$1
                        @Override // kotlin.jvm.functions.Function0
                        public final UUID invoke() {
                            return UUID.randomUUID();
                        }
                    }, startRestartGroup, 3072, 6);
                    rememberedValue = startRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (rememberedValue == companion.getEmpty()) {
                        str = str2;
                        i10 = i9;
                        i11 = 32;
                        final PopupLayout popupLayout = new PopupLayout(function03, popupProperties3, str2, view, density, popupPositionProvider, uuid, null, 128, null);
                        Function2<Composer, Integer, Unit> function22 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1
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

                            public final void invoke(Composer composer2, int i13) {
                                if ((i13 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1302892335, i13, -1, "androidx.compose.ui.window.Popup.<anonymous>.<anonymous>.<anonymous> (AndroidPopup.android.kt:321)");
                                }
                                Modifier semantics$default = SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        invoke2(semanticsPropertyReceiver);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        SemanticsPropertiesKt.popup(semanticsPropertyReceiver);
                                    }
                                }, 1, null);
                                boolean changedInstance7 = composer2.changedInstance(PopupLayout.this);
                                final PopupLayout popupLayout2 = PopupLayout.this;
                                Object rememberedValue8 = composer2.rememberedValue();
                                if (changedInstance7 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue8 = new Function1<IntSize, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1$2$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                            m2716invokeozmzZPI(intSize.getPackedValue());
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                                        public final void m2716invokeozmzZPI(long j5) {
                                            PopupLayout.this.m2720setPopupContentSizefhxjrPA(IntSize.m2656boximpl(j5));
                                            PopupLayout.this.updatePosition();
                                        }
                                    };
                                    composer2.updateRememberedValue(rememberedValue8);
                                }
                                Modifier alpha = AlphaKt.alpha(OnRemeasuredModifierKt.onSizeChanged(semantics$default, (Function1) rememberedValue8), PopupLayout.this.getCanCalculatePosition() ? 1.0f : 0.0f);
                                final State<Function2<Composer, Integer, Unit>> state = rememberUpdatedState;
                                ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(606497925, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i14) {
                                        Function2 Popup$lambda$1;
                                        if ((i14 & 3) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(606497925, i14, -1, "androidx.compose.ui.window.Popup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AndroidPopup.android.kt:332)");
                                        }
                                        Popup$lambda$1 = AndroidPopup_androidKt.Popup$lambda$1(state);
                                        Popup$lambda$1.invoke(composer3, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer2, 54);
                                AndroidPopup_androidKt$SimpleStack$1 androidPopup_androidKt$SimpleStack$1 = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1
                                    @Override // androidx.compose.ui.layout.MeasurePolicy
                                    /* renamed from: measure-3p2s80s */
                                    public final MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                                        int i14;
                                        int i15;
                                        int size = list.size();
                                        if (size == 0) {
                                            return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1.1
                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(Placeable.PlacementScope placementScope) {
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                    invoke2(placementScope);
                                                    return Unit.INSTANCE;
                                                }
                                            }, 4, null);
                                        }
                                        int i16 = 0;
                                        if (size == 1) {
                                            final Placeable mo1946measureBRTryo0 = list.get(0).mo1946measureBRTryo0(j5);
                                            return MeasureScope.layout$default(measureScope, mo1946measureBRTryo0.getWidth(), mo1946measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1.2
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
                                                    Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
                                                }
                                            }, 4, null);
                                        }
                                        final ArrayList arrayList = new ArrayList(list.size());
                                        int size2 = list.size();
                                        for (int i17 = 0; i17 < size2; i17++) {
                                            arrayList.add(list.get(i17).mo1946measureBRTryo0(j5));
                                        }
                                        int lastIndex = CollectionsKt.getLastIndex(arrayList);
                                        if (lastIndex >= 0) {
                                            int i18 = 0;
                                            int i19 = 0;
                                            while (true) {
                                                Placeable placeable = (Placeable) arrayList.get(i16);
                                                i18 = Math.max(i18, placeable.getWidth());
                                                i19 = Math.max(i19, placeable.getHeight());
                                                if (i16 == lastIndex) {
                                                    break;
                                                }
                                                i16++;
                                            }
                                            i14 = i18;
                                            i15 = i19;
                                        } else {
                                            i14 = 0;
                                            i15 = 0;
                                        }
                                        return MeasureScope.layout$default(measureScope, i14, i15, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
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
                                                int lastIndex2 = CollectionsKt.getLastIndex(arrayList);
                                                if (lastIndex2 < 0) {
                                                    return;
                                                }
                                                int i20 = 0;
                                                while (true) {
                                                    Placeable.PlacementScope.placeRelative$default(placementScope, arrayList.get(i20), 0, 0, 0.0f, 4, null);
                                                    if (i20 == lastIndex2) {
                                                        return;
                                                    } else {
                                                        i20++;
                                                    }
                                                }
                                            }
                                        }, 4, null);
                                    }
                                };
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, alpha);
                                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                if (composer2.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor);
                                } else {
                                    composer2.useNode();
                                }
                                Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer2);
                                Updater.m1227setimpl(m1226constructorimpl2, androidPopup_androidKt$SimpleStack$1, companion2.getSetMeasurePolicy());
                                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                                if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash);
                                }
                                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier, companion2.getSetModifier());
                                rememberComposableLambda.invoke(composer2, 6);
                                composer2.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        };
                        z5 = true;
                        popupLayout.setContent(rememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(1302892335, true, function22));
                        startRestartGroup.updateRememberedValue(popupLayout);
                        obj = popupLayout;
                    } else {
                        str = str2;
                        z5 = true;
                        i10 = i9;
                        i11 = 32;
                        obj = rememberedValue;
                    }
                    final PopupLayout popupLayout2 = (PopupLayout) obj;
                    int i13 = i10;
                    int i14 = i13 & 112;
                    int i15 = i13 & 896;
                    final String str3 = str;
                    changedInstance = startRestartGroup.changedInstance(popupLayout2) | (i14 == i11 ? z5 : false) | (i15 == 256 ? z5 : false) | startRestartGroup.changed(str3) | startRestartGroup.changed(layoutDirection);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!changedInstance || rememberedValue2 == companion.getEmpty()) {
                        final Function0<Unit> function05 = function03;
                        final PopupProperties popupProperties5 = popupProperties3;
                        rememberedValue2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                PopupLayout.this.show();
                                PopupLayout.this.updateParameters(function05, popupProperties5, str3, layoutDirection);
                                final PopupLayout popupLayout3 = PopupLayout.this;
                                return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                        PopupLayout.this.disposeComposition();
                                        PopupLayout.this.dismiss();
                                    }
                                };
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    EffectsKt.DisposableEffect(popupLayout2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue2, startRestartGroup, 0);
                    changedInstance2 = (i14 == i11 ? z5 : false) | startRestartGroup.changedInstance(popupLayout2) | (i15 == 256 ? z5 : false) | startRestartGroup.changed(str3) | startRestartGroup.changed(layoutDirection);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (!changedInstance2 || rememberedValue3 == companion.getEmpty()) {
                        final Function0<Unit> function06 = function03;
                        final PopupProperties popupProperties6 = popupProperties3;
                        rememberedValue3 = new Function0<Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$3$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                PopupLayout.this.updateParameters(function06, popupProperties6, str3, layoutDirection);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                    }
                    EffectsKt.SideEffect((Function0) rememberedValue3, startRestartGroup, 0);
                    int i16 = i13 & 14;
                    changedInstance3 = startRestartGroup.changedInstance(popupLayout2) | (i16 == 4 ? z5 : false);
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (!changedInstance3 || rememberedValue4 == companion.getEmpty()) {
                        rememberedValue4 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                PopupLayout.this.setPositionProvider(popupPositionProvider);
                                PopupLayout.this.updatePosition();
                                return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                    }
                                };
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                    }
                    EffectsKt.DisposableEffect(popupPositionProvider, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue4, startRestartGroup, i16);
                    changedInstance4 = startRestartGroup.changedInstance(popupLayout2);
                    rememberedValue5 = startRestartGroup.rememberedValue();
                    if (!changedInstance4 || rememberedValue5 == companion.getEmpty()) {
                        rememberedValue5 = new AndroidPopup_androidKt$Popup$5$1(popupLayout2, null);
                        startRestartGroup.updateRememberedValue(rememberedValue5);
                    }
                    EffectsKt.LaunchedEffect(popupLayout2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue5, startRestartGroup, 0);
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    changedInstance5 = startRestartGroup.changedInstance(popupLayout2);
                    rememberedValue6 = startRestartGroup.rememberedValue();
                    if (!changedInstance5 || rememberedValue6 == companion.getEmpty()) {
                        rememberedValue6 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$7$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                invoke2(layoutCoordinates);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LayoutCoordinates layoutCoordinates) {
                                LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
                                Intrinsics.checkNotNull(parentLayoutCoordinates);
                                PopupLayout.this.updateParentLayoutCoordinates(parentLayoutCoordinates);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue6);
                    }
                    Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, (Function1) rememberedValue6);
                    changedInstance6 = startRestartGroup.changedInstance(popupLayout2) | startRestartGroup.changed(layoutDirection);
                    rememberedValue7 = startRestartGroup.rememberedValue();
                    if (!changedInstance6 || rememberedValue7 == companion.getEmpty()) {
                        rememberedValue7 = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1
                            @Override // androidx.compose.ui.layout.MeasurePolicy
                            /* renamed from: measure-3p2s80s */
                            public final MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                                PopupLayout.this.setParentLayoutDirection(layoutDirection);
                                return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1.1
                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Placeable.PlacementScope placementScope) {
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }
                                }, 4, null);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue7);
                    }
                    MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue7;
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, onGloballyPositioned);
                    ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor = companion3.getConstructor();
                    if (startRestartGroup.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor);
                    } else {
                        startRestartGroup.useNode();
                    }
                    m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                    Updater.m1227setimpl(m1226constructorimpl, measurePolicy, companion3.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                    if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                    startRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function04 = function03;
                    popupProperties4 = popupProperties3;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    function04 = function02;
                    popupProperties4 = popupProperties2;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$9
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

                        public final void invoke(Composer composer2, int i17) {
                            AndroidPopup_androidKt.Popup(PopupPositionProvider.this, function04, popupProperties4, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                        }
                    });
                    return;
                }
                return;
            }
            popupProperties2 = popupProperties;
            if ((i6 & 8) != 0) {
            }
            i9 = i7;
            if ((i9 & 1171) == 1170) {
            }
            if (i12 != 0) {
            }
            if (i8 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            View view2 = (View) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
            Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            String str22 = (String) startRestartGroup.consume(LocalPopupTestTag);
            final LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            CompositionContext rememberCompositionContext2 = ComposablesKt.rememberCompositionContext(startRestartGroup, 0);
            final State<? extends Function2<? super Composer, ? super Integer, Unit>> rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function2, startRestartGroup, (i9 >> 9) & 14);
            UUID uuid2 = (UUID) RememberSaveableKt.rememberSaveable(new Object[0], null, null, new Function0<UUID>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupId$1
                @Override // kotlin.jvm.functions.Function0
                public final UUID invoke() {
                    return UUID.randomUUID();
                }
            }, startRestartGroup, 3072, 6);
            rememberedValue = startRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
            }
            final PopupLayout popupLayout22 = (PopupLayout) obj;
            int i132 = i10;
            int i142 = i132 & 112;
            int i152 = i132 & 896;
            final String str32 = str;
            changedInstance = startRestartGroup.changedInstance(popupLayout22) | (i142 == i11 ? z5 : false) | (i152 == 256 ? z5 : false) | startRestartGroup.changed(str32) | startRestartGroup.changed(layoutDirection2);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changedInstance) {
            }
            final Function0<Unit> function052 = function03;
            final PopupProperties popupProperties52 = popupProperties3;
            rememberedValue2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    PopupLayout.this.show();
                    PopupLayout.this.updateParameters(function052, popupProperties52, str32, layoutDirection2);
                    final PopupLayout popupLayout3 = PopupLayout.this;
                    return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            PopupLayout.this.disposeComposition();
                            PopupLayout.this.dismiss();
                        }
                    };
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
            EffectsKt.DisposableEffect(popupLayout22, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue2, startRestartGroup, 0);
            changedInstance2 = (i142 == i11 ? z5 : false) | startRestartGroup.changedInstance(popupLayout22) | (i152 == 256 ? z5 : false) | startRestartGroup.changed(str32) | startRestartGroup.changed(layoutDirection2);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!changedInstance2) {
            }
            final Function0<Unit> function062 = function03;
            final PopupProperties popupProperties62 = popupProperties3;
            rememberedValue3 = new Function0<Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$3$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    PopupLayout.this.updateParameters(function062, popupProperties62, str32, layoutDirection2);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue3);
            EffectsKt.SideEffect((Function0) rememberedValue3, startRestartGroup, 0);
            int i162 = i132 & 14;
            changedInstance3 = startRestartGroup.changedInstance(popupLayout22) | (i162 == 4 ? z5 : false);
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (!changedInstance3) {
            }
            rememberedValue4 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    PopupLayout.this.setPositionProvider(popupPositionProvider);
                    PopupLayout.this.updatePosition();
                    return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                        }
                    };
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue4);
            EffectsKt.DisposableEffect(popupPositionProvider, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue4, startRestartGroup, i162);
            changedInstance4 = startRestartGroup.changedInstance(popupLayout22);
            rememberedValue5 = startRestartGroup.rememberedValue();
            if (!changedInstance4) {
            }
            rememberedValue5 = new AndroidPopup_androidKt$Popup$5$1(popupLayout22, null);
            startRestartGroup.updateRememberedValue(rememberedValue5);
            EffectsKt.LaunchedEffect(popupLayout22, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue5, startRestartGroup, 0);
            Modifier.Companion companion22 = Modifier.INSTANCE;
            changedInstance5 = startRestartGroup.changedInstance(popupLayout22);
            rememberedValue6 = startRestartGroup.rememberedValue();
            if (!changedInstance5) {
            }
            rememberedValue6 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$7$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                    invoke2(layoutCoordinates);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LayoutCoordinates layoutCoordinates) {
                    LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
                    Intrinsics.checkNotNull(parentLayoutCoordinates);
                    PopupLayout.this.updateParentLayoutCoordinates(parentLayoutCoordinates);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue6);
            Modifier onGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion22, (Function1) rememberedValue6);
            changedInstance6 = startRestartGroup.changedInstance(popupLayout22) | startRestartGroup.changed(layoutDirection2);
            rememberedValue7 = startRestartGroup.rememberedValue();
            if (!changedInstance6) {
            }
            rememberedValue7 = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                    PopupLayout.this.setParentLayoutDirection(layoutDirection2);
                    return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1.1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Placeable.PlacementScope placementScope) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                            invoke2(placementScope);
                            return Unit.INSTANCE;
                        }
                    }, 4, null);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue7);
            MeasurePolicy measurePolicy2 = (MeasurePolicy) rememberedValue7;
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, onGloballyPositioned2);
            ComposeUiNode.Companion companion32 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor2 = companion32.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, measurePolicy2, companion32.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion32.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion32.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion32.getSetModifier());
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            function04 = function03;
            popupProperties4 = popupProperties3;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        function02 = function0;
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        popupProperties2 = popupProperties;
        if ((i6 & 8) != 0) {
        }
        i9 = i7;
        if ((i9 & 1171) == 1170) {
        }
        if (i12 != 0) {
        }
        if (i8 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        View view22 = (View) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
        Density density22 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        String str222 = (String) startRestartGroup.consume(LocalPopupTestTag);
        final LayoutDirection layoutDirection22 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        CompositionContext rememberCompositionContext22 = ComposablesKt.rememberCompositionContext(startRestartGroup, 0);
        final State<? extends Function2<? super Composer, ? super Integer, Unit>> rememberUpdatedState22 = SnapshotStateKt.rememberUpdatedState(function2, startRestartGroup, (i9 >> 9) & 14);
        UUID uuid22 = (UUID) RememberSaveableKt.rememberSaveable(new Object[0], null, null, new Function0<UUID>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupId$1
            @Override // kotlin.jvm.functions.Function0
            public final UUID invoke() {
                return UUID.randomUUID();
            }
        }, startRestartGroup, 3072, 6);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        final PopupLayout popupLayout222 = (PopupLayout) obj;
        int i1322 = i10;
        int i1422 = i1322 & 112;
        int i1522 = i1322 & 896;
        final String str322 = str;
        changedInstance = startRestartGroup.changedInstance(popupLayout222) | (i1422 == i11 ? z5 : false) | (i1522 == 256 ? z5 : false) | startRestartGroup.changed(str322) | startRestartGroup.changed(layoutDirection22);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        final Function0<Unit> function0522 = function03;
        final PopupProperties popupProperties522 = popupProperties3;
        rememberedValue2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                PopupLayout.this.show();
                PopupLayout.this.updateParameters(function0522, popupProperties522, str322, layoutDirection22);
                final PopupLayout popupLayout3 = PopupLayout.this;
                return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        PopupLayout.this.disposeComposition();
                        PopupLayout.this.dismiss();
                    }
                };
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        EffectsKt.DisposableEffect(popupLayout222, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue2, startRestartGroup, 0);
        changedInstance2 = (i1422 == i11 ? z5 : false) | startRestartGroup.changedInstance(popupLayout222) | (i1522 == 256 ? z5 : false) | startRestartGroup.changed(str322) | startRestartGroup.changed(layoutDirection22);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changedInstance2) {
        }
        final Function0<Unit> function0622 = function03;
        final PopupProperties popupProperties622 = popupProperties3;
        rememberedValue3 = new Function0<Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PopupLayout.this.updateParameters(function0622, popupProperties622, str322, layoutDirection22);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue3);
        EffectsKt.SideEffect((Function0) rememberedValue3, startRestartGroup, 0);
        int i1622 = i1322 & 14;
        changedInstance3 = startRestartGroup.changedInstance(popupLayout222) | (i1622 == 4 ? z5 : false);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (!changedInstance3) {
        }
        rememberedValue4 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                PopupLayout.this.setPositionProvider(popupPositionProvider);
                PopupLayout.this.updatePosition();
                return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                    }
                };
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue4);
        EffectsKt.DisposableEffect(popupPositionProvider, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue4, startRestartGroup, i1622);
        changedInstance4 = startRestartGroup.changedInstance(popupLayout222);
        rememberedValue5 = startRestartGroup.rememberedValue();
        if (!changedInstance4) {
        }
        rememberedValue5 = new AndroidPopup_androidKt$Popup$5$1(popupLayout222, null);
        startRestartGroup.updateRememberedValue(rememberedValue5);
        EffectsKt.LaunchedEffect(popupLayout222, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue5, startRestartGroup, 0);
        Modifier.Companion companion222 = Modifier.INSTANCE;
        changedInstance5 = startRestartGroup.changedInstance(popupLayout222);
        rememberedValue6 = startRestartGroup.rememberedValue();
        if (!changedInstance5) {
        }
        rememberedValue6 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$7$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                invoke2(layoutCoordinates);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutCoordinates layoutCoordinates) {
                LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
                Intrinsics.checkNotNull(parentLayoutCoordinates);
                PopupLayout.this.updateParentLayoutCoordinates(parentLayoutCoordinates);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue6);
        Modifier onGloballyPositioned22 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion222, (Function1) rememberedValue6);
        changedInstance6 = startRestartGroup.changedInstance(popupLayout222) | startRestartGroup.changed(layoutDirection22);
        rememberedValue7 = startRestartGroup.rememberedValue();
        if (!changedInstance6) {
        }
        rememberedValue7 = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1
            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            public final MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                PopupLayout.this.setParentLayoutDirection(layoutDirection22);
                return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1.1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope placementScope) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }
                }, 4, null);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue7);
        MeasurePolicy measurePolicy22 = (MeasurePolicy) rememberedValue7;
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, onGloballyPositioned22);
        ComposeUiNode.Companion companion322 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor22 = companion322.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, measurePolicy22, companion322.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap22, companion322.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion322.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier22, companion322.getSetModifier());
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        function04 = function03;
        popupProperties4 = popupProperties3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final Function2<Composer, Integer, Unit> Popup$lambda$1(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x004d  */
    /* renamed from: Popup-K5zGePQ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2715PopupK5zGePQ(Alignment alignment, long j5, Function0<Unit> function0, PopupProperties popupProperties, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i5, final int i6) {
        Alignment alignment2;
        int i7;
        long j6;
        int i8;
        Function0<Unit> function02;
        int i9;
        PopupProperties popupProperties2;
        Alignment topStart;
        boolean z5;
        Object rememberedValue;
        final Function0<Unit> function03;
        final PopupProperties popupProperties3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(295309329);
        int i10 = i6 & 1;
        if (i10 != 0) {
            i7 = i5 | 6;
            alignment2 = alignment;
        } else if ((i5 & 6) == 0) {
            alignment2 = alignment;
            i7 = (startRestartGroup.changed(alignment2) ? 4 : 2) | i5;
        } else {
            alignment2 = alignment;
            i7 = i5;
        }
        int i11 = i6 & 2;
        if (i11 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            j6 = j5;
            i7 |= startRestartGroup.changed(j6) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                function02 = function0;
                i7 |= startRestartGroup.changedInstance(function02) ? 256 : 128;
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else if ((i5 & 3072) == 0) {
                    popupProperties2 = popupProperties;
                    i7 |= startRestartGroup.changed(popupProperties2) ? 2048 : 1024;
                    if ((i6 & 16) == 0) {
                        i7 |= 24576;
                    } else if ((i5 & 24576) == 0) {
                        i7 |= startRestartGroup.changedInstance(function2) ? 16384 : 8192;
                        if ((i7 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                            topStart = i10 != 0 ? Alignment.INSTANCE.getTopStart() : alignment2;
                            if (i11 != 0) {
                                j6 = IntOffsetKt.IntOffset(0, 0);
                            }
                            Function0<Unit> function04 = i8 != 0 ? null : function02;
                            PopupProperties popupProperties4 = i9 != 0 ? new PopupProperties(false, false, false, false, 15, (DefaultConstructorMarker) null) : popupProperties2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(295309329, i7, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:268)");
                            }
                            z5 = ((i7 & 14) == 4) | ((i7 & 112) == 32);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = new AlignmentOffsetPositionProvider(topStart, j6, null);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            long j7 = j6;
                            Popup((AlignmentOffsetPositionProvider) rememberedValue, function04, popupProperties4, function2, startRestartGroup, (i7 >> 3) & 8176, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j6 = j7;
                            function03 = function04;
                            popupProperties3 = popupProperties4;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            topStart = alignment2;
                            function03 = function02;
                            popupProperties3 = popupProperties2;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Alignment alignment3 = topStart;
                            final long j8 = j6;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$1
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

                                public final void invoke(Composer composer2, int i12) {
                                    AndroidPopup_androidKt.m2715PopupK5zGePQ(Alignment.this, j8, function03, popupProperties3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i7 & 9363) == 9362) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z5 = ((i7 & 14) == 4) | ((i7 & 112) == 32);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z5) {
                    }
                    rememberedValue = new AlignmentOffsetPositionProvider(topStart, j6, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    long j72 = j6;
                    Popup((AlignmentOffsetPositionProvider) rememberedValue, function04, popupProperties4, function2, startRestartGroup, (i7 >> 3) & 8176, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    j6 = j72;
                    function03 = function04;
                    popupProperties3 = popupProperties4;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                popupProperties2 = popupProperties;
                if ((i6 & 16) == 0) {
                }
                if ((i7 & 9363) == 9362) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                z5 = ((i7 & 14) == 4) | ((i7 & 112) == 32);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z5) {
                }
                rememberedValue = new AlignmentOffsetPositionProvider(topStart, j6, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
                long j722 = j6;
                Popup((AlignmentOffsetPositionProvider) rememberedValue, function04, popupProperties4, function2, startRestartGroup, (i7 >> 3) & 8176, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                j6 = j722;
                function03 = function04;
                popupProperties3 = popupProperties4;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function02 = function0;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            popupProperties2 = popupProperties;
            if ((i6 & 16) == 0) {
            }
            if ((i7 & 9363) == 9362) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            z5 = ((i7 & 14) == 4) | ((i7 & 112) == 32);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z5) {
            }
            rememberedValue = new AlignmentOffsetPositionProvider(topStart, j6, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
            long j7222 = j6;
            Popup((AlignmentOffsetPositionProvider) rememberedValue, function04, popupProperties4, function2, startRestartGroup, (i7 >> 3) & 8176, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            j6 = j7222;
            function03 = function04;
            popupProperties3 = popupProperties4;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        j6 = j5;
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        function02 = function0;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        popupProperties2 = popupProperties;
        if ((i6 & 16) == 0) {
        }
        if ((i7 & 9363) == 9362) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        z5 = ((i7 & 14) == 4) | ((i7 & 112) == 32);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z5) {
        }
        rememberedValue = new AlignmentOffsetPositionProvider(topStart, j6, null);
        startRestartGroup.updateRememberedValue(rememberedValue);
        long j72222 = j6;
        Popup((AlignmentOffsetPositionProvider) rememberedValue, function04, popupProperties4, function2, startRestartGroup, (i7 >> 3) & 8176, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        j6 = j72222;
        function03 = function04;
        popupProperties3 = popupProperties4;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final int createFlags(boolean z5, SecureFlagPolicy secureFlagPolicy, boolean z6) {
        int i5 = !z5 ? 262152 : PopupPropertiesBaseFlags;
        if (secureFlagPolicy == SecureFlagPolicy.SecureOn) {
            i5 |= 8192;
        }
        return !z6 ? i5 | 512 : i5;
    }

    public static final int flagsWithSecureFlagInherited(PopupProperties popupProperties, boolean z5) {
        return (popupProperties.getInheritSecurePolicy() && z5) ? popupProperties.getFlags() | 8192 : (!popupProperties.getInheritSecurePolicy() || z5) ? popupProperties.getFlags() : popupProperties.getFlags() & (-8193);
    }

    public static final boolean isFlagSecureEnabled(View view) {
        ViewGroup.LayoutParams layoutParams = view.getRootView().getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        return (layoutParams2 == null || (layoutParams2.flags & 8192) == 0) ? false : true;
    }

    public static final IntRect toIntBounds(Rect rect) {
        return new IntRect(rect.left, rect.top, rect.right, rect.bottom);
    }
}
