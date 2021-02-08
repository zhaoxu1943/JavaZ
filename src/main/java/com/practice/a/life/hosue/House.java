package com.practice.a.life.hosue;

import java.util.HashMap;

/**
 * @author zhaoxu
 * @className House
 * @projectName JavaConcentration
 * @date 2021/1/28 14:21
 */

public class House {

    /**
     * 区域,如回龙观,龙域等
     * @author zhaoxu
     */
    private String region;



    /**
     * 小区
     * @author zhaoxu
     */
    private String communityName;

    /**
     * 地铁环境,统计近的地铁,且是否有首发,等信息
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private HashMap<String, Subway> subwayMap;

    /**
     * 地址
     * @author zhaoxu
     */
    private String address;

    /**
     * 小区内部整体环境
     * @author zhaoxu
     */
    private Integer communityInnerEnvironment;


    /**
     * 小区外部整体环境
     * @author zhaoxu
     */
    private Integer communityOutSideEnvironment;



    /**
     * 总楼层数
     * @author zhaoxu
     */
    private Integer totalFloor;

    /**
     * 楼层
     * @author zhaoxu
     */
    private Integer floor;

    /**
     * 是否有电梯
     * @author zhaoxu
     */
    private Integer isElevator;

    /**
     * 是否把边/冷山
     * @author zhaoxu
     */
    private Integer isOnTheSideOrCodeWall;



    /**
     * 户型
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private Integer unitType;

    /**
     * 面积
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private Integer area;

    /**
     * 临街
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private Integer isOnStreet;


    /**
     * 客厅是否可以当卧室
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private Integer isLivingRoomAsBedRoom;



    /**
     * 采光
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private Integer lighting;


    /**
     * 采光
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private Integer schoolQuality;



    /**
     * 装修
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private Integer decoration;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public HashMap<String, Subway> getSubwayMap() {
        return subwayMap;
    }

    public void setSubwayMap(HashMap<String, Subway> subwayMap) {
        this.subwayMap = subwayMap;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCommunityInnerEnvironment() {
        return communityInnerEnvironment;
    }

    public void setCommunityInnerEnvironment(Integer communityInnerEnvironment) {
        this.communityInnerEnvironment = communityInnerEnvironment;
    }

    public Integer getCommunityOutSideEnvironment() {
        return communityOutSideEnvironment;
    }

    public void setCommunityOutSideEnvironment(Integer communityOutSideEnvironment) {
        this.communityOutSideEnvironment = communityOutSideEnvironment;
    }

    public Integer getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(Integer totalFloor) {
        this.totalFloor = totalFloor;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getIsElevator() {
        return isElevator;
    }

    public void setIsElevator(Integer isElevator) {
        this.isElevator = isElevator;
    }

    public Integer getIsOnTheSideOrCodeWall() {
        return isOnTheSideOrCodeWall;
    }

    public void setIsOnTheSideOrCodeWall(Integer isOnTheSideOrCodeWall) {
        this.isOnTheSideOrCodeWall = isOnTheSideOrCodeWall;
    }

    public Integer getUnitType() {
        return unitType;
    }

    public void setUnitType(Integer unitType) {
        this.unitType = unitType;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getIsOnStreet() {
        return isOnStreet;
    }

    public void setIsOnStreet(Integer isOnStreet) {
        this.isOnStreet = isOnStreet;
    }

    public Integer getIsLivingRoomAsBedRoom() {
        return isLivingRoomAsBedRoom;
    }

    public void setIsLivingRoomAsBedRoom(Integer isLivingRoomAsBedRoom) {
        this.isLivingRoomAsBedRoom = isLivingRoomAsBedRoom;
    }

    public Integer getLighting() {
        return lighting;
    }

    public void setLighting(Integer lighting) {
        this.lighting = lighting;
    }

    public Integer getSchoolQuality() {
        return schoolQuality;
    }

    public void setSchoolQuality(Integer schoolQuality) {
        this.schoolQuality = schoolQuality;
    }

    public Integer getDecoration() {
        return decoration;
    }

    public void setDecoration(Integer decoration) {
        this.decoration = decoration;
    }
}
