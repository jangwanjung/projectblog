package blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

import javax.persistence.*;


@Entity
public class Reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String content;
	
	@ManyToOne //여러개의 댓글은 하나의 보드에 있을수있다
	private Board board;
	
	@ManyToOne //여러개의 댓글은 한사람을 쓸수있다
	private User user;

	@CreationTimestamp
	private Timestamp creatDate;
	
}
