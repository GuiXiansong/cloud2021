package com.othertest.pojo;

public class TransForm {
    private int calcId;
    private String qtyChargYm;
    private String mgtOrgCode;

    public TransForm() {
    }

    public TransForm(int calcId, String qtyChargYm, String mgtOrgCode) {
        this.calcId = calcId;
        this.qtyChargYm = qtyChargYm;
        this.mgtOrgCode = mgtOrgCode;
    }

    public int getCalcId() {
        return calcId;
    }

    public void setCalcId(int calcId) {
        this.calcId = calcId;
    }

    public String getQtyChargYm() {
        return qtyChargYm;
    }

    public void setQtyChargYm(String qtyChargYm) {
        this.qtyChargYm = qtyChargYm;
    }

    public String getMgtOrgCode() {
        return mgtOrgCode;
    }

    public void setMgtOrgCode(String mgtOrgCode) {
        this.mgtOrgCode = mgtOrgCode;
    }

    @Override
    public String toString() {
        return "TransForm{" +
                "calcId=" + calcId +
                ", qtyChargYm='" + qtyChargYm + '\'' +
                ", mgtOrgCode='" + mgtOrgCode + '\'' +
                '}';
    }
}
