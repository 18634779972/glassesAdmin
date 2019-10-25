package com.xjt.fileupload.pojo;


import com.xjt.fileupload.common.YesOrNo;
import com.xjt.fileupload.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @Author Scott Lau
 * @Date Create in 18/5/21 12:00
 * @Description
 */
@Entity
@Table(name = "t_file_history", catalog = "")
public class FileHistory implements Cloneable {
    //主键
    private String id;
    //备注
    private String note;
    //转换后文件名
    private String convertFullName;
    //转换后格式
    private String convertType;
    //是否已删除
    private String del;
    //Excel信息
    private String excelInfo;
    //文件缩写名
    private String fileShortname;
    //所在文件夹
    private String folder;
    //此保存是否为原文件
    private String isOrigin;
    //原文件完整名称
    private String originFullName;
    //原文件名称(不包括后缀)
    private String originSimpleName;
    //原文件格式
    private String originType;
    //文件权限
    private String permission;
    //访问url
    private String url;
    //完整访问url
    private String fullUrl;
    //所属批次ID
    private String uploadHistoryId;
    //文件高度
    private Long imgHeight;
    //文件宽度
    private Long imgWidth;
    //业务主键
    private String businessKey;
    //业务的附件类别
    private String attachmentCategory;
    //操作人
    private String createBy;
    //上传时间
    private Date createDate;
    //上传日期字符串
    private String dateStr;
    //访问IP和Port
    private String addr;
    //摁键类别
    private String docType;

    public FileHistory() {
    }

    public FileHistory(String convertFullName, String convertType, String del,
                       String excelInfo, String fileShortname, String folder,
                       String isOrigin, String originFullName, String originSimpleName,
                       String originType, String permission, String url, String uploadHistoryId,
                       Long imgHeight, Long imgWidth, String businessKey, String attachmentCategory,
                       String createBy, Date createDate, String dateStr, String note, String docType) {

        this.convertFullName = convertFullName;
        this.convertType = convertType;
        this.del = del;
        this.excelInfo = excelInfo;
        this.fileShortname = fileShortname;
        this.folder = folder;
        this.isOrigin = isOrigin;
        this.originFullName = originFullName;
        this.originSimpleName = originSimpleName;
        this.originType = originType;
        this.permission = permission;
        this.url = url;
        this.uploadHistoryId = uploadHistoryId;
        this.imgHeight = imgHeight;
        this.imgWidth = imgWidth;
        this.businessKey = businessKey;
        this.attachmentCategory = attachmentCategory;
        this.createBy = createBy;
        this.createDate = createDate;
        this.dateStr = dateStr;
        this.addr = addr;
        this.note = note;
        this.docType = docType;
    }

    public static FileHistory createFileHistory(Date createDate, String convertFullName, String folder,
                                                String isOrigin, String originFullName, String originType,
                                                String permission, String createBy, String note) {

        String originSimpleName = originFullName.substring(0, originFullName.lastIndexOf("."));
        String convertType = convertFullName.substring(convertFullName.lastIndexOf(".") + 1, convertFullName.length());

        String url = "";
        if (StringUtils.isBlank(folder)) {
            url = "/" + convertFullName;
        } else if (folder.equals("/")) {
            url = folder + convertFullName;
        } else {
            url = folder + "/" + convertFullName;
        }

        String dateStr = DateUtil.formatDate(createDate, null);

        return new FileHistory(convertFullName, convertType, YesOrNo.NO.getValue(),
                "", "", StringUtils.isBlank(folder) ? "/" : folder, isOrigin,
                originFullName, originSimpleName,
                originType, permission, url, null,
                (long) 0, (long) 0, null, null,
                createBy, createDate, dateStr, note, null);
    }

    public void addWidthAndHeight(long imgWidth, long imgHeight) {
        this.imgWidth = imgWidth;
        this.imgHeight = imgHeight;
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
    @Column(name = "note", nullable = true, length = 50)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "convert_full_name", nullable = true, length = 64)
    public String getConvertFullName() {
        return convertFullName;
    }

    public void setConvertFullName(String convertFullName) {
        this.convertFullName = convertFullName;
    }

    @Basic
    @Column(name = "convert_type", nullable = true, length = 10)
    public String getConvertType() {
        return convertType;
    }

    public void setConvertType(String convertType) {
        this.convertType = convertType;
    }

    @Basic
    @Column(name = "del", nullable = true, length = 1)
    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }

    @Basic
    @Column(name = "excel_info", nullable = true, length = 32)
    public String getExcelInfo() {
        return excelInfo;
    }

    public void setExcelInfo(String excelInfo) {
        this.excelInfo = excelInfo;
    }

    @Basic
    @Column(name = "file_shortname", nullable = true, length = 10)
    public String getFileShortname() {
        return fileShortname;
    }

    public void setFileShortname(String fileShortname) {
        this.fileShortname = fileShortname;
    }

    @Basic
    @Column(name = "folder", nullable = true, length = 64)
    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    @Basic
    @Column(name = "is_origin", nullable = true, length = 1)
    public String getIsOrigin() {
        return isOrigin;
    }

    public void setIsOrigin(String isOrigin) {
        this.isOrigin = isOrigin;
    }

    @Basic
    @Column(name = "origin_full_name", nullable = true, length = 150)
    public String getOriginFullName() {
        return originFullName;
    }

    public void setOriginFullName(String originFullName) {
        this.originFullName = originFullName;
    }

    @Basic
    @Column(name = "origin_simple_name", nullable = true, length = 150)
    public String getOriginSimpleName() {
        return originSimpleName;
    }

    public void setOriginSimpleName(String originSimpleName) {
        this.originSimpleName = originSimpleName;
    }

    @Basic
    @Column(name = "origin_type", nullable = true, length = 10)
    public String getOriginType() {
        return originType;
    }

    public void setOriginType(String originType) {
        this.originType = originType;
    }

    @Basic
    @Column(name = "permission", nullable = true, length = 128)
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Basic
    @Column(name = "url", nullable = true, length = 128)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Transient
    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    @Basic
    @Column(name = "upload_history_id", nullable = true, length = 32)
    public String getUploadHistoryId() {
        return uploadHistoryId;
    }

    public void setUploadHistoryId(String uploadHistoryId) {
        this.uploadHistoryId = uploadHistoryId;
    }

    @Basic
    @Column(name = "img_height", nullable = true, precision = 0)
    public Long getImgHeight() {
        return imgHeight;
    }

    public void setImgHeight(Long imgHeight) {
        this.imgHeight = imgHeight;
    }

    @Basic
    @Column(name = "img_width", nullable = true, precision = 0)
    public Long getImgWidth() {
        return imgWidth;
    }

    public void setImgWidth(Long imgWidth) {
        this.imgWidth = imgWidth;
    }

    @Basic
    @Column(name = "business_key", nullable = true, length = 32)
    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    @Basic
    @Column(name = "attachment_category", nullable = true, length = 32)
    public String getAttachmentCategory() {
        return attachmentCategory;
    }

    public void setAttachmentCategory(String attachmentCategory) {
        this.attachmentCategory = attachmentCategory;
    }

    @Basic
    @Column(name = "create_by", nullable = true, length = 10)
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
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
    @Column(name = "date_str", nullable = true, length = 255)
    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    @Transient
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Basic
    @Column(name = "doc_type", nullable = true, length = 32)
    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileHistory that = (FileHistory) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(note, that.note) &&
                Objects.equals(convertFullName, that.convertFullName) &&
                Objects.equals(convertType, that.convertType) &&
                Objects.equals(del, that.del) &&
                Objects.equals(excelInfo, that.excelInfo) &&
                Objects.equals(fileShortname, that.fileShortname) &&
                Objects.equals(folder, that.folder) &&
                Objects.equals(isOrigin, that.isOrigin) &&
                Objects.equals(originFullName, that.originFullName) &&
                Objects.equals(originSimpleName, that.originSimpleName) &&
                Objects.equals(originType, that.originType) &&
                Objects.equals(permission, that.permission) &&
                Objects.equals(url, that.url) &&
                Objects.equals(uploadHistoryId, that.uploadHistoryId) &&
                Objects.equals(imgHeight, that.imgHeight) &&
                Objects.equals(imgWidth, that.imgWidth) &&
                Objects.equals(businessKey, that.businessKey) &&
                Objects.equals(attachmentCategory, that.attachmentCategory) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(createDate, that.createDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, note, convertFullName, convertType, del, excelInfo, fileShortname, folder, isOrigin, originFullName, originSimpleName, originType, permission, url, uploadHistoryId, imgHeight, imgWidth, businessKey, attachmentCategory, createBy, createDate);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
