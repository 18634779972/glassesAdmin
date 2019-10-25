package com.xjt.fileupload.common;

import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @Author liuwei
 * @Date Create in 18/5/11 9:21
 * @Description
 */
public class DateTimeRange {

    private final String field;
    private final Date startDate;
    private final Date endDate;

    private DateTimeRange(String field, Date startDate, Date endDate) {
        this.field = field;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getField() {
        return field;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public static DateTimeRange createTimaRange(@NotNull String field, @NotNull Date startDate, @NotNull Date endDate) {
        return new DateTimeRange(field, startDate, endDate);
    }

    public boolean isValid() {
        return StringUtils.isNotBlank(field)
                && startDate != null
                && endDate != null;
    }

    public static void addDateTimeRange(DateTimeRange dateTimeRange, StringBuilder hql, List<Object> param) {
        if (dateTimeRange.isValid()) {
            hql.append(" and " + dateTimeRange.field + " between ? and ?");
            param.add(dateTimeRange.getStartDate());
            param.add(dateTimeRange.getEndDate());
        }
    }

}
