package blog.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class User {
	
	@Id  //id어노테이션이 없으면 오류가 발생한다
	private int id;
	
	private String username;
	
	private String password;
	
	private String email;

	private Timestamp creatDate;

}
