package com.xjt.entity;

/**
 * 银行账户表
 * 
 * @author wcyong
 * 
 * @date 2019-10-29
 */
public class Dictbankaccounts {
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
        this.id = id == null ? null : id.trim();
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getBankaddr() {
        return bankaddr;
    }

    public void setBankaddr(String bankaddr) {
        this.bankaddr = bankaddr == null ? null : bankaddr.trim();
    }

    public String getAccountsname() {
        return accountsname;
    }

    public void setAccountsname(String accountsname) {
        this.accountsname = accountsname == null ? null : accountsname.trim();
    }

    public String getAccounts() {
        return accounts;
    }

    public void setAccounts(String accounts) {
        this.accounts = accounts == null ? null : accounts.trim();
    }

    public String getBanknumber() {
        return banknumber;
    }

    public void setBanknumber(String banknumber) {
        this.banknumber = banknumber == null ? null : banknumber.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getBanktel() {
        return banktel;
    }

    public void setBanktel(String banktel) {
        this.banktel = banktel == null ? null : banktel.trim();
    }

    public String getCmemo() {
        return cmemo;
    }

    public void setCmemo(String cmemo) {
        this.cmemo = cmemo == null ? null : cmemo.trim();
    }

    public String getSupplyNo() {
        return supplyNo;
    }

    public void setSupplyNo(String supplyNo) {
        this.supplyNo = supplyNo == null ? null : supplyNo.trim();
    }
}