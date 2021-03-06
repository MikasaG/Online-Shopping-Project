package testmapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mapper.BookMapper;
import pojo.Book;
import util.Page;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:resource/spring-service.xml")
public class TestBookMapper {
	@Autowired
	private BookMapper bookMapper;

	@Test
    public void Testadd() {//pass
		Book b = new Book(1,"book1",10,"intro1");
		bookMapper.add(b);
	}
	@Test
    public void Testdelete() {//pass
		bookMapper.delete(1009);
	}
	@Test
    public void Testupdate() {//pass
		Book b = new Book(1010,"book2",10,"intro2");
		bookMapper.update(b);
	}
	@Test
    public void Testget() {//pass
		List<Book> books =bookMapper.get(1000);
		for (Book b : books) {
			System.out.println(b);
		}
	}
	@Test
    public void TestgetTotal() {//pass
		int a =bookMapper.getTotal();
		System.out.println(a);
	}
	@Test
    public void TestlistAll() {//pass
		List<Book> books = bookMapper.listAll();
		for (Book b : books) {
			System.out.println(b);
		}
	}
	
	@Test
    public void TestlistAll_page(Page page) {//pass
		page.caculateLast(9);
		System.out.println("last isssssssssssssssssssssssss "+page.getLast());
		List<Book> books = bookMapper.listAll(page);
		for (Book b : books) {
			System.out.println(b);
		}
	}
	@Test
    public void TestgetStock() {//pass
		System.out.println("1001 left " + bookMapper.getStock(1001));
	}
	@Test
    public int reduceNumber() {//pass
		return bookMapper.reduceNumber(1001);
	}
}
