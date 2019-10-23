package com.xjt.fileupload.pojo;


import com.xjt.fileupload.util.DateUtil;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

/**
 * @Author Scott Lau
 * @Date Create in 18/5/21 12:00
 * @Description
 */
@Entity
@Table(name = "t_upload_history", catalog = "")
public class UploadHistory {
    //主键
    private String id;
    //备注
    private String note;
    //上传时间
    private Date createDate;
    //上传失败文件数
    private Long failCount;
    //上传文件总数
    private Long fileCount;
    //上传成功文件数
    private Long finishCount;
    //上传操作人
    private String createBy;
    //操作平台
    private Long permission;
    //文件所属
    private String platform;
    //上传日期字符串
    private String dateStr;

    public UploadHistory() {}

    public UploadHistory(Date createDate, String dateStr, Long fileCount,
                         Long finishCount, Long failCount, String platform,
                         Long permission, String createBy, String note) {

        this.createDate = createDate;
        this.dateStr = dateStr;
        this.fileCount = fileCount;
        this.finishCount = finishCount;
        this.failCount = failCount;
        this.platform = platform;
        this.permission = permission;
        this.createBy = createBy;
        this.note = note;
    }

    public static UploadHistory createUploadHistory(Date createDate, Long fileCount, Long finishCount,
                                                    Long failCount, String platform, Long permission,
                                                    String createBy, String note) {

        String dateStr = DateUtil.formatDate(createDate, null);

        return new UploadHistory(createDate, dateStr, fileCount, finishCount,
                failCount, platform, permission, createBy, note);
    }


    @Id
    @Column(name = "id", nullable = false, length = 32)
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "note", nullable = true, length = 32)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "create_date", nullable = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "fail_count", nullable = true, precision = 0)
    public Long getFailCount() {
        return failCount;
    }

    public void setFailCount(Long failCount) {
        this.failCount = failCount;
    }

    @Basic
    @Column(name = "file_count", nullable = true, precision = 0)
    public Long getFileCount() {
        return fileCount;
    }

    public void setFileCount(Long fileCount) {
        this.fileCount = fileCount;
    }

    @Basic
    @Column(name = "finish_count", nullable = true, precision = 0)
    public Long getFinishCount() {
        return finishCount;
    }

    public void setFinishCount(Long finishCount) {
        this.finishCount = finishCount;
    }

    @Basic
    @Column(name = "create_by", nullable = true, length = 32)
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Basic
    @Column(name = "permission", nullable = true, precision = 0)
    public Long getPermission() {
        return permission;
    }

    public void setPermission(Long permission) {
        this.permission = permission;
    }

    @Basic
    @Column(name = "platform", nullable = true, length = 16)
    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Basic
    @Column(name = "date_str", nullable = true, length = 255)
    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UploadHistory that = (UploadHistory) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(note, that.note) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(failCount, that.failCount) &&
                Objects.equals(fileCount, that.fileCount) &&
                Objects.equals(finishCount, that.finishCount) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(permission, that.permission) &&
                Objects.equals(platform, that.platform) &&
                Objects.equals(dateStr, that.dateStr);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, note, createDate, failCount, fileCount, finishCount, createBy, permission, platform, dateStr);
    }
}
