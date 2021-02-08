package com.jinguizi.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Title: landingpage
 * @description:
 * @Author: liuzhiwen
 * @Create: 2021-01-29 14:39
 **/
public class Behavior implements Serializable {
    private Integer id;
    private String fuid;
    private Integer productId;
    private Integer templateId;
    private Long LoadTime;
    private Integer isScroll;
    private Integer isClickBanner;
    private Integer isClickRedpack;
    private Integer isClickRedpackClose;
    private Integer isClickEggs;
    private Integer triggerEggNum;
    private Integer isClickEggsClose;
    private Integer isClickEggsRedpack;
    private Integer isClickEggsRedpackClose;
    private Integer isClickTurn;
    private Integer triggerTurnNum;
    private Integer isClickTurnClose;
    private Integer isClickTurnGift;
    private Integer isClickTurnGiftClose;
    private Integer isClickPrimaryDownload;
    private Long startToEndTime;
    private String inmarsatSerialNumber;
    private String mobileType;
    private String CreateTime;

    @Override
    public String toString() {
        return "Behavior{" +
                "id=" + id +
                ", fuid='" + fuid + '\'' +
                ", productId=" + productId +
                ", templateId=" + templateId +
                ", LoadTime=" + LoadTime +
                ", isScroll=" + isScroll +
                ", isClickBanner=" + isClickBanner +
                ", isClickRedpack=" + isClickRedpack +
                ", isClickRedpackClose=" + isClickRedpackClose +
                ", isClickEggs=" + isClickEggs +
                ", triggerEggNum=" + triggerEggNum +
                ", isClickEggsClose=" + isClickEggsClose +
                ", isClickEggsRedpack=" + isClickEggsRedpack +
                ", isClickEggsRedpackClose=" + isClickEggsRedpackClose +
                ", isClickTurn=" + isClickTurn +
                ", triggerTurnNum=" + triggerTurnNum +
                ", isClickTurnClose=" + isClickTurnClose +
                ", isClickTurnGift=" + isClickTurnGift +
                ", isClickTurnGiftClose=" + isClickTurnGiftClose +
                ", isClickPrimaryDownload=" + isClickPrimaryDownload +
                ", startToEndTime=" + startToEndTime +
                ", inmarsatSerialNumber='" + inmarsatSerialNumber + '\'' +
                ", mobileType='" + mobileType + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Behavior behavior = (Behavior) o;
        return Objects.equals(id, behavior.id) &&
                Objects.equals(fuid, behavior.fuid) &&
                Objects.equals(productId, behavior.productId) &&
                Objects.equals(templateId, behavior.templateId) &&
                Objects.equals(LoadTime, behavior.LoadTime) &&
                Objects.equals(isScroll, behavior.isScroll) &&
                Objects.equals(isClickBanner, behavior.isClickBanner) &&
                Objects.equals(isClickRedpack, behavior.isClickRedpack) &&
                Objects.equals(isClickRedpackClose, behavior.isClickRedpackClose) &&
                Objects.equals(isClickEggs, behavior.isClickEggs) &&
                Objects.equals(triggerEggNum, behavior.triggerEggNum) &&
                Objects.equals(isClickEggsClose, behavior.isClickEggsClose) &&
                Objects.equals(isClickEggsRedpack, behavior.isClickEggsRedpack) &&
                Objects.equals(isClickEggsRedpackClose, behavior.isClickEggsRedpackClose) &&
                Objects.equals(isClickTurn, behavior.isClickTurn) &&
                Objects.equals(triggerTurnNum, behavior.triggerTurnNum) &&
                Objects.equals(isClickTurnClose, behavior.isClickTurnClose) &&
                Objects.equals(isClickTurnGift, behavior.isClickTurnGift) &&
                Objects.equals(isClickTurnGiftClose, behavior.isClickTurnGiftClose) &&
                Objects.equals(isClickPrimaryDownload, behavior.isClickPrimaryDownload) &&
                Objects.equals(startToEndTime, behavior.startToEndTime) &&
                Objects.equals(inmarsatSerialNumber, behavior.inmarsatSerialNumber) &&
                Objects.equals(mobileType, behavior.mobileType) &&
                Objects.equals(CreateTime, behavior.CreateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fuid, productId, templateId, LoadTime, isScroll, isClickBanner, isClickRedpack, isClickRedpackClose, isClickEggs, triggerEggNum, isClickEggsClose, isClickEggsRedpack, isClickEggsRedpackClose, isClickTurn, triggerTurnNum, isClickTurnClose, isClickTurnGift, isClickTurnGiftClose, isClickPrimaryDownload, startToEndTime, inmarsatSerialNumber, mobileType, CreateTime);
    }

    public Integer getIsClickEggsClose() {
        return isClickEggsClose;
    }

    public void setIsClickEggsClose(Integer isClickEggsClose) {
        this.isClickEggsClose = isClickEggsClose;
    }

    public Integer getIsClickTurnClose() {
        return isClickTurnClose;
    }

    public void setIsClickTurnClose(Integer isClickTurnClose) {
        this.isClickTurnClose = isClickTurnClose;
    }

    public String getInmarsatSerialNumber() {
        return inmarsatSerialNumber;
    }

    public void setInmarsatSerialNumber(String inmarsatSerialNumber) {
        this.inmarsatSerialNumber = inmarsatSerialNumber;
    }

    public String getMobileType() {
        return mobileType;
    }

    public void setMobileType(String mobileType) {
        this.mobileType = mobileType;
    }


    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFuid() {
        return fuid;
    }

    public void setFuid(String fuid) {
        this.fuid = fuid;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Long getLoadTime() {
        return LoadTime;
    }

    public void setLoadTime(Long loadTime) {
        LoadTime = loadTime;
    }

    public Integer getIsScroll() {
        return isScroll;
    }

    public void setIsScroll(Integer isScroll) {
        this.isScroll = isScroll;
    }

    public Integer getIsClickBanner() {
        return isClickBanner;
    }

    public void setIsClickBanner(Integer isClickBanner) {
        this.isClickBanner = isClickBanner;
    }

    public Integer getIsClickRedpack() {
        return isClickRedpack;
    }

    public void setIsClickRedpack(Integer isClickRedpack) {
        this.isClickRedpack = isClickRedpack;
    }

    public Integer getIsClickRedpackClose() {
        return isClickRedpackClose;
    }

    public void setIsClickRedpackClose(Integer isClickRedpackClose) {
        this.isClickRedpackClose = isClickRedpackClose;
    }

    public Integer getIsClickEggs() {
        return isClickEggs;
    }

    public void setIsClickEggs(Integer isClickEggs) {
        this.isClickEggs = isClickEggs;
    }

    public Integer getTriggerEggNum() {
        return triggerEggNum;
    }

    public void setTriggerEggNum(Integer triggerEggNum) {
        this.triggerEggNum = triggerEggNum;
    }

    public Integer getIsClickEggsRedpack() {
        return isClickEggsRedpack;
    }

    public void setIsClickEggsRedpack(Integer isClickEggsRedpack) {
        this.isClickEggsRedpack = isClickEggsRedpack;
    }

    public Integer getIsClickEggsRedpackClose() {
        return isClickEggsRedpackClose;
    }

    public void setIsClickEggsRedpackClose(Integer isClickEggsRedpackClose) {
        this.isClickEggsRedpackClose = isClickEggsRedpackClose;
    }

    public Integer getIsClickTurn() {
        return isClickTurn;
    }

    public void setIsClickTurn(Integer isClickTurn) {
        this.isClickTurn = isClickTurn;
    }

    public Integer getTriggerTurnNum() {
        return triggerTurnNum;
    }

    public void setTriggerTurnNum(Integer triggerTurnNum) {
        this.triggerTurnNum = triggerTurnNum;
    }

    public Integer getIsClickTurnGift() {
        return isClickTurnGift;
    }

    public void setIsClickTurnGift(Integer isClickTurnGift) {
        this.isClickTurnGift = isClickTurnGift;
    }

    public Integer getIsClickTurnGiftClose() {
        return isClickTurnGiftClose;
    }

    public void setIsClickTurnGiftClose(Integer isClickTurnGiftClose) {
        this.isClickTurnGiftClose = isClickTurnGiftClose;
    }

    public Integer getIsClickPrimaryDownload() {
        return isClickPrimaryDownload;
    }

    public void setIsClickPrimaryDownload(Integer isClickPrimaryDownload) {
        this.isClickPrimaryDownload = isClickPrimaryDownload;
    }

    public Long getStartToEndTime() {
        return startToEndTime;
    }

    public void setStartToEndTime(Long startToEndTime) {
        this.startToEndTime = startToEndTime;
    }
}
