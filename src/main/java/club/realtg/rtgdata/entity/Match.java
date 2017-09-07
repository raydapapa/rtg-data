package club.realtg.rtgdata.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 比赛实体类
 *
 * @author Papa Ray
 * Created on 2017-08-28
 */
@Entity
@Table(name = "t_match")
public class Match {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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

    /** 所属赛事ID */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tournament_Id")
    private Tournament tourna;

    /** 对手球队ID */
    private int opponentId;

    /** 开球时间 yyyy-MM-dd HH:mm:ss */
    private Date kickOffTime;

    /** 加时点球（0：无加时无点球，1：有点球无加时，2：有加时无点球，3：有加时有点球） */
    private int extraTimePK;

    /** 比赛性质（1：普通轮次积分赛，2：关键轮次积分赛，3：杯赛小组赛，3：淘汰赛） */
    private int matchType;

    /** 裁判姓名 */
    private String referee;

    /** 比赛备注 */
    private String note;

    /** 球员出场记录 */
    @OneToMany(mappedBy = "match")
    private List<Appearance> appearances;

    /** 进球 */
    @OneToMany(mappedBy = "match")
    private List<Goal> goals;

    public Match() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Tournament getTourna() {
        return tourna;
    }

    public void setTourna(Tournament tourna) {
        this.tourna = tourna;
    }

    public int getOpponentId() {
        return opponentId;
    }

    public void setOpponentId(int opponentId) {
        this.opponentId = opponentId;
    }

    public Date getKickOffTime() {
        return kickOffTime;
    }

    public void setKickOffTime(Date kickOffTime) {
        this.kickOffTime = kickOffTime;
    }

    public int getExtraTimePK() {
        return extraTimePK;
    }

    public void setExtraTimePK(int extraTimePK) {
        this.extraTimePK = extraTimePK;
    }

    public int getMatchType() {
        return matchType;
    }

    public void setMatchType(int matchType) {
        this.matchType = matchType;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Appearance> getAppearances() {
        return appearances;
    }

    public void setAppearances(List<Appearance> appearances) {
        this.appearances = appearances;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }
}
