package com.xjt.dto;

public class DictbankaccountsReqDto extends BaseReqDto {

    /**
     * 银行编号
     */
    private String id;

    /**
     * 开户行
     */
    private String bank;

    /**
     * 开户行地址
     */
    private String bankaddr;

    /**
     * 户名
     */
    private String accountsname;

    /**
     * 账号
     */
    private String accounts;

    /**
     * 行号
     */
    private String banknumber;

    /**
     * 开户电话
     */
    private String tel;

    /**
     * 银行电话
     */
    private String banktel;

    /**
     * 备注
     */
    private String cmemo;

    /**
     * 编号
     */
    private String supplyNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankaddr() {
        return bankaddr;
    }

    public void setBankaddr(String bankaddr) {
        this.bankaddr = bankaddr;
    }

    public String getAccountsname() {
        return accountsname;
    }

    public void setAccountsname(String accountsname) {
        this.accountsname = accountsname;
    }

    public String getAccounts() {
        return accounts;
    }

    public void setAccounts(String accounts) {
        this.accounts = accounts;
    }

    public String getBanknumber() {
        return banknumber;
    }

    public void setBanknumber(String banknumber) {
        this.banknumber = banknumber;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBanktel() {
        return banktel;
    }

    public void setBanktel(String banktel) {
        this.banktel = banktel;
    }

    public String getCmemo() {
        return cmemo;
    }

    public void setCmemo(String cmemo) {
        this.cmemo = cmemo;
    }

    public String getSupplyNo() {
        return supplyNo;
    }

    public void setSupplyNo(String supplyNo) {
        this.supplyNo = supplyNo;
    }
}
