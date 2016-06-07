package com.example.retrofitdemo.bean;

/**
 * 获取图书信息参数类
 * @author wangyunlong
 *
 */
public class CGetBookInfoParam  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6558720278753882422L;
	//图书id	
	private int bookid;
	//用户id
	private int userid;
	//最后更新时间
	private int last_update_time;

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getLast_update_time() {
		return last_update_time;
	}

	public void setLast_update_time(int lastUpdateTime) {
		last_update_time = lastUpdateTime;
	}

	@Override
	public String toString() {
		return "{" +
				"bookid:" + bookid +
				", userid:" + userid +
				", last_update_time:" + last_update_time +
				'}';
	}
}
