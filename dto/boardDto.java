package dto;

public class boardDto {
	private int bno;
	private String title;	
	private String content;
	private String writer;
	private String Writedate;
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWritedate() {
		return Writedate;
	}
	public void setWritedate(String writedate) {
		Writedate = writedate;
	}
	public boardDto(int bno, String title, String content, String writer, String writedate) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		Writedate = writedate;
	}
	
}
