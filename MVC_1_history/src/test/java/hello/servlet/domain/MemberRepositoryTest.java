package hello.servlet.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {

	MemberRepository memberRepository = MemberRepository.getInstance();

	//테스트 하나 끝나면 초기화
	@AfterEach
	void afterEach(){
		memberRepository.clearStore();
	}

	@Test
	void save() {

		//given
		Member member = new Member("hello", 20);

		//when
		Member savedMember = memberRepository.save(member);

		//then
		Member findMember = memberRepository.findById(savedMember.getId());
		Assertions.assertThat(findMember).isEqualTo(savedMember);

	}

	@Test
	void findById() {
		//given
		Member member = new Member("sujin",25);
		memberRepository.save(member);

		//when
		Member findById = memberRepository.findById(member.getId());

		//then
		Assertions.assertThat(findById).isEqualTo(member);
	}

	@Test
	void findAll() {
		//given
		Member member1 = new Member("member1", 20);
		Member member2 = new Member("member2", 24);

		memberRepository.save(member1);
		memberRepository.save(member2);

		//when
		List<Member> result = memberRepository.findAll();

		//then
		Assertions.assertThat(result.size()).isEqualTo(2);

	}

}