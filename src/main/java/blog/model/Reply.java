package blog.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Reply {
	
	@Id
	private int id;
	
	private String content;
	
	@ManyToOne //여러개의 댓글은 하나의 보드에 있을수있다
	private Board board;
	
	@ManyToOne //여러개의 댓글은 한사람을 쓸수있다
	private User user;
	
	private Timestamp creatDate;
	
}
