package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.selection.SelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.internal.TextFieldType;
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.PropertyReference0Impl;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\\\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014JJ\u0010\u0018\u001a\u00020\t*\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017Jû\u0001\u0010*\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u001b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b2\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b2\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010(\u001a\u00020'2\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00120\u001bH\u0007¢\u0006\u0004\b*\u0010+J8\u00102\u001a\u00020'2\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0004\b0\u00101J8\u00104\u001a\u00020'2\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0004\b3\u00101J:\u00106\u001a\u00020'2\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000fH\u0000ø\u0001\u0000¢\u0006\u0004\b5\u00101J\u000f\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u00107R\u001d\u00108\u001a\u00020\u000f8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001d\u0010<\u001a\u00020\u000f8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b<\u00109\u001a\u0004\b=\u0010;R\u001d\u0010>\u001a\u00020\u000f8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b>\u00109\u001a\u0004\b?\u0010;R\u001d\u0010@\u001a\u00020\u000f8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b@\u00109\u001a\u0004\bA\u0010;R&\u0010B\u001a\u00020\u000f8\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bB\u00109\u0012\u0004\bD\u0010\u0003\u001a\u0004\bC\u0010;R&\u0010E\u001a\u00020\u000f8\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bE\u00109\u0012\u0004\bG\u0010\u0003\u001a\u0004\bF\u0010;R\u0011\u0010\u000e\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0018\u0010M\u001a\u00020\u000b*\u00020J8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\bK\u0010L\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006N"}, d2 = {"Landroidx/compose/material3/TextFieldDefaults;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "enabled", "isError", "Landroidx/compose/foundation/interaction/InteractionSource;", "interactionSource", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/material3/TextFieldColors;", "colors", "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/ui/unit/Dp;", "focusedIndicatorLineThickness", "unfocusedIndicatorLineThickness", BuildConfig.FLAVOR, "Container-4EFweAY", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "Container", "indicatorLine-gv0btCI", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;FF)Landroidx/compose/ui/Modifier;", "indicatorLine", BuildConfig.FLAVOR, "value", "Lkotlin/Function0;", "innerTextField", "singleLine", "Landroidx/compose/ui/text/input/VisualTransformation;", "visualTransformation", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "Landroidx/compose/foundation/layout/PaddingValues;", "contentPadding", "container", "DecorationBox", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "start", "end", "top", "bottom", "contentPaddingWithLabel-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "contentPaddingWithLabel", "contentPaddingWithoutLabel-a9UjIt4", "contentPaddingWithoutLabel", "supportingTextPadding-a9UjIt4$material3_release", "supportingTextPadding", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "MinHeight", "F", "getMinHeight-D9Ej5fM", "()F", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedIndicatorThickness", "getUnfocusedIndicatorThickness-D9Ej5fM", "FocusedIndicatorThickness", "getFocusedIndicatorThickness-D9Ej5fM", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "getUnfocusedBorderThickness-D9Ej5fM$annotations", "FocusedBorderThickness", "getFocusedBorderThickness-D9Ej5fM", "getFocusedBorderThickness-D9Ej5fM$annotations", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "Landroidx/compose/material3/ColorScheme;", "getDefaultTextFieldColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "defaultTextFieldColors", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldDefaults {
    private static final float FocusedBorderThickness;
    private static final float FocusedIndicatorThickness;
    public static final TextFieldDefaults INSTANCE = new TextFieldDefaults();
    private static final float MinHeight = Dp.m2599constructorimpl(56);
    private static final float MinWidth = Dp.m2599constructorimpl(280);
    private static final float UnfocusedBorderThickness;
    private static final float UnfocusedIndicatorThickness;

    static {
        float m2599constructorimpl = Dp.m2599constructorimpl(1);
        UnfocusedIndicatorThickness = m2599constructorimpl;
        float m2599constructorimpl2 = Dp.m2599constructorimpl(2);
        FocusedIndicatorThickness = m2599constructorimpl2;
        UnfocusedBorderThickness = m2599constructorimpl;
        FocusedBorderThickness = m2599constructorimpl2;
    }

    private TextFieldDefaults() {
    }

    /* renamed from: contentPaddingWithLabel-a9UjIt4$default */
    public static /* synthetic */ PaddingValues m924contentPaddingWithLabela9UjIt4$default(TextFieldDefaults textFieldDefaults, float f5, float f6, float f7, float f8, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i5 & 2) != 0) {
            f6 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i5 & 4) != 0) {
            f7 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        if ((i5 & 8) != 0) {
            f8 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        return textFieldDefaults.m928contentPaddingWithLabela9UjIt4(f5, f6, f7, f8);
    }

    /* renamed from: contentPaddingWithoutLabel-a9UjIt4$default */
    public static /* synthetic */ PaddingValues m925contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults textFieldDefaults, float f5, float f6, float f7, float f8, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i5 & 2) != 0) {
            f6 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i5 & 4) != 0) {
            f7 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i5 & 8) != 0) {
            f8 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m929contentPaddingWithoutLabela9UjIt4(f5, f6, f7, f8);
    }

    /* renamed from: supportingTextPadding-a9UjIt4$material3_release$default */
    public static /* synthetic */ PaddingValues m926supportingTextPaddinga9UjIt4$material3_release$default(TextFieldDefaults textFieldDefaults, float f5, float f6, float f7, float f8, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i5 & 2) != 0) {
            f6 = TextFieldImplKt.getSupportingTopPadding();
        }
        if ((i5 & 4) != 0) {
            f7 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i5 & 8) != 0) {
            f8 = Dp.m2599constructorimpl(0);
        }
        return textFieldDefaults.m935supportingTextPaddinga9UjIt4$material3_release(f5, f6, f7, f8);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0189  */
    /* renamed from: Container-4EFweAY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m927Container4EFweAY(final boolean z5, final boolean z6, final InteractionSource interactionSource, Modifier modifier, TextFieldColors textFieldColors, Shape shape, float f5, float f6, Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        TextFieldColors textFieldColors2;
        Shape shape2;
        float f7;
        float f8;
        float f9;
        float f10;
        Modifier modifier3;
        Composer composer2;
        final Shape shape3;
        final TextFieldColors textFieldColors3;
        final Modifier modifier4;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(-818661242);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(z5) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(z6) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changed(interactionSource) ? 256 : 128;
        }
        int i12 = i6 & 8;
        if (i12 != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 2048 : 1024;
            if ((i5 & 24576) != 0) {
                if ((i6 & 16) == 0) {
                    textFieldColors2 = textFieldColors;
                    if (startRestartGroup.changed(textFieldColors2)) {
                        i11 = 16384;
                        i7 |= i11;
                    }
                } else {
                    textFieldColors2 = textFieldColors;
                }
                i11 = 8192;
                i7 |= i11;
            } else {
                textFieldColors2 = textFieldColors;
            }
            if ((196608 & i5) != 0) {
                if ((i6 & 32) == 0) {
                    shape2 = shape;
                    if (startRestartGroup.changed(shape2)) {
                        i10 = 131072;
                        i7 |= i10;
                    }
                } else {
                    shape2 = shape;
                }
                i10 = 65536;
                i7 |= i10;
            } else {
                shape2 = shape;
            }
            if ((1572864 & i5) != 0) {
                if ((i6 & 64) == 0) {
                    f7 = f5;
                    if (startRestartGroup.changed(f7)) {
                        i9 = 1048576;
                        i7 |= i9;
                    }
                } else {
                    f7 = f5;
                }
                i9 = 524288;
                i7 |= i9;
            } else {
                f7 = f5;
            }
            if ((12582912 & i5) != 0) {
                if ((i6 & 128) == 0) {
                    f8 = f6;
                    if (startRestartGroup.changed(f8)) {
                        i8 = 8388608;
                        i7 |= i8;
                    }
                } else {
                    f8 = f6;
                }
                i8 = 4194304;
                i7 |= i8;
            } else {
                f8 = f6;
            }
            if ((i6 & 256) == 0) {
                i7 |= 100663296;
            } else if ((i5 & 100663296) == 0) {
                i7 |= startRestartGroup.changed(this) ? 67108864 : 33554432;
            }
            if ((38347923 & i7) == 38347922 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    Modifier modifier5 = i12 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i6 & 16) != 0) {
                        TextFieldColors colors = colors(startRestartGroup, (i7 >> 24) & 14);
                        i7 &= -57345;
                        textFieldColors2 = colors;
                    }
                    if ((i6 & 32) != 0) {
                        i7 &= -458753;
                        shape2 = INSTANCE.getShape(startRestartGroup, 6);
                    }
                    if ((i6 & 64) != 0) {
                        i7 &= -3670017;
                        f7 = FocusedIndicatorThickness;
                    }
                    if ((i6 & 128) == 0) {
                        i7 &= -29360129;
                        f10 = UnfocusedIndicatorThickness;
                        f9 = f7;
                    } else {
                        f9 = f7;
                        f10 = f8;
                    }
                    modifier3 = modifier5;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i6 & 16) != 0) {
                        i7 &= -57345;
                    }
                    if ((i6 & 32) != 0) {
                        i7 &= -458753;
                    }
                    if ((i6 & 64) != 0) {
                        i7 &= -3670017;
                    }
                    if ((i6 & 128) != 0) {
                        i7 &= -29360129;
                    }
                    f9 = f7;
                    f10 = f8;
                    modifier3 = modifier2;
                }
                Shape shape4 = shape2;
                TextFieldColors textFieldColors4 = textFieldColors2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-818661242, i7, -1, "androidx.compose.material3.TextFieldDefaults.Container (TextFieldDefaults.kt:109)");
                }
                Modifier modifier6 = modifier3;
                composer2 = startRestartGroup;
                BoxKt.Box(m934indicatorLinegv0btCI(TextFieldImplKt.textFieldBackground(modifier3, new TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0(new PropertyReference0Impl(SingleValueAnimationKt.m54animateColorAsStateeuL9pac(textFieldColors4.m913containerColorXeAY9LY$material3_release(z5, z6, FocusInteractionKt.collectIsFocusedAsState(interactionSource, startRestartGroup, (i7 >> 6) & 14).getValue().booleanValue()), AnimationSpecKt.tween$default(150, 0, null, 6, null), null, null, startRestartGroup, 48, 12)) { // from class: androidx.compose.material3.TextFieldDefaults$Container$1
                    @Override // kotlin.reflect.KProperty0
                    public Object get() {
                        return ((State) this.receiver).getValue();
                    }
                }), shape4), z5, z6, interactionSource, textFieldColors4, f9, f10), composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape3 = shape4;
                textFieldColors3 = textFieldColors4;
                modifier4 = modifier6;
            } else {
                startRestartGroup.skipToGroupEnd();
                f9 = f7;
                composer2 = startRestartGroup;
                f10 = f8;
                textFieldColors3 = textFieldColors2;
                shape3 = shape2;
                modifier4 = modifier2;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                final float f11 = f9;
                final float f12 = f10;
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults$Container$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i13) {
                        TextFieldDefaults.this.m927Container4EFweAY(z5, z6, interactionSource, modifier4, textFieldColors3, shape3, f11, f12, composer3, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i5 & 24576) != 0) {
        }
        if ((196608 & i5) != 0) {
        }
        if ((1572864 & i5) != 0) {
        }
        if ((12582912 & i5) != 0) {
        }
        if ((i6 & 256) == 0) {
        }
        if ((38347923 & i7) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i12 == 0) {
        }
        if ((i6 & 16) != 0) {
        }
        if ((i6 & 32) != 0) {
        }
        if ((i6 & 64) != 0) {
        }
        if ((i6 & 128) == 0) {
        }
        modifier3 = modifier5;
        Shape shape42 = shape2;
        TextFieldColors textFieldColors42 = textFieldColors2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier modifier62 = modifier3;
        composer2 = startRestartGroup;
        BoxKt.Box(m934indicatorLinegv0btCI(TextFieldImplKt.textFieldBackground(modifier3, new TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0(new PropertyReference0Impl(SingleValueAnimationKt.m54animateColorAsStateeuL9pac(textFieldColors42.m913containerColorXeAY9LY$material3_release(z5, z6, FocusInteractionKt.collectIsFocusedAsState(interactionSource, startRestartGroup, (i7 >> 6) & 14).getValue().booleanValue()), AnimationSpecKt.tween$default(150, 0, null, 6, null), null, null, startRestartGroup, 48, 12)) { // from class: androidx.compose.material3.TextFieldDefaults$Container$1
            @Override // kotlin.reflect.KProperty0
            public Object get() {
                return ((State) this.receiver).getValue();
            }
        }), shape42), z5, z6, interactionSource, textFieldColors42, f9, f10), composer2, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        shape3 = shape42;
        textFieldColors3 = textFieldColors42;
        modifier4 = modifier62;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0275  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void DecorationBox(final String str, final Function2<? super Composer, ? super Integer, Unit> function2, final boolean z5, final boolean z6, final VisualTransformation visualTransformation, final InteractionSource interactionSource, boolean z7, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, Function2<? super Composer, ? super Integer, Unit> function28, Shape shape, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2<? super Composer, ? super Integer, Unit> function29, Composer composer, final int i5, final int i6, final int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean z8;
        Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        Function2<? super Composer, ? super Integer, Unit> function212;
        Function2<? super Composer, ? super Integer, Unit> function213;
        Function2<? super Composer, ? super Integer, Unit> function214;
        Function2<? super Composer, ? super Integer, Unit> function215;
        Shape shape2;
        TextFieldColors textFieldColors2;
        PaddingValues paddingValues2;
        int i19;
        Function2<? super Composer, ? super Integer, Unit> function216;
        Shape shape3;
        Function2<? super Composer, ? super Integer, Unit> function217;
        PaddingValues paddingValues3;
        int i20;
        Shape shape4;
        final Function2<? super Composer, ? super Integer, Unit> function218;
        final Function2<? super Composer, ? super Integer, Unit> function219;
        Function2<? super Composer, ? super Integer, Unit> function220;
        final Function2<? super Composer, ? super Integer, Unit> function221;
        final boolean z9;
        TextFieldColors textFieldColors3;
        final Function2<? super Composer, ? super Integer, Unit> function222;
        final Function2<? super Composer, ? super Integer, Unit> function223;
        final Function2<? super Composer, ? super Integer, Unit> function224;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(289640444);
        if ((i7 & 1) != 0) {
            i8 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i8 = (startRestartGroup.changed(str) ? 4 : 2) | i5;
        } else {
            i8 = i5;
        }
        if ((i7 & 2) != 0) {
            i8 |= 48;
        } else if ((i5 & 48) == 0) {
            i8 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
            if ((i7 & 4) == 0) {
                i8 |= 384;
            } else if ((i5 & 384) == 0) {
                i8 |= startRestartGroup.changed(z5) ? 256 : 128;
                if ((i7 & 8) != 0) {
                    i8 |= 3072;
                } else if ((i5 & 3072) == 0) {
                    i8 |= startRestartGroup.changed(z6) ? 2048 : 1024;
                    int i21 = 8192;
                    if ((i7 & 16) == 0) {
                        i8 |= 24576;
                    } else if ((i5 & 24576) == 0) {
                        i8 |= startRestartGroup.changed(visualTransformation) ? 16384 : 8192;
                        if ((i7 & 32) != 0) {
                            i8 |= 196608;
                        } else if ((i5 & 196608) == 0) {
                            i8 |= startRestartGroup.changed(interactionSource) ? 131072 : 65536;
                        }
                        i9 = i7 & 64;
                        if (i9 != 0) {
                            i8 |= 1572864;
                        } else if ((i5 & 1572864) == 0) {
                            i8 |= startRestartGroup.changed(z7) ? 1048576 : 524288;
                        }
                        i10 = i7 & 128;
                        if (i10 != 0) {
                            i8 |= 12582912;
                        } else if ((i5 & 12582912) == 0) {
                            i8 |= startRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
                        }
                        i11 = i7 & 256;
                        if (i11 != 0) {
                            i8 |= 100663296;
                        } else if ((i5 & 100663296) == 0) {
                            i8 |= startRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                        }
                        i12 = i7 & 512;
                        if (i12 != 0) {
                            i8 |= 805306368;
                        } else if ((i5 & 805306368) == 0) {
                            i8 |= startRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                        }
                        i13 = i7 & 1024;
                        if (i13 != 0) {
                            i14 = i6 | 6;
                        } else if ((i6 & 6) == 0) {
                            i14 = i6 | (startRestartGroup.changedInstance(function25) ? 4 : 2);
                        } else {
                            i14 = i6;
                        }
                        i15 = i7 & 2048;
                        if (i15 != 0) {
                            i14 |= 48;
                        } else if ((i6 & 48) == 0) {
                            i14 |= startRestartGroup.changedInstance(function26) ? 32 : 16;
                        }
                        int i22 = i14;
                        i16 = i7 & 4096;
                        if (i16 != 0) {
                            i22 |= 384;
                        } else if ((i6 & 384) == 0) {
                            i22 |= startRestartGroup.changedInstance(function27) ? 256 : 128;
                            i17 = i7 & 8192;
                            if (i17 == 0) {
                                i22 |= 3072;
                            } else if ((i6 & 3072) == 0) {
                                i22 |= startRestartGroup.changedInstance(function28) ? 2048 : 1024;
                                if ((i6 & 24576) == 0) {
                                    if ((i7 & 16384) == 0 && startRestartGroup.changed(shape)) {
                                        i21 = 16384;
                                    }
                                    i22 |= i21;
                                }
                                if ((i6 & 196608) == 0) {
                                    i22 |= ((i7 & 32768) == 0 && startRestartGroup.changed(textFieldColors)) ? 131072 : 65536;
                                }
                                if ((i6 & 1572864) == 0) {
                                    i22 |= ((i7 & 65536) == 0 && startRestartGroup.changed(paddingValues)) ? 1048576 : 524288;
                                }
                                i18 = i7 & 131072;
                                if (i18 != 0) {
                                    i22 |= 12582912;
                                } else if ((i6 & 12582912) == 0) {
                                    i22 |= startRestartGroup.changedInstance(function29) ? 8388608 : 4194304;
                                }
                                if ((i7 & 262144) != 0) {
                                    i22 |= 100663296;
                                } else if ((i6 & 100663296) == 0) {
                                    i22 |= startRestartGroup.changed(this) ? 67108864 : 33554432;
                                }
                                if ((i8 & 306783379) != 306783378 && (38347923 & i22) == 38347922 && startRestartGroup.getSkipping()) {
                                    startRestartGroup.skipToGroupEnd();
                                    z9 = z7;
                                    function224 = function22;
                                    function211 = function23;
                                    function223 = function24;
                                    function218 = function25;
                                    function219 = function26;
                                    function221 = function27;
                                    function220 = function28;
                                    shape4 = shape;
                                    textFieldColors3 = textFieldColors;
                                    paddingValues3 = paddingValues;
                                    function222 = function29;
                                } else {
                                    startRestartGroup.startDefaults();
                                    if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                        z8 = i9 != 0 ? false : z7;
                                        function210 = i10 != 0 ? null : function22;
                                        function211 = i11 != 0 ? null : function23;
                                        function212 = i12 != 0 ? null : function24;
                                        function213 = i13 != 0 ? null : function25;
                                        function214 = i15 != 0 ? null : function26;
                                        function215 = i16 != 0 ? null : function27;
                                        Function2<? super Composer, ? super Integer, Unit> function225 = i17 == 0 ? function28 : null;
                                        if ((i7 & 16384) != 0) {
                                            shape2 = INSTANCE.getShape(startRestartGroup, 6);
                                            i22 &= -57345;
                                        } else {
                                            shape2 = shape;
                                        }
                                        if ((i7 & 32768) != 0) {
                                            textFieldColors2 = colors(startRestartGroup, (i22 >> 24) & 14);
                                            i22 &= -458753;
                                        } else {
                                            textFieldColors2 = textFieldColors;
                                        }
                                        if ((i7 & 65536) != 0) {
                                            paddingValues2 = function210 == null ? m925contentPaddingWithoutLabela9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null) : m924contentPaddingWithLabela9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                            i22 &= -3670017;
                                        } else {
                                            paddingValues2 = paddingValues;
                                        }
                                        if (i18 != 0) {
                                            Function2<? super Composer, ? super Integer, Unit> function226 = function212;
                                            final boolean z10 = z8;
                                            final TextFieldColors textFieldColors4 = textFieldColors2;
                                            final Shape shape5 = shape2;
                                            Function2<Composer, Integer, Unit> function227 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults$DecorationBox$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                                    invoke(composer2, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer2, int i23) {
                                                    if ((i23 & 3) == 2 && composer2.getSkipping()) {
                                                        composer2.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-435523791, i23, -1, "androidx.compose.material3.TextFieldDefaults.DecorationBox.<anonymous> (TextFieldDefaults.kt:265)");
                                                    }
                                                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                                    textFieldDefaults.m927Container4EFweAY(z5, z10, interactionSource, Modifier.INSTANCE, textFieldColors4, shape5, textFieldDefaults.m930getFocusedIndicatorThicknessD9Ej5fM(), textFieldDefaults.m933getUnfocusedIndicatorThicknessD9Ej5fM(), composer2, 114822144, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            };
                                            i19 = i22;
                                            function213 = function213;
                                            function214 = function214;
                                            function216 = ComposableLambdaKt.rememberComposableLambda(-435523791, true, function227, startRestartGroup, 54);
                                            shape3 = shape2;
                                            function212 = function226;
                                        } else {
                                            i19 = i22;
                                            function216 = function29;
                                            shape3 = shape2;
                                        }
                                        function217 = function225;
                                        paddingValues3 = paddingValues2;
                                        i20 = i19;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i7 & 16384) != 0) {
                                            i22 &= -57345;
                                        }
                                        if ((32768 & i7) != 0) {
                                            i22 &= -458753;
                                        }
                                        if ((i7 & 65536) != 0) {
                                            i22 &= -3670017;
                                        }
                                        z8 = z7;
                                        function210 = function22;
                                        function211 = function23;
                                        function212 = function24;
                                        function213 = function25;
                                        function214 = function26;
                                        function215 = function27;
                                        shape3 = shape;
                                        textFieldColors2 = textFieldColors;
                                        paddingValues3 = paddingValues;
                                        function216 = function29;
                                        i20 = i22;
                                        function217 = function28;
                                    }
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(289640444, i8, i20, "androidx.compose.material3.TextFieldDefaults.DecorationBox (TextFieldDefaults.kt:276)");
                                    }
                                    int i23 = i8 << 3;
                                    int i24 = i8 >> 3;
                                    int i25 = i8 >> 9;
                                    int i26 = i20 << 21;
                                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, function2, visualTransformation, function210, function211, function212, function213, function214, function215, function217, z6, z5, z8, interactionSource, paddingValues3, textFieldColors2, function216, startRestartGroup, (i23 & 896) | (i23 & 112) | 6 | (i24 & 7168) | (i25 & 57344) | (i25 & 458752) | (i25 & 3670016) | (i26 & 29360128) | (i26 & 234881024) | (i26 & 1879048192), (i8 & 896) | ((i20 >> 9) & 14) | ((i8 >> 6) & 112) | (i25 & 7168) | (57344 & i24) | ((i20 >> 3) & 458752) | (3670016 & (i20 << 3)) | (i20 & 29360128), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    shape4 = shape3;
                                    function218 = function213;
                                    function219 = function214;
                                    function220 = function217;
                                    function221 = function215;
                                    z9 = z8;
                                    textFieldColors3 = textFieldColors2;
                                    function222 = function216;
                                    function223 = function212;
                                    function224 = function210;
                                }
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                    final Function2<? super Composer, ? super Integer, Unit> function228 = function220;
                                    final Shape shape6 = shape4;
                                    final TextFieldColors textFieldColors5 = textFieldColors3;
                                    final PaddingValues paddingValues4 = paddingValues3;
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults$DecorationBox$2
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

                                        public final void invoke(Composer composer2, int i27) {
                                            TextFieldDefaults.this.DecorationBox(str, function2, z5, z6, visualTransformation, interactionSource, z9, function224, function211, function223, function218, function219, function221, function228, shape6, textFieldColors5, paddingValues4, function222, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6), i7);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            if ((i6 & 24576) == 0) {
                            }
                            if ((i6 & 196608) == 0) {
                            }
                            if ((i6 & 1572864) == 0) {
                            }
                            i18 = i7 & 131072;
                            if (i18 != 0) {
                            }
                            if ((i7 & 262144) != 0) {
                            }
                            if ((i8 & 306783379) != 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i5 & 1) != 0) {
                            }
                            if (i9 != 0) {
                            }
                            if (i10 != 0) {
                            }
                            if (i11 != 0) {
                            }
                            if (i12 != 0) {
                            }
                            if (i13 != 0) {
                            }
                            if (i15 != 0) {
                            }
                            if (i16 != 0) {
                            }
                            if (i17 == 0) {
                            }
                            if ((i7 & 16384) != 0) {
                            }
                            if ((i7 & 32768) != 0) {
                            }
                            if ((i7 & 65536) != 0) {
                            }
                            if (i18 != 0) {
                            }
                            function217 = function225;
                            paddingValues3 = paddingValues2;
                            i20 = i19;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i232 = i8 << 3;
                            int i242 = i8 >> 3;
                            int i252 = i8 >> 9;
                            int i262 = i20 << 21;
                            TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, function2, visualTransformation, function210, function211, function212, function213, function214, function215, function217, z6, z5, z8, interactionSource, paddingValues3, textFieldColors2, function216, startRestartGroup, (i232 & 896) | (i232 & 112) | 6 | (i242 & 7168) | (i252 & 57344) | (i252 & 458752) | (i252 & 3670016) | (i262 & 29360128) | (i262 & 234881024) | (i262 & 1879048192), (i8 & 896) | ((i20 >> 9) & 14) | ((i8 >> 6) & 112) | (i252 & 7168) | (57344 & i242) | ((i20 >> 3) & 458752) | (3670016 & (i20 << 3)) | (i20 & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            shape4 = shape3;
                            function218 = function213;
                            function219 = function214;
                            function220 = function217;
                            function221 = function215;
                            z9 = z8;
                            textFieldColors3 = textFieldColors2;
                            function222 = function216;
                            function223 = function212;
                            function224 = function210;
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i17 = i7 & 8192;
                        if (i17 == 0) {
                        }
                        if ((i6 & 24576) == 0) {
                        }
                        if ((i6 & 196608) == 0) {
                        }
                        if ((i6 & 1572864) == 0) {
                        }
                        i18 = i7 & 131072;
                        if (i18 != 0) {
                        }
                        if ((i7 & 262144) != 0) {
                        }
                        if ((i8 & 306783379) != 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i5 & 1) != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if (i10 != 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (i12 != 0) {
                        }
                        if (i13 != 0) {
                        }
                        if (i15 != 0) {
                        }
                        if (i16 != 0) {
                        }
                        if (i17 == 0) {
                        }
                        if ((i7 & 16384) != 0) {
                        }
                        if ((i7 & 32768) != 0) {
                        }
                        if ((i7 & 65536) != 0) {
                        }
                        if (i18 != 0) {
                        }
                        function217 = function225;
                        paddingValues3 = paddingValues2;
                        i20 = i19;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i2322 = i8 << 3;
                        int i2422 = i8 >> 3;
                        int i2522 = i8 >> 9;
                        int i2622 = i20 << 21;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, function2, visualTransformation, function210, function211, function212, function213, function214, function215, function217, z6, z5, z8, interactionSource, paddingValues3, textFieldColors2, function216, startRestartGroup, (i2322 & 896) | (i2322 & 112) | 6 | (i2422 & 7168) | (i2522 & 57344) | (i2522 & 458752) | (i2522 & 3670016) | (i2622 & 29360128) | (i2622 & 234881024) | (i2622 & 1879048192), (i8 & 896) | ((i20 >> 9) & 14) | ((i8 >> 6) & 112) | (i2522 & 7168) | (57344 & i2422) | ((i20 >> 3) & 458752) | (3670016 & (i20 << 3)) | (i20 & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        shape4 = shape3;
                        function218 = function213;
                        function219 = function214;
                        function220 = function217;
                        function221 = function215;
                        z9 = z8;
                        textFieldColors3 = textFieldColors2;
                        function222 = function216;
                        function223 = function212;
                        function224 = function210;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    if ((i7 & 32) != 0) {
                    }
                    i9 = i7 & 64;
                    if (i9 != 0) {
                    }
                    i10 = i7 & 128;
                    if (i10 != 0) {
                    }
                    i11 = i7 & 256;
                    if (i11 != 0) {
                    }
                    i12 = i7 & 512;
                    if (i12 != 0) {
                    }
                    i13 = i7 & 1024;
                    if (i13 != 0) {
                    }
                    i15 = i7 & 2048;
                    if (i15 != 0) {
                    }
                    int i222 = i14;
                    i16 = i7 & 4096;
                    if (i16 != 0) {
                    }
                    i17 = i7 & 8192;
                    if (i17 == 0) {
                    }
                    if ((i6 & 24576) == 0) {
                    }
                    if ((i6 & 196608) == 0) {
                    }
                    if ((i6 & 1572864) == 0) {
                    }
                    i18 = i7 & 131072;
                    if (i18 != 0) {
                    }
                    if ((i7 & 262144) != 0) {
                    }
                    if ((i8 & 306783379) != 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i5 & 1) != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i15 != 0) {
                    }
                    if (i16 != 0) {
                    }
                    if (i17 == 0) {
                    }
                    if ((i7 & 16384) != 0) {
                    }
                    if ((i7 & 32768) != 0) {
                    }
                    if ((i7 & 65536) != 0) {
                    }
                    if (i18 != 0) {
                    }
                    function217 = function225;
                    paddingValues3 = paddingValues2;
                    i20 = i19;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i23222 = i8 << 3;
                    int i24222 = i8 >> 3;
                    int i25222 = i8 >> 9;
                    int i26222 = i20 << 21;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, function2, visualTransformation, function210, function211, function212, function213, function214, function215, function217, z6, z5, z8, interactionSource, paddingValues3, textFieldColors2, function216, startRestartGroup, (i23222 & 896) | (i23222 & 112) | 6 | (i24222 & 7168) | (i25222 & 57344) | (i25222 & 458752) | (i25222 & 3670016) | (i26222 & 29360128) | (i26222 & 234881024) | (i26222 & 1879048192), (i8 & 896) | ((i20 >> 9) & 14) | ((i8 >> 6) & 112) | (i25222 & 7168) | (57344 & i24222) | ((i20 >> 3) & 458752) | (3670016 & (i20 << 3)) | (i20 & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    shape4 = shape3;
                    function218 = function213;
                    function219 = function214;
                    function220 = function217;
                    function221 = function215;
                    z9 = z8;
                    textFieldColors3 = textFieldColors2;
                    function222 = function216;
                    function223 = function212;
                    function224 = function210;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                int i212 = 8192;
                if ((i7 & 16) == 0) {
                }
                if ((i7 & 32) != 0) {
                }
                i9 = i7 & 64;
                if (i9 != 0) {
                }
                i10 = i7 & 128;
                if (i10 != 0) {
                }
                i11 = i7 & 256;
                if (i11 != 0) {
                }
                i12 = i7 & 512;
                if (i12 != 0) {
                }
                i13 = i7 & 1024;
                if (i13 != 0) {
                }
                i15 = i7 & 2048;
                if (i15 != 0) {
                }
                int i2222 = i14;
                i16 = i7 & 4096;
                if (i16 != 0) {
                }
                i17 = i7 & 8192;
                if (i17 == 0) {
                }
                if ((i6 & 24576) == 0) {
                }
                if ((i6 & 196608) == 0) {
                }
                if ((i6 & 1572864) == 0) {
                }
                i18 = i7 & 131072;
                if (i18 != 0) {
                }
                if ((i7 & 262144) != 0) {
                }
                if ((i8 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i5 & 1) != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if (i12 != 0) {
                }
                if (i13 != 0) {
                }
                if (i15 != 0) {
                }
                if (i16 != 0) {
                }
                if (i17 == 0) {
                }
                if ((i7 & 16384) != 0) {
                }
                if ((i7 & 32768) != 0) {
                }
                if ((i7 & 65536) != 0) {
                }
                if (i18 != 0) {
                }
                function217 = function225;
                paddingValues3 = paddingValues2;
                i20 = i19;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i232222 = i8 << 3;
                int i242222 = i8 >> 3;
                int i252222 = i8 >> 9;
                int i262222 = i20 << 21;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, function2, visualTransformation, function210, function211, function212, function213, function214, function215, function217, z6, z5, z8, interactionSource, paddingValues3, textFieldColors2, function216, startRestartGroup, (i232222 & 896) | (i232222 & 112) | 6 | (i242222 & 7168) | (i252222 & 57344) | (i252222 & 458752) | (i252222 & 3670016) | (i262222 & 29360128) | (i262222 & 234881024) | (i262222 & 1879048192), (i8 & 896) | ((i20 >> 9) & 14) | ((i8 >> 6) & 112) | (i252222 & 7168) | (57344 & i242222) | ((i20 >> 3) & 458752) | (3670016 & (i20 << 3)) | (i20 & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                shape4 = shape3;
                function218 = function213;
                function219 = function214;
                function220 = function217;
                function221 = function215;
                z9 = z8;
                textFieldColors3 = textFieldColors2;
                function222 = function216;
                function223 = function212;
                function224 = function210;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            if ((i7 & 8) != 0) {
            }
            int i2122 = 8192;
            if ((i7 & 16) == 0) {
            }
            if ((i7 & 32) != 0) {
            }
            i9 = i7 & 64;
            if (i9 != 0) {
            }
            i10 = i7 & 128;
            if (i10 != 0) {
            }
            i11 = i7 & 256;
            if (i11 != 0) {
            }
            i12 = i7 & 512;
            if (i12 != 0) {
            }
            i13 = i7 & 1024;
            if (i13 != 0) {
            }
            i15 = i7 & 2048;
            if (i15 != 0) {
            }
            int i22222 = i14;
            i16 = i7 & 4096;
            if (i16 != 0) {
            }
            i17 = i7 & 8192;
            if (i17 == 0) {
            }
            if ((i6 & 24576) == 0) {
            }
            if ((i6 & 196608) == 0) {
            }
            if ((i6 & 1572864) == 0) {
            }
            i18 = i7 & 131072;
            if (i18 != 0) {
            }
            if ((i7 & 262144) != 0) {
            }
            if ((i8 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (i13 != 0) {
            }
            if (i15 != 0) {
            }
            if (i16 != 0) {
            }
            if (i17 == 0) {
            }
            if ((i7 & 16384) != 0) {
            }
            if ((i7 & 32768) != 0) {
            }
            if ((i7 & 65536) != 0) {
            }
            if (i18 != 0) {
            }
            function217 = function225;
            paddingValues3 = paddingValues2;
            i20 = i19;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i2322222 = i8 << 3;
            int i2422222 = i8 >> 3;
            int i2522222 = i8 >> 9;
            int i2622222 = i20 << 21;
            TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, function2, visualTransformation, function210, function211, function212, function213, function214, function215, function217, z6, z5, z8, interactionSource, paddingValues3, textFieldColors2, function216, startRestartGroup, (i2322222 & 896) | (i2322222 & 112) | 6 | (i2422222 & 7168) | (i2522222 & 57344) | (i2522222 & 458752) | (i2522222 & 3670016) | (i2622222 & 29360128) | (i2622222 & 234881024) | (i2622222 & 1879048192), (i8 & 896) | ((i20 >> 9) & 14) | ((i8 >> 6) & 112) | (i2522222 & 7168) | (57344 & i2422222) | ((i20 >> 3) & 458752) | (3670016 & (i20 << 3)) | (i20 & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            shape4 = shape3;
            function218 = function213;
            function219 = function214;
            function220 = function217;
            function221 = function215;
            z9 = z8;
            textFieldColors3 = textFieldColors2;
            function222 = function216;
            function223 = function212;
            function224 = function210;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i7 & 4) == 0) {
        }
        if ((i7 & 8) != 0) {
        }
        int i21222 = 8192;
        if ((i7 & 16) == 0) {
        }
        if ((i7 & 32) != 0) {
        }
        i9 = i7 & 64;
        if (i9 != 0) {
        }
        i10 = i7 & 128;
        if (i10 != 0) {
        }
        i11 = i7 & 256;
        if (i11 != 0) {
        }
        i12 = i7 & 512;
        if (i12 != 0) {
        }
        i13 = i7 & 1024;
        if (i13 != 0) {
        }
        i15 = i7 & 2048;
        if (i15 != 0) {
        }
        int i222222 = i14;
        i16 = i7 & 4096;
        if (i16 != 0) {
        }
        i17 = i7 & 8192;
        if (i17 == 0) {
        }
        if ((i6 & 24576) == 0) {
        }
        if ((i6 & 196608) == 0) {
        }
        if ((i6 & 1572864) == 0) {
        }
        i18 = i7 & 131072;
        if (i18 != 0) {
        }
        if ((i7 & 262144) != 0) {
        }
        if ((i8 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (i13 != 0) {
        }
        if (i15 != 0) {
        }
        if (i16 != 0) {
        }
        if (i17 == 0) {
        }
        if ((i7 & 16384) != 0) {
        }
        if ((i7 & 32768) != 0) {
        }
        if ((i7 & 65536) != 0) {
        }
        if (i18 != 0) {
        }
        function217 = function225;
        paddingValues3 = paddingValues2;
        i20 = i19;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i23222222 = i8 << 3;
        int i24222222 = i8 >> 3;
        int i25222222 = i8 >> 9;
        int i26222222 = i20 << 21;
        TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, function2, visualTransformation, function210, function211, function212, function213, function214, function215, function217, z6, z5, z8, interactionSource, paddingValues3, textFieldColors2, function216, startRestartGroup, (i23222222 & 896) | (i23222222 & 112) | 6 | (i24222222 & 7168) | (i25222222 & 57344) | (i25222222 & 458752) | (i25222222 & 3670016) | (i26222222 & 29360128) | (i26222222 & 234881024) | (i26222222 & 1879048192), (i8 & 896) | ((i20 >> 9) & 14) | ((i8 >> 6) & 112) | (i25222222 & 7168) | (57344 & i24222222) | ((i20 >> 3) & 458752) | (3670016 & (i20 << 3)) | (i20 & 29360128), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        shape4 = shape3;
        function218 = function213;
        function219 = function214;
        function220 = function217;
        function221 = function215;
        z9 = z8;
        textFieldColors3 = textFieldColors2;
        function222 = function216;
        function223 = function212;
        function224 = function210;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public final TextFieldColors colors(Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(831731228, i5, -1, "androidx.compose.material3.TextFieldDefaults.colors (TextFieldDefaults.kt:336)");
        }
        TextFieldColors defaultTextFieldColors = getDefaultTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i5 << 3) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return defaultTextFieldColors;
    }

    /* renamed from: contentPaddingWithLabel-a9UjIt4 */
    public final PaddingValues m928contentPaddingWithLabela9UjIt4(float start, float end, float top, float bottom) {
        return PaddingKt.m309PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* renamed from: contentPaddingWithoutLabel-a9UjIt4 */
    public final PaddingValues m929contentPaddingWithoutLabela9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m309PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    public final TextFieldColors getDefaultTextFieldColors(ColorScheme colorScheme, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1341970309, i5, -1, "androidx.compose.material3.TextFieldDefaults.<get-defaultTextFieldColors> (TextFieldDefaults.kt:486)");
        }
        TextFieldColors defaultTextFieldColorsCached = colorScheme.getDefaultTextFieldColorsCached();
        composer.startReplaceGroup(27085453);
        if (defaultTextFieldColorsCached == null) {
            FilledTextFieldTokens filledTextFieldTokens = FilledTextFieldTokens.INSTANCE;
            defaultTextFieldColorsCached = new TextFieldColors(ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getFocusInputColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getInputColor()), Color.m1485copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getDisabledInputColor()), filledTextFieldTokens.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getErrorInputColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getCaretColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getErrorFocusCaretColor()), (SelectionColors) composer.consume(TextSelectionColorsKt.getLocalTextSelectionColors()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getFocusActiveIndicatorColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getActiveIndicatorColor()), Color.m1485copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getDisabledActiveIndicatorColor()), filledTextFieldTokens.getDisabledActiveIndicatorOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getErrorActiveIndicatorColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getFocusLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getLeadingIconColor()), Color.m1485copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getDisabledLeadingIconColor()), filledTextFieldTokens.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getErrorLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getFocusTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getTrailingIconColor()), Color.m1485copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getDisabledTrailingIconColor()), filledTextFieldTokens.getDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getErrorTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getFocusLabelColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getLabelColor()), Color.m1485copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getDisabledLabelColor()), filledTextFieldTokens.getDisabledLabelOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getErrorLabelColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getInputPlaceholderColor()), Color.m1485copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getDisabledInputColor()), filledTextFieldTokens.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getFocusSupportingColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getSupportingColor()), Color.m1485copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getDisabledSupportingColor()), filledTextFieldTokens.getDisabledSupportingOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getErrorSupportingColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getInputPrefixColor()), Color.m1485copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getInputPrefixColor()), filledTextFieldTokens.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getInputSuffixColor()), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getInputSuffixColor()), Color.m1485copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getInputSuffixColor()), filledTextFieldTokens.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, filledTextFieldTokens.getInputSuffixColor()), null);
            colorScheme.setDefaultTextFieldColorsCached$material3_release(defaultTextFieldColorsCached);
        }
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return defaultTextFieldColorsCached;
    }

    /* renamed from: getFocusedIndicatorThickness-D9Ej5fM */
    public final float m930getFocusedIndicatorThicknessD9Ej5fM() {
        return FocusedIndicatorThickness;
    }

    /* renamed from: getMinHeight-D9Ej5fM */
    public final float m931getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM */
    public final float m932getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    public final Shape getShape(Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1941327459, i5, -1, "androidx.compose.material3.TextFieldDefaults.<get-shape> (TextFieldDefaults.kt:60)");
        }
        Shape value = ShapesKt.getValue(FilledTextFieldTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return value;
    }

    /* renamed from: getUnfocusedIndicatorThickness-D9Ej5fM */
    public final float m933getUnfocusedIndicatorThicknessD9Ej5fM() {
        return UnfocusedIndicatorThickness;
    }

    /* renamed from: indicatorLine-gv0btCI */
    public final Modifier m934indicatorLinegv0btCI(Modifier modifier, final boolean z5, final boolean z6, final InteractionSource interactionSource, final TextFieldColors textFieldColors, final float f5, final float f6) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults$indicatorLine-gv0btCI$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                android.support.v4.media.session.a.a(inspectorInfo);
                invoke2((InspectorInfo) null);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                throw null;
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material3.TextFieldDefaults$indicatorLine$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i5) {
                composer.startReplaceGroup(-891038934);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-891038934, i5, -1, "androidx.compose.material3.TextFieldDefaults.indicatorLine.<anonymous> (TextFieldDefaults.kt:169)");
                }
                Modifier drawIndicatorLine = TextFieldKt.drawIndicatorLine(Modifier.INSTANCE, TextFieldImplKt.m1001animateBorderStrokeAsStateNuRrP5Q(z5, z6, FocusInteractionKt.collectIsFocusedAsState(InteractionSource.this, composer, 0).getValue().booleanValue(), textFieldColors, f5, f6, composer, 0));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return drawIndicatorLine;
            }
        });
    }

    /* renamed from: supportingTextPadding-a9UjIt4$material3_release */
    public final PaddingValues m935supportingTextPaddinga9UjIt4$material3_release(float start, float top, float end, float bottom) {
        return PaddingKt.m309PaddingValuesa9UjIt4(start, top, end, bottom);
    }
}
