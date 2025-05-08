package com.ramcosta.composedestinations.generated.destinations;

import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NamedNavArgumentKt;
import androidx.navigation.NavArgumentBuilder;
import androidx.navigation.NavDeepLink;
import com.ramcosta.composedestinations.bottomsheet.spec.DestinationStyleBottomSheet;
import com.ramcosta.composedestinations.generated.destinations.FaqSubjectScreenDestination;
import com.ramcosta.composedestinations.navargs.primitives.DestinationsStringNavType;
import com.ramcosta.composedestinations.navargs.primitives.DestinationsStringNavTypeKt;
import com.ramcosta.composedestinations.navigation.DestinationDependenciesContainerImpl;
import com.ramcosta.composedestinations.scope.DestinationScope;
import com.ramcosta.composedestinations.spec.BaseRoute;
import com.ramcosta.composedestinations.spec.DestinationStyle;
import com.ramcosta.composedestinations.spec.Direction;
import com.ramcosta.composedestinations.spec.DirectionKt;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import dk.molslinjen.domain.model.faq.FaqQuestionId;
import dk.molslinjen.domain.model.faq.FaqSubjectId;
import dk.molslinjen.ui.views.screens.profile.faq.subject.FaqSubjectScreenKt;
import dk.molslinjen.ui.views.screens.profile.faq.subject.FaqSubjectScreenNavArgs;
import dk.molslinjen.ui.views.screens.profile.faq.subject.FaqSubjectViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0096\u0002J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0086\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u001e\u001a\u00020\u001f*\b\u0012\u0004\u0012\u00020\u00030 H\u0017¢\u0006\u0002\u0010!J\u0012\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&H\u0016J\t\u0010'\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u000f\u001a\u00020\u0010X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006("}, d2 = {"Lcom/ramcosta/composedestinations/generated/destinations/FaqSubjectScreenDestination;", "Lcom/ramcosta/composedestinations/spec/BaseRoute;", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Ldk/molslinjen/ui/views/screens/profile/faq/subject/FaqSubjectScreenNavArgs;", "<init>", "()V", "invoke", "Lcom/ramcosta/composedestinations/spec/Direction;", "navArgs", "subjectId", "Ldk/molslinjen/domain/model/faq/FaqSubjectId;", "questionId", "Ldk/molslinjen/domain/model/faq/FaqQuestionId;", "invoke-3g9fzqg", "(Ljava/lang/String;Ljava/lang/String;)Lcom/ramcosta/composedestinations/spec/Direction;", "baseRoute", BuildConfig.FLAVOR, "getBaseRoute", "()Ljava/lang/String;", "route", "getRoute", "arguments", BuildConfig.FLAVOR, "Landroidx/navigation/NamedNavArgument;", "getArguments", "()Ljava/util/List;", "style", "Lcom/ramcosta/composedestinations/spec/DestinationStyle;", "getStyle", "()Lcom/ramcosta/composedestinations/spec/DestinationStyle;", "Content", BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/scope/DestinationScope;", "(Lcom/ramcosta/composedestinations/scope/DestinationScope;Landroidx/compose/runtime/Composer;I)V", "argsFrom", "bundle", "Landroid/os/Bundle;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class FaqSubjectScreenDestination extends BaseRoute implements TypedDestinationSpec<FaqSubjectScreenNavArgs> {
    public static final int $stable;
    public static final FaqSubjectScreenDestination INSTANCE;
    private static final String baseRoute;
    private static final String route;
    private static final DestinationStyle style;

    static {
        FaqSubjectScreenDestination faqSubjectScreenDestination = new FaqSubjectScreenDestination();
        INSTANCE = faqSubjectScreenDestination;
        baseRoute = "faq_subject_screen";
        route = faqSubjectScreenDestination.getBaseRoute() + "/{subjectId}?questionId={questionId}";
        style = DestinationStyleBottomSheet.INSTANCE;
        $stable = DestinationStyle.$stable;
    }

    private FaqSubjectScreenDestination() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$1(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(DestinationsStringNavTypeKt.getStringNavType());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_arguments_$lambda$2(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(DestinationsStringNavTypeKt.getStringNavType());
        navArgument.setNullable(true);
        return Unit.INSTANCE;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec
    public void Content(DestinationScope<FaqSubjectScreenNavArgs> destinationScope, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(destinationScope, "<this>");
        composer.startReplaceGroup(-413753585);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-413753585, i5, -1, "com.ramcosta.composedestinations.generated.destinations.FaqSubjectScreenDestination.Content (FaqSubjectScreenDestination.kt:60)");
        }
        FaqSubjectScreenKt.FaqSubjectScreen((FaqSubjectViewModel) ((DestinationDependenciesContainerImpl) destinationScope.buildDependencies(composer, i5 & 14)).require(Reflection.getOrCreateKotlinClass(FaqSubjectViewModel.class), false), destinationScope.getDestinationsNavigator(), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public List<NamedNavArgument> getArguments() {
        return CollectionsKt.listOf((Object[]) new NamedNavArgument[]{NamedNavArgumentKt.navArgument("subjectId", new Function1() { // from class: f1.N
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$1;
                _get_arguments_$lambda$1 = FaqSubjectScreenDestination._get_arguments_$lambda$1((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$1;
            }
        }), NamedNavArgumentKt.navArgument("questionId", new Function1() { // from class: f1.O
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_arguments_$lambda$2;
                _get_arguments_$lambda$2 = FaqSubjectScreenDestination._get_arguments_$lambda$2((NavArgumentBuilder) obj);
                return _get_arguments_$lambda$2;
            }
        })});
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public String getBaseRoute() {
        return baseRoute;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public List<NavDeepLink> getDeepLinks() {
        return TypedDestinationSpec.DefaultImpls.getDeepLinks(this);
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute, com.ramcosta.composedestinations.spec.RouteOrDirection
    public String getRoute() {
        return route;
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec
    public DestinationStyle getStyle() {
        return style;
    }

    /* renamed from: invoke-3g9fzqg, reason: not valid java name */
    public final Direction m3069invoke3g9fzqg(String subjectId, String questionId) {
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        String baseRoute2 = getBaseRoute();
        String serializeValue = DestinationsStringNavTypeKt.getStringNavType().serializeValue("subjectId", subjectId);
        DestinationsStringNavType stringNavType = DestinationsStringNavTypeKt.getStringNavType();
        if (questionId == null) {
            questionId = null;
        }
        return DirectionKt.Direction(baseRoute2 + "/" + serializeValue + "?questionId=" + stringNavType.serializeValue("questionId", questionId));
    }

    public String toString() {
        return "FaqSubjectScreenDestination";
    }

    @Override // com.ramcosta.composedestinations.spec.TypedRoute
    public Direction invoke(FaqSubjectScreenNavArgs navArgs) {
        Intrinsics.checkNotNullParameter(navArgs, "navArgs");
        return INSTANCE.m3069invoke3g9fzqg(navArgs.getSubjectId(), navArgs.getQuestionId());
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public FaqSubjectScreenNavArgs argsFrom(Bundle bundle) {
        String safeGet = DestinationsStringNavTypeKt.getStringNavType().safeGet(bundle, "subjectId");
        if (safeGet != null) {
            String m3241constructorimpl = FaqSubjectId.m3241constructorimpl(safeGet);
            String safeGet2 = DestinationsStringNavTypeKt.getStringNavType().safeGet(bundle, "questionId");
            return new FaqSubjectScreenNavArgs(m3241constructorimpl, safeGet2 != null ? FaqQuestionId.m3230constructorimpl(safeGet2) : null, null);
        }
        throw new RuntimeException("'subjectId' argument is mandatory, but was not present!");
    }

    @Override // com.ramcosta.composedestinations.spec.TypedDestinationSpec, com.ramcosta.composedestinations.spec.TypedRoute
    public FaqSubjectScreenNavArgs argsFrom(SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        String str = DestinationsStringNavTypeKt.getStringNavType().get(savedStateHandle, "subjectId");
        if (str != null) {
            String m3241constructorimpl = FaqSubjectId.m3241constructorimpl(str);
            String str2 = DestinationsStringNavTypeKt.getStringNavType().get(savedStateHandle, "questionId");
            return new FaqSubjectScreenNavArgs(m3241constructorimpl, str2 != null ? FaqQuestionId.m3230constructorimpl(str2) : null, null);
        }
        throw new RuntimeException("'subjectId' argument is mandatory, but was not present!");
    }
}
