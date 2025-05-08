package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ConnectionSpec;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\rH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/connection/ConnectionSpecSelector;", BuildConfig.FLAVOR, "connectionSpecs", BuildConfig.FLAVOR, "Lokhttp3/ConnectionSpec;", "(Ljava/util/List;)V", "isFallback", BuildConfig.FLAVOR, "isFallbackPossible", "nextModeIndex", BuildConfig.FLAVOR, "configureSecureSocket", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "connectionFailed", "e", "Ljava/io/IOException;", "socket", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ConnectionSpecSelector {
    private final List<ConnectionSpec> connectionSpecs;
    private boolean isFallback;
    private boolean isFallbackPossible;
    private int nextModeIndex;

    public ConnectionSpecSelector(List<ConnectionSpec> connectionSpecs) {
        Intrinsics.checkNotNullParameter(connectionSpecs, "connectionSpecs");
        this.connectionSpecs = connectionSpecs;
    }

    private final boolean isFallbackPossible(SSLSocket socket) {
        int i5 = this.nextModeIndex;
        int size = this.connectionSpecs.size();
        while (i5 < size) {
            int i6 = i5 + 1;
            if (this.connectionSpecs.get(i5).isCompatible(socket)) {
                return true;
            }
            i5 = i6;
        }
        return false;
    }

    public final ConnectionSpec configureSecureSocket(SSLSocket sslSocket) {
        ConnectionSpec connectionSpec;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        int i5 = this.nextModeIndex;
        int size = this.connectionSpecs.size();
        while (true) {
            if (i5 >= size) {
                connectionSpec = null;
                break;
            }
            int i6 = i5 + 1;
            connectionSpec = this.connectionSpecs.get(i5);
            if (connectionSpec.isCompatible(sslSocket)) {
                this.nextModeIndex = i6;
                break;
            }
            i5 = i6;
        }
        if (connectionSpec != null) {
            this.isFallbackPossible = isFallbackPossible(sslSocket);
            connectionSpec.apply$okhttp(sslSocket, this.isFallback);
            return connectionSpec;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to find acceptable protocols. isFallback=");
        sb.append(this.isFallback);
        sb.append(", modes=");
        sb.append(this.connectionSpecs);
        sb.append(", supported protocols=");
        String[] enabledProtocols = sslSocket.getEnabledProtocols();
        Intrinsics.checkNotNull(enabledProtocols);
        String arrays = Arrays.toString(enabledProtocols);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        sb.append(arrays);
        throw new UnknownServiceException(sb.toString());
    }

    public final boolean connectionFailed(IOException e5) {
        Intrinsics.checkNotNullParameter(e5, "e");
        this.isFallback = true;
        return (!this.isFallbackPossible || (e5 instanceof ProtocolException) || (e5 instanceof InterruptedIOException) || ((e5 instanceof SSLHandshakeException) && (e5.getCause() instanceof CertificateException)) || (e5 instanceof SSLPeerUnverifiedException) || !(e5 instanceof SSLException)) ? false : true;
    }
}
