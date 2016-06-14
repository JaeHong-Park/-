package dto;

import java.io.Serializable;
import java.util.Vector;

public class objectDTO implements Serializable {
	
	private int state;
	private String id;
	private String msg;
	private Vector<drawDTO> vc;
	
	/*
	 * state
	 * 0. system message
	 * 1. chat
	 * 2. draw
	 * 3. 술래
	 * 4. 참가자
	 */
	
	public objectDTO() {
		this.state = 0;
		this.id = "";
		this.msg = "";
		this.vc = null;
	}	
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Vector<drawDTO> getVc() {
		return vc;
	}
	public void setVc(Vector<drawDTO> vc) {
		this.vc = vc;
	}	
}
