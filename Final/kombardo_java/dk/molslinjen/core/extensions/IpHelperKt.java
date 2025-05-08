package dk.molslinjen.core.extensions;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\b\u0010\u0000\u001a\u0004\u0018\u00010\u0001¨\u0006\u0002"}, d2 = {"getIpAddress", BuildConfig.FLAVOR, "core_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class IpHelperKt {
    public static final String getIpAddress() {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress nextElement = inetAddresses.nextElement();
                if (!nextElement.isLoopbackAddress() && nextElement.isSiteLocalAddress() && (nextElement instanceof Inet4Address)) {
                    return ((Inet4Address) nextElement).getHostAddress();
                }
            }
        }
        return null;
    }
}
