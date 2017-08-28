package club.realtg.rtgdata.entity;

import javax.persistence.*;
import java.util.Date;

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

    /** 所属联赛ID */
    private int tournamentId;

    /** 对手球队ID */
    private int opponentId;

    /** 主客场（0：不分主客场，1：主场，2：客场） */
    private int homeAway;

    /** 我方进球数 */
    private int ourGoals;

    /** 对方进球数 */
    private int opponentGoals;

    /** 开球时间 yyyy-MM-dd HH:mm */
    private Date kickOffTime;

    /** 比赛时长（分钟） */
    private int matchMinutes;

    /** 加时点球（0：无加时无点球，1：有点球无加时，2：有加时无点球，3：有加时有点球） */
    private int extraTimePK;

    /** 比赛性质（1：普通轮次积分赛，2：关键轮次积分赛，3：淘汰赛） */
    private int matchType;

    /** 裁判姓名 */
    private String referee;

    /** 比赛备注 */
    private String matchNote;

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

    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public int getOpponentId() {
        return opponentId;
    }

    public void setOpponentId(int opponentId) {
        this.opponentId = opponentId;
    }

    public int getHomeAway() {
        return homeAway;
    }

    public void setHomeAway(int homeAway) {
        this.homeAway = homeAway;
    }

    public int getOurGoals() {
        return ourGoals;
    }

    public void setOurGoals(int ourGoals) {
        this.ourGoals = ourGoals;
    }

    public int getOpponentGoals() {
        return opponentGoals;
    }

    public void setOpponentGoals(int opponentGoals) {
        this.opponentGoals = opponentGoals;
    }

    public Date getKickOffTime() {
        return kickOffTime;
    }

    public void setKickOffTime(Date kickOffTime) {
        this.kickOffTime = kickOffTime;
    }

    public int getMatchMinutes() {
        return matchMinutes;
    }

    public void setMatchMinutes(int matchMinutes) {
        this.matchMinutes = matchMinutes;
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

    public String getMatchNote() {
        return matchNote;
    }

    public void setMatchNote(String matchNote) {
        this.matchNote = matchNote;
    }
}
