package com.google.firebase.perf.config;

import android.content.Context;
import com.google.firebase.perf.BuildConfig;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.ImmutableBundle;
import com.google.firebase.perf.util.Optional;
import com.google.firebase.perf.util.Utils;

/* loaded from: classes2.dex */
public class ConfigResolver {
    private static volatile ConfigResolver instance;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private DeviceCacheManager deviceCacheManager;
    private ImmutableBundle metadataBundle;
    private final RemoteConfigManager remoteConfigManager;

    public ConfigResolver(RemoteConfigManager remoteConfigManager, ImmutableBundle immutableBundle, DeviceCacheManager deviceCacheManager) {
        this.remoteConfigManager = remoteConfigManager == null ? RemoteConfigManager.getInstance() : remoteConfigManager;
        this.metadataBundle = immutableBundle == null ? new ImmutableBundle() : immutableBundle;
        this.deviceCacheManager = deviceCacheManager == null ? DeviceCacheManager.getInstance() : deviceCacheManager;
    }

    private Optional<Boolean> getDeviceCacheBoolean(ConfigurationFlag<Boolean> configurationFlag) {
        return this.deviceCacheManager.getBoolean(configurationFlag.getDeviceCacheFlag());
    }

    private Optional<Double> getDeviceCacheDouble(ConfigurationFlag<Double> configurationFlag) {
        return this.deviceCacheManager.getDouble(configurationFlag.getDeviceCacheFlag());
    }

    private Optional<Long> getDeviceCacheLong(ConfigurationFlag<Long> configurationFlag) {
        return this.deviceCacheManager.getLong(configurationFlag.getDeviceCacheFlag());
    }

    private Optional<String> getDeviceCacheString(ConfigurationFlag<String> configurationFlag) {
        return this.deviceCacheManager.getString(configurationFlag.getDeviceCacheFlag());
    }

    public static synchronized ConfigResolver getInstance() {
        ConfigResolver configResolver;
        synchronized (ConfigResolver.class) {
            try {
                if (instance == null) {
                    instance = new ConfigResolver(null, null, null);
                }
                configResolver = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return configResolver;
    }

    private boolean getIsSdkEnabled() {
        ConfigurationConstants$SdkEnabled configurationConstants$SdkEnabled = ConfigurationConstants$SdkEnabled.getInstance();
        Optional<Boolean> deviceCacheBoolean = getDeviceCacheBoolean(configurationConstants$SdkEnabled);
        Optional<Boolean> remoteConfigBoolean = getRemoteConfigBoolean(configurationConstants$SdkEnabled);
        if (!remoteConfigBoolean.isAvailable()) {
            return deviceCacheBoolean.isAvailable() ? deviceCacheBoolean.get().booleanValue() : configurationConstants$SdkEnabled.getDefault().booleanValue();
        }
        if (this.remoteConfigManager.isLastFetchFailed()) {
            return false;
        }
        Boolean bool = remoteConfigBoolean.get();
        if (deviceCacheBoolean == null || !deviceCacheBoolean.isAvailable() || deviceCacheBoolean.get() != bool) {
            this.deviceCacheManager.setValue(configurationConstants$SdkEnabled.getDeviceCacheFlag(), bool.booleanValue());
        }
        return bool.booleanValue();
    }

    private boolean getIsSdkVersionDisabled() {
        ConfigurationConstants$SdkDisabledVersions configurationConstants$SdkDisabledVersions = ConfigurationConstants$SdkDisabledVersions.getInstance();
        Optional<String> deviceCacheString = getDeviceCacheString(configurationConstants$SdkDisabledVersions);
        Optional<String> remoteConfigString = getRemoteConfigString(configurationConstants$SdkDisabledVersions);
        if (!remoteConfigString.isAvailable()) {
            return deviceCacheString.isAvailable() ? isFireperfSdkVersionInList(deviceCacheString.get()) : isFireperfSdkVersionInList(configurationConstants$SdkDisabledVersions.getDefault());
        }
        String str = remoteConfigString.get();
        if (deviceCacheString == null || !deviceCacheString.isAvailable() || !deviceCacheString.get().equals(str)) {
            this.deviceCacheManager.setValue(configurationConstants$SdkDisabledVersions.getDeviceCacheFlag(), str);
        }
        return isFireperfSdkVersionInList(str);
    }

    private Optional<Boolean> getMetadataBoolean(ConfigurationFlag<Boolean> configurationFlag) {
        return this.metadataBundle.getBoolean(configurationFlag.getMetadataFlag());
    }

    private Optional<Double> getMetadataDouble(ConfigurationFlag<Double> configurationFlag) {
        return this.metadataBundle.getDouble(configurationFlag.getMetadataFlag());
    }

    private Optional<Long> getMetadataLong(ConfigurationFlag<Long> configurationFlag) {
        return this.metadataBundle.getLong(configurationFlag.getMetadataFlag());
    }

    private Optional<Boolean> getRemoteConfigBoolean(ConfigurationFlag<Boolean> configurationFlag) {
        return this.remoteConfigManager.getBoolean(configurationFlag.getRemoteConfigFlag());
    }

    private Optional<Double> getRemoteConfigDouble(ConfigurationFlag<Double> configurationFlag) {
        return this.remoteConfigManager.getDouble(configurationFlag.getRemoteConfigFlag());
    }

    private Optional<Long> getRemoteConfigLong(ConfigurationFlag<Long> configurationFlag) {
        return this.remoteConfigManager.getLong(configurationFlag.getRemoteConfigFlag());
    }

    private Optional<String> getRemoteConfigString(ConfigurationFlag<String> configurationFlag) {
        return this.remoteConfigManager.getString(configurationFlag.getRemoteConfigFlag());
    }

    private boolean isEventCountValid(long j5) {
        return j5 >= 0;
    }

    private boolean isFireperfSdkVersionInList(String str) {
        if (str.trim().isEmpty()) {
            return false;
        }
        for (String str2 : str.split(";")) {
            if (str2.trim().equals(BuildConfig.FIREPERF_VERSION_NAME)) {
                return true;
            }
        }
        return false;
    }

    private boolean isGaugeCaptureFrequencyMsValid(long j5) {
        return j5 >= 0;
    }

    private boolean isSamplingRateValid(double d5) {
        return 0.0d <= d5 && d5 <= 1.0d;
    }

    private boolean isSessionsMaxDurationMinutesValid(long j5) {
        return j5 > 0;
    }

    private boolean isTimeRangeSecValid(long j5) {
        return j5 > 0;
    }

    public String getAndCacheLogSourceName() {
        String logSourceName;
        ConfigurationConstants$LogSourceName configurationConstants$LogSourceName = ConfigurationConstants$LogSourceName.getInstance();
        if (BuildConfig.ENFORCE_DEFAULT_LOG_SRC.booleanValue()) {
            return configurationConstants$LogSourceName.getDefault();
        }
        String remoteConfigFlag = configurationConstants$LogSourceName.getRemoteConfigFlag();
        long longValue = remoteConfigFlag != null ? ((Long) this.remoteConfigManager.getRemoteConfigValueOrDefault(remoteConfigFlag, -1L)).longValue() : -1L;
        String deviceCacheFlag = configurationConstants$LogSourceName.getDeviceCacheFlag();
        if (!ConfigurationConstants$LogSourceName.isLogSourceKnown(longValue) || (logSourceName = ConfigurationConstants$LogSourceName.getLogSourceName(longValue)) == null) {
            Optional<String> deviceCacheString = getDeviceCacheString(configurationConstants$LogSourceName);
            return deviceCacheString.isAvailable() ? deviceCacheString.get() : configurationConstants$LogSourceName.getDefault();
        }
        this.deviceCacheManager.setValue(deviceCacheFlag, logSourceName);
        return logSourceName;
    }

    public double getFragmentSamplingRate() {
        ConfigurationConstants$FragmentSamplingRate configurationConstants$FragmentSamplingRate = ConfigurationConstants$FragmentSamplingRate.getInstance();
        Optional<Double> metadataDouble = getMetadataDouble(configurationConstants$FragmentSamplingRate);
        if (metadataDouble.isAvailable()) {
            double doubleValue = metadataDouble.get().doubleValue() / 100.0d;
            if (isSamplingRateValid(doubleValue)) {
                return doubleValue;
            }
        }
        Optional<Double> remoteConfigDouble = getRemoteConfigDouble(configurationConstants$FragmentSamplingRate);
        if (remoteConfigDouble.isAvailable() && isSamplingRateValid(remoteConfigDouble.get().doubleValue())) {
            this.deviceCacheManager.setValue(configurationConstants$FragmentSamplingRate.getDeviceCacheFlag(), remoteConfigDouble.get().doubleValue());
            return remoteConfigDouble.get().doubleValue();
        }
        Optional<Double> deviceCacheDouble = getDeviceCacheDouble(configurationConstants$FragmentSamplingRate);
        return (deviceCacheDouble.isAvailable() && isSamplingRateValid(deviceCacheDouble.get().doubleValue())) ? deviceCacheDouble.get().doubleValue() : configurationConstants$FragmentSamplingRate.getDefault().doubleValue();
    }

    public boolean getIsExperimentTTIDEnabled() {
        ConfigurationConstants$ExperimentTTID configurationConstants$ExperimentTTID = ConfigurationConstants$ExperimentTTID.getInstance();
        Optional<Boolean> metadataBoolean = getMetadataBoolean(configurationConstants$ExperimentTTID);
        if (metadataBoolean.isAvailable()) {
            return metadataBoolean.get().booleanValue();
        }
        Optional<Boolean> remoteConfigBoolean = getRemoteConfigBoolean(configurationConstants$ExperimentTTID);
        if (remoteConfigBoolean.isAvailable()) {
            this.deviceCacheManager.setValue(configurationConstants$ExperimentTTID.getDeviceCacheFlag(), remoteConfigBoolean.get().booleanValue());
            return remoteConfigBoolean.get().booleanValue();
        }
        Optional<Boolean> deviceCacheBoolean = getDeviceCacheBoolean(configurationConstants$ExperimentTTID);
        return deviceCacheBoolean.isAvailable() ? deviceCacheBoolean.get().booleanValue() : configurationConstants$ExperimentTTID.getDefault().booleanValue();
    }

    public Boolean getIsPerformanceCollectionDeactivated() {
        ConfigurationConstants$CollectionDeactivated configurationConstants$CollectionDeactivated = ConfigurationConstants$CollectionDeactivated.getInstance();
        Optional<Boolean> metadataBoolean = getMetadataBoolean(configurationConstants$CollectionDeactivated);
        return metadataBoolean.isAvailable() ? metadataBoolean.get() : configurationConstants$CollectionDeactivated.getDefault();
    }

    public Boolean getIsPerformanceCollectionEnabled() {
        if (getIsPerformanceCollectionDeactivated().booleanValue()) {
            return Boolean.FALSE;
        }
        ConfigurationConstants$CollectionEnabled configurationConstants$CollectionEnabled = ConfigurationConstants$CollectionEnabled.getInstance();
        Optional<Boolean> deviceCacheBoolean = getDeviceCacheBoolean(configurationConstants$CollectionEnabled);
        if (deviceCacheBoolean.isAvailable()) {
            return deviceCacheBoolean.get();
        }
        Optional<Boolean> metadataBoolean = getMetadataBoolean(configurationConstants$CollectionEnabled);
        if (metadataBoolean.isAvailable()) {
            return metadataBoolean.get();
        }
        return null;
    }

    public boolean getIsServiceCollectionEnabled() {
        return getIsSdkEnabled() && !getIsSdkVersionDisabled();
    }

    public long getNetworkEventCountBackground() {
        ConfigurationConstants$NetworkEventCountBackground configurationConstants$NetworkEventCountBackground = ConfigurationConstants$NetworkEventCountBackground.getInstance();
        Optional<Long> remoteConfigLong = getRemoteConfigLong(configurationConstants$NetworkEventCountBackground);
        if (remoteConfigLong.isAvailable() && isEventCountValid(remoteConfigLong.get().longValue())) {
            this.deviceCacheManager.setValue(configurationConstants$NetworkEventCountBackground.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
            return remoteConfigLong.get().longValue();
        }
        Optional<Long> deviceCacheLong = getDeviceCacheLong(configurationConstants$NetworkEventCountBackground);
        return (deviceCacheLong.isAvailable() && isEventCountValid(deviceCacheLong.get().longValue())) ? deviceCacheLong.get().longValue() : configurationConstants$NetworkEventCountBackground.getDefault().longValue();
    }

    public long getNetworkEventCountForeground() {
        ConfigurationConstants$NetworkEventCountForeground configurationConstants$NetworkEventCountForeground = ConfigurationConstants$NetworkEventCountForeground.getInstance();
        Optional<Long> remoteConfigLong = getRemoteConfigLong(configurationConstants$NetworkEventCountForeground);
        if (remoteConfigLong.isAvailable() && isEventCountValid(remoteConfigLong.get().longValue())) {
            this.deviceCacheManager.setValue(configurationConstants$NetworkEventCountForeground.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
            return remoteConfigLong.get().longValue();
        }
        Optional<Long> deviceCacheLong = getDeviceCacheLong(configurationConstants$NetworkEventCountForeground);
        return (deviceCacheLong.isAvailable() && isEventCountValid(deviceCacheLong.get().longValue())) ? deviceCacheLong.get().longValue() : configurationConstants$NetworkEventCountForeground.getDefault().longValue();
    }

    public double getNetworkRequestSamplingRate() {
        ConfigurationConstants$NetworkRequestSamplingRate configurationConstants$NetworkRequestSamplingRate = ConfigurationConstants$NetworkRequestSamplingRate.getInstance();
        Optional<Double> remoteConfigDouble = getRemoteConfigDouble(configurationConstants$NetworkRequestSamplingRate);
        if (remoteConfigDouble.isAvailable() && isSamplingRateValid(remoteConfigDouble.get().doubleValue())) {
            this.deviceCacheManager.setValue(configurationConstants$NetworkRequestSamplingRate.getDeviceCacheFlag(), remoteConfigDouble.get().doubleValue());
            return remoteConfigDouble.get().doubleValue();
        }
        Optional<Double> deviceCacheDouble = getDeviceCacheDouble(configurationConstants$NetworkRequestSamplingRate);
        return (deviceCacheDouble.isAvailable() && isSamplingRateValid(deviceCacheDouble.get().doubleValue())) ? deviceCacheDouble.get().doubleValue() : this.remoteConfigManager.isLastFetchFailed() ? configurationConstants$NetworkRequestSamplingRate.getDefaultOnRcFetchFail().doubleValue() : configurationConstants$NetworkRequestSamplingRate.getDefault().doubleValue();
    }

    public long getRateLimitSec() {
        ConfigurationConstants$RateLimitSec configurationConstants$RateLimitSec = ConfigurationConstants$RateLimitSec.getInstance();
        Optional<Long> remoteConfigLong = getRemoteConfigLong(configurationConstants$RateLimitSec);
        if (remoteConfigLong.isAvailable() && isTimeRangeSecValid(remoteConfigLong.get().longValue())) {
            this.deviceCacheManager.setValue(configurationConstants$RateLimitSec.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
            return remoteConfigLong.get().longValue();
        }
        Optional<Long> deviceCacheLong = getDeviceCacheLong(configurationConstants$RateLimitSec);
        return (deviceCacheLong.isAvailable() && isTimeRangeSecValid(deviceCacheLong.get().longValue())) ? deviceCacheLong.get().longValue() : configurationConstants$RateLimitSec.getDefault().longValue();
    }

    public long getSessionsCpuCaptureFrequencyBackgroundMs() {
        ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs configurationConstants$SessionsCpuCaptureFrequencyBackgroundMs = ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs.getInstance();
        Optional<Long> metadataLong = getMetadataLong(configurationConstants$SessionsCpuCaptureFrequencyBackgroundMs);
        if (metadataLong.isAvailable() && isGaugeCaptureFrequencyMsValid(metadataLong.get().longValue())) {
            return metadataLong.get().longValue();
        }
        Optional<Long> remoteConfigLong = getRemoteConfigLong(configurationConstants$SessionsCpuCaptureFrequencyBackgroundMs);
        if (remoteConfigLong.isAvailable() && isGaugeCaptureFrequencyMsValid(remoteConfigLong.get().longValue())) {
            this.deviceCacheManager.setValue(configurationConstants$SessionsCpuCaptureFrequencyBackgroundMs.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
            return remoteConfigLong.get().longValue();
        }
        Optional<Long> deviceCacheLong = getDeviceCacheLong(configurationConstants$SessionsCpuCaptureFrequencyBackgroundMs);
        return (deviceCacheLong.isAvailable() && isGaugeCaptureFrequencyMsValid(deviceCacheLong.get().longValue())) ? deviceCacheLong.get().longValue() : configurationConstants$SessionsCpuCaptureFrequencyBackgroundMs.getDefault().longValue();
    }

    public long getSessionsCpuCaptureFrequencyForegroundMs() {
        ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs configurationConstants$SessionsCpuCaptureFrequencyForegroundMs = ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs.getInstance();
        Optional<Long> metadataLong = getMetadataLong(configurationConstants$SessionsCpuCaptureFrequencyForegroundMs);
        if (metadataLong.isAvailable() && isGaugeCaptureFrequencyMsValid(metadataLong.get().longValue())) {
            return metadataLong.get().longValue();
        }
        Optional<Long> remoteConfigLong = getRemoteConfigLong(configurationConstants$SessionsCpuCaptureFrequencyForegroundMs);
        if (remoteConfigLong.isAvailable() && isGaugeCaptureFrequencyMsValid(remoteConfigLong.get().longValue())) {
            this.deviceCacheManager.setValue(configurationConstants$SessionsCpuCaptureFrequencyForegroundMs.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
            return remoteConfigLong.get().longValue();
        }
        Optional<Long> deviceCacheLong = getDeviceCacheLong(configurationConstants$SessionsCpuCaptureFrequencyForegroundMs);
        return (deviceCacheLong.isAvailable() && isGaugeCaptureFrequencyMsValid(deviceCacheLong.get().longValue())) ? deviceCacheLong.get().longValue() : this.remoteConfigManager.isLastFetchFailed() ? configurationConstants$SessionsCpuCaptureFrequencyForegroundMs.getDefaultOnRcFetchFail().longValue() : configurationConstants$SessionsCpuCaptureFrequencyForegroundMs.getDefault().longValue();
    }

    public long getSessionsMaxDurationMinutes() {
        ConfigurationConstants$SessionsMaxDurationMinutes configurationConstants$SessionsMaxDurationMinutes = ConfigurationConstants$SessionsMaxDurationMinutes.getInstance();
        Optional<Long> metadataLong = getMetadataLong(configurationConstants$SessionsMaxDurationMinutes);
        if (metadataLong.isAvailable() && isSessionsMaxDurationMinutesValid(metadataLong.get().longValue())) {
            return metadataLong.get().longValue();
        }
        Optional<Long> remoteConfigLong = getRemoteConfigLong(configurationConstants$SessionsMaxDurationMinutes);
        if (remoteConfigLong.isAvailable() && isSessionsMaxDurationMinutesValid(remoteConfigLong.get().longValue())) {
            this.deviceCacheManager.setValue(configurationConstants$SessionsMaxDurationMinutes.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
            return remoteConfigLong.get().longValue();
        }
        Optional<Long> deviceCacheLong = getDeviceCacheLong(configurationConstants$SessionsMaxDurationMinutes);
        return (deviceCacheLong.isAvailable() && isSessionsMaxDurationMinutesValid(deviceCacheLong.get().longValue())) ? deviceCacheLong.get().longValue() : configurationConstants$SessionsMaxDurationMinutes.getDefault().longValue();
    }

    public long getSessionsMemoryCaptureFrequencyBackgroundMs() {
        ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs configurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs = ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs.getInstance();
        Optional<Long> metadataLong = getMetadataLong(configurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs);
        if (metadataLong.isAvailable() && isGaugeCaptureFrequencyMsValid(metadataLong.get().longValue())) {
            return metadataLong.get().longValue();
        }
        Optional<Long> remoteConfigLong = getRemoteConfigLong(configurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs);
        if (remoteConfigLong.isAvailable() && isGaugeCaptureFrequencyMsValid(remoteConfigLong.get().longValue())) {
            this.deviceCacheManager.setValue(configurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
            return remoteConfigLong.get().longValue();
        }
        Optional<Long> deviceCacheLong = getDeviceCacheLong(configurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs);
        return (deviceCacheLong.isAvailable() && isGaugeCaptureFrequencyMsValid(deviceCacheLong.get().longValue())) ? deviceCacheLong.get().longValue() : configurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs.getDefault().longValue();
    }

    public long getSessionsMemoryCaptureFrequencyForegroundMs() {
        ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs configurationConstants$SessionsMemoryCaptureFrequencyForegroundMs = ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs.getInstance();
        Optional<Long> metadataLong = getMetadataLong(configurationConstants$SessionsMemoryCaptureFrequencyForegroundMs);
        if (metadataLong.isAvailable() && isGaugeCaptureFrequencyMsValid(metadataLong.get().longValue())) {
            return metadataLong.get().longValue();
        }
        Optional<Long> remoteConfigLong = getRemoteConfigLong(configurationConstants$SessionsMemoryCaptureFrequencyForegroundMs);
        if (remoteConfigLong.isAvailable() && isGaugeCaptureFrequencyMsValid(remoteConfigLong.get().longValue())) {
            this.deviceCacheManager.setValue(configurationConstants$SessionsMemoryCaptureFrequencyForegroundMs.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
            return remoteConfigLong.get().longValue();
        }
        Optional<Long> deviceCacheLong = getDeviceCacheLong(configurationConstants$SessionsMemoryCaptureFrequencyForegroundMs);
        return (deviceCacheLong.isAvailable() && isGaugeCaptureFrequencyMsValid(deviceCacheLong.get().longValue())) ? deviceCacheLong.get().longValue() : this.remoteConfigManager.isLastFetchFailed() ? configurationConstants$SessionsMemoryCaptureFrequencyForegroundMs.getDefaultOnRcFetchFail().longValue() : configurationConstants$SessionsMemoryCaptureFrequencyForegroundMs.getDefault().longValue();
    }

    public double getSessionsSamplingRate() {
        ConfigurationConstants$SessionsSamplingRate configurationConstants$SessionsSamplingRate = ConfigurationConstants$SessionsSamplingRate.getInstance();
        Optional<Double> metadataDouble = getMetadataDouble(configurationConstants$SessionsSamplingRate);
        if (metadataDouble.isAvailable()) {
            double doubleValue = metadataDouble.get().doubleValue() / 100.0d;
            if (isSamplingRateValid(doubleValue)) {
                return doubleValue;
            }
        }
        Optional<Double> remoteConfigDouble = getRemoteConfigDouble(configurationConstants$SessionsSamplingRate);
        if (remoteConfigDouble.isAvailable() && isSamplingRateValid(remoteConfigDouble.get().doubleValue())) {
            this.deviceCacheManager.setValue(configurationConstants$SessionsSamplingRate.getDeviceCacheFlag(), remoteConfigDouble.get().doubleValue());
            return remoteConfigDouble.get().doubleValue();
        }
        Optional<Double> deviceCacheDouble = getDeviceCacheDouble(configurationConstants$SessionsSamplingRate);
        return (deviceCacheDouble.isAvailable() && isSamplingRateValid(deviceCacheDouble.get().doubleValue())) ? deviceCacheDouble.get().doubleValue() : this.remoteConfigManager.isLastFetchFailed() ? configurationConstants$SessionsSamplingRate.getDefaultOnRcFetchFail().doubleValue() : configurationConstants$SessionsSamplingRate.getDefault().doubleValue();
    }

    public long getTraceEventCountBackground() {
        ConfigurationConstants$TraceEventCountBackground configurationConstants$TraceEventCountBackground = ConfigurationConstants$TraceEventCountBackground.getInstance();
        Optional<Long> remoteConfigLong = getRemoteConfigLong(configurationConstants$TraceEventCountBackground);
        if (remoteConfigLong.isAvailable() && isEventCountValid(remoteConfigLong.get().longValue())) {
            this.deviceCacheManager.setValue(configurationConstants$TraceEventCountBackground.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
            return remoteConfigLong.get().longValue();
        }
        Optional<Long> deviceCacheLong = getDeviceCacheLong(configurationConstants$TraceEventCountBackground);
        return (deviceCacheLong.isAvailable() && isEventCountValid(deviceCacheLong.get().longValue())) ? deviceCacheLong.get().longValue() : configurationConstants$TraceEventCountBackground.getDefault().longValue();
    }

    public long getTraceEventCountForeground() {
        ConfigurationConstants$TraceEventCountForeground configurationConstants$TraceEventCountForeground = ConfigurationConstants$TraceEventCountForeground.getInstance();
        Optional<Long> remoteConfigLong = getRemoteConfigLong(configurationConstants$TraceEventCountForeground);
        if (remoteConfigLong.isAvailable() && isEventCountValid(remoteConfigLong.get().longValue())) {
            this.deviceCacheManager.setValue(configurationConstants$TraceEventCountForeground.getDeviceCacheFlag(), remoteConfigLong.get().longValue());
            return remoteConfigLong.get().longValue();
        }
        Optional<Long> deviceCacheLong = getDeviceCacheLong(configurationConstants$TraceEventCountForeground);
        return (deviceCacheLong.isAvailable() && isEventCountValid(deviceCacheLong.get().longValue())) ? deviceCacheLong.get().longValue() : configurationConstants$TraceEventCountForeground.getDefault().longValue();
    }

    public double getTraceSamplingRate() {
        ConfigurationConstants$TraceSamplingRate configurationConstants$TraceSamplingRate = ConfigurationConstants$TraceSamplingRate.getInstance();
        Optional<Double> remoteConfigDouble = getRemoteConfigDouble(configurationConstants$TraceSamplingRate);
        if (remoteConfigDouble.isAvailable() && isSamplingRateValid(remoteConfigDouble.get().doubleValue())) {
            this.deviceCacheManager.setValue(configurationConstants$TraceSamplingRate.getDeviceCacheFlag(), remoteConfigDouble.get().doubleValue());
            return remoteConfigDouble.get().doubleValue();
        }
        Optional<Double> deviceCacheDouble = getDeviceCacheDouble(configurationConstants$TraceSamplingRate);
        return (deviceCacheDouble.isAvailable() && isSamplingRateValid(deviceCacheDouble.get().doubleValue())) ? deviceCacheDouble.get().doubleValue() : this.remoteConfigManager.isLastFetchFailed() ? configurationConstants$TraceSamplingRate.getDefaultOnRcFetchFail().doubleValue() : configurationConstants$TraceSamplingRate.getDefault().doubleValue();
    }

    public boolean isPerformanceMonitoringEnabled() {
        Boolean isPerformanceCollectionEnabled = getIsPerformanceCollectionEnabled();
        return (isPerformanceCollectionEnabled == null || isPerformanceCollectionEnabled.booleanValue()) && getIsServiceCollectionEnabled();
    }

    public void setApplicationContext(Context context) {
        logger.setLogcatEnabled(Utils.isDebugLoggingEnabled(context));
        this.deviceCacheManager.setContext(context);
    }

    public void setMetadataBundle(ImmutableBundle immutableBundle) {
        this.metadataBundle = immutableBundle;
    }
}
