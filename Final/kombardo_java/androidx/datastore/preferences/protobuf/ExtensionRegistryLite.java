package androidx.datastore.preferences.protobuf;

import android.support.v4.media.session.a;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public class ExtensionRegistryLite {
    static final ExtensionRegistryLite EMPTY_REGISTRY_LITE = new ExtensionRegistryLite(true);
    private static volatile boolean eagerlyParseMessageSets = false;
    private static volatile ExtensionRegistryLite emptyRegistry;
    private final Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> extensionsByNumber = Collections.emptyMap();

    /* loaded from: classes.dex */
    private static final class ObjectIntPair {
        private final int number;
        private final Object object;

        ObjectIntPair(Object obj, int i5) {
            this.object = obj;
            this.number = i5;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ObjectIntPair)) {
                return false;
            }
            ObjectIntPair objectIntPair = (ObjectIntPair) obj;
            return this.object == objectIntPair.object && this.number == objectIntPair.number;
        }

        public int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }
    }

    ExtensionRegistryLite(boolean z5) {
    }

    public static ExtensionRegistryLite getEmptyRegistry() {
        if (Protobuf.assumeLiteRuntime) {
            return EMPTY_REGISTRY_LITE;
        }
        ExtensionRegistryLite extensionRegistryLite = emptyRegistry;
        if (extensionRegistryLite == null) {
            synchronized (ExtensionRegistryLite.class) {
                try {
                    extensionRegistryLite = emptyRegistry;
                    if (extensionRegistryLite == null) {
                        extensionRegistryLite = ExtensionRegistryFactory.createEmpty();
                        emptyRegistry = extensionRegistryLite;
                    }
                } finally {
                }
            }
        }
        return extensionRegistryLite;
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(ContainingType containingtype, int i5) {
        a.a(this.extensionsByNumber.get(new ObjectIntPair(containingtype, i5)));
        return null;
    }
}
