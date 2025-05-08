package com.sdk.growthbook.features;

import com.sdk.growthbook.model.GBFeature;
import com.sdk.growthbook.sandbox.CachingImpl;
import com.sdk.growthbook.sandbox.KMMCachingKt;
import com.sdk.growthbook.utils.Constants;
import com.sdk.growthbook.utils.CryptoKt;
import com.sdk.growthbook.utils.GBError;
import com.sdk.growthbook.utils.GBRemoteEvalParams;
import com.sdk.growthbook.utils.Resource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.serialization.json.JsonObject;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ&\u0010\u000b\u001a\"\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\u0004\u0018\u0001`\u00100\r0\fJ\u001c\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u001a\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J\u0012\u0010\u001c\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/sdk/growthbook/features/FeaturesViewModel;", BuildConfig.FLAVOR, "delegate", "Lcom/sdk/growthbook/features/FeaturesFlowDelegate;", "dataSource", "Lcom/sdk/growthbook/features/FeaturesDataSource;", "encryptionKey", BuildConfig.FLAVOR, "(Lcom/sdk/growthbook/features/FeaturesFlowDelegate;Lcom/sdk/growthbook/features/FeaturesDataSource;Ljava/lang/String;)V", "manager", "Lcom/sdk/growthbook/sandbox/CachingImpl;", "autoRefreshFeatures", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sdk/growthbook/utils/Resource;", BuildConfig.FLAVOR, "Lcom/sdk/growthbook/model/GBFeature;", "Lcom/sdk/growthbook/utils/GBFeatures;", "fetchFeatures", BuildConfig.FLAVOR, "remoteEval", BuildConfig.FLAVOR, "payload", "Lcom/sdk/growthbook/utils/GBRemoteEvalParams;", "getDataFromCache", "Lcom/sdk/growthbook/features/FeaturesDataModel;", "handleFetchFeaturesWithRemoteEval", "handleFetchFeaturesWithoutRemoteEval", "dataModel", "prepareFeaturesDataForRemoteEval", "putDataToCache", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FeaturesViewModel {
    private final FeaturesDataSource dataSource;
    private final FeaturesFlowDelegate delegate;
    private final String encryptionKey;
    private final CachingImpl manager;

    public FeaturesViewModel(FeaturesFlowDelegate delegate, FeaturesDataSource dataSource, String str) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.delegate = delegate;
        this.dataSource = dataSource;
        this.encryptionKey = str;
        this.manager = CachingImpl.INSTANCE;
    }

    public static /* synthetic */ void fetchFeatures$default(FeaturesViewModel featuresViewModel, boolean z5, GBRemoteEvalParams gBRemoteEvalParams, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = false;
        }
        if ((i5 & 2) != 0) {
            gBRemoteEvalParams = null;
        }
        featuresViewModel.fetchFeatures(z5, gBRemoteEvalParams);
    }

    private final FeaturesDataModel getDataFromCache() {
        return (FeaturesDataModel) KMMCachingKt.getData(this.manager.getLayer(), Constants.FEATURE_CACHE, FeaturesDataModel.INSTANCE.serializer());
    }

    private final void handleFetchFeaturesWithRemoteEval(boolean remoteEval, GBRemoteEvalParams payload) {
        if (remoteEval) {
            this.dataSource.fetchRemoteEval(payload, new Function1<Resource.Success<? extends FeaturesDataModel>, Unit>() { // from class: com.sdk.growthbook.features.FeaturesViewModel$handleFetchFeaturesWithRemoteEval$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Resource.Success<? extends FeaturesDataModel> success) {
                    invoke2((Resource.Success<FeaturesDataModel>) success);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Resource.Success<FeaturesDataModel> responseFeaturesDataModel) {
                    Intrinsics.checkNotNullParameter(responseFeaturesDataModel, "responseFeaturesDataModel");
                    FeaturesViewModel.this.prepareFeaturesDataForRemoteEval(responseFeaturesDataModel.getData());
                }
            }, new Function1<Resource.Error, Unit>() { // from class: com.sdk.growthbook.features.FeaturesViewModel$handleFetchFeaturesWithRemoteEval$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Resource.Error error) {
                    invoke2(error);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Resource.Error error) {
                    FeaturesFlowDelegate featuresFlowDelegate;
                    Intrinsics.checkNotNullParameter(error, "error");
                    featuresFlowDelegate = FeaturesViewModel.this.delegate;
                    featuresFlowDelegate.featuresFetchFailed(new GBError(error.getException()), true);
                }
            });
        } else {
            this.dataSource.fetchFeatures(new Function1<FeaturesDataModel, Unit>() { // from class: com.sdk.growthbook.features.FeaturesViewModel$handleFetchFeaturesWithRemoteEval$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FeaturesDataModel featuresDataModel) {
                    invoke2(featuresDataModel);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(FeaturesDataModel dataModel) {
                    Intrinsics.checkNotNullParameter(dataModel, "dataModel");
                    FeaturesViewModel.this.prepareFeaturesDataForRemoteEval(dataModel);
                }
            }, new Function1<Throwable, Unit>() { // from class: com.sdk.growthbook.features.FeaturesViewModel$handleFetchFeaturesWithRemoteEval$4
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    FeaturesFlowDelegate featuresFlowDelegate;
                    featuresFlowDelegate = FeaturesViewModel.this.delegate;
                    featuresFlowDelegate.featuresFetchFailed(new GBError(th), true);
                }
            });
        }
    }

    private final void handleFetchFeaturesWithoutRemoteEval(FeaturesDataModel dataModel) {
        String str;
        Map<String, GBFeature> featuresFromEncryptedFeatures$default;
        Map<String, GBFeature> features = dataModel.getFeatures();
        if (features != null) {
            this.delegate.featuresFetchedSuccessfully(features, false);
        }
        String encryptedFeatures = dataModel.getEncryptedFeatures();
        if (encryptedFeatures == null || (str = this.encryptionKey) == null || (featuresFromEncryptedFeatures$default = CryptoKt.getFeaturesFromEncryptedFeatures$default(encryptedFeatures, str, null, 4, null)) == null) {
            return;
        }
        this.delegate.featuresFetchedSuccessfully(featuresFromEncryptedFeatures$default, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003e, code lost:
    
        r7 = r6.encryptionKey;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0040, code lost:
    
        if (r7 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0046, code lost:
    
        if (r7.length() <= 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0048, code lost:
    
        r7 = com.sdk.growthbook.utils.CryptoKt.getFeaturesFromEncryptedFeatures(r3, r6.encryptionKey, new com.sdk.growthbook.utils.DefaultCrypto());
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0053, code lost:
    
        if (r7 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0055, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0056, code lost:
    
        r6.delegate.featuresFetchedSuccessfully(r7, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005c, code lost:
    
        if (r1 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005e, code lost:
    
        r6.delegate.featuresFetchedSuccessfully(r1, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0063, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0064, code lost:
    
        if (r2 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006a, code lost:
    
        if (r2.isEmpty() == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006d, code lost:
    
        r6.delegate.savedGroupsFetchedSuccessfully(r2, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0073, code lost:
    
        if (r0 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0075, code lost:
    
        r7 = r6.encryptionKey;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0077, code lost:
    
        if (r7 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007d, code lost:
    
        if (r7.length() <= 0) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007f, code lost:
    
        r7 = com.sdk.growthbook.utils.CryptoKt.getSavedGroupFromEncryptedSavedGroup(r0, r6.encryptionKey, new com.sdk.growthbook.utils.DefaultCrypto());
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x008a, code lost:
    
        if (r7 != null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x008c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x008d, code lost:
    
        r6.delegate.savedGroupsFetchedSuccessfully(r7, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0092, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0093, code lost:
    
        if (r2 == null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0095, code lost:
    
        r6.delegate.savedGroupsFetchedSuccessfully(r2, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x009a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x009b, code lost:
    
        r6.delegate.savedGroupsFetchFailed(new com.sdk.growthbook.utils.GBError(new java.lang.Exception()), true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00aa, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void prepareFeaturesDataForRemoteEval(FeaturesDataModel dataModel) {
        Map<String, GBFeature> features = dataModel != null ? dataModel.getFeatures() : null;
        JsonObject savedGroups = dataModel != null ? dataModel.getSavedGroups() : null;
        String encryptedFeatures = dataModel != null ? dataModel.getEncryptedFeatures() : null;
        String encryptedSavedGroups = dataModel != null ? dataModel.getEncryptedSavedGroups() : null;
        if (dataModel != null) {
            try {
                putDataToCache(dataModel);
                this.delegate.featuresAPIModelSuccessfully(dataModel);
                if (features != null && !features.isEmpty()) {
                    this.delegate.featuresFetchedSuccessfully(features, true);
                    return;
                }
                this.delegate.featuresFetchFailed(new GBError(new Exception()), true);
            } catch (Throwable th) {
                this.delegate.featuresFetchFailed(new GBError(th), true);
            }
        }
    }

    private final void putDataToCache(FeaturesDataModel dataModel) {
        KMMCachingKt.putData(this.manager.getLayer(), Constants.FEATURE_CACHE, dataModel, FeaturesDataModel.INSTANCE.serializer());
    }

    public final Flow<Resource<Map<String, GBFeature>>> autoRefreshFeatures() {
        return this.dataSource.autoRefresh(new Function1<FeaturesDataModel, Unit>() { // from class: com.sdk.growthbook.features.FeaturesViewModel$autoRefreshFeatures$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FeaturesDataModel featuresDataModel) {
                invoke2(featuresDataModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FeaturesDataModel dataModel) {
                Intrinsics.checkNotNullParameter(dataModel, "dataModel");
                FeaturesViewModel.this.prepareFeaturesDataForRemoteEval(dataModel);
            }
        }, new Function1<Throwable, Unit>() { // from class: com.sdk.growthbook.features.FeaturesViewModel$autoRefreshFeatures$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                FeaturesFlowDelegate featuresFlowDelegate;
                featuresFlowDelegate = FeaturesViewModel.this.delegate;
                featuresFlowDelegate.featuresFetchFailed(new GBError(th), true);
            }
        });
    }

    public final void fetchFeatures(boolean remoteEval, GBRemoteEvalParams payload) {
        try {
            FeaturesDataModel dataFromCache = getDataFromCache();
            if (dataFromCache != null) {
                handleFetchFeaturesWithoutRemoteEval(dataFromCache);
            }
        } catch (Throwable th) {
            this.delegate.featuresFetchFailed(new GBError(th), false);
        }
        handleFetchFeaturesWithRemoteEval(remoteEval, payload);
    }

    public /* synthetic */ FeaturesViewModel(FeaturesFlowDelegate featuresFlowDelegate, FeaturesDataSource featuresDataSource, String str, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(featuresFlowDelegate, featuresDataSource, (i5 & 4) != 0 ? null : str);
    }
}
