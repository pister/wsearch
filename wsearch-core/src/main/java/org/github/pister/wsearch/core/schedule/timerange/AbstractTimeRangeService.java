package org.github.pister.wsearch.core.schedule.timerange;

import java.util.Date;

/**
 * User: longyi
 * Date: 13-10-7
 * Time: 下午2:01
 */
public abstract class AbstractTimeRangeService implements TimeRangeService {

    protected abstract void storeLastTime(Date timeRange);

    protected abstract Date loadLastTime();

    @Override
    public TimeRange getTimeRange() {
        Date date = loadLastTime();
        return new TimeRange(date, new Date());
    }

    @Override
    public void saveTimeRange(TimeRange timeRange) {
        if (timeRange != null) {
            Date oldTime = timeRange.getEnd();
            storeLastTime(oldTime);
        }
    }

    protected TimeRange getDefaultTimeRange() {
        return new TimeRange(new Date(0), new Date());
    }
}
