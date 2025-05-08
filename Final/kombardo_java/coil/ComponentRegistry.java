package coil;

import coil.content.Collections;
import coil.decode.Decoder;
import coil.fetch.Fetcher;
import coil.fetch.SourceResult;
import coil.intercept.Interceptor;
import coil.key.Keyer;
import coil.map.Mapper;
import coil.request.Options;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001)B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B©\u0001\b\u0002\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00120\u0010\u0006\u001a,\u0012(\u0012&\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u00010\b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\t0\u00070\u0004\u0012(\u0010\n\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\t0\u00070\u0004\u0012(\u0010\f\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\r\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\t0\u00070\u0004\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u001eJ8\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0018\u00010\u00072\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020!H\u0007J8\u0010'\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020!\u0018\u00010\u00072\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020!H\u0007R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R3\u0010\f\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\r\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\t0\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R3\u0010\n\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\t0\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R;\u0010\u0006\u001a,\u0012(\u0012&\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u00010\b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\t0\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012¨\u0006*"}, d2 = {"Lcoil/ComponentRegistry;", BuildConfig.FLAVOR, "()V", "interceptors", BuildConfig.FLAVOR, "Lcoil/intercept/Interceptor;", "mappers", "Lkotlin/Pair;", "Lcoil/map/Mapper;", "Ljava/lang/Class;", "keyers", "Lcoil/key/Keyer;", "fetcherFactories", "Lcoil/fetch/Fetcher$Factory;", "decoderFactories", "Lcoil/decode/Decoder$Factory;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getDecoderFactories", "()Ljava/util/List;", "getFetcherFactories", "getInterceptors", "getKeyers", "getMappers", "key", BuildConfig.FLAVOR, "data", "options", "Lcoil/request/Options;", "map", "newBuilder", "Lcoil/ComponentRegistry$Builder;", "newDecoder", "Lcoil/decode/Decoder;", BuildConfig.FLAVOR, "result", "Lcoil/fetch/SourceResult;", "imageLoader", "Lcoil/ImageLoader;", "startIndex", "newFetcher", "Lcoil/fetch/Fetcher;", "Builder", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComponentRegistry {
    private final List<Decoder.Factory> decoderFactories;
    private final List<Pair<Fetcher.Factory<? extends Object>, Class<? extends Object>>> fetcherFactories;
    private final List<Interceptor> interceptors;
    private final List<Pair<Keyer<? extends Object>, Class<? extends Object>>> keyers;
    private final List<Pair<Mapper<? extends Object, ? extends Object>, Class<? extends Object>>> mappers;

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J7\u0010\f\u001a\u00020\u0000\"\b\b\u0000\u0010\u0007*\u00020\u00012\u0010\u0010\t\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0004\b\f\u0010\rJ3\u0010\f\u001a\u00020\u0000\"\b\b\u0000\u0010\u0007*\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0004\b\f\u0010\u0010J3\u0010\f\u001a\u00020\u0000\"\b\b\u0000\u0010\u0007*\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0004\b\f\u0010\u0013J\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0014¢\u0006\u0004\b\f\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR@\u0010\u001f\u001a(\u0012$\u0012\"\u0012\u0010\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0002\b\u00030\b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\n0\u001e0\u00188\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u001dR<\u0010!\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\n0\u001e0\u00188\u0000X\u0080\u0004¢\u0006\f\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001dR<\u0010#\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0011\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\n0\u001e0\u00188\u0000X\u0080\u0004¢\u0006\f\n\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010\u001dR \u0010%\u001a\b\u0012\u0004\u0012\u00020\u00140\u00188\u0000X\u0080\u0004¢\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010\u001d¨\u0006'"}, d2 = {"Lcoil/ComponentRegistry$Builder;", BuildConfig.FLAVOR, "<init>", "()V", "Lcoil/ComponentRegistry;", "registry", "(Lcoil/ComponentRegistry;)V", "T", "Lcoil/map/Mapper;", "mapper", "Ljava/lang/Class;", "type", "add", "(Lcoil/map/Mapper;Ljava/lang/Class;)Lcoil/ComponentRegistry$Builder;", "Lcoil/key/Keyer;", "keyer", "(Lcoil/key/Keyer;Ljava/lang/Class;)Lcoil/ComponentRegistry$Builder;", "Lcoil/fetch/Fetcher$Factory;", "factory", "(Lcoil/fetch/Fetcher$Factory;Ljava/lang/Class;)Lcoil/ComponentRegistry$Builder;", "Lcoil/decode/Decoder$Factory;", "(Lcoil/decode/Decoder$Factory;)Lcoil/ComponentRegistry$Builder;", "build", "()Lcoil/ComponentRegistry;", BuildConfig.FLAVOR, "Lcoil/intercept/Interceptor;", "interceptors", "Ljava/util/List;", "getInterceptors$coil_base_release", "()Ljava/util/List;", "Lkotlin/Pair;", "mappers", "getMappers$coil_base_release", "keyers", "getKeyers$coil_base_release", "fetcherFactories", "getFetcherFactories$coil_base_release", "decoderFactories", "getDecoderFactories$coil_base_release", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Builder {
        private final List<Decoder.Factory> decoderFactories;
        private final List<Pair<Fetcher.Factory<? extends Object>, Class<? extends Object>>> fetcherFactories;
        private final List<Interceptor> interceptors;
        private final List<Pair<Keyer<? extends Object>, Class<? extends Object>>> keyers;
        private final List<Pair<Mapper<? extends Object, ?>, Class<? extends Object>>> mappers;

        public Builder() {
            this.interceptors = new ArrayList();
            this.mappers = new ArrayList();
            this.keyers = new ArrayList();
            this.fetcherFactories = new ArrayList();
            this.decoderFactories = new ArrayList();
        }

        public final <T> Builder add(Mapper<T, ?> mapper, Class<T> type) {
            this.mappers.add(TuplesKt.to(mapper, type));
            return this;
        }

        public final ComponentRegistry build() {
            return new ComponentRegistry(Collections.toImmutableList(this.interceptors), Collections.toImmutableList(this.mappers), Collections.toImmutableList(this.keyers), Collections.toImmutableList(this.fetcherFactories), Collections.toImmutableList(this.decoderFactories), null);
        }

        public final List<Decoder.Factory> getDecoderFactories$coil_base_release() {
            return this.decoderFactories;
        }

        public final List<Pair<Fetcher.Factory<? extends Object>, Class<? extends Object>>> getFetcherFactories$coil_base_release() {
            return this.fetcherFactories;
        }

        public final <T> Builder add(Keyer<T> keyer, Class<T> type) {
            this.keyers.add(TuplesKt.to(keyer, type));
            return this;
        }

        public final <T> Builder add(Fetcher.Factory<T> factory, Class<T> type) {
            this.fetcherFactories.add(TuplesKt.to(factory, type));
            return this;
        }

        public final Builder add(Decoder.Factory factory) {
            this.decoderFactories.add(factory);
            return this;
        }

        public Builder(ComponentRegistry componentRegistry) {
            this.interceptors = CollectionsKt.toMutableList((Collection) componentRegistry.getInterceptors());
            this.mappers = CollectionsKt.toMutableList((Collection) componentRegistry.getMappers());
            this.keyers = CollectionsKt.toMutableList((Collection) componentRegistry.getKeyers());
            this.fetcherFactories = CollectionsKt.toMutableList((Collection) componentRegistry.getFetcherFactories());
            this.decoderFactories = CollectionsKt.toMutableList((Collection) componentRegistry.getDecoderFactories());
        }
    }

    public /* synthetic */ ComponentRegistry(List list, List list2, List list3, List list4, List list5, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, list3, list4, list5);
    }

    public final List<Decoder.Factory> getDecoderFactories() {
        return this.decoderFactories;
    }

    public final List<Pair<Fetcher.Factory<? extends Object>, Class<? extends Object>>> getFetcherFactories() {
        return this.fetcherFactories;
    }

    public final List<Interceptor> getInterceptors() {
        return this.interceptors;
    }

    public final List<Pair<Keyer<? extends Object>, Class<? extends Object>>> getKeyers() {
        return this.keyers;
    }

    public final List<Pair<Mapper<? extends Object, ? extends Object>, Class<? extends Object>>> getMappers() {
        return this.mappers;
    }

    public final String key(Object data, Options options) {
        List<Pair<Keyer<? extends Object>, Class<? extends Object>>> list = this.keyers;
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            Pair<Keyer<? extends Object>, Class<? extends Object>> pair = list.get(i5);
            Keyer<? extends Object> component1 = pair.component1();
            if (pair.component2().isAssignableFrom(data.getClass())) {
                Intrinsics.checkNotNull(component1, "null cannot be cast to non-null type coil.key.Keyer<kotlin.Any>");
                String key = component1.key(data, options);
                if (key != null) {
                    return key;
                }
            }
        }
        return null;
    }

    public final Object map(Object data, Options options) {
        List<Pair<Mapper<? extends Object, ? extends Object>, Class<? extends Object>>> list = this.mappers;
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            Pair<Mapper<? extends Object, ? extends Object>, Class<? extends Object>> pair = list.get(i5);
            Mapper<? extends Object, ? extends Object> component1 = pair.component1();
            if (pair.component2().isAssignableFrom(data.getClass())) {
                Intrinsics.checkNotNull(component1, "null cannot be cast to non-null type coil.map.Mapper<kotlin.Any, *>");
                Object map = component1.map(data, options);
                if (map != null) {
                    data = map;
                }
            }
        }
        return data;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final Pair<Decoder, Integer> newDecoder(SourceResult result, Options options, ImageLoader imageLoader, int startIndex) {
        int size = this.decoderFactories.size();
        while (startIndex < size) {
            Decoder create = this.decoderFactories.get(startIndex).create(result, options, imageLoader);
            if (create != null) {
                return TuplesKt.to(create, Integer.valueOf(startIndex));
            }
            startIndex++;
        }
        return null;
    }

    public final Pair<Fetcher, Integer> newFetcher(Object data, Options options, ImageLoader imageLoader, int startIndex) {
        int size = this.fetcherFactories.size();
        while (startIndex < size) {
            Pair<Fetcher.Factory<? extends Object>, Class<? extends Object>> pair = this.fetcherFactories.get(startIndex);
            Fetcher.Factory<? extends Object> component1 = pair.component1();
            if (pair.component2().isAssignableFrom(data.getClass())) {
                Intrinsics.checkNotNull(component1, "null cannot be cast to non-null type coil.fetch.Fetcher.Factory<kotlin.Any>");
                Fetcher create = component1.create(data, options, imageLoader);
                if (create != null) {
                    return TuplesKt.to(create, Integer.valueOf(startIndex));
                }
            }
            startIndex++;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ComponentRegistry(List<? extends Interceptor> list, List<? extends Pair<? extends Mapper<? extends Object, ? extends Object>, ? extends Class<? extends Object>>> list2, List<? extends Pair<? extends Keyer<? extends Object>, ? extends Class<? extends Object>>> list3, List<? extends Pair<? extends Fetcher.Factory<? extends Object>, ? extends Class<? extends Object>>> list4, List<? extends Decoder.Factory> list5) {
        this.interceptors = list;
        this.mappers = list2;
        this.keyers = list3;
        this.fetcherFactories = list4;
        this.decoderFactories = list5;
    }

    public ComponentRegistry() {
        this(CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }
}
