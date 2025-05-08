package dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.unit.Dp;
import coil.compose.AsyncImagePainter;
import coil.compose.SingletonAsyncImagePainterKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.core.image.ImageHelper;
import dk.molslinjen.domain.model.config.Subline;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails.LineIconViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"LineIconView", BuildConfig.FLAVOR, "modifier", "Landroidx/compose/ui/Modifier;", "subline", "Ldk/molslinjen/domain/model/config/Subline;", "lineIconUrl", BuildConfig.FLAVOR, "(Landroidx/compose/ui/Modifier;Ldk/molslinjen/domain/model/config/Subline;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class LineIconViewKt {
    /* JADX WARN: Removed duplicated region for block: B:18:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LineIconView(Modifier modifier, final Subline subline, String str, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        String str2;
        Modifier modifier3;
        String str3;
        String iconUrl;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1453895256);
        int i8 = i6 & 1;
        if (i8 != 0) {
            i7 = i5 | 6;
            modifier2 = modifier;
        } else if ((i5 & 6) == 0) {
            modifier2 = modifier;
            i7 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i5;
        } else {
            modifier2 = modifier;
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(subline) ? 32 : 16;
        }
        int i9 = i6 & 4;
        if (i9 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            str2 = str;
            i7 |= startRestartGroup.changed(str2) ? 256 : 128;
            if ((i7 & 147) == 146 || !startRestartGroup.getSkipping()) {
                modifier3 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                str3 = i9 == 0 ? null : str2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1453895256, i7, -1, "dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails.LineIconView (LineIconView.kt:16)");
                }
                if (subline != null && str3 == null) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
                    if (endRestartGroup2 != null) {
                        final Modifier modifier4 = modifier3;
                        final String str4 = str3;
                        endRestartGroup2.updateScope(new Function2() { // from class: c3.k
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit LineIconView$lambda$0;
                                LineIconView$lambda$0 = LineIconViewKt.LineIconView$lambda$0(Modifier.this, subline, str4, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                return LineIconView$lambda$0;
                            }
                        });
                        return;
                    }
                    return;
                }
                ImageHelper imageHelper = ImageHelper.INSTANCE;
                String str5 = (subline != null || (iconUrl = subline.getIconUrl()) == null) ? str3 : iconUrl;
                float f5 = 16;
                String m3193buildImageUrlC8IHX40 = imageHelper.m3193buildImageUrlC8IHX40(str5, null, Dp.m2597boximpl(Dp.m2599constructorimpl(f5)), startRestartGroup, 3456, 2);
                Modifier m325height3ABfNKs = SizeKt.m325height3ABfNKs(modifier3, Dp.m2599constructorimpl(f5));
                AsyncImagePainter m2744rememberAsyncImagePainter19ie5dc = SingletonAsyncImagePainterKt.m2744rememberAsyncImagePainter19ie5dc(m3193buildImageUrlC8IHX40, null, null, null, 0, startRestartGroup, 0, 30);
                if (subline != null || (r6 = subline.getName()) == null) {
                    String skip = Accessibility.INSTANCE.getSkip();
                }
                ImageKt.Image(m2744rememberAsyncImagePainter19ie5dc, skip, m325height3ABfNKs, null, null, 0.0f, ColorFilter.Companion.m1503tintxETnrds$default(ColorFilter.INSTANCE, AppColor.INSTANCE.m3253getBrandBlack10d7_KjU(), 0, 2, null), startRestartGroup, 1572864, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                str3 = str2;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier5 = modifier3;
                final String str6 = str3;
                endRestartGroup.updateScope(new Function2() { // from class: c3.l
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit LineIconView$lambda$1;
                        LineIconView$lambda$1 = LineIconViewKt.LineIconView$lambda$1(Modifier.this, subline, str6, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                        return LineIconView$lambda$1;
                    }
                });
                return;
            }
            return;
        }
        str2 = str;
        if ((i7 & 147) == 146) {
        }
        if (i8 == 0) {
        }
        if (i9 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        if (subline != null) {
        }
        ImageHelper imageHelper2 = ImageHelper.INSTANCE;
        if (subline != null) {
        }
        float f52 = 16;
        String m3193buildImageUrlC8IHX402 = imageHelper2.m3193buildImageUrlC8IHX40(str5, null, Dp.m2597boximpl(Dp.m2599constructorimpl(f52)), startRestartGroup, 3456, 2);
        Modifier m325height3ABfNKs2 = SizeKt.m325height3ABfNKs(modifier3, Dp.m2599constructorimpl(f52));
        AsyncImagePainter m2744rememberAsyncImagePainter19ie5dc2 = SingletonAsyncImagePainterKt.m2744rememberAsyncImagePainter19ie5dc(m3193buildImageUrlC8IHX402, null, null, null, 0, startRestartGroup, 0, 30);
        if (subline != null) {
        }
        String skip2 = Accessibility.INSTANCE.getSkip();
        ImageKt.Image(m2744rememberAsyncImagePainter19ie5dc2, skip2, m325height3ABfNKs2, null, null, 0.0f, ColorFilter.Companion.m1503tintxETnrds$default(ColorFilter.INSTANCE, AppColor.INSTANCE.m3253getBrandBlack10d7_KjU(), 0, 2, null), startRestartGroup, 1572864, 56);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LineIconView$lambda$0(Modifier modifier, Subline subline, String str, int i5, int i6, Composer composer, int i7) {
        LineIconView(modifier, subline, str, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LineIconView$lambda$1(Modifier modifier, Subline subline, String str, int i5, int i6, Composer composer, int i7) {
        LineIconView(modifier, subline, str, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
