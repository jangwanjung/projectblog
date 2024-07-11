package blog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

	@JoinColumn(name = "userId")
	@ManyToOne
	private User user;


	@OneToMany(mappedBy = "board")
	@OrderBy("id desc")
	private List<Reply> replys;  //OneToMany이면 List를 사용해야한다

	@CreationTimestamp
	private Timestamp creatDate;

}
