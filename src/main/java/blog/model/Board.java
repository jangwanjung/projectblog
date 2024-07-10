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
	@ManyToOne //한명의 유저가 여러개의 보드를 만들수있다
	private User user;

	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE) // mappedBy : 연관관계의 주인이 아님(FK가 아님) -> db에 컬럼 만들지 않음
	private List<Reply> replys;  //OneToMany이면 List를 사용해야한다

	@CreationTimestamp
	private Timestamp creatDate;

}
