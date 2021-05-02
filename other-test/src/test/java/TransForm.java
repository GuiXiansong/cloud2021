public class TransForm {
    private Long calcId;
    private String qtyChargYm;
    private String mgtOrgCode;

    public TransForm() {
    }

    public TransForm(Long calcId, String qtyChargYm, String mgtOrgCode) {
        this.calcId = calcId;
        this.qtyChargYm = qtyChargYm;
        this.mgtOrgCode = mgtOrgCode;
    }

    public Long getCalcId() {
        return calcId;
    }

    public void setCalcId(Long calcId) {
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
