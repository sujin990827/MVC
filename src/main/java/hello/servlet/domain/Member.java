package hello.servlet.domain;

import lombok.Data;

@Data
public class Member {

	private Long id;
	private String username;
	private int age;

	public Member(String username, int age) {
		this.username = username;
		this.age = age;
	}

	public Member() {
	}

}
