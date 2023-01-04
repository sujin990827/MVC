package hello.springmvc.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import hello.springmvc.domain.Item;

class ItemRepositoryTest {

	ItemRepository itemRepository = new ItemRepository();

	@AfterEach
	void afterEach(){
		itemRepository.clearStore();
	}

	@Test
	void save() {
		//given
		Item item = new Item("itemA", 1000, 10);

		//when
		Item save = itemRepository.save(item);

		//then
		Item findItem = itemRepository.findById(item.getId());
		Assertions.assertThat(findItem).isEqualTo(save);

	}

	@Test
	void findAll() {
		//given
		Item item1 = new Item("itemA", 1000, 10);
		Item item2 = new Item("itemB", 2000, 20);

		//when
		Item save1 = itemRepository.save(item1);
		Item save2 = itemRepository.save(item2);

		//then
		List<Item> findAll = itemRepository.findAll();
		Assertions.assertThat(findAll.size()).isEqualTo(2);
		Assertions.assertThat(findAll).contains(item1, item2);
	}

	@Test
	void update() {
		//given
		Item item = new Item("itemA", 1000, 10);
		Item save = itemRepository.save(item);
		Long itemId = save.getId();

		//when
		Item updateItem = new Item("item2", 2000, 20);
		itemRepository.update(itemId, updateItem);

		//then
		Item findItem = itemRepository.findById(itemId);
		Assertions.assertThat(findItem.getItemName()).isEqualTo(updateItem.getItemName());
		Assertions.assertThat(findItem.getPrice()).isEqualTo(updateItem.getPrice());
	}
}