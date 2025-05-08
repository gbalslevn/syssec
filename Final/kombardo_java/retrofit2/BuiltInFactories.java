package retrofit2;

import android.annotation.TargetApi;
import androidx.appcompat.R$styleable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import retrofit2.CallAdapter;
import retrofit2.Converter;

/* loaded from: classes3.dex */
class BuiltInFactories {

    @TargetApi(R$styleable.Toolbar_titleMarginEnd)
    /* loaded from: classes3.dex */
    static final class Java8 extends BuiltInFactories {
        @Override // retrofit2.BuiltInFactories
        List<? extends CallAdapter.Factory> createDefaultCallAdapterFactories(Executor executor) {
            return Arrays.asList(new CompletableFutureCallAdapterFactory(), new DefaultCallAdapterFactory(executor));
        }

        @Override // retrofit2.BuiltInFactories
        List<? extends Converter.Factory> createDefaultConverterFactories() {
            return Collections.singletonList(new OptionalConverterFactory());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<? extends CallAdapter.Factory> createDefaultCallAdapterFactories(Executor executor) {
        return Collections.singletonList(new DefaultCallAdapterFactory(executor));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<? extends Converter.Factory> createDefaultConverterFactories() {
        return Collections.emptyList();
    }
}
