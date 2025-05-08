package dk.molslinjen.ui.views.screens.booking.summary;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.AutofillType;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.booking.CheckoutContactInfo;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.CircledBorderIconKt;
import dk.molslinjen.ui.views.reusable.input.PhoneNumberInputKt;
import dk.molslinjen.ui.views.reusable.input.StyledTextFieldKt;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.screens.booking.summary.PersonalInfoSectionViewKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u007f\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/domain/model/booking/CheckoutContactInfo;", "personalInfo", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "validator", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", BuildConfig.FLAVOR, "onPhoneNumberChange", BuildConfig.FLAVOR, "onEmailChange", "onPostalCodeChange", "Lkotlin/Function0;", "startPersonalInfoEdit", "showPhoneNumberCodeSelector", BuildConfig.FLAVOR, "isInEditMode", "PersonalInfoSection", "(Ldk/molslinjen/domain/model/booking/CheckoutContactInfo;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PersonalInfoSectionViewKt {
    public static final void PersonalInfoSection(final CheckoutContactInfo personalInfo, final IFormValidator validator, final Function1<? super PhoneNumber, Unit> onPhoneNumberChange, final Function1<? super String, Unit> onEmailChange, final Function1<? super String, Unit> onPostalCodeChange, final Function0<Unit> startPersonalInfoEdit, final Function0<Unit> showPhoneNumberCodeSelector, final boolean z5, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(personalInfo, "personalInfo");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(onPhoneNumberChange, "onPhoneNumberChange");
        Intrinsics.checkNotNullParameter(onEmailChange, "onEmailChange");
        Intrinsics.checkNotNullParameter(onPostalCodeChange, "onPostalCodeChange");
        Intrinsics.checkNotNullParameter(startPersonalInfoEdit, "startPersonalInfoEdit");
        Intrinsics.checkNotNullParameter(showPhoneNumberCodeSelector, "showPhoneNumberCodeSelector");
        Composer startRestartGroup = composer.startRestartGroup(-129764177);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(personalInfo) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= (i5 & 64) == 0 ? startRestartGroup.changed(validator) : startRestartGroup.changedInstance(validator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(onPhoneNumberChange) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(onEmailChange) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(onPostalCodeChange) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(startPersonalInfoEdit) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(showPhoneNumberCodeSelector) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 8388608 : 4194304;
        }
        int i7 = i6;
        if ((4793491 & i7) == 4793490 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-129764177, i7, -1, "dk.molslinjen.ui.views.screens.booking.summary.PersonalInfoSection (PersonalInfoSectionView.kt:44)");
            }
            final FocusManager focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            Modifier.Companion companion = Modifier.INSTANCE;
            float f5 = 16;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.bookingSummary_personalInfo, startRestartGroup, 6), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 7, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), startRestartGroup, 48, 1572864, 65532);
            if (z5) {
                startRestartGroup.startReplaceGroup(582810194);
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                int i8 = 3670016 & (i7 << 15);
                PhoneNumberInputKt.PhoneNumberInput(null, personalInfo.getPhoneNumber(), onPhoneNumberChange, showPhoneNumberCodeSelector, BookingSummaryFormField.NationalNumber, BookingSummaryFormField.CountryCode, validator, false, startRestartGroup, (i7 & 896) | 221184 | ((i7 >> 9) & 7168) | i8, 129);
                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null);
                BookingSummaryFormField bookingSummaryFormField = BookingSummaryFormField.Email;
                KeyboardType.Companion companion3 = KeyboardType.INSTANCE;
                int m2416getEmailPjHm6EE = companion3.m2416getEmailPjHm6EE();
                ImeAction.Companion companion4 = ImeAction.INSTANCE;
                KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, m2416getEmailPjHm6EE, companion4.m2385getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                String email = personalInfo.getEmail();
                List listOf = CollectionsKt.listOf(AutofillType.EmailAddress);
                Integer valueOf = Integer.valueOf(R.string.textField_label_email);
                startRestartGroup.startReplaceGroup(1192089223);
                boolean changedInstance = startRestartGroup.changedInstance(focusManager);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: h3.Q
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit PersonalInfoSection$lambda$4$lambda$1$lambda$0;
                            PersonalInfoSection$lambda$4$lambda$1$lambda$0 = PersonalInfoSectionViewKt.PersonalInfoSection$lambda$4$lambda$1$lambda$0(FocusManager.this);
                            return PersonalInfoSection$lambda$4$lambda$1$lambda$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                int i9 = i8 | 12779520;
                StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(m315paddingqDBjuR0$default, false, 0.0f, listOf, valueOf, null, null, onEmailChange, (Function0) rememberedValue, email, false, null, false, false, 0, bookingSummaryFormField, validator, keyboardOptions, null, null, 0L, null, false, 0, startRestartGroup, ((i7 << 12) & 29360128) | 27654, i9, 0, 16546918);
                Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null);
                BookingSummaryFormField bookingSummaryFormField2 = BookingSummaryFormField.PostalCode;
                KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, (Boolean) null, companion3.m2417getNumberPjHm6EE(), companion4.m2383getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                String postalCode = personalInfo.getPostalCode();
                List listOf2 = CollectionsKt.listOf(AutofillType.PostalCode);
                Integer valueOf2 = Integer.valueOf(R.string.textField_label_zipcode);
                startRestartGroup.startReplaceGroup(1192112213);
                boolean changedInstance2 = startRestartGroup.changedInstance(focusManager);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: h3.S
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit PersonalInfoSection$lambda$4$lambda$3$lambda$2;
                            PersonalInfoSection$lambda$4$lambda$3$lambda$2 = PersonalInfoSectionViewKt.PersonalInfoSection$lambda$4$lambda$3$lambda$2(FocusManager.this);
                            return PersonalInfoSection$lambda$4$lambda$3$lambda$2;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(m315paddingqDBjuR0$default2, false, 0.0f, listOf2, valueOf2, null, null, onPostalCodeChange, (Function0) rememberedValue2, postalCode, false, null, false, false, 0, bookingSummaryFormField2, validator, keyboardOptions2, null, null, 0L, null, false, 0, startRestartGroup, ((i7 << 9) & 29360128) | 27654, i9, 0, 16546918);
                startRestartGroup.endNode();
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
            } else {
                startRestartGroup.startReplaceGroup(584719453);
                BookingSummaryFormField bookingSummaryFormField3 = BookingSummaryFormField.NationalNumber;
                validator.validate(bookingSummaryFormField3, personalInfo.getPhoneNumber().getNationalNumber());
                BookingSummaryFormField bookingSummaryFormField4 = BookingSummaryFormField.CountryCode;
                validator.validate(bookingSummaryFormField4, StringsKt.replace$default(personalInfo.getPhoneNumber().getCountryCode(), "+", BuildConfig.FLAVOR, false, 4, (Object) null));
                BookingSummaryFormField bookingSummaryFormField5 = BookingSummaryFormField.Email;
                validator.validate(bookingSummaryFormField5, personalInfo.getEmail());
                BookingSummaryFormField bookingSummaryFormField6 = BookingSummaryFormField.PostalCode;
                validator.validate(bookingSummaryFormField6, personalInfo.getPostalCode());
                validator.submit(bookingSummaryFormField3);
                validator.submit(bookingSummaryFormField4);
                validator.submit(bookingSummaryFormField5);
                validator.submit(bookingSummaryFormField6);
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                AppColor appColor = AppColor.INSTANCE;
                float f6 = 24;
                Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BorderKt.m108borderxT4_qwU(BackgroundKt.m103backgroundbw27NRU(fillMaxWidth$default, appColor.m3281getWhite0d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(1), appColor.m3267getGrey40d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(f6));
                Alignment.Companion companion5 = Alignment.INSTANCE;
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion5.getTopStart(), false);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs);
                ComposeUiNode.Companion companion6 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor2 = companion6.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy, companion6.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion6.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion6.getSetCompositeKeyHash();
                if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion6.getSetModifier());
                CircledBorderIconKt.m3385CircledBorderIconkaRa2wg(BoxScopeInstance.INSTANCE.align(PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 0.0f, 14, null), companion5.getTopEnd()), R.drawable.icon_edit, startPersonalInfoEdit, 0.0f, 0.0f, 0L, appColor.m3267getGrey40d7_KjU(), 0L, StringResources_androidKt.stringResource(R.string.accessibilityLabel_edit, startRestartGroup, 6), startRestartGroup, ((i7 >> 9) & 896) | 1572912, 184);
                startRestartGroup.startReplaceGroup(1192167247);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                Composer.Companion companion7 = Composer.INSTANCE;
                if (rememberedValue3 == companion7.getEmpty()) {
                    rememberedValue3 = new Function1() { // from class: h3.T
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit PersonalInfoSection$lambda$10$lambda$6$lambda$5;
                            PersonalInfoSection$lambda$10$lambda$6$lambda$5 = PersonalInfoSectionViewKt.PersonalInfoSection$lambda$10$lambda$6$lambda$5((SemanticsPropertyReceiver) obj);
                            return PersonalInfoSection$lambda$10$lambda$6$lambda$5;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                Modifier semantics$default = SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue3, 1, null);
                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion5.getStart(), startRestartGroup, 0);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, semantics$default);
                Function0<ComposeUiNode> constructor3 = companion6.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy2, companion6.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion6.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion6.getSetCompositeKeyHash();
                if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion6.getSetModifier());
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.textField_label_phoneNumber, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), startRestartGroup, 0, 1572864, 65534);
                float f7 = 4;
                TextKt.m940Text4IGK_g(personalInfo.getPhoneNumber().toFormattedString(), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f7), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, 48, 1572864, 65532);
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f6)), startRestartGroup, 6);
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.textField_label_email, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), startRestartGroup, 0, 1572864, 65534);
                TextKt.m940Text4IGK_g(personalInfo.getEmail(), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f7), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, 48, 1572864, 65532);
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f6)), startRestartGroup, 6);
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.textField_label_zipcode, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), startRestartGroup, 0, 1572864, 65534);
                Modifier m315paddingqDBjuR0$default3 = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f7), 0.0f, 0.0f, 13, null);
                startRestartGroup.startReplaceGroup(1853603638);
                boolean changedInstance3 = startRestartGroup.changedInstance(personalInfo);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (changedInstance3 || rememberedValue4 == companion7.getEmpty()) {
                    rememberedValue4 = new Function1() { // from class: h3.U
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit PersonalInfoSection$lambda$10$lambda$9$lambda$8$lambda$7;
                            PersonalInfoSection$lambda$10$lambda$9$lambda$8$lambda$7 = PersonalInfoSectionViewKt.PersonalInfoSection$lambda$10$lambda$9$lambda$8$lambda$7(CheckoutContactInfo.this, (SemanticsPropertyReceiver) obj);
                            return PersonalInfoSection$lambda$10$lambda$9$lambda$8$lambda$7;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
                TextKt.m940Text4IGK_g(personalInfo.getPostalCode(), SemanticsModifierKt.semantics$default(m315paddingqDBjuR0$default3, false, (Function1) rememberedValue4, 1, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer2, 0, 1572864, 65532);
                composer2.endNode();
                composer2.endNode();
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: h3.V
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PersonalInfoSection$lambda$11;
                    PersonalInfoSection$lambda$11 = PersonalInfoSectionViewKt.PersonalInfoSection$lambda$11(CheckoutContactInfo.this, validator, onPhoneNumberChange, onEmailChange, onPostalCodeChange, startPersonalInfoEdit, showPhoneNumberCodeSelector, z5, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return PersonalInfoSection$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PersonalInfoSection$lambda$10$lambda$6$lambda$5(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setTraversalGroup(semantics, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PersonalInfoSection$lambda$10$lambda$9$lambda$8$lambda$7(CheckoutContactInfo checkoutContactInfo, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, CollectionsKt.joinToString$default(StringsKt.chunked(checkoutContactInfo.getPostalCode(), 2), " ", null, null, 0, null, null, 62, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PersonalInfoSection$lambda$11(CheckoutContactInfo checkoutContactInfo, IFormValidator iFormValidator, Function1 function1, Function1 function12, Function1 function13, Function0 function0, Function0 function02, boolean z5, int i5, Composer composer, int i6) {
        PersonalInfoSection(checkoutContactInfo, iFormValidator, function1, function12, function13, function0, function02, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PersonalInfoSection$lambda$4$lambda$1$lambda$0(FocusManager focusManager) {
        focusManager.mo1288moveFocus3ESFkO8(FocusDirection.INSTANCE.m1279getDowndhqQ8s());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PersonalInfoSection$lambda$4$lambda$3$lambda$2(FocusManager focusManager) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        return Unit.INSTANCE;
    }
}
