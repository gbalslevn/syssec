package com.sdk.growthbook.features;

import com.sdk.growthbook.GrowthBookSDK;
import com.sdk.growthbook.model.GBFeature;
import com.sdk.growthbook.network.NetworkDispatcher;
import com.sdk.growthbook.utils.FeatureRefreshStrategy;
import com.sdk.growthbook.utils.GBRemoteEvalParams;
import com.sdk.growthbook.utils.Resource;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JP\u0010\u000b\u001a\"\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000ej\u0004\u0018\u0001`\u00110\r0\f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0014\u0010\u0016\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00150\u0013J0\u0010\u0018\u001a\u00020\u00152\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0014\u0010\u0016\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00150\u0013J>\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0018\u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u001c\u0012\u0004\u0012\u00020\u00150\u00132\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00150\u0013J\u0012\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006!"}, d2 = {"Lcom/sdk/growthbook/features/FeaturesDataSource;", BuildConfig.FLAVOR, "dispatcher", "Lcom/sdk/growthbook/network/NetworkDispatcher;", "enableLogging", BuildConfig.FLAVOR, "(Lcom/sdk/growthbook/network/NetworkDispatcher;Z)V", "jsonParser", "Lkotlinx/serialization/json/Json;", "getJsonParser", "()Lkotlinx/serialization/json/Json;", "autoRefresh", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sdk/growthbook/utils/Resource;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/sdk/growthbook/model/GBFeature;", "Lcom/sdk/growthbook/utils/GBFeatures;", "success", "Lkotlin/Function1;", "Lcom/sdk/growthbook/features/FeaturesDataModel;", BuildConfig.FLAVOR, "failure", BuildConfig.FLAVOR, "fetchFeatures", "fetchRemoteEval", "params", "Lcom/sdk/growthbook/utils/GBRemoteEvalParams;", "Lcom/sdk/growthbook/utils/Resource$Success;", "Lcom/sdk/growthbook/utils/Resource$Error;", "getEndpoint", "featureRefreshStrategy", "Lcom/sdk/growthbook/utils/FeatureRefreshStrategy;", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FeaturesDataSource {
    private final NetworkDispatcher dispatcher;
    private final boolean enableLogging;

    public FeaturesDataSource(NetworkDispatcher dispatcher, boolean z5) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        this.enableLogging = z5;
    }

    private final String getEndpoint(FeatureRefreshStrategy featureRefreshStrategy) {
        FeatureURLBuilder featureURLBuilder = new FeatureURLBuilder();
        GrowthBookSDK.Companion companion = GrowthBookSDK.INSTANCE;
        return featureURLBuilder.buildUrl(companion.getGbContext$GrowthBook_release().getHostURL(), companion.getGbContext$GrowthBook_release().getApiKey(), featureRefreshStrategy);
    }

    static /* synthetic */ String getEndpoint$default(FeaturesDataSource featuresDataSource, FeatureRefreshStrategy featureRefreshStrategy, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            featureRefreshStrategy = FeatureRefreshStrategy.STALE_WHILE_REVALIDATE;
        }
        return featuresDataSource.getEndpoint(featureRefreshStrategy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Json getJsonParser() {
        return JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: com.sdk.growthbook.features.FeaturesDataSource$jsonParser$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
                invoke2(jsonBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JsonBuilder Json) {
                Intrinsics.checkNotNullParameter(Json, "$this$Json");
                Json.setPrettyPrint(true);
                Json.setLenient(true);
                Json.setIgnoreUnknownKeys(true);
            }
        }, 1, null);
    }

    public final Flow<Resource<Map<String, GBFeature>>> autoRefresh(Function1<? super FeaturesDataModel, Unit> success, Function1<? super Throwable, Unit> failure) {
        Intrinsics.checkNotNullParameter(success, "success");
        Intrinsics.checkNotNullParameter(failure, "failure");
        return FlowKt.flow(new FeaturesDataSource$autoRefresh$$inlined$transform$1(this.dispatcher.consumeSSEConnection(getEndpoint(FeatureRefreshStrategy.SERVER_SENT_EVENTS)), null, this, success, failure));
    }

    public final void fetchFeatures(final Function1<? super FeaturesDataModel, Unit> success, final Function1<? super Throwable, Unit> failure) {
        Intrinsics.checkNotNullParameter(success, "success");
        Intrinsics.checkNotNullParameter(failure, "failure");
        this.dispatcher.consumeGETRequest(getEndpoint$default(this, null, 1, null), new Function1<String, Unit>() { // from class: com.sdk.growthbook.features.FeaturesDataSource$fetchFeatures$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String rawContent) {
                Json jsonParser;
                Intrinsics.checkNotNullParameter(rawContent, "rawContent");
                jsonParser = FeaturesDataSource.this.getJsonParser();
                success.invoke((FeaturesDataModel) jsonParser.decodeFromString(FeaturesDataModel.INSTANCE.serializer(), rawContent));
            }
        }, new Function1<Throwable, Unit>() { // from class: com.sdk.growthbook.features.FeaturesDataSource$fetchFeatures$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable apiTimeError) {
                Intrinsics.checkNotNullParameter(apiTimeError, "apiTimeError");
                failure.invoke(apiTimeError);
            }
        });
    }

    public final void fetchRemoteEval(GBRemoteEvalParams params, final Function1<? super Resource.Success<FeaturesDataModel>, Unit> success, final Function1<? super Resource.Error, Unit> failure) {
        Intrinsics.checkNotNullParameter(success, "success");
        Intrinsics.checkNotNullParameter(failure, "failure");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (params != null) {
            linkedHashMap.put("attributes", params.getAttributes());
            linkedHashMap.put("forcedFeatures", params.getForcedFeatures());
            linkedHashMap.put("forcedVariations", params.getForcedVariations());
        }
        if (this.enableLogging) {
            System.out.println(linkedHashMap);
        }
        this.dispatcher.consumePOSTRequest(getEndpoint(FeatureRefreshStrategy.SERVER_SENT_REMOTE_FEATURE_EVAL), linkedHashMap, new Function1<String, Unit>() { // from class: com.sdk.growthbook.features.FeaturesDataSource$fetchRemoteEval$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String rawContent) {
                Json jsonParser;
                Intrinsics.checkNotNullParameter(rawContent, "rawContent");
                jsonParser = FeaturesDataSource.this.getJsonParser();
                success.invoke(new Resource.Success<>((FeaturesDataModel) jsonParser.decodeFromString(FeaturesDataModel.INSTANCE.serializer(), rawContent)));
            }
        }, new Function1<Throwable, Unit>() { // from class: com.sdk.growthbook.features.FeaturesDataSource$fetchRemoteEval$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable error) {
                Intrinsics.checkNotNullParameter(error, "error");
                failure.invoke(new Resource.Error(new Exception(error.getMessage())));
            }
        });
    }

    public /* synthetic */ FeaturesDataSource(NetworkDispatcher networkDispatcher, boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(networkDispatcher, (i5 & 2) != 0 ? true : z5);
    }
}
