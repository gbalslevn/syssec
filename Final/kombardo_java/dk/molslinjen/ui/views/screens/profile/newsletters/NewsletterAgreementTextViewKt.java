package dk.molslinjen.ui.views.screens.profile.newsletters;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import dk.molslinjen.domain.model.site.SiteInfo;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.clickableText.ClickableTextData;
import dk.molslinjen.ui.views.reusable.clickableText.ClickableTextKt;
import dk.molslinjen.ui.views.screens.profile.newsletters.NewsletterAgreementTextViewKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"NewsletterAgreementTextView", BuildConfig.FLAVOR, "siteInfo", "Ldk/molslinjen/domain/model/site/SiteInfo;", "style", "Landroidx/compose/ui/text/TextStyle;", "color", "Landroidx/compose/ui/graphics/Color;", "description", BuildConfig.FLAVOR, "NewsletterAgreementTextView-cf5BqRc", "(Ldk/molslinjen/domain/model/site/SiteInfo;Landroidx/compose/ui/text/TextStyle;JILandroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class NewsletterAgreementTextViewKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x004d  */
    /* renamed from: NewsletterAgreementTextView-cf5BqRc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3513NewsletterAgreementTextViewcf5BqRc(final SiteInfo siteInfo, TextStyle textStyle, long j5, int i5, Composer composer, final int i6, final int i7) {
        int i8;
        TextStyle textStyle2;
        int i9;
        long j6;
        int i10;
        int i11;
        TextStyle sub;
        final int i12;
        boolean changedInstance;
        Object rememberedValue;
        TextStyle m2295copyp1EtxEg;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(siteInfo, "siteInfo");
        Composer startRestartGroup = composer.startRestartGroup(-1718409565);
        if ((i7 & 1) != 0) {
            i8 = i6 | 6;
        } else if ((i6 & 6) == 0) {
            i8 = (startRestartGroup.changedInstance(siteInfo) ? 4 : 2) | i6;
        } else {
            i8 = i6;
        }
        int i13 = i7 & 2;
        if (i13 != 0) {
            i8 |= 48;
        } else if ((i6 & 48) == 0) {
            textStyle2 = textStyle;
            i8 |= startRestartGroup.changed(textStyle2) ? 32 : 16;
            i9 = i7 & 4;
            if (i9 == 0) {
                i8 |= 384;
            } else if ((i6 & 384) == 0) {
                j6 = j5;
                i8 |= startRestartGroup.changed(j6) ? 256 : 128;
                i10 = i7 & 8;
                if (i10 != 0) {
                    i8 |= 3072;
                } else if ((i6 & 3072) == 0) {
                    i11 = i5;
                    i8 |= startRestartGroup.changed(i11) ? 2048 : 1024;
                    if ((i8 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                        sub = i13 == 0 ? TypographyKt.getSub() : textStyle2;
                        long m3264getGrey10d7_KjU = i9 == 0 ? AppColor.INSTANCE.m3264getGrey10d7_KjU() : j6;
                        i12 = i10 == 0 ? R.string.profile_newsletter_newsletterDescription : i11;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1718409565, i8, -1, "dk.molslinjen.ui.views.screens.profile.newsletters.NewsletterAgreementTextView (NewsletterAgreementTextView.kt:21)");
                        }
                        String stringResource = StringResources_androidKt.stringResource(R.string.profile_newsletter_terms_personalDataPolicy, startRestartGroup, 6);
                        final UriHandler uriHandler = (UriHandler) startRestartGroup.consume(CompositionLocalsKt.getLocalUriHandler());
                        String stringResource2 = StringResources_androidKt.stringResource(i12, new Object[]{siteInfo.getSiteName()}, startRestartGroup, (i8 >> 9) & 14);
                        startRestartGroup.startReplaceGroup(-1816973182);
                        changedInstance = startRestartGroup.changedInstance(siteInfo) | startRestartGroup.changedInstance(uriHandler);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new Function0() { // from class: P3.a
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit NewsletterAgreementTextView_cf5BqRc$lambda$2$lambda$1;
                                    NewsletterAgreementTextView_cf5BqRc$lambda$2$lambda$1 = NewsletterAgreementTextViewKt.NewsletterAgreementTextView_cf5BqRc$lambda$2$lambda$1(SiteInfo.this, uriHandler);
                                    return NewsletterAgreementTextView_cf5BqRc$lambda$2$lambda$1;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        startRestartGroup.endReplaceGroup();
                        List listOf = CollectionsKt.listOf(new ClickableTextData(stringResource, (Function0) rememberedValue, null, null, null, 28, null));
                        m2295copyp1EtxEg = r11.m2295copyp1EtxEg((r48 & 1) != 0 ? r11.spanStyle.m2255getColor0d7_KjU() : m3264getGrey10d7_KjU, (r48 & 2) != 0 ? r11.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r11.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? r11.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r11.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r11.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r11.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r11.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r11.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r11.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r11.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r11.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r11.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r11.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r11.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r11.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r11.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r11.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r11.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r11.platformStyle : null, (r48 & 1048576) != 0 ? r11.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r11.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r11.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? sub.paragraphStyle.getTextMotion() : null);
                        ClickableTextKt.m3408ClickableTextFHprtrg(null, stringResource2, listOf, m2295copyp1EtxEg, 0L, null, startRestartGroup, 0, 49);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j6 = m3264getGrey10d7_KjU;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        sub = textStyle2;
                        i12 = i11;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final TextStyle textStyle3 = sub;
                        final long j7 = j6;
                        endRestartGroup.updateScope(new Function2() { // from class: P3.b
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit NewsletterAgreementTextView_cf5BqRc$lambda$3;
                                NewsletterAgreementTextView_cf5BqRc$lambda$3 = NewsletterAgreementTextViewKt.NewsletterAgreementTextView_cf5BqRc$lambda$3(SiteInfo.this, textStyle3, j7, i12, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                                return NewsletterAgreementTextView_cf5BqRc$lambda$3;
                            }
                        });
                        return;
                    }
                    return;
                }
                i11 = i5;
                if ((i8 & 1171) == 1170) {
                }
                if (i13 == 0) {
                }
                if (i9 == 0) {
                }
                if (i10 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                String stringResource3 = StringResources_androidKt.stringResource(R.string.profile_newsletter_terms_personalDataPolicy, startRestartGroup, 6);
                final UriHandler uriHandler2 = (UriHandler) startRestartGroup.consume(CompositionLocalsKt.getLocalUriHandler());
                String stringResource22 = StringResources_androidKt.stringResource(i12, new Object[]{siteInfo.getSiteName()}, startRestartGroup, (i8 >> 9) & 14);
                startRestartGroup.startReplaceGroup(-1816973182);
                changedInstance = startRestartGroup.changedInstance(siteInfo) | startRestartGroup.changedInstance(uriHandler2);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changedInstance) {
                }
                rememberedValue = new Function0() { // from class: P3.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit NewsletterAgreementTextView_cf5BqRc$lambda$2$lambda$1;
                        NewsletterAgreementTextView_cf5BqRc$lambda$2$lambda$1 = NewsletterAgreementTextViewKt.NewsletterAgreementTextView_cf5BqRc$lambda$2$lambda$1(SiteInfo.this, uriHandler2);
                        return NewsletterAgreementTextView_cf5BqRc$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceGroup();
                List listOf2 = CollectionsKt.listOf(new ClickableTextData(stringResource3, (Function0) rememberedValue, null, null, null, 28, null));
                m2295copyp1EtxEg = r11.m2295copyp1EtxEg((r48 & 1) != 0 ? r11.spanStyle.m2255getColor0d7_KjU() : m3264getGrey10d7_KjU, (r48 & 2) != 0 ? r11.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r11.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? r11.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r11.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r11.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r11.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r11.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r11.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r11.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r11.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r11.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r11.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r11.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r11.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r11.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r11.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r11.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r11.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r11.platformStyle : null, (r48 & 1048576) != 0 ? r11.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r11.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r11.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? sub.paragraphStyle.getTextMotion() : null);
                ClickableTextKt.m3408ClickableTextFHprtrg(null, stringResource22, listOf2, m2295copyp1EtxEg, 0L, null, startRestartGroup, 0, 49);
                if (ComposerKt.isTraceInProgress()) {
                }
                j6 = m3264getGrey10d7_KjU;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            j6 = j5;
            i10 = i7 & 8;
            if (i10 != 0) {
            }
            i11 = i5;
            if ((i8 & 1171) == 1170) {
            }
            if (i13 == 0) {
            }
            if (i9 == 0) {
            }
            if (i10 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            String stringResource32 = StringResources_androidKt.stringResource(R.string.profile_newsletter_terms_personalDataPolicy, startRestartGroup, 6);
            final UriHandler uriHandler22 = (UriHandler) startRestartGroup.consume(CompositionLocalsKt.getLocalUriHandler());
            String stringResource222 = StringResources_androidKt.stringResource(i12, new Object[]{siteInfo.getSiteName()}, startRestartGroup, (i8 >> 9) & 14);
            startRestartGroup.startReplaceGroup(-1816973182);
            changedInstance = startRestartGroup.changedInstance(siteInfo) | startRestartGroup.changedInstance(uriHandler22);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changedInstance) {
            }
            rememberedValue = new Function0() { // from class: P3.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit NewsletterAgreementTextView_cf5BqRc$lambda$2$lambda$1;
                    NewsletterAgreementTextView_cf5BqRc$lambda$2$lambda$1 = NewsletterAgreementTextViewKt.NewsletterAgreementTextView_cf5BqRc$lambda$2$lambda$1(SiteInfo.this, uriHandler22);
                    return NewsletterAgreementTextView_cf5BqRc$lambda$2$lambda$1;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceGroup();
            List listOf22 = CollectionsKt.listOf(new ClickableTextData(stringResource32, (Function0) rememberedValue, null, null, null, 28, null));
            m2295copyp1EtxEg = r11.m2295copyp1EtxEg((r48 & 1) != 0 ? r11.spanStyle.m2255getColor0d7_KjU() : m3264getGrey10d7_KjU, (r48 & 2) != 0 ? r11.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r11.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? r11.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r11.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r11.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r11.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r11.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r11.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r11.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r11.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r11.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r11.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r11.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r11.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r11.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r11.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r11.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r11.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r11.platformStyle : null, (r48 & 1048576) != 0 ? r11.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r11.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r11.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? sub.paragraphStyle.getTextMotion() : null);
            ClickableTextKt.m3408ClickableTextFHprtrg(null, stringResource222, listOf22, m2295copyp1EtxEg, 0L, null, startRestartGroup, 0, 49);
            if (ComposerKt.isTraceInProgress()) {
            }
            j6 = m3264getGrey10d7_KjU;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        textStyle2 = textStyle;
        i9 = i7 & 4;
        if (i9 == 0) {
        }
        j6 = j5;
        i10 = i7 & 8;
        if (i10 != 0) {
        }
        i11 = i5;
        if ((i8 & 1171) == 1170) {
        }
        if (i13 == 0) {
        }
        if (i9 == 0) {
        }
        if (i10 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        String stringResource322 = StringResources_androidKt.stringResource(R.string.profile_newsletter_terms_personalDataPolicy, startRestartGroup, 6);
        final UriHandler uriHandler222 = (UriHandler) startRestartGroup.consume(CompositionLocalsKt.getLocalUriHandler());
        String stringResource2222 = StringResources_androidKt.stringResource(i12, new Object[]{siteInfo.getSiteName()}, startRestartGroup, (i8 >> 9) & 14);
        startRestartGroup.startReplaceGroup(-1816973182);
        changedInstance = startRestartGroup.changedInstance(siteInfo) | startRestartGroup.changedInstance(uriHandler222);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue = new Function0() { // from class: P3.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit NewsletterAgreementTextView_cf5BqRc$lambda$2$lambda$1;
                NewsletterAgreementTextView_cf5BqRc$lambda$2$lambda$1 = NewsletterAgreementTextViewKt.NewsletterAgreementTextView_cf5BqRc$lambda$2$lambda$1(SiteInfo.this, uriHandler222);
                return NewsletterAgreementTextView_cf5BqRc$lambda$2$lambda$1;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceGroup();
        List listOf222 = CollectionsKt.listOf(new ClickableTextData(stringResource322, (Function0) rememberedValue, null, null, null, 28, null));
        m2295copyp1EtxEg = r11.m2295copyp1EtxEg((r48 & 1) != 0 ? r11.spanStyle.m2255getColor0d7_KjU() : m3264getGrey10d7_KjU, (r48 & 2) != 0 ? r11.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r11.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? r11.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r11.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r11.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r11.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r11.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r11.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r11.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r11.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r11.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r11.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r11.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r11.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r11.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r11.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r11.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r11.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r11.platformStyle : null, (r48 & 1048576) != 0 ? r11.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r11.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r11.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? sub.paragraphStyle.getTextMotion() : null);
        ClickableTextKt.m3408ClickableTextFHprtrg(null, stringResource2222, listOf222, m2295copyp1EtxEg, 0L, null, startRestartGroup, 0, 49);
        if (ComposerKt.isTraceInProgress()) {
        }
        j6 = m3264getGrey10d7_KjU;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NewsletterAgreementTextView_cf5BqRc$lambda$2$lambda$1(SiteInfo siteInfo, UriHandler uriHandler) {
        String privacyPolicyPageUrl = siteInfo.getSupportInfo().getPrivacyPolicyPageUrl();
        if (privacyPolicyPageUrl != null) {
            uriHandler.openUri(privacyPolicyPageUrl);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NewsletterAgreementTextView_cf5BqRc$lambda$3(SiteInfo siteInfo, TextStyle textStyle, long j5, int i5, int i6, int i7, Composer composer, int i8) {
        m3513NewsletterAgreementTextViewcf5BqRc(siteInfo, textStyle, j5, i5, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }
}
