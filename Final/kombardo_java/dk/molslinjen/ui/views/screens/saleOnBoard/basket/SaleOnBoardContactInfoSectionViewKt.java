package dk.molslinjen.ui.views.screens.saleOnBoard.basket;

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
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
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
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.booking.SaleOnBoardContactInfo;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.CircledBorderIconKt;
import dk.molslinjen.ui.views.reusable.input.PhoneNumberInputKt;
import dk.molslinjen.ui.views.reusable.input.StyledTextFieldKt;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardContactInfoSectionViewKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ai\u0010\r\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Ldk/molslinjen/domain/model/booking/SaleOnBoardContactInfo;", "contactInfo", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "validator", "Lkotlin/Function1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "onEmailChange", "onNameChange", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "onPhoneNumberChange", "Lkotlin/Function0;", "showPhoneNumberCodeSelector", "SaleOnBoardContactInfoSectionView", "(Ldk/molslinjen/domain/model/booking/SaleOnBoardContactInfo;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SaleOnBoardContactInfoSectionViewKt {
    public static final void SaleOnBoardContactInfoSectionView(final SaleOnBoardContactInfo contactInfo, final IFormValidator validator, final Function1<? super String, Unit> onEmailChange, final Function1<? super String, Unit> onNameChange, final Function1<? super PhoneNumber, Unit> onPhoneNumberChange, final Function0<Unit> showPhoneNumberCodeSelector, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(contactInfo, "contactInfo");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(onEmailChange, "onEmailChange");
        Intrinsics.checkNotNullParameter(onNameChange, "onNameChange");
        Intrinsics.checkNotNullParameter(onPhoneNumberChange, "onPhoneNumberChange");
        Intrinsics.checkNotNullParameter(showPhoneNumberCodeSelector, "showPhoneNumberCodeSelector");
        Composer startRestartGroup = composer.startRestartGroup(547698519);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(contactInfo) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= (i5 & 64) == 0 ? startRestartGroup.changed(validator) : startRestartGroup.changedInstance(validator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(onEmailChange) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(onNameChange) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(onPhoneNumberChange) ? 16384 : 8192;
        }
        if ((i5 & 196608) == 0) {
            i6 |= startRestartGroup.changedInstance(showPhoneNumberCodeSelector) ? 131072 : 65536;
        }
        int i7 = i6;
        if ((74899 & i7) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(547698519, i7, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardContactInfoSectionView (SaleOnBoardContactInfoSectionView.kt:42)");
            }
            final FocusManager focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            Object[] objArr = new Object[0];
            startRestartGroup.startReplaceGroup(1402864372);
            boolean changedInstance = startRestartGroup.changedInstance(contactInfo);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: f4.n
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        MutableState SaleOnBoardContactInfoSectionView$lambda$1$lambda$0;
                        SaleOnBoardContactInfoSectionView$lambda$1$lambda$0 = SaleOnBoardContactInfoSectionViewKt.SaleOnBoardContactInfoSectionView$lambda$1$lambda$0(SaleOnBoardContactInfo.this);
                        return SaleOnBoardContactInfoSectionView$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            final MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, null, null, (Function0) rememberedValue, startRestartGroup, 0, 6);
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                startRestartGroup.startReplaceGroup(539255688);
                Modifier.Companion companion = Modifier.INSTANCE;
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
                SaleOnBoardBasketFormField saleOnBoardBasketFormField = SaleOnBoardBasketFormField.Name;
                KeyboardType.Companion companion3 = KeyboardType.INSTANCE;
                int m2421getTextPjHm6EE = companion3.m2421getTextPjHm6EE();
                int m2406getWordsIUNYP9k = KeyboardCapitalization.INSTANCE.m2406getWordsIUNYP9k();
                ImeAction.Companion companion4 = ImeAction.INSTANCE;
                KeyboardOptions keyboardOptions = new KeyboardOptions(m2406getWordsIUNYP9k, (Boolean) null, m2421getTextPjHm6EE, companion4.m2385getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 114, (DefaultConstructorMarker) null);
                String name = contactInfo.getName();
                List listOf = CollectionsKt.listOf(AutofillType.PersonFullName);
                Integer valueOf = Integer.valueOf(R.string.textField_label_name);
                startRestartGroup.startReplaceGroup(260697465);
                boolean changedInstance2 = startRestartGroup.changedInstance(focusManager);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: f4.o
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit SaleOnBoardContactInfoSectionView$lambda$6$lambda$3$lambda$2;
                            SaleOnBoardContactInfoSectionView$lambda$6$lambda$3$lambda$2 = SaleOnBoardContactInfoSectionViewKt.SaleOnBoardContactInfoSectionView$lambda$6$lambda$3$lambda$2(FocusManager.this);
                            return SaleOnBoardContactInfoSectionView$lambda$6$lambda$3$lambda$2;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                int i8 = i7 << 15;
                int i9 = i8 & 3670016;
                StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(null, false, 0.0f, listOf, valueOf, null, null, onNameChange, (Function0) rememberedValue2, name, false, null, false, false, 0, saleOnBoardBasketFormField, validator, keyboardOptions, null, null, 0L, null, false, 0, startRestartGroup, ((i7 << 12) & 29360128) | 27648, i9 | 196608, 0, 16546919);
                float f5 = 16;
                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null);
                SaleOnBoardBasketFormField saleOnBoardBasketFormField2 = SaleOnBoardBasketFormField.Email;
                KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, (Boolean) null, companion3.m2416getEmailPjHm6EE(), companion4.m2383getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                String email = contactInfo.getEmail();
                List listOf2 = CollectionsKt.listOf(AutofillType.EmailAddress);
                Integer valueOf2 = Integer.valueOf(R.string.textField_label_email);
                startRestartGroup.startReplaceGroup(260720135);
                boolean changedInstance3 = startRestartGroup.changedInstance(focusManager);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: f4.p
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit SaleOnBoardContactInfoSectionView$lambda$6$lambda$5$lambda$4;
                            SaleOnBoardContactInfoSectionView$lambda$6$lambda$5$lambda$4 = SaleOnBoardContactInfoSectionViewKt.SaleOnBoardContactInfoSectionView$lambda$6$lambda$5$lambda$4(FocusManager.this);
                            return SaleOnBoardContactInfoSectionView$lambda$6$lambda$5$lambda$4;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(m315paddingqDBjuR0$default, false, 0.0f, listOf2, valueOf2, null, null, onEmailChange, (Function0) rememberedValue3, email, false, null, false, false, 0, saleOnBoardBasketFormField2, validator, keyboardOptions2, null, null, 0L, null, false, 0, startRestartGroup, (i8 & 29360128) | 27654, i9 | 12779520, 0, 16546918);
                int i10 = i7 >> 6;
                PhoneNumberInputKt.PhoneNumberInput(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null), contactInfo.getPhoneNumber(), onPhoneNumberChange, showPhoneNumberCodeSelector, SaleOnBoardBasketFormField.NationalNumber, SaleOnBoardBasketFormField.CountryCode, validator, false, startRestartGroup, (i10 & 7168) | (i10 & 896) | 221190 | i9, 128);
                startRestartGroup.endNode();
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
            } else {
                startRestartGroup.startReplaceGroup(541183206);
                Modifier.Companion companion5 = Modifier.INSTANCE;
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion5, 0.0f, 1, null);
                AppColor appColor = AppColor.INSTANCE;
                float f6 = 24;
                Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BorderKt.m108borderxT4_qwU(BackgroundKt.m103backgroundbw27NRU(fillMaxWidth$default, appColor.m3281getWhite0d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(1), appColor.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(f6));
                Alignment.Companion companion6 = Alignment.INSTANCE;
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion6.getTopStart(), false);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs);
                ComposeUiNode.Companion companion7 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor2 = companion7.getConstructor();
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
                Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy, companion7.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion7.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion7.getSetCompositeKeyHash();
                if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion7.getSetModifier());
                Modifier align = BoxScopeInstance.INSTANCE.align(PaddingKt.m315paddingqDBjuR0$default(companion5, Dp.m2599constructorimpl(16), 0.0f, 0.0f, 0.0f, 14, null), companion6.getTopEnd());
                startRestartGroup.startReplaceGroup(260759335);
                boolean changed = startRestartGroup.changed(mutableState);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue4 = new Function0() { // from class: f4.q
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit SaleOnBoardContactInfoSectionView$lambda$10$lambda$8$lambda$7;
                            SaleOnBoardContactInfoSectionView$lambda$10$lambda$8$lambda$7 = SaleOnBoardContactInfoSectionViewKt.SaleOnBoardContactInfoSectionView$lambda$10$lambda$8$lambda$7(MutableState.this);
                            return SaleOnBoardContactInfoSectionView$lambda$10$lambda$8$lambda$7;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceGroup();
                CircledBorderIconKt.m3385CircledBorderIconkaRa2wg(align, R.drawable.icon_edit, (Function0) rememberedValue4, 0.0f, 0.0f, 0L, appColor.m3265getGrey20d7_KjU(), 0L, null, startRestartGroup, 1572912, 440);
                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion6.getStart(), startRestartGroup, 0);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, companion5);
                Function0<ComposeUiNode> constructor3 = companion7.getConstructor();
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
                Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy2, companion7.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion7.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion7.getSetCompositeKeyHash();
                if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion7.getSetModifier());
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.textField_label_name, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), startRestartGroup, 0, 1572864, 65534);
                float f7 = 4;
                TextKt.m940Text4IGK_g(contactInfo.getName(), PaddingKt.m315paddingqDBjuR0$default(companion5, 0.0f, Dp.m2599constructorimpl(f7), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, 48, 1572864, 65532);
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion5, Dp.m2599constructorimpl(f6)), startRestartGroup, 6);
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.textField_label_email, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), startRestartGroup, 0, 1572864, 65534);
                TextKt.m940Text4IGK_g(contactInfo.getEmail(), PaddingKt.m315paddingqDBjuR0$default(companion5, 0.0f, Dp.m2599constructorimpl(f7), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, 48, 1572864, 65532);
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion5, Dp.m2599constructorimpl(f6)), startRestartGroup, 6);
                composer2 = startRestartGroup;
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.textField_label_phoneNumber, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer2, 0, 1572864, 65534);
                TextKt.m940Text4IGK_g(contactInfo.getPhoneNumber().toFormattedString(), PaddingKt.m315paddingqDBjuR0$default(companion5, 0.0f, Dp.m2599constructorimpl(f7), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer2, 48, 1572864, 65532);
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
            endRestartGroup.updateScope(new Function2() { // from class: f4.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SaleOnBoardContactInfoSectionView$lambda$11;
                    SaleOnBoardContactInfoSectionView$lambda$11 = SaleOnBoardContactInfoSectionViewKt.SaleOnBoardContactInfoSectionView$lambda$11(SaleOnBoardContactInfo.this, validator, onEmailChange, onNameChange, onPhoneNumberChange, showPhoneNumberCodeSelector, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SaleOnBoardContactInfoSectionView$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState SaleOnBoardContactInfoSectionView$lambda$1$lambda$0(SaleOnBoardContactInfo saleOnBoardContactInfo) {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(!saleOnBoardContactInfo.getWasPrefilled()), null, 2, null);
        return mutableStateOf$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardContactInfoSectionView$lambda$10$lambda$8$lambda$7(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardContactInfoSectionView$lambda$11(SaleOnBoardContactInfo saleOnBoardContactInfo, IFormValidator iFormValidator, Function1 function1, Function1 function12, Function1 function13, Function0 function0, int i5, Composer composer, int i6) {
        SaleOnBoardContactInfoSectionView(saleOnBoardContactInfo, iFormValidator, function1, function12, function13, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardContactInfoSectionView$lambda$6$lambda$3$lambda$2(FocusManager focusManager) {
        focusManager.mo1288moveFocus3ESFkO8(FocusDirection.INSTANCE.m1279getDowndhqQ8s());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardContactInfoSectionView$lambda$6$lambda$5$lambda$4(FocusManager focusManager) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        return Unit.INSTANCE;
    }
}
