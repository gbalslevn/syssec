package dk.molslinjen.ui.views.screens.profile.newsletters;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.account.newsletters.NewsletterSubscription;
import dk.molslinjen.domain.model.site.SiteInfo;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.input.dropdown.DropdownItem;
import dk.molslinjen.ui.views.reusable.input.dropdown.DropdownPickerKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProfileNewslettersScreenKt$ProfileNewslettersContent$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function2<SiteInfo, Boolean, Unit> $onNewsletterSubscriptionChange;
    final /* synthetic */ Function2<SiteInfo, Boolean, Unit> $onPromotionsSubscriptionChange;
    final /* synthetic */ Function1<NewsletterSubscription, Unit> $onSiteChange;
    final /* synthetic */ NewsletterSubscription $selectedSiteSubscriptions;
    final /* synthetic */ List<NewsletterSubscription> $subscriptions;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public ProfileNewslettersScreenKt$ProfileNewslettersContent$1(NewsletterSubscription newsletterSubscription, List<NewsletterSubscription> list, Function1<? super NewsletterSubscription, Unit> function1, Function2<? super SiteInfo, ? super Boolean, Unit> function2, Function2<? super SiteInfo, ? super Boolean, Unit> function22) {
        this.$selectedSiteSubscriptions = newsletterSubscription;
        this.$subscriptions = list;
        this.$onSiteChange = function1;
        this.$onNewsletterSubscriptionChange = function2;
        this.$onPromotionsSubscriptionChange = function22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$7$lambda$2$lambda$1(Function1 function1, DropdownItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it.getValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$7$lambda$4$lambda$3(Function2 function2, NewsletterSubscription newsletterSubscription, boolean z5) {
        function2.invoke(newsletterSubscription.getSiteInfo(), Boolean.valueOf(z5));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$7$lambda$6$lambda$5(Function2 function2, NewsletterSubscription newsletterSubscription, boolean z5) {
        function2.invoke(newsletterSubscription.getSiteInfo(), Boolean.valueOf(z5));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        DropdownItem dropdownItem;
        DropdownItem dropdownItem2;
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-321298506, i5, -1, "dk.molslinjen.ui.views.screens.profile.newsletters.ProfileNewslettersContent.<anonymous> (ProfileNewslettersScreen.kt:68)");
        }
        float f5 = 24;
        Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m2599constructorimpl(f5), 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 10, null);
        final NewsletterSubscription newsletterSubscription = this.$selectedSiteSubscriptions;
        List<NewsletterSubscription> list = this.$subscriptions;
        final Function1<NewsletterSubscription, Unit> function1 = this.$onSiteChange;
        final Function2<SiteInfo, Boolean, Unit> function2 = this.$onNewsletterSubscriptionChange;
        final Function2<SiteInfo, Boolean, Unit> function22 = this.$onPromotionsSubscriptionChange;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m315paddingqDBjuR0$default);
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer m1226constructorimpl = Updater.m1226constructorimpl(composer);
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        composer.startReplaceGroup(1088752851);
        if (newsletterSubscription != null && !list.isEmpty()) {
            composer.startReplaceGroup(1088754186);
            if (list.size() > 1) {
                dropdownItem = ProfileNewslettersScreenKt.toDropdownItem(newsletterSubscription);
                List<NewsletterSubscription> list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    dropdownItem2 = ProfileNewslettersScreenKt.toDropdownItem((NewsletterSubscription) it.next());
                    arrayList.add(dropdownItem2);
                }
                composer.startReplaceGroup(1088762454);
                boolean changed = composer.changed(function1);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.newsletters.a
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit invoke$lambda$7$lambda$2$lambda$1;
                            invoke$lambda$7$lambda$2$lambda$1 = ProfileNewslettersScreenKt$ProfileNewslettersContent$1.invoke$lambda$7$lambda$2$lambda$1(Function1.this, (DropdownItem) obj);
                            return invoke$lambda$7$lambda$2$lambda$1;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                DropdownPickerKt.DropdownPicker(dropdownItem, arrayList, (Function1) rememberedValue, null, composer, 0, 8);
            }
            composer.endReplaceGroup();
            String stringResource = StringResources_androidKt.stringResource(R.string.profile_newsletter_newsletterTitle, composer, 6);
            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-155242163, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.newsletters.ProfileNewslettersScreenKt$ProfileNewslettersContent$1$1$3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    if ((i6 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-155242163, i6, -1, "dk.molslinjen.ui.views.screens.profile.newsletters.ProfileNewslettersContent.<anonymous>.<anonymous>.<anonymous> (ProfileNewslettersScreen.kt:88)");
                    }
                    NewsletterAgreementTextViewKt.m3513NewsletterAgreementTextViewcf5BqRc(NewsletterSubscription.this.getSiteInfo(), TypographyKt.getParagraphSmall(), 0L, 0, composer2, 48, 12);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer, 54);
            boolean isNewslettersSubscribed = newsletterSubscription.isNewslettersSubscribed();
            composer.startReplaceGroup(1088780530);
            boolean changed2 = composer.changed(function2) | composer.changedInstance(newsletterSubscription);
            Object rememberedValue2 = composer.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.newsletters.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit invoke$lambda$7$lambda$4$lambda$3;
                        invoke$lambda$7$lambda$4$lambda$3 = ProfileNewslettersScreenKt$ProfileNewslettersContent$1.invoke$lambda$7$lambda$4$lambda$3(Function2.this, newsletterSubscription, ((Boolean) obj).booleanValue());
                        return invoke$lambda$7$lambda$4$lambda$3;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceGroup();
            NewsletterSubscriptionRowKt.NewsletterSubscriptionRow(stringResource, rememberComposableLambda, isNewslettersSubscribed, (Function1) rememberedValue2, composer, 48);
            String stringResource2 = StringResources_androidKt.stringResource(R.string.profile_newsletter_promotionsTitle, composer, 6);
            ComposableLambda rememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(517027126, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.newsletters.ProfileNewslettersScreenKt$ProfileNewslettersContent$1$1$5
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    TextStyle m2295copyp1EtxEg;
                    if ((i6 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(517027126, i6, -1, "dk.molslinjen.ui.views.screens.profile.newsletters.ProfileNewslettersContent.<anonymous>.<anonymous>.<anonymous> (ProfileNewslettersScreen.kt:96)");
                    }
                    String upperCase = NewsletterSubscription.this.getSiteInfo().getSiteName().toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    String stringResource3 = StringResources_androidKt.stringResource(R.string.profile_newsletter_promotionsDescription, new Object[]{upperCase}, composer2, 6);
                    m2295copyp1EtxEg = r16.m2295copyp1EtxEg((r48 & 1) != 0 ? r16.spanStyle.m2255getColor0d7_KjU() : AppColor.INSTANCE.m3264getGrey10d7_KjU(), (r48 & 2) != 0 ? r16.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r16.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? r16.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r16.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r16.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r16.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r16.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r16.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r16.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r16.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r16.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r16.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r16.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r16.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r16.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r16.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r16.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r16.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r16.platformStyle : null, (r48 & 1048576) != 0 ? r16.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r16.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r16.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? TypographyKt.getParagraphSmall().paragraphStyle.getTextMotion() : null);
                    TextKt.m940Text4IGK_g(stringResource3, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, m2295copyp1EtxEg, composer2, 0, 0, 65534);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer, 54);
            boolean isPromotionsSubscribed = newsletterSubscription.isPromotionsSubscribed();
            composer.startReplaceGroup(1088806418);
            boolean changed3 = composer.changed(function22) | composer.changedInstance(newsletterSubscription);
            Object rememberedValue3 = composer.rememberedValue();
            if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.newsletters.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit invoke$lambda$7$lambda$6$lambda$5;
                        invoke$lambda$7$lambda$6$lambda$5 = ProfileNewslettersScreenKt$ProfileNewslettersContent$1.invoke$lambda$7$lambda$6$lambda$5(Function2.this, newsletterSubscription, ((Boolean) obj).booleanValue());
                        return invoke$lambda$7$lambda$6$lambda$5;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            composer.endReplaceGroup();
            NewsletterSubscriptionRowKt.NewsletterSubscriptionRow(stringResource2, rememberComposableLambda2, isPromotionsSubscribed, (Function1) rememberedValue3, composer, 48);
        }
        composer.endReplaceGroup();
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
