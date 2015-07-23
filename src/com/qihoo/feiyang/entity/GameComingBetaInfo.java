package com.qihoo.feiyang.entity;

/**
 * 
 * 今日内测游戏实体
 * 
 * @author niangang
 *
 */
public class GameComingBetaInfo {

	private String gNameStr;// 内测游戏名字
	private int gNum; // 游戏下载数量
	private String gSizeStr; // 游戏大小
	private String gInfoStr; // 游戏详情
	private boolean isDown;// 是否下载�?
	private String gIcoUrl;// 游戏图标地址
	private int gIcoUri;

	public int getgIcoUri() {
		return gIcoUri;
	}

	public void setgIcoUri(int gIcoUri) {
		this.gIcoUri = gIcoUri;
	}

	public GameComingBetaInfo() {
		// TODO Auto-generated constructor stub

		this.gNameStr = null;
		this.gNum = 0;
		this.gSizeStr = null;
		this.isDown = false;
		this.gInfoStr = null;
		this.gIcoUrl = null;
	}

	public String getgNameStr() {
		return gNameStr;
	}

	public void setgNameStr(String gNameStr) {
		this.gNameStr = gNameStr;
	}

	public int getgNum() {
		return gNum;
	}

	public void setgNum(int gNum) {
		this.gNum = gNum;
	}

	public String getgSize() {
		return gSizeStr;
	}

	public void setgSize(String gSize) {
		this.gSizeStr = gSize;
	}

	public String getgInfoStr() {
		return gInfoStr;
	}

	public void setgInfoStr(String gInfoStr) {
		this.gInfoStr = gInfoStr;
	}

	public boolean isDown() {
		return isDown;
	}

	public void setDown(boolean isDown) {
		this.isDown = isDown;
	}

	public String getgIcoUrl() {
		return gIcoUrl;
	}

	public void setgIcoUrl(String gIcoUrl) {
		this.gIcoUrl = gIcoUrl;
	}

}
