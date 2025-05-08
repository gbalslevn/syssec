package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextOverflow;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u001av\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString;", "text", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/text/TextStyle;", "style", BuildConfig.FLAVOR, "softWrap", "Landroidx/compose/ui/text/style/TextOverflow;", "overflow", BuildConfig.FLAVOR, "maxLines", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", BuildConfig.FLAVOR, "onTextLayout", "onClick", "ClickableText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;ZIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ClickableText", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ClickableTextKt {
    /* JADX WARN: Removed duplicated region for block: B:104:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00a5  */
    @Deprecated
    /* renamed from: ClickableText-4YKlhWE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m469ClickableText4YKlhWE(final AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, boolean z5, int i5, int i6, Function1<? super TextLayoutResult, Unit> function1, final Function1<? super Integer, Unit> function12, Composer composer, final int i7, final int i8) {
        int i9;
        Modifier modifier2;
        int i10;
        TextStyle textStyle2;
        int i11;
        boolean z6;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        final Function1<? super TextLayoutResult, Unit> function13;
        Object rememberedValue;
        Composer.Companion companion;
        boolean z7;
        Object rememberedValue2;
        boolean z8;
        Object rememberedValue3;
        final boolean z9;
        final int i17;
        final Function1<? super TextLayoutResult, Unit> function14;
        final Modifier modifier3;
        final int i18;
        final TextStyle textStyle3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-246609449);
        if ((i8 & 1) != 0) {
            i9 = i7 | 6;
        } else if ((i7 & 6) == 0) {
            i9 = (startRestartGroup.changed(annotatedString) ? 4 : 2) | i7;
        } else {
            i9 = i7;
        }
        int i19 = i8 & 2;
        if (i19 != 0) {
            i9 |= 48;
        } else if ((i7 & 48) == 0) {
            modifier2 = modifier;
            i9 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i10 = i8 & 4;
            if (i10 == 0) {
                i9 |= 384;
            } else if ((i7 & 384) == 0) {
                textStyle2 = textStyle;
                i9 |= startRestartGroup.changed(textStyle2) ? 256 : 128;
                i11 = i8 & 8;
                if (i11 != 0) {
                    i9 |= 3072;
                } else if ((i7 & 3072) == 0) {
                    z6 = z5;
                    i9 |= startRestartGroup.changed(z6) ? 2048 : 1024;
                    i12 = i8 & 16;
                    if (i12 == 0) {
                        i9 |= 24576;
                    } else if ((i7 & 24576) == 0) {
                        i13 = i5;
                        i9 |= startRestartGroup.changed(i13) ? 16384 : 8192;
                        i14 = i8 & 32;
                        if (i14 != 0) {
                            i9 |= 196608;
                            i15 = i6;
                        } else {
                            i15 = i6;
                            if ((i7 & 196608) == 0) {
                                i9 |= startRestartGroup.changed(i15) ? 131072 : 65536;
                            }
                        }
                        i16 = i8 & 64;
                        if (i16 != 0) {
                            i9 |= 1572864;
                        } else if ((i7 & 1572864) == 0) {
                            i9 |= startRestartGroup.changedInstance(function1) ? 1048576 : 524288;
                        }
                        if ((i8 & 128) != 0) {
                            i9 |= 12582912;
                        } else if ((i7 & 12582912) == 0) {
                            i9 |= startRestartGroup.changedInstance(function12) ? 8388608 : 4194304;
                        }
                        if ((4793491 & i9) == 4793490 || !startRestartGroup.getSkipping()) {
                            if (i19 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            TextStyle textStyle4 = i10 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle2;
                            boolean z10 = i11 != 0 ? true : z6;
                            int m2563getClipgIe3tQ8 = i12 != 0 ? TextOverflow.INSTANCE.m2563getClipgIe3tQ8() : i13;
                            if (i14 != 0) {
                                i15 = Integer.MAX_VALUE;
                            }
                            function13 = i16 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$1
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextLayoutResult textLayoutResult) {
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }
                            } : function1;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-246609449, i9, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:83)");
                            }
                            rememberedValue = startRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            if (rememberedValue == companion.getEmpty()) {
                                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            final MutableState mutableState = (MutableState) rememberedValue;
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            z7 = (i9 & 29360128) == 8388608;
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (!z7 || rememberedValue2 == companion.getEmpty()) {
                                rememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function12, null);
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            Modifier then = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion2, function12, (Function2) rememberedValue2));
                            z8 = (i9 & 3670016) == 1048576;
                            rememberedValue3 = startRestartGroup.rememberedValue();
                            if (!z8 || rememberedValue3 == companion.getEmpty()) {
                                rememberedValue3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$2$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                        invoke2(textLayoutResult);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(TextLayoutResult textLayoutResult) {
                                        mutableState.setValue(textLayoutResult);
                                        function13.invoke(textLayoutResult);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            Function1<? super TextLayoutResult, Unit> function15 = function13;
                            BasicTextKt.m464BasicTextRWo7tUw(annotatedString, then, textStyle4, (Function1) rememberedValue3, m2563getClipgIe3tQ8, z10, i15, 0, null, null, startRestartGroup, (58254 & i9) | (458752 & (i9 << 6)) | ((i9 << 3) & 3670016), 896);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z9 = z10;
                            i17 = m2563getClipgIe3tQ8;
                            function14 = function15;
                            modifier3 = modifier2;
                            i18 = i15;
                            textStyle3 = textStyle4;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            function14 = function1;
                            modifier3 = modifier2;
                            z9 = z6;
                            i17 = i13;
                            i18 = i15;
                            textStyle3 = textStyle2;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$3
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
                                    ClickableTextKt.m469ClickableText4YKlhWE(AnnotatedString.this, modifier3, textStyle3, z9, i17, i18, function14, function12, composer2, RecomposeScopeImplKt.updateChangedFlags(i7 | 1), i8);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i13 = i5;
                    i14 = i8 & 32;
                    if (i14 != 0) {
                    }
                    i16 = i8 & 64;
                    if (i16 != 0) {
                    }
                    if ((i8 & 128) != 0) {
                    }
                    if ((4793491 & i9) == 4793490) {
                    }
                    if (i19 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (i16 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    rememberedValue = startRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (rememberedValue == companion.getEmpty()) {
                    }
                    final MutableState<TextLayoutResult> mutableState2 = (MutableState) rememberedValue;
                    Modifier.Companion companion22 = Modifier.INSTANCE;
                    if ((i9 & 29360128) == 8388608) {
                    }
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!z7) {
                    }
                    rememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState2, function12, null);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    Modifier then2 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion22, function12, (Function2) rememberedValue2));
                    if ((i9 & 3670016) == 1048576) {
                    }
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (!z8) {
                    }
                    rememberedValue3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                            invoke2(textLayoutResult);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextLayoutResult textLayoutResult) {
                            mutableState2.setValue(textLayoutResult);
                            function13.invoke(textLayoutResult);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                    Function1<? super TextLayoutResult, Unit> function152 = function13;
                    BasicTextKt.m464BasicTextRWo7tUw(annotatedString, then2, textStyle4, (Function1) rememberedValue3, m2563getClipgIe3tQ8, z10, i15, 0, null, null, startRestartGroup, (58254 & i9) | (458752 & (i9 << 6)) | ((i9 << 3) & 3670016), 896);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z9 = z10;
                    i17 = m2563getClipgIe3tQ8;
                    function14 = function152;
                    modifier3 = modifier2;
                    i18 = i15;
                    textStyle3 = textStyle4;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z6 = z5;
                i12 = i8 & 16;
                if (i12 == 0) {
                }
                i13 = i5;
                i14 = i8 & 32;
                if (i14 != 0) {
                }
                i16 = i8 & 64;
                if (i16 != 0) {
                }
                if ((i8 & 128) != 0) {
                }
                if ((4793491 & i9) == 4793490) {
                }
                if (i19 != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if (i12 != 0) {
                }
                if (i14 != 0) {
                }
                if (i16 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                }
                final MutableState<TextLayoutResult> mutableState22 = (MutableState) rememberedValue;
                Modifier.Companion companion222 = Modifier.INSTANCE;
                if ((i9 & 29360128) == 8388608) {
                }
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!z7) {
                }
                rememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState22, function12, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
                Modifier then22 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion222, function12, (Function2) rememberedValue2));
                if ((i9 & 3670016) == 1048576) {
                }
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!z8) {
                }
                rememberedValue3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                        invoke2(textLayoutResult);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextLayoutResult textLayoutResult) {
                        mutableState22.setValue(textLayoutResult);
                        function13.invoke(textLayoutResult);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
                Function1<? super TextLayoutResult, Unit> function1522 = function13;
                BasicTextKt.m464BasicTextRWo7tUw(annotatedString, then22, textStyle4, (Function1) rememberedValue3, m2563getClipgIe3tQ8, z10, i15, 0, null, null, startRestartGroup, (58254 & i9) | (458752 & (i9 << 6)) | ((i9 << 3) & 3670016), 896);
                if (ComposerKt.isTraceInProgress()) {
                }
                z9 = z10;
                i17 = m2563getClipgIe3tQ8;
                function14 = function1522;
                modifier3 = modifier2;
                i18 = i15;
                textStyle3 = textStyle4;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            textStyle2 = textStyle;
            i11 = i8 & 8;
            if (i11 != 0) {
            }
            z6 = z5;
            i12 = i8 & 16;
            if (i12 == 0) {
            }
            i13 = i5;
            i14 = i8 & 32;
            if (i14 != 0) {
            }
            i16 = i8 & 64;
            if (i16 != 0) {
            }
            if ((i8 & 128) != 0) {
            }
            if ((4793491 & i9) == 4793490) {
            }
            if (i19 != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (i14 != 0) {
            }
            if (i16 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            rememberedValue = startRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
            }
            final MutableState<TextLayoutResult> mutableState222 = (MutableState) rememberedValue;
            Modifier.Companion companion2222 = Modifier.INSTANCE;
            if ((i9 & 29360128) == 8388608) {
            }
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!z7) {
            }
            rememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState222, function12, null);
            startRestartGroup.updateRememberedValue(rememberedValue2);
            Modifier then222 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion2222, function12, (Function2) rememberedValue2));
            if ((i9 & 3670016) == 1048576) {
            }
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!z8) {
            }
            rememberedValue3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                    invoke2(textLayoutResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TextLayoutResult textLayoutResult) {
                    mutableState222.setValue(textLayoutResult);
                    function13.invoke(textLayoutResult);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue3);
            Function1<? super TextLayoutResult, Unit> function15222 = function13;
            BasicTextKt.m464BasicTextRWo7tUw(annotatedString, then222, textStyle4, (Function1) rememberedValue3, m2563getClipgIe3tQ8, z10, i15, 0, null, null, startRestartGroup, (58254 & i9) | (458752 & (i9 << 6)) | ((i9 << 3) & 3670016), 896);
            if (ComposerKt.isTraceInProgress()) {
            }
            z9 = z10;
            i17 = m2563getClipgIe3tQ8;
            function14 = function15222;
            modifier3 = modifier2;
            i18 = i15;
            textStyle3 = textStyle4;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i10 = i8 & 4;
        if (i10 == 0) {
        }
        textStyle2 = textStyle;
        i11 = i8 & 8;
        if (i11 != 0) {
        }
        z6 = z5;
        i12 = i8 & 16;
        if (i12 == 0) {
        }
        i13 = i5;
        i14 = i8 & 32;
        if (i14 != 0) {
        }
        i16 = i8 & 64;
        if (i16 != 0) {
        }
        if ((i8 & 128) != 0) {
        }
        if ((4793491 & i9) == 4793490) {
        }
        if (i19 != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (i14 != 0) {
        }
        if (i16 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        final MutableState<TextLayoutResult> mutableState2222 = (MutableState) rememberedValue;
        Modifier.Companion companion22222 = Modifier.INSTANCE;
        if ((i9 & 29360128) == 8388608) {
        }
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!z7) {
        }
        rememberedValue2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState2222, function12, null);
        startRestartGroup.updateRememberedValue(rememberedValue2);
        Modifier then2222 = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion22222, function12, (Function2) rememberedValue2));
        if ((i9 & 3670016) == 1048576) {
        }
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!z8) {
        }
        rememberedValue3 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.ClickableTextKt$ClickableText$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                invoke2(textLayoutResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TextLayoutResult textLayoutResult) {
                mutableState2222.setValue(textLayoutResult);
                function13.invoke(textLayoutResult);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue3);
        Function1<? super TextLayoutResult, Unit> function152222 = function13;
        BasicTextKt.m464BasicTextRWo7tUw(annotatedString, then2222, textStyle4, (Function1) rememberedValue3, m2563getClipgIe3tQ8, z10, i15, 0, null, null, startRestartGroup, (58254 & i9) | (458752 & (i9 << 6)) | ((i9 << 3) & 3670016), 896);
        if (ComposerKt.isTraceInProgress()) {
        }
        z9 = z10;
        i17 = m2563getClipgIe3tQ8;
        function14 = function152222;
        modifier3 = modifier2;
        i18 = i15;
        textStyle3 = textStyle4;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
