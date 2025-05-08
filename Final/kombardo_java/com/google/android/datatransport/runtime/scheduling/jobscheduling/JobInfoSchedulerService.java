package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.datatransport.runtime.util.PriorityMapping;

/* loaded from: classes.dex */
public class JobInfoSchedulerService extends JobService {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStartJob$0(JobParameters jobParameters) {
        jobFinished(jobParameters, false);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i5 = jobParameters.getExtras().getInt("priority");
        int i6 = jobParameters.getExtras().getInt("attemptNumber");
        TransportRuntime.initialize(getApplicationContext());
        TransportContext.Builder priority = TransportContext.builder().setBackendName(string).setPriority(PriorityMapping.valueOf(i5));
        if (string2 != null) {
            priority.setExtras(Base64.decode(string2, 0));
        }
        TransportRuntime.getInstance().getUploader().upload(priority.build(), i6, new Runnable() { // from class: y0.b
            @Override // java.lang.Runnable
            public final void run() {
                JobInfoSchedulerService.this.lambda$onStartJob$0(jobParameters);
            }
        });
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
