package model;

public class Chat {
	//field
		private int id;
		private String name;
		private String subject;
		private String content;
		//constructors
		public Chat(String name, String subject, String content) {
			super();
			this.name = name;
			this.subject = subject;
			this.content = content;
		}
		public Chat() {
			super();
			// TODO Auto-generated constructor stub
		}
		//setters/getters
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		
		

}
