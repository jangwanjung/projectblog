package blog.model;

import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Data
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;

	private String content;

	@ManyToOne //한명의 유저가 여러개의 보드를 만들수있다
	private User user;

	@OneToMany //하나의보드에는 여러개의 댓글이있을수있다
	private List<Reply> replys;  //OneToMany이면 List를 사용해야한다

	@CreationTimestamp
	private Timestamp creatDate;

}
