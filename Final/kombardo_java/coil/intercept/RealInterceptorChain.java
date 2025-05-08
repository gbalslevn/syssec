package coil.intercept;

import coil.EventListener;
import coil.intercept.Interceptor;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.request.NullRequestData;
import coil.size.Size;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010\t\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b$\u0010\u001dR\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010+\u001a\u0004\b\u000f\u0010,\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Lcoil/intercept/RealInterceptorChain;", "Lcoil/intercept/Interceptor$Chain;", "Lcoil/request/ImageRequest;", "initialRequest", BuildConfig.FLAVOR, "Lcoil/intercept/Interceptor;", "interceptors", BuildConfig.FLAVOR, "index", "request", "Lcoil/size/Size;", "size", "Lcoil/EventListener;", "eventListener", BuildConfig.FLAVOR, "isPlaceholderCached", "<init>", "(Lcoil/request/ImageRequest;Ljava/util/List;ILcoil/request/ImageRequest;Lcoil/size/Size;Lcoil/EventListener;Z)V", "interceptor", BuildConfig.FLAVOR, "checkRequest", "(Lcoil/request/ImageRequest;Lcoil/intercept/Interceptor;)V", "copy", "(ILcoil/request/ImageRequest;Lcoil/size/Size;)Lcoil/intercept/RealInterceptorChain;", "Lcoil/request/ImageResult;", "proceed", "(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcoil/request/ImageRequest;", "getInitialRequest", "()Lcoil/request/ImageRequest;", "Ljava/util/List;", "getInterceptors", "()Ljava/util/List;", "I", "getIndex", "()I", "getRequest", "Lcoil/size/Size;", "getSize", "()Lcoil/size/Size;", "Lcoil/EventListener;", "getEventListener", "()Lcoil/EventListener;", "Z", "()Z", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RealInterceptorChain implements Interceptor.Chain {
    private final EventListener eventListener;
    private final int index;
    private final ImageRequest initialRequest;
    private final List<Interceptor> interceptors;
    private final boolean isPlaceholderCached;
    private final ImageRequest request;
    private final Size size;

    /* JADX WARN: Multi-variable type inference failed */
    public RealInterceptorChain(ImageRequest imageRequest, List<? extends Interceptor> list, int i5, ImageRequest imageRequest2, Size size, EventListener eventListener, boolean z5) {
        this.initialRequest = imageRequest;
        this.interceptors = list;
        this.index = i5;
        this.request = imageRequest2;
        this.size = size;
        this.eventListener = eventListener;
        this.isPlaceholderCached = z5;
    }

    private final void checkRequest(ImageRequest request, Interceptor interceptor) {
        if (request.getContext() != this.initialRequest.getContext()) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's context.").toString());
        }
        if (request.getData() == NullRequestData.INSTANCE) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot set the request's data to null.").toString());
        }
        if (request.getTarget() != this.initialRequest.getTarget()) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's target.").toString());
        }
        if (request.getLifecycle() != this.initialRequest.getLifecycle()) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's lifecycle.").toString());
        }
        if (request.getSizeResolver() == this.initialRequest.getSizeResolver()) {
            return;
        }
        throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's size resolver. Use `Interceptor.Chain.withSize` instead.").toString());
    }

    private final RealInterceptorChain copy(int index, ImageRequest request, Size size) {
        return new RealInterceptorChain(this.initialRequest, this.interceptors, index, request, size, this.eventListener, this.isPlaceholderCached);
    }

    static /* synthetic */ RealInterceptorChain copy$default(RealInterceptorChain realInterceptorChain, int i5, ImageRequest imageRequest, Size size, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = realInterceptorChain.index;
        }
        if ((i6 & 2) != 0) {
            imageRequest = realInterceptorChain.getRequest();
        }
        if ((i6 & 4) != 0) {
            size = realInterceptorChain.getSize();
        }
        return realInterceptorChain.copy(i5, imageRequest, size);
    }

    public final EventListener getEventListener() {
        return this.eventListener;
    }

    @Override // coil.intercept.Interceptor.Chain
    public ImageRequest getRequest() {
        return this.request;
    }

    @Override // coil.intercept.Interceptor.Chain
    public Size getSize() {
        return this.size;
    }

    /* renamed from: isPlaceholderCached, reason: from getter */
    public final boolean getIsPlaceholderCached() {
        return this.isPlaceholderCached;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object proceed(ImageRequest imageRequest, Continuation<? super ImageResult> continuation) {
        RealInterceptorChain$proceed$1 realInterceptorChain$proceed$1;
        int i5;
        RealInterceptorChain realInterceptorChain;
        Interceptor interceptor;
        if (continuation instanceof RealInterceptorChain$proceed$1) {
            realInterceptorChain$proceed$1 = (RealInterceptorChain$proceed$1) continuation;
            int i6 = realInterceptorChain$proceed$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                realInterceptorChain$proceed$1.label = i6 - Integer.MIN_VALUE;
                Object obj = realInterceptorChain$proceed$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = realInterceptorChain$proceed$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    int i7 = this.index;
                    if (i7 > 0) {
                        checkRequest(imageRequest, this.interceptors.get(i7 - 1));
                    }
                    Interceptor interceptor2 = this.interceptors.get(this.index);
                    RealInterceptorChain copy$default = copy$default(this, this.index + 1, imageRequest, null, 4, null);
                    realInterceptorChain$proceed$1.L$0 = this;
                    realInterceptorChain$proceed$1.L$1 = interceptor2;
                    realInterceptorChain$proceed$1.label = 1;
                    Object intercept = interceptor2.intercept(copy$default, realInterceptorChain$proceed$1);
                    if (intercept == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    realInterceptorChain = this;
                    obj = intercept;
                    interceptor = interceptor2;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    interceptor = (Interceptor) realInterceptorChain$proceed$1.L$1;
                    realInterceptorChain = (RealInterceptorChain) realInterceptorChain$proceed$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                ImageResult imageResult = (ImageResult) obj;
                realInterceptorChain.checkRequest(imageResult.getRequest(), interceptor);
                return imageResult;
            }
        }
        realInterceptorChain$proceed$1 = new RealInterceptorChain$proceed$1(this, continuation);
        Object obj2 = realInterceptorChain$proceed$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = realInterceptorChain$proceed$1.label;
        if (i5 != 0) {
        }
        ImageResult imageResult2 = (ImageResult) obj2;
        realInterceptorChain.checkRequest(imageResult2.getRequest(), interceptor);
        return imageResult2;
    }
}
