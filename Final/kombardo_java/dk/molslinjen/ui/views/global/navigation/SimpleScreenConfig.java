package dk.molslinjen.ui.views.global.navigation;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.generated.destinations.AgreementsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.DeparturesScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TicketsScreenDestination;
import com.ramcosta.composedestinations.navigation.DependenciesContainerBuilder;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import dk.molslinjen.core.Feature;
import dk.molslinjen.domain.managers.company.ICompanyViewHelper;
import dk.molslinjen.domain.managers.ticket.ITicketsManager;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.account.user.AccountUser;
import dk.molslinjen.domain.model.account.user.User;
import dk.molslinjen.domain.model.account.user.UserCompany;
import dk.molslinjen.domain.model.account.user.UserInfo;
import dk.molslinjen.domain.model.account.user.UserPersonalDetails;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.global.bottombar.BottomBarButtonConfiguration;
import dk.molslinjen.ui.views.global.bottombar.BottomBarConfiguration;
import dk.molslinjen.ui.views.global.navigation.SimpleScreenConfig;
import dk.molslinjen.ui.views.global.topbar.NavigationButton;
import dk.molslinjen.ui.views.global.topbar.TopBarButtonConfiguration;
import dk.molslinjen.ui.views.global.topbar.TopBarButtonType;
import dk.molslinjen.ui.views.global.topbar.TopBarConfiguration;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0001&BQ\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012&\u0010\f\u001a\"\u0012\f\u0012\n\u0012\u0002\b\u00030\u0002j\u0002`\t\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0010\u001a\u00020\u000b2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\nH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$R4\u0010\f\u001a\"\u0012\f\u0012\n\u0012\u0002\b\u00030\u0002j\u0002`\t\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010%¨\u0006'"}, d2 = {"Ldk/molslinjen/ui/views/global/navigation/SimpleScreenConfig;", BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "destination", "Ldk/molslinjen/ui/views/global/topbar/TopBarConfiguration;", "topBarConfiguration", "Ldk/molslinjen/ui/views/global/bottombar/BottomBarConfiguration;", "bottomBarConfiguration", "Lkotlin/Function2;", "Lcom/ramcosta/composedestinations/spec/DestinationSpec;", "Lcom/ramcosta/composedestinations/navigation/DependenciesContainerBuilder;", BuildConfig.FLAVOR, "buildDependencies", "<init>", "(Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;Ldk/molslinjen/ui/views/global/topbar/TopBarConfiguration;Ldk/molslinjen/ui/views/global/bottombar/BottomBarConfiguration;Lkotlin/jvm/functions/Function4;)V", "dependenciesContainerBuilder", "BuildDependencies", "(Lcom/ramcosta/composedestinations/navigation/DependenciesContainerBuilder;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "getDestination", "()Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Ldk/molslinjen/ui/views/global/topbar/TopBarConfiguration;", "getTopBarConfiguration", "()Ldk/molslinjen/ui/views/global/topbar/TopBarConfiguration;", "Ldk/molslinjen/ui/views/global/bottombar/BottomBarConfiguration;", "getBottomBarConfiguration", "()Ldk/molslinjen/ui/views/global/bottombar/BottomBarConfiguration;", "Lkotlin/jvm/functions/Function4;", "Companion", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SimpleScreenConfig {
    private static BottomBarButtonConfiguration bottomBarCateringButton;
    private static BottomBarButtonConfiguration bottomBarDeparturesButton;
    private static BottomBarButtonConfiguration bottomBarMultirideAndCommuterButton;
    private static BottomBarButtonConfiguration bottomBarTicketsButton;
    public static TopBarButtonConfiguration topBarProfileButton;
    private final BottomBarConfiguration bottomBarConfiguration;
    private final Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> buildDependencies;
    private final TypedDestinationSpec<?> destination;
    private final TopBarConfiguration topBarConfiguration;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<BottomBarConfiguration> defaultBottomNavConfig$delegate = LazyKt.lazy(new Function0() { // from class: R1.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            BottomBarConfiguration defaultBottomNavConfig_delegate$lambda$1;
            defaultBottomNavConfig_delegate$lambda$1 = SimpleScreenConfig.defaultBottomNavConfig_delegate$lambda$1();
            return defaultBottomNavConfig_delegate$lambda$1;
        }
    });
    private static final Lazy<TopBarConfiguration> defaultTopBarConfig$delegate = LazyKt.lazy(new Function0() { // from class: R1.h
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            TopBarConfiguration defaultTopBarConfig_delegate$lambda$2;
            defaultTopBarConfig_delegate$lambda$2 = SimpleScreenConfig.defaultTopBarConfig_delegate$lambda$2();
            return defaultTopBarConfig_delegate$lambda$2;
        }
    });

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001d\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u00020!8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0019\u001a\u0004\b\"\u0010#¨\u0006%²\u0006\n\u0010&\u001a\u00020'X\u008a\u008e\u0002"}, d2 = {"Ldk/molslinjen/ui/views/global/navigation/SimpleScreenConfig$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "initBottomBar", BuildConfig.FLAVOR, "ticketsManager", "Ldk/molslinjen/domain/managers/ticket/ITicketsManager;", "initTopBar", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "companyViewHelper", "Ldk/molslinjen/domain/managers/company/ICompanyViewHelper;", "CompanyPopupContent", "(Ldk/molslinjen/domain/managers/company/ICompanyViewHelper;Ldk/molslinjen/domain/managers/user/IUserManager;Landroidx/compose/runtime/Composer;I)V", "bottomBarDeparturesButton", "Ldk/molslinjen/ui/views/global/bottombar/BottomBarButtonConfiguration;", "bottomBarTicketsButton", "bottomBarMultirideAndCommuterButton", "bottomBarCateringButton", "defaultBottomNavConfig", "Ldk/molslinjen/ui/views/global/bottombar/BottomBarConfiguration;", "getDefaultBottomNavConfig", "()Ldk/molslinjen/ui/views/global/bottombar/BottomBarConfiguration;", "defaultBottomNavConfig$delegate", "Lkotlin/Lazy;", "topBarProfileButton", "Ldk/molslinjen/ui/views/global/topbar/TopBarButtonConfiguration;", "getTopBarProfileButton", "()Ldk/molslinjen/ui/views/global/topbar/TopBarButtonConfiguration;", "setTopBarProfileButton", "(Ldk/molslinjen/ui/views/global/topbar/TopBarButtonConfiguration;)V", "defaultTopBarConfig", "Ldk/molslinjen/ui/views/global/topbar/TopBarConfiguration;", "getDefaultTopBarConfig", "()Ldk/molslinjen/ui/views/global/topbar/TopBarConfiguration;", "defaultTopBarConfig$delegate", "app_kombardoProd", "closePopupCounter", BuildConfig.FLAVOR}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public final void CompanyPopupContent(final ICompanyViewHelper iCompanyViewHelper, final IUserManager iUserManager, Composer composer, final int i5) {
            int i6;
            Composer composer2;
            String fullName;
            UserInfo userInfo;
            UserPersonalDetails personalDetails;
            List<UserCompany> companies;
            Composer startRestartGroup = composer.startRestartGroup(1479340933);
            if ((i5 & 6) == 0) {
                i6 = (startRestartGroup.changedInstance(iCompanyViewHelper) ? 4 : 2) | i5;
            } else {
                i6 = i5;
            }
            if ((i5 & 48) == 0) {
                i6 |= startRestartGroup.changedInstance(iUserManager) ? 32 : 16;
            }
            if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
                startRestartGroup.skipToGroupEnd();
                composer2 = startRestartGroup;
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1479340933, i6, -1, "dk.molslinjen.ui.views.global.navigation.SimpleScreenConfig.Companion.CompanyPopupContent (SimpleScreenConfig.kt:125)");
                }
                startRestartGroup.startReplaceGroup(1980185541);
                Object rememberedValue = startRestartGroup.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                UserCompany userCompany = null;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                MutableState mutableState = (MutableState) rememberedValue;
                startRestartGroup.endReplaceGroup();
                Boolean bool = (Boolean) SnapshotStateKt.collectAsState(iCompanyViewHelper.getShowCompanyPopupState(), null, startRestartGroup, 0, 1).getValue();
                boolean booleanValue = bool.booleanValue();
                startRestartGroup.startReplaceGroup(1980191425);
                boolean changed = startRestartGroup.changed(booleanValue) | startRestartGroup.changedInstance(iCompanyViewHelper);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new SimpleScreenConfig$Companion$CompanyPopupContent$1$1(booleanValue, iCompanyViewHelper, mutableState, null);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(bool, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, 0);
                IUserManager.UserState userState = (IUserManager.UserState) SnapshotStateKt.collectAsState(iUserManager.getCurrentUserState(), null, startRestartGroup, 0, 1).getValue();
                User user = userState.getUser();
                AccountUser accountUser = user instanceof AccountUser ? (AccountUser) user : null;
                if (accountUser != null && (companies = accountUser.getCompanies()) != null) {
                    Iterator<T> it = companies.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (Intrinsics.areEqual(((UserCompany) next).getCompanyId(), userState.getActiveCompanyId())) {
                            userCompany = next;
                            break;
                        }
                    }
                    userCompany = userCompany;
                }
                UserCompany userCompany2 = userCompany;
                Alignment.Companion companion2 = Alignment.INSTANCE;
                Alignment.Vertical centerVertically = companion2.getCenterVertically();
                Modifier.Companion companion3 = Modifier.INSTANCE;
                Arrangement arrangement = Arrangement.INSTANCE;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, startRestartGroup, 48);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion3);
                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion4.getConstructor();
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
                Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                float f5 = 16;
                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion3, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5), 0.0f, Dp.m2599constructorimpl(f5), 4, null);
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), startRestartGroup, 0);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
                Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
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
                Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
                if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                composer2 = startRestartGroup;
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.profile_company_loggedInAs, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 0, 1572864, 65534);
                Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(companion3, 0.0f, Dp.m2599constructorimpl(4), 0.0f, 0.0f, 13, null);
                if (userCompany2 == null || (fullName = userCompany2.companyAndDepartmentName()) == null) {
                    fullName = (accountUser == null || (userInfo = accountUser.getUserInfo()) == null || (personalDetails = userInfo.getPersonalDetails()) == null) ? BuildConfig.FLAVOR : personalDetails.getFullName();
                }
                TextKt.m940Text4IGK_g(fullName, m315paddingqDBjuR0$default2, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer2, 48, 1572864, 65532);
                composer2.endNode();
                composer2.startReplaceGroup(-1384119110);
                boolean changedInstance = composer2.changedInstance(iCompanyViewHelper);
                Object rememberedValue3 = composer2.rememberedValue();
                if (changedInstance || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: R1.j
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CompanyPopupContent$lambda$8$lambda$7$lambda$6;
                            CompanyPopupContent$lambda$8$lambda$7$lambda$6 = SimpleScreenConfig.Companion.CompanyPopupContent$lambda$8$lambda$7$lambda$6(ICompanyViewHelper.this);
                            return CompanyPopupContent$lambda$8$lambda$7$lambda$6;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue3);
                }
                composer2.endReplaceGroup();
                IconButtonKt.IconButton((Function0) rememberedValue3, null, false, null, null, ComposableSingletons$SimpleScreenConfigKt.INSTANCE.m3379getLambda1$app_kombardoProd(), composer2, 196608, 30);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new Function2() { // from class: R1.k
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit CompanyPopupContent$lambda$9;
                        CompanyPopupContent$lambda$9 = SimpleScreenConfig.Companion.CompanyPopupContent$lambda$9(SimpleScreenConfig.Companion.this, iCompanyViewHelper, iUserManager, i5, (Composer) obj, ((Integer) obj2).intValue());
                        return CompanyPopupContent$lambda$9;
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int CompanyPopupContent$lambda$1(MutableState<Integer> mutableState) {
            return mutableState.getValue().intValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void CompanyPopupContent$lambda$2(MutableState<Integer> mutableState, int i5) {
            mutableState.setValue(Integer.valueOf(i5));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit CompanyPopupContent$lambda$8$lambda$7$lambda$6(ICompanyViewHelper iCompanyViewHelper) {
            iCompanyViewHelper.hideCompanyPopup();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit CompanyPopupContent$lambda$9(Companion companion, ICompanyViewHelper iCompanyViewHelper, IUserManager iUserManager, int i5, Composer composer, int i6) {
            companion.CompanyPopupContent(iCompanyViewHelper, iUserManager, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
            return Unit.INSTANCE;
        }

        public final BottomBarConfiguration getDefaultBottomNavConfig() {
            return (BottomBarConfiguration) SimpleScreenConfig.defaultBottomNavConfig$delegate.getValue();
        }

        public final TopBarConfiguration getDefaultTopBarConfig() {
            return (TopBarConfiguration) SimpleScreenConfig.defaultTopBarConfig$delegate.getValue();
        }

        public final TopBarButtonConfiguration getTopBarProfileButton() {
            TopBarButtonConfiguration topBarButtonConfiguration = SimpleScreenConfig.topBarProfileButton;
            if (topBarButtonConfiguration != null) {
                return topBarButtonConfiguration;
            }
            Intrinsics.throwUninitializedPropertyAccessException("topBarProfileButton");
            return null;
        }

        public final void initBottomBar(ITicketsManager ticketsManager) {
            Intrinsics.checkNotNullParameter(ticketsManager, "ticketsManager");
            SimpleScreenConfig.bottomBarDeparturesButton = new BottomBarButtonConfiguration(DeparturesScreenDestination.INSTANCE, R.raw.animation_lottie_departures, R.string.departuresScreen_title, null, 8, null);
            SimpleScreenConfig.bottomBarTicketsButton = new BottomBarButtonConfiguration(TicketsScreenDestination.INSTANCE, R.raw.animation_lottie_my_tickets, R.string.ticketsScreen_title, ticketsManager.getActiveTicketsCount());
            SimpleScreenConfig.bottomBarMultirideAndCommuterButton = new BottomBarButtonConfiguration(AgreementsScreenDestination.INSTANCE, R.raw.animation_lottie_agreements, R.string.agreementsScreen_title, null, 8, null);
            SimpleScreenConfig.bottomBarCateringButton = new BottomBarButtonConfiguration(SaleOnBoardScreenDestination.INSTANCE, R.raw.animation_lottie_catering, R.string.cateringScreen_title, null, 8, null);
        }

        public final void initTopBar(final IUserManager userManager, final ICompanyViewHelper companyViewHelper) {
            Intrinsics.checkNotNullParameter(userManager, "userManager");
            Intrinsics.checkNotNullParameter(companyViewHelper, "companyViewHelper");
            setTopBarProfileButton(new TopBarButtonConfiguration.Custom(ComposableLambdaKt.composableLambdaInstance(-321117337, true, new SimpleScreenConfig$Companion$initTopBar$1(userManager)), companyViewHelper.getShowCompanyPopupState(), ComposableLambdaKt.composableLambdaInstance(-1041944462, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.SimpleScreenConfig$Companion$initTopBar$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i5) {
                    if ((i5 & 3) == 2 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1041944462, i5, -1, "dk.molslinjen.ui.views.global.navigation.SimpleScreenConfig.Companion.initTopBar.<anonymous> (SimpleScreenConfig.kt:119)");
                    }
                    SimpleScreenConfig.INSTANCE.CompanyPopupContent(ICompanyViewHelper.this, userManager, composer, 384);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            })));
        }

        public final void setTopBarProfileButton(TopBarButtonConfiguration topBarButtonConfiguration) {
            Intrinsics.checkNotNullParameter(topBarButtonConfiguration, "<set-?>");
            SimpleScreenConfig.topBarProfileButton = topBarButtonConfiguration;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleScreenConfig(TypedDestinationSpec<?> destination, TopBarConfiguration topBarConfiguration, BottomBarConfiguration bottomBarConfiguration, Function4<? super TypedDestinationSpec<?>, ? super DependenciesContainerBuilder<?>, ? super Composer, ? super Integer, Unit> function4) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(bottomBarConfiguration, "bottomBarConfiguration");
        this.destination = destination;
        this.topBarConfiguration = topBarConfiguration;
        this.bottomBarConfiguration = bottomBarConfiguration;
        this.buildDependencies = function4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BuildDependencies$lambda$0(SimpleScreenConfig simpleScreenConfig, DependenciesContainerBuilder dependenciesContainerBuilder, int i5, Composer composer, int i6) {
        simpleScreenConfig.BuildDependencies(dependenciesContainerBuilder, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final BottomBarConfiguration defaultBottomNavConfig_delegate$lambda$1() {
        BottomBarButtonConfiguration bottomBarButtonConfiguration;
        BottomBarButtonConfiguration bottomBarButtonConfiguration2 = bottomBarDeparturesButton;
        BottomBarButtonConfiguration bottomBarButtonConfiguration3 = null;
        if (bottomBarButtonConfiguration2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBarDeparturesButton");
            bottomBarButtonConfiguration2 = null;
        }
        BottomBarButtonConfiguration bottomBarButtonConfiguration4 = bottomBarTicketsButton;
        if (bottomBarButtonConfiguration4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBarTicketsButton");
            bottomBarButtonConfiguration4 = null;
        }
        if (Feature.MultiRideTickets.isEnabled()) {
            bottomBarButtonConfiguration = bottomBarMultirideAndCommuterButton;
            if (bottomBarButtonConfiguration == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomBarMultirideAndCommuterButton");
            }
            if (Feature.SaleOnboard.isEnabled()) {
                BottomBarButtonConfiguration bottomBarButtonConfiguration5 = bottomBarCateringButton;
                if (bottomBarButtonConfiguration5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomBarCateringButton");
                } else {
                    bottomBarButtonConfiguration3 = bottomBarButtonConfiguration5;
                }
            }
            return new BottomBarConfiguration(true, CollectionsKt.listOfNotNull((Object[]) new BottomBarButtonConfiguration[]{bottomBarButtonConfiguration2, bottomBarButtonConfiguration4, bottomBarButtonConfiguration, bottomBarButtonConfiguration3}));
        }
        bottomBarButtonConfiguration = null;
        if (Feature.SaleOnboard.isEnabled()) {
        }
        return new BottomBarConfiguration(true, CollectionsKt.listOfNotNull((Object[]) new BottomBarButtonConfiguration[]{bottomBarButtonConfiguration2, bottomBarButtonConfiguration4, bottomBarButtonConfiguration, bottomBarButtonConfiguration3}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TopBarConfiguration defaultTopBarConfig_delegate$lambda$2() {
        return new TopBarConfiguration(true, null, new NavigationButton.Custom(new TopBarButtonConfiguration.Basic(R.drawable.icon_toolbar_molslinjen, Integer.valueOf(R.string.accessibilityLabel_emptyOnPurpose), null, 4, null)), CollectionsKt.listOf(TopBarButtonType.Profile));
    }

    public final void BuildDependencies(final DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(dependenciesContainerBuilder, "dependenciesContainerBuilder");
        Composer startRestartGroup = composer.startRestartGroup(-6933059);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(dependenciesContainerBuilder) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(this) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-6933059, i6, -1, "dk.molslinjen.ui.views.global.navigation.SimpleScreenConfig.BuildDependencies (SimpleScreenConfig.kt:60)");
            }
            Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> function4 = this.buildDependencies;
            if (function4 != null) {
                function4.invoke(this.destination, dependenciesContainerBuilder, startRestartGroup, Integer.valueOf((i6 << 3) & 112));
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: R1.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit BuildDependencies$lambda$0;
                    BuildDependencies$lambda$0 = SimpleScreenConfig.BuildDependencies$lambda$0(SimpleScreenConfig.this, dependenciesContainerBuilder, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return BuildDependencies$lambda$0;
                }
            });
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SimpleScreenConfig)) {
            return false;
        }
        SimpleScreenConfig simpleScreenConfig = (SimpleScreenConfig) other;
        return Intrinsics.areEqual(this.destination, simpleScreenConfig.destination) && Intrinsics.areEqual(this.topBarConfiguration, simpleScreenConfig.topBarConfiguration) && Intrinsics.areEqual(this.bottomBarConfiguration, simpleScreenConfig.bottomBarConfiguration) && Intrinsics.areEqual(this.buildDependencies, simpleScreenConfig.buildDependencies);
    }

    public final BottomBarConfiguration getBottomBarConfiguration() {
        return this.bottomBarConfiguration;
    }

    public final TypedDestinationSpec<?> getDestination() {
        return this.destination;
    }

    public final TopBarConfiguration getTopBarConfiguration() {
        return this.topBarConfiguration;
    }

    public int hashCode() {
        int hashCode = this.destination.hashCode() * 31;
        TopBarConfiguration topBarConfiguration = this.topBarConfiguration;
        int hashCode2 = (((hashCode + (topBarConfiguration == null ? 0 : topBarConfiguration.hashCode())) * 31) + this.bottomBarConfiguration.hashCode()) * 31;
        Function4<TypedDestinationSpec<?>, DependenciesContainerBuilder<?>, Composer, Integer, Unit> function4 = this.buildDependencies;
        return hashCode2 + (function4 != null ? function4.hashCode() : 0);
    }

    public String toString() {
        return "SimpleScreenConfig(destination=" + this.destination + ", topBarConfiguration=" + this.topBarConfiguration + ", bottomBarConfiguration=" + this.bottomBarConfiguration + ", buildDependencies=" + this.buildDependencies + ")";
    }
}
