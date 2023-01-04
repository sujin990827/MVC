package hello.springmvc.web.basic;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hello.springmvc.domain.Item;
import hello.springmvc.repository.ItemRepository;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {

	private final ItemRepository itemRepository;

	@GetMapping
	public String items(Model model){
		List<Item> items = itemRepository.findAll();
		model.addAttribute("items", items);
		return "basic/items";
	}

	//테스트용 아이템 추가
	@PostConstruct
	public void init(){
		itemRepository.save(new Item("itemaA", 1000, 10));
		itemRepository.save(new Item("itemaB", 2000, 20));

	}

	//상품 상세
	@GetMapping("/{itemId}")
	public String item(@PathVariable long itemId, Model model){
		Item item = itemRepository.findById(itemId);
		model.addAttribute("item", item);
		return "basic/item";
	}

	@GetMapping("/add")
	public String addForm(){
		return "basic/addForm";
	}

	@PostMapping("/add")
	public String addItemV4(Item item, RedirectAttributes redirectAttributes) {
		Item savedItem = itemRepository.save(item);
		redirectAttributes.addAttribute("itemId", savedItem.getId());
		redirectAttributes.addAttribute("status", true);
		return "redirect:/basic/items/{itemId}";
	}

	//상품 수정 -> 상품 조회랑 비슷
	@GetMapping("/{itemId}/edit")
	public String editForm(@PathVariable Long itemId, Model model){
		Item item = itemRepository.findById(itemId);
		model.addAttribute("item", item);
		return "basic/editForm";
	}

	@PostMapping("/{itemId}/edit")
	public String edit(@PathVariable Long itemId, @ModelAttribute Item item){
		itemRepository.update(itemId,item);
		return "redirect:/basic/items/{itemId}";
	}


}
