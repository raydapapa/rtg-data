package club.realtg.rtgdata.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 球员实体类
 *
 * @author Papa Ray
 * Created on 2017-08-14
 */
@Entity
@Table(name = "t_player")
public class Player {
    /** ID */
    @Id
    @GeneratedValue
    private int id;

    /** 身份证姓名 */
    @NotNull
    @Column(name = "real_name")
    private String realName;

    /** 绰号 */
    private String nickName;

    /** 身份证号 */
    @NotNull
    @Size(min=15, max=18)
    private String idCardNo;

    /** 球衣号码 */
    private int kitNumber;

    /** 出生日期 */
    private Date birthDate;

    /** 身高(cm) */
    private int height;

    /** 体重(kg) */
    private int weight;

    /** 擅长足 1:右脚 2:左脚 */
    @Column(name = "pref_foot")
    private int preferredFoot;

    /** 场上位置 0:守门员 1:中后卫 2:边后卫 3:后腰 4:前腰 5:边前卫 6:中锋 */
    private int position;

    /** 手机号 */
    @Size(max=11)
    private String phoneNo;

    /** QQ号 */
    private String qqNo;

    /** 微信号 */
    private String wechatNo;

    /** 简介 */
    @Column(name = "description")
    private String desc;

    public Player() {
    }

    public Player(String realName, String nickName, String idCardNo, int kitNumber) {
        this.realName = realName;
        this.nickName = nickName;
        this.idCardNo = idCardNo;
        this.kitNumber = kitNumber;
    }

    public Player(String realName, String nickName, String idCardNo, int kitNumber, Date birthDate, int height, int weight, int preferredFoot, int position, String phoneNo, String qqNo, String wechatNo, String desc) {
        this.realName = realName;
        this.nickName = nickName;
        this.idCardNo = idCardNo;
        this.kitNumber = kitNumber;
        this.birthDate = birthDate;
        this.height = height;
        this.weight = weight;
        this.preferredFoot = preferredFoot;
        this.position = position;
        this.phoneNo = phoneNo;
        this.qqNo = qqNo;
        this.wechatNo = wechatNo;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public int getKitNumber() {
        return kitNumber;
    }

    public void setKitNumber(int kitNumber) {
        this.kitNumber = kitNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPreferredFoot() {
        return preferredFoot;
    }

    public void setPreferredFoot(int preferredFoot) {
        this.preferredFoot = preferredFoot;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getQqNo() {
        return qqNo;
    }

    public void setQqNo(String qqNo) {
        this.qqNo = qqNo;
    }

    public String getWechatNo() {
        return wechatNo;
    }

    public void setWechatNo(String wechatNo) {
        this.wechatNo = wechatNo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
