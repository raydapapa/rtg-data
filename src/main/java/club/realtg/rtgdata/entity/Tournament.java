package club.realtg.rtgdata.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 赛事实体类
 *
 * @author Papa Ray
 * Created on 2017-08-28
 */
@Entity
@Table(name = "t_tournament")
public class Tournament {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * 记录创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @org.hibernate.annotations.CreationTimestamp
    private Date ctime;

    /**
     * 记录更新时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @org.hibernate.annotations.UpdateTimestamp
    private Date mtime;

    /** 赛事名 */
    @NotNull
    private String name;

    /** 赛事官网地址 */
    private String officialUrl;

    /** 球场位置 */
    private String location;

    /** 赛事类型（1：联赛，2：杯赛） */
    private int tournamentType;

    /** 参赛球队数量 */
    private int teamCnt;

    /** 赛季开始日期 yyyy-MM-dd */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date seasonStartDate;

    /** 赛季结束日期 yyyy-MM-dd */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date seasonEndDate;

    /** 夺冠球队ID */
    private int championId;

    /** 我队最终名次 */
    private int ourRank;

    /** 简介 */
    @Column(name = "description")
    private String desc;

    public Tournament() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOfficialUrl() {
        return officialUrl;
    }

    public void setOfficialUrl(String officialUrl) {
        this.officialUrl = officialUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTournamentType() {
        return tournamentType;
    }

    public void setTournamentType(int tournamentType) {
        this.tournamentType = tournamentType;
    }

    public int getTeamCnt() {
        return teamCnt;
    }

    public void setTeamCnt(int teamCnt) {
        this.teamCnt = teamCnt;
    }

    public Date getSeasonStartDate() {
        return seasonStartDate;
    }

    public void setSeasonStartDate(Date seasonStartDate) {
        this.seasonStartDate = seasonStartDate;
    }

    public Date getSeasonEndDate() {
        return seasonEndDate;
    }

    public void setSeasonEndDate(Date seasonEndDate) {
        this.seasonEndDate = seasonEndDate;
    }

    public int getChampionId() {
        return championId;
    }

    public void setChampionId(int championId) {
        this.championId = championId;
    }

    public int getOurRank() {
        return ourRank;
    }

    public void setOurRank(int ourRank) {
        this.ourRank = ourRank;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
