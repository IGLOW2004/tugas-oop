package library;
import java.util.ArrayList;

class Library {
  public ArrayList<Book> books = new ArrayList<Book>();
  public ArrayList<Member> members = new ArrayList<Member>();

  public void addMember(Member member) {
	  if (!isMemberIdExist(member.id)) {
		  this.members.add(member);
	  }
	  else {
		  System.out.println("Data sudah ada");
	  }
  }

  public Boolean isMemberIdExist(String id) {
    Boolean isExist = false;
    for (Member member : this.members) {
      if (member.id.equals(id)) { 
        isExist = true;
      }
    }
    return isExist;
  }
//  menambahkan buku
  public void addBook(Book book) {
//	  agar data tidak diulang maka, pertama kita harus melakukan pengecekan
	  if(!isBookIdExist(book.id)) {
		  this.books.add(book);
	  } else {
		  System.out.println("data Buku Sudah ada");
	  }
	  }

	  public Boolean isBookIdExist(String id) {
	    Boolean isExist = false;
	    for (Book book : this.books) {
	      if (book.id.equals(id)) {
	        isExist = true;
	      }
	    }
	    return isExist;
	  }
//perbaikan agar bisa meminjam buku dan mengembalikan buku
  public void giveBook(String bookId, String memberId) {
    Book book = this.getBookById(bookId);

    Member member = this.getMemberById(memberId);
    int memberIndex = this.getMemberIndex(member);
    this.books.remove(book);
    this.members.get(memberIndex).borrowedBooks.add(book);
  }

  public void receiveBook(String bookId, String memberId) {
	    Member member = this.getMemberById(memberId);
	    int memberIndex = this.getMemberIndex(member);

	    Book book = this.members.get(memberIndex).getBookById(bookId);

	    this.books.add(book);
	    this.members.get(memberIndex).borrowedBooks.remove(book);
	  }

  private int getMemberIndex(Member member) {
    return this.members.indexOf(member);
  }

  private Member getMemberById(String id) {
    for (Member member : this.members) {
      if (member.id.equals(id)) {
        return member;
      }
    }
    return null;
  }

  private Book getBookById(String id) {
    for (Book book : this.books) {
      if (book.id.equals(id)) {
        return book;
      }
    }
    return null;
  }
}