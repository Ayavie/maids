package com.maids.devices;
import jakarta.persistence.*;

@Entity
@Table(name = "testdata")
public class Devices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "battery_power")
    private Integer battery_power;

    @Column(name = "blue")
    private Integer blue;

    @Column(name = "clock_speed")
    private Float clock_speed;

    @Column(name = "dual_sim")
    private Integer dual_sim;

    @Column(name = "fc")
    private Float fc;

    @Column(name = "four_g")
    private Integer four_g;

    @Column(name = "int_memory")
    private Float int_memory;

    @Column(name = "m_dep")
    private Float m_dep;

    @Column(name = "mobile_wt")
    private Float mobile_wt;

    @Column(name = "n_cores")
    private Float n_cores;

    @Column(name = "pc")
    private Float pc;

    @Column(name = "px_height")
    private Float px_height;

    @Column(name = "px_width")
    private Float px_width;

    @Column(name = "ram")
    private Float ram;

    @Column(name = "sc_h")
    private Float sc_h;

    @Column(name = "sc_w")
    private Float sc_w;

    @Column(name = "talk_time")
    private Integer talk_time;

    @Column(name = "three_g")
    private Integer three_g;

    @Column(name = "touch_screen")
    private Integer touch_screen;

    @Column(name = "wifi")
    private Integer wifi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBattery_power() {
        return battery_power;
    }

    public void setBattery_power(Integer battery_power) {
        this.battery_power = battery_power;
    }

    public Integer getBlue() {
        return blue;
    }

    public void setBlue(Integer blue) {
        this.blue = blue;
    }

    public Float getClock_speed() {
        return clock_speed;
    }

    public void setClock_speed(Float clock_speed) {
        this.clock_speed = clock_speed;
    }

    public Integer getDual_sim() {
        return dual_sim;
    }

    public void setDual_sim(Integer dual_sim) {
        this.dual_sim = dual_sim;
    }

    public Float getFc() {
        return fc;
    }

    public void setFc(Float fc) {
        this.fc = fc;
    }

    public Integer getFour_g() {
        return four_g;
    }

    public void setFour_g(Integer four_g) {
        this.four_g = four_g;
    }

    public Float getInt_memory() {
        return int_memory;
    }

    public void setInt_memory(Float int_memory) {
        this.int_memory = int_memory;
    }

    public Float getM_dep() {
        return m_dep;
    }

    public void setM_dep(Float m_dep) {
        this.m_dep = m_dep;
    }

    public Float getMobile_wt() {
        return mobile_wt;
    }

    public void setMobile_wt(Float mobile_wt) {
        this.mobile_wt = mobile_wt;
    }

   

    public Float getRam() {
        return ram;
    }

    public void setRam(Float ram) {
        this.ram = ram;
    }

    public Float getPx_height() {
        return px_height;
    }

    public void setPx_height(Float px_height) {
        this.px_height = px_height;
    }

    public Float getPx_width() {
        return px_width;
    }

    public void setPx_width(Float px_width) {
        this.px_width = px_width;
    }


    public Float getSc_h() {
        return sc_h;
    }

    public void setSc_h(Float sc_h) {
        this.sc_h = sc_h;
    }

    public Float getSc_w() {
        return sc_w;
    }

    public void setSc_w(Float sc_w) {
        this.sc_w = sc_w;
    }

    public Float getN_cores() {
        return n_cores;
    }

    public void setN_cores(Float n_cores) {
        this.n_cores = n_cores;
    }

    public Float getPc() {
        return pc;
    }

    public void setPc(Float pc) {
        this.pc = pc;
    }

    public Integer getTalk_time() {
        return talk_time;
    }

    public void setTalk_time(Integer talk_time) {
        this.talk_time = talk_time;
    }

    public Integer getThree_g() {
        return three_g;
    }

    public void setThree_g(Integer three_g) {
        this.three_g = three_g;
    }

    public Integer getTouch_screen() {
        return touch_screen;
    }

    public void setTouch_screen(Integer touch_screen) {
        this.touch_screen = touch_screen;
    }

    public Integer getWifi() {
        return wifi;
    }

    public void setWifi(Integer wifi) {
        this.wifi = wifi;
    }

    
}
