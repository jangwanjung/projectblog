package blog.model;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Board {
	
	@Id
	private int id;
	
	private String title;
	
	private String content;
	
	@ManyToOne //한명의 유저가 여러개의 보드를 만들수있다
	private User user;
	
	@OneToMany //하나의보드에는 여러개의 댓글이있을수있다
	private List<Reply> replys;  //OneToMany이면 List를 사용해야한다
	
	private Timestamp creatDate;
	
}
