package com.example.retrofitdemo.bean;

import java.util.List;


/**
 * 展示端作品最基本信息
 * @author linshirong
 *
 */
public class CBaseBookVO  {

	private int book_id;
	private String book_name;
	private String book_img;
	private String book_author;
	private String anchor;
	private String book_owner;
	private int good_num;
	private int play_num;
	private int down_num;
	private int r_rank;
	//评论数
	private int comment_num;
	//收藏数
	private int collection_num;
	private String book_outline;
	private String first_article_path;
	//最后更新时间
	private String last_update_time;
	//作品上架时间
	private String public_time;
	//是否收藏:0=否,1=是
	private int is_favorite;
	//是否购买:0=否,1=是
	private int is_buy;
	//章节数
	private int article_num;
	//内容标签
	private List<String> book_content_tag;
	//频道标签
	private List<String> book_channel_tag;
	//作品状态：10=完本，11=连载
	private int book_status;
	
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_img() {
		return book_img;
	}
	public void setBook_img(String book_img) {
		this.book_img = book_img;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public String getAnchor() {
		return anchor;
	}
	public void setAnchor(String anchor) {
		this.anchor = anchor;
	}
	public String getBook_owner() {
		return book_owner;
	}
	public void setBook_owner(String book_owner) {
		this.book_owner = book_owner;
	}
	public int getGood_num() {
		return good_num;
	}
	public void setGood_num(int good_num) {
		this.good_num = good_num;
	}
	public int getPlay_num() {
		return play_num;
	}
	public void setPlay_num(int play_num) {
		this.play_num = play_num;
	}
	public int getDown_num() {
		return down_num;
	}
	public void setDown_num(int down_num) {
		this.down_num = down_num;
	}
	public int getR_rank() {
		return r_rank;
	}
	public void setR_rank(int r_rank) {
		this.r_rank = r_rank;
	}
	public String getBook_outline() {
		return book_outline;
	}
	public void setBook_outline(String book_outline) {
		this.book_outline = book_outline;
	}
	public String getFirst_article_path() {
		return first_article_path;
	}
	public int getIs_favorite() {
		return is_favorite;
	}
	public void setIs_favorite(int is_favorite) {
		this.is_favorite = is_favorite;
	}
	public List<String> getBook_content_tag() {
		return book_content_tag;
	}
	public void setBook_content_tag(List<String> book_content_tag) {
		this.book_content_tag = book_content_tag;
	}
	public List<String> getBook_channel_tag() {
		return book_channel_tag;
	}
	public void setBook_channel_tag(List<String> book_channel_tag) {
		this.book_channel_tag = book_channel_tag;
	}
	public int getArticle_num() {
		return article_num;
	}
	public void setArticle_num(int article_num) {
		this.article_num = article_num;
	}
	public int getIs_buy() {
		return is_buy;
	}
	public void setIs_buy(int is_buy) {
		this.is_buy = is_buy;
	}
	public String getLast_update_time() {
		return last_update_time;
	}
	public void setLast_update_time(String last_update_time) {
		this.last_update_time = last_update_time;
	}
	public String getPublic_time() {
		return public_time;
	}
	public void setPublic_time(String public_time) {
		this.public_time = public_time;
	}
	public int getComment_num() {
		return comment_num;
	}
	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}
	public int getCollection_num() {
		return collection_num;
	}
	public void setCollection_num(int collection_num) {
		this.collection_num = collection_num;
	}
	public int getBook_status() {
		return book_status;
	}
	public void setBook_status(int book_status) {
		this.book_status = book_status;
	}

	@Override
	public String toString() {
		return "CBaseBookVO{" +
				"book_id=" + book_id +
				", book_name='" + book_name + '\'' +
				", book_img='" + book_img + '\'' +
				", book_author='" + book_author + '\'' +
				", anchor='" + anchor + '\'' +
				", book_owner='" + book_owner + '\'' +
				", good_num=" + good_num +
				", play_num=" + play_num +
				", down_num=" + down_num +
				", r_rank=" + r_rank +
				", comment_num=" + comment_num +
				", collection_num=" + collection_num +
				", book_outline='" + book_outline + '\'' +
				", first_article_path='" + first_article_path + '\'' +
				", last_update_time='" + last_update_time + '\'' +
				", public_time='" + public_time + '\'' +
				", is_favorite=" + is_favorite +
				", is_buy=" + is_buy +
				", article_num=" + article_num +
				", book_content_tag=" + book_content_tag +
				", book_channel_tag=" + book_channel_tag +
				", book_status=" + book_status +
				'}';
	}
}